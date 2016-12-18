项目需求分析
基于Android的婴幼儿养育系统设计与实现

1引言	2
1.1编写目的	2
1.2背景	2
1.3技术要点	3
1.4参考资料	4
2任务概述	4
2.1目标	4
2.2用户的特点	4
2.3假定和约束	4
3需求规定	5
3.1对功能的规定	5
3.2对性能的规定	7
3.3输人输出要求	8
3.4数据管理能力要求	8
3.5故障处理要求	8
3.6其他专门要求	9
4运行环境规定	9
4.1设备	9
4.2支持软件	10
4.3接口	10
4.4控制	10

1引言
1.1编写目的
编写本说明书的目的在于明确婴幼儿养育系统的需求，明确系统需要实现的具体功能，系统运行所需的相应软硬件环境，系统数据的输入输出要求，把这些内容以书面的方式描述出来，项目开展和检查项目工作的依据。为系统数据库结构设计、编码实现以及测试提供基础的指导。
1.2背景
如今移动互联网技术日趋成熟，为了更好的提供育儿知识、育儿产品和早教服务等信息，基于Android的婴幼儿养育系统为关注的年轻父母、幼儿未来,让孩子在生理、心理上健康茁壮地成长起来。
	待开发的软件系统的名称：基于Android的婴幼儿养育系统
	开发者：马增群
	用户：APP用户
	实现该系统基于C/S结构
1.3技术要点
【系统简介】
	系统框架为：SpringMVC +Spring+ Mybaits  SSM框架组合
	Android开源组件:Volley、Universal-image-loader、Butterknife
	操作平台:Android2.3，Android4.0及以上版本
	开发工具:Android Studio、SQLyog、SecureCRT、WinSCP
	建模工具:Rotation Rose
	数据库:MySQL
	版本控制系统:SVN和Git
【技术点】
1、导出Excel文件
2、MD5加密SHA加密，接口加密身份验证
3、数据库连接池,阿里的druid。Druid在监控、可扩展性、稳定性和性能方面都有明显的优势,支持并发    
4、加入安全框架 shiro (登录授权)(session管理)
5、app接口@ResponseBody（支持与其它语言数据交互）
6、java websocket 即时通讯技术，点对点，群聊，单聊
7、HTML5 + JAVAEE  WebSocket 通信技术，WebSocket 验证用户登录，强制某用户下线
8、服务器内部GET POST 请求
9、uploadify 上传插件，单条、批量上传多线程，带进度条，异步，图片、视频, 其它文件格式均可上传
10、百度富文本编辑器，可上传图片

1.4参考资料
[1] 李智慧著. 大型网站技术架构[M]. 北京：电子工业出版社，2014.05
[2] 李刚著. 轻量级JavaEE企业应用实战[M]. 北京：电子工业出版社，2012
[3] 周志明著. 深入理解Java虚拟机. 北京：机械工业出版社，2014.11
[4] 任玉刚著. Android开发艺术探索. 北京：电子工业出版社，2015.09
[5] 李刚著. 经典JavaEE企业应用实战. 北京：电子工业出版社，2010.10
[6] 张海藩，倪宁. 软件工程[M]. 北京：人民邮电出版社，2010
[7] 陈志泊，王春玲.数据库原理及应用教程[M]. 北京：人民邮电出版社，2008
[8] 丁旭. 基于B/S架构的软件项目实训 JSP[M]. 北京：北京交通大学出版社，2011
[9] (美）马丁. 代码整洁之道[M]. 北京：人民邮电出版社，2010
[10] 温谦，赵伟，胡静，李占波. 网页制作综合技术教程[M]. 北京：人民邮电出版社，2009
2任务概述
2.1目标
定义婴幼儿养育系统需要实现哪些功能，以及这些功能实现时的具体逻辑和需要注意事项。
2.2用户的特点
本系统的用户：即APP用户，即该安卓平台的使用者。他们可以使用手机端进行浏览育儿信息和进行其他操作
2.3假定和约束
开发期限：本系统的开发期限为3个月，为保证系统的正常运行，开发完成后还有进行一系列的测试，预计2017年12月底完成第一版本。
3需求规定
3.1对功能的规定
3.1.1系统总体需求
3.1.2 APP功能模块：
 
 ![这里写图片描述](http://img.blog.csdn.net/20161218211124237?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxNDQyNzM5MQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
									
![这里写图片描述](http://img.blog.csdn.net/20161218211142567?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxNDQyNzM5MQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


![这里写图片描述](http://img.blog.csdn.net/20161218211202254?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxNDQyNzM5MQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


![这里写图片描述](http://img.blog.csdn.net/20161218211214989?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxNDQyNzM5MQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)



![这里写图片描述](http://img.blog.csdn.net/20161218211225536?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxNDQyNzM5MQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


![这里写图片描述](http://img.blog.csdn.net/20161218211236755?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxNDQyNzM5MQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

	查看育儿产品介绍：不需要登录。用户可在应用中查看育儿产品介绍，以瀑布流的形式展示产品，并且提供多种产品浏览方式，系统会推送特价产品，用户可以在线购买
	查看宝宝知识专题：不需要登录。用户可以分类查找各种育儿知识。
	热点关注：不需要登录。系统会根据用户的点击量等推送优质的信息
	成长阶梯：用户可以记录宝宝成长过程的一些数据和照片等等，有趣实用
	音乐教育：系统有早教音乐、胎教音乐等等的推送，用户可以使用软件给宝宝听音乐
	圈子互动：系统以各种兴趣圈子的形式，让用户可以根据自己的兴趣，加入圈子，进行交流分享，同时可以在线问答，用户进行多一点互动
 

