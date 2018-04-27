package springDateRedis;


import java.util.List;
import java.util.ResourceBundle;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTest {
	
	
	
	public static void main(String [] args) {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println("连接成功");
		System.out.println("服务正在运行:"+jedis.ping());
		
        jedis.set("set", "settest");
        System.out.println("SET:"+jedis.get("set"));
        jedis.setnx("set", "set1");
        System.out.println("SETNX:"+jedis.get("set"));//如果key不存在，相当于set，如果存在，什么也不做
        jedis.setrange("set", 3, "zk");
        System.out.println("setrange:"+jedis.get("set"));//覆盖key对应的string的一部分，从指定的offset处开始，覆盖value的长度
        
        System.out.println("jedis.getSet(\"set\", \"getset\"):"+jedis.getSet("set", "getset"));
        System.out.println("jedis.get(\"set\"):"+jedis.get("set"));//getset ­­ 设置key的值,并返回key的旧值
        
        System.out.println("jedis.getrange(\"set\", 0, 3):"+jedis.getrange("set", 0, 3));//获取指定key的value值的子字符串。
        
        System.out.println("jedis.append(\"set\", \"append\"):"+ jedis.append("set", "append"));
        //给指定key的字符串值追加value,返回新字符串值的长度
        
        jedis.set("age", "23");
        jedis.incr("age");
        System.out.println("after jedis.incr(\"age\") :"+jedis.get("age"));//对key的值加1操作
        
        jedis.incrBy("high", 100);
        System.out.println("after jedis.incrBy(\"high\", 100) :"+jedis.get("high"));
        //同incr类似,加指定值 ,key不存在时候会设置key,并认为原来的value是 0
        
        jedis.decr("age");
        System.out.println("after jedis.decr(\"age\") :"+jedis.get("age"));//对key的值减1操作
        jedis.decrBy("high", 90);
        System.out.println("after jedis.decrBy(\"high\", 100) :"+jedis.get("high"));
        //同decr类似,减指定值 ,key不存在时候会设置key,并认为原来的value是 0
        jedis.close();
        
	}

}
