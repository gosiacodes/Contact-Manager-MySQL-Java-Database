package a.Package;

public class aBean {
	
	private String name, password;
	private static String table, conName, email, address, phone;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean validate() {
		if(name.contentEquals("Gosia") && password.contentEquals("admin")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static String getConName() {
		return conName;
	}

	public static void setConName(String conName) {
		aBean.conName = conName;
		
	}
	
	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		aBean.email = email;
	}
	
	public static String getAddress() {
		return address;
	}

	public static void setAddress(String address) {
		aBean.address = address;
	}

	public static String getPhone() {
		return phone;
	}
	
	public static void setPhone(String phone) {
		aBean.phone = phone;
	}
	
	public static String getTable() {
		return table;
	}

	public static void setTable(String table) {
		aBean.table = table;
	}

}
