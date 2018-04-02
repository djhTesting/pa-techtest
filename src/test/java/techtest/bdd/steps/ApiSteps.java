package techtest.bdd.steps;

import java.util.List;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import techtest.bdd.shared.AppResponse;
import techtest.bdd.shared.FluentHandler;
import techtest.bdd.shared.SharedObjects;
import techtest.bdd.shared.Utilities;
import techtest.bdd.shared.Video;


public class ApiSteps {
	
	private SharedObjects sharedObjects;
	
	public ApiSteps(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}
	
	
	@Given("^multiple songs exist in the Daily Songs database$")
	public void multipleSongsExistInTheDailySongsDatabase() {
		List<Video> songs = getSongsList();
		
		int songsCount = songs.size();
		while(songsCount<2) {
			addSong(null);
			songsCount++;
		}
		
		sharedObjects.setExpectedSongCount(songsCount);
	}
	
	@Given("^at least (\\d+) songs exist in the Daily Songs database$")
	public void at_least_songs_exist_in_the_Daily_Songs_database(int target) throws Throwable {
		List<Video> songs = getSongsList();
		
		int songsCount = songs.size();
		while(songsCount<target) {
			addSong(null);
			songsCount++;
		}
		
		sharedObjects.setExpectedSongCount(songsCount);
	}

	
	
	@Given("^a song exists in the Daily Songs database with a known Id$")
	public void aSongExistsInTheDailySongsDatabaseWithKnownSongId() {
		multipleSongsExistInTheDailySongsDatabase();
		List<Video> songs = getSongsList();
		
		String id = songs.get(songs.size()-1).get_id();
		sharedObjects.setKnownSongId(id);
	}
	
	@When("^the list of Songs is requested$")
	public void theListOfSongsIsRequested() {
		List<Video> songs = getSongsList();
		
		sharedObjects.setSongsList(songs);
	}
	
	@Then("^all the Songs are returned in the list$") 
	public void allTheSongsAreReturnedInTheList() {
		org.junit.Assert.assertEquals("Songs list does not contain all songs", sharedObjects.getExpectedSongCount(),
				sharedObjects.getSongsList().size());
		
		
	}
	
	@When("^a song is requested using the Id$")
	public void a_song_is_requested_using_the_Id() throws Throwable {
		requestSongWithId(sharedObjects.getKnownSongId());
	}
	
	private void requestSongWithId(String id) {
		String url = "video/"+id;
		
		
		sharedObjects.setAppResponse(new FluentHandler().execGet(url));
				
		return;
	}

	@Then("^the details for the Song are returned$")
	public void the_details_for_the_Song_are_returned() throws Throwable {

		
		Video video = new Video(sharedObjects.getAppResponse().getJsonBody());
		
		Assert.assertFalse("Song details have not been returned for id: "+sharedObjects.getKnownSongId(), video==null);
		return;
	}
	
	@When("^a song is requested with an unknown Id$")
	public void a_song_is_requested_with_an_unknown_Id() throws Throwable {
	    requestSongWithId("5abcc6498f2e6f0011aaaaaa");
	}
	
	@When("^a song is requested with an invalid Id$")
	public void a_song_is_requested_with_an_invalid_Id() throws Throwable {
	    requestSongWithId("xxxxx");
	}
	
	@Then("^no data is returned in the Json response$")
	public void no_data_in_json() throws Throwable {
		Assert.assertEquals("",sharedObjects.getAppResponse().getJsonBody());
	}


	
	private void sendHttpReqAddSong(Video video) {
		
		sharedObjects.setAppResponse(new FluentHandler().execPost("video/", video.toJson()));
	}
	
	public String addSong(String publishDateIn) {
		String artist = Utilities.getRandomString(12);
		String song = Utilities.getRandomString(10);
		
		String publishDate;
		if(publishDateIn==null) {
			publishDate = Utilities.getRandomDate();
		}
		else {
			publishDate = publishDateIn;
		}
		
		Video video = new Video(artist ,song, publishDate);
		sharedObjects.setVideoCreated(video);
		
		sendHttpReqAddSong(video);
		
		video = new Video(sharedObjects.getAppResponse().getJsonBody());
		
		
		sharedObjects.setVideo(video);
		return video.get_id();
		
	
		
	}
	
	
	public List<Video> getSongsList() {
		
		
		AppResponse appResponse = new FluentHandler().execGet("video/");
		sharedObjects.setAppResponse(appResponse);
		
		String jsonString = appResponse.getJsonBody();
		
		
		List<Video> videos = Video.videoListFromJson(jsonString);

		
		return videos;
	}

	

	
	@When("^a song is added to Daily Songs via the API$")
	public void a_song_is_added_to_Daily_Songs_via_the_API() throws Throwable {
		addSong(null);
		sharedObjects.setKnownSongId(sharedObjects.getVideo().get_id());
			

		
		Video video = new Video(sharedObjects.getAppResponse().getJsonBody());
		
		org.junit.Assert.assertEquals("0", video.get__v());
		org.junit.Assert.assertEquals(sharedObjects.getVideoCreated().getSong(), video.getSong());
		org.junit.Assert.assertEquals(sharedObjects.getVideoCreated().getArtist(), video.getArtist());
		org.junit.Assert.assertEquals(sharedObjects.getVideoCreated().getPublishDate().substring(0, 10), video.getPublishDate().substring(0, 10));
		org.junit.Assert.assertTrue(video.get_id().length()==24);
		org.junit.Assert.assertTrue(video.getdate_created().substring(0, 10).equals(Utilities.getTodayPlusDays(0)));	
	}

