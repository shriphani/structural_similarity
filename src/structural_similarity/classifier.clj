(ns structural-similarity.classifier
  (:require [clojure.string :as string]
            [structural-similarity.xpath-text :as xpath-text]
            [structural-similarity.utils :as utils])
  (:use [svm.core]))

(defn page-xpaths-intersection-v-union
  [text-xpaths1 text-xpaths2]
  (let [page1-xpaths (set (map first text-xpaths1))
        page2-xpaths (set (map first text-xpaths2))]

    (/ (count
        (clojure.set/intersection page1-xpaths
                                  page2-xpaths))
       (count
        (clojure.set/union page1-xpaths
                           page2-xpaths)))))

(defn same-max-min-xpaths?
  [text-xpaths1 text-xpaths2]
  (let [page-char-count (fn [page-xpaths]
                          (reduce
                           (fn [acc [x cs]]
                             (merge-with +' acc {x (count cs)}))
                           {}
                           page-xpaths))

        page-freqs (fn [page-xpaths]
                     (reduce
                      (fn [acc [x _]]
                        (merge-with +' acc {x 1}))
                      {}
                      page-xpaths))

        page1-xpaths (set (map first text-xpaths1))
        page2-xpaths (set (map first text-xpaths2))
        
        page1-char-counts (page-char-count text-xpaths1)
        page2-char-counts (page-char-count text-xpaths2)
        
        page1-freqs (page-freqs text-xpaths1)
        page2-freqs (page-freqs text-xpaths2)

        page1-avg-len-f (fn [page-xpaths]
                          (map
                           (fn [x]
                             [x (/ (page1-char-counts x)
                                   (page1-freqs x))])
                           page-xpaths))
        
        page2-avg-len-f (fn [page-xpaths]
                          (map
                           (fn [x]
                             [x (/ (page2-char-counts x)
                                   (page2-freqs x))])
                           page-xpaths))

        page1-avg-len (sort-by
                       second
                       (page1-avg-len-f page1-xpaths))
        page2-avg-len (sort-by
                       second
                       (page2-avg-len-f page2-xpaths))

        max-avg-len-xp-same? (= (first
                                 (last page1-avg-len))
                                (first
                                 (last page2-avg-len)))

        min-avg-len-xp-same? (= (first
                                 (first page1-avg-len))
                                (first
                                 (first page2-avg-len)))]
    [min-avg-len-xp-same? max-avg-len-xp-same?]))

(defn avg-link-length
  [a-page]
  (if-not a-page
    0
    (let [anchors (-> a-page
                      utils/html->xml
                      utils/anchor-nodes)]
      (/ (apply
          + (map
             (fn [a]
               (count
                (.getTextContent a)))
             anchors))
         (count anchors)))))

(defn var-link-length
  [a-page]
  (if-not a-page
    0
    (let [anchors (-> a-page
                      utils/html->xml
                      utils/anchor-nodes)
          mean    (/ (apply
                      + (map
                         (fn [a]
                           (count
                            (.getTextContent a)))
                         anchors))
                     (count anchors))

          diffs   (map
                   (fn [a]
                     (Math/pow
                      (- (count
                          (.getTextContent a))
                         mean)
                      2))
                   anchors)]
      
      (/ (apply + diffs)
         (count diffs)))))

(defn avg-text-length
  [a-page]
  (if-not a-page
    0
    (let [texts (-> a-page
                    utils/html->xml
                    utils/text-nodes)]
      (/ (apply
          + (map
             (fn [a]
               (count
                (.getTextContent a)))
             texts))
         (count texts)))))

(defn var-text-length
  [a-page]
  (if-not a-page
    0
    (let [texts (-> a-page
                    utils/html->xml
                    utils/text-nodes)
          mean    (/ (apply
                      + (map
                         (fn [a]
                           (count
                            (.getTextContent a)))
                         texts))
                     (count texts))

          diffs   (map
                   (fn [a]
                     (Math/pow
                      (- (count
                          (.getTextContent a))
                         mean)
                      2))
                   texts)]

      (/ (apply + diffs)
         (count diffs)))))

(def text-xpaths xpath-text/page-text-xpaths)

(defn generate-features
  [page1 page2]
  (let [text-xpaths1 (text-xpaths page1)
        text-xpaths2 (text-xpaths page2)

        intersection-v-union (page-xpaths-intersection-v-union text-xpaths1
                                                               text-xpaths2)

        [same-min same-max] (same-max-min-xpaths? text-xpaths1 text-xpaths2)

        avg-link-length1 (avg-link-length page1)
        avg-link-length2 (avg-link-length page2)

        avg-text-length1 (avg-text-length page1)
        avg-text-length2 (avg-text-length page2)

        var-link-length1 (var-link-length page1)
        var-link-length2 (var-link-length page2)
        
        var-text-length1 (var-text-length page1)
        var-text-length2 (var-text-length page2)]
    
    [(Math/abs
      (- (count text-xpaths1)
         (count text-xpaths2)))
     (double intersection-v-union)
     (if same-min 1 0)
     (if same-max 1 0)
     (Math/abs
      (- (double avg-link-length1)
         (double avg-link-length2)))
     (Math/abs
      (- (double avg-text-length1)
         (double avg-text-length2)))
     (Math/abs
      (- (double var-link-length2)
         (double var-link-length1)))
     (Math/abs
      (- (double var-text-length1)
         (double var-text-length1)))]))

(defn generate-feature-map
  [page1 page2]
  (let [features (generate-features page1 page2)]
    (into {} (map vector
                  (range 1 (+ 1 (count features)))
                  features))))

(defn similar?
  [page1 page2 model]
  (pos? (predict model (generate-feature-map page1 page2))))
