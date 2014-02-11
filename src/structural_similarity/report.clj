(ns structural-similarity.report
  "Produce a report of a similarity algorithm on a corpus
   file"
  (:require [clojure.java.io :as io])
  (:use [clojure.pprint :only [pprint]]))

(defn report [similarity-fn dataset]
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
                  :computed  (similarity-fn doc1
                                            doc2)}))
             (map vector links corpus))}))
   {}
   dataset))

(defn analyze-report
  [a-report]
  (let [per-corpus (map
                    (fn [[name ls]]
                      [name (reduce
                             (fn [acc {_ :link1 _' :link2 e :expected c :computed}]
                               (merge-with + acc (if (= e c) {:success 1} {:fail 1})))
                             {}
                             ls)])
                    a-report)

        global     (reduce
                    (fn [acc [name rep]]
                      (merge-with + acc rep))
                    {}
                    per-corpus)]
    {:global global
     :accuracy (double
                (/
                 (:success global)
                 (+ (:success global)
                    (:fail global))))
     :per-corpus per-corpus}))

(defn dump-report
  [similarity-fn dataset]
  (let [rep      (report similarity-fn dataset)
        analysis (analyze-report rep)]
    (with-open [wrtr (io/writer "corpus-report.clj")]
      (do
        (pprint analysis wrtr)
        (pprint rep wrtr)))))

