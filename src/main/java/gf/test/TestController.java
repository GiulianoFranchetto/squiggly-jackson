package gf.test;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TestController {

	@RequestMapping("/")
	public TestObject index() {
		TestObject obj = new TestObject();
		obj.setA("a");
		obj.setB("b");
		obj.setC("c");
		return obj;
	}

}
