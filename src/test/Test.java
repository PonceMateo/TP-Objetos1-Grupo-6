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
			sistema.altaEmpladoStaff("Lionel", "Messi", 11111111, LocalDate.of(1986, 10, 5), LocalDate.of(2004, 5, 2), CategoriaCocinero.PASTELERO);
			sistema.altaEmpladoStaff("Dibu", "Martinez", 22222222, LocalDate.of(1987, 10, 5), LocalDate.of(2000, 5, 2), CategoriaCocinero.PARRILLERO);
			sistema.altaEmpladoStaff("Julian", "Alvarez", 33333333, LocalDate.of(1990, 10, 5), LocalDate.of(2002, 5, 2),CategoriaCocinero.SUSHI);
			
			sistema.altaEmpladoStaff("Rodrigo", "De Paul", 44444444, LocalDate.of(1996, 6, 7), LocalDate.of(2005, 8, 7),"Mañana");
			sistema.altaEmpladoStaff("Nico", "Paz", 55555555, LocalDate.of(1995, 6, 7), LocalDate.of(2005, 8, 7),"Mañana");
			sistema.altaEmpladoStaff("Cristiano", "Ronaldo", 66666666, LocalDate.of(1993, 6, 7), LocalDate.of(2001, 8, 7),"Noche");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Empleado e : sistema.getLstStaff()) {
			System.out.println(e);
			System.out.println("");
		}
		
	}

}
