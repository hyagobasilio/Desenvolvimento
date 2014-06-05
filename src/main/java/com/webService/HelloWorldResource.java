package com.webService;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class HelloWorldResource {
	
	public String getCep (){
		
		Client c = Client.create();
		WebResource wr = c.resource("");
		return wr.get(String.class);
	}
}