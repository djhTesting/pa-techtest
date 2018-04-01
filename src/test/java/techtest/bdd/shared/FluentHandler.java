package techtest.bdd.shared;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.junit.Assert;

public class FluentHandler {
	
	private static final String urlBase = "http://turing.niallbunting.com:3005/api/";
	
	public AppResponse execGet(String url) {
		AppResponse appResponse = null;
		try {
			appResponse = Request.Get(urlBase+url)
					.execute().handleResponse(new AppResponseHandler());
			
		} catch (ClientProtocolException e) {
			Assert.fail(e.getMessage());
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		
		return appResponse;
	}
	
	public AppResponse execPost(String url, String jsonString) {
		AppResponse appResponse = null;
		
		try {
			appResponse = Request.Post(urlBase+url)
					.bodyString( jsonString, 
							ContentType.APPLICATION_JSON)
					.execute().handleResponse(new AppResponseHandler());
			
		} catch (ClientProtocolException e) {
			Assert.fail(e.getMessage());
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		
		return appResponse;
	}
	
	public AppResponse execPatch(String url, String jsonString) {
		AppResponse appResponse = null;
		
		try {
			appResponse = Request.Patch(urlBase+url).bodyString(jsonString, ContentType.APPLICATION_JSON)
					.execute().handleResponse(new AppResponseHandler());
			
		} catch (ClientProtocolException e) {
			Assert.fail(e.getMessage());
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		
		return appResponse;
	}
	
	public AppResponse execDelete(String url) {
		AppResponse appResponse = null;
		
		try {
			appResponse = Request.Delete(urlBase+url).addHeader("Content-Type", "application/json")
					.execute().handleResponse(new AppResponseHandler());
			
		} catch (ClientProtocolException e) {
			Assert.fail(e.getMessage());
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		
		return appResponse;
	}
	
	

}
