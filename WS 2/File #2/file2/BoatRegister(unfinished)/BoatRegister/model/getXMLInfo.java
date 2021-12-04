package model;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class getXMLInfo{
	{
		String firstName = "hej";
		String lastName = "nej";
		try 
		{
			File fXMLFile = new File("/boatRegister.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXMLFile);
			doc.getDocumentElement().normalize();
			
			int memberId;
			String boatType;
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	
			NodeList nList = doc.getElementsByTagName("member");
	
			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {
	
				Node nNode = nList.item(temp);
	
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
	
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	
					Element eElement = (Element) nNode;
					firstName = eElement.getElementsByTagName("firstname").item(0).getTextContent();
					lastName = eElement.getElementsByTagName("lastname").item(0).getTextContent();
					
				}
		}
		}	
		catch (Exception e) 
		{
			e.printStackTrace();
	    }	
		
	  }
}


