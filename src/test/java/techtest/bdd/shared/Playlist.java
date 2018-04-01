package techtest.bdd.shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import techtest.bdd.shared.Video;

public class Playlist {

	public Playlist() {
	}
	public Playlist(String desc, String title) {
		setDesc(desc);
		setTitle(title);
	}
	
	private String _id;
	private String desc;
	private String title;
	private String date_created;
	private String __v;
	private ArrayList<Video> videos;
	
	
	public Playlist(String jsonString) {
		ObjectMapper mapper = new ObjectMapper();
		Playlist playlist = null;
		try {
			playlist = mapper.readValue(jsonString, Playlist.class);
		} catch (JsonParseException e) {
			Assert.fail(e.getMessage());
		} catch (JsonMappingException e) {
			Assert.fail(e.getMessage());
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		
		this.set_id(playlist.get_id());
		this.setDesc(playlist.getDesc());
		this.setTitle(playlist.getTitle());
		this.setDate_created(playlist.getDate_created());
		this.set__v(playlist.get__v());
		this.setVideos(playlist.getVideos());
	}
	
	public static List<Playlist> playlistListFromJson(String jsonString) {
		
		List<Playlist> playlist = null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			playlist = Arrays.asList(mapper.readValue(jsonString, Playlist[].class));
		} catch (JsonParseException e) {
			Assert.fail(e.getMessage());
		} catch (JsonMappingException e) {
			Assert.fail(e.getMessage());
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		
		return playlist;

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
	
	
	public static String createVideoList(ArrayList<String> idsAdd, ArrayList<String> idsRemove) {
		// Haven't got time to figure out how to do this with Jackson...
		StringBuilder jsonStrBld = new StringBuilder();
		jsonStrBld.append("{\"videos\":[");
		
		if(idsAdd!=null) {
			for(int inx=0; inx<idsAdd.size(); inx++) {			
				jsonStrBld.append("{\""+idsAdd.get(inx)+"\":\"add\"},");			
			}
		}
		if(idsRemove!=null) {
			for(int inx=0; inx<idsRemove.size(); inx++) {			
				jsonStrBld.append("{\""+idsRemove.get(inx)+"\":\"remove\"},");			
			}
		}
		String jsonString = jsonStrBld.toString();
		jsonString = jsonString.substring(0, jsonString.length()-1);
		jsonString = jsonString + "]}";
		
		return jsonString;
	}
	
	public ArrayList<Video> getVideos() {
		return videos;
	}
	public void setVideos(ArrayList<Video> videos) {
		this.videos = videos;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate_created() {
		return date_created;
	}
	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}
	public String get__v() {
		return __v;
	}
	public void set__v(String __v) {
		this.__v = __v;
	}
}
