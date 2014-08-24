package me.lytra.controller;

import javax.servlet.http.HttpSession;

import me.lytra.domain.user.User;
import me.lytra.persistence.service.BlogService;
import me.lytra.persistence.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//@Configuration
@Controller
public class MainController {
	static Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private BlogService blogService;
	

	
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index() {
        return "index";
    }
	@RequestMapping(value="/test")
	public ModelAndView test(HttpSession session, @ModelAttribute User user) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		return mav;
	}
	
	@RequestMapping(value="/alpha", method=RequestMethod.GET)
	public ModelAndView handleRequest(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("alpha");
		return mav;
	
	}

	@RequestMapping("/gallery")
	public ModelAndView handleRequestGallery() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("gallery");
		mav.addObject("active", "gallery");
		return mav;

	}

	@RequestMapping("/about")
	public ModelAndView handleRequestAbout() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("about");
		mav.addObject("active", "about");
		return mav;
	}

	@RequestMapping("/blog")
	public ModelAndView handleRequestBlog() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("blog");
		mav.addObject("posts", blogService.findAll());
		mav.addObject("active", "blog");
		return mav;
	}

	@RequestMapping(value = "/json", produces = "application/json")
	public @ResponseBody
	String testfoo() {
		return blogService.findAll().toString();
	}

}
