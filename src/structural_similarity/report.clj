(ns structural-similarity.report
  "Produce a report of a similarity algorithm on a corpus
   file")

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
  (map
   (fn [[name ls]]
     (reduce
      (fn [acc {_ :link1 _' :link2 e :expected c :computed}]
        (merge-with + acc (if (= e c) {:success 1} {:fail 1})))
      {}
      ls))
   a-report))

