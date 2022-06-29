package ar.edu.unlam.pb2;

public class Medicamento {

	private Integer idMedicamento;
	private Double precioMedicamento;
	private String decripcion;

	public Medicamento(Integer idMedicamento, String descripcion,Double precioMedicamento) {
		this.idMedicamento=idMedicamento;
		this.decripcion=descripcion;
		this.precioMedicamento=precioMedicamento;
	}

}
