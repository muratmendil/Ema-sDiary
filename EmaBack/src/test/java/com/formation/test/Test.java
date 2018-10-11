package com.formation.test;

import com.formation.facade.Facade;

public class Test {

	public static void main(String[] args) {

System.out.println(Facade.getInstance().getUserService().findById(1));

	}

}
