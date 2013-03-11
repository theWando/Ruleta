package controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import modelos.Participante;
import modelos.Usuario;

import org.apache.log4j.Logger;

import controladores.utils.Constantes;

public class AccionesParticipante {
    private DBConnector dbc;
    private ResultSet rs;
	private static Logger logger = Logger.getLogger(AccionesParticipante.class);
	
	public boolean crearParticipante(Participante par){
		int inserts = 0;
		try{
			dbc = new DBConnector();
			inserts += dbc.dbInsercion(Constantes.TABLE_USUARIO, "'" + par.getNombre() + "','" + par.getApellido() + "'," + par.isSexo() + ",'" + par.getFdn() + "'," + par.getNEdad(), "nombre_persona, apellido_persona, sexo, fdn, edad");
			par.setIdUsuario(this.buscarIdUsuario(par));
			inserts += dbc.dbInsercion(Constantes.TABLE_PARTICIPANTE, "'" + par.getNick() + "','" + par.getContrasena() + "'," + par.getIdUsuario(), "login, pass, id_usuario");
		} catch (SQLException e) { 
            logger.fatal(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
            logger.fatal(e.getMessage(), e);
		}
		if(inserts > 1)
			return true;
		else
			return false;
	}
	
	public int buscarIdUsuario(Usuario user){
		try{
			dbc = new DBConnector();
			rs = dbc.dbConsult(Constantes.TABLE_USUARIO, "id_persona", "nombre_persona = '" + user.getNombre() + "' AND apellido_persona = '" + user.getApellido() + "'");
			while(rs.next()){
				user.setIdUsuario(rs.getInt("id_persona"));
			}
		} catch (SQLException e) { 
            logger.fatal(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
            logger.fatal(e.getMessage(), e);
		}
		return user.getIdUsuario();
	}
	
	public Participante buscarParticipantexId(Participante par){
		try{
			dbc = new DBConnector();
			rs = dbc.dbConsult(Constantes.TABLE_USUARIO, null, "id_persona = " + par.getIdUsuario());
			while(rs != null && rs.next()){
				par.setNombre(rs.getString("nombre_persona"));
				par.setApellido(rs.getString("apellido_persona"));
				par.setSexo(rs.getBoolean("sexo"));
				par.setFdn(rs.getString("fdn"));
				par.setEdad(rs.getInt("edad"));
			}
		} catch (SQLException e) { 
            logger.fatal(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
            logger.fatal(e.getMessage(), e);
		}
		return par;
	}
	
	public Participante buscarUsuarioxLoginPass(String login, String pass){
		Participante par = new Participante();
		try{
			dbc = new DBConnector();
			rs = dbc.dbConsult(Constantes.TABLE_PARTICIPANTE, null, "login = '" + login + "' AND pass = '" + pass + "'");
			while(rs.next()){
				par.setNick(login);
				par.setContrasena(pass);
				par.setIdUsuario(rs.getInt("id_usuario"));
				par = this.buscarParticipantexId(par);
			}
		} catch (SQLException e) { 
            logger.fatal(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
            logger.fatal(e.getMessage(), e);
		}
		return par;
	}
	
	public Participante calcularPromedioParticipante(Participante par){
		par.partidaCompletada();
		if(par.getnJuegos() != 0)
			par.setPromedio(par.getPuntajeTotal()/par.getnJuegos());
		else
			par.setPromedio(0);
		logger.debug("promedio de puntaje: " + par.getPromedio());
		try{
			dbc = new DBConnector();
			dbc.dbUpdate(Constantes.TABLE_PARTICIPANTE, "login = '" + par.getNick() + "' AND id_usuario = " + par.getIdUsuario() , "puntaje = " + par.getNPuntaje() + ", numero_juegos = " + par.getnJuegos());
		} catch (SQLException e) { 
            logger.fatal(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
            logger.fatal(e.getMessage(), e);
		}
		return par;
	}
}
