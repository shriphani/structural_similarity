(defproject structural_similarity "0.1.0-SNAPSHOT"
  :description "Routines and experiments for comparing the structural similarity (i.e. are these pages generated using the same template) of HTML documents"
  :url "http://blog.shriphani.com"
  :license {:name "BSD (2) License"
            :url "license.txt"}
  :dependencies [[clj-http "0.7.9"]
                 [clj-ml "0.0.3-SNAPSHOT"]
                 [com.github.kyleburton/clj-xpath "1.4.2"]
                 [enlive "1.1.4"]
                 [me.raynes/fs "1.4.4"]
                 [net.sourceforge.htmlcleaner/htmlcleaner "2.6"]
                 [org.clojure/clojure "1.5.1"]
                 [svm-clj "0.1.3"]]
  :plugins [[lein-gorilla "0.1.2"]])
