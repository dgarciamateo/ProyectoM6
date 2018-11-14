package XML;
 
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Read_XMLConfig {
	private static String version_p;
	private static String car_conf_path;
	private static String car_conf_f_name;
	private static String specif_f_path;
	private static String lenguage_def;
	private static String lenguage_f_name;
	private static String lenguagesString;
	private static String[] users = null;
	private static String[] pass = null;
	private static String[] lenguages = null;
	private static int discount;
	private static String discountString;
	 
	 
	public XMLConfig leer() {
	XMLConfig conf = new XMLConfig();

	try {
		
		File f = new File("XMLs/cv_config.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document doc = builder.parse(f);

		NodeList nList = ((Document) doc).getElementsByTagName("xml_config");

		for (int i = 0; i < nList.getLength(); i++) {

			org.w3c.dom.Node nNode = nList.item(i);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Node eElement = nNode;
				
				version_p = ((Element) eElement).getElementsByTagName("version").item(0)
						.getTextContent();

				car_conf_path = ((Element) eElement).getElementsByTagName("car_configuration_path").item(0)
						.getTextContent();
				car_conf_f_name = ((Element) eElement).getElementsByTagName("car_configuration_file_name").item(0)
						.getTextContent();
				specif_f_path = ((Element) eElement).getElementsByTagName("specifications_file_path").item(0)
						.getTextContent();

				lenguagesString = ((Element) eElement).getElementsByTagName("lenguage").item(0)
						.getTextContent();
				
				
				lenguages = lenguagesString.split(",");
				
				lenguage_def = ((Element) eElement).getElementsByTagName("lenguage_default").item(0)
						.getTextContent();
				
				lenguage_f_name = ((Element) eElement).getElementsByTagName("postfix_lenguage_file_name").item(0)
						.getTextContent();
				
				
				discountString = ((Element) eElement).getElementsByTagName("discount").item(0)
						.getTextContent();
				
				discount = Integer.parseInt(discountString);
				
				NodeList nList2 = ((Document) doc).getElementsByTagName("user");
				users = new String[nList2.getLength()];

				for (int j = 0; j < nList2.getLength(); j++) {

					org.w3c.dom.Node nNode2 = nList2.item(j);

					if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
						Node eElement2 = nNode2;

						// String user = ((Element) eElement2).getTextContent();
						users[j] = ((Element) eElement2).getTextContent();

					}

				}

				NodeList nList3 = ((Document) doc).getElementsByTagName("password");
				pass = new String[nList3.getLength()];

				for (int k = 0; k < nList3.getLength(); k++) {

					org.w3c.dom.Node nNode3 = nList3.item(k);

					if (nNode3.getNodeType() == Node.ELEMENT_NODE) {

						Node eElement3 = nNode3;

						pass[k] = ((Element) eElement3).getTextContent();

					}

				}
				
				conf = new XMLConfig(car_conf_path, car_conf_f_name, specif_f_path, version_p, lenguage_def, lenguage_f_name, users, pass, lenguages, discount);

			}
		}
		
		//Prints de seguridad
		/*
		System.out.println("Version: "+version_p);

		System.out.println("Ruta configuration Car: " + car_conf_path);
		System.out.println("Archivo configuration Car: " + car_conf_f_name);

		System.out.println(Arrays.toString(users));
		System.out.println(Arrays.toString(pass));
		
		System.out.println("Emp version: "+emp_version);

		System.out.println("Ruta archivo especificaciones: " + specif_f_path);
		*/

	} catch (ParserConfigurationException | SAXException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	return conf;
	
	}
	 
	public static String[] getUsers() {
	return users;
	}

	public static String[] getPass() {
	return pass;
	}
	 
	public static void main(String[] args) {
	
	}
}
