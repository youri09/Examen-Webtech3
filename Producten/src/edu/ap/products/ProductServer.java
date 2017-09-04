package edu.ap.products;

import org.restlet.*;
import org.restlet.data.Protocol;

public class ProductServer {
	
public static void main(String[] args) {
		
		try {
			// Create a new Component.
		    Component component = new Component();
	
		    // Add a new HTTP server listening on port 8585.
		    component.getServers().add(Protocol.HTTP, 8585);
	
		    // Attach the sample application.
		    component.getDefaultHost().attach("/products", ProductResource.class);
		    component.getDefaultHost().attach("/products/{product_id}", ProductResource.class);
		    
			component.start();
		} 
	    catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
