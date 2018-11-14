package Idao;

import java.util.ArrayList;

import objetos.Model;

public interface IModels {

	
	ArrayList<Model> getModelAll();
	
	void addModel(Model model);
	
	void actualizarModel(Model model);
	
	void eliminarModel(Model model);
}
