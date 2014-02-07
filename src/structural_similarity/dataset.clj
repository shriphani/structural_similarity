(ns structural-similarity.dataset
  "Generate a dataset by downloading the webpage"
  (:require [clj-http.client :as client]
            [clojure.java.io :as io])
  (:use [clojure.pprint :only [pprint]])
  (:import [java.io PushbackReader]))

(def *corpus-file* "resources/corpus.clj")

(def *blog-index-similar-page-pairs*
  {:name     :blog-index-similar-page-pairs
   :similar? true
   :links
   [["http://blog.shriphani.com/" "http://blog.shriphani.com/index-2.html"]
    ["https://rottenindenmark.wordpress.com/" "https://rottenindenmark.wordpress.com/2012/02/"]
    ["http://carsandetc.tumblr.com/" "http://carsandetc.tumblr.com/page/2"]
    ["http://www.adventuresoncehad.com/" "http://www.adventuresoncehad.com/page/2"]]})

(def *forum-index-similar-page-pairs*
  {:name     :forum-index-similar-page-pairs
   :similar? true
   :links
   [["http://www.vbulletin.org/forum/forumdisplay.php?f=263"
     "http://www.vbulletin.org/forum/forumdisplay.php?f=26"]
    ["http://forums.finalgear.com/the-site-itself/"
     "http://forums.finalgear.com/top-gear-america/"]
    ["http://forums.finalgear.com/fifth-gear/"
     "http://forums.finalgear.com/top-gear-america/"]
    ["http://www.theverge.com/forums"
     "http://www.theverge.com/forums/all/forum/2"]]})

(def *forum-leaf-similar-page-pairs*
  {:name     :forum-leaf-similar-page-pairs
   :similar? true
   :links
   [["http://www.vbulletin.org/forum/showthread.php?t=254967"
     "http://www.vbulletin.org/forum/showthread.php?t=295438"]
    ["http://www.vbulletin.org/forum/showthread.php?t=285516"
     "http://www.vbulletin.org/forum/showthread.php?t=295438"]
    ["http://forums.finalgear.com/finalgear-meets/finalgear-lemon-party-texas-march-57401/"
     "http://forums.finalgear.com/problems/nsfw-subforum-57124/"]
    ["http://www.theverge.com/2014/2/6/5387804/looking-for-an-inexpensive-device-with-nfc"
     "http://www.theverge.com/2014/2/6/5386736/has-there-been-any-indication-of-a-north-american-z1-compact"]]})

(defn build-dataset-aux
  [a-dataset]
  (merge
   a-dataset
   {:corpus
    (map
     (fn [[l1 l2]]
       [(-> l1 client/get :body)
        (-> l2 client/get :body)])
     (:links a-dataset))}))

(defn build-dataset
  []
  (pprint
   (map
    build-dataset-aux
    [*blog-index-similar-page-pairs*
     *forum-index-similar-page-pairs*
     *forum-leaf-similar-page-pairs*])
   (io/writer *corpus-file*)))

(defn read-dataset
  []
  (let [rdr (-> *corpus-file*
                io/reader
                PushbackReader.)]
    (read rdr)))
