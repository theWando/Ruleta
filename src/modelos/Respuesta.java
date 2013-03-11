package modelos;

public class Respuesta {
	private int idRespuesta;
	private String respuesta;
	private boolean correcta;
	
	public int getIdRespuesta() {
		return idRespuesta;
	}
	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public boolean isCorrecta() {
		return correcta;
	}
	public void setCorrecta(boolean correcta) {
		this.correcta = correcta;
	}
	
	public Respuesta() {
		super();
	}
	public Respuesta(String respuesta, boolean correcta) {
		super();
		this.respuesta = respuesta;
		this.correcta = correcta;
	}
}
