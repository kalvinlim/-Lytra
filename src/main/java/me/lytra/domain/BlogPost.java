package me.lytra.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;


public class BlogPost {
	
	@Id
	private String id;
	
	private String title;
	private String content;
	private Date timeStamp;
	private boolean published = false;
	private boolean deleted = false;
	
	public BlogPost(){}
	
	public BlogPost(String title, String content, Date timeStamp, boolean published, boolean deleted){}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public boolean isPublished() {
		return published;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "BlogPost [id=" + id + ", title=" + title + ", content="
				+ content + ", timeStamp=" + timeStamp + ", published="
				+ published + ", deleted=" + deleted + "]";
	}
	
	

	
}
