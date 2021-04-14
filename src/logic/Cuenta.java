package logic;

public class Cuenta{
	
	String user;
	String pass;
	AccountType type;
	Boolean status;
	
	public Cuenta(String user, String pass, AccountType type, Boolean status) {
		super();
		this.user = user;
		this.pass = pass;
		this.type = type;
		this.status = status;
	}
	
	public void login(String user, String pass) {
		//conexion a la base de datos
		//en login exitoso el status cambia a true
	}
	
	public void start() {
		if (status == true) {
			if (type == AccountType.ADMIN) {
				//Admin admin = new Admin();
				//abrir la ventana que solo admin tiene acceso
			}
			if (type == AccountType.USER) {
				//User user = new User();
				//abrir la ventana que user tiene acceso
			}
		}
	}
}
