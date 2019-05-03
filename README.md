# CMSLite

#### 项目介绍
CMSLite是一套极简的创建内容管理系统，可用于创建企业网站，个人blog，目前只提供一套模板。
CMSLite是本人的一个前端练手项目的后端API加网站展示，同时本人也是在这个框架基础上搭建了几套企业网站。
##### 项目功能
1. 用户管理
2. 文章管理
3. 栏目管理
4. 产品管理
5. 产品分类
6. 网站基础设置
7. 产品组件
8. 留言管理
9. banner管理
10. 区块管理
11. 页面缓存（支持ehcache或者redis）
#### 项目github
1. 系统总共包括2个项目
2. [CMSLite 后端服务 api加网站](https://github.com/liudexiang3218/CMSLite)
3. [CMSLite_vue 前端管理](https://github.com/liudexiang3218/CMSLite_vue)

#### 软件架构
<img src="https://github.com/liudexiang3218/CMSLite/blob/master/ScreenShots/flow.jpg?raw=true">
#### 安装教程

1. 下载项目 git clone https://github.com/liudexiang3218/CMSLite.git
2. 导入eclipse
3. mysql数据库导入cmslite.sql
4. 修改配置文件jdbc.properties
5. 修改配置文件jwt.properties
6. 修改配置文件email.properties
7. jetty:run项目 
8. http://127.0.0.1:8088/

#### 使用说明

1. 管理后台在线demo(暂未开放)
2. [企业网站在线demo](http://www.cchcch.com)

#### email.properties配置说明
邮箱设置，客户有留言将自动回复一份邮件给到对方，同时发送一个提醒邮箱到需要通知的邮箱地址
1.  ``simplejavamail.smtp.host ``:邮箱smtp服务器地址
2.  ``simplejavamail.smtp.port ``: 邮箱smtp端口
3.  ``simplejavamail.transportstrategy ``: 协议（目前只支持SMTP）
3.  ``simplejavamail.smtp.username ``: 登录邮箱账号
4.  ``simplejavamail.smtp.password ``: 登录邮箱密码
5.  ``simplejavamail.defaults.from.address ``: 邮箱账号
6.  ``simplejavamail.defaults.from.name ``: 邮箱显示名称
7.  ``mail.noice.address ``: 订阅通知邮箱地址

#### jwt.properties配置说明
密钥设置，前端权限验证token由此密钥生成
1.  ``jwt.secret ``:密钥，任意字符串

#### 开发环境

1. eclipse-2018-12
2. maven 3.5.4
3. git
4. jetty
5. mysql 5.7
6. redis 5.0.4

#### 技术栈
1. springmvc 4.3.19
3. ehcache 2.10.6
4. java-jwt 3.4.1
5. shiro 1.4.0
6. mybatis 3.4.6
7. freemarker 2.3.28
8. jedis 2.9.3

#### 作者微信
<img src="https://github.com/liudexiang3218/CMSLite/blob/master/ScreenShots/wechatqr.png?raw=true">
