package logic;

public class Person {
	
	String name;
	String fname;
	String email;
	
	//Constructor
	public Person(String name, String fname, String email) {
		super();
		this.name = name;
		this.fname = fname;
		this.email = email;
	}
	
	//Metodos get/set de los atributos
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
