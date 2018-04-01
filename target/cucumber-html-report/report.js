$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("test/resources/cucumber/Playlists.feature");
formatter.feature({
  "line": 2,
  "name": "Playlists tests",
  "description": "Playlists tests description",
  "id": "playlists-tests",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@playlists"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Playlists songs are returned in Playlists list",
  "description": "",
  "id": "playlists-tests;playlists-songs-are-returned-in-playlists-list",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "multiple Playlists exist in the Daily Songs database",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "the list of Playlists is requested",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "all the Playlists are returned in the list",
  "keyword": "Then "
});
formatter.match({
  "location": "PlaylistSteps.multiplePlaylistsExistInTheDailySongsDatabase()"
});
formatter.result({
  "duration": 911336389,
  "status": "passed"
});
formatter.match({
  "location": "PlaylistSteps.theListOfPlaylistsIsRequested()"
});
formatter.result({
  "duration": 135099703,
  "status": "passed"
});
formatter.match({
  "location": "PlaylistSteps.allThePlaylistsAreReturnedInTheList()"
});
formatter.result({
  "duration": 41432,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "An individual Playlist can be requested with an Id",
  "description": "",
  "id": "playlists-tests;an-individual-playlist-can-be-requested-with-an-id",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "a Playlist exists in the Daily Songs database with a known Id",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "the Playlist is requested using the Id",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "the details for the Playlist are returned",
  "keyword": "Then "
});
formatter.match({
  "location": "PlaylistSteps.aPlaylistExistsInTheDailySongsDatabaseWithKnownId()"
});
formatter.result({
  "duration": 352128994,
  "status": "passed"
});
formatter.match({
  "location": "PlaylistSteps.a_playlists_is_requested_using_the_Id()"
});
formatter.result({
  "duration": 78545473,
  "status": "passed"
});
formatter.match({
  "location": "PlaylistSteps.the_details_for_the_Playlist_are_returned()"
});
formatter.result({
  "duration": 3850891,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Song details in Playlist are hidden where publishDate is in future",
  "description": "",
  "id": "playlists-tests;song-details-in-playlist-are-hidden-where-publishdate-is-in-future",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "a Playlist exists containing Songs with past and future publishDates",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "the Playlist is requested using the Id",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "the Song details are hidden for Songs with a future publishDate",
  "keyword": "Then "
});
formatter.match({
  "location": "PlaylistSteps.a_Playlist_exists_containing_Songs_where_the_publishDate_is_in_the_future()"
});
formatter.result({
  "duration": 486605697,
  "status": "passed"
});
formatter.match({
  "location": "PlaylistSteps.a_playlists_is_requested_using_the_Id()"
});
formatter.result({
  "duration": 92324447,
  "status": "passed"
});
formatter.match({
  "location": "PlaylistSteps.the_Song_details_are_hidden_for_Songs_with_a_future_publishDate()"
});
formatter.result({
  "duration": 115751363,
  "status": "passed"
});
formatter.scenario({
  "line": 26,
  "name": "An request for an individual Playlist with an invalid Id fails correctly",
  "description": "",
  "id": "playlists-tests;an-request-for-an-individual-playlist-with-an-invalid-id-fails-correctly",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 27,
  "name": "a Playlist is requested with an invalid Id",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "an error message is returned for the invalid Id",
  "keyword": "Then "
});
formatter.match({
  "location": "PlaylistSteps.a_Playlist_is_requested_with_an_invalid_Id()"
});
formatter.result({
  "duration": 84236854,
  "status": "passed"
});
formatter.match({
  "location": "ApiSteps.an_error_message_is_returned_for_the_invalid_id()"
});
formatter.result({
  "duration": 154325,
  "status": "passed"
});
formatter.scenario({
  "line": 30,
  "name": "A Playlist can be added to Daily Songs",
  "description": "",
  "id": "playlists-tests;a-playlist-can-be-added-to-daily-songs",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 31,
  "name": "a Playlist is added to Daily Songs via the API",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "the individual Playlist can be returned from the API",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "the Playlist is returned in the Playlist list",
  "keyword": "And "
});
formatter.match({
  "location": "PlaylistSteps.a_Playlist_is_added_to_Daily_Songs_via_the_API()"
});
formatter.result({
  "duration": 111231100,
  "status": "passed"
});
formatter.match({
  "location": "PlaylistSteps.the_individual_Playlist_can_be_returned_from_the_API()"
});
formatter.result({
  "duration": 79284026,
  "status": "passed"
});
formatter.match({
  "location": "PlaylistSteps.the_Playlist_is_returned_in_the_Playlist_list()"
});
formatter.result({
  "duration": 192816309,
  "status": "passed"
});
formatter.scenario({
  "line": 55,
  "name": "A specified number of songs can be added to a new Playlist",
  "description": "",
  "id": "playlists-tests;a-specified-number-of-songs-can-be-added-to-a-new-playlist",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 56,
  "name": "at least 20 songs exist in the Daily Songs database",
  "keyword": "Given "
});
formatter.step({
  "line": 57,
  "name": "5 Songs are added to a new Playlist",
  "keyword": "When "
});
formatter.step({
  "line": 58,
  "name": "a No Content message is returned",
  "keyword": "Then "
});
formatter.step({
  "line": 59,
  "name": "the correct Songs are stored in the Playlist",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "20",
      "offset": 9
    }
  ],
  "location": "ApiSteps.at_least_songs_exist_in_the_Daily_Songs_database(int)"
});
formatter.result({
  "duration": 129778548,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 0
    }
  ],
  "location": "PlaylistSteps.songs_are_added_to_a_play_list(int)"
});
formatter.result({
  "duration": 300867411,
  "status": "passed"
});
formatter.match({
  "location": "ApiSteps.a_No_Content_message_is_returned()"
});
formatter.result({
  "duration": 98069,
  "status": "passed"
});
formatter.match({
  "location": "PlaylistSteps.the_correct_Songs_are_stored_in_the_Playlist()"
});
formatter.result({
  "duration": 77228013,
  "status": "passed"
});
formatter.scenario({
  "line": 61,
  "name": "A specified number of songs can be added to an existing Playlist",
  "description": "",
  "id": "playlists-tests;a-specified-number-of-songs-can-be-added-to-an-existing-playlist",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 62,
  "name": "at least 20 songs exist in the Daily Songs database",
  "keyword": "Given "
});
formatter.step({
  "line": 63,
  "name": "5 Songs are added to an existing Playlist",
  "keyword": "When "
});
formatter.step({
  "line": 64,
  "name": "a No Content message is returned",
  "keyword": "Then "
});
formatter.step({
  "line": 65,
  "name": "the correct Songs are stored in the Playlist",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "20",
      "offset": 9
    }
  ],
  "location": "ApiSteps.at_least_songs_exist_in_the_Daily_Songs_database(int)"
});
formatter.result({
  "duration": 117609718,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 0
    }
  ],
  "location": "PlaylistSteps.songs_are_added_to_an_existing_Playlist(int)"
});
formatter.result({
  "duration": 528925202,
  "status": "passed"
});
formatter.match({
  "location": "ApiSteps.a_No_Content_message_is_returned()"
});
formatter.result({
  "duration": 77923,
  "status": "passed"
});
formatter.match({
  "location": "PlaylistSteps.the_correct_Songs_are_stored_in_the_Playlist()"
});
formatter.result({
  "duration": 94935039,
  "status": "passed"
});
formatter.scenario({
  "line": 67,
  "name": "The functionality to remove Songs from a Playlist is not implemented",
  "description": "",
  "id": "playlists-tests;the-functionality-to-remove-songs-from-a-playlist-is-not-implemented",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 68,
  "name": "at least 20 songs exist in the Daily Songs database",
  "keyword": "Given "
});
formatter.step({
  "line": 69,
  "name": "5 Songs are added to a new Playlist and a Song removal is requested",
  "keyword": "When "
});
formatter.step({
  "line": 70,
  "name": "a Not Implemented message is returned",
  "keyword": "Then "
});
formatter.step({
  "line": 71,
  "name": "the correct Songs are stored in the Playlist",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "20",
      "offset": 9
    }
  ],
  "location": "ApiSteps.at_least_songs_exist_in_the_Daily_Songs_database(int)"
});
formatter.result({
  "duration": 210402841,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 0
    }
  ],
  "location": "PlaylistSteps.songs_are_added_to_a_new_Playlist_and_a_Song_removal_is_requested(int)"
});
formatter.result({
  "duration": 329851910,
  "status": "passed"
});
formatter.match({
  "location": "ApiSteps.a_Not_Implemented_message_is_returned()"
});
formatter.result({
  "duration": 84005,
  "status": "passed"
});
formatter.match({
  "location": "PlaylistSteps.the_correct_Songs_are_stored_in_the_Playlist()"
});
formatter.result({
  "duration": 102705620,
  "status": "passed"
});
formatter.scenario({
  "line": 81,
  "name": "A Playlist is updated with an invalid command",
  "description": "",
  "id": "playlists-tests;a-playlist-is-updated-with-an-invalid-command",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 82,
  "name": "at least 20 songs exist in the Daily Songs database",
  "keyword": "Given "
});
formatter.step({
  "line": 83,
  "name": "5 Songs are added to a new Playlist and a invalid command is included",
  "keyword": "When "
});
formatter.step({
  "line": 84,
  "name": "a Bad Content message is returned",
  "keyword": "Then "
});
formatter.step({
  "line": 85,
  "name": "no Songs are stored in the Playlist",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "20",
      "offset": 9
    }
  ],
  "location": "ApiSteps.at_least_songs_exist_in_the_Daily_Songs_database(int)"
});
formatter.result({
  "duration": 211552672,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 0
    }
  ],
  "location": "PlaylistSteps.invalid_command_included(int)"
});
formatter.result({
  "duration": 427998114,
  "status": "passed"
});
formatter.match({
  "location": "ApiSteps.a_Bad_Content_message_is_returned()"
});
formatter.result({
  "duration": 93887,
  "status": "passed"
});
formatter.match({
  "location": "PlaylistSteps.no_Songs_are_stored_in_the_Playlist()"
});
formatter.result({
  "duration": 76374286,
  "status": "passed"
});
formatter.uri("test/resources/cucumber/Songs.feature");
formatter.feature({
  "line": 3,
  "name": "Songs tests",
  "description": "Songs tests description",
  "id": "songs-tests",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@songs"
    }
  ]
});
formatter.scenario({
  "line": 7,
  "name": "All songs are returned in Songs list",
  "description": "",
  "id": "songs-tests;all-songs-are-returned-in-songs-list",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "multiple songs exist in the Daily Songs database",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "the list of Songs is requested",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "all the Songs are returned in the list",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiSteps.multipleSongsExistInTheDailySongsDatabase()"
});
formatter.result({
  "duration": 265307395,
  "status": "passed"
});
formatter.match({
  "location": "ApiSteps.theListOfSongsIsRequested()"
});
formatter.result({
  "duration": 258487087,
  "status": "passed"
});
formatter.match({
  "location": "ApiSteps.allTheSongsAreReturnedInTheList()"
});
formatter.result({
  "duration": 83624,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "An individual song can be requested with an Id",
  "description": "",
  "id": "songs-tests;an-individual-song-can-be-requested-with-an-id",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "a song exists in the Daily Songs database with a known Id",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "a song is requested using the Id",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "the details for the Song are returned",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiSteps.aSongExistsInTheDailySongsDatabaseWithKnownSongId()"
});
formatter.result({
  "duration": 596867897,
  "status": "passed"
});
formatter.match({
  "location": "ApiSteps.a_song_is_requested_using_the_Id()"
});
formatter.result({
  "duration": 58638751,
  "status": "passed"
});
formatter.match({
  "location": "ApiSteps.the_details_for_the_Song_are_returned()"
});
formatter.result({
  "duration": 1644734,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "An request for an individual song with an invalid Id fails correctly",
  "description": "",
  "id": "songs-tests;an-request-for-an-individual-song-with-an-invalid-id-fails-correctly",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 23,
  "name": "a song is requested with an invalid Id",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "an error message is returned for the invalid Id",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiSteps.a_song_is_requested_with_an_invalid_Id()"
});
formatter.result({
  "duration": 83610814,
  "status": "passed"
});
formatter.match({
  "location": "ApiSteps.an_error_message_is_returned_for_the_invalid_id()"
});
formatter.result({
  "duration": 61957,
  "status": "passed"
});
formatter.scenario({
  "line": 26,
  "name": "A Song can be added to Daily Songs",
  "description": "",
  "id": "songs-tests;a-song-can-be-added-to-daily-songs",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 27,
  "name": "a song is added to Daily Songs via the API",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "the individual Song can be returned from the API",
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "the Song is returned in the Song list",
  "keyword": "And "
});
formatter.match({
  "location": "ApiSteps.a_song_is_added_to_Daily_Songs_via_the_API()"
});
formatter.result({
  "duration": 90790324,
  "status": "passed"
});
formatter.match({
  "location": "ApiSteps.the_individual_Song_can_be_returned_from_the_API()"
});
formatter.result({
  "duration": 62916505,
  "status": "passed"
});
formatter.match({
  "location": "ApiSteps.the_Song_is_returned_in_the_Song_list()"
});
formatter.result({
  "duration": 245719966,
  "status": "passed"
});
formatter.scenario({
  "line": 31,
  "name": "A Song cannot be added to Daily Songs with invalid data",
  "description": "",
  "id": "songs-tests;a-song-cannot-be-added-to-daily-songs-with-invalid-data",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 32,
  "name": "a song is added to Daily Songs via the API with invalid data",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "an error message is returned for the invalid data",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiSteps.a_song_is_added_to_Daily_Songs_via_the_API_with_invalid_data()"
});
formatter.result({
  "duration": 78877688,
  "status": "passed"
});
formatter.match({
  "location": "ApiSteps.an_error_message_is_returned_for_the_invalid_data()"
});
formatter.result({
  "duration": 84385,
  "status": "passed"
});
formatter.scenario({
  "line": 35,
  "name": "The functionality to update a Song is not implemented",
  "description": "",
  "id": "songs-tests;the-functionality-to-update-a-song-is-not-implemented",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 36,
  "name": "a Song is updated",
  "keyword": "When "
});
formatter.step({
  "line": 37,
  "name": "a Not Implemented message is returned",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiSteps.a_Song_is_updated()"
});
formatter.result({
  "duration": 81865730,
  "status": "passed"
});
formatter.match({
  "location": "ApiSteps.a_Not_Implemented_message_is_returned()"
});
formatter.result({
  "duration": 73361,
  "status": "passed"
});
formatter.scenario({
  "line": 39,
  "name": "An individual song can be deleted",
  "description": "",
  "id": "songs-tests;an-individual-song-can-be-deleted",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 40,
  "name": "a song exists in the Daily Songs database with a known Id",
  "keyword": "Given "
});
formatter.step({
  "line": 41,
  "name": "the song is deleted using the Id",
  "keyword": "When "
});
formatter.step({
  "line": 42,
  "name": "a No Content message is returned",
  "keyword": "Then "
});
formatter.step({
  "line": 43,
  "name": "the song is removed from Daily Songs",
  "keyword": "And "
});
formatter.match({
  "location": "ApiSteps.aSongExistsInTheDailySongsDatabaseWithKnownSongId()"
});
formatter.result({
  "duration": 436290966,
  "status": "passed"
});
formatter.match({
  "location": "ApiSteps.the_song_is_deleted_using_the_Id()"
});
formatter.result({
  "duration": 100953695,
  "status": "passed"
});
formatter.match({
  "location": "ApiSteps.a_No_Content_message_is_returned()"
});
formatter.result({
  "duration": 34590,
  "status": "passed"
});
formatter.match({
  "location": "ApiSteps.the_song_is_removed_from_Daily_Songs()"
});
formatter.result({
  "duration": 69760759,
  "status": "passed"
});
});