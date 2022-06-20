package site.orangefield.reflect.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller {
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	public void injectRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public void injectResponse(HttpServletResponse response) {
		this.response = response;
	}
}
