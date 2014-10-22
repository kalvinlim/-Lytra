package me.lytra.domain.facebook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Likes {
	public Likes(){}
	private LikeData likeData;

	public LikeData getLikeData() {
		return likeData;
	}

	public void setLikeData(LikeData likeData) {
		this.likeData = likeData;
	}

	@Override
	public String toString() {
		return "Likes [likeData=" + likeData + "]";
	}

}


