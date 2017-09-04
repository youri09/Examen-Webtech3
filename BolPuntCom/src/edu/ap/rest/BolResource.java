package edu.ap.rest;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import edu.ap.xml.XMLParser;

public class BolResource extends ServerResource{

	@Get("html")
	public String getOrders() {
		XMLParser parser = new XMLParser();
		return parser.getOrders();
	}
	
	@Post("txt")
	public String addOrder(String xml) {
		XMLParser parser = new XMLParser();
		return parser.addOrder(xml);
	}
}
