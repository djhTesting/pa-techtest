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
  "comments": [
    {
      "line": 23,
      "value": "# Fails as request with unknown id causes \"no http response\" error"
    }
  ],
  "line": 25,
  "name": "An request for an individual Playlist with a valid unknown Id fails correctly",
  "description": "",
  "id": "playlists-tests;an-request-for-an-individual-playlist-with-a-valid-unknown-id-fails-correctly",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 24,
      "name": "@failTest"
    }
  ]
});
formatter.step({
  "line": 26,
  "name": "a Playlist is requested with an unknown Id",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "a Http Status Code 404 is returned",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "no data is returned in the Json response",
  "keyword": "And "
});
formatter.match({
  "location": "PlaylistSteps.a_Playlist_is_requested_with_an_unknown_Id()"
});
formatter.result({
  "duration": 4340551948,
  "error_message": "java.lang.AssertionError: turing.niallbunting.com:3005 failed to respond\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat techtest.bdd.shared.FluentHandler.execGet(FluentHandler.java:23)\r\n\tat techtest.bdd.steps.PlaylistSteps.requestPlaylistWithId(PlaylistSteps.java:90)\r\n\tat techtest.bdd.steps.PlaylistSteps.a_Playlist_is_requested_with_an_unknown_Id(PlaylistSteps.java:111)\r\n\tat ✽.When a Playlist is requested with an unknown Id(test/resources/cucumber/Playlists.feature:26)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "404",
      "offset": 19
    }
  ],
  "location": "ApiSteps.a_Http_Status_Code_is_returned(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ApiSteps.no_data_in_json()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "comments": [
    {
      "line": 41,
      "value": "# Delete works, but final verification step fails as request with unknown id causes \"no http response\" error"
    }
  ],
  "line": 43,
  "name": "An individual Playlist can be deleted",
  "description": "",
  "id": "playlists-tests;an-individual-playlist-can-be-deleted",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 42,
      "name": "@failTest"
    }
  ]
});
formatter.step({
  "line": 44,
  "name": "a Playlist exists in the Daily Songs database with a known Id",
  "keyword": "Given "
});
formatter.step({
  "line": 45,
  "name": "the Playlist is deleted using the Id",
  "keyword": "When "
});
formatter.step({
  "line": 46,
  "name": "a Http Status Code 204 is returned",
  "keyword": "Then "
});
formatter.step({
  "line": 47,
  "name": "the Playlist is removed from Daily Songs",
  "keyword": "And "
});
formatter.match({
  "location": "PlaylistSteps.aPlaylistExistsInTheDailySongsDatabaseWithKnownId()"
});
formatter.result({
  "duration": 1840076616,
  "status": "passed"
});
formatter.match({
  "location": "PlaylistSteps.the_Playlist_is_deleted_using_the_Id()"
});
formatter.result({
  "duration": 77735555,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "204",
      "offset": 19
    }
  ],
  "location": "ApiSteps.a_Http_Status_Code_is_returned(int)"
});
formatter.result({
  "duration": 4077100,
  "status": "passed"
});
formatter.match({
  "location": "PlaylistSteps.the_Playlist_is_removed_from_Daily_Songs()"
});
formatter.result({
  "duration": 3855329062,
  "error_message": "java.lang.AssertionError: turing.niallbunting.com:3005 failed to respond\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat techtest.bdd.shared.FluentHandler.execGet(FluentHandler.java:23)\r\n\tat techtest.bdd.steps.PlaylistSteps.requestPlaylistWithId(PlaylistSteps.java:90)\r\n\tat techtest.bdd.steps.PlaylistSteps.the_Playlist_is_removed_from_Daily_Songs(PlaylistSteps.java:212)\r\n\tat ✽.And the Playlist is removed from Daily Songs(test/resources/cucumber/Playlists.feature:47)\r\n",
  "status": "failed"
});
formatter.scenario({
  "comments": [
    {
      "line": 49,
      "value": "# Fails as request with unknown id causes \"no http response\" error"
    }
  ],
  "line": 51,
  "name": "A Playlist deletetion request with an unknown id is handled correctly",
  "description": "",
  "id": "playlists-tests;a-playlist-deletetion-request-with-an-unknown-id-is-handled-correctly",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 50,
      "name": "@failTest"
    }
  ]
});
formatter.step({
  "line": 52,
  "name": "a Playlist deletion is requested using an unknown Id",
  "keyword": "When "
});
formatter.step({
  "line": 53,
  "name": "a Http Status Code 204 is returned",
  "keyword": "Then "
});
formatter.match({
  "location": "PlaylistSteps.a_Playlist_deletion_is_requested_using_an_unknown_Id()"
});
formatter.result({
  "duration": 5160791184,
  "error_message": "java.lang.AssertionError: turing.niallbunting.com:3005 failed to respond\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat techtest.bdd.shared.FluentHandler.execDelete(FluentHandler.java:73)\r\n\tat techtest.bdd.steps.PlaylistSteps.deletePlaylistWithId(PlaylistSteps.java:206)\r\n\tat techtest.bdd.steps.PlaylistSteps.a_Playlist_deletion_is_requested_using_an_unknown_Id(PlaylistSteps.java:195)\r\n\tat ✽.When a Playlist deletion is requested using an unknown Id(test/resources/cucumber/Playlists.feature:52)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "204",
      "offset": 19
    }
  ],
  "location": "ApiSteps.a_Http_Status_Code_is_returned(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "comments": [
    {
      "line": 55,
      "value": "# Fails as request with invalid id causes \"no http response\" error"
    }
  ],
  "line": 57,
  "name": "A Playlist deletetion request with an invalid id is handled correctly",
  "description": "",
  "id": "playlists-tests;a-playlist-deletetion-request-with-an-invalid-id-is-handled-correctly",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 56,
      "name": "@failTest"
    }
  ]
});
formatter.step({
  "line": 58,
  "name": "a Playlist deletion is requested using an invalid Id",
  "keyword": "When "
});
formatter.step({
  "line": 59,
  "name": "a Http Status Code 500 is returned",
  "keyword": "Then "
});
formatter.step({
  "line": 60,
  "name": "an error message is returned for the invalid Id",
  "keyword": "And "
});
formatter.match({
  "location": "PlaylistSteps.a_Playlist_deletion_is_requested_using_an_invalid_Id()"
});
formatter.result({
  "duration": 5147662433,
  "error_message": "java.lang.AssertionError: turing.niallbunting.com:3005 failed to respond\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat techtest.bdd.shared.FluentHandler.execDelete(FluentHandler.java:73)\r\n\tat techtest.bdd.steps.PlaylistSteps.deletePlaylistWithId(PlaylistSteps.java:206)\r\n\tat techtest.bdd.steps.PlaylistSteps.a_Playlist_deletion_is_requested_using_an_invalid_Id(PlaylistSteps.java:200)\r\n\tat ✽.When a Playlist deletion is requested using an invalid Id(test/resources/cucumber/Playlists.feature:58)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "500",
      "offset": 19
    }
  ],
  "location": "ApiSteps.a_Http_Status_Code_is_returned(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ApiSteps.an_error_message_is_returned_for_the_invalid_id()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "comments": [
    {
      "line": 80,
      "value": "# I am guessing that the version number should be updated in the Playlist when it is updated..."
    }
  ],
  "line": 82,
  "name": "The version number is updated when an existing Playlist is updated",
  "description": "",
  "id": "playlists-tests;the-version-number-is-updated-when-an-existing-playlist-is-updated",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 81,
      "name": "@failTest"
    }
  ]
});
formatter.step({
  "line": 83,
  "name": "at least 20 songs exist in the Daily Songs database",
  "keyword": "Given "
});
formatter.step({
  "line": 84,
  "name": "5 Songs are added to an existing Playlist",
  "keyword": "When "
});
formatter.step({
  "line": 85,
  "name": "a Http Status Code 204 is returned",
  "keyword": "Then "
});
formatter.step({
  "line": 86,
  "name": "the Playlist version number is updated",
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
  "duration": 1512714997,
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
  "duration": 703700142,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "204",
      "offset": 19
    }
  ],
  "location": "ApiSteps.a_Http_Status_Code_is_returned(int)"
});
formatter.result({
  "duration": 78684,
  "status": "passed"
});
formatter.match({
  "location": "PlaylistSteps.the_Playlist_version_number_is_updated()"
});
formatter.result({
  "duration": 86447764,
  "error_message": "org.junit.ComparisonFailure: Version number not updated in Playlist expected:\u003c[1]\u003e but was:\u003c[0]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat techtest.bdd.steps.PlaylistSteps.the_Playlist_version_number_is_updated(PlaylistSteps.java:341)\r\n\tat ✽.And the Playlist version number is updated(test/resources/cucumber/Playlists.feature:86)\r\n",
  "status": "failed"
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
  "line": 20,
  "name": "An request for an individual song with a valid unknown Id fails correctly",
  "description": "",
  "id": "songs-tests;an-request-for-an-individual-song-with-a-valid-unknown-id-fails-correctly",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 19,
      "name": "@failTest"
    }
  ]
});
formatter.step({
  "line": 21,
  "name": "a song is requested with an unknown Id",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "a Http Status Code 404 is returned",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiSteps.a_song_is_requested_with_an_unknown_Id()"
});
formatter.result({
  "duration": 59367696,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "404",
      "offset": 19
    }
  ],
  "location": "ApiSteps.a_Http_Status_Code_is_returned(int)"
});
formatter.result({
  "duration": 255437,
  "error_message": "java.lang.AssertionError: Expected return Http Status Code 404 expected:\u003c404\u003e but was:\u003c200\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\r\n\tat org.junit.Assert.assertEquals(Assert.java:645)\r\n\tat techtest.bdd.steps.ApiSteps.a_Http_Status_Code_is_returned(ApiSteps.java:297)\r\n\tat ✽.Then a Http Status Code 404 is returned(test/resources/cucumber/Songs.feature:22)\r\n",
  "status": "failed"
});
formatter.scenario({
  "comments": [
    {
      "line": 51,
      "value": "# Fails as request with unknown id causes \"no http response\" error"
    }
  ],
  "line": 53,
  "name": "An song deletetion request with an unknown id is handled correctly",
  "description": "",
  "id": "songs-tests;an-song-deletetion-request-with-an-unknown-id-is-handled-correctly",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 52,
      "name": "@failTest"
    }
  ]
});
formatter.step({
  "line": 54,
  "name": "a song deletion is requested using an unknown Id",
  "keyword": "When "
});
formatter.step({
  "line": 55,
  "name": "a Http Status Code 204 is returned",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiSteps.a_song_deletion_is_requested_using_an_unknown_Id()"
});
formatter.result({
  "duration": 3813727127,
  "error_message": "java.lang.AssertionError: turing.niallbunting.com:3005 failed to respond\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat techtest.bdd.shared.FluentHandler.execDelete(FluentHandler.java:73)\r\n\tat techtest.bdd.steps.ApiSteps.deleteSongWithId(ApiSteps.java:284)\r\n\tat techtest.bdd.steps.ApiSteps.a_song_deletion_is_requested_using_an_unknown_Id(ApiSteps.java:273)\r\n\tat ✽.When a song deletion is requested using an unknown Id(test/resources/cucumber/Songs.feature:54)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "204",
      "offset": 19
    }
  ],
  "location": "ApiSteps.a_Http_Status_Code_is_returned(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "comments": [
    {
      "line": 57,
      "value": "# Fails as request with invalid id causes \"no http response\" error"
    }
  ],
  "line": 59,
  "name": "An song deletetion request with an invalid id is handled correctly",
  "description": "",
  "id": "songs-tests;an-song-deletetion-request-with-an-invalid-id-is-handled-correctly",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 58,
      "name": "@failTest"
    }
  ]
});
formatter.step({
  "line": 60,
  "name": "a song deletion is requested using an invalid Id",
  "keyword": "When "
});
formatter.step({
  "line": 61,
  "name": "a Http Status Code 200 is returned",
  "keyword": "Then "
});
formatter.step({
  "line": 62,
  "name": "an error message is returned for the invalid Id",
  "keyword": "And "
});
formatter.match({
  "location": "ApiSteps.a_song_deletion_is_requested_using_an_invalid_Id()"
});
formatter.result({
  "duration": 4967182494,
  "error_message": "java.lang.AssertionError: turing.niallbunting.com:3005 failed to respond\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat techtest.bdd.shared.FluentHandler.execDelete(FluentHandler.java:73)\r\n\tat techtest.bdd.steps.ApiSteps.deleteSongWithId(ApiSteps.java:284)\r\n\tat techtest.bdd.steps.ApiSteps.a_song_deletion_is_requested_using_an_invalid_Id(ApiSteps.java:278)\r\n\tat ✽.When a song deletion is requested using an invalid Id(test/resources/cucumber/Songs.feature:60)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 19
    }
  ],
  "location": "ApiSteps.a_Http_Status_Code_is_returned(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ApiSteps.an_error_message_is_returned_for_the_invalid_id()"
});
formatter.result({
  "status": "skipped"
});
});