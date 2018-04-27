package iocAndDI;

public class IocAndDI {
	private HelloWorld helloWorld;
	
	public  IocAndDI() {
		System.out.println("----");
	}

	public HelloWorld getHelloWorld() {
		return helloWorld;
	}

	public void setHelloWorld(HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}
	

}
