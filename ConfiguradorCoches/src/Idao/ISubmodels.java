package Idao;

import java.util.ArrayList;

import objetos.Submodel;

public interface ISubmodels {

	
	ArrayList<Submodel> getSubmodelAll();
	
	void addSubmodel(Submodel submodel);
	
	void actualizarSubmodel(Submodel submodel);
	
	void eliminarSubmodel(Submodel submodel);
}
