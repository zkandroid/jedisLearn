package spring.learnSpring;

import iocAndDI.HelloWorld;
import iocAndDI.IocAndDI;
import springDateRedis.MyBeanContext;

public class App{
	
	public static void main(String[] args) {
		HelloWorld hWorld = MyBeanContext.context.getBean("IocAndDI", IocAndDI.class).getHelloWorld();
		hWorld.sayHello();
	}
}
