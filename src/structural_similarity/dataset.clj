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
    ["http://rottenindenmark.wordpress.com/" "http://rottenindenmark.wordpress.com/2012/02/"]
    ["http://carsandetc.tumblr.com/" "http://carsandetc.tumblr.com/page/2"]
    ["http://www.adventuresoncehad.com/" "http://www.adventuresoncehad.com/page/2"]
    ["http://minimsft.blogspot.com/" "http://minimsft.blogspot.com/search?updated-max=2011-04-28T07:52:00-07:00&max-results=11"]
    ["http://lifeandartintheup.blogspot.com/" "http://lifeandartintheup.blogspot.com/search?updated-max=2011-09-27T03:07:00-07:00&max-results=7"]
    ["http://paulmullins.wordpress.com/" "http://paulmullins.wordpress.com/page/2/"]
    ["http://sportsethicist.com/" "http://sportsethicist.com/2013/07/"]
    ["http://techcrunch.com/" "http://techcrunch.com/page/2/"]]})

(def *blog-leaf-similar-page-pairs*
  {:name :blog-leaf-similar-page-pairs
   :similar? true
   :links
   [["http://blog.shriphani.com/2014/01/11/all-it-took-was-an-aha/" "http://blog.shriphani.com/2013/12/26/the-sistine-chapel/"]
    ["http://rottenindenmark.wordpress.com/2014/02/01/bleg-anyone-been-to-bangladesh/" "http://rottenindenmark.wordpress.com/2014/01/30/five-stories-about-sports-for-people-who-hate-sports/"]
    ["http://carsandetc.tumblr.com/post/76473121817/a-stunning-camaro-ss-convertible-sandwiched-in" "http://carsandetc.tumblr.com/post/76472905072/chevy-impala-parked-roadside"]
    ["http://www.adventuresoncehad.com/post/76340631742" "http://www.adventuresoncehad.com/post/74869511763"]
    ["http://minimsft.blogspot.com/2013/08/steve-ballmer-is-going-to-frickin.html" "http://minimsft.blogspot.com/2012/11/a-microsoft-without-sinofsky.html"]
    ["http://lifeandartintheup.blogspot.com/2012/03/wind-off-of-breaking-ice-covered-lake.html" "http://lifeandartintheup.blogspot.com/2011/09/hey-fall-you-arrived-early-but-since.html"]
    ["http://paulmullins.wordpress.com/2014/02/08/domesticating-dissent-consuming-johnny-cash/" "http://paulmullins.wordpress.com/2014/01/27/the-final-choice-the-materiality-of-last-meals/"]
    ["http://sportsethicist.com/2014/02/10/ethics-of-high-school-athletic-transfers/" "http://sportsethicist.com/2014/02/05/boycotts-and-the-sochi-olympics/"]
    ["http://techcrunch.com/2014/02/12/white-house-unveils-cybersecurity-plan-for-big-firms-looks-to-silicon-valley-next/" "http://techcrunch.com/2014/02/06/apple-hiring-fitness-physiologists-sleep-experts-on-the-heels-of-recent-iwatch-rumors/?source=gravity"]]})

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
     "http://www.theverge.com/forums/all/forum/2"]
    ["http://www.artofproblemsolving.com/Forum/viewforum.php?f=300&" "http://www.artofproblemsolving.com/Forum/viewforum.php?f=300&start=40"]
    ["http://forums.asterisk.org/viewforum.php?f=38" "http://forums.asterisk.org/viewforum.php?f=38&start=50"]
    ["http://www.12allchat.com/forum/viewforum.php?f=143" "http://www.12allchat.com/forum/viewforum.php?f=143&start=75"]
    ["http://forum.avantbrowser.com/viewforum.php?f=9" "http://forum.avantbrowser.com/viewforum.php?f=9&start=120"]
    ["http://www.bmwfaq.com/forums/foro-general-bmw.7/" "http://www.bmwfaq.com/forums/foro-general-bmw.7/page-6"]]})

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
     "http://www.theverge.com/2014/2/6/5386736/has-there-been-any-indication-of-a-north-american-z1-compact"]
    ["http://www.bmwfaq.com/threads/hoy-he-echo-un-60-a-320-km-conometrado-en-8-segundos.787580/" "http://www.bmwfaq.com/threads/como-dice-el-anuncio-me-he-comprado-un-polo.786907/"]
    ["http://forum.avantbrowser.com/viewtopic.php?f=9&t=33057" "http://forum.avantbrowser.com/viewtopic.php?f=9&t=32452"]
    ["http://www.12allchat.com/forum/viewtopic.php?f=143&t=120886" "http://www.12allchat.com/forum/viewtopic.php?f=143&t=120884"]
    ["http://forums.asterisk.org/viewtopic.php?f=38&t=87887" "http://forums.asterisk.org/viewtopic.php?f=38&t=88051"]
    ["http://www.artofproblemsolving.com/Forum/viewtopic.php?f=300&t=573898" "http://www.artofproblemsolving.com/Forum/viewtopic.php?f=300&t=23215"]]})

