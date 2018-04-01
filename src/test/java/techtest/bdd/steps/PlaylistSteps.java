package techtest.bdd.steps;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import techtest.bdd.shared.AppResponse;
import techtest.bdd.shared.FluentHandler;
import techtest.bdd.shared.Playlist;
import techtest.bdd.shared.SharedObjects;
import techtest.bdd.shared.Utilities;
import techtest.bdd.shared.Video;

public class PlaylistSteps {
	
	private SharedObjects sharedObjects;
	
	public PlaylistSteps(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}
	
	
	
	@Given("^multiple Playlists exist in the Daily Songs database$")
	public void multiplePlaylistsExistInTheDailySongsDatabase() {
		List<Playlist> playlists = getPlaylists();
		
		int playlistsCount = playlists.size();
		while(playlistsCount<2) {
			addPlaylist();
			playlistsCount++;
		}
		
		sharedObjects.setExpectedPlaylistCount(playlistsCount);
	}
	
	private void addPlaylist() {
		String desc = Utilities.getRandomString(12);
		String title = Utilities.getRandomString(12);
		
		Playlist playlist = new Playlist(desc ,title);
		sharedObjects.setPlaylistCreated(playlist);
		
		sendHttpReqAddPlaylist(playlist);
				
		sharedObjects.setPlaylist(new Playlist(sharedObjects.getAppResponse().getJsonBody()));
		return;		
	}
	
	private void sendHttpReqAddPlaylist(Playlist playlist) {
		
		String url = "playlist/";
		
		sharedObjects.setAppResponse(new FluentHandler().execPost(url, playlist.toJson()));
	}
	
	
	@Given("^a Playlist exists in the Daily Songs database with a known Id$")
	public void aPlaylistExistsInTheDailySongsDatabaseWithKnownId() {
		multiplePlaylistsExistInTheDailySongsDatabase();
		List<Playlist> playlists = getPlaylists();
		
		String id = playlists.get(playlists.size()-1).get_id();
		sharedObjects.setKnownPlaylistId(id);
	}
	
	@When("^the list of Playlists is requested$")
	public void theListOfPlaylistsIsRequested() {
		List<Playlist> playlists = getPlaylists();
		
		sharedObjects.setPlaylists(playlists);
	}
	
	@Then("^all the Playlists are returned in the list$") 
	public void allThePlaylistsAreReturnedInTheList() {
		org.junit.Assert.assertEquals("Playlist list does not contain all Playlists", sharedObjects.getExpectedPlaylistCount(),
				sharedObjects.getPlaylists().size());
	}
	
	@When("^the Playlist is requested using the Id$")
	public void a_playlists_is_requested_using_the_Id() throws Throwable {
		requestPlaylistWithId(sharedObjects.getKnownPlaylistId());
	}
	
	private void requestPlaylistWithId(String id) {
		String url = "playlist/"+id;
		
		sharedObjects.setAppResponse(new FluentHandler().execGet(url));
		return;
	}

	@Then("^the details for the Playlist are returned$")
	public void the_details_for_the_Playlist_are_returned() throws Throwable {
		
		org.junit.Assert.assertEquals("Get Playlist by Id should return http status code 200 for id "+sharedObjects.getKnownPlaylistId(),
				200, sharedObjects.getAppResponse().getHttpStatus());
		
		// Could check the actual details here, but this would be done nicer
		// in the Post new Playlist tests, so just check an actual Playlist has 
		// been returned...
		
		Playlist playlist = new Playlist(sharedObjects.getAppResponse().getJsonBody());
		
		
		Assert.assertFalse("Playlist details have not been returned for id: "+sharedObjects.getKnownPlaylistId(), playlist==null);
		return;
	}
	
	@When("^a Playlist is requested with an unknown Id$")
	public void a_Playlist_is_requested_with_an_unknown_Id() throws Throwable {
	    requestPlaylistWithId("5abcc6498f2e6f0011aaaaaa");
	}
	
	@When("^a Playlist is requested with an invalid Id$")
	public void a_Playlist_is_requested_with_an_invalid_Id() throws Throwable {
	    requestPlaylistWithId("xxxxx");
	}

	private List<Playlist> getPlaylists() {
		String url = "playlist/";
		
		AppResponse appResponse = new FluentHandler().execGet(url);
		Assert.assertEquals(200, appResponse.getHttpStatus());
		
		List<Playlist> playlists = Playlist.playlistListFromJson(appResponse.getJsonBody());
	
		
		return playlists;
	}
	
