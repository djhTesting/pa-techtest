package techtest.bdd.shared;

import org.apache.http.HttpStatus;

public class AppResponse {
	int httpStatus = HttpStatus.SC_OK;
    public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getJsonBody() {
		return jsonBody;
	}

	public void setJsonBody(String jsonBody) {
		this.jsonBody = jsonBody;
	}

	String jsonBody = "";

    AppResponse(int httpStatus, String jsonBody) {
        this.httpStatus = httpStatus;
        this.jsonBody = jsonBody;
    }
}
