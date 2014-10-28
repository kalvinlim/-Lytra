package me.lytra.service.facebook;

import me.lytra.domain.facebook.Feed;
import me.lytra.domain.facebook.Lytra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LytraFacebookService {
	static Logger logger = LoggerFactory.getLogger(LytraFacebookService.class);
	
	@Value("${facebook.page.id}")
	private String facebookPageId;
	
	@Value("${facebook.app.id}")
	private String facebookAppId;
	
	@Value("${facebook.app.secret}")
	private String facebookAppSecret;
	
	public Lytra getLytra(){
		RestTemplate restTemplate = new RestTemplate();
		 
    	String url = "https://graph.facebook.com/%s";
    	url = String.format(url, facebookPageId);
    	
    	Lytra lytra = restTemplate.getForObject(url, Lytra.class);
    	
    	return lytra;
	}
	public Feed getFeed(){
	 	RestTemplate restTemplate = new RestTemplate();
	 	 
    	String url = "https://graph.facebook.com/%s/feed?key=value&access_token=%s|%s";
    	url = String.format(url, facebookPageId, facebookAppId, facebookAppSecret);
    	
    	Feed feed = restTemplate.getForObject(url, Feed.class);
   
    	return feed;
	}
	public String getProfileImageUrl(){
		RestTemplate restTemplate = new RestTemplate();
	 	String url = "https://graph.facebook.com/%s/picture";
		url = String.format(url, facebookPageId);
		logger.info("{}", restTemplate.getForObject(url, String.class));
		return url;
	}
	
}
