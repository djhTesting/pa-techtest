
@songs
Feature: Songs tests
  Songs tests description


  Scenario: All songs are returned in Songs list
  Given multiple songs exist in the Daily Songs database
  When the list of Songs is requested
  Then all the Songs are returned in the list
  
  Scenario: An individual song can be requested with an Id
  Given a song exists in the Daily Songs database with a known Id
  When a song is requested using the Id
  Then the details for the Song are returned
  
  @failTest
  Scenario: An request for an individual song with a valid unknown Id fails correctly
  When a song is requested with an unknown Id
  Then a Resource not Found error is returned
   
  Scenario: An request for an individual song with an invalid Id fails correctly
  When a song is requested with an invalid Id
  Then an error message is returned for the invalid Id
    
  Scenario: A Song can be added to Daily Songs
  When a song is added to Daily Songs via the API
  Then the individual Song can be returned from the API
  And the Song is returned in the Song list
      
  Scenario: A Song cannot be added to Daily Songs with invalid data
  When a song is added to Daily Songs via the API with invalid data
  Then an error message is returned for the invalid data
    
  Scenario: The functionality to update a Song is not implemented
  When a Song is updated
  Then a Not Implemented message is returned

  Scenario: An individual song can be deleted
  Given a song exists in the Daily Songs database with a known Id
  When the song is deleted using the Id
  Then a No Content message is returned
  And the song is removed from Daily Songs
  
  # Fails as request with unknown id causes "no http response" error
  @failTest
  Scenario: An song deletetion request with an unknown id is handled correctly
  When a song deletion is requested using an unknown Id
  Then a No Content message is returned
  
  # Fails as request with invalid id causes "no http response" error
  @failTest
  Scenario: An song deletetion request with an invalid id is handled correctly
  When a song deletion is requested using an invalid Id
  Then an error message is returned for the invalid Id
