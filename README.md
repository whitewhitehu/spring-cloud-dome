**`基于spring boot 2.0.8 目前集成了spring security oauth2 (server and client)、
springboot-admin、openfeign、hystrix,zuul（后续会替换成gateway），config.....等组件 `**

[前端项目 请点这里](https://github.com/yangqifang/SB-cloud-UI)
```$xslt
project 
|--admin 管理模块 主要为前端项目提供接口
|--common 基础模块 放置项目中所欲要用到的实体类 (目前这个模块中存在自动配置 后面我会剔除)
|--eurekaserver 注册中心
|--gateway zuul 网关
|--modules
      |
      |--config-server 配置中心
      |
      |--monitor-server 监控服务 使用spring boot admin2
|--oauth-modules
       |
       |--oauth2-server 授权服务 提供用户认证 授权
       |
       |--resource-server 资源服务 提供用户信息接口与OAuth2客户端修改添加
|--pom.xml 
|
|--webdb.sql 数据库脚本
```



### spring boot version
       2.0.8.RELEASE
### spring cloud version
       Finchley.SR2
### 界面预览
![](http://www.cnblogs.com/images/cnblogs_com/yangqifang/1412844/o_a1%20(4).jpg)
![](http://www.cnblogs.com/images/cnblogs_com/yangqifang/1412844/o_a1%20(5).jpg)
![](http://www.cnblogs.com/images/cnblogs_com/yangqifang/1412844/o_a1%20(6).jpg)
![](http://www.cnblogs.com/images/cnblogs_com/yangqifang/1412844/o_a1%20(2).jpg)
![](http://www.cnblogs.com/images/cnblogs_com/yangqifang/1412844/o_a1%20(1).jpg)
![](http://www.cnblogs.com/images/cnblogs_com/yangqifang/1412844/o_a1%20(3).jpg)
### 部署
* **1.安装mysql8数据库 将项目中的webdb.sql脚本文件导入到数据库中 PS:mysql其他版本没试过 我电脑上使用的是mysql 8.0.12版本**
* **2.修改oauth2认证授权服务中的数据库连接地址密码**
* **3.修改CRM服务中的数据库连接地址与密码 CRM服务使用的是OAUTH2协议中的password认证授权模式可以在application-test.yml文件中修改**
* **4.如果发现找不到common包下的类 可以在common模块的文件目录中执行命令:mvn clean install**
* **5.运行步骤 1.运行eureka注册中心 2.启动oauth2认证授权服务 3.启动CRM基础服务 4.启动gateway网关**
