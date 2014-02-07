(defproject structural_similarity "0.1.0-SNAPSHOT"
  :description "Routines and experiments for comparing the structural similarity (i.e. are these pages generated using the same template) of HTML documents"
  :url "http://blog.shriphani.com"
  :license {:name "BSD (2) License"
            :url "license.txt"}
  :dependencies [[clj-http "0.7.9"]
                 [enlive "1.1.4"]
                 [me.raynes/fs "1.4.4"]
                 [org.clojure/clojure "1.5.1"]])
