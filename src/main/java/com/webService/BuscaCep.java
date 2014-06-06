package com.webService;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

@Path("/cep")
public class BuscaCep {

	
	@GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/{cep}") 
	public static WebserviceCep getEndereco(@PathParam("cep")String cep) throws JAXBException, IOException{
		
		   JAXBContext jc = JAXBContext.newInstance(WebserviceCep.class);
		
		   Unmarshaller u = jc.createUnmarshaller();
		   URL url = new URL( "http://cep.republicavirtual.com.br/web_cep.php?cep="+cep+"&formato=xml" );
		   HttpURLConnection connection = (HttpURLConnection) url.openConnection();  
		   connection.setRequestProperty("Request-Method", "GET");  
	       WebserviceCep wCep = (WebserviceCep) u.unmarshal( url );
	       
	       return wCep;
		
	}

}
