package modelos;

import java.util.Date;

import vistas.CuadroParticipante;

import controladores.utils.Constantes;

public class Participante extends Usuario {
	private String nick;
	private String contrasena;
	private int puntaje;
	private int puntajeTotal;
	private float promedio;
	private int nJuegos;
	private Date fechaCreacion;
	
	public Participante() {
		super();
	}
	public Participante(CuadroParticipante cp) {
		this.nick = cp.getJlNombreTF().getText();
		this.contrasena = cp.getJlApellidoTF().getText();
		super.setNombre(cp.getJlNombreTF().getText());
		super.setApellido(cp.getJlApellidoTF().getText());
		boolean sexo = cp.getJlSexoTF();
		super.setFdn(cp.getJlDobP().getText());
		super.setEdad(Integer.parseInt(cp.getJlEdadP().getText().substring(0, cp.getJlEdadP().getText().indexOf(Constantes.TXT_YEAR))));
		String puntaje = (cp.getJlPuntajeP() != null)?cp.getJlPuntajeP().getText():"0";
		if(puntaje.indexOf(Constantes.TXT_PUNTOS) != -1)
			puntaje = puntaje.substring(0, puntaje.indexOf(Constantes.TXT_PUNTOS));
		this.puntaje = Integer.parseInt(puntaje);
		super.setSexo(sexo);
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getPuntaje() {
		return new String(puntaje + Constantes.TXT_PUNTOS);
	}
	
	public int getNPuntaje() {
		return puntaje;
	}
	
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	public void puntoGanado(int pts){
		this.puntaje+=pts;
		this.puntajeTotal+=pts;
	}
	
	public int getnJuegos() {
		return nJuegos;
	}
	public void setnJuegos(int nJuegos) {
		this.nJuegos = nJuegos;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public int getPuntajeTotal() {
		return puntajeTotal;
	}
	public void setPuntajeTotal(int puntajeTotal) {
		this.puntajeTotal = puntajeTotal;
	}
	public float getPromedio() {
		return promedio;
	}
	public void setPromedio(float promedio) {
		this.promedio = promedio;
	}
	public String toString(){
		StringBuffer str = new StringBuffer(this.getClass().toString() + "[");
		str.append("idUsuario: ");
		str.append(super.getIdUsuario());
		str.append(" | nick: ");
		str.append(this.nick);
		str.append(" | contrasena: ");
		str.append(this.contrasena);
		str.append(" | puntaje: ");
		str.append(this.puntaje);
		str.append(" | puntajeTotal: ");
		str.append(this.puntajeTotal);
		str.append(" | promedio: ");
		str.append(this.promedio);
		str.append(" | nJuegos: ");
		str.append(this.nJuegos);
		str.append(" | fechaCreacion: ");
		str.append(this.fechaCreacion);
		str.append(" | nombre: ");
		str.append(super.getNombre());
		str.append(" | apellido: ");
		str.append(super.getApellido());
		str.append(" | sexo: ");
		str.append(super.getSexo());
		str.append("]");
		return str.toString();
	}
	
	public boolean validarParticipante(){
		if(super.getNombre() == null || super.getNombre().trim().length() == 0)
			return false;
		if(super.getApellido() == null || super.getApellido().trim().length() == 0)
			return false;
		return true;
	}
	
	public void partidaCompletada(){
		this.nJuegos++;
	}
}
