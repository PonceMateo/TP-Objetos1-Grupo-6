package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

//CLASE DE FUNCIONES ESTÁTICAS
public class Funciones {

	public static void imprimirLista(List<?> lista) {
	    for (Object elemento : lista) {
	        System.out.println(elemento);
	    }
	}

	public static boolean fechaEntreFechas(LocalDate fechaAComparar, LocalDate fechaDesde, LocalDate fechaHasta) {
		return !(fechaAComparar.isAfter(fechaHasta) || fechaAComparar.isBefore(fechaDesde));
	}
	
	public static boolean horaEntreHoras(LocalTime horaAComparar, LocalTime horaDesde, LocalTime horaHasta) {
	    return !(horaAComparar.isAfter(horaHasta) || horaAComparar.isBefore(horaDesde));
	}
	
}
