(ns structural-similarity.core-test
  (:require [clojure.test :refer :all]
            [me.raynes.fs :as fs]
            [structural-similarity.core :refer :all]
            [structural-similarity.dataset :as dataset]))

(def *algorithms* (keys *algorithms-functions-similarity*))

(defn initialize
  []
  (when-not (fs/exists? dataset/*corpus-file*)
    (dataset/build-dataset)))

(deftest similarity-test
  (do
    (initialize)
    (let [dataset (dataset/read-dataset)]
      (doall
       (doseq [{name   :name
                truth  :similar?
                links  :links
                corpus :corpus}
               dataset]
         
         (print
          (map
           (fn [[ls docs]]
             (let [[l1   l2]   ls
                   [doc1 doc2] docs]
               (map
                (fn [algorithm]
                  (let [computed (similar? doc1 doc2 algorithm)]
                   (println :link1    l1
                            :link2    l2
                            :true-sim truth
                            :computed computed)
                   (is (= truth computed))))
                *algorithms*)))
           (map vector links corpus))))))))

