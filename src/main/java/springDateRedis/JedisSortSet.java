package springDateRedis;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

/**
 * Redis 有序集合和集合一样也是string类型元素的集合,且不允许重复的成员。
 * 不同的是每个元素都会关联一个double类型的分数。redis正是通过分数来为集合中的成员进行从小到大的排序。
 * 有序集合的成员是唯一的,但分数(score)却可以重复。
 * 集合是通过哈希表实现的，所以添加，删除，查找的复杂度都是O(1)。 集合中最大的成员数为 232 - 1 (4294967295, 每个集合可存储40多亿个成员)。
 * @author zk
 *
 */
public class JedisSortSet {
	
	public static void main(String []args) {
		
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		
		jedis.zadd("SingSong", 1, "zk1");
		jedis.zadd("SingSong", 2, "zk2");
		jedis.zadd("SingSong", 3, "zk3");
		//jedis.zadd("SingSong", 1, "zk1");
		
		jedis.zincrby("SingSong", 10, "zk1");//向set里面的键的socre加
		
		//zrevrange doudizhu_rank 0 -1 withscores
		//min 和 max 可以是 -inf 和 +inf ，这样一来，你就可以在不知道有序集的最低和最高 score 值的情况下，使用 ZRANGEBYSCORE 这类命令。逆序排序
		Set<Tuple> rank=jedis.zrevrangeByScoreWithScores("SingSong","+inf","-inf",0,3);
		 Iterator rankIt=rank.iterator();
		while (rankIt.hasNext()) {
			Tuple rankTuple = (Tuple) rankIt.next();
			System.out.println("name:"+rankTuple.getElement()+" score:"+rankTuple.getScore());
			
		}
		jedis.del("SingSong");
		
	}

}
