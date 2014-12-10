package me.lytra.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import me.lytra.domain.facebook.Feed;
import me.lytra.persistence.service.BlogService;
import me.lytra.persistence.service.GridFsService;
import me.lytra.persistence.service.UserService;
import me.lytra.service.facebook.LytraFacebookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
	static Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private BlogService blogService;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private GridFsService gridFsService;
	
	@Autowired
	private LytraFacebookService lytraFacebookService;
	
/*	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}*/

    @RequestMapping(value="/indexold", method=RequestMethod.GET)
	public ModelAndView handleIndex(HttpSession session) {
    	logger.info("Index accessed");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("indexold");
		return mav;	
	}
    
    @RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView handleTest(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Feed feed = lytraFacebookService.getFeed();
		String profileImageUrl = lytraFacebookService.getProfileImageUrl();
		mav.addObject("pimgurl", profileImageUrl);
		mav.addObject("feed", feed);
		mav.setViewName("index");
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
		//mav.addObject("posts", blogService.findAll());
		//mav.addObject("active", "blog");
		return mav;
	}
/*	@RequestMapping(value="/photos", method=RequestMethod.GET)
	public ModelAndView handleRequestPhotos(HttpSession session) {
		if(session.getAttribute("USER_OBJECT") == null){
			return new ModelAndView("redirect:/lytra");
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("photos");
		String userid = session.getAttribute("USER_ID").toString();
		List<String> fileIdList = gridFsService.getGridFSDBPhotoIdsByUserId(userid);
		logger.info("Found photos for userid: {}, file id list: {}", userid, fileIdList);
		mav.addObject("files", fileIdList);

		return mav;
	}*/

/*	@RequestMapping(value = "/json", produces = "application/json")
	public @ResponseBody
	String testfoo() {
		logger.info("Users: {}", blogService.findAll());
		return userService.findAll().toString();
	}*/

}
