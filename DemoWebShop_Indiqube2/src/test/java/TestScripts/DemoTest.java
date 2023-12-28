package TestScripts;

import org.testng.annotations.Test;

public class DemoTest {
	
	@Test
	public void demo() {
		String Url=System.getProperty("Url");
		String Un=System.getProperty("un");
		System.out.println(Url);
		System.out.println(Un);
	}

}
