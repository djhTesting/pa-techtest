@playlists
Feature: Playlists tests
  Playlists tests description

  Scenario: Playlists songs are returned in Playlists list
  Given multiple Playlists exist in the Daily Songs database
  When the list of Playlists is requested
  Then all the Playlists are returned in the list
  
  Scenario: An individual Playlist can be requested with an Id
  Given a Playlist exists in the Daily Songs database with a known Id
  When the Playlist is requested using the Id
  Then the details for the Playlist are returned
  
  Scenario: Song details in Playlist are hidden where publishDate is in future
  Given a Playlist exists containing Songs with past and future publishDates
  When the Playlist is requested using the Id
  Then the Song details are hidden for Songs with a future publishDate
   
  # Fails as request with unknown id causes "no http response" error
  @failTest   
  Scenario: An request for an individual Playlist with a valid unknown Id fails correctly
  When a Playlist is requested with an unknown Id
  Then a Resource not Found error is returned
    
  Scenario: An request for an individual Playlist with an invalid Id fails correctly
  When a Playlist is requested with an invalid Id
  Then an error message is returned for the invalid Id
    
  Scenario: A Playlist can be added to Daily Songs
  When a Playlist is added to Daily Songs via the API
  Then the individual Playlist can be returned from the API
  And the Playlist is returned in the Playlist list
   
	# Delete works, but final verification step fails as request with unknown id causes "no http response" error
  @failTest 
  Scenario: An individual Playlist can be deleted
  Given a Playlist exists in the Daily Songs database with a known Id
  When the Playlist is deleted using the Id
  Then a No Content message is returned
  And the Playlist is removed from Daily Songs
   
  # Fails as request with unknown id causes "no http response" error
  @failTest   
  Scenario: A Playlist deletetion request with an unknown id is handled correctly
  When a Playlist deletion is requested using an unknown Id
  Then a No Content message is returned
  
  # Fails as request with invalid id causes "no http response" error
  @failTest   
  Scenario: A Playlist deletetion request with an invalid id is handled correctly
  When a Playlist deletion is requested using an invalid Id
  Then an error message is returned for the invalid Id
  
  Scenario: A specified number of songs can be added to a new Playlist
  Given at least 20 songs exist in the Daily Songs database
  When 5 Songs are added to a new Playlist
  Then a No Content message is returned
  And the correct Songs are stored in the Playlist
   
  Scenario: A specified number of songs can be added to an existing Playlist
  Given at least 20 songs exist in the Daily Songs database
  When 5 Songs are added to an existing Playlist
  Then a No Content message is returned
  And the correct Songs are stored in the Playlist
  
  Scenario: The functionality to remove Songs from a Playlist is not implemented
  Given at least 20 songs exist in the Daily Songs database
  When 5 Songs are added to a new Playlist and a Song removal is requested
  Then a Not Implemented message is returned
  And the correct Songs are stored in the Playlist
  
  # I am guessing that the version number should be updated in the Playlist when it is updated...
  @failTest
  Scenario: The version number is updated when an existing Playlist is updated
  Given at least 20 songs exist in the Daily Songs database
  When 5 Songs are added to an existing Playlist
  Then a No Content message is returned
  And the Playlist version number is updated
   
  Scenario: A Playlist is updated with an invalid command
  Given at least 20 songs exist in the Daily Songs database
  When 5 Songs are added to a new Playlist and a invalid command is included
  Then a Bad Content message is returned
  And no Songs are stored in the Playlist
  