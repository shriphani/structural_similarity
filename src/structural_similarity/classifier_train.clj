(ns structural-similarity.clasifier-train
  "Aux code to assist with the structural similarity
   training set. This will just download a corpus and
   build a training set")

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
