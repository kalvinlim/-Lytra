package me.lytra.controller.facebook;

import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


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
    	String content = restTemplate.getForObject("https://www.facebook.com/feeds/page.php?id=504848586256055&format=json", Page.class).getEntries().get(0).getContent();
    	ModelAndView mav = new ModelAndView("facebook");    	
    	mav.addObject("content", content);
    	return mav;
    }
    
    @RequestMapping(value = "/json", produces = "application/json", method=RequestMethod.GET)
    public @ResponseBody String helloFacebookJSON(Model model) {
    	RestTemplate restTemplate = new RestTemplate();
 
    	String url = "https://graph.facebook.com/504848586256055/feed?key=value&access_token=";
    	Feed feed = restTemplate.getForObject(url, Feed.class);
    	return feed.toString();
  
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Feed {
    	public Feed(){}
    	
    	private List <Data> data;
    	private Paging paging;
		public List<Data> getData() {
			return data;
		}
		public void setData(List<Data> data) {
			this.data = data;
		}
		public Paging getPaging() {
			return paging;
		}
		public void setPaging(Paging paging) {
			this.paging = paging;
		}
		@Override
		public String toString() {
			return "Feed [data=" + data + ", paging=" + paging + "]";
		}
    	
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Paging {
    	String previous;
    	String next;
		public String getPrevious() {
			return previous;
		}
		public void setPrevious(String previous) {
			this.previous = previous;
		}
		public String getNext() {
			return next;
		}
		public void setNext(String next) {
			this.next = next;
		}
		@Override
		public String toString() {
			return "Paging [previous=" + previous + ", next=" + next + "]";
		}
    	
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
    	public Data(){}
    	
    	String id;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return "Data [id=" + id + "]";
		}
    	
    
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Page {
    	
    	public Page() {}
    	
    	//@JsonProperty("title")
        private String title;
        private String link;
        private String self;
        private String updated;
        private String icon;        
    	private List<Entry> entries;
		public String getTitle() {
			return title;
		}
		public String getLink() {
			return link;
		}
		public String getSelf() {
			return self;
		}
		public String getUpdated() {
			return updated;
		}
		public String getIcon() {
			return icon;
		}
		public List<Entry> getEntries() {
			return entries;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public void setLink(String link) {
			this.link = link;
		}
		public void setSelf(String self) {
			this.self = self;
		}
		public void setUpdated(String updated) {
			this.updated = updated;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		public void setEntries(List<Entry> entries) {
			this.entries = entries;
		}
		@Override
		public String toString() {
			return "Page [title=" + title + ", link=" + link + ", self=" + self + ", updated=" + updated + ", icon=" + icon + ", entries=" + entries + "]";
		}
    	
    	
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Entry{
    	public Entry(){}
    	
    	private String title;
    	private String id;
    	private String alternate;
    	private String updated;
    	private String published;
    	private String verb;
    	private String target;
    	private String comments;
    	private String likes;
    	private String content;
		public String getTitle() {
			return title;
		}
		public String getId() {
			return id;
		}
		public String getAlternate() {
			return alternate;
		}
		public String getUpdated() {
			return updated;
		}
		public String getPublished() {
			return published;
		}
		public String getVerb() {
			return verb;
		}
		public String getTarget() {
			return target;
		}
		public String getComments() {
			return comments;
		}
		public String getLikes() {
			return likes;
		}
		public String getContent() {
			return content;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public void setId(String id) {
			this.id = id;
		}
		public void setAlternate(String alternate) {
			this.alternate = alternate;
		}
		public void setUpdated(String updated) {
			this.updated = updated;
		}
		public void setPublished(String published) {
			this.published = published;
		}
		public void setVerb(String verb) {
			this.verb = verb;
		}
		public void setTarget(String target) {
			this.target = target;
		}
		public void setComments(String comments) {
			this.comments = comments;
		}
		public void setLikes(String likes) {
			this.likes = likes;
		}
		public void setContent(String content) {
			this.content = content;
		}
		@Override
		public String toString() {
			return "Entry [title=" + title + ", id=" + id + ", alternate=" + alternate + ", updated=" + updated + ", published=" + published + ", verb=" + verb + ", target=" + target + ", comments="
					+ comments + ", likes=" + likes + ", content=" + content + "]";
		}
    	
    	
    }

}