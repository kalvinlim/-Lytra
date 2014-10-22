package me.lytra.domain.facebook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class StoryTag {
	
	public StoryTag(){}
	
	private String id;
	private String name;
	private String offset;
	private String length;
	private String type;
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getOffset() {
		return offset;
	}
	public String getLength() {
		return length;
	}
	public String getType() {
		return type;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setOffset(String offset) {
		this.offset = offset;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "StoryTag [id=" + id + ", name=" + name + ", offset=" + offset + ", length=" + length + ", type=" + type + "]";
	}	
}
