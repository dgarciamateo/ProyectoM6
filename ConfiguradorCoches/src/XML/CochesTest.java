package XML;
 
import Idao.IAccesories;
import Idao.IEngines;
import Idao.IModels;
import Idao.ISubmodels;

public class CochesTest {

	public static void main(String[] args) {

		IModels gestorM = new Read_XMLModels();
		//IEngines gestorE = new Read_XMLEngines();
		IAccesories gestorA = new Read_XMLAccesories();
		ISubmodels gestorS = new Read_XMLSubmodels();

		System.out.println("IMPRIMIMOS MODELOS");
		gestorM.getModelAll().forEach(System.out::println);
		
		
		//System.out.println("IMPRIMIMOS MOTORES");
		//gestorE.getEngineAll().forEach(System.out::println);
		
		
		System.out.println("IMPRIMIMOS ACCESORIOS");
		gestorA.getAccesoryAll().forEach(System.out::println);
		
		System.out.println("IMPRIMIMOS SUBMODELOS");
		gestorS.getSubmodelAll().forEach(System.out::println);
	}
}