	@When("^a Playlist is added to Daily Songs via the API$")
	public void a_Playlist_is_added_to_Daily_Songs_via_the_API() throws Throwable {
		addPlaylist();
		sharedObjects.setKnownPlaylistId(sharedObjects.getPlaylist().get_id());
		
	
		org.junit.Assert.assertEquals("Adding a Playlist by Id should return http status code 201",
				201, sharedObjects.getAppResponse().getHttpStatus());
		
		Playlist playlist = new Playlist(sharedObjects.getAppResponse().getJsonBody());
		
		org.junit.Assert.assertEquals("0", playlist.get__v());
		org.junit.Assert.assertEquals(sharedObjects.getPlaylistCreated().getDesc(), playlist.getDesc());
		org.junit.Assert.assertEquals(sharedObjects.getPlaylistCreated().getTitle(), playlist.getTitle());
		org.junit.Assert.assertTrue(playlist.get_id().length()==24);
		org.junit.Assert.assertTrue(playlist.getVideos().size()==0);
		org.junit.Assert.assertTrue(playlist.getDate_created().substring(0, 10).equals(Utilities.getTodayPlusDays(0)));		
	}

	@Then("^the individual Playlist can be returned from the API$")
	public void the_individual_Playlist_can_be_returned_from_the_API() throws Throwable {
		requestPlaylistWithId(sharedObjects.getKnownPlaylistId());
		the_details_for_the_Playlist_are_returned();
		verifyPlaylistDetails(sharedObjects.getPlaylistCreated(), sharedObjects.getPlaylist());
	}
	
	private void verifyPlaylistDetails(Playlist expected, Playlist actual) {
		Assert.assertEquals(expected.getDesc(), actual.getDesc());
		Assert.assertEquals(expected.getTitle(), actual.getTitle());
	}

	@Then("^the Playlist is returned in the Playlist list$")
	public void the_Playlist_is_returned_in_the_Playlist_list() throws Throwable {
		List<Playlist> playlists = getPlaylists();
		
		boolean found = false;
		
		for(int inx=0; inx<playlists.size(); inx++) {
			if(playlists.get(inx).get_id().equals(sharedObjects.getKnownPlaylistId())) {
				verifyPlaylistDetails(sharedObjects.getPlaylistCreated(), playlists.get(inx));
				found = true;
				break;
			}			
		}
		
		if(found==false) {
			Assert.fail("New Playlist has not been returned in Playlist list");
		}
	}
	
	

	
	

	
	
	@When("^the Playlist is deleted using the Id$")
	public void the_Playlist_is_deleted_using_the_Id() throws Throwable {
	
		
		deletePlaylistWithId(sharedObjects.getKnownPlaylistId());
		
	}
	
	@When("^a Playlist deletion is requested using an unknown Id$")
	public void a_Playlist_deletion_is_requested_using_an_unknown_Id() throws Throwable {
		deletePlaylistWithId("5abcc6498f2e6f0011aaaaaa");
	}
	
	@When("^a Playlist deletion is requested using an invalid Id$")
	public void a_Playlist_deletion_is_requested_using_an_invalid_Id() throws Throwable {
		deletePlaylistWithId("xxxxx");
	}
	
	private void deletePlaylistWithId(String id) {
		String url = "playlist/"+sharedObjects.getKnownPlaylistId();
		
		sharedObjects.setAppResponse(new FluentHandler().execDelete(url));		
	}
	

	@Then("^the Playlist is removed from Daily Songs$")
	public void the_Playlist_is_removed_from_Daily_Songs() throws Throwable {
		requestPlaylistWithId(sharedObjects.getKnownPlaylistId());
		org.junit.Assert.assertEquals("Playlist has not been deleted",
				"null", sharedObjects.getAppResponse().getJsonBody());
	}
	
	private void sendPlaylistPatchReq(String id, String jsonString) {
		String url = "playlist/"+id;
		sharedObjects.setAppResponse(new FluentHandler().execPatch(url, jsonString));
	}
	
	@When("^(\\d+) Songs are added to a new Playlist$")
	public void songs_are_added_to_a_play_list(int songCount) throws Throwable {
		a_Playlist_is_added_to_Daily_Songs_via_the_API();
		
		List<Video> songs = new ApiSteps(sharedObjects).getSongsList();
		ArrayList<String> songsInPlaylist = new ArrayList<String>(){};
		
		
		for(int inx=0; inx<songCount; inx++) {
			songsInPlaylist.add(songs.get(inx).get_id());
		}
		
		sharedObjects.setExpectedSongsInPlaylist(songsInPlaylist);

		sendPlaylistPatchReq(sharedObjects.getKnownPlaylistId(), Playlist.createVideoList(songsInPlaylist, null));
		
		
		
	
		
	}

