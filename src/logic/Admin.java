package logic;
import java.util.Date;

public class Admin extends Cuenta{
	
	public Admin(String user, String pass, AccountType type, Boolean status) {
		super(user, pass, type, status);
		// TODO Auto-generated constructor stub
	}

	public boolean createPerson(String name, String fname, String email) {
		Person p = new Person(name, fname, email);
		//enviar persona a la base de datos como un nuevo registro
		//realizar el proceso de verificacion de registros repetidos
		return false;
	}
	
	public boolean createMenu(Date date, String[] contents) {
		Menu m = new Menu(date, contents);
		//enviar el nuevo menu a la base de datos
		return false;
	}
	
	public void viewRegisters() {
		//retorno de los registros desde la base de datos
	}
	
	public void registerConsumption(Person person) {
		//primero debe traer los datos de la persona solo con el id
		//nuevo consumo usa los datos y raeliza los cambios pertinentes y envia mensajes
	}
	
	public void modifyRegister() {
		//la base de datos no deberia ser alterada para cambios puntuales
		//en caso de errores humanos deberia implementarse?
	}
	
	public void viewMenu(){
		//accede a la base de datos y recupera el menu del dia
	}
	
	public void generateReport() {
		//informacion de reporte pendiente
	}

}
