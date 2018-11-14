package Idao;

import java.util.ArrayList;

import objetos.Accesory;

public interface IAccesories {
	
	ArrayList<Accesory> getAccesoryAll();
	
	void addAccesory(Accesory accesory);

	void actualizarAccesory(Accesory accesory);

	void eliminarAccesory(Accesory accesory);


}
