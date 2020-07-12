# ms-demo
micro service demo

1. 两个以上的微服务
2. 使用Restful和MQ进行通信
3. 实现客户端负载均衡
4. 有服务注册和发现中心
5. 使用config sever配置config
6. 有熔断机制
7. 使用cache， redis
8. 数据要保存到 DB.
9. 至少要有一个UI
 按照以上要求搭建一个基本的微服务框架
 
spring boot cloud  
~~gradle + ali 镜像~~
FAQ frequently answered question 
** how to start spring boot project? user spring initializer
** 每个微服务都要各自一个git 仓库嘛? 貌似是的, 为了独立部署, 组织架构blah blah; 折衷, 为了方便在一个IDE里搞, 不分了

** 挺萌的Grade, 一堆坑
** gradlew 要不要提交? 要
** gradle build 太慢了? gradle-wrapper.properties 访问了墙外; 
    C:\Users\xxx\.gradle\wrapper\dists\gradle-6.5.1-bin\1m5048aptkfynhbvolwgr4ej9\ 目录下放自己下载的 gradle-6.5.1-bin.zip
** gradle plugin 下载不到? 配置settings.gradle, 用ali 镜像 
** 报错 zip END header not found
** gradle如何构建? 跑 gradlew build 

** sprig boot 如何启动? gradlew bootRun 
** gradle bootRun 报错? - Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
    因为配置了 spring-boot-starter-data-jpa; 若想取消读db配置: @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
** 报错: Web server failed to start. Port 8080 was already in use. 
    解决: 
** yml 还是 properties? yml, 因为别人都在用.
** [Spring Initializr](https://start.spring.io/) 作甚的? 定义项目元信息, 依赖, 然后打包一个空项目.

** spring boot 测试有啥变化? 可以写UT/IT, 具体待学习, 先掠过
** [如何搞rest WS?](https://spring.io/guides/gs/rest-service/)
** spring boot 如何发http请求?  RestTemplate 客户端访问server端的, 类似的有jdbcTemplate, JmsTemplate 
** rabbitmq? choco install rabbitmq --yes 
    http://localhost:15672/#/
        guest/guest
** rabbitmq 收发消息? RabbitTemplate 
     Spring AMQP requires that the Queue, the TopicExchange, 
     and the Binding be declared as top-level Spring beans in order to be set up properly.
      

** 客户端负载均衡怎么搞?  
    spring-cloud-starter-loadbalancer 
    
** 服务发现? eureka 
    server 不要注册自己
    先启动server, 然后起client
    默认端口 8761, 其他端口没成功过
    
** config 
    yaml 没有特殊字符, 要'*'
    config git repo 根据application name 设置各个app的config
    client 端要手动刷新才能refreh config
         curl localhost:8002/actuator/refresh -d {} -H "Content-Type: application/json"
         
** circuit breaker
    配置在client, call 不通时,用fallback 方法 
    
** redis
    choco install redis-64 --yes
    端口: 6379
    https://programmerfriend.com/ultimate-guide-to-redis-cache-with-spring-boot-2-and-spring-data-redis/
    
** JPA  
    repo 类声明方法即可, spring会实现
    数据库用H2
    要加pathVariable
    test: curl http://localhost:8761/customer/1    
    
** UI
        vaadin    