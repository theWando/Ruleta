package modelos;

import controladores.utils.Constantes;

public class Usuario {
	private int idUsuario;
	private String nombre;
	private String apellido;
	private boolean sexo;
	private String fdn;
	private int edad;
	
	
	public Usuario() {	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public boolean isSexo() {
		return sexo;
	}
	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
	public String getFdn() {
		return fdn;
	}
	public void setFdn(String fdn) {
		this.fdn = fdn;
	}
	public String getEdad() {
		return edad+Constantes.TXT_YEAR;
	}
	public int getNEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getSexo(){
		if(this.isSexo())
			return Constantes.SEXO_M;
		else
			return Constantes.SEXO_F;
	}

}
