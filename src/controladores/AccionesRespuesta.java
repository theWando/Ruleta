package controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.Respuesta;

import org.apache.log4j.Logger;

import controladores.utils.Constantes;

public class AccionesRespuesta {
    private DBConnector dbc;
    private ResultSet rs;
	private static Logger logger = Logger.getLogger(AccionesRespuesta.class);

    public ArrayList<Respuesta> buscarPregunta(int idPregunta){
    	ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
       	try{
    		dbc = new DBConnector();
    		rs = dbc.dbConsult(Constantes.TABLE_RESPUESTA, null, "id_pregunta = " + idPregunta);
    		while(rs.next()){
    			Respuesta res = new Respuesta();
    			res.setIdRespuesta(rs.getInt("id_respuesta"));
    			res.setRespuesta(rs.getString("respuesta"));
    			res.setCorrecta(rs.getBoolean("correcta"));
    			respuestas.add(res);
    		}
		} catch (SQLException e) {
            logger.fatal(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
            logger.fatal(e.getMessage(), e);
		}
    	return respuestas;
    }


}
