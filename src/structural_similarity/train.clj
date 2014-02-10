(ns structural-similarity.train
  "Training set for determining threshold value"
  (:require [clj-http.client :as client]
            [clojure.java.io :as io])
  (:use [clojure.pprint :only [pprint]]))

;; positive examples: similar documents follow each other
(def *positive-examples* ["http://www.vbulletin.org/forum/forumdisplay.php?f=262"
                          "http://www.vbulletin.org/forum/forumdisplay.php?f=264"
                          "http://www.reddit.com/"
                          "http://www.reddit.com/?count=25&after=t3_1xfyi0"
                          "http://www.reddit.com/r/manga/comments/1xhx6n/can_someone_tell_me_where_this_is_from/"
                          "http://www.reddit.com/r/compsci/comments/1xidk0/are_trace_semantics_and_completed_trace_semantics/"
                          "http://www.phpbb.com/community/viewforum.php?f=14"
                          "http://www.phpbb.com/community/viewforum.php?f=46"
                          "http://www.phpbb.com/community/viewtopic.php?f=65&t=2226331"
                          "http://www.phpbb.com/community/viewtopic.php?f=65&t=1494875"
                          "https://news.ycombinator.com/news"
                          "https://news.ycombinator.com/x?fnid=sGdG4aNROGuVUqXl3nZRvT"
                          "https://news.ycombinator.com/item?id=7209384"
                          "https://news.ycombinator.com/item?id=7206572"])

(def *negative-examples* ["http://carsandetc.tumblr.com/"
                          "http://carsandetc.tumblr.com/post/76160507825/chevy-camaro-z-28"
                          "http://www.theverge.com/"
                          "http://www.theverge.com/2014/2/10/5397442/americans-are-finally-switching-over-to-chip-and-pin-credit-cards"
                          "http://www.vbulletin.org/forum/forumdisplay.php?f=2"
                          "http://www.vbulletin.org/forum/showthread.php?t=254967"
                          "http://www.phpbb.com/community/viewforum.php?f=451"
                          "http://www.phpbb.com/community/viewtopic.php?f=461&t=2211266"
                          "http://www.reddit.com/r/formula1/comments/1xioi8/bbc_got_rid_of_garry_anderson/"
                          "http://www.reddit.com/r/formula1/"])

(defn download-corpus
  []
  (let [positives
        (map
         (fn [l]
           {:url  l
            :body (-> l client/get :body)})
         *positive-examples*)

        negatives
        (map
         (fn [l]
           {:url  l
            :body (-> l client/get :body)})
         *negative-examples*)]
    (do
      (pprint positives (io/writer "training_corpus.clj" :append true))
      (pprint negatives (io/writer "training_corpus.clj" :append true)))))
