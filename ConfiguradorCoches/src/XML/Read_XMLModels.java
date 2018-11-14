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

import Idao.IModels;
import objetos.Model;

public class Read_XMLModels implements IModels{

	private static ArrayList<Model> models;
	
	private static String m_id, m_name, m_descript, m_imageName, m_price;
	
	public Read_XMLModels() {
		File f = new File("XMLs/cars_config.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		models = new ArrayList<Model>();
		
		try {
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.parse(f);
		
		//Esto es para leer los modelos del XML: Models
		
		NodeList nList = ((Document) doc).getElementsByTagName("model");
		
		for (int i = 0; i < nList.getLength(); i++) {

			org.w3c.dom.Node nNode =nList.item(i);
					
			
					
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Node eElement = nNode;

				
				m_id = ((Element) eElement).getElementsByTagName("id").item(0).getTextContent();
				m_name=  ((Element) eElement).getElementsByTagName("name").item(0).getTextContent();
				m_descript = ((Element) eElement).getElementsByTagName("descript").item(0).getTextContent();
				m_imageName = ((Element) eElement).getElementsByTagName("image_name").item(0).getTextContent();
				m_price = ((Element) eElement).getElementsByTagName("price").item(0).getTextContent();
				
				//m_price = Integer.parseInt(m_aux);
				
				
				models.add(new Model(m_id, m_name, m_descript, m_imageName,m_price));
				
			}
		}
		
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<Model> getModelAll() {
		// TODO Auto-generated method stub
		return models;
	}

	@Override
	public void addModel(Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarModel(Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarModel(Model model) {
		// TODO Auto-generated method stub
		
	}

	
	
}
