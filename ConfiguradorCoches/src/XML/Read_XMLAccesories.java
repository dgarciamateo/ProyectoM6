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

import Idao.IAccesories;
import objetos.Accesory;


public class Read_XMLAccesories implements IAccesories{

	private static ArrayList<Accesory> accesories;
	private static String a_id, a_name, a_descript, a_imageName , models_a, a_price;
	private static String [] models_available;;
	
	public Read_XMLAccesories() {

		
		File f = new File("XMLs/cars_config.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		accesories = new ArrayList<Accesory>();
		
		try {
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.parse(f);
		
		NodeList nList3 = ((Document) doc).getElementsByTagName("accesory");
		
		for (int k = 0; k < nList3.getLength(); k++) {

			org.w3c.dom.Node nNode3 =nList3.item(k);
					
			
					
			if (nNode3.getNodeType() == Node.ELEMENT_NODE) {

				Node eElement3 = nNode3;

				
				a_id = ((Element) eElement3).getElementsByTagName("id").item(0).getTextContent();
				a_name=  ((Element) eElement3).getElementsByTagName("name").item(0).getTextContent();
				a_descript = ((Element) eElement3).getElementsByTagName("descript").item(0).getTextContent();
				a_imageName = ((Element) eElement3).getElementsByTagName("image_name").item(0).getTextContent();
				a_price = ((Element) eElement3).getElementsByTagName("price").item(0).getTextContent();
				
				//a_price = Integer.parseInt(a_aux);
				
				models_a = ((Element) eElement3).getElementsByTagName("model_available").item(0).getTextContent();
				
				models_available = models_a.split(",");
				
				accesories.add(new Accesory(a_id, a_name, a_descript, a_imageName, a_price, models_available));
				
			}
		}
		
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<Accesory> getAccesoryAll() {
		// TODO Auto-generated method stub
		return accesories;
	}

	@Override
	public void addAccesory(Accesory accesory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarAccesory(Accesory accesory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarAccesory(Accesory accesory) {
		// TODO Auto-generated method stub
		
	}

}
