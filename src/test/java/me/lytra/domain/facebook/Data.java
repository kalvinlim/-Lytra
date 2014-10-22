package me.lytra.domain.facebook;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
	public Data(){}
	
	private String id;
	//private From from;
	private String story;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	@Override
	public String toString() {
		return "Data [id=" + id + ", story=" + story + "]";
	}

/*	@JsonProperty("story_tags")
	private List<StoryTag> storyTags;*/
/*	private String picture;
	private String link;
	private String name;
	private String caption;
	private String icon;
	private Privacy privacy;
	private String type;
	
	@JsonProperty("status_type")
	private String statusType;	
	
	@JsonProperty("object_id")
    private String objectId;
	
	@JsonProperty("created_time")
    private String createdTime;
	
	@JsonProperty("updated_time")
    private String updatedTtime;
    
	private Likes likes;*/
    //private Comments comments;


	
}