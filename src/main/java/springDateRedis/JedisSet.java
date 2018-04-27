package springDateRedis;

import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * Set 就是一个集合,集合的概念就是一堆不重复值的组合。利用 Redis 提供的 Set 数据结构,可以存储一些集合性的数据
 * @author zk
 *
 */
public class JedisSet {
	public static void main(String [] args) {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		
		jedis.sadd("openId1", "zk","dly");//添加一个或多个指定的member元素到集合的 key中
		Set<String> openIdSet =jedis.smembers("openId1");//获取集合中所有的value
		for(String openId:openIdSet) {
			System.out.println("openId:"+openId);
		}
		jedis.sadd("openId2", "zk");
		System.out.println("jedis.scard(\"openId\"):"+jedis.scard("openId1"));//返回集合存储的key的基数 (集合元素的数量).
		System.out.println("jedis.sdiff(\"openID\",\"openId\"):"+jedis.sdiff("openId1","openId2"));//返回一个集合与给定集合的差集的元素.
		jedis.del("openId2");
		jedis.del("openId1");
	}

}
