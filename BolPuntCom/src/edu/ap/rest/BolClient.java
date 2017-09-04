package edu.ap.rest;

import org.restlet.resource.ClientResource;

public class BolClient {
	
public static void main(String[] args) {
        
        try {
       	ClientResource resource = new ClientResource("http://localhost:8182/bol/orders");
       	// Post a new race
       	String order1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
       	order1 += "<order id=\"3\" nameCustomer=\"youri vh\" address=\"ap hogeschool 2\" dateOrder=\"19/04/2017\" nameProduct=\"Batteriekes\">";
       	order1 += "<qty>10</qty>";
       	order1 += "</order>";
   		resource.post(order1);
   		// get the response
       	System.out.println(resource.getResponseEntity().getText());
       	
       	String order2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
       	order2 += "<order id=\"4\" nameCustomer=\"yannick k\" address=\"thuis 2\" dateOrder=\"10/07/2016\" nameProduct=\"Tweewieler\">";
       	order2 += "<qty>6</qty>";
       	order2 += "</order>";
   		resource.post(order2);
   		// get the response
       	System.out.println(resource.getResponseEntity().getText());
       }
       catch (Exception e) {
           System.out.println("In main : " + e.getMessage());
       }

	}

}
