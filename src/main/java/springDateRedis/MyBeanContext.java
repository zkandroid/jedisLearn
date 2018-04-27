package springDateRedis;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBeanContext {
	public static ClassPathXmlApplicationContext context = null;
	//静态代码块是自动执行的
	static{
		context = new ClassPathXmlApplicationContext("beans.xml");
        context.start();//启动spring容器，
	}

}
