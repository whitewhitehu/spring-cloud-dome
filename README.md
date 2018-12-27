# 微服务dome


### crm模块   运行8763端口
####基础功能
*登陆

![](https://www.cnblogs.com/images/cnblogs_com/yangqifang/1331045/o_QQ%e6%88%aa%e5%9b%be20181227174522.png)
* 用户管理
* 角色管理

![](https://www.cnblogs.com/images/cnblogs_com/yangqifang/1331045/o_QQ%e6%88%aa%e5%9b%be20181227174820.png)
* 权限管理

![](https://www.cnblogs.com/images/cnblogs_com/yangqifang/1331045/o_QQ%e6%88%aa%e5%9b%be20181227174843.png)

* 菜单管理 :递归实现多级菜单

![](https://www.cnblogs.com/images/cnblogs_com/yangqifang/1331045/o_QQ%e6%88%aa%e5%9b%be20181227174843.png)
### eurekaserver  eureka注册中心 运行8761端口
### gateway  服务网关(所有的服务都通过 zuul 来访问) 运行8080端口

### oauth2 认证中心 使用sprig cloud oauth2 运行在8762端口

## 采用Restful Api 返回数据 

### spring boot 版本
		
		<groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-parent</artifactId>
            <version>2.0.4.RELEASE</version>

### 分享两个个zuul网关的注意事项 

	1.通过zuul访问oauth2时请求头会造成丢失 在网关的配置文件中将sensitiveHeaders设置为空 即可解决
	2.zuul访问带有server.path 的服务时 会产生404 找不到接口  将strip-Prefix设置为true 即可解决
