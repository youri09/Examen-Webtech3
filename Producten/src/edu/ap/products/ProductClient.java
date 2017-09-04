package edu.ap.products;

import org.restlet.resource.ClientResource;

public class ProductClient {
	
	public static void main(String[] args) {
        
        try {
       	ClientResource resource = new ClientResource("http://localhost:8585/products/product");
       	// Post a new product
       	String product1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
       	product1 += "<product name=\"Klok\" producer=\"De Tijd\" id=\"2\"><uri>product/2</uri>";
   		resource.post(product1);
   		// get the response
       	System.out.println(resource.getResponseEntity().getText());
       	
     // Post a new product
       	String product2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
       	product2 += "<product name=\"kaartjes\" producer=\"Den Boek\" id=\"5\"><uri>product/5</uri>";
   		resource.post(product2);
   		// get the response
       	System.out.println(resource.getResponseEntity().getText());
       }
       catch (Exception e) {
           System.out.println("In main : " + e.getMessage());
       }
   }

}
