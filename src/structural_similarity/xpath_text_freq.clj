(ns structural-similarity.xpath-text-freq
  (:require [structural-similarity.xpath-text :as xpath-text]
            [structural-similarity.utils :as utils]))

(def *sim-thresh* 0.58)

(defn char-count-freq-representation
  [text-xpaths-coll]
  (reduce
   (fn [acc [x text]]
     (merge-with +' acc {(str "f-" x) 1}))
   {}
   text-xpaths-coll))

(defn representation
  [a-page]
  (let [page-text (xpath-text/page-text-xpaths a-page)
        char-repr (xpath-text/char-frequency-representation page-text)
        freq-repr (char-count-freq-representation page-text)]
    (merge char-repr freq-repr)))

(defn similarity
  [doc1 doc2]
  (let [r1 (representation doc1)
        r2 (representation doc2)]
    (utils/cosine-similarity r1 r2)))

(defn similar?
  [doc1 doc2]
  (<= *sim-thresh* (similarity doc1 doc2)))
