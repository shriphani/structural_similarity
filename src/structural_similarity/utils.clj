(ns structural-similarity.utils
  (:require [clj-http.client :as client])
  (:use [clj-xpath.core :only [$x:node+]])
  (:import [org.htmlcleaner HtmlCleaner DomSerializer CleanerProperties]))

(defn page-body
  [a-link]
  (try (-> a-link client/get :body)
       (catch Exception e nil)))

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
