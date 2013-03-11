package modelos;

import java.util.List;

public class Categoria {
	private int idCategoria;
	private String nombreCategoria;
	private List<Pregunta> preguntas;
	private int turnoPregunta;
	
	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	public List<Pregunta> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	public int getTurnoPregunta() {
		return turnoPregunta;
	}
	public void setTurnoPregunta(int turnoPregunta) {
		this.turnoPregunta = turnoPregunta;
	}
	public String toString(){
		StringBuffer str = new StringBuffer(this.getClass().toString() + "[");
		str.append("idcategoria: ");
		str.append(idCategoria);
		str.append(" | nombreCategoria: ");
		str.append(nombreCategoria);
		str.append(" | turnoPregunta: ");
		str.append(turnoPregunta);
		str.append(" | preguntas: ");
		str.append(preguntas);
		str.append("]");
		return str.toString();
	}
}