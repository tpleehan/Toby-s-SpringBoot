package tobyspring.helloboot;

import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private final HelloService helloService;

	// @Autowired // Spring 4.3버전부터 클래스에 생성자가 하나라면 @Autowired 생략이 가능하다.
	public HelloController(HelloService helloService) {
		this.helloService = helloService;
	}

	@GetMapping("/hello")
	// @ResponseBody // @RestController를 클래스 타입에 지정할 경우 dispatcherServlet이 각 메서드에 @ResponseBody가 지정해주기 때문에 생략이 가능하다.
	// @RequestMapping(value = "/hello", method = RequestMethod.GET) // 처음 사용되던 어노테이션. GetMapping 동일한 결과
	public String hello(String name) {
		if (name == null || name.trim().length() == 0)
			throw new IllegalArgumentException();

		return helloService.sayHello(Objects.requireNonNull(name));
	}

	@GetMapping("/count")
	public String count(String name) {
		return name + ": " + helloService.countOf(name);
	}
}
