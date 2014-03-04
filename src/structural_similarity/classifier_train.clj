(ns structural-similarity.classifier-train
  "Aux code to assist with the structural similarity
   training set. This will just download a corpus and
   build a training set"
  (:require [clj-http.client :as client]
            [structural-similarity.classifier :as classifier])
  (:use [svm.core]))

(def *downloaded* (atom {}))

(def *forum* [["http://forum.zwame.pt/forumdisplay.php?f=34" "http://forum.zwame.pt/showthread.php?t=660406&page=2" true]
              ["http://www.advrider.com/forums/forumdisplay.php?f=2" "http://www.advrider.com/forums/forumdisplay.php?f=2&order=desc&page=2" true]
              ["http://forums.di.fm/general-help-and-support/" "http://forums.di.fm/the-dj-booth/index2.html" true]
              ["http://photography-on-the.net/forum/forumdisplay.php?f=26" "http://photography-on-the.net/forum/forumdisplay.php?f=26&order=desc&page=2" true]
              ["http://photography-on-the.net/forum/forumdisplay.php?f=15" "http://photography-on-the.net/forum/forumdisplay.php?f=15&order=desc&page=4" true]
              ["http://ubuntuforums.org/forumdisplay.php?f=336" "http://ubuntuforums.org/forumdisplay.php?f=336&page=51" true]
              ["http://www.cableforum.co.uk/board/12/" "http://www.cableforum.co.uk/board/12/page-2.html" true]
              ["http://www.planet3dnow.de/vbulletin/forumdisplay.php/10-Grafikkarten" "http://www.planet3dnow.de/vbulletin/forumdisplay.php/10-Grafikkarten/page51" true]
              ["http://www.narutomania.com/forumdisplay.php?15-General-Discussion-amp-News" "http://www.narutomania.com/forumdisplay.php?15-General-Discussion-amp-News/page51" true]
              ["http://www.webkinzinsider.com/forum/wi-rules-suggestions-131/" "http://www.webkinzinsider.com/forum/wi-rules-suggestions-131/index3.html" true]
              ["http://www.arizonasportsfans.com/vb/f20/" "http://www.arizonasportsfans.com/vb/f20/index11.html" true]
              ["http://www.ultimate-guitar.com/forum/forumdisplay.php?f=11" "http://www.ultimate-guitar.com/forum/forumdisplay.php?f=11&page=5&sort=lastpost&order=&pp=35&daysprune=10" true]
              
              ["http://forum.zwame.pt/showthread.php?t=87928" "http://forum.zwame.pt/forumdisplay.php?f=34" false]
              ["http://www.advrider.com/forums/forumdisplay.php?f=2" "http://www.advrider.com/forums/showthread.php?t=781893" false]
              ["http://forums.di.fm/general-help-and-support/" "http://forums.di.fm/general-help-and-support/progressive-abstract-space-022-february-2014-peter-meatman-312410/" false]
              ["http://photography-on-the.net/forum/showthread.php?t=1275976" "http://photography-on-the.net/forum/forumdisplay.php?f=26" false]
              ["http://ubuntuforums.org/showthread.php?t=2178873" "http://ubuntuforums.org/forumdisplay.php?f=336" false]
              ["http://www.cableforum.co.uk/board/12/" "http://www.cableforum.co.uk/board/12/33656965-beginners-guide-testing-improving-connection-speeds.html" false]
              ["http://www.planet3dnow.de/vbulletin/forumdisplay.php/10-Grafikkarten" "http://www.planet3dnow.de/vbulletin/showthread.php/214472-***Der-ultimative-Grafikkarten-Bilder-Thread***" false]
              ["http://www.narutomania.com/showthread.php?102043-Hunting-for-Microsoft-IME" "http://www.narutomania.com/forumdisplay.php?15-General-Discussion-amp-News" false]
              ["http://www.webkinzinsider.com/forum/wi-rules-suggestions-131/how-make-good-posts-become-gifted-327735/" "http://www.webkinzinsider.com/forum/wi-rules-suggestions-131/index3.html" false]
              ["http://www.arizonasportsfans.com/vb/f20/anyone-have-a-vizio-e500-a1-a-204456.html" "http://www.arizonasportsfans.com/vb/f20/" false]
              ["http://www.ultimate-guitar.com/forum/showthread.php?t=1632191" "http://www.ultimate-guitar.com/forum/forumdisplay.php?f=11" false]])

