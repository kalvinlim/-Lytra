package me.lytra.domain.client;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class AccessCode {
	@Id
	private String id;		
	private String code;		
	private boolean expired;		
	private Date created;
	private String userId;
	
	public AccessCode(){}

	public String getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public boolean isExpired() {
		return expired;
	}

	public Date getCreated() {
		return created;
	}

	public String getUserId() {
		return userId;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "AccessCode [id=" + id + ", code=" + code + ", expired=" + expired + ", created=" + created + ", userId=" + userId + "]";
	}

	
}