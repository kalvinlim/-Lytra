package me.lytra.controller.dashboard;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.lytra.domain.client.Client;
import me.lytra.domain.user.User;
import me.lytra.persistence.service.BlogService;
import me.lytra.persistence.service.ClientService;
import me.lytra.persistence.service.GridFsService;
import me.lytra.persistence.service.UserService;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mongodb.gridfs.GridFSDBFile;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	static Logger logger = LoggerFactory.getLogger(DashboardController.class);
	@Autowired 
	private BlogService blogService;
	
	@Autowired
	private UserService userService;
	
	@Autowired private ClientService clientService;
	
	@Autowired
	private GridFsService gridFsService;
	
	@Autowired
	private MongoOperations mongoOperations;

	private String BASE_URL = "http://localhost:1337/lytra/";
	
	@RequestMapping
	public ModelAndView handleRequestDashboard(HttpSession session) {
		if(session.getAttribute("USER_OBJECT") == null){
			logger.warn("Null login rejected");
			return new ModelAndView("redirect:/");
		}
		if(session.getAttribute("USER_ADMIN").toString() != "true"){
			logger.warn("User admin login rejected: {}", session.getAttribute("USER_OBJECT").toString());
			return new ModelAndView("redirect:/");
		}	
		List<User> users = userService.findAll();
		List<Client> clients = clientService.findAllWithGalleryCount();
	
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("dashboard");
		mav.addObject("users", users);
		mav.addObject("clients", clients);
		mav.addObject("user", new User()); //For create new user form
		mav.addObject("client", new Client()); //For create new client form
		mav.addObject("baseurl", BASE_URL); //for client gallery url
	
		return mav;
	}
	
	@RequestMapping("/user/upload/{userid}")
	public ModelAndView handleRequestUserUpload(@PathVariable String userid, HttpSession session) {
		if(session.getAttribute("USER_OBJECT") == null){
			logger.warn("Null login rejected");
			return new ModelAndView("redirect:/");
		}
		if(session.getAttribute("USER_ADMIN").toString() != "true"){
			logger.warn("User admin login rejected: {}", session.getAttribute("USER_OBJECT").toString());
			return new ModelAndView("redirect:/");
		}	
		
		User user = userService.findById(userid);
		if(user == null){
			logger.warn("User id param rejected; not found. userid: {}", userid);
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView("userupload");
		mav.addObject("user", user);				
		return mav;
	}
	
	
    @RequestMapping(value="/createuser", method=RequestMethod.POST)
    public String createUser(@ModelAttribute User user, HttpSession session){
		if(session.getAttribute("USER_OBJECT") == null){
			logger.warn("Null login rejected");
			return "redirect:/";
		}
		if(session.getAttribute("USER_ADMIN").toString() != "true"){
			logger.warn("User admin login rejected: {}", session.getAttribute("USER_OBJECT").toString());
			return "redirect:/";
		}	
		
    	if(user.getUsername() != null && user.getPassword() != null && user.getPassword().length() > 0){    		
    		userService.create(user);
    	}
    	
    	return "redirect:/dashboard";
    }
    @RequestMapping(value="/createclient", method=RequestMethod.POST)
    public String createClient(@ModelAttribute Client client, HttpSession session){
		if(session.getAttribute("USER_OBJECT") == null){
			logger.warn("Null login rejected");
			return "redirect:/";
		}
		if(session.getAttribute("USER_ADMIN").toString() != "true"){
			logger.warn("User admin login rejected: {}", session.getAttribute("USER_OBJECT").toString());
			return "redirect:/";
		}	
		
    	if(client.getName() != null){
    		
    		Client result = clientService.createAndPersistClientWithAccessCode(client.getName());
    		logger.info("Created new client: {}", result);
    	}
    	else {
    		logger.info("Invalid client creation submitted: {}", client);
    	}
    	
    	    	
    	return "redirect:/dashboard";
    }
	@RequestMapping("/client/upload/{clientid}")
	public ModelAndView handleRequestClientUpload(@PathVariable String clientid, HttpSession session) {
		if(session.getAttribute("USER_OBJECT") == null){
			logger.warn("Null login rejected");
			return new ModelAndView("redirect:/");
		}
		if(session.getAttribute("USER_ADMIN").toString() != "true"){
			logger.warn("User admin login rejected: {}", session.getAttribute("USER_OBJECT").toString());
			return new ModelAndView("redirect:/");
		}	
		Client client = clientService.findById(clientid);
		
		if(client == null){
			logger.warn("User id param rejected; not found. userid: {}", client);
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView("clientupload");
		mav.addObject("client", client);				
		return mav;
	}
    
    
    @RequestMapping(value="/user/edit/{id}", method=RequestMethod.GET)
    public ModelAndView handleModUser(@PathVariable String id, HttpSession session){	    	
    	User user = userService.findById(id);
    	ModelAndView mav = new ModelAndView("useredit");
		mav.addObject("user", user);				
		return mav;
    }
    
    
    @RequestMapping(value="/user/save/", method=RequestMethod.POST)
    public String handleModUserSave(@ModelAttribute User user, HttpSession session){
		if(session.getAttribute("USER_OBJECT") == null){
			logger.warn("Null login rejected");
			return "redirect:/";
		}
		if(session.getAttribute("USER_ADMIN").toString() != "true"){
			logger.warn("User admin login rejected: {}", session.getAttribute("USER_OBJECT").toString());
			return "redirect:/";
		}	
		
    		
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
    
	@RequestMapping(value="/photos/{accessCode}")
	public ModelAndView getPhotoIdsByUserId(@PathVariable String accessCode, HttpSession session){
		if(session.getAttribute("USER_OBJECT") == null){
			logger.warn("Null login rejected");
			return new ModelAndView("redirect:/");
		}
		if(session.getAttribute("USER_ADMIN").toString() != "true"){
			logger.warn("User admin login rejected: {}", session.getAttribute("USER_OBJECT").toString());
			return new ModelAndView("redirect:/");
		}	
		
		logger.info("Accessing photo list using access code: {}", accessCode);
		Client client = mongoOperations.findOne(new Query().addCriteria(Criteria.where("accessCode.code").is(accessCode)), Client.class);
		
		
		List<String> fileIdList = gridFsService.getGridFSDBPhotoIdsByClientId(client.getId());

		ModelAndView mav = new ModelAndView("clientphotos");
		
		mav.addObject("files", fileIdList);

		return mav;
	}
	@RequestMapping(value="/photo/{photoId}")
	public @ResponseBody void getPhotoByPhotoId(HttpServletRequest request, HttpServletResponse response, @PathVariable String photoId){
		GridFSDBFile file = gridFsService.getGridFSDBFileByPhotoId(photoId);
		
		try {
			response.getOutputStream().write(IOUtils.toByteArray(file.getInputStream()));
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
