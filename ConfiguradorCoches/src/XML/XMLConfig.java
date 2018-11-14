package XML;
 
public class XMLConfig {

	private String car_conf_path, car_conf_f_name, specif_f_path, version_p,lenguage_def, lenguage_f_name;
	private String[] users, pass,lenguages;
	private int discount;
	  
	public XMLConfig() {
	 
	}


	public XMLConfig(String car_conf_path, String car_conf_f_name, String specif_f_path, String version_p,
			String lenguage_def, String lenguage_f_name, String[] users, String[] pass, String[] lenguages, int discount) {
		super();
		this.car_conf_path = car_conf_path;
		this.car_conf_f_name = car_conf_f_name;
		this.specif_f_path = specif_f_path;
		this.version_p = version_p;
		this.lenguage_def = lenguage_def;
		this.lenguage_f_name = lenguage_f_name;
		this.users = users;
		this.pass = pass;
		this.lenguages = lenguages;
		this.discount = discount;
	}


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


	public String getLenguage_def() {
		return lenguage_def;
	}


	public void setLenguage_def(String lenguage_def) {
		this.lenguage_def = lenguage_def;
	}


	public String getLenguage_f_name() {
		return lenguage_f_name;
	}


	public void setLenguage_f_name(String lenguage_f_name) {
		this.lenguage_f_name = lenguage_f_name;
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


	public String[] getLenguages() {
		return lenguages;
	}


	public void setLenguages(String[] lenguages) {
		this.lenguages = lenguages;
	}


	public int getDiscount() {
		return discount;
	}


	public void setDiscount(int discount) {
		this.discount = discount;
	}

	

}
