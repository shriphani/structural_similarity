{:global {:fail 16, :success 45},
 :accuracy 0.7377049180327869,
 :per-corpus
 ([:negatives {:success 25}]
  [:forum-leaf-similar-page-pairs {:success 2, :fail 7}]
  [:forum-index-similar-page-pairs {:success 9}]
  [:blog-leaf-similar-page-pairs {:success 5, :fail 4}]
  [:blog-index-similar-page-pairs {:success 4, :fail 5}])}
{:negatives
 ({:link1 "http://blog.shriphani.com/",
   :link2
   "http://blog.shriphani.com/2013/12/18/robust-principal-component-pursuit-background-matrix-recovery/",
   :expected false,
   :computed false,
   :info 0.07350835322195703}
  {:link1 "http://rottenindenmark.wordpress.com/",
   :link2
   "http://rottenindenmark.wordpress.com/2012/02/29/what-is-your-boss-buying/",
   :expected false,
   :computed false,
   :info 0.5019762845849802}
  {:link1 "http://carsandetc.tumblr.com/",
   :link2
   "http://carsandetc.tumblr.com/post/76160507825/chevy-camaro-z-28",
   :expected false,
   :computed false,
   :info 0.675120244862265}
  {:link1 "http://www.adventuresoncehad.com/",
   :link2 "http://www.adventuresoncehad.com/post/76190425016",
   :expected false,
   :computed false,
   :info 0.491566265060241}
  {:link1 "http://minimsft.blogspot.com/",
   :link2
   "http://minimsft.blogspot.com/2013/08/steve-ballmer-is-going-to-frickin.html",
   :expected false,
   :computed false,
   :info 0.3046330463304633}
  {:link1 "http://lifeandartintheup.blogspot.com/",
   :link2
   "http://lifeandartintheup.blogspot.com/2012/03/wind-off-of-breaking-ice-covered-lake.html",
   :expected false,
   :computed false,
   :info 0.5572254335260116}
  {:link1 "http://paulmullins.wordpress.com/",
   :link2
   "http://paulmullins.wordpress.com/2014/02/08/domesticating-dissent-consuming-johnny-cash/",
   :expected false,
   :computed false,
   :info 0.628226249313564}
  {:link1 "http://sportsethicist.com/",
   :link2
   "http://sportsethicist.com/2014/02/05/boycotts-and-the-sochi-olympics/",
   :expected false,
   :computed false,
   :info 0.4723646723646724}
  {:link1 "http://techcrunch.com/",
   :link2
   "http://techcrunch.com/2014/02/10/inmobi-launches-interactive-video-ad-platform-to-help-advertisers-boost-sales-on-mobile/",
   :expected false,
   :computed false,
   :info 0.2871319880913}
  {:link1 "http://www.vbulletin.org/forum/forumdisplay.php?f=263",
   :link2 "http://www.vbulletin.org/forum/showthread.php?t=254967",
   :expected false,
   :computed false,
   :info 0.1917454858125537}
  {:link1
   "http://forums.finalgear.com/finalgear-meets/finalgear-lemon-party-texas-march-57401/",
   :link2 "http://forums.finalgear.com/the-site-itself/",
   :expected false,
   :computed false,
   :info 0.1482398239823982}
  {:link1 "http://www.theverge.com/forums",
   :link2
   "http://www.theverge.com/2014/2/6/5387804/looking-for-an-inexpensive-device-with-nfc",
   :expected false,
   :computed false,
   :info 0.2308188265635074}
  {:link1
   "http://www.12allchat.com/forum/viewtopic.php?f=143&t=120886",
   :link2 "http://www.12allchat.com/forum/viewforum.php?f=143",
   :expected false,
   :computed false,
   :info 0.2328269484808454}
  {:link1 "http://www.bmwfaq.com/forums/foro-general-bmw.7/",
   :link2
   "http://www.bmwfaq.com/threads/hoy-he-echo-un-60-a-320-km-conometrado-en-8-segundos.787580/",
   :expected false,
   :computed false,
   :info 0.2207171314741036}
  {:link1 "http://forums.asterisk.org/viewtopic.php?f=38&t=87887",
   :link2 "http://forums.asterisk.org/viewforum.php?f=38&start=50",
   :expected false,
   :computed false,
   :info 0.3124569855471438}
  {:link1 "http://www.reddit.com/",
   :link2
   "http://www.reddit.com/r/aww/comments/1xitir/my_neighbor_took_a_picture_of_my_dogs_and_it/",
   :expected false,
   :computed false,
   :info 0.1865316901408451}
  {:link1 "http://blog.shriphani.com/",
   :link2
   "http://blog.shriphani.com/2014/01/11/all-it-took-was-an-aha/",
   :expected false,
   :computed false,
   :info 0.1376228775692583}
  {:link1 "http://rottenindenmark.wordpress.com/",
   :link2
   "http://rottenindenmark.wordpress.com/2014/02/01/bleg-anyone-been-to-bangladesh/",
   :expected false,
   :computed false,
   :info 0.4953203743700504}
  {:link1 "http://carsandetc.tumblr.com/",
   :link2
   "http://carsandetc.tumblr.com/post/76473121817/a-stunning-camaro-ss-convertible-sandwiched-in",
   :expected false,
   :computed false,
   :info 0.6825817860300619}
  {:link1 "http://www.adventuresoncehad.com/",
   :link2 "http://www.adventuresoncehad.com/post/76340631742",
   :expected false,
   :computed false,
   :info 0.4619164619164619}
  {:link1 "http://minimsft.blogspot.com/",
   :link2
   "http://minimsft.blogspot.com/2013/08/steve-ballmer-is-going-to-frickin.html",
   :expected false,
   :computed false,
   :info 0.3046330463304633}
  {:link1 "http://lifeandartintheup.blogspot.com/",
   :link2
   "http://lifeandartintheup.blogspot.com/2012/03/wind-off-of-breaking-ice-covered-lake.html",
   :expected false,
   :computed false,
   :info 0.5572254335260116}
  {:link1
   "http://paulmullins.wordpress.com/2014/02/08/domesticating-dissent-consuming-johnny-cash/",
   :link2 "http://paulmullins.wordpress.com/",
   :expected false,
   :computed false,
   :info 0.6278814489571899}
  {:link1 "http://sportsethicist.com/",
   :link2
   "http://sportsethicist.com/2014/02/10/ethics-of-high-school-athletic-transfers/",
   :expected false,
   :computed false,
   :info 0.6523125996810207}
  {:link1 "http://techcrunch.com/",
   :link2
   "http://techcrunch.com/2014/02/12/white-house-unveils-cybersecurity-plan-for-big-firms-looks-to-silicon-valley-next/",
   :expected false,
   :computed false,
   :info 0.3204134366925065}),
 :forum-leaf-similar-page-pairs
 ({:link1 "http://www.vbulletin.org/forum/showthread.php?t=254967",
   :link2 "http://www.vbulletin.org/forum/showthread.php?t=295438",
   :expected true,
   :computed false,
   :info 0.5591274397244546}
  {:link1 "http://www.vbulletin.org/forum/showthread.php?t=285516",
   :link2 "http://www.vbulletin.org/forum/showthread.php?t=295438",
   :expected true,
   :computed false,
   :info 0.4584702017832004}
  {:link1
   "http://forums.finalgear.com/finalgear-meets/finalgear-lemon-party-texas-march-57401/",
   :link2 "http://forums.finalgear.com/problems/nsfw-subforum-57124/",
   :expected true,
   :computed false,
   :info 0.6100200400801603}
  {:link1
   "http://www.theverge.com/2014/2/6/5387804/looking-for-an-inexpensive-device-with-nfc",
   :link2
   "http://www.theverge.com/2014/2/6/5386736/has-there-been-any-indication-of-a-north-american-z1-compact",
   :expected true,
   :computed true,
   :info 0.9922958397534669}
  {:link1
   "http://www.bmwfaq.com/threads/hoy-he-echo-un-60-a-320-km-conometrado-en-8-segundos.787580/",
   :link2
   "http://www.bmwfaq.com/threads/como-dice-el-anuncio-me-he-comprado-un-polo.786907/",
   :expected true,
   :computed true,
   :info 0.847046031170714}
  {:link1 "http://forum.avantbrowser.com/viewtopic.php?f=9&t=33057",
   :link2 "http://forum.avantbrowser.com/viewtopic.php?f=9&t=32452",
   :expected true,
   :computed false,
   :info 0.6258992805755396}
  {:link1
   "http://www.12allchat.com/forum/viewtopic.php?f=143&t=120886",
   :link2
   "http://www.12allchat.com/forum/viewtopic.php?f=143&t=120884",
   :expected true,
   :computed false,
   :info 0.3434566537824406}
  {:link1 "http://forums.asterisk.org/viewtopic.php?f=38&t=87887",
   :link2 "http://forums.asterisk.org/viewtopic.php?f=38&t=88051",
   :expected true,
   :computed false,
   :info 0.7308176100628931}
  {:link1
   "http://www.artofproblemsolving.com/Forum/viewtopic.php?f=300&t=573898",
   :link2
   "http://www.artofproblemsolving.com/Forum/viewtopic.php?f=300&t=23215",
   :expected true,
   :computed false,
   :info 0.6744540375825292}),
 :forum-index-similar-page-pairs
 ({:link1 "http://www.vbulletin.org/forum/forumdisplay.php?f=263",
   :link2 "http://www.vbulletin.org/forum/forumdisplay.php?f=26",
   :expected true,
   :computed true,
   :info 0.9392165691130122}
  {:link1 "http://forums.finalgear.com/the-site-itself/",
   :link2 "http://forums.finalgear.com/top-gear-america/",
   :expected true,
   :computed true,
   :info 0.8466290625839377}
  {:link1 "http://forums.finalgear.com/fifth-gear/",
   :link2 "http://forums.finalgear.com/top-gear-america/",
   :expected true,
   :computed true,
   :info 0.9311111111111111}
  {:link1 "http://www.theverge.com/forums",
   :link2 "http://www.theverge.com/forums/all/forum/2",
   :expected true,
   :computed true,
   :info 0.9991850040749796}
  {:link1
   "http://www.artofproblemsolving.com/Forum/viewforum.php?f=300&",
   :link2
   "http://www.artofproblemsolving.com/Forum/viewforum.php?f=300&start=40",
   :expected true,
   :computed true,
   :info 0.9687697160883281}
  {:link1 "http://forums.asterisk.org/viewforum.php?f=38",
   :link2 "http://forums.asterisk.org/viewforum.php?f=38&start=50",
   :expected true,
   :computed true,
   :info 0.9961089494163424}
  {:link1 "http://www.12allchat.com/forum/viewforum.php?f=143",
   :link2
   "http://www.12allchat.com/forum/viewforum.php?f=143&start=75",
   :expected true,
   :computed true,
   :info 0.9935828877005348}
  {:link1 "http://forum.avantbrowser.com/viewforum.php?f=9",
   :link2 "http://forum.avantbrowser.com/viewforum.php?f=9&start=120",
   :expected true,
   :computed true,
   :info 0.9721784776902886}
  {:link1 "http://www.bmwfaq.com/forums/foro-general-bmw.7/",
   :link2 "http://www.bmwfaq.com/forums/foro-general-bmw.7/page-6",
   :expected true,
   :computed true,
   :info 0.8883139284174213}),
 :blog-leaf-similar-page-pairs
 ({:link1
   "http://blog.shriphani.com/2014/01/11/all-it-took-was-an-aha/",
   :link2 "http://blog.shriphani.com/2013/12/26/the-sistine-chapel/",
   :expected true,
   :computed false,
   :info 0.7007874015748031}
  {:link1
   "http://rottenindenmark.wordpress.com/2014/02/01/bleg-anyone-been-to-bangladesh/",
   :link2
   "http://rottenindenmark.wordpress.com/2014/01/30/five-stories-about-sports-for-people-who-hate-sports/",
   :expected true,
   :computed true,
   :info 0.9798619102416571}
  {:link1
   "http://carsandetc.tumblr.com/post/76473121817/a-stunning-camaro-ss-convertible-sandwiched-in",
   :link2
   "http://carsandetc.tumblr.com/post/76472905072/chevy-impala-parked-roadside",
   :expected true,
   :computed true,
   :info 0.9396039603960396}
  {:link1 "http://www.adventuresoncehad.com/post/76340631742",
   :link2 "http://www.adventuresoncehad.com/post/74869511763",
   :expected true,
   :computed true,
   :info 0.9227053140096618}
  {:link1
   "http://minimsft.blogspot.com/2013/08/steve-ballmer-is-going-to-frickin.html",
   :link2
   "http://minimsft.blogspot.com/2012/11/a-microsoft-without-sinofsky.html",
   :expected true,
   :computed true,
   :info 0.8695141640980478}
  {:link1
   "http://lifeandartintheup.blogspot.com/2012/03/wind-off-of-breaking-ice-covered-lake.html",
   :link2
   "http://lifeandartintheup.blogspot.com/2011/09/hey-fall-you-arrived-early-but-since.html",
   :expected true,
   :computed true,
   :info 0.8599871547848426}
  {:link1
   "http://paulmullins.wordpress.com/2014/02/08/domesticating-dissent-consuming-johnny-cash/",
   :link2
   "http://paulmullins.wordpress.com/2014/01/27/the-final-choice-the-materiality-of-last-meals/",
   :expected true,
   :computed false,
   :info 0.6369661266568483}
  {:link1
   "http://sportsethicist.com/2014/02/10/ethics-of-high-school-athletic-transfers/",
   :link2
   "http://sportsethicist.com/2014/02/05/boycotts-and-the-sochi-olympics/",
   :expected true,
   :computed false,
   :info 0.697874784606548}
  {:link1
   "http://techcrunch.com/2014/02/12/white-house-unveils-cybersecurity-plan-for-big-firms-looks-to-silicon-valley-next/",
   :link2
   "http://techcrunch.com/2014/02/06/apple-hiring-fitness-physiologists-sleep-experts-on-the-heels-of-recent-iwatch-rumors/?source=gravity",
   :expected true,
   :computed false,
   :info 0.7931206380857428}),
 :blog-index-similar-page-pairs
 ({:link1 "http://blog.shriphani.com/",
   :link2 "http://blog.shriphani.com/index-2.html",
   :expected true,
   :computed false,
   :info 0.3290816326530612}
  {:link1 "http://rottenindenmark.wordpress.com/",
   :link2 "http://rottenindenmark.wordpress.com/2012/02/",
   :expected true,
   :computed false,
   :info 0.7838302752293578}
  {:link1 "http://carsandetc.tumblr.com/",
   :link2 "http://carsandetc.tumblr.com/page/2",
   :expected true,
   :computed true,
   :info 0.9794204115917682}
  {:link1 "http://www.adventuresoncehad.com/",
   :link2 "http://www.adventuresoncehad.com/page/2",
   :expected true,
   :computed true,
   :info 0.9138755980861244}
  {:link1 "http://minimsft.blogspot.com/",
   :link2
   "http://minimsft.blogspot.com/search?updated-max=2011-04-28T07:52:00-07:00&max-results=11",
   :expected true,
   :computed false,
   :info 0.7740416946872898}
  {:link1 "http://lifeandartintheup.blogspot.com/",
   :link2
   "http://lifeandartintheup.blogspot.com/search?updated-max=2011-09-27T03:07:00-07:00&max-results=7",
   :expected true,
   :computed false,
   :info 0.6906093612010598}
  {:link1 "http://paulmullins.wordpress.com/",
   :link2 "http://paulmullins.wordpress.com/page/2/",
   :expected true,
   :computed true,
   :info 0.880236305048335}
  {:link1 "http://sportsethicist.com/",
   :link2 "http://sportsethicist.com/2013/07/",
   :expected true,
   :computed false,
   :info 0.7582005623242737}
  {:link1 "http://techcrunch.com/",
   :link2 "http://techcrunch.com/page/2/",
   :expected true,
   :computed true,
   :info 0.9601528384279476})}