	@Then("^the correct Songs are stored in the Playlist$")
	public void the_correct_Songs_are_stored_in_the_Playlist() throws Throwable {
		requestPlaylistWithId(sharedObjects.getKnownPlaylistId());

		
		Playlist playlist = new Playlist(sharedObjects.getAppResponse().getJsonBody());
		
		
		org.junit.Assert.assertEquals("Incorrect number of songs in Playlist",sharedObjects.getExpectedSongsInPlaylist().size(), playlist.getVideos().size());
		for(int inx=0; inx<playlist.getVideos().size(); inx++) {
			boolean found = false;
			for(int jnx=0; jnx<sharedObjects.getExpectedSongsInPlaylist().size(); jnx++) {
				if(sharedObjects.getExpectedSongsInPlaylist().get(jnx).equals(playlist.getVideos().get(inx).get_id())) {
					found = true;
					break;
				}
			}
			org.junit.Assert.assertTrue("Expected Song not found in Playlist",found);
		}
	}
	
	@Then("^no Songs are stored in the Playlist$")
	public void no_Songs_are_stored_in_the_Playlist() throws Throwable {
		requestPlaylistWithId(sharedObjects.getKnownPlaylistId());

		
		Playlist playlist = new Playlist(sharedObjects.getAppResponse().getJsonBody());
		
		
		org.junit.Assert.assertEquals("No songs should be stored in Playlist",0, playlist.getVideos().size());
		
	}
	
	@When("^(\\d+) Songs are added to an existing Playlist$")
	public void songs_are_added_to_an_existing_Playlist(int songCount) throws Throwable {
		songs_are_added_to_a_play_list(songCount);
		
		List<Video> songs = new ApiSteps(sharedObjects).getSongsList();
		ArrayList<String> extendedSongsInPlaylist = sharedObjects.getExpectedSongsInPlaylist();
		ArrayList<String> newSongsInPlaylist = new ArrayList<String>(){};
		
		for(int inx=0; inx<songCount; inx++) {
			extendedSongsInPlaylist.add(songs.get((songs.size()-1)-inx).get_id());
			newSongsInPlaylist.add(songs.get((songs.size()-1)-inx).get_id());
		}		
		
		sharedObjects.setExpectedSongsInPlaylist(extendedSongsInPlaylist);		
		sendPlaylistPatchReq(sharedObjects.getKnownPlaylistId(), Playlist.createVideoList(newSongsInPlaylist, null));
		
	}
	
	@When("^(\\d+) Songs are added to a new Playlist and a Song removal is requested$")
	public void songs_are_added_to_a_new_Playlist_and_a_Song_removal_is_requested(int songCount) throws Throwable {
		a_Playlist_is_added_to_Daily_Songs_via_the_API();
		
		List<Video> songs = new ApiSteps(sharedObjects).getSongsList();
		ArrayList<String> songsInPlaylistAdd = new ArrayList<String>(){};
		ArrayList<String> songsInPlaylistARemove = new ArrayList<String>(){};
		
		
		for(int inx=0; inx<songCount; inx++) {
			String id = songs.get(inx).get_id();
			songsInPlaylistAdd.add(id);
		}
		String id = songs.get(songCount).get_id();
		songsInPlaylistARemove.add(id);
		
		sharedObjects.setExpectedSongsInPlaylist(new ArrayList<String>(){});
		
		sendPlaylistPatchReq(sharedObjects.getKnownPlaylistId(), Playlist.createVideoList(songsInPlaylistAdd, songsInPlaylistARemove));
	}
	
	@When("^(\\d+) Songs are added to a new Playlist and a invalid command is included$")
	public void invalid_command_included(int songCount) throws Throwable {
		a_Playlist_is_added_to_Daily_Songs_via_the_API();
		
		List<Video> songs = new ApiSteps(sharedObjects).getSongsList();
		ArrayList<String> songsInPlaylist = new ArrayList<String>(){};
		
		
		for(int inx=0; inx<songCount; inx++) {
			songsInPlaylist.add(songs.get(inx).get_id());
		}
		
		
		
		sharedObjects.setExpectedSongsInPlaylist(songsInPlaylist);

		sendPlaylistPatchReq(sharedObjects.getKnownPlaylistId(), Playlist.createVideoList(songsInPlaylist, null).replace("add", "madeUpCommand"));
	}

