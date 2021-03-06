package techtest.bdd.shared;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.fluent.ContentResponseHandler;

public class AppResponseHandler implements ResponseHandler<AppResponse> {  
    //@Override  
    public AppResponse handleResponse(HttpResponse response) throws ClientProtocolException, IOException {  
         HttpEntity entity = response.getEntity();  
         ContentResponseHandler contentHandler = new ContentResponseHandler();  
         AppResponse appResponse = new AppResponse(
             response.getStatusLine().getStatusCode(),
             contentHandler.handleEntity(entity).asString());
         return appResponse;
    }  
}