package XML;
 
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Idao.ICoches;
import objetos.Accesory;
import objetos.Engine;
import objetos.Model;
import objetos.Submodel;


public class Read_XMLCars implements ICoches{

	private static String m_id, m_name, m_descript, m_imageName, e_id,  e_name, e_descript, e_imageName,  a_id, a_name, a_descript, a_imageName ,m_aux, e_aux, a_aux , models_a;
	private static String m_price;
	private static String sm_modelId, sm_id, sm_name, sm_cv, sm_doors, sm_engine, sm_price;
	String e_price;
	static String a_price;
	private static String [] models_available;
	
	private static ArrayList<Model> models;
	private static ArrayList<Engine> engines;
	private static ArrayList<Accesory> accesories;
	private static ArrayList<Submodel> submodels;

	public Read_XMLCars() {
		// TODO Auto-generated method stub
		File f = new File("XMLs/cars_config.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		models = new ArrayList<Model>();
		engines = new ArrayList<Engine>();
		accesories = new ArrayList<Accesory>();
		submodels = new ArrayList<Submodel>();
		
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
		
		//Esto es para leer los motores del XML: Engines
		/*
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
		*/
		//Esto es para leer los accesorios del XML: Accesories
		
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
		
				
				//Esto es para leer los submodelos del XML: Submodels
				
				NodeList nList4 = ((Document) doc).getElementsByTagName("submodel");
				
				for (int l = 0; l < nList4.getLength(); l++) {

					org.w3c.dom.Node nNode4 =nList4.item(l);
							
					
							
					if (nNode4.getNodeType() == Node.ELEMENT_NODE) {

						Node eElement4 = nNode4;

						
						sm_modelId = ((Element) eElement4).getElementsByTagName("model_id").item(0).getTextContent();
						sm_id = ((Element) eElement4).getElementsByTagName("sm_id").item(0).getTextContent();
						sm_name=  ((Element) eElement4).getElementsByTagName("name").item(0).getTextContent();
						sm_cv = ((Element) eElement4).getElementsByTagName("cv").item(0).getTextContent();
						sm_doors = ((Element) eElement4).getElementsByTagName("doors").item(0).getTextContent();
						sm_engine = ((Element) eElement4).getElementsByTagName("engine").item(0).getTextContent();
						sm_price = ((Element) eElement4).getElementsByTagName("price").item(0).getTextContent();
						
						//sm_price = Integer.parseInt(a_aux);
						
						submodels.add(new Submodel(sm_modelId, sm_id, sm_name, sm_cv, sm_doors, sm_engine, sm_price));
						
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
	public ArrayList<Engine> getEngineAll() {
		// TODO Auto-generated method stub
		return engines;
	}

	@Override
	public ArrayList<Accesory> getAccesoryAll() {
		// TODO Auto-generated method stub
		return accesories;
	}
	
	@Override
	public ArrayList<Submodel> getSubmodelAll() {
		// TODO Auto-generated method stub
		return submodels;
	}
	
	
	@Override
	public void addModel(Model Model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEngine(Engine Engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAccesory(Accesory Accesory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarModel(Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarEngine(Engine engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarAccesory(Accesory accesory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarModel(Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarEngine(Engine engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarAccesory(Accesory accesory) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void addSubmodel(Submodel submodel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarSubmodel(Submodel submodel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarSubmodel(Submodel submodel) {
		// TODO Auto-generated method stub
		
	}


	
	
	
}
