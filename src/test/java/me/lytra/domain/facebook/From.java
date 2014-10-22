package me.lytra.domain.facebook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class From {
	
	public From(){}
	
	private String category;
	private String name;
	private String id;
	public String getCategory() {
		return category;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "From [category=" + category + ", name=" + name + ", id=" + id + "]";
	}	
}
