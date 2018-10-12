package test;

import com.formation.exeption.ErrorExeption;
import com.formation.facade.Facade;
import com.formation.model.User;

public class Test {

	public static void main(String[] args) throws ErrorExeption {
		User newUser = Facade.getInstance().getUserService().findByEmail("dadie.emilin@gmail.com", "azerty");

		System.out.println(newUser);
	}

}
