package me.lytra.domain.client;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Client {
	@Id
	private String id;
	private String name;	
	private Date created;
	private boolean deleted;
		 	
	@Transient
	private Integer photos;
	
	private AccessCode accessCode;
	
	public Client(){}
	public Client(String name){
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Date getCreated() {
		return created;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public Integer getPhotos() {
		return photos;
	}
	public AccessCode getAccessCode() {
		return accessCode;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public void setPhotos(Integer photos) {
		this.photos = photos;
	}
	public void setAccessCode(AccessCode accessCode) {
		this.accessCode = accessCode;
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", created=" + created + ", deleted=" + deleted + ", photos=" + photos + ", accessCode=" + accessCode + "]";
	}


}

