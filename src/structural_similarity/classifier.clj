(ns structural-similarity.classifier
  (:require [structural-similarity.xpath-text :as xpath-text]))

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
                        (merge-with +' acc {x 1})))
                     {}
                     page-xpaths)
        
        page1-char-counts (page-char-count page1-xpaths)
        page2-char-counts (page-char-count page2-xpaths)
        
        page1-freqs (page-freqs page1-xpaths)
        page2-freqs (page-freqs page2-xpaths)

        page-avg-len (fn [page-xpaths]
                      (map
                       (fn [x]
                         [x (/ (page1-char-counts x)
                               (page1-freqs x))])
                       page-xpaths))

        page1-avg-len (sort-by
                       second
                       (page-avg-len page1-xpaths))
        page2-avg-len (sort-by
                       second
                       (page-avg-len page2-xpaths))

        max-avg-len-xp-same? (= (first
                                 (last page1-avg-len))
                                (first
                                 (last page2-avg-len)))

        min-avg-len-xp-same? (= (first
                                 (first page1-avg-len))
                                (first
                                 (first page2-avg-len)))]
    [min-avg-len-xp-same? max-avg-len-xp-same?]))

(defn generate-features
  [page1 page2]
  (let [text-xpaths1 (xpath-text/page-text-xpaths page1)
        text-xpaths2 (xpath-text/page-text-xpaths page2)

        intersection-v-union (page-xpaths-intersection-v-union text-xpaths1
                                                               text-xpaths2)

        [same-min same-max] (same-max-min-xpaths? text-xpaths1 text-xpaths2)]
    [(count text-xpaths1)
     (count text-xpaths2)
     intersection-v-union
     same-min
     same-max]))
