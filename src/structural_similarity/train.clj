(ns structural-similarity.train
  "Training set for determining threshold value"
  (:require [clj-http.client :as client]
            [clojure.java.io :as io])
  (:use [clojure.pprint :only [pprint]])
  (:import [java.io PushbackReader]))

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
                          "http://www.simplemachines.org/community/index.php?topic=506649.0"
                          "http://www.simplemachines.org/community/index.php?topic=517205.0"
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
                          "http://www.reddit.com/r/formula1/"
                          "http://www.fmylife.com/"
                          "http://www.fmylife.com/miscellaneous/21056193"
                          "http://stackoverflow.com/"
                          "http://stackoverflow.com/questions/21685316/change-the-color-of-a-label-border-back-to-normal"])

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

(defn load-corpus
  []
  (let [rdr   (PushbackReader.
               (io/reader "training_corpus.clj"))
        [p n] (take-while
               identity
               (repeatedly
                #(try (read rdr)
                      (catch Exception e nil))))]
    [(partition 2 2 p)
     (partition 2 2 n)]))

(defn test-example
  [similarity-fn doc-pair thresh]
  (let [[doc1 doc2] doc-pair]
    (<= thresh (similarity-fn (:body doc1) (:body doc2)))))

(defn test-examples
  [similarity-fn positives negatives]
  (reverse
   (sort-by
    second
    (map
     (fn [thresh]
       (let [positive-tests (count
                             (filter
                              identity
                              (map
                               (fn [an-example]
                                 (test-example similarity-fn an-example thresh))
                               positives)))

             negative-tests (count
                             (filter
                              #(not %)
                              (map
                               (fn [an-example]
                                 (test-example similarity-fn an-example thresh))
                               negatives)))]
         [thresh (double
                  (/ (+ positive-tests negative-tests)
                     (+ (count positives)
                        (count negatives))))]))
     (range 0 1 0.01)))))
