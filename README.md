# sbmoon
http://spring.io/guides 有什么不会的，我想首先看下这里有没有，相比网上的各种教材，这里可能是最权威和及时的。
https://docs.spring.io/spring-boot/docs/2.0.5.RELEASE/reference/htmlsingle/ all the thing


https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html

## Developer Tools
https://docs.spring.io/spring-boot/docs/2.0.5.RELEASE/reference/htmlsingle/#using-boot-devtools
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
	<optional>true</optional>
</dependency>
```

## 页面模板 thymeleaf
 https://docs.spring.io/spring-boot/docs/2.0.5.RELEASE/reference/htmlsingle/#getting-started-first-application

```
# 开发阶段关闭cache
spring.thymeleaf.cache=false
spring.thymeleaf.check-template=true
spring.thymeleaf.check-template-location=true
spring.thymeleaf.enabled=true
spring.thymeleaf.encoding=UTF-8
spring.thymeleaf.mode=HTML
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.servlet.content-type=text/html
spring.thymeleaf.suffix=.html
```


## mybatis
http://www.mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/

```
mybatis.type-aliases-package=com.github.mingruyue.sbmoon.domain
mybatis.configuration.map-underscore-to-camel-case=true
mybatis.configuration.default-fetch-size=100
mybatis.configuration.default-statement-timeout=3000
mybatis.mapper-locations=com/github/mingruyue/sbmoon/dao/*.xml
```
pom.xml
```
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>1.3.2</version>
</dependency>
```

## druid
https://github.com/alibaba/druid/blob/master/druid-spring-boot-starter/README_EN.md


```
#druid
spring.datasource.url=jdbc:mysql://localhost:3306/sbmoon
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```

pom.xml
```
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.1.11</version>
</dependency>

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <!--<scope>runtime</scope> 默认会有，一定要去掉, application.properties 才能识别 Driver -->
</dependency>
```

## redis
https://github.com/xetorthio/jedis

```
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
    <version>2.9.0</version>
    <type>jar</type>
    <scope>compile</scope>
</dependency>
```
```
# redis
spring.redis.host=192.168.1.100
spring.redis.port=6379
#spring.redis.password=$requirepass
#Duration 是个什么东西原来就是带单位的，不带单位是秒，后边是毫秒的不用转了
spring.redis.timeout=3ms
spring.redis.jedis.pool.max-active=10
spring.redis.jedis.pool.max-idle=10
spring.redis.jedis.pool.max-wait=3ms

```



## fastjson 明文可读比较方便，性能大概是protobuf的1/10
```
<!-- https://mvnrepository.com/artifact/com.alibaba/fastjson -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.51</version>
</dependency>
```

