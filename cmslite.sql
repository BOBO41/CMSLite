-- MySQL dump 10.13  Distrib 5.7.22, for Win64 (x86_64)
--
-- Host: localhost    Database: cmslite
-- ------------------------------------------------------
-- Server version	5.7.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `id` bigint(11) unsigned NOT NULL DEFAULT '0' COMMENT '文章ID',
  `del` bit(1) NOT NULL DEFAULT b'0' COMMENT '已删除',
  `add_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '添加时间',
  `title` varchar(36) NOT NULL DEFAULT '' COMMENT '标题',
  `spec` varchar(200) NOT NULL DEFAULT '' COMMENT '简约说明',
  `img_url` varchar(100) NOT NULL DEFAULT '' COMMENT '主图',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (44389699258679297,'\0','2019-04-24 03:38:49.148','The successful 124th Canton Fair ','CCH with furniture hardware fittings in Canton fair,Oct 15th-19th,2018','/demodata/article1.jpg'),(44403065196904449,'\0','2019-04-24 07:06:17.176','2019 Malaysia Furniture Fair','This is Malaysia International Furniture Fair which held in Kuala Lumpur from March 8 to 11, 2019.','/demodata/article2.jpg'),(44482209633009665,'\0','2019-04-25 03:34:46.149','2019 CIFF','This is 41st China (Guangzhou) International Furniture Fair be held at the Pazhou Exhibition hall in Guangzhou from March 28 to 31, 2019.','/demodata/article3.jpg');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_ex`
--

