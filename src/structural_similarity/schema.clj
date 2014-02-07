(ns structural-similarity.schema
  "Similarity implementation of a web-page
   based on Crescenzi et. al, Data Knowledge and Engineering
   2005"
  (:require [clojure.set :as clj-set])
  (:use [clj-xpath.core :only [$x:node+]])
  (:import [org.htmlcleaner HtmlCleaner DomSerializer CleanerProperties]))

(def *sim-thresh* 0.2)

(defn html->xml
  "A html document is converted to an XML object"
  [a-html-doc]
  (let [cleaner (new HtmlCleaner)
        
        cleaner-props (new CleanerProperties)
        dom-srlzr     (new DomSerializer cleaner-props)
        
        cleaned-doc   (.clean cleaner a-html-doc)]
    
    (.createDOM dom-srlzr cleaned-doc)))

(defn anchor-nodes
  [a-node]
  (try ($x:node+ ".//a" a-node)
       (catch RuntimeException e [])))

(defn nodes-to-root
  [a-node]
  (drop
   1 ; we are dropping the first ele since it is not html
   (reverse
    (take-while identity
                (iterate
                 (fn [x]
                   (.getParentNode x))
                 a-node)))))

(defn path-to-root
  [a-node]
  (let [nodes (nodes-to-root a-node)]
    (map #(.getNodeName %) nodes)))

(defn page-schema
  [a-webpage]
  (let [page-xml (html->xml a-webpage)
        anchors  (anchor-nodes page-xml)]
    (map path-to-root anchors)))

(defn schema-similarity
  [schema1 schema2]
  (let [g1-only (clj-set/difference schema1 schema2)
        g2-only (clj-set/difference schema1 schema2)

        g1-u-g2 (clj-set/union schema1 schema2)]
    
    (/ (count (clj-set/union g1-only g2-only))
       (count g1-u-g2))))

(defn similarity
  [doc1 doc2]
  (let [schema1 (set
                 (page-schema doc1))
        schema2 (set
                 (page-schema doc2))]
    (schema-similarity schema1 schema2)))

(defn similar?
  [doc1 doc2]
  (<= *sim-thresh*
      (similarity doc1 doc2)))
