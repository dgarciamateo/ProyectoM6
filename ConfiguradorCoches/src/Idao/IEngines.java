package Idao;

import java.util.ArrayList;

import objetos.Engine;

public interface IEngines {

	ArrayList<Engine> getEngineAll();
	
	void addEngine(Engine engine);
	
	void actualizarEngine(Engine engine);
	
	void eliminarEngine(Engine engine);
}
