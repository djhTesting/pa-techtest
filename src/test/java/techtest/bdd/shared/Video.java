package techtest.bdd.shared;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Video {
	
	public Video() {
		
	}
	
	public Video(String jsonString) {
		ObjectMapper mapper = new ObjectMapper();
		Video video = null;
		try {
			video = mapper.readValue(jsonString, Video.class);
		} catch (JsonParseException e) {
			Assert.fail(e.getMessage());
		} catch (JsonMappingException e) {
			Assert.fail(e.getMessage());
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		
		this.set__v(video.get__v());
		this.set_id(video.get_id());
		this.setArtist(video.getArtist());
		this.setdate_created(video.getdate_created());
		this.setHidden(video.getHidden());
		this.setPublishDate(video.getPublishDate());
		this.setSong(video.getSong());
	}
	
	public static List<Video> videoListFromJson(String jsonString) {
		
		List<Video> videos = null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			videos = Arrays.asList(mapper.readValue(jsonString, Video[].class));
		} catch (JsonParseException e) {
			Assert.fail(e.getMessage());
		} catch (JsonMappingException e) {
			Assert.fail(e.getMessage());
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		
		return videos;

	}
	
	public String toJson() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(this);
			
		} catch (JsonProcessingException e) {
			Assert.fail(e.getMessage());
		}
		
		return jsonString;
	}
	
	public Video(String artist, String song, String publishDate) {
		setArtist(artist);
		setSong(song);
		setPublishDate(publishDate);
	}
	
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String get__v() {
		return __v;
	}
	public void set__v(String __v) {
		this.__v = __v;
	}
	public String getdate_created() {
		return date_created;
	}
	public void setdate_created(String date_created) {
		this.date_created = date_created;
	}
	public String getHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}
	
	private String artist;
	private String song;
	private String publishDate;
	private String __v;
	private String date_created;
	private String _id;
	private String hidden;

	
}
