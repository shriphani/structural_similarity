(ns structural-similarity.core
  (:require [clj-http.client :as client]
            [structural-similarity.edit-distance :as tree-edit-distance]
            [structural-similarity.schema :as schema]))

(defn page-body
  [a-link]
  (try (-> a-link client/get :body)
       (catch Exception e nil)))

(def *algorithms-functions-similarity*
  {:tree-edit-distance tree-edit-distance/similarity
   :page-schema        schema/similarity})

(def *algorithms-functions-similar?*
  {:tree-edit-distance tree-edit-distance/similar?
   :page-schema        schema/similar?})

(defn similarity
  "Algorithm must be one of:
   :tree-edit-distance"
  [doc1 doc2 algorithm]
  (let [algorithms (set
                    (keys *algorithms-functions-similarity*))]
    (if (some #{algorithm} algorithms)
      ((*algorithms-functions-similarity* algorithm) doc1 doc2)
      (throw
       (UnsupportedOperationException. "Algorithm not implemented")))))

(defn similarity-link
  "For convenience, fetch pages from the specified URIs
   and then compute their similarity using the specified
   algorithm:"
  [link1 link2 algorithm]
  (let [doc1 (page-body link1)
        doc2 (page-body link2)]
    (similarity doc1 doc2 algorithm)))

(defn similar?
  [doc1 doc2 algorithm]
  (let [algorithms (set (keys *algorithms-functions-similar?*))]
    (if (some #{algorithm} algorithms)
      ((*algorithms-functions-similar?* algorithm) doc1 doc2)
      (throw
       (UnsupportedOperationException. "Algorithm not implemented")))))
