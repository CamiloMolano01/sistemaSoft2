package logic;
import java.util.Date;

public class User extends Cuenta{
	
	public User(String user, String pass, AccountType type, Boolean status) {
		super(user, pass, type, status);
		// TODO Auto-generated constructor stub
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

	public void viewMenu(){
		//accede a la base de datos y recupera el menu del dia
	}

}
