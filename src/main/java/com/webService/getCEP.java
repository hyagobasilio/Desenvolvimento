package com.webService;

import javax.faces.bean.ManagedBean;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@ManagedBean
public class getCEP {

	public String getCEPS(){
		
		Client c =  Client.create();
		WebResource wr = c.resource("http://frete.w21studio.com/calFrete.xml"); 
		return wr.get(String.class); 
		
	}
}
