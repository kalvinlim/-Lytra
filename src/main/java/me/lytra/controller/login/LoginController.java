package me.lytra.controller.login;

import javax.servlet.http.HttpSession;

import me.lytra.controller.MainController;
import me.lytra.domain.user.User;
import me.lytra.persistence.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	static Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private UserService userService;

	/*	@RequestMapping(value="login", method=RequestMethod.GET)
	public ModelAndView handleRequest(){
		return new ModelAndView();
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public void handleLogin(HttpSession session, @ModelAttribute User user){
		logger.info("Session: {}", session);
	}
	*/
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginFoo(HttpSession session, @ModelAttribute User user) {
		return new ModelAndView("alpha", "user", new User());
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpSession session, @ModelAttribute User user) {
		logger.info("User: {}", user);
		User validUser = userService.login(user.getUsername(), user.getPassword());
		if(validUser!=null){
			logger.info("User Authenticated: {}", validUser);
			session.setAttribute("USER_OBJECT", validUser);
			return "redirect:/alpha";
		}
		else {
			return "noaccess";
		}
	}
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		if(session != null){
			session.invalidate();
		}
		return "redirect:/alpha";

	}

}



