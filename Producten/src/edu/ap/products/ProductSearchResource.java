package edu.ap.products;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import edu.ap.xml.XMLParser;

public class ProductSearchResource extends ServerResource {
	
	@Get("html")
	public String getSearchQuotes(String search_term) {
		search_term = getAttribute("search_term");
		XMLParser parser = new XMLParser();
		return parser.getSearchProducts(search_term);
	}

}
