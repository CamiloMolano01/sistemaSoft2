package logic;

public class Cuenta{

	String id;
	Person person;
	String pass;
	Boolean status;
	
	public void login(String id, String pass) {
		//conexion a la base de datos
		//en login exitoso el status cambia a true
	}
	
	public void start() {
		if (status == true) {
			if (person.getType() == AccountType.ADMIN) {
				Admin admin = new Admin();
				//abrir la ventana que solo admin tiene acceso
			}
			if (person.getType() == AccountType.USER) {
				User user = new User();
				//abrir la ventana que user tiene acceso
			}
		}
	}
}
