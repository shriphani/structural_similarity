(ns structural-similarity.decision-tree
  (:require [structural-similarity.xpath-text :as xpath-text]
            [structural-similarity.edit-distance :as edit-distance])
  (:use [clj-ml.classifiers]
        [clj-ml.data]
        [clj-ml.io]
        [clj-ml.utils]))

(defn generate-features
  [doc1 doc2]
  (let [sim1 (xpath-text/similarity-cosine-char-freq doc1 doc2)
        sim2 (edit-distance/similarity doc1 doc2)]
    [sim1 sim2]))

(defn similar-classifier?
  [classifier ds doc1 doc2]
  (let [[sim1 sim2] (generate-features doc1 doc2)
        to-label (make-instance ds {:X sim1, :E sim2, :label 0})
        res      (do (classifier-classify classifier to-label)
                     (.toString
                      (classifier-label classifier to-label)))]
    (Integer/parseInt
     (last
      (clojure.string/split res #",")))))

(def classifier (deserialize-from-file "dtree.bin"))
(def ds (load-instances
         :arff
         (str "file://" (System/getProperty "user.dir") "/" "decision_tree.arff")))
(dataset-set-class ds 2)
(defn similar?
  [doc1 doc2]
  (similar-classifier? classifier ds doc1 doc2))

