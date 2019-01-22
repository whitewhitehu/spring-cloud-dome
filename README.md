## spring cloud 

### 1.eureka模块-服务注册中心
### 2.oauth2模块-认证授权服务
### 3.gateway模块-网关(主要用于路由转发)
### 3.crm模块-基础服务
### 4.common模块-目前主要存用与存放实体类
### CRM模块功能

* 1.用户管理
* 2.部门管理
* 3.菜单管理
* 4.角色管理
* 5.权限管理




* 系统与前端的数据交互主要采用Restful Api 的方式实现 

### spring boot 版本
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-parent</artifactId>
            <version>2.0.4.RELEASE</version>
### 部署
* 1.安装mysql8数据库 将项目中的webdb.sql脚本文件导入到数据库中 PS:mysql其他版本没试过 我电脑上使用的是mysql 8.0.12版本
* 2.修改oauth2认证授权服务中的数据库连接地址密码
* 3.修改CRM服务中的数据库连接地址与密码 CRM服务使用的是OAUTH2协议中的password认证授权模式可以在application-test.yml文件中修改
* 4.如果发现找不到common包下的类 可以在common模块的文件目录中执行命令:mvn clean install
* 5.运行步骤 1.运行eureka注册中心 2.启动oauth2认证授权服务 3.启动CRM基础服务 4.启动gateway网关