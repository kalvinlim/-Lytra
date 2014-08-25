package me.lytra.controller.blog;

import javax.servlet.http.HttpSession;

import me.lytra.persistence.service.BlogService;
import me.lytra.persistence.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	static Logger logger = LoggerFactory.getLogger(DashboardController.class);
	@Autowired 
	private BlogService blogService;
	
	@Autowired
	private UserService userService;

	@RequestMapping
	public ModelAndView handleRequestDashboard(HttpSession session) {
		
		if(session.getAttribute("USER_OBJECT") == null){
			return new ModelAndView("redirect:/alpha");
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sb-admin/index");
		mav.addObject("active", "dashboard");
		return mav;
	}
	

/*	@RequestMapping("/blog")
	public ModelAndView handleRequestDashboardBlog() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sb-admin/blog");
		mav.addObject("posts", blogService.findAllByNewestFirst());
		mav.addObject("active", "blog");
		//logger.info("blog");
		return mav;
	}
	@RequestMapping("/users")
	public ModelAndView handleRequestDashboardUsers() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sb-admin/users");
		mav.addObject("active", "users");
		mav.addObject("users", userService.findAll());
		return mav;
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String submit(@ModelAttribute BlogPost blogPost){
		//blogService.save(blogPost);
		logger.info("Saved new BlogPost: {}", blogPost);
		return "redirect:/dashboard/blog";
	}
	@RequestMapping(value="/publish", method=RequestMethod.POST, headers = {"Content-type=application/json"})
	public @ResponseBody void publish(@RequestBody BlogPost blogPost){
		BlogPost published = blogService.findOne(blogPost.getId());
		published.setPublished(true);
		//blogService.save(published);
		logger.info("Publishing BlogPost: {}", published);
	}
	
	@RequestMapping(value="/createuser", method=RequestMethod.POST)
	public void submitUser(@ModelAttribute User user){
		logger.info("user: {}", user);
		userService.create(user);
	}
	
	@RequestMapping(value="/unpublish", method=RequestMethod.POST, headers = {"Content-type=application/json"})
	public @ResponseBody void unpublish(@RequestBody BlogPost blogPost){
		BlogPost unPublished = blogService.findOne(blogPost.getId());
		unPublished.setPublished(false);
		//blogService.save(unPublished);
		logger.info("Unpublishing BlogPost: {}", unPublished);
	}*/
}
