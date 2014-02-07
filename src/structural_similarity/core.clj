(ns structural-similarity.core
  (:require [clj-http.client :as client]
            [structural-similarity.edit-distance :as tree-edit-distance]))

(defn page-body
  [a-link]
  (try (-> a-link client/get :body)
       (catch Exception e nil)))

(defn similarity
  "Algorithm must be one of:
   :tree-edit-distance"
  [doc1 doc2 algorithm]
  (cond (= algorithm :tree-edit-distance)
        (tree-edit-distance/similarity doc1 doc2)
        
        :else
        (throw
         (UnsupportedOperationException. "Algorithm not implemented"))))

(defn similarity-link
  "For convenience, fetch pages from the specified URIs
   and then compute their similarity using the specified
   algorithm:"
  [link1 link2 algorithm]
  (let [doc1 (page-body link1)
        doc2 (page-body link2)]
    (similarity doc1 doc2 algorithm)))
