package test;

import java.time.LocalDate;

import modelo.Empleado;
import modelo.Sistema;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sistema sistema = new Sistema();
		
		try {
			sistema.agregarCocinero("Lionel", "Messi", 111111111, LocalDate.of(1986, 10, 5), LocalDate.of(2004, 5, 2),"Pastelero", 10_000);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Empleado e : sistema.getLstStaff()) {
			System.out.println(e);
		}

	}

}