	@Then("^the individual Song can be returned from the API$")
	public void the_individual_Song_can_be_returned_from_the_API() throws Throwable {
		requestSongWithId(sharedObjects.getKnownSongId());
		the_details_for_the_Song_are_returned();
		verifySongDetails(sharedObjects.getVideoCreated(), sharedObjects.getVideo());
	}
	
	private void verifySongDetails(Video expected, Video actual) {
		Assert.assertEquals(expected.getSong(), actual.getSong());
		Assert.assertEquals(expected.getArtist(), actual.getArtist());
		Assert.assertEquals(expected.getPublishDate()+"T00:00:00.000Z", actual.getPublishDate());
	}

	@Then("^the Song is returned in the Song list$")
	public void the_Song_is_returned_in_the_Song_list() throws Throwable {
		List<Video> videos = getSongsList();
		
		boolean found = false;
		
		for(int inx=0; inx<videos.size(); inx++) {
			if(videos.get(inx).get_id().equals(sharedObjects.getKnownSongId())) {
				verifySongDetails(sharedObjects.getVideoCreated(), videos.get(inx));
				found = true;
				break;
			}			
		}
		
		if(found==false) {
			Assert.fail("New Song has not been returned in Songs list");
		}
	}
	
	@When("^a song is added to Daily Songs via the API with invalid data$")
	public void a_song_is_added_to_Daily_Songs_via_the_API_with_invalid_data() throws Throwable {
		String artist = Utilities.getRandomString(12);
		String song = Utilities.getRandomString(10);
		String publishDate = "abc";
		
		Video Video = new Video(artist ,song, publishDate);
		sharedObjects.setVideoCreated(Video);
		
		sendHttpReqAddSong(Video);
	}

	@Then("^an error message is returned for the invalid data$")
	public void an_error_message_is_returned_for_the_invalid_data() throws Throwable {
		Assert.assertTrue(sharedObjects.getAppResponse().getJsonBody().contains("Cast to Date failed for value"));
	}
	
	@Then("^an error message is returned for the invalid Id$")
	public void an_error_message_is_returned_for_the_invalid_id() throws Throwable {
		Assert.assertTrue(sharedObjects.getAppResponse().getJsonBody().contains("Cast to ObjectId failed for value"));
	}

	@When("^a Song is updated$")
	public void a_Song_is_updated() throws Throwable {
	  
		String artist = Utilities.getRandomString(12);
		String song = Utilities.getRandomString(10);
		String publishDate = Utilities.getRandomDate();
		
		Video video = new Video(artist ,song, publishDate);
		
		
		String url = "video/5abcc6498f2e6f0011aaaaaa";
		
		sharedObjects.setAppResponse(new FluentHandler().execPatch(url, video.toJson()));
		
		return;
		
	}

	@Then("^a Not Implemented message is returned$")
	public void a_Not_Implemented_message_is_returned() throws Throwable {
		Assert.assertTrue(sharedObjects.getAppResponse().getJsonBody().contains("Not implemented"));
	}
	
	
	@When("^the song is deleted using the Id$")
	public void the_song_is_deleted_using_the_Id() throws Throwable {
	
		
		deleteSongWithId(sharedObjects.getKnownSongId());
		
	}
	
	@When("^a song deletion is requested using an unknown Id$")
	public void a_song_deletion_is_requested_using_an_unknown_Id() throws Throwable {
		deleteSongWithId("5abcc6498f2e6f0011aaaaaa");
	}
	
	@When("^a song deletion is requested using an invalid Id$")
	public void a_song_deletion_is_requested_using_an_invalid_Id() throws Throwable {
		deleteSongWithId("xxxxx");
	}
	
	private void deleteSongWithId(String id) {
		String url = "video/"+sharedObjects.getKnownSongId();
		
		sharedObjects.setAppResponse(new FluentHandler().execDelete(url));
	}
	

	@Then("^the song is removed from Daily Songs$")
	public void the_song_is_removed_from_Daily_Songs() throws Throwable {
		requestSongWithId(sharedObjects.getKnownSongId());
		org.junit.Assert.assertEquals("Song has not been deleted",
				"null", sharedObjects.getAppResponse().getJsonBody());
	}

	@Then("^a Http Status Code (\\d+) is returned$")
	public void a_Http_Status_Code_is_returned(int expectedCode) throws Throwable {
		org.junit.Assert.assertEquals("Expected return Http Status Code "+expectedCode,
				expectedCode, sharedObjects.getAppResponse().getHttpStatus());
	}
	
	

}