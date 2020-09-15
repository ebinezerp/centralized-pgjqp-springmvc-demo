package spring.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	// request handling methods
	// example: to handle contact page request, which need to display contact.jsp

	@RequestMapping("/contact")
	public String contactPage() {
		return "contact";
	}

	@RequestMapping("/")
	public String indexPage() {
		return "index";
	}

}
