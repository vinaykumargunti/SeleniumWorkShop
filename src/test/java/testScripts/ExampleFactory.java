package testScripts;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class ExampleFactory {

	@Factory
	public Object[] factoryMethod() {
		
		return new Object[] {new SimpleTest(2),new SimpleTest(4)};
	}
	
	

}


class SimpleTest {
	
	int i=0;
	SimpleTest(){}
	SimpleTest(int i){
		
		this.i=i;
		System.out.println("parameter Value: "+i);
		
	}
	
	@Test
	public void sample1() {
		i=i+3;
		
		System.out.println("Test One: "+i);
	}
	@Test
public void sample2() {
		i=i+4;
		System.out.println("Test Two: "+i);
	}
	
	
	
}