package XML;
 
import Idao.ICoches;

public class CochesTest {

	public static void main(String[] args) {

		ICoches gestorCars = new Read_XMLCars();

		System.out.println("IMPRIMIMOS MODELOS");
		gestorCars.getModelAll().forEach(System.out::println);
		
		
		System.out.println("IMPRIMIMOS MOTORES");
		gestorCars.getEngineAll().forEach(System.out::println);
		
		
		System.out.println("IMPRIMIMOS ACCESORIOS");
		gestorCars.getAccesoryAll().forEach(System.out::println);
		
		System.out.println("IMPRIMIMOS SUBMODELOS");
		gestorCars.getSubmodelAll().forEach(System.out::println);
	}
}
