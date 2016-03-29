package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.jersey.api.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.jackson.JacksonFeature;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PruebaRest extends HttpServlet{
	 @Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
             throws ServletException, IOException {
		    String accion=req.getParameter("accion");
		    Client client = Client.create();
			WebResource webResource = client.resource(getBaseURI()).path("rest").path("todos");
		    //WebResource webResource = client.resource(getBaseURI2());
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			if(response.getStatus()!=200){
				throw new RuntimeException("HTTP Error: "+ response.getStatus());
			}
			
			String result = response.getEntity(String.class);
			if("Resultado".equals(accion)){
				System.out.println(result);				
			}
		System.out.println("La accion es: "+accion);      
			String forward="/resultado.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(forward);
		rd.forward(req, resp);
}	 
/*	 
	 protected void doGet2(HttpServletRequest req, HttpServletResponse resp)
	                  throws ServletException, IOException {
		//ClientConfig config = new ClientConfig();
		ClientConfig config = new ClientConfig().register(JacksonFeature.class);
		Client client = ClientBuilder.newClient(config);		
		
		WebTarget service = client.target(getBaseURI()); 
		String accion=req.getParameter("accion");
		if("Resultado".equals(accion)){
			System.out.println(service.path("rest").path("todos").request().accept(MediaType.APPLICATION_JSON).get(String.class));

	        //System.out.println(service.path("rest").path("todo").request()
	        //.accept(MediaType.APPLICATION_JSON).get(String.class));			
			//System.out.println(service.path("rest").path("todos").request().accept(MediaType.TEXT_XML).get(String.class));
		}
	    System.out.println("La accion es: "+accion);;       
	   	String forward="/resultado.jsp";
	    RequestDispatcher rd = req.getRequestDispatcher(forward);
	    rd.forward(req, resp);
	 }*/
	 
	  private static URI getBaseURI() {
		    return UriBuilder.fromUri("http://localhost:8080/com.vogella.jersey.todo").build();
	  }	 
	  private static URI getBaseURI2() {
		    return UriBuilder.fromUri("http://localhost:8080/JAXRS-JSON/rest/todos/get").build();
	  }	 
}
