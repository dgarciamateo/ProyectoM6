package XML;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Idao.IEngines;

import objetos.Engine;


public class Read_XMLEngines implements IEngines {

	private static ArrayList<Engine> engines;
	private static String  e_id,  e_name, e_descript, e_imageName, e_price;
	
	public Read_XMLEngines() {
		
		
		File f = new File("XMLs/cars_config.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		engines = new ArrayList<Engine>();
		
		try {
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.parse(f);
		
		NodeList nList2 = ((Document) doc).getElementsByTagName("engine");
		
		for (int j = 0; j < nList2.getLength(); j++) {

			org.w3c.dom.Node nNode2 =nList2.item(j);
					
			
					
			if (nNode2.getNodeType() == Node.ELEMENT_NODE) {

				Node eElement2 = nNode2;

				
				e_id = ((Element) eElement2).getElementsByTagName("id").item(0).getTextContent();
				e_name=  ((Element) eElement2).getElementsByTagName("name").item(0).getTextContent();
				e_descript = ((Element) eElement2).getElementsByTagName("descript").item(0).getTextContent();
				e_imageName = ((Element) eElement2).getElementsByTagName("image_name").item(0).getTextContent();
				e_price = ((Element) eElement2).getElementsByTagName("price").item(0).getTextContent();
				
				//e_price = Integer.parseInt(e_aux);
				
				
				engines.add(new Engine(e_id, e_name, e_descript, e_imageName, e_price));
				
			}
		}
		
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public ArrayList<Engine> getEngineAll() {
		// TODO Auto-generated method stub
		return engines;
	}

	@Override
	public void addEngine(Engine engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarEngine(Engine engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarEngine(Engine engine) {
		// TODO Auto-generated method stub
		
	}

}
