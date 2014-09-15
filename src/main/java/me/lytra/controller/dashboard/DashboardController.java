package me.lytra.controller.dashboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sun.xml.internal.ws.developer.UsesJAXBContext;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	static Logger logger = LoggerFactory.getLogger(DashboardController.class);
	@Autowired 
	private BlogService blogService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GridFsService gridFsService;

	@RequestMapping
	public ModelAndView handleRequestDashboard(HttpSession session) {
		if(session.getAttribute("USER_OBJECT") == null){
			logger.warn("Null login rejected");
			return new ModelAndView("redirect:/lytra");
		}
		if(session.getAttribute("USER_ADMIN").toString() != "true"){
			logger.warn("User admin login rejected: {}", session.getAttribute("USER_OBJECT").toString());
			return new ModelAndView("redirect:/lytra");
		}

		
		List<User> users = userService.findAllWithGalleryCount();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("dashboard");
		mav.addObject("users", users);
		mav.addObject("user", new User());
	
		return mav;
	}
	
    @RequestMapping(value="/createuser", method=RequestMethod.POST)
    public String handleFileUpload(@ModelAttribute User user, HttpSession session){
		
    	if(user.getUsername() != null && user.getPassword() != null && user.getPassword().length() > 0){
    		userService.create(user);
    	}
    	
    	return "redirect:/dashboard";
    }
    @RequestMapping(value="/moduser", method=RequestMethod.POST)
    public String handleFileUpload2(@ModelAttribute User user, HttpSession session){
    	logger.info("user mod: {}", user);	
    	User result = userService.findById(user.getId());
    	if(result != null){
    		logger.info("user mod: {}, changes: {}", result, user);	
    		
    	}
    	
    	return "redirect:/dashboard";
    }
    @RequestMapping(value="/delete/photo/{photoid}", method=RequestMethod.POST)
    public String handleFileUpload3(@PathVariable String photoid, HttpSession session){
		if(session.getAttribute("USER_OBJECT") == null){
			logger.warn("Null login user attempted to delete photo: {}", photoid);
			
		}
		if(session.getAttribute("USER_ADMIN").toString() != "true"){
			logger.warn("Non admin user attempted to delete photo: {}", photoid);			
		}
		User requestUser = userService.findById(session.getAttribute("USER_ID").toString());
    	logger.info("Delete requested by user: {}, for fileid: {}", requestUser, photoid);
    	gridFsService.deleteGridFSDBFileByPhotoId(photoid);
    	return "redirect:/dashboard";
    }
    
	@RequestMapping(value="/user/{userid}")
	public ModelAndView getPhotoIdsByUserId(HttpServletRequest request, HttpServletResponse response, @PathVariable String userid, HttpSession session){
		if(session.getAttribute("USER_OBJECT") == null){
			logger.warn("Null login rejected");
			return new ModelAndView("redirect:/lytra");
		}
		if(session.getAttribute("USER_ADMIN").toString() != "true"){
			logger.warn("User admin login rejected: {}", session.getAttribute("USER_OBJECT").toString());
			return new ModelAndView("redirect:/lytra");
		}
		logger.info("User admin login successful: {}", session.getAttribute("USER_OBJECT").toString());
		
		
		
		logger.info("Accessing photo list for userid: {}", userid);
		List<String> fileIdList = gridFsService.getGridFSDBPhotoIdsByUserId(userid);
		//53ffe8ea8d598e24fa67d190
		ModelAndView mav = new ModelAndView("userphotos");
		
		mav.addObject("files", fileIdList);

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
