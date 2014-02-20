{:global {:fail 9, :success 62},
 :accuracy 0.8732394366197183,
 :per-corpus
 ([:qa-similar-index-page-pairs {:success 5}]
  [:negatives {:success 26, :fail 4}]
  [:forum-leaf-similar-page-pairs {:fail 1, :success 8}]
  [:forum-index-similar-page-pairs {:success 9}]
  [:blog-leaf-similar-page-pairs {:fail 1, :success 8}]
  [:blog-index-similar-page-pairs {:success 6, :fail 3}])}
{:qa-similar-index-page-pairs
 ({:link1 "http://stackoverflow.com/questions",
   :link2 "http://stackoverflow.com/questions?page=2&sort=newest",
   :expected true,
   :computed true,
   :info 0.9985066343486889}
  {:link1 "http://mindthebook.com/",
   :link2 "http://mindthebook.com/questions/search/popular/page/2",
   :expected true,
   :computed true,
   :info 0.8657476358720115}
  {:link1 "http://askville.amazon.com/Index.do",
   :link2
   "http://askville.amazon.com/Index.do?page=2&filter=AllAnswersOnly",
   :expected true,
   :computed true,
   :info 0.9994882816982726}
  {:link1 "http://superuser.com/questions",
   :link2 "http://superuser.com/questions?page=2&sort=newest",
   :expected true,
   :computed true,
   :info 0.9991942229206948}
  {:link1 "http://www.metafilter.com/",
   :link2 "http://www.metafilter.com/index.cfm?page=2",
   :expected true,
   :computed true,
   :info 0.9766911690718943}),
 :negatives
 ({:link1 "http://blog.shriphani.com/",
   :link2
   "http://blog.shriphani.com/2013/12/18/robust-principal-component-pursuit-background-matrix-recovery/",
   :expected false,
   :computed true,
   :info 0.7587740639357192}
  {:link1 "http://rottenindenmark.wordpress.com/",
   :link2
   "http://rottenindenmark.wordpress.com/2012/02/29/what-is-your-boss-buying/",
   :expected false,
   :computed false,
   :info 4.743955098015219E-5}
  {:link1 "http://carsandetc.tumblr.com/",
   :link2
   "http://carsandetc.tumblr.com/post/76160507825/chevy-camaro-z-28",
   :expected false,
   :computed false,
   :info 0.5659744483509581}
  {:link1 "http://www.adventuresoncehad.com/",
   :link2 "http://www.adventuresoncehad.com/post/76190425016",
   :expected false,
   :computed true,
   :info 0.8977931085727705}
  {:link1 "http://minimsft.blogspot.com/",
   :link2
   "http://minimsft.blogspot.com/2013/08/steve-ballmer-is-going-to-frickin.html",
   :expected false,
   :computed false,
   :info 0.004203404005976772}
  {:link1 "http://lifeandartintheup.blogspot.com/",
   :link2
   "http://lifeandartintheup.blogspot.com/2012/03/wind-off-of-breaking-ice-covered-lake.html",
   :expected false,
   :computed false,
   :info 0.416541238185853}
  {:link1 "http://paulmullins.wordpress.com/",
   :link2
   "http://paulmullins.wordpress.com/2014/02/08/domesticating-dissent-consuming-johnny-cash/",
   :expected false,
   :computed false,
   :info 6.687675894233701E-5}
  {:link1 "http://sportsethicist.com/",
   :link2
   "http://sportsethicist.com/2014/02/05/boycotts-and-the-sochi-olympics/",
   :expected false,
   :computed false,
   :info 7.446535819597089E-5}
  {:link1 "http://techcrunch.com/",
   :link2
   "http://techcrunch.com/2014/02/10/inmobi-launches-interactive-video-ad-platform-to-help-advertisers-boost-sales-on-mobile/",
   :expected false,
   :computed false,
   :info 6.606966593132487E-4}
  {:link1 "http://www.vbulletin.org/forum/forumdisplay.php?f=263",
   :link2 "http://www.vbulletin.org/forum/showthread.php?t=254967",
   :expected false,
   :computed false,
   :info 0.008998631438567198}
  {:link1
   "http://forums.finalgear.com/finalgear-meets/finalgear-lemon-party-texas-march-57401/",
   :link2 "http://forums.finalgear.com/the-site-itself/",
   :expected false,
   :computed false,
   :info 0.012906006426409938}
  {:link1 "http://www.theverge.com/forums",
   :link2
   "http://www.theverge.com/2014/2/6/5387804/looking-for-an-inexpensive-device-with-nfc",
   :expected false,
   :computed false,
   :info 0.006663791964729127}
  {:link1
   "http://www.12allchat.com/forum/viewtopic.php?f=143&t=120886",
   :link2 "http://www.12allchat.com/forum/viewforum.php?f=143",
   :expected false,
   :computed false,
   :info 0.001999692744418325}
  {:link1 "http://www.bmwfaq.com/forums/foro-general-bmw.7/",
   :link2
   "http://www.bmwfaq.com/threads/hoy-he-echo-un-60-a-320-km-conometrado-en-8-segundos.787580/",
   :expected false,
   :computed false,
   :info 0.010398122284904927}
  {:link1 "http://forums.asterisk.org/viewtopic.php?f=38&t=87887",
   :link2 "http://forums.asterisk.org/viewforum.php?f=38&start=50",
   :expected false,
   :computed false,
   :info 0.06621897821191464}
  {:link1 "http://www.reddit.com/",
   :link2
   "http://www.reddit.com/r/aww/comments/1xitir/my_neighbor_took_a_picture_of_my_dogs_and_it/",
   :expected false,
   :computed false,
   :info 1.1646056722076777E-4}
  {:link1 "http://blog.shriphani.com/",
   :link2
   "http://blog.shriphani.com/2014/01/11/all-it-took-was-an-aha/",
   :expected false,
   :computed false,
   :info 0.364058103928939}
  {:link1 "http://rottenindenmark.wordpress.com/",
   :link2
   "http://rottenindenmark.wordpress.com/2014/02/01/bleg-anyone-been-to-bangladesh/",
   :expected false,
   :computed false,
   :info 9.043995755713355E-5}
  {:link1 "http://carsandetc.tumblr.com/",
   :link2
   "http://carsandetc.tumblr.com/post/76473121817/a-stunning-camaro-ss-convertible-sandwiched-in",
   :expected false,
   :computed true,
   :info 0.600442869738973}
  {:link1 "http://www.adventuresoncehad.com/",
   :link2 "http://www.adventuresoncehad.com/post/76340631742",
   :expected false,
   :computed true,
   :info 0.6791070079203699}
  {:link1 "http://minimsft.blogspot.com/",
   :link2
   "http://minimsft.blogspot.com/2013/08/steve-ballmer-is-going-to-frickin.html",
   :expected false,
   :computed false,
   :info 0.004203404005976772}
  {:link1 "http://lifeandartintheup.blogspot.com/",
   :link2
   "http://lifeandartintheup.blogspot.com/2012/03/wind-off-of-breaking-ice-covered-lake.html",
   :expected false,
   :computed false,
   :info 0.416541238185853}
  {:link1
   "http://paulmullins.wordpress.com/2014/02/08/domesticating-dissent-consuming-johnny-cash/",
   :link2 "http://paulmullins.wordpress.com/",
   :expected false,
   :computed false,
   :info 6.687675894233701E-5}
  {:link1 "http://sportsethicist.com/",
   :link2
   "http://sportsethicist.com/2014/02/10/ethics-of-high-school-athletic-transfers/",
   :expected false,
   :computed false,
   :info 5.476503355251642E-4}
  {:link1 "http://techcrunch.com/",
   :link2
   "http://techcrunch.com/2014/02/12/white-house-unveils-cybersecurity-plan-for-big-firms-looks-to-silicon-valley-next/",
   :expected false,
   :computed false,
   :info 5.147410011336409E-4}
  {:link1 "http://stackoverflow.com/questions",
   :link2
   "http://stackoverflow.com/questions/21898464/windows-7-smartcard-service-hang-after-a-lot-of-scardcontrol",
   :expected false,
   :computed false,
   :info 0.001606518642209733}
  {:link1 "http://mindthebook.com/",
   :link2
   "http://mindthebook.com/question/what_is_the_story_of_darryl_flicking",
   :expected false,
   :computed false,
   :info 0.1373366249191133}
  {:link1 "http://askville.amazon.com/Index.do",
   :link2
   "http://askville.amazon.com/republican-resistance-legislation-help-create-jobs-based-sound-economics/AnswerViewer.do?requestId=90037687",
   :expected false,
   :computed false,
   :info 0.057951851219124516}
  {:link1 "http://superuser.com/questions",
   :link2
   "http://superuser.com/questions/719239/itunes-playback-skipping-on-some-songs",
   :expected false,
   :computed false,
   :info 0.0019187928053895262}
  {:link1 "http://www.metafilter.com/",
   :link2 "http://www.metafilter.com/136813/Venezuela-Riots",
   :expected false,
   :computed false,
   :info 0.006592812789125626}),
 :forum-leaf-similar-page-pairs
 ({:link1 "http://www.vbulletin.org/forum/showthread.php?t=254967",
   :link2 "http://www.vbulletin.org/forum/showthread.php?t=295438",
   :expected true,
   :computed true,
   :info 0.7889185670881613}
  {:link1 "http://www.vbulletin.org/forum/showthread.php?t=285516",
   :link2 "http://www.vbulletin.org/forum/showthread.php?t=295438",
   :expected true,
   :computed true,
   :info 0.7510780659253038}
  {:link1
   "http://forums.finalgear.com/finalgear-meets/finalgear-lemon-party-texas-march-57401/",
   :link2 "http://forums.finalgear.com/problems/nsfw-subforum-57124/",
   :expected true,
   :computed true,
   :info 0.8485121283245324}
  {:link1
   "http://www.theverge.com/2014/2/6/5387804/looking-for-an-inexpensive-device-with-nfc",
   :link2
   "http://www.theverge.com/2014/2/6/5386736/has-there-been-any-indication-of-a-north-american-z1-compact",
   :expected true,
   :computed true,
   :info 0.7878971426489235}
  {:link1
   "http://www.bmwfaq.com/threads/hoy-he-echo-un-60-a-320-km-conometrado-en-8-segundos.787580/",
   :link2
   "http://www.bmwfaq.com/threads/como-dice-el-anuncio-me-he-comprado-un-polo.786907/",
   :expected true,
   :computed true,
   :info 0.9644662341985332}
  {:link1 "http://forum.avantbrowser.com/viewtopic.php?f=9&t=33057",
   :link2 "http://forum.avantbrowser.com/viewtopic.php?f=9&t=32452",
   :expected true,
   :computed true,
   :info 0.9731914235323148}
  {:link1
   "http://www.12allchat.com/forum/viewtopic.php?f=143&t=120886",
   :link2
   "http://www.12allchat.com/forum/viewtopic.php?f=143&t=120884",
   :expected true,
   :computed false,
   :info 0.001457889233064024}
  {:link1 "http://forums.asterisk.org/viewtopic.php?f=38&t=87887",
   :link2 "http://forums.asterisk.org/viewtopic.php?f=38&t=88051",
   :expected true,
   :computed true,
   :info 0.8849218010619386}
  {:link1
   "http://www.artofproblemsolving.com/Forum/viewtopic.php?f=300&t=573898",
   :link2
   "http://www.artofproblemsolving.com/Forum/viewtopic.php?f=300&t=23215",
   :expected true,
   :computed true,
   :info 0.9426934827716669}),
 :forum-index-similar-page-pairs
 ({:link1 "http://www.vbulletin.org/forum/forumdisplay.php?f=263",
   :link2 "http://www.vbulletin.org/forum/forumdisplay.php?f=26",
   :expected true,
   :computed true,
   :info 0.9910382043728752}
  {:link1 "http://forums.finalgear.com/the-site-itself/",
   :link2 "http://forums.finalgear.com/top-gear-america/",
   :expected true,
   :computed true,
   :info 0.9661521602495398}
  {:link1 "http://forums.finalgear.com/fifth-gear/",
   :link2 "http://forums.finalgear.com/top-gear-america/",
   :expected true,
   :computed true,
   :info 0.9919457721339467}
  {:link1 "http://www.theverge.com/forums",
   :link2 "http://www.theverge.com/forums/all/forum/2",
   :expected true,
   :computed true,
   :info 0.9996913985899492}
  {:link1
   "http://www.artofproblemsolving.com/Forum/viewforum.php?f=300&",
   :link2
   "http://www.artofproblemsolving.com/Forum/viewforum.php?f=300&start=40",
   :expected true,
   :computed true,
   :info 0.9997643215723638}
  {:link1 "http://forums.asterisk.org/viewforum.php?f=38",
   :link2 "http://forums.asterisk.org/viewforum.php?f=38&start=50",
   :expected true,
   :computed true,
   :info 0.9998888000546364}
  {:link1 "http://www.12allchat.com/forum/viewforum.php?f=143",
   :link2
   "http://www.12allchat.com/forum/viewforum.php?f=143&start=75",
   :expected true,
   :computed true,
   :info 0.99291646478035}
  {:link1 "http://forum.avantbrowser.com/viewforum.php?f=9",
   :link2 "http://forum.avantbrowser.com/viewforum.php?f=9&start=120",
   :expected true,
   :computed true,
   :info 0.9998937739322314}
  {:link1 "http://www.bmwfaq.com/forums/foro-general-bmw.7/",
   :link2 "http://www.bmwfaq.com/forums/foro-general-bmw.7/page-6",
   :expected true,
   :computed true,
   :info 0.9614116696436911}),
 :blog-leaf-similar-page-pairs
 ({:link1
   "http://blog.shriphani.com/2014/01/11/all-it-took-was-an-aha/",
   :link2 "http://blog.shriphani.com/2013/12/26/the-sistine-chapel/",
   :expected true,
   :computed true,
   :info 0.7558740762173193}
  {:link1
   "http://rottenindenmark.wordpress.com/2014/02/01/bleg-anyone-been-to-bangladesh/",
   :link2
   "http://rottenindenmark.wordpress.com/2014/01/30/five-stories-about-sports-for-people-who-hate-sports/",
   :expected true,
   :computed true,
   :info 0.9905764899873551}
  {:link1
   "http://carsandetc.tumblr.com/post/76473121817/a-stunning-camaro-ss-convertible-sandwiched-in",
   :link2
   "http://carsandetc.tumblr.com/post/76472905072/chevy-impala-parked-roadside",
   :expected true,
   :computed true,
   :info 0.9796435003460221}
  {:link1 "http://www.adventuresoncehad.com/post/76340631742",
   :link2 "http://www.adventuresoncehad.com/post/74869511763",
   :expected true,
   :computed true,
   :info 0.8471960468504759}
  {:link1
   "http://minimsft.blogspot.com/2013/08/steve-ballmer-is-going-to-frickin.html",
   :link2
   "http://minimsft.blogspot.com/2012/11/a-microsoft-without-sinofsky.html",
   :expected true,
   :computed true,
   :info 0.9983646793472248}
  {:link1
   "http://lifeandartintheup.blogspot.com/2012/03/wind-off-of-breaking-ice-covered-lake.html",
   :link2
   "http://lifeandartintheup.blogspot.com/2011/09/hey-fall-you-arrived-early-but-since.html",
   :expected true,
   :computed true,
   :info 0.9465118872415423}
  {:link1
   "http://paulmullins.wordpress.com/2014/02/08/domesticating-dissent-consuming-johnny-cash/",
   :link2
   "http://paulmullins.wordpress.com/2014/01/27/the-final-choice-the-materiality-of-last-meals/",
   :expected true,
   :computed true,
   :info 0.7153176344512728}
  {:link1
   "http://sportsethicist.com/2014/02/10/ethics-of-high-school-athletic-transfers/",
   :link2
   "http://sportsethicist.com/2014/02/05/boycotts-and-the-sochi-olympics/",
   :expected true,
   :computed false,
   :info 0.36736069801705157}
  {:link1
   "http://techcrunch.com/2014/02/12/white-house-unveils-cybersecurity-plan-for-big-firms-looks-to-silicon-valley-next/",
   :link2
   "http://techcrunch.com/2014/02/06/apple-hiring-fitness-physiologists-sleep-experts-on-the-heels-of-recent-iwatch-rumors/?source=gravity",
   :expected true,
   :computed true,
   :info 0.7913786584507279}),
 :blog-index-similar-page-pairs
 ({:link1 "http://blog.shriphani.com/",
   :link2 "http://blog.shriphani.com/index-2.html",
   :expected true,
   :computed false,
   :info 0.42229408034278}
  {:link1 "http://rottenindenmark.wordpress.com/",
   :link2 "http://rottenindenmark.wordpress.com/2012/02/",
   :expected true,
   :computed false,
   :info 2.083824904235865E-5}
  {:link1 "http://carsandetc.tumblr.com/",
   :link2 "http://carsandetc.tumblr.com/page/2",
   :expected true,
   :computed true,
   :info 0.9998672234509106}
  {:link1 "http://www.adventuresoncehad.com/",
   :link2 "http://www.adventuresoncehad.com/page/2",
   :expected true,
   :computed true,
   :info 0.9783164911486545}
  {:link1 "http://minimsft.blogspot.com/",
   :link2
   "http://minimsft.blogspot.com/search?updated-max=2011-04-28T07:52:00-07:00&max-results=11",
   :expected true,
   :computed true,
   :info 0.9224484996519915}
  {:link1 "http://lifeandartintheup.blogspot.com/",
   :link2
   "http://lifeandartintheup.blogspot.com/search?updated-max=2011-09-27T03:07:00-07:00&max-results=7",
   :expected true,
   :computed true,
   :info 0.5827793202080662}
  {:link1 "http://paulmullins.wordpress.com/",
   :link2 "http://paulmullins.wordpress.com/page/2/",
   :expected true,
   :computed true,
   :info 0.9968919460508859}
  {:link1 "http://sportsethicist.com/",
   :link2 "http://sportsethicist.com/2013/07/",
   :expected true,
   :computed false,
   :info 1.979693664623823E-4}
  {:link1 "http://techcrunch.com/",
   :link2 "http://techcrunch.com/page/2/",
   :expected true,
   :computed true,
   :info 0.998664627091589})}
