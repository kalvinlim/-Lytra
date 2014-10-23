package me.lytra.domain.facebook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comments {
	private CommentsData commentsData;
}
