package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVeterinaria {

	@Test
	public void queSePuedaInstanciarUnaVeterinariaConNombre() {
		Veterinaria veterinaria=new Veterinaria("Huellitas");
		assertNotNull(veterinaria);
		assertEquals("Huellitas", veterinaria.getNombreVeterinaria());
	}

	@Test
	public void queSePuedaCrearUnDuenioConDniYConNombre() {
		Duenio duenio=new Duenio(111,"Rogelio");
		assertNotNull(duenio);
	}
	
	@Test
	public void queSePuedaCrearUnaMascotaConNombreIdApodoYTipoDeMascota() {
		// El tipo de mascota puede ser solamente doméstica y exótica (enum)
		Mascota mascota1=new Mascota("Petaca",1,"Peta",TipoDeMascota.DOMESTICA);
	}
	
	@Test
	public void queSePuedaAgregarDosMascotasAUnDuenio() throws MascotaDuplicada {
		Mascota mascota1=new Mascota("Petaca",1,"Peta",TipoDeMascota.DOMESTICA);
		Mascota mascota2=new Mascota("Felipa",2,"Feli",TipoDeMascota.DOMESTICA);
		
		Duenio duenio=new Duenio(111,"Rogelio");
		duenio.agregarMascota(mascota1);
		duenio.agregarMascota(mascota2);
		assertEquals(2, duenio.getListaMascotas().size());
	}
	
	@Test (expected=MascotaDuplicada.class)
	public void queAlAgregarDosMascotasConMismoIdParaUnMismoDuenioLanceUnaExcepcionMascotaDuplicadaException() throws MascotaDuplicada {
	
		Mascota mascota1=new Mascota("Petaca",1,"Peta",TipoDeMascota.DOMESTICA);
		Mascota mascota2=new Mascota("Felipa",1,"Feli",TipoDeMascota.DOMESTICA);
		
		Duenio duenio=new Duenio(111,"Rogelio");
		duenio.agregarMascota(mascota1);
		duenio.agregarMascota(mascota2);
		assertEquals(1, duenio.getListaMascotas().size());
	
	}
	
	@Test
	public void queSePuedaCrearUnMedicamentoConIdDescripcionYPrecio() {
		final Integer idMedicamento=1;
		final Double precioMedicamento=250.30;
		Medicamento medicina=new Medicamento(idMedicamento,"para la tos",precioMedicamento);
		assertNotNull(medicina);
	}
	
	@Test
	public void queSePuedanAgregarDueniosDeMascotasAUnaVeterinaria() {
		Duenio duenio=new Duenio(111,"Rogelio");
		Duenio duenio2=new Duenio(222,"Marta");
		
		Veterinaria veterinaria=new Veterinaria("Huellitas");
		
		veterinaria.agregarDuenioMascotas(duenio);
		veterinaria.agregarDuenioMascotas(duenio2);
		
		Integer valorEsperado=2;
		assertEquals(valorEsperado,(Integer) veterinaria.getDueniosDeMascotas().size());
	}
	
	@Test 
	public void queSePuedaCrearUnaAtencionConIdDeDuenioIdDeMascotaYPrecio()
			throws DuenioInexistenteException, MascotaNoEncontradaException, MascotaDuplicada {
		Veterinaria veterinaria = new Veterinaria("Huellitas");

		Integer idDuenio = 111, idMascota = 1;
		Double precioAtencion = 120.33;
		Duenio duenio = new Duenio(idDuenio, "Rogelio");
		veterinaria.agregarDuenioMascotas(duenio);
		
		Mascota mascota1 = new Mascota("Petaca", idMascota, "Peta", TipoDeMascota.DOMESTICA);
		duenio.agregarMascota(mascota1);
		try {
			veterinaria.iniciarAtencion(idDuenio, idMascota, precioAtencion);
		} catch (DuenioInexistenteException e) {
			System.err.println(e);

		} catch (MascotaNoEncontradaException e) {
			System.err.println(e);
		}
		assertEquals(1, veterinaria.getAtenciones().size());
		System.out.println(veterinaria.getAtenciones().size());
		}
	/*
	@Test
	public void queSePuedaAsignarVariosMedicamentosAUnaAtencion() {
		// Para asignar un medicamento necesita el id de la atencion y el id del medicamento
	}
	
	@Test
	public void queSePuedaCalcularElPrecioTotalDeUnaAtencion() {
		// El precio total de la atencion será la suma del precio de la atencion mas la suma del precio de todos los medicamentos
	}
	
	@Test
	public void queSePuedaObtenerDeUnDuenioUnaListaDeMascotasDomesticasOrdenadasPorApodo() {
		
	}
	
	@Test
	public void queSePuedaObtenerUnMapaConIdDeAtencionYIdDeMascota() {
		
	}
	*/
}
