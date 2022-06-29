package ar.edu.unlam.pb2;

public class Atencion {

	private Duenio duenioEncontrado;
	private Mascota buscarMascota;
	private Double precio;

	public Atencion(Duenio duenioEncontrado, Mascota buscarMascota, Double precio) {
		// TODO Auto-generated constructor stub
		this.duenioEncontrado=duenioEncontrado;
		this.buscarMascota=buscarMascota;
		this.precio=precio;
	}

	public Duenio getDuenioEncontrado() {
		return duenioEncontrado;
	}

	public void setDuenioEncontrado(Duenio duenioEncontrado) {
		this.duenioEncontrado = duenioEncontrado;
	}

	public Mascota getBuscarMascota() {
		return buscarMascota;
	}

	public void setBuscarMascota(Mascota buscarMascota) {
		this.buscarMascota = buscarMascota;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
