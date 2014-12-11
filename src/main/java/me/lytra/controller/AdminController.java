package me.lytra.controller;

import javax.servlet.http.HttpSession;

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
@RequestMapping(value="/admin")
public class AdminController {
	static Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private UserService userService;


    @RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView handleLogin(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		mav.addObject("user", new User());
		return mav;	
	}
    
    

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginFoo(HttpSession session, @ModelAttribute User user) {
		logger.info("login ######################################");
		return new ModelAndView("lytra", "user", new User());
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpSession session, @ModelAttribute User user) {
		logger.info("User login attept: {}", user);
		User validUser = userService.login(user.getUsername(), user.getPassword());
		if(validUser!=null){			
			logger.info("User Authenticated: {}", validUser);
			
			session.setAttribute("USER_OBJECT", validUser);
			session.setAttribute("USER_ID", validUser.getId());
			if(validUser.isAdmin()){
				session.setAttribute("USER_ADMIN", validUser.isAdmin());
				logger.info("User admin login successful: {}", session.getAttribute("USER_OBJECT").toString());
			}
			return "redirect:/dashboard";
		}
		
		else {
			logger.warn("Failed login attempted with username: {}", user.getUsername());
			return "noaccess";			
		}
	}
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		if(session != null){
			session.invalidate();
		}
		return "redirect:/";

	}

}



