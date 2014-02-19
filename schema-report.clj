{:global {:fail 46, :success 15},
 :accuracy 0.2459016393442623,
 :per-corpus
 ([:negatives {:success 9, :fail 16}]
  [:forum-leaf-similar-page-pairs {:success 2, :fail 7}]
  [:forum-index-similar-page-pairs {:fail 9}]
  [:blog-leaf-similar-page-pairs {:success 1, :fail 8}]
  [:blog-index-similar-page-pairs {:success 3, :fail 6}])}
{:negatives
 ({:link1 "http://blog.shriphani.com/",
   :link2
   "http://blog.shriphani.com/2013/12/18/robust-principal-component-pursuit-background-matrix-recovery/",
   :expected false,
   :computed true,
   :info 6/13}
  {:link1 "http://rottenindenmark.wordpress.com/",
   :link2
   "http://rottenindenmark.wordpress.com/2012/02/29/what-is-your-boss-buying/",
   :expected false,
   :computed true,
   :info 4/17}
  {:link1 "http://carsandetc.tumblr.com/",
   :link2
   "http://carsandetc.tumblr.com/post/76160507825/chevy-camaro-z-28",
   :expected false,
   :computed false,
   :info 0}
  {:link1 "http://www.adventuresoncehad.com/",
   :link2 "http://www.adventuresoncehad.com/post/76190425016",
   :expected false,
   :computed true,
   :info 4/9}
  {:link1 "http://minimsft.blogspot.com/",
   :link2
   "http://minimsft.blogspot.com/2013/08/steve-ballmer-is-going-to-frickin.html",
   :expected false,
   :computed true,
   :info 7/31}
  {:link1 "http://lifeandartintheup.blogspot.com/",
   :link2
   "http://lifeandartintheup.blogspot.com/2012/03/wind-off-of-breaking-ice-covered-lake.html",
   :expected false,
   :computed false,
   :info 1/13}
  {:link1 "http://paulmullins.wordpress.com/",
   :link2
   "http://paulmullins.wordpress.com/2014/02/08/domesticating-dissent-consuming-johnny-cash/",
   :expected false,
   :computed false,
   :info 1/38}
  {:link1 "http://sportsethicist.com/",
   :link2
   "http://sportsethicist.com/2014/02/05/boycotts-and-the-sochi-olympics/",
   :expected false,
   :computed false,
   :info 4/33}
  {:link1 "http://techcrunch.com/",
   :link2
   "http://techcrunch.com/2014/02/10/inmobi-launches-interactive-video-ad-platform-to-help-advertisers-boost-sales-on-mobile/",
   :expected false,
   :computed true,
   :info 33/92}
  {:link1 "http://www.vbulletin.org/forum/forumdisplay.php?f=263",
   :link2 "http://www.vbulletin.org/forum/showthread.php?t=254967",
   :expected false,
   :computed true,
   :info 7/27}
  {:link1
   "http://forums.finalgear.com/finalgear-meets/finalgear-lemon-party-texas-march-57401/",
   :link2 "http://forums.finalgear.com/the-site-itself/",
   :expected false,
   :computed true,
   :info 13/38}
  {:link1 "http://www.theverge.com/forums",
   :link2
   "http://www.theverge.com/2014/2/6/5387804/looking-for-an-inexpensive-device-with-nfc",
   :expected false,
   :computed true,
   :info 26/41}
  {:link1
   "http://www.12allchat.com/forum/viewtopic.php?f=143&t=120886",
   :link2 "http://www.12allchat.com/forum/viewforum.php?f=143",
   :expected false,
   :computed true,
   :info 5/14}
  {:link1 "http://www.bmwfaq.com/forums/foro-general-bmw.7/",
   :link2
   "http://www.bmwfaq.com/threads/hoy-he-echo-un-60-a-320-km-conometrado-en-8-segundos.787580/",
   :expected false,
   :computed true,
   :info 11/31}
  {:link1 "http://forums.asterisk.org/viewtopic.php?f=38&t=87887",
   :link2 "http://forums.asterisk.org/viewforum.php?f=38&start=50",
   :expected false,
   :computed true,
   :info 2/7}
  {:link1 "http://www.reddit.com/",
   :link2
   "http://www.reddit.com/r/aww/comments/1xitir/my_neighbor_took_a_picture_of_my_dogs_and_it/",
   :expected false,
   :computed false,
   :info 1/22}
  {:link1 "http://blog.shriphani.com/",
   :link2
   "http://blog.shriphani.com/2014/01/11/all-it-took-was-an-aha/",
   :expected false,
   :computed true,
   :info 1/2}
  {:link1 "http://rottenindenmark.wordpress.com/",
   :link2
   "http://rottenindenmark.wordpress.com/2014/02/01/bleg-anyone-been-to-bangladesh/",
   :expected false,
   :computed false,
   :info 7/36}
  {:link1 "http://carsandetc.tumblr.com/",
   :link2
   "http://carsandetc.tumblr.com/post/76473121817/a-stunning-camaro-ss-convertible-sandwiched-in",
   :expected false,
   :computed false,
   :info 0}
  {:link1 "http://www.adventuresoncehad.com/",
   :link2 "http://www.adventuresoncehad.com/post/76340631742",
   :expected false,
   :computed true,
   :info 4/9}
  {:link1 "http://minimsft.blogspot.com/",
   :link2
   "http://minimsft.blogspot.com/2013/08/steve-ballmer-is-going-to-frickin.html",
   :expected false,
   :computed true,
   :info 7/31}
  {:link1 "http://lifeandartintheup.blogspot.com/",
   :link2
   "http://lifeandartintheup.blogspot.com/2012/03/wind-off-of-breaking-ice-covered-lake.html",
   :expected false,
   :computed false,
   :info 1/13}
  {:link1
   "http://paulmullins.wordpress.com/2014/02/08/domesticating-dissent-consuming-johnny-cash/",
   :link2 "http://paulmullins.wordpress.com/",
   :expected false,
   :computed true,
   :info 21/38}
  {:link1 "http://sportsethicist.com/",
   :link2
   "http://sportsethicist.com/2014/02/10/ethics-of-high-school-athletic-transfers/",
   :expected false,
   :computed false,
   :info 1/7}
  {:link1 "http://techcrunch.com/",
   :link2
   "http://techcrunch.com/2014/02/12/white-house-unveils-cybersecurity-plan-for-big-firms-looks-to-silicon-valley-next/",
   :expected false,
   :computed true,
   :info 33/94}),
 :forum-leaf-similar-page-pairs
 ({:link1 "http://www.vbulletin.org/forum/showthread.php?t=254967",
   :link2 "http://www.vbulletin.org/forum/showthread.php?t=295438",
   :expected true,
   :computed false,
   :info 1/10}
  {:link1 "http://www.vbulletin.org/forum/showthread.php?t=285516",
   :link2 "http://www.vbulletin.org/forum/showthread.php?t=295438",
   :expected true,
   :computed true,
   :info 1/4}
  {:link1
   "http://forums.finalgear.com/finalgear-meets/finalgear-lemon-party-texas-march-57401/",
   :link2 "http://forums.finalgear.com/problems/nsfw-subforum-57124/",
   :expected true,
   :computed false,
   :info 1/7}
  {:link1
   "http://www.theverge.com/2014/2/6/5387804/looking-for-an-inexpensive-device-with-nfc",
   :link2
   "http://www.theverge.com/2014/2/6/5386736/has-there-been-any-indication-of-a-north-american-z1-compact",
   :expected true,
   :computed false,
   :info 0}
  {:link1
   "http://www.bmwfaq.com/threads/hoy-he-echo-un-60-a-320-km-conometrado-en-8-segundos.787580/",
   :link2
   "http://www.bmwfaq.com/threads/como-dice-el-anuncio-me-he-comprado-un-polo.786907/",
   :expected true,
   :computed false,
   :info 0}
  {:link1 "http://forum.avantbrowser.com/viewtopic.php?f=9&t=33057",
   :link2 "http://forum.avantbrowser.com/viewtopic.php?f=9&t=32452",
   :expected true,
   :computed false,
   :info 0}
  {:link1
   "http://www.12allchat.com/forum/viewtopic.php?f=143&t=120886",
   :link2
   "http://www.12allchat.com/forum/viewtopic.php?f=143&t=120884",
   :expected true,
   :computed true,
   :info 10/23}
  {:link1 "http://forums.asterisk.org/viewtopic.php?f=38&t=87887",
   :link2 "http://forums.asterisk.org/viewtopic.php?f=38&t=88051",
   :expected true,
   :computed false,
   :info 1/16}
  {:link1
   "http://www.artofproblemsolving.com/Forum/viewtopic.php?f=300&t=573898",
   :link2
   "http://www.artofproblemsolving.com/Forum/viewtopic.php?f=300&t=23215",
   :expected true,
   :computed false,
   :info 1/19}),
 :forum-index-similar-page-pairs
 ({:link1 "http://www.vbulletin.org/forum/forumdisplay.php?f=263",
   :link2 "http://www.vbulletin.org/forum/forumdisplay.php?f=26",
   :expected true,
   :computed false,
   :info 0}
  {:link1 "http://forums.finalgear.com/the-site-itself/",
   :link2 "http://forums.finalgear.com/top-gear-america/",
   :expected true,
   :computed false,
   :info 0}
  {:link1 "http://forums.finalgear.com/fifth-gear/",
   :link2 "http://forums.finalgear.com/top-gear-america/",
   :expected true,
   :computed false,
   :info 1/32}
  {:link1 "http://www.theverge.com/forums",
   :link2 "http://www.theverge.com/forums/all/forum/2",
   :expected true,
   :computed false,
   :info 0}
  {:link1
   "http://www.artofproblemsolving.com/Forum/viewforum.php?f=300&",
   :link2
   "http://www.artofproblemsolving.com/Forum/viewforum.php?f=300&start=40",
   :expected true,
   :computed false,
   :info 0}
  {:link1 "http://forums.asterisk.org/viewforum.php?f=38",
   :link2 "http://forums.asterisk.org/viewforum.php?f=38&start=50",
   :expected true,
   :computed false,
   :info 0}
  {:link1 "http://www.12allchat.com/forum/viewforum.php?f=143",
   :link2
   "http://www.12allchat.com/forum/viewforum.php?f=143&start=75",
   :expected true,
   :computed false,
   :info 0}
  {:link1 "http://forum.avantbrowser.com/viewforum.php?f=9",
   :link2 "http://forum.avantbrowser.com/viewforum.php?f=9&start=120",
   :expected true,
   :computed false,
   :info 0}
  {:link1 "http://www.bmwfaq.com/forums/foro-general-bmw.7/",
   :link2 "http://www.bmwfaq.com/forums/foro-general-bmw.7/page-6",
   :expected true,
   :computed false,
   :info 0}),
 :blog-leaf-similar-page-pairs
 ({:link1
   "http://blog.shriphani.com/2014/01/11/all-it-took-was-an-aha/",
   :link2 "http://blog.shriphani.com/2013/12/26/the-sistine-chapel/",
   :expected true,
   :computed false,
   :info 1/7}
  {:link1
   "http://rottenindenmark.wordpress.com/2014/02/01/bleg-anyone-been-to-bangladesh/",
   :link2
   "http://rottenindenmark.wordpress.com/2014/01/30/five-stories-about-sports-for-people-who-hate-sports/",
   :expected true,
   :computed false,
   :info 3/29}
  {:link1
   "http://carsandetc.tumblr.com/post/76473121817/a-stunning-camaro-ss-convertible-sandwiched-in",
   :link2
   "http://carsandetc.tumblr.com/post/76472905072/chevy-impala-parked-roadside",
   :expected true,
   :computed false,
   :info 0}
  {:link1 "http://www.adventuresoncehad.com/post/76340631742",
   :link2 "http://www.adventuresoncehad.com/post/74869511763",
   :expected true,
   :computed false,
   :info 1/6}
  {:link1
   "http://minimsft.blogspot.com/2013/08/steve-ballmer-is-going-to-frickin.html",
   :link2
   "http://minimsft.blogspot.com/2012/11/a-microsoft-without-sinofsky.html",
   :expected true,
   :computed false,
   :info 1/27}
  {:link1
   "http://lifeandartintheup.blogspot.com/2012/03/wind-off-of-breaking-ice-covered-lake.html",
   :link2
   "http://lifeandartintheup.blogspot.com/2011/09/hey-fall-you-arrived-early-but-since.html",
   :expected true,
   :computed true,
   :info 7/24}
  {:link1
   "http://paulmullins.wordpress.com/2014/02/08/domesticating-dissent-consuming-johnny-cash/",
   :link2
   "http://paulmullins.wordpress.com/2014/01/27/the-final-choice-the-materiality-of-last-meals/",
   :expected true,
   :computed false,
   :info 0}
  {:link1
   "http://sportsethicist.com/2014/02/10/ethics-of-high-school-athletic-transfers/",
   :link2
   "http://sportsethicist.com/2014/02/05/boycotts-and-the-sochi-olympics/",
   :expected true,
   :computed false,
   :info 1/30}
  {:link1
   "http://techcrunch.com/2014/02/12/white-house-unveils-cybersecurity-plan-for-big-firms-looks-to-silicon-valley-next/",
   :link2
   "http://techcrunch.com/2014/02/06/apple-hiring-fitness-physiologists-sleep-experts-on-the-heels-of-recent-iwatch-rumors/?source=gravity",
   :expected true,
   :computed false,
   :info 1/16}),
 :blog-index-similar-page-pairs
 ({:link1 "http://blog.shriphani.com/",
   :link2 "http://blog.shriphani.com/index-2.html",
   :expected true,
   :computed false,
   :info 1/9}
  {:link1 "http://rottenindenmark.wordpress.com/",
   :link2 "http://rottenindenmark.wordpress.com/2012/02/",
   :expected true,
   :computed true,
   :info 3/14}
  {:link1 "http://carsandetc.tumblr.com/",
   :link2 "http://carsandetc.tumblr.com/page/2",
   :expected true,
   :computed false,
   :info 0}
  {:link1 "http://www.adventuresoncehad.com/",
   :link2 "http://www.adventuresoncehad.com/page/2",
   :expected true,
   :computed false,
   :info 1/9}
  {:link1 "http://minimsft.blogspot.com/",
   :link2
   "http://minimsft.blogspot.com/search?updated-max=2011-04-28T07:52:00-07:00&max-results=11",
   :expected true,
   :computed true,
   :info 3/14}
  {:link1 "http://lifeandartintheup.blogspot.com/",
   :link2
   "http://lifeandartintheup.blogspot.com/search?updated-max=2011-09-27T03:07:00-07:00&max-results=7",
   :expected true,
   :computed false,
   :info 0}
  {:link1 "http://paulmullins.wordpress.com/",
   :link2 "http://paulmullins.wordpress.com/page/2/",
   :expected true,
   :computed false,
   :info 0}
  {:link1 "http://sportsethicist.com/",
   :link2 "http://sportsethicist.com/2013/07/",
   :expected true,
   :computed true,
   :info 2/9}
  {:link1 "http://techcrunch.com/",
   :link2 "http://techcrunch.com/page/2/",
   :expected true,
   :computed false,
   :info 3/28})}
