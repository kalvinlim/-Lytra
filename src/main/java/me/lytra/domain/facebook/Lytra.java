package me.lytra.domain.facebook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Domain model representation of the public Lytra graph api page.  
 * This is essentially the "About Lytra" information.
 * @author Kalvin
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Lytra {
	public Lytra(){}
	
	private String id;
	private String about;
	
	@JsonProperty("can_post")
	private String canPost;
	
	private String category;
	private String checkins;
	private Cover cover;
	private String description;
	
	@JsonProperty("has_added_app")
	private String hasAddedApp;
	
	@JsonProperty("is_community_page")
	private String isCommunityPage;
	
	@JsonProperty("is_published")
	private String isPublished;
	
	private String likes;
	private String link;
	private Location location;
	private String name;
	private String phone;
	
	@JsonProperty("talking_about_count")
	private String talkingAboutCount;
	private String username;
	private String website;
	
	@JsonProperty("were_here_count")
	private String wereHereCount;
	
	
	
	public String getId() {
		return id;
	}

	public String getAbout() {
		return about;
	}

	public String getCanPost() {
		return canPost;
	}

	public String getCategory() {
		return category;
	}

	public String getCheckins() {
		return checkins;
	}

	public Cover getCover() {
		return cover;
	}

	public String getDescription() {
		return description;
	}

	public String getHasAddedApp() {
		return hasAddedApp;
	}

	public String getIsCommunityPage() {
		return isCommunityPage;
	}

	public String getIsPublished() {
		return isPublished;
	}

	public String getLikes() {
		return likes;
	}

	public String getLink() {
		return link;
	}

	public Location getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getTalkingAboutCount() {
		return talkingAboutCount;
	}

	public String getUsername() {
		return username;
	}

	public String getWebsite() {
		return website;
	}

	public String getWereHereCount() {
		return wereHereCount;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public void setCanPost(String canPost) {
		this.canPost = canPost;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCheckins(String checkins) {
		this.checkins = checkins;
	}

	public void setCover(Cover cover) {
		this.cover = cover;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setHasAddedApp(String hasAddedApp) {
		this.hasAddedApp = hasAddedApp;
	}

	public void setIsCommunityPage(String isCommunityPage) {
		this.isCommunityPage = isCommunityPage;
	}

	public void setIsPublished(String isPublished) {
		this.isPublished = isPublished;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setTalkingAboutCount(String talkingAboutCount) {
		this.talkingAboutCount = talkingAboutCount;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void setWereHereCount(String wereHereCount) {
		this.wereHereCount = wereHereCount;
	}
	
	@Override
	public String toString() {
		return "Lytra [id=" + id + ", about=" + about + ", canPost=" + canPost
				+ ", category=" + category + ", checkins=" + checkins
				+ ", cover=" + cover + ", description=" + description
				+ ", hasAddedApp=" + hasAddedApp + ", isCommunityPage="
				+ isCommunityPage + ", isPublished=" + isPublished + ", likes="
				+ likes + ", link=" + link + ", location=" + location
				+ ", name=" + name + ", phone=" + phone
				+ ", talkingAboutCount=" + talkingAboutCount + ", username="
				+ username + ", website=" + website + ", wereHereCount="
				+ wereHereCount + "]";
	}


	@JsonIgnoreProperties(ignoreUnknown = true)
	private static class Cover{
		private Cover(){}
		@JsonProperty("cover_id")
		private String coverId;
		@JsonProperty("offset_x")
		private String offsetX;
		@JsonProperty("offset_y")
		private String offsetY;
		private String source;
		public String getCoverId() {
			return coverId;
		}
		public String getOffsetX() {
			return offsetX;
		}
		public String getOffsetY() {
			return offsetY;
		}
		public String getSource() {
			return source;
		}
		public void setCoverId(String coverId) {
			this.coverId = coverId;
		}
		public void setOffsetX(String offsetX) {
			this.offsetX = offsetX;
		}
		public void setOffsetY(String offsetY) {
			this.offsetY = offsetY;
		}
		public void setSource(String source) {
			this.source = source;
		}
		@Override
		public String toString() {
			return "Cover [coverId=" + coverId + ", offsetX=" + offsetX
					+ ", offsetY=" + offsetY + ", source=" + source + "]";
		}
		
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	private static class Location{
		private Location(){}
		private String city;
		private String country;
		private String state;
		public String getCity() {
			return city;
		}
		public String getCountry() {
			return country;
		}
		public String getState() {
			return state;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public void setState(String state) {
			this.state = state;
		}
		@Override
		public String toString() {
			return "Location [city=" + city + ", country=" + country
					+ ", state=" + state + "]";
		}
		
	}
}
