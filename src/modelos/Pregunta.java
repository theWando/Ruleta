package modelos;

import java.util.List;

public class Pregunta {
	private int idPregunta;
	private String pregunta;
	private boolean tipo;
	private List<Respuesta> opciones;
	private int correcta;
	private String respuestaCorrecta;
	private int idCategoria;
	private String nombreCategoria;
	private boolean turno;
	
	
	public boolean isTurno() {
		return turno;
	}
	public void setTurno(boolean turno) {
		this.turno = turno;
	}
	public int getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public boolean isTipo() {
		return tipo;
	}
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	public List<Respuesta> getOpciones() {
		return opciones;
	}
	public void setOpciones(List<Respuesta> opciones) {
		this.opciones = opciones;
	}
	public int getCorrecta() {
		return correcta;
	}
	public void setCorrecta(int correcta) {
		this.correcta = correcta;
	}
	public String getRespuestaCorrecta() {
		return respuestaCorrecta;
	}
	public void setRespuestaCorrecta(String respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	public Pregunta() {
		super();
	}
	
	public String toString(){
		StringBuffer str = new StringBuffer(this.getClass().toString() + "[");
		str.append("idPregunta: ");
		str.append(idPregunta);
		str.append(" | pregunta: ");
		str.append(pregunta);
		str.append(" | tipo: ");
		str.append(tipo);
		str.append(" | opciones: ");
		str.append(opciones);
		str.append(" | correcta : ");
		str.append(correcta);
		str.append(" | respuestaCorrecta: ");
		str.append(respuestaCorrecta);
		str.append(" | idCategoria: ");
		str.append(idCategoria);
		str.append(" | nombroCategoria: ");
		str.append(nombreCategoria);
		str.append(" | categoria: ");
		str.append(nombreCategoria);
		str.append(" | turno: ");
		str.append(turno);
		str.append("]");
		return str.toString();
	}
}
