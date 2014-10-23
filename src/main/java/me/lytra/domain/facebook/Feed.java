package me.lytra.domain.facebook;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Feed {
	public Feed(){}
	
	public List<Data> data;
	
	public Paging paging;
	
	public List<Data> getData() {
		return data;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	@Override
	public String toString() {
		return "Feed [data=" + data + ", paging=" + paging + "]";
	}
}