package Idao;
 
import java.util.ArrayList;

import objetos.Accesory;
import objetos.Engine;
import objetos.Model;
import objetos.Submodel;

public interface ICoches {

	ArrayList<Model> getModelAll();
	ArrayList<Engine> getEngineAll();
	ArrayList<Accesory> getAccesoryAll();
	ArrayList<Submodel> getSubmodelAll();
	
	void addModel(Model model);
	void addEngine(Engine engine);
	void addAccesory(Accesory accesory);
	void addSubmodel(Submodel submodel);
	
	void actualizarModel(Model model);
	void actualizarEngine(Engine engine);
	void actualizarAccesory(Accesory accesory);
	void actualizarSubmodel(Submodel submodel);
	
	void eliminarModel(Model model);
	void eliminarEngine(Engine engine);
	void eliminarAccesory(Accesory accesory);
	void eliminarSubmodel(Submodel submodel);
	
}
