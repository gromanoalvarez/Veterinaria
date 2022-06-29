package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public class Veterinaria {

	private String nombreVeterinaria;
	private Set<Duenio>dueniosDeMascotas;
	private Set<Atencion>atenciones;

	public Veterinaria(String nombreVeterinaria) {
		this.nombreVeterinaria=nombreVeterinaria;
		this.dueniosDeMascotas=new HashSet<Duenio>();
		this.atenciones=new HashSet<Atencion>();
	}

	public String getNombreVeterinaria() {
		return nombreVeterinaria;
	}

	public void setNombreVeterinaria(String nombreVeterinaria) {
		this.nombreVeterinaria = nombreVeterinaria;
	}

	public void agregarDuenioMascotas(Duenio duenio) {
		// TODO Auto-generated method stub
		this.dueniosDeMascotas.add(duenio);
		
	}

	public Set<Duenio> getDueniosDeMascotas() {
		return dueniosDeMascotas;
	}

	public void setDueniosDeMascotas(Set<Duenio> dueniosDeMascotas) {
		this.dueniosDeMascotas = dueniosDeMascotas;
	}

	public void iniciarAtencion(Integer idDuenio, Integer idMascota, Double precioAtencion) throws DuenioInexistenteException, MascotaNoEncontradaException {
		
		Duenio duenioEncontrado=buscarDuenio(idDuenio);
		
		atenciones.add(new Atencion(duenioEncontrado,duenioEncontrado.buscarMascota(idMascota), 157.23));
		
	}

	public Duenio buscarDuenio(Integer idDuenio) throws DuenioInexistenteException {
		
		for (Duenio actual : this.dueniosDeMascotas) {
			if (actual.getDni().equals(idDuenio)) {
				return actual;
			}
	
		}
		throw new DuenioInexistenteException("El dueño buescado no es cliente");
	
	}

	public Set<Atencion> getAtenciones() {
		return atenciones;
	}

	public void setAtenciones(Set<Atencion> atenciones) {
		this.atenciones = atenciones;
	}
	
}
