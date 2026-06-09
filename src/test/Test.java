package test;

import java.time.LocalDate;
import java.util.List;

import modelo.*;

public class Test {

	public static void main(String[] args) {

		Sistema sistema = new Sistema();

		System.out.println("=================================");
		System.out.println("CASO 1 - ALTAS");
		System.out.println("=================================");

		try {

			// COCINEROS
			sistema.altaEmpladoStaff("Lionel", "Messi", 11111111,
					LocalDate.of(1986, 10, 5),
					LocalDate.of(2010, 5, 2),
					CategoriaCocinero.PASTELERO);

			sistema.altaEmpladoStaff("Dibu", "Martinez", 22222222,
					LocalDate.of(1987, 5, 1),
					LocalDate.of(2012, 4, 1),
					CategoriaCocinero.PARRILLERO);

			sistema.altaEmpladoStaff("Julian", "Alvarez", 33333333,
					LocalDate.of(1990, 7, 15),
					LocalDate.of(2014, 3, 1),
					CategoriaCocinero.SUSHI);

			// CAJEROS
			sistema.altaEmpladoStaff("Rodrigo", "De Paul", 44444444,
					LocalDate.of(1994, 6, 20),
					LocalDate.of(2018, 1, 10),
					"Mañana");

			sistema.altaEmpladoStaff("Nico", "Paz", 55555555,
					LocalDate.of(1995, 2, 12),
					LocalDate.of(2019, 2, 15),
					"Tarde");

			sistema.altaEmpladoStaff("Cristiano", "Ronaldo", 66666666,
					LocalDate.of(1985, 8, 10),
					LocalDate.of(2005, 5, 20),
					"Noche");

			System.out.println("Empleados cargados correctamente");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {

			sistema.altaUnidadVenta(
					"FT00001",
					"Burger House",
					20,
					sistema.traerEmpleado(11111111),
					"ABC123",
					true);

			sistema.altaUnidadVenta(
					"FT00002",
					"Pizza Truck",
					15,
					sistema.traerEmpleado(22222222),
					"DEF456",
					false);

			sistema.altaUnidadVenta(
					"PD00001",
					"Parrilla Criolla",
					30,
					sistema.traerEmpleado(33333333),
					5,
					30);

			sistema.altaUnidadVenta(
					"PD00002",
					"Dulce Tentacion",
					10,
					sistema.traerEmpleado(11111111),
					2,
					20);

			System.out.println("Unidades cargadas correctamente");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {

			sistema.AltaFestival(
					"Epicentro Gourmet",
					"2026",
					LocalDate.of(2026, 7, 1),
					LocalDate.of(2026, 7, 15),
					500,
					10,
					2000,
					100000,
					5000);

			System.out.println("Festival creado correctamente");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Festival festival =
				sistema.traerFestival("Epicentro Gourmet", "2026");

		try {

			festival.agregarUnidadVenta(
					sistema.traerUnidadVenta("FT00001"));

			festival.agregarUnidadVenta(
					sistema.traerUnidadVenta("FT00002"));

			festival.agregarUnidadVenta(
					sistema.traerUnidadVenta("PD00001"));

			festival.agregarUnidadVenta(
					sistema.traerUnidadVenta("PD00002"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// EMPLEADOS ADICIONALES A UNIDADES

		try {

			sistema.traerUnidadVenta("FT00001")
					.agregarEmpleado(
							sistema.traerEmpleado(44444444));

			sistema.traerUnidadVenta("FT00002")
					.agregarEmpleado(
							sistema.traerEmpleado(55555555));

			sistema.traerUnidadVenta("PD00001")
					.agregarEmpleado(
							sistema.traerEmpleado(66666666));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println();
		System.out.println("=================================");
		System.out.println("CASO 2 - BUSQUEDAS");
		System.out.println("=================================");

		System.out.println(sistema.traerEmpleado(11111111));
		System.out.println(sistema.traerUnidadVenta("FT00001"));

		System.out.println();
		System.out.println("=================================");
		System.out.println("CASO 3 - CALCULO CANON");
		System.out.println("=================================");

		try {

			for(UnidadVenta u : festival.getLstUnidadesDelFestival()) {

				System.out.println(
						u.getNombreComercial()
						+ " -> "
						+ festival.calcularCanon(u));
			}

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println();
		System.out.println("=================================");
		System.out.println("CASO 4 - SUELDOS");
		System.out.println("=================================");

		try {

			for(Empleado e : sistema.getLstStaff()) {

				System.out.println(
						e.getNombre() +
						" -> $" +
						festival.calcularSueldo(e.getDni()));
			}

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		// MENU

		try {

			UnidadVenta burger =
					sistema.traerUnidadVenta("FT00001");

			burger.agregarPlato("Hamburguesa",12000,5000);
			burger.agregarPlato("Papas",6000,2000);
			burger.agregarPlato("Gaseosa",3000,1000);

			UnidadVenta pizza =
					sistema.traerUnidadVenta("FT00002");

			pizza.agregarPlato("Pizza",15000,7000);
			pizza.agregarPlato("Faina",4000,1500);

			UnidadVenta parrilla =
					sistema.traerUnidadVenta("PD00001");

			parrilla.agregarPlato("Asado",20000,9000);
			parrilla.agregarPlato("Choripan",8000,3000);

			UnidadVenta dulce =
					sistema.traerUnidadVenta("PD00002");

			dulce.agregarPlato("Torta",10000,3000);
			dulce.agregarPlato("Cafe",4000,1000);

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println();
		System.out.println("=================================");
		System.out.println("CASO 5 - PEDIDOS");
		System.out.println("=================================");

		try {

			UnidadVenta burger =
					sistema.traerUnidadVenta("FT00001");

			sistema.agregarPedido("FT00001", festival, LocalDate.now());
			sistema.agregarPedido("FT00001", festival, LocalDate.now());
			sistema.agregarPedido("FT00001", festival, LocalDate.now());

			burger.getLstPedidos().get(0)
					.agregarItem(5, burger.traerPlato("Hamburguesa"));

			burger.getLstPedidos().get(0)
					.agregarItem(3, burger.traerPlato("Papas"));

			burger.getLstPedidos().get(1)
					.agregarItem(8, burger.traerPlato("Hamburguesa"));

			burger.getLstPedidos().get(1)
					.agregarItem(4, burger.traerPlato("Gaseosa"));

			burger.getLstPedidos().get(2)
					.agregarItem(10, burger.traerPlato("Hamburguesa"));

			UnidadVenta pizza =
					sistema.traerUnidadVenta("FT00002");

			sistema.agregarPedido("FT00002", festival, LocalDate.now());
			sistema.agregarPedido("FT00002", festival, LocalDate.now());

			pizza.getLstPedidos().get(0)
					.agregarItem(4, pizza.traerPlato("Pizza"));

			pizza.getLstPedidos().get(0)
					.agregarItem(3, pizza.traerPlato("Faina"));

			pizza.getLstPedidos().get(1)
					.agregarItem(6, pizza.traerPlato("Pizza"));

			UnidadVenta parrilla =
					sistema.traerUnidadVenta("PD00001");

			sistema.agregarPedido("PD00001", festival, LocalDate.now());
			sistema.agregarPedido("PD00001", festival, LocalDate.now());

			parrilla.getLstPedidos().get(0)
					.agregarItem(3, parrilla.traerPlato("Asado"));

			parrilla.getLstPedidos().get(0)
					.agregarItem(5, parrilla.traerPlato("Choripan"));

			parrilla.getLstPedidos().get(1)
					.agregarItem(2, parrilla.traerPlato("Asado"));

			UnidadVenta dulce =
					sistema.traerUnidadVenta("PD00002");

			sistema.agregarPedido("PD00002", festival, LocalDate.now());

			dulce.getLstPedidos().get(0)
					.agregarItem(4, dulce.traerPlato("Torta"));

			dulce.getLstPedidos().get(0)
					.agregarItem(10, dulce.traerPlato("Cafe"));

			System.out.println("Pedidos cargados correctamente");

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println();
		System.out.println("=================================");
		System.out.println("CASO 6 - REPORTE RECAUDACION");
		System.out.println("=================================");

		try {

			ReporteVenta rv =
					sistema.reporteRecaudacion(festival);

			System.out.println("TOTAL FESTIVAL: $" +
					rv.getRecaudacionTotal());

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println();
		System.out.println("=================================");
		System.out.println("CASO 7 - FILTRO EDAD");
		System.out.println("=================================");

		List<Empleado> filtrados =
				sistema.filtrarEdadEmpelado(
						LocalDate.of(1985,1,1),
						LocalDate.of(1992,12,31));

		for(Empleado e : filtrados) {
			System.out.println(e.getNombre());
		}

		System.out.println();
		System.out.println("=================================");
		System.out.println("CASO 8 Y 9 - RENTABILIDAD");
		System.out.println("=================================");

		try {

			for(UnidadVenta u :
					festival.getLstUnidadesDelFestival()) {

				System.out.println(
						u.getNombreComercial()
						+ " -> "
						+ sistema.calculoRentabilidadNeta(
								u,
								festival));
			}

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println();
		System.out.println("=================================");
		System.out.println("CASO 10 - RANKING");
		System.out.println("=================================");

		int pos = 1;

		for(UnidadVenta u :
				sistema.rankingUnidades(festival)) {

			System.out.println(
					pos + ") "
					+ u.getNombreComercial()
					+ " -> $"
					+ sistema.calcularTotalUnidad(u));

			pos++;
		}

		System.out.println();
		System.out.println("=================================");
		System.out.println("CASO 11 - PLATO ESTRELLA");
		System.out.println("=================================");

		Plato estrella =
				sistema.platoEstrella(
						sistema.traerUnidadVenta("FT00001"),
						festival);

		System.out.println(
				"Plato estrella Burger House: "
				+ estrella.getNombrePlato());

		System.out.println();
		System.out.println("=================================");
		System.out.println("CASO 12 - AUDITORIA");
		System.out.println("=================================");
		System.out.println("Los trabajadores que participaron en el festival:");
		System.out.println(festival.toString());
		System.out.println("fueron:");
		for(Empleado e :
				sistema.auditoriaFestival(festival)) {

			System.out.println(
					e.getNombre()
					+ " "
					+ e.getApellido());
		}

		System.out.println();
		System.out.println("=================================");
		System.out.println("CASO 13 - MAYORES CANON");
		System.out.println("=================================");

		for(ReporteMayoresCanon r :
				sistema.traerUnidadesMayorCanon(festival)) {

			System.out.println(
					r.getNombreComercial()
					+ " | "
					+ r.getCodigo()
					+ " | Canon: $"
					+ r.getCanon());
		}

		System.out.println();
		System.out.println("=================================");
		System.out.println("PRUEBA DE EXCEPCIONES");
		System.out.println("=================================");

		try {
			sistema.altaEmpladoStaff(
					"Duplicado",
					"Duplicado",
					11111111,
					LocalDate.of(1990,1,1),
					LocalDate.of(2020,1,1),
					"Tarde");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			sistema.AltaFestival(
					"Epicentro Gourmet",
					"2026",
					LocalDate.now(),
					LocalDate.now(),
					500,
					10,
					2000,
					100000,
					5000);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			sistema.altaUnidadVenta(
					"FT00001",
					"Duplicada",
					20,
					sistema.traerEmpleado(11111111), "ZZZ999",
					true);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			sistema.bajaEmpleado(99999999);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			sistema.agregarPedido(
					"FT99999",
					festival,
					LocalDate.now());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			festival.calcularCanon("FT02384");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}