	@Then("^the Playlist version number is updated$")
	public void the_Playlist_version_number_is_updated() throws Throwable {
		requestPlaylistWithId(sharedObjects.getKnownPlaylistId());
		
		Playlist playlist = new Playlist(sharedObjects.getAppResponse().getJsonBody());
				
		org.junit.Assert.assertEquals("Version number not updated in Playlist","1", playlist.get__v());
		
	}

	@Given("^a Playlist exists containing Songs with past and future publishDates$")
	public void a_Playlist_exists_containing_Songs_where_the_publishDate_is_in_the_future() throws Throwable {
		a_Playlist_is_added_to_Daily_Songs_via_the_API();
		String pastId = new ApiSteps(sharedObjects).addSong(Utilities.getTodayPlusDays(-1));
		sharedObjects.setSongInPlaylistPastId(pastId);
		String todayId = new ApiSteps(sharedObjects).addSong(Utilities.getTodayPlusDays(0));
		sharedObjects.setSongInPlaylistTodayId(todayId);
		String futureId = new ApiSteps(sharedObjects).addSong(Utilities.getTodayPlusDays(1));
		sharedObjects.setSongInPlaylistFutureId(futureId);
		
		ArrayList<String> ids = new ArrayList(){};
		
		ids.add(pastId);
		ids.add(todayId);
		ids.add(futureId);
		
		
		sendPlaylistPatchReq(sharedObjects.getKnownPlaylistId(), Playlist.createVideoList(ids, null));
		
	}
	
	@Then("^the Song details are hidden for Songs with a future publishDate$")
	public void the_Song_details_are_hidden_for_Songs_with_a_future_publishDate() throws Throwable {

		requestPlaylistWithId(sharedObjects.getKnownPlaylistId());
		
		Playlist playlist = new Playlist(sharedObjects.getAppResponse().getJsonBody());
		
		
		boolean pastFound = false;
		boolean todayFound = false;
		boolean futureFound = false;
		
		for(int inx=0; inx<playlist.getVideos().size(); inx++) {
			if(playlist.getVideos().get(inx).get_id().equals(sharedObjects.getSongInPlaylistPastId())) {
				pastFound = true;
				org.junit.Assert.assertEquals("Song with past publishDate should NOT be hidden","false", playlist.getVideos().get(inx).getHidden());
				org.junit.Assert.assertFalse(playlist.getVideos().get(inx).get_id()==null);
				org.junit.Assert.assertFalse(playlist.getVideos().get(inx).getSong()==null);
				org.junit.Assert.assertFalse(playlist.getVideos().get(inx).getArtist()==null);
				org.junit.Assert.assertFalse(playlist.getVideos().get(inx).getPublishDate()==null);
				org.junit.Assert.assertFalse(playlist.getVideos().get(inx).getdate_created()==null);
				org.junit.Assert.assertFalse(playlist.getVideos().get(inx).get__v()==null);
			}
			if(playlist.getVideos().get(inx).get_id().equals(sharedObjects.getSongInPlaylistTodayId())) {
				todayFound = true;
				org.junit.Assert.assertEquals("Song with past publishDate should NOT be hidden","false", playlist.getVideos().get(inx).getHidden());
				org.junit.Assert.assertFalse(playlist.getVideos().get(inx).get_id()==null);
				org.junit.Assert.assertFalse(playlist.getVideos().get(inx).getSong()==null);
				org.junit.Assert.assertFalse(playlist.getVideos().get(inx).getArtist()==null);
				org.junit.Assert.assertFalse(playlist.getVideos().get(inx).getPublishDate()==null);
				org.junit.Assert.assertFalse(playlist.getVideos().get(inx).getdate_created()==null);
				org.junit.Assert.assertFalse(playlist.getVideos().get(inx).get__v()==null);
			}
			if(playlist.getVideos().get(inx).get_id().equals(sharedObjects.getSongInPlaylistFutureId())) {
				futureFound = true;
				org.junit.Assert.assertEquals("Song with future publishDate should be hidden","true", playlist.getVideos().get(inx).getHidden());
				org.junit.Assert.assertFalse(playlist.getVideos().get(inx).get_id()==null);
				org.junit.Assert.assertTrue(playlist.getVideos().get(inx).getSong()==null);
				org.junit.Assert.assertTrue(playlist.getVideos().get(inx).getArtist()==null);
				org.junit.Assert.assertTrue(playlist.getVideos().get(inx).getPublishDate()==null);
				org.junit.Assert.assertTrue(playlist.getVideos().get(inx).getdate_created()==null);
				org.junit.Assert.assertTrue(playlist.getVideos().get(inx).get__v()==null);
			}
		}
		org.junit.Assert.assertTrue(pastFound==true && todayFound && futureFound==true);
		
	}
}
