package me.lytra.domain.user;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class User {
	@Id
	private String id;
	
	private String username;
	private String password;
	private Date created;
	private boolean deleted;
	private boolean admin;
	
	@Transient
	private Integer photos;
	
	public User(){}
	
	public User(String username, String password, Date created, boolean deleted, boolean admin){
		this.username = username;
		this.password = password;
		this.created = created;
		this.deleted = deleted;
		this.admin = admin;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Date getCreated() {
		return created;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public boolean isAdmin() {
		return admin;
	}
	public Integer getPhotos() {
		return photos;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public void setPhotos(Integer photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", created=" + created + ", deleted=" + deleted + ", admin=" + admin + ", photos=" + photos + "]";
	}

	
	
}
