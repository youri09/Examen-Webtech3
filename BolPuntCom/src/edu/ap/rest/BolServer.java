package edu.ap.rest;

import org.restlet.*;
import org.restlet.data.Protocol;

public class BolServer {
	
	public static void main(String[] args) throws Exception {  
	    // Create a new Component.  
	    Component component = new Component();  

	    // Add a new HTTP server listening on port 8080.  
	    component.getServers().add(Protocol.HTTP, 8182);  

	    // Attach the sample application.  
	    component.getDefaultHost().attach("/bol",  new BolApplication());  

	    // Start the component.  
	    component.start();  
	}

}