(def *negatives*
  {:name     :negatives
   :similar? false
   :links
   [["http://blog.shriphani.com/" "http://blog.shriphani.com/2013/12/18/robust-principal-component-pursuit-background-matrix-recovery/"]
    ["http://rottenindenmark.wordpress.com/" "http://rottenindenmark.wordpress.com/2012/02/29/what-is-your-boss-buying/"]
    ["http://carsandetc.tumblr.com/" "http://carsandetc.tumblr.com/post/76160507825/chevy-camaro-z-28"]
    ["http://www.adventuresoncehad.com/" "http://www.adventuresoncehad.com/post/76190425016"]
    ["http://minimsft.blogspot.com/" "http://minimsft.blogspot.com/2013/08/steve-ballmer-is-going-to-frickin.html"]
    ["http://lifeandartintheup.blogspot.com/" "http://lifeandartintheup.blogspot.com/2012/03/wind-off-of-breaking-ice-covered-lake.html"]
    ["http://paulmullins.wordpress.com/" "http://paulmullins.wordpress.com/2014/02/08/domesticating-dissent-consuming-johnny-cash/"]
    ["http://sportsethicist.com/" "http://sportsethicist.com/2014/02/05/boycotts-and-the-sochi-olympics/"]
    ["http://techcrunch.com/" "http://techcrunch.com/2014/02/10/inmobi-launches-interactive-video-ad-platform-to-help-advertisers-boost-sales-on-mobile/"]
    ["http://www.vbulletin.org/forum/forumdisplay.php?f=263" "http://www.vbulletin.org/forum/showthread.php?t=254967"]
    ["http://forums.finalgear.com/finalgear-meets/finalgear-lemon-party-texas-march-57401/" "http://forums.finalgear.com/the-site-itself/"]
    ["http://www.theverge.com/forums" "http://www.theverge.com/2014/2/6/5387804/looking-for-an-inexpensive-device-with-nfc"]
    ["http://www.12allchat.com/forum/viewtopic.php?f=143&t=120886" "http://www.12allchat.com/forum/viewforum.php?f=143"]
    ["http://www.bmwfaq.com/forums/foro-general-bmw.7/" "http://www.bmwfaq.com/threads/hoy-he-echo-un-60-a-320-km-conometrado-en-8-segundos.787580/"]
    ["http://forums.asterisk.org/viewtopic.php?f=38&t=87887" "http://forums.asterisk.org/viewforum.php?f=38&start=50"]
    ["http://www.reddit.com/" "http://www.reddit.com/r/aww/comments/1xitir/my_neighbor_took_a_picture_of_my_dogs_and_it/"]]})

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
     *forum-leaf-similar-page-pairs*
     *negatives*])
   (io/writer *corpus-file*)))

(defn read-dataset
  []
  (let [rdr (-> *corpus-file*
                io/reader
                PushbackReader.)]
    (read rdr)))
