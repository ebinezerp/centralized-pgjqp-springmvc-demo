package spring.webapp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.webapp.dao.UserService;
import spring.webapp.dto.User;
import spring.webapp.util.UserValidation;

@Controller
public class MyController {

	@Autowired
	private UserValidation userValidation;

	@Autowired
	private UserService userService;

	// request handling methods
	// example: to handle contact page request, which need to display contact.jsp

	/*
	 * @RequestMapping("/contact") public String contactPage(HttpServletRequest
	 * request) { request.setAttribute("myname", "ebinezer"); return "contact"; }
	 */

	/*
	 * @RequestMapping("/contact") public String contactPage(Model model) {
	 * 
	 * // model.addAttribute(String, Object); model.addAttribute("myname",
	 * "ebinezer");
	 * 
	 * List<String> names = Arrays.asList("Raghu", "Vishal", "Geetha", "Kishori",
	 * "Kavya", "Prbhat");
	 * 
	 * model.addAttribute("names", names); return "contact"; }
	 */

	@GetMapping("/contact")
	public ModelAndView contactPage() {

		List<String> names = Arrays.asList("Raghu", "Vishal", "Geetha", "Kishori", "Kavya", "Prbhat");

		ModelAndView mv = new ModelAndView();
		mv.setViewName("contact");
		mv.addObject("names", names);

		return mv;
	}

	@RequestMapping("/")
	public String indexPage() {
		return "index";
	}

//	@RequestMapping(value = "/register", method = RequestMethod.GET)

	@GetMapping("/register")
	public String registrationPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

//	@RequestMapping(value = "/loginpage", method = RequestMethod.GET)

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

//	@RequestMapping(value = "/register", method = RequestMethod.POST)

	@PostMapping("/register")
	public String registration(@ModelAttribute("user") User user, Model model) {

		Map<String, String> errorMessages = userValidation.validate(user);
		if (!errorMessages.isEmpty()) {
			model.addAttribute("errorMessages", errorMessages);
			return "register";
		}

		if (userService.save(user)) {
			// request is forwarded to login page
			/* return "login"; */

			// requesst is redirected to login
			return "redirect:/login";

		} else {
			model.addAttribute("errorMessage", "Internal Error Occured. Try again");
			return "register";
		}

	}

	@PostMapping("/login")
	public String loginProcess(@RequestParam("email") String email, @RequestParam("password") String password,
			Model model) {

		User user = userService.get(email, password);
		if (user != null) {
			return "redirect:/home";
		} else {
			model.addAttribute("errorMessage", "Invalid Credentails");
			return "login";
		}
	}

	@GetMapping("/home")
	public String homePage() {
		return "home";
	}

}
