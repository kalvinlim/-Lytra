package me.lytra.domain.facebook;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
	public Data(){}
	

	private String id;
	private From from;
	private String story;

/*	@JsonProperty("story_tags")
	private List<StoryTags> storyTags;
*/
	private String picture;
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
	private String updatedTime;
	   
	private Likes likes;
	private Comments comments;
	public String getId() {
		return id;
	}
	public From getFrom() {
		return from;
	}
	public String getStory() {
		return story;
	}
	public String getPicture() {
		return picture;
	}
	public String getLink() {
		return link;
	}
	public String getName() {
		return name;
	}
	public String getCaption() {
		return caption;
	}
	public String getIcon() {
		return icon;
	}
	public Privacy getPrivacy() {
		return privacy;
	}
	public String getType() {
		return type;
	}
	public String getStatusType() {
		return statusType;
	}
	public String getObjectId() {
		return objectId;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public String getUpdatedTime() {
		return updatedTime;
	}
	public Likes getLikes() {
		return likes;
	}
	public Comments getComments() {
		return comments;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setFrom(From from) {
		this.from = from;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public void setPrivacy(Privacy privacy) {
		this.privacy = privacy;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}
	public void setLikes(Likes likes) {
		this.likes = likes;
	}
	public void setComments(Comments comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Data [id=" + id + ", from=" + from + ", story=" + story
				+ ", picture=" + picture + ", link=" + link + ", name=" + name
				+ ", caption=" + caption + ", icon=" + icon + ", privacy="
				+ privacy + ", type=" + type + ", statusType=" + statusType
				+ ", objectId=" + objectId + ", createdTime=" + createdTime
				+ ", updatedTime=" + updatedTime + ", likes=" + likes
				+ ", comments=" + comments + "]";
	}
	
	
}