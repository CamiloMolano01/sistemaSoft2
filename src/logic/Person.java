package logic;

public class Person {
	
	String name;
	String fname;
	String email;
	Integer id;
	AccountType type; //Enumerador ADMIN, USER, STUDENT
	
	//Constructor
	public Person(String name, String fname, String email, Integer id, AccountType type) {
		super();
		this.name = name;
		this.fname = fname;
		this.email = email;
		this.id = id;
		this.type = type;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

}
