package springDateRedis;

import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Redis列表是简单的字符串列表，按照插入顺序排序。
 * 你可以添加一个元素导列表的头部（左边）或者尾部（右边）
 * @author zk
 *
 */
public class JedisList {
	
	public static void main(String []args) {
		JedisPool  jedisPool = new JedisPool();
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		
		/*
		//向存于 key 的列表的尾部插入所有指定的值。如果 key 不存在，那么会创建一个空的列表然后再进行 push 操作。
		jedis.rpush("songList", "1","2","3");
		jedis.rpush("songList", "-1");
		jedis.ltrim("songList", 0, 1);//修剪(trim)一个已存在的 list，这样 list 就会只包含指定范围的指定元素。
		jedis.lpush("songList", "5","7");//7成为了第一个元素，5是第二个
		//移除并且返回 key 对应的 list 的第一个元素
		//System.out.println("jedis.lpop(\"songList\"):"+jedis.lpop("songList"));
		 * 
		 */
		for(int x =0; x<20;x++) {
			jedis.rpush("songList", Integer.toString(x));
		}
		/*
		 * 只要前五个数，并且替换成99-95
		 */
		for(int x=95;x<100;x++) {
			jedis.lpush("songList", Integer.toString(x));
		}
		jedis.ltrim("songList", 0, 4);
		List<String> songList =jedis.lrange("songList", 0, -1);	//取出list的区间范围内的元素
		for(String song:songList) {
			System.out.println(song);
		}
		
		jedis.del("songList");
		
	}

}
