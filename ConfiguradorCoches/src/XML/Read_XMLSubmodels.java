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

import Idao.ISubmodels;
import objetos.Submodel;

public class Read_XMLSubmodels implements ISubmodels{

	private static ArrayList<Submodel> submodels;
	private static String sm_modelId, sm_id, sm_name, sm_cv, sm_doors, sm_engine, sm_price;
	
	public Read_XMLSubmodels() {
		File f = new File("XMLs/cars_config.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		submodels = new ArrayList<Submodel>();
		
		
		try {
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.parse(f);
		
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
	public ArrayList<Submodel> getSubmodelAll() {
		// TODO Auto-generated method stub
		return submodels;
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
