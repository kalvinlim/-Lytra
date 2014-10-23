package me.lytra.controller.facebook;

import me.lytra.domain.facebook.Feed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/facebook")
public class FacebookController {
	static Logger logger = LoggerFactory.getLogger(FacebookController.class);
	
	@Value("${facebook.app.id}")
	private String facebookAppId;
	
	@Value("${facebook.app.secret}")
	private String facebookAppSecret;
    		
    @RequestMapping(value = "")
    public ModelAndView helloFacebook(Model model) {
    	RestTemplate restTemplate = new RestTemplate();
    	//return restTemplate.getForObject("https://www.facebook.com/feeds/page.php?id=504848586256055&format=json", Page.class).toString();
    	
    	
    	String url = "https://graph.facebook.com/504848586256055/feed?key=value&access_token=%s|%s";
    	url = String.format(url, facebookAppId, facebookAppSecret);
    	
    	//String content = restTemplate.getForObject(url, Feed.class);
    	ModelAndView mav = new ModelAndView("facebook");    	
    	//mav.addObject("content", content);
    	return mav;
    }
    
    @RequestMapping(value = "/json", produces = "application/json", method=RequestMethod.GET)
    public @ResponseBody String helloFacebookJSON(Model model) {
    	RestTemplate restTemplate = new RestTemplate();
 
    	String url = "https://graph.facebook.com/504848586256055/feed?key=value&access_token=%s|%s";
    	url = String.format(url, facebookAppId, facebookAppSecret);
    	
    	logger.info(url);
    	Feed feed = restTemplate.getForObject(url, Feed.class);
    	String foo = restTemplate.getForObject(url, String.class);
    	return feed.toString();
  
    }   
}