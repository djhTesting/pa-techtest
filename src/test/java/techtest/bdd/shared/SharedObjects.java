package techtest.bdd.shared;

import java.util.ArrayList;
import java.util.List;

public class SharedObjects {
	private Video VideoCreated;
	
	public Video getVideoCreated() {
		return VideoCreated;
	}

	public void setVideoCreated(Video VideoCreated) {
		this.VideoCreated = VideoCreated;
	}
	
	private Playlist playlistCreated;

	public Playlist getPlaylistCreated() {
		return playlistCreated;
	}

	public void setPlaylistCreated(Playlist playlistCreated) {
		this.playlistCreated = playlistCreated;
	}
	
	private Playlist playlist;

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}
	
	private long expectedPlaylistCount;

	public long getExpectedPlaylistCount() {
		return expectedPlaylistCount;
	}

	public void setExpectedPlaylistCount(long expectedPlaylistCount) {
		this.expectedPlaylistCount = expectedPlaylistCount;
	}

	private Video Video;

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video Video) {
		this.Video = Video;
	}
	
	private long expectedSongCount;

	public long getExpectedSongCount() {
		return expectedSongCount;
	}

	public void setExpectedSongCount(long expectedSongCount) {
		this.expectedSongCount = expectedSongCount;
	} 
	
	private List<Playlist> playlists;
	
	
	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}

	private List<Video> songsList;

	public List<Video> getSongsList() {
		return songsList;
	}

	public void setSongsList(List<Video> songsList) {
		this.songsList = songsList;
	}
	
	private String knownPlaylistId;
	
	public String getKnownPlaylistId() {
		return knownPlaylistId;
	}

	public void setKnownPlaylistId(String knownPlaylistId) {
		this.knownPlaylistId = knownPlaylistId;
	}

	private String knownSongId;

	public String getKnownSongId() {
		return knownSongId;
	}

	public void setKnownSongId(String knownSongId) {
		this.knownSongId = knownSongId;
	}
	
	private AppResponse appResponse;

	public AppResponse getAppResponse() {
		return appResponse;
	}

	public void setAppResponse(AppResponse appResponse) {
		this.appResponse = appResponse;
	}
	
	
	private ArrayList<String> expectedSongsInPlaylist;

	public ArrayList<String> getExpectedSongsInPlaylist() {
		return expectedSongsInPlaylist;
	}

	public void setExpectedSongsInPlaylist(ArrayList<String> expectedSongsInPlaylist) {
		this.expectedSongsInPlaylist = expectedSongsInPlaylist;
	}
	
	private String songInPlaylistPastId;
	public String getSongInPlaylistPastId() {
		return songInPlaylistPastId;
	}

	public void setSongInPlaylistPastId(String songInPlaylistPastId) {
		this.songInPlaylistPastId = songInPlaylistPastId;
	}

	public String getSongInPlaylistFutureId() {
		return songInPlaylistFutureId;
	}

	public void setSongInPlaylistFutureId(String songInPlaylistFutureId) {
		this.songInPlaylistFutureId = songInPlaylistFutureId;
	}

	private String songInPlaylistFutureId;
	
	private String songInPlaylistTodayId;

	public String getSongInPlaylistTodayId() {
		return songInPlaylistTodayId;
	}

	public void setSongInPlaylistTodayId(String songInPlaylistTodayId) {
		this.songInPlaylistTodayId = songInPlaylistTodayId;
	}
}
