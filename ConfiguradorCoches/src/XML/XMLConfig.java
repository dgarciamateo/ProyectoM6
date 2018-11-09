package XML;
 
public class XMLConfig {

	private String car_conf_path, car_conf_f_name, specif_f_path, version_p;
	private String[] users, pass;
	private boolean emp_version;
	  
	public XMLConfig() {
	 
	}

	
	public XMLConfig(String car_conf_path, String car_conf_f_name, String specif_f_path, String version_p,
			String[] users, String[] pass, boolean emp_version) {
		super();
		this.car_conf_path = car_conf_path;
		this.car_conf_f_name = car_conf_f_name;
		this.specif_f_path = specif_f_path;
		this.version_p = version_p;
		this.users = users; 
		this.pass = pass;
		this.emp_version = emp_version;
	}

	//SETTERS Y GETTERS 
	public String getCar_conf_path() {
		return car_conf_path;
	}

	public void setCar_conf_path(String car_conf_path) {
		this.car_conf_path = car_conf_path;
	}

	public String getCar_conf_f_name() {
		return car_conf_f_name;
	}

	public void setCar_conf_f_name(String car_conf_f_name) {
		this.car_conf_f_name = car_conf_f_name;
	}

	public String getSpecif_f_path() {
		return specif_f_path;
	}

	public void setSpecif_f_path(String specif_f_path) {
		this.specif_f_path = specif_f_path;
	}

	public String getVersion_p() {
		return version_p;
	}

	public void setVersion_p(String version_p) {
		this.version_p = version_p;
	}

	public String[] getUsers() {
		return users;
	}

	public void setUsers(String[] users) {
		this.users = users;
	}

	public String[] getPass() {
		return pass;
	}

	public void setPass(String[] pass) {
		this.pass = pass;
	}

	public boolean isEmp_version() {
		return emp_version;
	}

	public void setEmp_version(boolean emp_version) {
		this.emp_version = emp_version;
	}
	 

}
