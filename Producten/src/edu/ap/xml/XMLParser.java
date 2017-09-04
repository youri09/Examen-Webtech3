package edu.ap.xml;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.InputSource;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

import java.io.*;

public class XMLParser {
	
private String INPUTFILE = "products.xml";
	
	/** Get all races from the xml file and return them 
	 * in html format
	 */
	public String getProducts() {
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        String result = "<h2>Products</h2>";
	        
	        NodeList races = doc.getElementsByTagName("product");

	        for (int i = 0; i < races.getLength(); i++) {
	        	 Node nNode = races.item(i);
	        	 Element eElement = (Element) nNode;
	        	 
	        	 result += "<br/><b>Name : </b>" + eElement.getAttribute("name");
	        	 result += "<br/><b>Producent : </b>" + eElement.getAttribute("producer");
	        	 result += "<br/><b>Prijs: </b>" + eElement.getAttribute("price");
	        	 result += "<br/>";
	        }

	        return result;
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}
	
	/** Get the product with product_id and return them 
	 * in html format
	 */
	public String getProduct(String product_id) {
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        String result = "<h2>Product</h2>";
	        
	        NodeList races = doc.getElementsByTagName("product");

	        for (int i = 0; i < races.getLength(); i++) {
	        	
	        	 Node nNode = races.item(i);
	        	 Element eElement = (Element) nNode;
	        	 
	        	 if(eElement.getAttribute("id").equalsIgnoreCase(product_id)) {
	        		 result += "<br/><b>Name : </b>" + eElement.getAttribute("name");
		        	 result += "<br/><b>Producent : </b>" + eElement.getAttribute("producer");
		        	 result += "<br/><b>Prijs: </b>" + eElement.getAttribute("price");
		        	 result += "<br/>";
	        	 }
	        }

	        return result;
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String getSearchProducts(String search_term) {

		String result = "";
		System.out.println(search_term);
		
		try {	
			Scanner scanner = new Scanner(new File("products.xml")).useDelimiter(Pattern.compile("^\\s*$", Pattern.MULTILINE));		
			while(scanner.hasNext()) {
				final String quote = scanner.next();
				   if(quote.contains(search_term)) { 
				       result += quote + "<br><br>";
				   }
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;
	}
	
	public String addProduct(String xml) {
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        // set validating false to enable copying
        // node from one document to another
        dbFactory.setValidating(false);
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc1 = dBuilder.parse(inputFile);
	        Document doc2 = dBuilder.parse(new InputSource(new StringReader(xml)));
	        Element element = (Element) doc2.getDocumentElement();
	        // imports a node from doc2 document to doc1, without altering
	        // or removing the source node from the original document
	        Node copiedNode = doc1.importNode(element, true);
	        // adds the node to the end of the list of children of this node
	        doc1.getDocumentElement().appendChild(copiedNode);
	        
	        /*FileWriter fw = new FileWriter(INPUTFILE);
	        fw.write(doc1.toString());
	        fw.close();*/
	        // write the new document to file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc1);
			StreamResult result = new StreamResult(new File(INPUTFILE));
			transformer.transform(source, result);
	        
	        return this.getProducts();
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}
	
	
	
	public String prettyPrint(Document xml) throws Exception {
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		Writer out = new StringWriter();
		tf.transform(new DOMSource(xml), new StreamResult(out));
		return out.toString();
	}

}
