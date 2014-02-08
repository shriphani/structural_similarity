(ns structural-similarity.core-test
  (:require [clojure.java.io :as io]
            [clojure.test :refer :all]
            [me.raynes.fs :as fs]
            [structural-similarity.core :refer :all]
            [structural-similarity.dataset :as dataset])
  (:use [clojure.pprint :only [pprint]]))

(def *algorithms* (keys *algorithms-functions-similarity*))

(defn initialize
  []
  (when-not (fs/exists? dataset/*corpus-file*)
    (dataset/build-dataset)))

(defn write-report
  [report]
  (pprint report (io/writer "resources/report.clj")))

(deftest similarity-test
  (do
    (initialize)
    (let [dataset (dataset/read-dataset)
          report  (reduce
                   (fn [acc algorithm]
                     (merge
                      acc
                      {algorithm
                       (reduce
                        (fn [stuff {name   :name
                                   truth  :similar?
                                   links  :links
                                   corpus :corpus}]
                          (merge
                           stuff
                           {name (map
                                  (fn [[ls docs]]
                                    (let [[l1 l2]     ls
                                          [doc1 doc2] docs]
                                      {:link1     l1
                                       :link2     l2
                                       :expected  truth
                                       :computed  (similar? doc1
                                                            doc2
                                                            algorithm)}))
                                  (map vector links corpus))}))
                        {}
                        dataset)}))
                   {}
                   *algorithms*)]
      (do (write-report report)
          (doall
           (doseq [[algorithm result] report]
             (doseq [[name results] result]
               (doseq [{l1       :link1
                        l2       :link2
                        expected :expected
                        computed :computed}
                       results]
                (is (= expected computed))))))))))