DROP TABLE IF EXISTS `article_ex`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article_ex` (
  `id` bigint(11) unsigned NOT NULL DEFAULT '0' COMMENT '产品ID',
  `del` bit(1) NOT NULL DEFAULT b'0' COMMENT '已删除',
  `add_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '添加时间',
  `content` longtext NOT NULL COMMENT '产品详情描述',
  `keyword` varchar(255) NOT NULL DEFAULT '',
  `description` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_ex`
--

LOCK TABLES `article_ex` WRITE;
/*!40000 ALTER TABLE `article_ex` DISABLE KEYS */;
INSERT INTO `article_ex` VALUES (44389699258679297,'\0','2019-04-24 03:38:49.148','<p style=\"text-align: left;\"><span style=\"color: #000000;\">The first phase of the 124th Canton Fair in 2018 (October 15-19, 2018) was successfully concluded. At the exhibition, the new furniture hardware brought by the &nbsp;CCH ushered in the attention of many buyers.<br /></span><br /><img class=\"img-fluid\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190424/44389041054941185.jpg\" /><br /><span style=\"color: #000000;\">In addition to cabinet hinges and drawer slides with huge market demand, furniture handles, furniture tables and office accessories are also very popular at the show.</span><span style=\"color: #000000;\">CCH\' products cover furniture hardware products to meet the different needs of different customers.<br /></span><br /><img class=\"img-fluid\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190424/44389489879023617.jpg\" /><br /><span style=\"color: #000000;\">Although Canton Fair is end , the story of you and CCH Hardware &nbsp;continues.</span><span style=\"color: #000000;\">For more information about the products you like at the show, please visit the CCH\'S Showroom in Guangzhou.<br /></span><br /><img class=\"img-fluid\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190424/44389055013584897.jpg\" /><br /><span style=\"color: #000000;\">Address:</span><br /><span style=\"color: #000000;\">3rd Floor, Building F, No. 29 Tonghe Tongbao Road, Baiyun District, Guangzhou.<br /></span>Looking forward to your visit.&nbsp;<br /><br /></p>','Canton fair,company news, about us','This is 124th Canton Fair'),(44403065196904449,'\0','2019-04-24 07:06:17.176','<p><span style=\"color: #000000;\">On the evening of March 6,2019， the company manager and business representatives went to Malaysia to participate in the furniture exhibition, and then arranged the booth to welcome tomorrow\'s coming .<br /><br /><img class=\"img-fluid\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190424/44400929524416513.jpg\" /></span><br /><span style=\"color: #000000;\">The purple exhibition decoration has attracted a lot of buyers, table legs, wire boxes, line tubes and other office accessories are the most popular. New products: Intelligent shutter cabinets have also attracted the attention of many people.</span><span style=\"color: #000000;\">During 8th to 11th, a four-day exhibition,we have met many old customers and have achieved great results.Although the show is over,the story of you and CCH Hardware still continues.<br /><br /><img class=\"img-fluid\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190424/44401624235376641.jpg\" /></span><br /><span style=\"color: #000000;\">For more information about the products you like at the show, welcome to visit the CCH Hardware\'s Showroom in Guangzhou.<br /><br /><img class=\"img-fluid\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190424/44401782075424769.jpg\" /></span><br /><span style=\"color: #000000;\">address:</span><br /><span style=\"color: #000000;\">3rd Floor, Building F, No. 29 Tonghe Tongbao Road, Baiyun District, Guangzhou<br />LOOKING FORWARD TO UR VISIT&nbsp;</span></p>','fair,exhibition',''),(44482209633009665,'\0','2019-04-25 03:34:46.149','<p>On March 31, the four-day 41st China (Guangzhou) International Furniture Fair was a complete success.CCH Hardware has once again won the praise of domestic and foreign merchants.<br /><br /><img class=\"img-fluid\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190425/44481287288782849.jpg\" /><br />In the four days of the exhibition, the elites of CCH have been providing professional products for many customers in more than 30 countries and regions at home and abroad to establish friendly business relationships<br /><br /><img class=\"img-fluid\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190425/44481327017230337.jpg\" /><br />Our new products: kitchen smart louver hanging cabinet has attracted the attention of many buyers, cabinet accessories, office accessories: wire boxes, line tubes and other products are also very popular.<br /><br /><img class=\"img-fluid\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190425/44481936902586369.jpg\" /><br />Thank you for visiting the booth of CCH <br />Want to know more about the product<br />Contact us by following the information below<br />Address:&nbsp;3rd Floor, Building F, No. 29 Tonghe Tongbao Road, Baiyun District, Guangzhou<br />TEL:&nbsp;86 -13922346566 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;E-mai: <a href=\"mailto:cch.gz@139.com\" target=\"_blank\" rel=\"noopener\">cch.gz@139.com</a><br /><br /><img class=\"img-fluid\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190425/44481707121836033.jpg\" /></p>','fair show, fair,','2019 exhibition');
/*!40000 ALTER TABLE `article_ex` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `banner`
--

DROP TABLE IF EXISTS `banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `banner` (
  `id` bigint(11) unsigned NOT NULL DEFAULT '0' COMMENT 'bannerID',
  `del` bit(1) NOT NULL DEFAULT b'0' COMMENT '已删除',
  `add_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '添加时间',
  `title` varchar(30) NOT NULL DEFAULT '' COMMENT '标题',
  `content` varchar(225) NOT NULL DEFAULT '' COMMENT '描述',
  `img_url` varchar(225) NOT NULL DEFAULT '' COMMENT 'D?',
  `sort` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  `link` varchar(255) NOT NULL DEFAULT '' COMMENT '超链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banner`
--

LOCK TABLES `banner` WRITE;
/*!40000 ALTER TABLE `banner` DISABLE KEYS */;
INSERT INTO `banner` VALUES (43117558936633345,'\0','2019-04-10 10:32:36.917','- 2 -','','/demodata/banner2.jpg',2,''),(44389745429577729,'\0','2019-04-24 03:39:32.503','- 1 -','','/demodata/banner1.jpg',1,'');
/*!40000 ALTER TABLE `banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `block`
--

DROP TABLE IF EXISTS `block`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `block` (
  `id` bigint(11) unsigned NOT NULL DEFAULT '0' COMMENT '区块ID',
  `del` bit(1) NOT NULL DEFAULT b'0' COMMENT '已删除',
  `add_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '添加时间',
  `content` longtext NOT NULL COMMENT '详情数据',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '名称',
  `description` varchar(225) NOT NULL DEFAULT '' COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `block`
--

LOCK TABLES `block` WRITE;
/*!40000 ALTER TABLE `block` DISABLE KEYS */;
INSERT INTO `block` VALUES (41787146645798913,'\0','2019-03-27 02:21:53.814','<footer class=\"py-4 bg-dark\" style=\"background-color: #e9ecef !important;\">\n<div class=\"container\">\n<p class=\"m-0 text-center text-white\" style=\"color: #6c757d !important;\"><strong><span style=\"color: #67409d;\">Copyright &copy; 2019 - CCH</span></strong></p>\n</div>\n</footer>','页脚','网站底部代码'),(41788914024841217,'\0','2019-03-27 02:49:19.004','<section id=\"contact2\" class=\"page-section\">\n<div class=\"container\">\n<div class=\"row justify-content-center\">\n<div class=\"col-lg-8 text-center\">\n<h2 class=\"mt-0\"><strong><span style=\"color: #6f37a3;\">Let\'s Get In Touch!</span></strong></h2>\n<hr class=\"divider my-4\" />\n<p class=\"text-muted mb-5\" style=\"color: #6c757d !important;\">Ready to start your next project with us? Give us a call or send us an email and we will get back to you as soon as possible!</p>\n</div>\n</div>\n<div class=\"row\">\n<div class=\"col-lg-4 ml-auto text-center\"><em class=\"fas fa-address-card fa-3x mb-3 text-muted\" style=\"color: #6c757d !important;\"> <!-- i --> </em> <!-- Make sure to change the email address in anchor text AND the link below! -->\n<div><span style=\"color: #000000;\">Rm. 302, Building F, 29 Tongbao Road, Tonghe Subdistrict, Baiyun Dist., Guangzhou</span></div>\n</div>\n<div class=\"col-lg-4 ml-auto text-center\"><em class=\"fas fa-phone fa-3x mb-3 text-muted\" style=\"color: #6c757d !important;\"> <!-- i --> </em>\n<div><span style=\"color: #000000;\">+86 13922346566</span></div>\n</div>\n<div class=\"col-lg-4 mr-auto text-center\"><em class=\"fas fa-envelope fa-3x mb-3 text-muted\" style=\"color: #6c757d !important;\"> <!-- i --> </em> <!-- Make sure to change the email address in anchor text AND the link below! --> <strong><span style=\"color: #67409d;\"><a class=\"d-block\" style=\"color: #67409d;\" href=\"mailto:cch.gz@139.com\">cch.gz@139.com</a></span></strong></div>\n</div>\n</div>\n</section>','联系信息','首页上的底部的联系信息'),(41803997949984769,'\0','2019-03-27 06:43:27.459','<div class=\"container\" style=\"padding: 10px;\">\n<div class=\"row\">\n<div class=\"col-lg-6\">\n<h2><span style=\"color: #602699;\">Market Range</span></h2>\n<p>&nbsp;</p>\n<p>&nbsp;<strong>Asia&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Europe</strong></p>\n<p><strong>&nbsp;Middle East &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; North America</strong></p>\n<p><strong>&nbsp;Southeast Asia &nbsp; &nbsp; &nbsp; &nbsp;South America etc.</strong></p>\n<p>The company is mainly engaged in export trade, with annual exports accounting for 90% of total exports.We have our export term,support OEM，has been recognized by customers in many countries for more than 10 years. We sincerely hope to cooperate closely with both domestic and foreign friends for mutual benefit.</p>\n<h2>&nbsp; &nbsp; &nbsp; &nbsp;</h2>\n<p>&nbsp;</p>\n</div>\n<div class=\"col-lg-6\"><img class=\"img-fluid rounded\" src=\"http://www.cchcch.com:8080/resources/20190427/44689463279878145.jpg\" /></div>\n</div>\n<!-- /.row --></div>','市场范围',''),(43267799040131073,'\0','2019-04-12 01:24:38.960','<div class=\"row\">\n<div class=\"col-lg-6\"><img class=\"wscnph\" src=\"http://www.cchcch.com:8080/resources/20190416/43643357422944257.jpg\" /></div>\n<div class=\"col-lg-6\">\n<h2><span style=\"color: #6f37a3;\"><strong>About CCH HARDWARE&nbsp;</strong></span></h2>\n<p><strong>China Connection Hardware Co.,Ltd</strong> is professional manufacturing and exporting furniture hardware and kitchen fittings with experience over 10 years.<br /><br />Our product mainly include furniture handle,office desk fittings,table leg,drawer slide,hinge,kitchen basket etc. furniture and kitchen hardware fittings.We have our export term,support OEM and export to Southeast East,Russia,Europe and America,etc.With the professionalism of \"one-on, professional and dedicated\", we will create a harmonious and comfortable modern home environment for our customers. It is the long-term pursuit of our company\'s social value.<br /><br />CCH also have extensive experience in exhibiting: Canton Fair, Furniture Fair and other foreign fair to work closely with domestic and foreign friends for mutual benefit.</p>\n</div>\n</div>','介绍内容','关于我们页的介绍内容'),(43268543143215105,'\0','2019-04-12 01:36:11.410','<section id=\"about\">\n<div class=\"container\">\n<div class=\"row\">\n<div class=\"col-lg-12 text-center\">\n<h2 class=\"section-heading text-uppercase\"><br /><strong><span style=\"color: #67409d;\">Exhibition SHOW</span></strong></h2>\n<h3 class=\"section-subheading text-muted\"><span style=\"color: #000000;\">Experienced exhibitors</span></h3>\n</div>\n</div>\n<div class=\"row\">\n<div class=\"col-lg-12\">\n<ul class=\"timeline\">\n<li>\n<div class=\"timeline-image\"><img class=\"rounded-circle img-fluid\" src=\"http://www.cchcch.com:8080/resources/20190417/43735925779333121.jpg\" /></div>\n<div class=\"timeline-panel\">\n<div class=\"timeline-heading\">\n<h4><span style=\"color: #67409d;\">2013-2014</span><br /><span style=\"color: #67409d;\">China International Furniture Fair(Guangzhou)-CIFF</span></h4>\n</div>\n<div class=\"timeline-body\">\n<p class=\"text-muted\"><span style=\"color: #000000;\">CIFF is Held every March,CCH company&nbsp;participate every year and meet with our new and old customers.</span></p>\n</div>\n</div>\n</li>\n<li class=\"timeline-inverted\">\n<div class=\"timeline-image\"><img class=\"rounded-circle img-fluid\" src=\"http://www.cchcch.com:8080/resources/20190417/43736505599918081.jpg\" /></div>\n<div class=\"timeline-panel\">\n<div class=\"timeline-heading\">\n<h4><span style=\"color: #67409d;\">2014-2017 China Import and Export Fair (Canton Fair)</span></h4>\n<p><span style=\"color: #000000;\">The Canton Fair is held in April and October each year.Every year our company will participate twice.</span></p>\n</div>\n</div>\n</li>\n<li>\n<div class=\"timeline-image\"><img class=\"rounded-circle img-fluid\" src=\"http://www.cchcch.com:8080/resources/20190417/43736951202775041.jpg\" /></div>\n<div class=\"timeline-panel\">\n<div class=\"timeline-heading\">\n<h4><span style=\"color: #67409d;\">2018</span><br /><span style=\"color: #67409d;\">CIFF &amp; Canton Fair</span></h4>\n</div>\n<div class=\"timeline-body\">\n<p class=\"text-muted\"><span style=\"color: #000000;\">Every year we participate in these two major exhibitions to meet and cooperate with more customers.</span></p>\n</div>\n</div>\n</li>\n<li class=\"timeline-inverted\">\n<div class=\"timeline-image\"><img class=\"rounded-circle img-fluid\" src=\"http://www.cchcch.com:8080/resources/20190417/43737273325322241.jpg\" /></div>\n<div class=\"timeline-panel\">\n<div class=\"timeline-heading\">\n<h4><span style=\"color: #67409d;\">2019 Malaysia International Furniture Fair &amp; CIFF</span> &nbsp;</h4>\n</div>\n<div class=\"timeline-body\">\n<p class=\"text-muted\"><span style=\"color: #000000;\">We not only participate in domestic exhibitions, but we also participate in foreign exhibitions.Looking to the world and the future,CCH Hardware sincerely hopes to work closely with domestic and foreign friends for mutual benefit,to share the joy of success together !</span></p>\n</div>\n</div>\n</li>\n<li class=\"timeline-inverted\">\n<div class=\"timeline-image\">\n<h4><span style=\"color: #67409d;\">Be Part </span><br /><span style=\"color: #67409d;\">Of Our </span><br /><span style=\"color: #67409d;\">Story!</span></h4>\n</div>\n</li>\n</ul>\n</div>\n</div>\n</div>\n</section>','展会历程','关于我们页里展会的介绍'),(43268614010175489,'\0','2019-04-12 01:37:17.895','<section id=\"team\" class=\"bg-light\">\n<div class=\"container\">\n<div class=\"row\">\n<div class=\"col-lg-12 text-center\">\n<h2 class=\"section-heading text-uppercase\"><strong><span style=\"color: #67409d;\">SHOW ROOM</span></strong></h2>\n<h3 class=\"section-subheading text-muted\"><span style=\"color: #000000;\">Product display area</span></h3>\n</div>\n</div>\n<div class=\"row\">\n<div class=\"col-sm-4\">\n<div class=\"team-member\"><img class=\"mx-auto rounded-circle\" src=\"http://www.cchcch.com:8080/resources/20190417/43740596556267521.jpg\" /><br />\n<h4>Chat Area</h4>\n<p class=\"text-muted\">&nbsp;</p>\n</div>\n</div>\n<div class=\"col-sm-4\">\n<div class=\"team-member\"><img class=\"mx-auto rounded-circle\" src=\"http://www.cchcch.com:8080/resources/20190417/43740609441169409.jpg\" /><br />\n<h4>Office fittings area</h4>\n<p class=\"text-muted\">&nbsp;</p>\n</div>\n</div>\n<div class=\"col-sm-4\">\n<div class=\"team-member\"><img class=\"mx-auto rounded-circle\" src=\"http://www.cchcch.com:8080/resources/20190417/43740623399813121.jpg\" /><br />\n<h4>&nbsp; &nbsp; Hardware fittings area</h4>\n<p class=\"text-muted\">&nbsp;</p>\n</div>\n</div>\n</div>\n<div class=\"row\">\n<div class=\"col-lg-8 mx-auto text-center\">\n<p class=\"large text-muted\"><span style=\"color: #000000;\">The company\'s showroom has a full range of products：office fittings, wardrobe accessories, cabinet fittings and other furniture hardware accessories ,allowing customers to experience the quality of products.We sincerely welcome your visit.</span></p>\n</div>\n</div>\n</div>\n</section>','展厅展示','关于我们页的我们的展厅介绍'),(43268769702739969,'\0','2019-04-12 01:39:42.224','<section class=\"bg-light\"><!-- Our Customers -->\n<div class=\"row\">\n<div class=\"col-lg-12 text-center\">\n<h2 class=\"section-heading text-uppercase\"><strong><span style=\"color: #67409d;\">Company Activities</span></strong></h2>\n<h3 class=\"section-subheading text-muted\">Colorful corporate events</h3>\n</div>\n</div>\n<div class=\"row\">\n<div class=\"col-lg-2 col-sm-4 mb-4\"><img class=\"img-fluid\" src=\"http://www.cchcch.com:8080/resources/20190417/43738198890774529.jpg\" />&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</div>\n<div class=\"col-lg-2 col-sm-4 mb-4\"><img class=\"img-fluid\" src=\"http://www.cchcch.com:8080/resources/20190417/43742249044934657.jpg\" /></div>\n<div class=\"col-lg-2 col-sm-4 mb-4\"><img class=\"img-fluid\" src=\"http://www.cchcch.com:8080/resources/20190417/43739577575276545.jpg\" /></div>\n<div class=\"col-lg-2 col-sm-4 mb-4\"><img class=\"img-fluid\" src=\"http://www.cchcch.com:8080/resources/20190417/43742259782352897.jpg\" /></div>\n<div class=\"col-lg-2 col-sm-4 mb-4\"><img class=\"img-fluid\" src=\"http://www.cchcch.com:8080/resources/20190417/43742053623922689.jpg\" /></div>\n<div class=\"col-lg-2 col-sm-4 mb-4\"><img class=\"img-fluid\" src=\"http://www.cchcch.com:8080/resources/20190417/43739761185128449.jpg\" /></div>\n</div>\n</section>','公司活动','关于我们页的公司活动介绍');
/*!40000 ALTER TABLE `block` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalog`
--

DROP TABLE IF EXISTS `catalog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `catalog` (
  `id` bigint(11) unsigned NOT NULL DEFAULT '0' COMMENT '产品分类ID',
  `del` bit(1) NOT NULL DEFAULT b'0' COMMENT '已删除',
  `add_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '添加时间',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '分类名称',
  `parent_id` bigint(11) unsigned NOT NULL DEFAULT '0' COMMENT '上级分类ID',
  `left_id` bigint(11) unsigned NOT NULL DEFAULT '0' COMMENT '左节点',
  `right_id` bigint(11) unsigned NOT NULL DEFAULT '0' COMMENT '右节点',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalog`
--

LOCK TABLES `catalog` WRITE;
/*!40000 ALTER TABLE `catalog` DISABLE KEYS */;
INSERT INTO `catalog` VALUES (42931406464090113,'\0','2019-04-08 10:23:08.819','Kitchen Fittings',0,0,42932195664330753),(42931454782472193,'\0','2019-04-08 10:23:53.220','Cabinet Basket ',42931406464090113,0,42931557861687297),(42931483773501441,'\0','2019-04-08 10:24:20.421','Cutlery Tray',42931406464090113,44760002749005825,42931498805886977),(42931498805886977,'\0','2019-04-08 10:24:34.543','Anti-slip Mat',42931406464090113,42931483773501441,0),(42931557861687297,'\0','2019-04-08 10:25:29.395','Waste Bin',42931406464090113,42931454782472193,44760002749005825),(42931687784448001,'','2019-04-08 10:27:30.508','Safe box',42931406464090113,42931498805886977,44760002749005825),(42931800527339521,'\0','2019-04-08 10:29:15.278','Smart Wardrobe ',0,42932195664330753,44760971264131073),(42931816633466881,'','2019-04-08 10:29:30.547','Cloth Tubing',42931800527339521,0,42931828444626945),(42931828444626945,'','2019-04-08 10:29:41.961','Cloth Socket',42931800527339521,0,44759449771966465),(42931847771979777,'','2019-04-08 10:29:59.084','Wardrobe Basket ',42931800527339521,0,42931816633466881),(42932195664330753,'\0','2019-04-08 10:35:23.559','Office Fittings',0,42931406464090113,42931800527339521),(42932227876585473,'\0','2019-04-08 10:35:53.375','Desk Grommet ',42932195664330753,0,42932241835229185),(42932241835229185,'\0','2019-04-08 10:36:06.670','Desk Accessories',42932195664330753,42932227876585473,44759564662341633),(42932340619476993,'\0','2019-04-08 10:37:38.451','Other Fittings',0,44760971264131073,0),(42932355651862529,'','2019-04-08 10:37:52.286','Table leg series',42932340619476993,0,42932377126699009),(42932377126699009,'\0','2019-04-08 10:38:12.598','Drawer Slide',42932340619476993,0,42932385716633601),(42932385716633601,'\0','2019-04-08 10:38:20.761','Hinge ',42932340619476993,42932377126699009,43022442590896129),(42932431887532033,'\0','2019-04-08 10:39:03.676','Caster',42932340619476993,42932473763463169,42932455509852161),(42932442624950273,'','2019-04-08 10:39:13.572','Skirting board ',42932340619476993,42932431887532033,42932455509852161),(42932455509852161,'\0','2019-04-08 10:39:25.531','Cabinet Lock',42932340619476993,42932431887532033,42932594022547457),(42932473763463169,'\0','2019-04-08 10:39:42.200','Door Seal Brush',42932340619476993,42932488795848705,42932431887532033),(42932488795848705,'\0','2019-04-08 10:39:56.316','Cabinet Stay',42932340619476993,42932519934361601,42932473763463169),(42932507049459713,'','2019-04-08 10:40:13.226','Cabinet Hanger ',42932340619476993,42932594022547457,42932529598038017),(42932519934361601,'\0','2019-04-08 10:40:25.227','Air Vent ',42932340619476993,43022442590896129,42932488795848705),(42932529598038017,'\0','2019-04-08 10:40:34.487','Cabinet Buffer',42932340619476993,44291732128399361,42932555367841793),(42932555367841793,'\0','2019-04-08 10:40:58.119','Sliding Wheel',42932340619476993,42932529598038017,42932576842678273),(42932566105260033,'','2019-04-08 10:41:08.072','Board Support ',42932340619476993,42932555367841793,42932576842678273),(42932576842678273,'\0','2019-04-08 10:41:18.811','Glass clamp',42932340619476993,42932555367841793,42932586506354689),(42932586506354689,'\0','2019-04-08 10:41:27.110','Cabinet Catch ',42932340619476993,42932576842678273,42932630529769473),(42932594022547457,'\0','2019-04-08 10:41:34.446','Connector',42932340619476993,42932455509852161,44291732128399361),(42932607981191169,'','2019-04-08 10:41:47.664','Screw cover',42932340619476993,42932586506354689,42932630529769473),(42932620866093057,'','2019-04-08 10:41:59.684','PVC edge banding',42932340619476993,42932488795848705,42932473763463169),(42932630529769473,'\0','2019-04-08 10:42:08.922','Screw series ',42932340619476993,42932586506354689,0),(43022442590896129,'\0','2019-04-09 09:56:12.438','Handle ',42932340619476993,42932385716633601,42932519934361601),(43023315542999041,'','2019-04-09 10:09:45.825','Smart furniture ',42932340619476993,0,42932355651862529),(44291732128399361,'\0','2019-04-23 02:18:10.639','Chair nail ',42932340619476993,42932594022547457,42932529598038017),(44759449771966465,'\0','2019-04-28 03:18:06.734','Smart Mirror',42931800527339521,44764193563344897,44759491647897601),(44759491647897601,'\0','2019-04-28 03:18:45.041','Safe box',42931800527339521,44759449771966465,44759506680283137),(44759506680283137,'\0','2019-04-28 03:18:59.981','Smart Sliding',42931800527339521,44759491647897601,0),(44759564662341633,'\0','2019-04-28 03:19:53.953','Table leg',42932195664330753,42932241835229185,0),(44760002749005825,'\0','2019-04-28 03:26:41.188','Skirting Board',42931406464090113,42931557861687297,42931483773501441),(44760158441570305,'','2019-04-28 03:29:06.835','Wardrobe fitting',42931800527339521,0,44759449771966465),(44760175621439489,'','2019-04-28 03:29:22.144','Wardrobe basket ',44760158441570305,0,44760203538726913),(44760203538726913,'','2019-04-28 03:29:48.478','Cloth tubing',44760158441570305,0,44760798391697409),(44760798391697409,'','2019-04-28 03:39:02.631','Cloth Socket',44760158441570305,44760203538726913,0),(44760971264131073,'\0','2019-04-28 03:41:43.355','PVC Fittings',0,42931800527339521,42932340619476993),(44761055015993345,'\0','2019-04-28 03:43:01.822','Pvc edge banding',44760971264131073,0,44761066827153409),(44761066827153409,'\0','2019-04-28 03:43:12.115','Screw cover',44760971264131073,44761055015993345,0),(44764157056122881,'\0','2019-04-28 04:31:10.422','Wardrobe Basket',42931800527339521,0,44764169941024769),(44764169941024769,'\0','2019-04-28 04:31:22.409','Cloth tube',42931800527339521,44764157056122881,44764193563344897),(44764193563344897,'\0','2019-04-28 04:31:44.540','Tube socket',42931800527339521,44764169941024769,44759449771966465);
/*!40000 ALTER TABLE `catalog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `com_product`
--

DROP TABLE IF EXISTS `com_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `com_product` (
  `id` bigint(11) unsigned NOT NULL DEFAULT '0' COMMENT '区块ID',
  `del` bit(1) NOT NULL DEFAULT b'0' COMMENT '已删除',
  `add_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '添加时间',
  `content` varchar(500) NOT NULL COMMENT '详情数据',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '名称',
  `sort` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='产品组件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `com_product`
--

LOCK TABLES `com_product` WRITE;
/*!40000 ALTER TABLE `com_product` DISABLE KEYS */;
INSERT INTO `com_product` VALUES (41812369914986497,'\0','2019-03-27 08:53:24.579','1,2,3,4,5,6,7,8','Hot Products',0),(41812821960294401,'\0','2019-03-27 09:00:25.295','9,10,11,12,13,14,15,16','New Products',2),(41813598275633153,'\0','2019-03-27 09:12:28.700','17,18,19,20,21,22,23,24','Recommend ',1);
/*!40000 ALTER TABLE `com_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `id` bigint(11) unsigned NOT NULL DEFAULT '0' COMMENT 'messageID',
  `del` bit(1) NOT NULL DEFAULT b'0' COMMENT '已删除',
  `add_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '添加时间',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '联系人',
  `email` varchar(100) NOT NULL DEFAULT '' COMMENT '联系email',
  `mobile` varchar(30) NOT NULL DEFAULT '' COMMENT '手机',
  `content` varchar(500) NOT NULL DEFAULT '' COMMENT '消息',
  `status` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nav`
--

DROP TABLE IF EXISTS `nav`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nav` (
  `id` bigint(11) unsigned NOT NULL DEFAULT '0' COMMENT 'navID',
  `del` bit(1) NOT NULL DEFAULT b'0' COMMENT '已删除',
  `add_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '添加时间',
  `title` varchar(30) NOT NULL DEFAULT '' COMMENT '标题',
  `payload` varchar(500) NOT NULL DEFAULT '' COMMENT '参数json',
  `img_url` varchar(100) NOT NULL DEFAULT '' COMMENT '背景图',
  `sort` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  `content` varchar(100) NOT NULL DEFAULT '' COMMENT '简约描述',
  `type` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '类型0连接，1产品分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nav`
--

LOCK TABLES `nav` WRITE;
/*!40000 ALTER TABLE `nav` DISABLE KEYS */;
INSERT INTO `nav` VALUES (41633189248106497,'\0','2019-03-25 10:32:09.188','Catalog','/categories','',2,'Categories',0),(41806272135168001,'\0','2019-03-27 07:18:45.497','About','/about','',7,'About US',0),(41806291462520833,'\0','2019-03-27 07:19:03.483','Smart Wardrobe','42931800527339521','',5,'Smart furniture Wardrobe fittings',1),(43116389631787009,'\0','2019-04-10 10:14:27.439','Kitchen Fitting','42931406464090113','/resources/20190426/44570368131727361.jpg',3,'',1),(43782612073840641,'\0','2019-04-17 14:35:35.058','Contact','/#contact','',8,'Contact',0),(44569509138268161,'\0','2019-04-26 02:09:50.359','Office fitting','42932195664330753','/resources/20190426/44570541004161025.jpg',4,'Office fittings ',1),(44569577857744897,'\0','2019-04-26 02:10:54.372','news','/news','',6,'news',0);
/*!40000 ALTER TABLE `nav` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` bigint(11) unsigned NOT NULL DEFAULT '0' COMMENT '产品ID',
  `del` bit(1) NOT NULL DEFAULT b'0' COMMENT '已删除',
  `add_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '添加时间',
  `code` varchar(30) NOT NULL DEFAULT '' COMMENT '产品型号',
  `name` varchar(30) NOT NULL DEFAULT '' COMMENT '产品名称',
  `spec` varchar(30) NOT NULL DEFAULT '' COMMENT '规格',
  `barcode` varchar(30) NOT NULL DEFAULT '' COMMENT '条形码',
  `img_url` varchar(100) NOT NULL DEFAULT '' COMMENT '主图',
  `catalog_id` bigint(11) unsigned NOT NULL DEFAULT '0' COMMENT '分类ID',
  PRIMARY KEY (`id`),
  KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'\0','2019-04-09 08:45:57.915','CH11-AL001','Office desk grommet ','80/160/274*80','','/demodata/product1.jpg',42932227876585473),(2,'\0','2019-04-09 08:47:55.115','CH11-PVC006','Office desk grommet ','50/53/60/80','','/demodata/product2.jpg',42932227876585473),(3,'\0','2019-04-09 08:50:18.466','CH11-AL011-012','Office desk grommet ','200/250/300*130','','/demodata/product3.jpg',42932227876585473),(4,'\0','2019-04-09 08:52:34.721','CH11-AL013-014','Office desk grommet ','200/250/300*130','','/demodata/product4.jpg',42932227876585473),(5,'\0','2019-04-09 08:53:43.102','CH11-AL015','Office desk grommet ','300/400/500*110','','/demodata/product5.jpg',42932227876585473),(6,'\0','2019-04-09 08:55:19.154','CH11-AL016','Office desk grommet ','292/392/492*135','','/demodata/product6.jpg',42932227876585473),(7,'\0','2019-04-09 08:57:14.105','CH10-PVC014','Screen clamp ','16-18MM','','/demodata/product7.jpg',42932241835229185),(8,'\0','2019-04-09 08:58:17.540','CH10-AL015','Screen clamp ','16-18mm','','/demodata/product8.jpg',42932241835229185),(9,'\0','2019-04-09 08:59:13.349','CH10-AL016','Screen clamp','16-18MM','','/demodata/product9.jpg',42932241835229185),(10,'\0','2019-04-09 09:00:22.227','CH10-AL017','Screen clamp ','16-18MM','','/demodata/product10.jpg',42932241835229185),(11,'\0','2019-04-09 09:01:47.649','CH10-ABS041','Spring tube','55*300MM','','/demodata/product11.jpg',42932241835229185),(12,'\0','2019-04-09 09:02:44.873','CH10-ABS042','Wire collection tube ','750*65*35MM','','/demodata/product12.jpg',42932241835229185),(13,'\0','2019-04-09 09:03:40.608','CH10-ABS045','Wire collection tube ','750*65*45','','/demodata/product13.jpg',42932241835229185),(14,'\0','2019-04-09 09:04:32.124','CH10-ABS046','Wire collection tube ','750*60','','/demodata/product14.jpg',42932241835229185),(15,'\0','2019-04-09 09:06:22.088','CH10-PVC013','Office desk mat ','680-700*400-450','','/demodata/product15.jpg',42932241835229185),(16,'\0','2019-04-09 09:08:19.221','CH5-SS014','Kitchen cabinet basket ','865*495*(650-750)','','/demodata/product16.jpg',42931454782472193),(17,'\0','2019-04-09 09:10:16.549','CH6-PVC001','Kitchen waste bin ','480*342*418','','/demodata/product17.jpg',42931557861687297),(18,'\0','2019-04-09 09:11:38.303','CH6-PVC002','Kitchen waste bin','480*342*418','','/demodata/product18.jpg',42931557861687297),(19,'\0','2019-04-09 09:12:52.717','CH6-PVC005','Kitchen waste bin ','480*260*418','','/demodata/product19.jpg',42931557861687297),(20,'\0','2019-04-09 09:14:28.147','CH6-SS008','Kitchen waste bin ','8L','','/demodata/product20.jpg',42931557861687297),(21,'\0','2019-04-09 09:16:23.283','CH7-ABS013','Cutlery tray ','560-630*420-500*50','','/demodata/product21.jpg',42931483773501441),(22,'\0','2019-04-09 09:17:45.547','CH7-SS00140','Cutlery tray ','280*372/422/472*64','','/demodata/product22.jpg',42931483773501441),(23,'\0','2019-04-09 09:19:23.585','CH8-EVA','Anti-slip mat','400gsw-1000','','/demodata/product23.jpg',42931498805886977),(24,'\0','2019-04-09 09:20:40.010','CH8-PO','Anti-slip mat','400-1000gsw','','/demodata/product24.jpg',42931498805886977);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_ex`
--

DROP TABLE IF EXISTS `product_ex`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_ex` (
  `id` bigint(11) unsigned NOT NULL DEFAULT '0' COMMENT '产品ID',
  `del` bit(1) NOT NULL DEFAULT b'0' COMMENT '已删除',
  `add_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '添加时间',
  `content` longtext NOT NULL COMMENT '产品详情描述',
  `img_url_a` varchar(100) NOT NULL DEFAULT '' COMMENT '副图1',
  `img_url_b` varchar(100) NOT NULL DEFAULT '' COMMENT '副图2',
  `img_url_c` varchar(100) NOT NULL DEFAULT '' COMMENT '副图3',
  `keyword` varchar(255) NOT NULL DEFAULT '',
  `description` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_ex`
--

LOCK TABLES `product_ex` WRITE;
/*!40000 ALTER TABLE `product_ex` DISABLE KEYS */;
INSERT INTO `product_ex` VALUES (1,'\0','2019-04-09 09:03:40.608','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019053861699585.jpg\" /></p>','/demodata/product1.jpg','/demodata/product2.jpg','','cable tube,wire collection mangner,office deak organizer ',''),(2,'\0','2019-04-09 09:04:32.124','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019109696274433.jpg\" /></p>','/demodata/produc3.jpg','/demodata/product4.jpg','','cable tube,wire collection mangner,office deak organizer ',''),(3,'\0','2019-04-09 09:06:22.088','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019226734133249.jpg\" /></p>','/demodata/product5.jpg','/demodata/product6.jpg','','office desk mat,anti-slip mat,writing mat ',''),(4,'\0','2019-04-09 09:08:19.221','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019350214443009.jpg\" /></p>','/demodata/product7.jpg','/demodata/product8.jpg','','pull-out basket,cabinet basket,kitchen basket,corner basket,storage basket',''),(5,'\0','2019-04-09 09:10:16.549','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019445777465345.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019451146174465.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019459736109057.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019462957334529.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019465104818177.jpg\" /></p>','/demodata/product9.jpg','/demodata/product10.jpg','','kitchen waste bin,storage basket,trash can,pvc waste bin, pull-out sliding waste bin ',''),(6,'\0','2019-04-09 09:11:38.303','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019537045520385.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019539193004033.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019542414229505.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019544561713153.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019546709196801.jpg\" /></p>','/demodata/product11.jpg','/demodata/product12.jpg','','kitchen waste bin,storage basket,trash can,pvc waste bin, pull-out sliding waste bin ',''),(7,'\0','2019-04-09 09:12:52.717','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019625092349953.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019627239833601.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019630461059073.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019632608542721.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019635829768193.jpg\" /></p>','/demodata/product13.jpg','/demodata/product14.jpg','','kitchen waste bin,storage basket,trash can,pvc waste bin, pull-out sliding waste bin ',''),(8,'\0','2019-04-09 09:14:28.147','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019741056466945.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019743203950593.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019746425176065.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019749646401537.jpg\" /></p>','/demodata/product15.jpg','/demodata/product16.jpg','','kitchen waste bin,storage basket,trash can',''),(9,'\0','2019-04-09 09:16:23.283','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019857020583937.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019860241809409.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019867758002177.jpg\" /></p>','/demodata/product17.jpg','/demodata/product18.jpg','','',''),(10,'\0','2019-04-09 09:17:45.547','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019949362380801.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019951509864449.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019956878573569.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43019962247282689.jpg\" /></p>','/demodata/product19.jpg','/demodata/product20.jpg','','',''),(11,'\0','2019-04-09 09:19:23.585','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020042777919489.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020044925403137.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020053515337729.jpg\" /></p>','/demodata/product21.jpg','/demodata/product22.jpg','','',''),(12,'\0','2019-04-09 09:02:44.873','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43018994805899265.jpg\" /></p>','/demodata/product23.jpg','/demodata/product24.jpg','','',''),(13,'\0','2019-04-09 09:01:47.649','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43018929307648001.jpg\" /></p>','/demodata/product2.jpg','/demodata/product1.jpg','','',''),(14,'\0','2019-04-09 09:26:10.826','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020491602001921.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020494823227393.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020503413161985.jpg\" /></p>','/demodata/product4.jpg','/demodata/produc3.jpg','','cloth basket,wardrobe fittings',''),(15,'\0','2019-04-09 09:29:15.306','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020695612948481.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020699907915777.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020703129141249.jpg\" /></p>','/demodata/product6.jpg','/demodata/product5.jpg','','',''),(16,'\0','2019-04-09 09:24:19.606','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020361679241217.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020363826724865.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020374564143105.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020377785368577.jpg\" /></p>','/demodata/product8.jpg','/demodata/product7.jpg','','',''),(17,'\0','2019-04-09 09:22:57.918','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020287591055361.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020294033506305.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020298328473601.jpg\" /></p>','/demodata/product10.jpg','/demodata/product9.jpg','','',''),(18,'\0','2019-04-09 09:20:40.010','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020129751007233.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020136193458177.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020146930876417.jpg\" /></p>','/demodata/product12.jpg','/demodata/product11.jpg','','',''),(19,'\0','2019-04-09 09:33:25.184','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020951163502593.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020953310986241.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020956532211713.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020959753437185.jpg\" /></p>','/demodata/product14.jpg','/demodata/product13.jpg','','cabinet door hinge,soft closing hinge ',''),(20,'\0','2019-04-09 09:35:02.433','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43021074643812353.jpg\" /></p>','/demodata/product16.jpg','/demodata/product15.jpg','','furniture table leg,metal table leg,folding table leg',''),(21,'\0','2019-04-09 09:32:27.079','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020894255185921.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020897476411393.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020902845120513.jpg\" /><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43020906066345985.jpg\" /></p>','/demodata/product18.jpg','/demodata/product17.jpg','','',''),(22,'\0','2019-04-09 09:39:06.597','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43021331268108289.jpg\" /></p>','/demodata/product20.jpg','/demodata/product19.jpg','','furniture table leg,office desk table leg ',''),(23,'\0','2019-04-09 09:40:02.479','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43021394618875905.jpg\" /></p>','/demodata/product22.jpg','/demodata/product21.jpg','','',''),(24,'\0','2019-04-09 09:41:08.827','<p><img class=\"wscnph\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://www.cchcch.com:8080/resources/20190409/43021466559578113.jpg\" /></p>','/demodata/product24.jpg','/demodata/product23.jpg','','','');
/*!40000 ALTER TABLE `product_ex` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site_info`
--

DROP TABLE IF EXISTS `site_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `site_info` (
  `id` bigint(11) unsigned NOT NULL DEFAULT '0' COMMENT 'ID',
  `del` bit(1) NOT NULL DEFAULT b'0' COMMENT '已删除',
  `add_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '添加时间',
  `title` varchar(500) NOT NULL DEFAULT '' COMMENT 'q???',
  `keyword` varchar(500) NOT NULL DEFAULT '' COMMENT 'q?seo keyword',
  `description` varchar(500) NOT NULL DEFAULT '' COMMENT 'q?seo description',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site_info`
--

LOCK TABLES `site_info` WRITE;
/*!40000 ALTER TABLE `site_info` DISABLE KEYS */;
INSERT INTO `site_info` VALUES (1,'\0','2019-04-24 02:23:21.558','CMSLite','cms,bolg,website','CMSLite是一套极简的创建内容管理系统，可用于创建企业网站，个人blog，目前只提供一套模板。');
/*!40000 ALTER TABLE `site_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(11) unsigned NOT NULL DEFAULT '0' COMMENT '用户ID',
  `del` bit(1) NOT NULL DEFAULT b'0' COMMENT '已删除',
  `add_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '添加时间',
  `user_name` varchar(20) NOT NULL DEFAULT '' COMMENT '登录账号',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '登录密码',
  `nick` varchar(20) NOT NULL DEFAULT '' COMMENT '昵称',
  `roles` varchar(200) NOT NULL DEFAULT '' COMMENT '角色，支持多个(admin,user)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'\0','2019-03-23 03:16:51.774','admin','e10adc3949ba59abbe56e057f20f883e','admin','admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-01 15:55:28
