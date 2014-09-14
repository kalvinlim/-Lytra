package me.lytra.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import me.lytra.domain.user.User;
import me.lytra.persistence.service.BlogService;
import me.lytra.persistence.service.GridFsService;
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


@Controller
@RequestMapping(value="/lytra")
public class MainController {
	static Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private BlogService blogService;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private GridFsService gridFsService;
/*	@RequestMapping(value="/test")
	public ModelAndView test(HttpSession session, @ModelAttribute User user) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		return mav;
	}
	
*/	@RequestMapping(value="", method=RequestMethod.GET)
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
	@RequestMapping(value="/photos", method=RequestMethod.GET)
	public ModelAndView handleRequestPhotos(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("photos");
		String userid = session.getAttribute("USER_ID").toString();
		List<String> fileIdList = gridFsService.getGridFSDBPhotoIdsByUserId(userid);
		
		mav.addObject("files", fileIdList);

		return mav;
	}

	@RequestMapping(value = "/json", produces = "application/json")
	public @ResponseBody
	String testfoo() {
		logger.info("Users: {}", blogService.findAll());
		return userService.findAll().toString();
	}

}
