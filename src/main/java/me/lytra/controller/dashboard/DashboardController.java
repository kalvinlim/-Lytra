package me.lytra.controller.dashboard;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
		List<User> users = userService.findAll();
/*		if(session.getAttribute("USER_OBJECT") == null){
			return new ModelAndView("redirect:/lytra");
		}*/
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("dashboard");
		mav.addObject("users", users);
		mav.addObject("user", new User());
		//mav.addObject("active", "dashboard2");
		return mav;
	}
	
    @RequestMapping(value="/createuser", method=RequestMethod.POST)
    public String handleFileUpload(@ModelAttribute User user){
    	if(user.getUsername() != null && user.getPassword() != null && user.getPassword().length() > 0){
    		userService.create(user);
    	}
    	
    	return "redirect:/dashboard";
    }
    @RequestMapping(value="/moduser", method=RequestMethod.POST)
    public String handleFileUpload2(@ModelAttribute User user){
    	logger.info("user mod: {}", user);	
    	User result = userService.findById(user.getId());
    	if(result != null){
    		logger.info("user mod: {}, changes: {}", result, user);	
    		
    	}
    	
    	return "redirect:/dashboard";
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