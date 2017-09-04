package edu.ap.products;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import edu.ap.xml.XMLParser;

public class ProductResource extends ServerResource{
	
	@Get("html")
	public String getProducts() {
		XMLParser parser = new XMLParser();
		return parser.getProducts();
	}
	
	@Post("txt")
	public String addProduct(String product) {
		XMLParser parser = new XMLParser();
		return parser.addProduct(product);
	}

}
