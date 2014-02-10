(ns structural-similarity.xpath-text
  "Compute XPaths to text and use cosine similarity
   as a metric"
  (:require [structural-similarity.utils :as utils]
            [clojure.string :as string])
  (:use [clj-xpath.core :only [$x:node+]]))

(defn node->xpath-component
  "Supplied a node, we produce an xpath component bruh. Make it
   a text-node pls"
  [a-node]
  (let [name  (.getNodeName a-node)
        class (utils/fix-class-attribute
               (utils/node-attr a-node
                                "class"))]
    (if-not class
      name
      (format "%s[contains(@class, '%s')]" name class))))

(defn page-text-xpaths
  "Accepts a html document and produces a
   list of XPaths with the associated text"
  [a-doc]
  (let [xml-document (utils/html->xml a-doc)
        text-nodes   (utils/text-nodes xml-document)]
    (map
     (fn [t]
       (let [nodes-to-root    (drop-last ; last node is named #text
                               (utils/nodes-to-root t))
             xpath-components (concat
                               (map node->xpath-component
                                    nodes-to-root)
                               ["text()"])
             node-text        (.getNodeValue t)]
         [(string/join "/" (cons "/" xpath-components)) node-text]))
     text-nodes)))

