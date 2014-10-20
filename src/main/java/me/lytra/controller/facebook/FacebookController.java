package me.lytra.controller.facebook;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Controller
@RequestMapping("/facebook")
public class FacebookController {
	static Logger logger = LoggerFactory.getLogger(FacebookController.class);
    		
	//private Facebook facebook;
/*
    @Inject
    public FacebookController(Facebook facebook) {
        this.facebook = facebook;
    }*/


    @RequestMapping(value = "", produces = "application/json", method=RequestMethod.GET)
    public @ResponseBody String helloFacebook(Model model) {
    	logger.info("Foo");
    	RestTemplate restTemplate = new RestTemplate();
    	//Page page = restTemplate.getForObject("https://www.facebook.com/feeds/page.php?id=504848586256055&format=json", String.class);
    	
    	//String page = restTemplate.getForObject("https://www.facebook.com/feeds/page.php?id=504848586256055&format=json", Page.class);
    	//return page.toString();
    	return restTemplate.getForObject("https://www.facebook.com/feeds/page.php?id=504848586256055&format=json", Page.class).toString();
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Page {
    	
    	public Page() {}
    	
    	//@JsonProperty("title")
        //private String title;

    	private List<Entry> entries;
    	
		public List<Entry> getEntries() {
			return entries;
		}

		public void setEntries(List<Entry> entries) {
			this.entries = entries;
		}

		@Override
		public String toString() {
			return "Page [entries=" + entries + "]";
		}	
		
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Entry{
    	public Entry(){}
    	
    	private String title;

		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}

		@Override
		public String toString() {
			return "Entry [title=" + title + "]";
		}
    }

}