(def *blog* [["https://rottenindenmark.wordpress.com/" "https://rottenindenmark.wordpress.com/category/america-2/" true]
             ["http://tressiemc.com/" "http://tressiemc.com/page/3/" true]
             ["http://busymockingbird.com/" "http://busymockingbird.com/page/2/" true]
             ["http://jonnegroni.com/" "http://jonnegroni.com/page/2/" true]
             ["http://ptsdandcombat.com/" "http://ptsdandcombat.com/page/2/" true]
             ["https://wronghands1.wordpress.com/" "https://wronghands1.wordpress.com/2013/05/" true]
             ["http://blog.quintinlake.com/" "http://blog.quintinlake.com/page/2/" true]
             ["http://simonkindt.com/" "http://simonkindt.com/page/4/" true]
             ["http://howthelightgetsinblog.com/" "http://howthelightgetsinblog.com/page/2/" true]
             ["http://jonsanwell.com/blog/" "http://jonsanwell.com/blog/page/2/" true]
             ["http://gendermom.wordpress.com/page/2/" "http://gendermom.wordpress.com/" true]

             ["https://rottenindenmark.wordpress.com/" "https://rottenindenmark.wordpress.com/2014/02/13/how-to-write-about-tax-havens/" false]
             ["http://tressiemc.com/2014/02/24/rationalization-of-higher-education-working-draft/" "http://tressiemc.com/" false]
             ["http://busymockingbird.com/" "http://busymockingbird.com/2014/02/18/okeeffe-and-the-dinosaurs/" false]
             ["http://jonnegroni.com/" "http://jonnegroni.com/2014/02/24/the-true-identity-of-andys-mom-in-toy-story-will-blow-your-mind/" false]
             ["http://ptsdandcombat.com/" "http://ptsdandcombat.com/2014/02/13/therapeutic-war-stories-an-introduction/" false]
             ["https://wronghands1.wordpress.com/" "https://wronghands1.wordpress.com/2014/02/21/phoney-dependency/" false]
             ["http://blog.quintinlake.com/2012/12/30/2012-in-30-pictures/" "http://blog.quintinlake.com/" false]
             ["http://simonkindt.com/2014/01/10/falling-back-after-cai-guo-quiang/" "http://simonkindt.com/" false]
             ["http://howthelightgetsinblog.com/2013/09/22/new-hope-for-smile-sufferers/" "http://howthelightgetsinblog.com/" false]
             ["http://jonsanwell.com/blog/" "http://jonsanwell.com/2014/02/24/bangkok-leftovers/" false]
             ["http://gendermom.wordpress.com/page/2/" "http://gendermom.wordpress.com/2013/10/02/f-you-jerry-springer/" false]])

(defn download-and-cache
  [a-link]
  (or (@*downloaded* a-link)
      (let [bd (-> a-link client/get :body)]
        (do (swap! *downloaded* merge {a-link bd})
            bd))))

(defn download-and-build-data
  [filename]
  (with-open [wrtr (clojure.java.io/writer filename)]
    (binding [*out* wrtr]
     (doseq [[l1 l2 label] (concat *forum* *blog*)]
       (let [b1 (download-and-cache l1)
             b2 (download-and-cache l2)
             l  (if label 1 -1)
             fs
             (let [features (classifier/generate-features b1 b2)]
               (map vector (range 1 (+ 1 (count features))) features))]
         (println (str l " " (clojure.string/join " " (map (fn [[i x]] (str i ":" x)) fs)))))))))

(defn train
  [training-file dump-filename]
  (let [dataset (read-dataset training-file)
        model (train-model dataset)]
    (write-model model dump-filename)))
