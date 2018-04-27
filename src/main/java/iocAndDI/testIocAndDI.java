package iocAndDI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


//import springDateRedis.BeanContext;

public class testIocAndDI {

	public  void main(String [] args) {
		/*常规启动方式
		IocAndDI iocAndDI = new IocAndDI();
		StrutsHelloWorld sWorld = new StrutsHelloWorld();
		iocAndDI.setHelloWorld(sWorld);
		iocAndDI.getHelloWorld().sayHello();
		*/
		
		/*
		ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
		HelloWorld iDi = context.getBean("IocAndDI", IocAndDI.class).getHelloWorld();
		*/
		/*HelloWorld iDi =MyBeanContext.context.getBean("IocAndDI", IocAndDI.class).getHelloWorld();
		iDi.sayHello();
		*/
	}
}
