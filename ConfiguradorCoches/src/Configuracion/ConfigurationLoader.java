package Configuracion;
  
import XML.Read_XMLConfig;
import XML.XMLConfig;
 
public final class ConfigurationLoader {

	private static XMLConfig instance;

	private ConfigurationLoader() {
		instance = new Read_XMLConfig().leer();
	}

	public static XMLConfig getInstance() {
		if (instance == null) {
			new ConfigurationLoader();
		}

		return instance;
	}
}
 