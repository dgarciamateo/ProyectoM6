package daoImpl;

import java.util.ArrayList;

import Idao.ICoches;
import objetos.Accesory;
import objetos.Engine;
import objetos.Model;
import objetos.Submodel;
 
public class CocheDAOImpl implements ICoches{

	private static ArrayList<Model> models;
	private static ArrayList<Engine> engines;
	private static ArrayList<Accesory> accesories;
	private static ArrayList<Submodel> submodels;
	
	public CocheDAOImpl() {
		 
	}
	
	
	public void addModel(Model Model) {
		// TODO Auto-generated method stub
		
	}

	public void addEngine(Engine Engine) {
		// TODO Auto-generated method stub
		
	}

	public void addAccesory(Accesory Accesory) {
		// TODO Auto-generated method stub
		
	}


	/*@Override
	public void actualizarModel(Model model) {
		// TODO Auto-generated method stub
		models.get(model.getId()).setName(model.getName());
		models.get(model.getId()).setName(model.getName());		System.out.println("Cliente con id: "+cliente.getId()+" actualizado satisfactoriamente");
	}

*/
	public void actualizarEngine(Engine engine) {
		// TODO Auto-generated method stub
		
	}


	
	public void actualizarAccesory(Accesory accesory) {
		// TODO Auto-generated method stub
		
	}


	
	public void eliminarModel(Model model) {
		// TODO Auto-generated method stub
		
	}


	
	public void eliminarEngine(Engine engine) {
		// TODO Auto-generated method stub
		
	}


	
	public void eliminarAccesory(Accesory accesory) {
		// TODO Auto-generated method stub
		
	}
/*	
	@Override
	public void actualizarCliente(Cliente cliente) {
		clientes.get(cliente.getId()).setNombre(cliente.getNombre());
		clientes.get(cliente.getId()).setApellido(cliente.getApellido());
		System.out.println("Cliente con id: "+cliente.getId()+" actualizado satisfactoriamente");
	}
	
	//eliminar un cliente por el id
	@Override
	public void eliminarCliente(Cliente cliente) {
		clientes.remove(cliente.getId());
		System.out.println("Cliente con id: "+cliente.getId()+" elimnado satisfactoriamente");
	}
*/


	
	public ArrayList<Model> getModelAll() {
		// TODO Auto-generated method stub
		return null;
	}


	
	public ArrayList<Engine> getEngineAll() {
		// TODO Auto-generated method stub
		return null;
	}


	
	public void actualizarModel(Model model) {
		// TODO Auto-generated method stub
		
	}


	
	public ArrayList<Accesory> getAccesoryAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<Submodel> getSubmodelAll() {
		// TODO Auto-generated method stub
		return null;
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