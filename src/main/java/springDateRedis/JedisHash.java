package springDateRedis;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import redis.clients.jedis.Jedis;
/**
 * Redis hash 是一个string类型的field和value的映射表，hash特别适合用于存储对象
 * @author zk
 *
 */
public class JedisHash {
	public static void main(String [] args) {
		
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.hset("songList", "songId1", "1");//设置 key 指定的哈希集中指定字段的值
		jedis.hset("songList", "songId2", "2");
		jedis.hset("songList", "songId3", "3");
		
		
		jedis.hincrBy("songList", "songId1", 5);
		jedis.hincrBy("songList", "songId4", 5);//指定的hash filed 加上给定值。,如果不存在，则重新建一个，value当0.然后再加上给定值
				
		
		
		jedis.hdel("songList", "songId1");//删除指定的field
		Map<String, String> hMap =jedis.hgetAll("songList");
		for(String key: hMap.keySet()) {
			System.out.println("songList key:"+key) ;
		    System.out.println("songList values:"+hMap.get(key)) ;
		}
		
		System.out.println("the songList songId1 is exit?:"+jedis.hexists("songList", "songId1"));
		
		jedis.del("songList");//删除指定的key
		hMap =jedis.hgetAll("songList");
		for(String key: hMap.keySet()) {
			System.out.println("songList key:"+key) ;
		    System.out.println("songList values:"+hMap.get(key)) ;
		}

		jedis.close();//?
		jedis.set("close", "have");
		System.out.println("after close :"+ jedis.get("close"));
		
		
	}
	

}
