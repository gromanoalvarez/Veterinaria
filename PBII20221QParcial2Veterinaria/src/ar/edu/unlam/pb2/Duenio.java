package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Objects;

public class Duenio {

	private Integer dni;
	private String nombre;
	private HashSet<Mascota>listaMascotas;

	public Duenio(Integer dni, String nombre) {
		this.dni=dni;
		this.nombre=nombre;
		this.listaMascotas=new HashSet<Mascota>();
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarMascota(Mascota mascota) throws MascotaDuplicada {
		// TODO Auto-generated method stub
		
		if (!this.listaMascotas.contains(mascota)) {
			this.listaMascotas.add(mascota);
		}else {
		throw new MascotaDuplicada("Mascota duplicada");
		}
		/*
		for (Mascota actual : listaMascotas) {
			if (actual.getId().equals(mascota)) {
				this.listaMascotas.add(mascota);
			}	
		}
		throw new MascotaDuplicada("Mascota duplicada");
		*/
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Duenio other = (Duenio) obj;
		return Objects.equals(dni, other.dni);
	}

	public HashSet<Mascota> getListaMascotas() {
		return listaMascotas;
	}

	public void setListaMascotas(HashSet<Mascota> listaMascotas) {
		this.listaMascotas = listaMascotas;
	}
public Mascota buscarMascota(Integer idMascota) throws MascotaNoEncontradaException  {
		
		for (Mascota actual : this.listaMascotas) {
			if (actual.getId().equals(idMascota)) {
				return actual;
			}
	
		}
		throw new MascotaNoEncontradaException("La mascota no se atiende en esta vet");
	
	}
}
