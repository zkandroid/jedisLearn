# 对jedis的简单应用
 由于最近业务需要使用redis，所有便找了点时间来研究redis，这个项目是我对redis的简单练手。
 
一，maven导入jedis包，jedis是redis官方对java提供的一个封装，只需要导入这个包，并配置一下便可以使用再java项目中使用redis，而且也比较简单。对了，不要忘了要先安装redis，并且启动redis。
 	<dependency>
    		<groupId>redis.clients</groupId>
    		<artifactId>jedis</artifactId>
    		<version>2.9.0</version>
    		<type>jar</type>
    		<scope>compile</scope>
	</dependency>
二，其中再springDateRedis下是对redis的字符串，hash，list，set，sortset的一些简单测试，而redis.properties是对redis的配置文件，当然也可以不用在这里面配置，我这里就没有用，直接在RedisUtil里面配置也可以。
