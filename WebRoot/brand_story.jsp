<!--
	作者：方小斌,龙威
	时间：2015-04-27
	描述：网站首页
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/public.css" />
		<link rel="stylesheet" type="text/css" href="css/swiper3.07.min.css"/>
		<link rel="stylesheet" href="css/story.css" type="text/css"/>
		<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/swiper3.07.jquery.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="js/public.js" ></script>
	</head>

	<body>
		<!-- 引入头部导航 -->
		<jsp:include flush="true" page="public/header.jsp"></jsp:include>
		
		<div class="container">
			<!-- 左导航 -->
			<jsp:include flush="true" page="public/menu.jsp"></jsp:include>
			
			<!-- 主体部分 ：width:962px;(内容自由发挥)-->
			<div class="main">
				<div class="logo-container">
                <!--导航 开始-->
	           <div class="reallove_content">
				<img src="img/reallove01.jpg" class="reallove_img" alt="真爱故事" />
				<img src="img/reallove02.jpg" class="reallove_img" alt="真爱故事" id="reallove_img_top"/>
				<div class="reallove_xq">
					<img id="love_img" src="img/13759547758928162.png" class="reallove_xqimg" alt="真爱故事" />					<div class="reallove_xqstory">
						<p id="lovedate">2013-08-08 <br/></p>
						<font class="font" id="love_title">四川地震中的佳缘</font>
						<p id="love_txt">雅安正在经历苦痛。对于roseonly而言，我们一直在寻找最能给人以信心与能量的人与事，抑或是一个场景。在信.望.爱中，爱为最大。有幸，我们收到了这样一段看似平淡，却直击人心的爱情故事，于地震中相识，于生活中交集。&nbsp;&nbsp;爱，不可用于作秀。&nbsp;2008年的汶川地震，让我们认识。当时正值5.12之后大批骨折和内脏受损伤员运抵重医附二院手术和休整，我们在医院做志愿者时相识，更巧的是&nbsp;我们在同个学校，于是开始了一个普通的校园恋爱故事。磕磕绊绊中走到结婚相守的这一天:我拥有梦想中的婚纱照，最简单的背景，有最美的花。&nbsp;&nbsp;如今，四川再度地震，希望roseonly将我们的故事给于大家：雅安加油。和五年前一样，我们依然挂念，依然落泪，我们伸出的手依然滚烫，相信，苦难之中，有幸福所在。除了救生命于水火中，我们更需要正能量。</p>
					</div>	
										<div class="reallove_xqsl">
						<div class="img1">
												</div>
					</div>
					<div class="clear"></div>
				</div>
				<a class="story_most">更多故事&nbsp;></a>
				<ul class="reallove_story">
						<div id="divid_1" > 
								<a href="javascript:;">
							<li class="love_item">
								<img src="img/13759534833591135.png" class="reallove_xqimg1" alt="明星故事" style="width:200px; height:200px;" />
								<div class="reallove_story_font"><span class="l_date">2013-08-08 </span><br/><span class="l_title">十年之恋</span></div>
								<div class="l_txt" style="display:none">校园，初见。你优秀，光彩照人，多少姑娘心中的白马王子。而我却是一只丑小鸭。爱上你是情理之中也是意外，我却卑微的连表白的勇气都没有，只能远远的站在一边看着你。谁知，这一看就是十年。十年里，我努力变得更好，学会了化妆，爱上了读书，只为再次在你面前时让你惊艳于我的变化分别六年后的＂偶然相遇＂，才知道那时的你原来也喜欢过我。我笑的流出了眼泪。在去年，我们认识的第十一年，你终于为我戴上了订婚戒指。十年的我爱你，终于换来了一句在一起。</div>
								<div style="display:none" iclass="l_img"><img id="love_img" src="img/13759534833591135.png" alt="明星故事" /> </div>
								<div style="display:none" class="l_img1">
																										</div>
							</li>
							</a>
						
																	<a href="javascript:;">
							<li class="love_item">
								<img src="img/13765393565967852.jpg" class="reallove_xqimg1" alt="明星故事" style="width:200px; height:200px;" />
								<div class="reallove_story_font"><span class="l_date">2013-08-15 </span><br/><span class="l_title">我想说：“我很幸福”</span></div>
								<div class="l_txt" style="display:none">机房忙忙碌碌大半天 ，一回来就收到漂亮的玫瑰花 。真的好喜欢！都说这家的玫瑰花很矜贵 ，因为一辈子只能送给唯一。 一个特别扭拧巴的人， 必须遇到一个主动且脸皮厚的人才能得到幸福！我想说：“我很幸福”！收到 roseonly又明白了一个获取幸福的道理。</div>
								<div style="display:none" iclass="l_img"><img id="love_img" src="img/13765393565967852.jpg" alt="明星故事" /> </div>
								<div style="display:none" class="l_img1">
								</div>
							</li>
							</a>
						
						<a href="javascript:;">
							<li class="love_item">
								<img src="img/13765393291513243.jpg" class="reallove_xqimg1" alt="明星故事" style="width:200px; height:200px;" />
								<div class="reallove_story_font"><span class="l_date">2013-08-15 </span><br/><span class="l_title">纪念日</span></div>
								<div class="l_txt" style="display:none">Be with a guy who ruins your Lipstick not your Mascara------2013,5,21 属于我们俩的纪念日</div>
								<div style="display:none" iclass="l_img"><img id="love_img" src="img/13765393291513243.jpg" alt="明星故事" /> </div>
								<div style="display:none" class="l_img1">
																										</div>
							</li>
						    </a>
						
						    <a href="javascript:;">
							<li class="love_item">
								<img src="img/13765393001239931.jpg" class="reallove_xqimg1" alt="明星故事" style="width:200px; height:200px;" />
								<div class="reallove_story_font"><span class="l_date">2013-08-15 </span><br/><span class="l_title">第一次收到玫瑰</span></div>
								<div class="l_txt" style="display:none">生平第一次收到玫瑰，满是欢喜。听说花店的主旨是一生只能赠予一人，何其的笃定。谢谢宝贝，我若是你心中的红玫瑰，亦要是你心口的朱砂痣。也谢谢这专爱的花店。</div>
								<div style="display:none" iclass="l_img"><img id="love_img" src="img/13765393001239931.jpg" alt="明星故事" /> </div>
								<div style="display:none" class="l_img1">
																										</div>
							</li>
							</a>
						</div>
						
						<div id="divid_5" style="display:none" >
							<a href="javascript:;">
							<li class="love_item">
								<img src="img/13765392689167608.jpg" class="reallove_xqimg1" alt="明星故事" style="width:200px; height:200px;" />
								<div class="reallove_story_font"><span class="l_date">2013-08-15 </span><br/><span class="l_title">宠爱之名</span></div>
								<div class="l_txt" style="display:none">毕业这天伴随着亲爱的送的一生只能送一个人的鲜花度过，注定是甜蜜而幸福的，花即魔药。信者得爱，爱是唯一。我和老公的未来并不好走，接下来的异国，彼此的牺牲和承担我们有爱就都不怕！谢谢老公的浪漫，你说的花语我记住了，我是你的真爱~想起【致青春】里的那句：她洗过的发，像心中火焰。6月，以宠爱之名给予青春的离奇。</div>
								<div style="display:none" iclass="l_img"><img id="love_img" src=" img/13765392689167608.jpg" alt="明星故事" /> </div>
								<div style="display:none" class="l_img1">
								</div>
							</li>
							</a>
						
							<a href="javascript:;">
							<li class="love_item">
								<img src="img/13765392445323264.jpg" class="reallove_xqimg1" alt="明星故事" style="width:200px; height:200px;" />
								<div class="reallove_story_font"><span class="l_date">2013-08-15 </span><br/><span class="l_title">有这样一份情谊</span></div>
								<div class="l_txt" style="display:none">你若当她是玫瑰略会觉得她有些昂贵，若当她是情谊，那么手留余香薄壁厚非！快乐是美妙的幸福...悲伤时更会体会歌词里的故事……多少人曾爱慕你年轻时的容颜…… 多少人曾在你生命里走了又还……</div>
								<div style="display:none" iclass="l_img"><img id="love_img" src=" img/13765392445323264.jpg" alt="明星故事" /> </div>
								<div style="display:none" class="l_img1">
								</div>
							</li>
							</a>
						
							<a href="javascript:;">
							<li class="love_item">
								<img src="img/13765392050037014.jpg" class="reallove_xqimg1" alt="明星故事" style="width:200px; height:200px;" />
								<div class="reallove_story_font"><span class="l_date">2013-08-15 </span><br/><span class="l_title">那个唯一的ta</span></div>
								<div class="l_txt" style="display:none">买花不用电话，直接也必须上官网购买，因为要注册唯一，注册后收花人的名字终身永远就不能改了，送多少盒不管，但是必须是你爱的那个唯一的ta，无法更改。因为信者得爱，爱是唯一！trust roseonly, trust love!诺言来之不易，你敢送她roseonly吗？</div>
								<div style="display:none" iclass="l_img"><img id="love_img" src="img/13765392050037014.jpg" alt="明星故事" /> </div>
								<div style="display:none" class="l_img1">
								</div>
							</li>
							</a>
						
							<a href="javascript:;">
							<li class="love_item">
								<img src="img/13765391620901793.jpg" class="reallove_xqimg1" alt="明星故事" style="width:200px; height:200px;" />
								<div class="reallove_story_font"><span class="l_date">2013-08-15 </span><br/><span class="l_title">一生一世的承诺</span></div>
								<div class="l_txt" style="display:none">意外的求婚充满了惊喜，一捧朱砂充满了深深的爱意。谢谢我最亲爱的他，知道我对roseonly专爱花店&nbsp;的喜爱已经很久，在这个重要的时刻，一生一世的承诺伴着朱砂的红，永远烙印在手上。这一生，我只能与roseonly的花相伴了。【信者得爱，爱是唯一】</div>
								<div style="display:none" iclass="l_img"><img id="love_img" src="img/13765391620901793.jpg" alt="明星故事" /> </div>
								<div style="display:none" class="l_img1">
								</div>
							</li>
							</a>
						</div>
						
						<div id="divid_9" style="display:none" >
							<a href="javascript:;">
							<li class="love_item">
								<img src="img/13765390717087160.jpg" class="reallove_xqimg1" alt="明星故事" style="width:200px; height:200px;" />
								<div class="reallove_story_font"><span class="l_date">2013-08-15 </span><br/><span class="l_title">浓情爱意</span></div>
								<div class="l_txt" style="display:none">从没想过数月前无心之举动，将「rose only」的照片拿给他看，会让他有心不远千里，专门差人从北京买来送我，只因今天是我26岁生日，这束「一位男士一辈子只能送给一位佳人」的「rose only」是我生日最大的惊喜，感恩上天让我在最美好的年华遇上你！roseonly专爱花店你们的花真的太美！</div>
								<div style="display:none" iclass="l_img"><img id="love_img" src="img/13765390717087160.jpg" alt="明星故事" /> </div>
								<div style="display:none" class="l_img1">
								</div>
							</li>
							</a>
						
							<a href="javascript:;">
							<li class="love_item">
								<img src="img/13759556536244724.jpg" class="reallove_xqimg1" alt="明星故事" style="width:200px; height:200px;" />
								<div class="reallove_story_font"><span class="l_date">2013-08-08 </span><br/><span class="l_title">我们的爱 一直都在</span></div>
								<div class="l_txt" style="display:none">大學一年級相戀，畢業一年后分開，五年。他說她是他的唯一...唯一想要送花的女孩，唯一想要單膝下跪的女孩，唯一想再披上嫁纱的女孩，唯一想要擁抱入夢的女孩，唯一想要給一個家的女孩......因為種種原因，分開，他說：唯一就是唯一，衹有一個，此生非你不娶！分開整整一年，没有一個电话，没有一條短信，也没有一次見面，斷了所有聯繫！2012年的聖誕節，人群中，一眼望出，原來，你一直都在，在我身後等待！2013年5月，我們結婚了，因為愛，一直都在！</div>
								<div style="display:none" iclass="l_img"><img id="love_img" src="img/13759556536244724.jpg" alt="明星故事" /> </div>
								<div style="display:none" class="l_img1">
								</div>
							</li>
							</a>
						
							<a href="javascript:;">
							<li class="love_item">
								<img src="img/13759555305883941.png" class="reallove_xqimg1" alt="明星故事" style="width:200px; height:200px;" />
								<div class="reallove_story_font"><span class="l_date">2013-08-08 </span><br/><span class="l_title">幸福，有时候来的很突然</span></div>
								<div class="l_txt" style="display:none">11年7月，他和她相识在拉萨八角街的旅行社，想一起拼车去纳木错的，可车没拼上，只是留下对方的号码。几天后，她在住宿本登记时看到他的名字，同一天他们来到纳木错，他高反发烧，她去看他。夜里，她目送着他的车离开神湖，心里满是牵挂。 后来偶尔寒暄，两个人，一个广东，一个广西，不近也不远！一年后的偶然，他请她去看陈奕迅演唱会，她忽然觉得一年里断断续续的关心像是根绳索牵系着他们，她相信命运有时候是注定的！ 看演唱会那天，他们自然的牵着手，一场演唱会，她知道自己爱上他。今天，她做了他的妻，他曾是当地很有名气的电台主持人；而她，平凡不过的小女人。 幸福，有时候来得很突然！</div>
								<div style="display:none" iclass="l_img"><img id="love_img" src="img/13759555305883941.png" alt="明星故事" /> </div>
								<div style="display:none" class="l_img1">
								</div>
							</li>
							</a>
						
							<a href="javascript:;">
							<li class="love_item">
								<img src="img/13759554654676998.png" class="reallove_xqimg1" alt="明星故事" style="width:200px; height:200px;" />
								<div class="reallove_story_font"><span class="l_date">2013-08-08 </span><br/><span class="l_title">青梅竹马</span></div>
								<div class="l_txt" style="display:none">同一家医院，同一间产房。我们走过小学中学，大学分开，再重逢的2013.1.4告白，原来他坚持爱了我16年。将一生四分之一的时间情绪和爱，放在我一个人身上，一心一意是全世界最温柔的力量。他说我嘴角上扬是一生的守护，我们是烙印情人。我在等160天后他的归来，走在红毯那一天。从学生时代直到婚姻殿堂，从心动到古稀。先森和我一起走过婴儿时期青春年华直到一生。</div>
								<div style="display:none" iclass="l_img"><img id="love_img" src=" img/13759554654676998.png" alt="明星故事" /> </div>
								<div style="display:none" class="l_img1">
								</div>
							</li>
							</a>
						</div>
						
						<div id="divid_13" style="display:none" >
							<a href="javascript:;">
							<li class="love_item">
								<img src="img/13759553059986992.png" class="reallove_xqimg1" alt="明星故事" style="width:200px; height:200px;" />
								<div class="reallove_story_font"><span class="l_date">2013-08-08 </span><br/><span class="l_title">相濡以沫的爱</span></div>
								<div class="l_txt" style="display:none">弱水三千，但取一瓢。情感里的执着忠诚，对于一个坚信选择的人来说，从来不是一件难事。十多年前，我们尚且年轻，不曾体会真爱其实未必没有伤害，误会纷争，反复纠缠；日常琐事，皆可成怨；一路走来的时光里，记忆深刻的仍旧是那些最初的心动，和相濡以沫的细节种种。我们的相识源于欣赏，我们的感情历经考量，我们的日子慢慢闪亮，我们的光阴也将静静酝酿，成酒成蜜或者诗行，在老去时，摇椅上，缓缓摇晃……</div>
								<div style="display:none" iclass="l_img"><img id="love_img" src=" img/13759553059986992.png" alt="明星故事" /> </div>
								<div style="display:none" class="l_img1">
								</div>
							</li>
							</a>
						
							<a href="javascript:;">
							<li class="love_item">
								<img src="img/13759552685146002.png" class="reallove_xqimg1" alt="明星故事" style="width:200px; height:200px;" />
								<div class="reallove_story_font"><span class="l_date">2013-08-08 </span><br/><span class="l_title">原来你一直都在</span></div>
								<div class="l_txt" style="display:none">2003年 ， 那年他花光了所有的零用钱给我买吃的，考试帮我作弊。 我不爱他，但是感动、温暖。于是我把零用钱都给了他保管。那时初恋很简单就是不吃国家补贴的伙食，去小弄堂两人吃一份盖浇饭。但是，后来因为同学的调皮，我觉得他不够男人和他分手。 他一句话也没说就走了。2009年偶然碰到，他说每年我生日都会给我发生日快乐！每次，我的一句“你是谁”？他都伤到， 后来我在萧山教瑜伽。他还没毕业，坐了几个小时公交车来看我。 我没下课，他就站外面等我。 那刻 ，我们什么都没说就牵手了。不同的是，不是因为感动。而是因为爱。现在，我们有了自己的宝宝，谢谢他！一直都在那里！</div>
								<div style="display:none" iclass="l_img"><img id="love_img" src="img/13759552685146002.png" alt="明星故事" /> </div>
								<div style="display:none" class="l_img1">
								</div>
							</li>
							</a>
						
							<a href="javascript:;">
							<li class="love_item">
								<img src="img/13759547758928162.png" class="reallove_xqimg1" alt="明星故事" style="width:200px; height:200px;" />
								<div class="reallove_story_font"><span class="l_date">2013-08-08 </span><br/><span class="l_title">四川地震中的佳缘</span></div>
								<div class="l_txt" style="display:none">雅安正在经历苦痛。对于roseonly而言，我们一直在寻找最能给人以信心与能量的人与事，抑或是一个场景。在信.望.爱中，爱为最大。有幸，我们收到了这样一段看似平淡，却直击人心的爱情故事，于地震中相识，于生活中交集。&nbsp;&nbsp;爱，不可用于作秀。&nbsp;2008年的汶川地震，让我们认识。当时正值5.12之后大批骨折和内脏受损伤员运抵重医附二院手术和休整，我们在医院做志愿者时相识，更巧的是&nbsp;我们在同个学校，于是开始了一个普通的校园恋爱故事。磕磕绊绊中走到结婚相守的这一天:我拥有梦想中的婚纱照，最简单的背景，有最美的花。&nbsp;&nbsp;如今，四川再度地震，希望roseonly将我们的故事给于大家：雅安加油。和五年前一样，我们依然挂念，依然落泪，我们伸出的手依然滚烫，相信，苦难之中，有幸福所在。除了救生命于水火中，我们更需要正能量。</div>
								<div style="display:none" iclass="l_img"><img id="love_img" src=" img/13759547758928162.png" alt="明星故事" /> </div>
								<div style="display:none" class="l_img1">
								</div>
							</li>
							</a>
						
						</div>
						
				</ul>
				<a onclick="divshow();" class="star_all1" id="showbut">查看更多</a>
				<div class="clear"></div>
				
				
			</div>
		</div>
		
	</body>

</html>
