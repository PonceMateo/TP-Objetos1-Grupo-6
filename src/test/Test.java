package test;

import java.time.LocalDate;

import modelo.CategoriaCocinero;
import modelo.Empleado;
import modelo.Sistema;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sistema sistema = new Sistema(); // CREACION DEL SISTEMA
		
		// 						!!!	IMPORTANTE !!!
		//
		// TEST DE PRUEBAS NO ES EL DEFINITIVO
		// CUANDO ESTE TODO PROBADO Y LISTO ARMAMOS EL TEST DEFINITIVO
		// LO ACLARO PARA QUE PRUEBEN LOS METODOS Y DEMAS SIN HACERSE PROBLEMA JAJA
		
		try { 
			sistema.agregarCocinero("Lionel", "Messi", 11111111, LocalDate.of(1986, 10, 5), LocalDate.of(2004, 5, 2), 100_000, CategoriaCocinero.PASTELERO);
			sistema.agregarCocinero("Dibu", "Martinez", 22222222, LocalDate.of(1987, 10, 5), LocalDate.of(2000, 5, 2),100_000,CategoriaCocinero.PARRILLERO);
			sistema.agregarCocinero("Julian", "Alvarez", 33333333, LocalDate.of(1990, 10, 5), LocalDate.of(2002, 5, 2),100_000,CategoriaCocinero.SUSHI);
			
			sistema.agregarCajero("Rodrigo", "De Paul", 44444444, LocalDate.of(1996, 6, 7), LocalDate.of(2005, 8, 7), 100_000,"Mañana");
			sistema.agregarCajero("Nico", "Paz", 55555555, LocalDate.of(1995, 6, 7), LocalDate.of(2005, 8, 7), 100_000,"Mañana");
			sistema.agregarCajero("Cristiano", "Ronaldo", 66666666, LocalDate.of(1993, 6, 7), LocalDate.of(2001, 8, 7), 100_000,"Noche");
			// EN EL FUTUTO EL SUELDO BASE LO DEFINO PASANDOLE UN GETTER DEL SUELDO BASE DENTRO DE LA CLASE COSTOS, 
			// CADA FETIVAL TENDRA SU DETERMINADO SUELDO BASE
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Empleado e : sistema.getLstStaff()) {
			System.out.println(e);
			System.out.println("");
		}
		
	}

}
