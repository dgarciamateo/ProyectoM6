package objetos;

public class Submodel {

	private String model_id;
	private String sm_id;
	private String name;
	private String cv;
	private String doors;
	private String engine;
	private String price;
	
	
	public Submodel(String model_id, String sm_id, String name, String cv, String doors, String engine, String price) {
		super();
		this.model_id = model_id;
		this.sm_id = sm_id;
		this.name = name;
		this.cv = cv;
		this.doors = doors;
		this.engine = engine;
		this.price = price;
	}


	public String getModel_id() {
		return model_id;
	}


	public void setModel_id(String model_id) {
		this.model_id = model_id;
	}


	public String getSm_id() {
		return sm_id;
	}


	public void setSm_id(String sm_id) {
		this.sm_id = sm_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCv() {
		return cv;
	}


	public void setCv(String cv) {
		this.cv = cv;
	}


	public String getDoors() {
		return doors;
	}


	public void setDoors(String doors) {
		this.doors = doors;
	}


	public String getEngine() {
		return engine;
	}


	public void setEngine(String engine) {
		this.engine = engine;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Submodel [model_id=" + model_id + ", sm_id=" + sm_id + ", name=" + name + ", cv=" + cv + ", doors="
				+ doors + ", engine=" + engine + ", price=" + price + "]";
	}

// Hacer tramada de ponerle espacios y convertirlo en un array
	
	
	
	
	
	
	
	
}
