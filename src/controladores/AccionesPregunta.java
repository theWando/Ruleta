package controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import vistas.PreguntaPopUp;

import controladores.utils.Constantes;

import modelos.Categoria;
import modelos.Pregunta;
import modelos.Respuesta;

public class AccionesPregunta {
    private DBConnector dbc;
    private ResultSet rs;
	private static Logger logger = Logger.getLogger(AccionesPregunta.class);

    public Pregunta buscarPregunta(boolean tipoPregunta, int idCat){
    	Pregunta pre = new Pregunta();
       	try{
    		dbc = new DBConnector();
    		rs = dbc.dbConsult(Constantes.TABLE_PREGUNTA, null, "id_categoria = " + idCat + " AND turno = TRUE");
    		while(rs.next()){
    			pre.setIdCategoria(idCat);
    			pre.setPregunta(rs.getString("pregunta"));
    			pre.setIdPregunta(rs.getInt("id_pregunta"));
    			pre.setTurno(rs.getBoolean("turno"));
    			AccionesRespuesta ar = new AccionesRespuesta();
    			ArrayList<Respuesta> respuestas = ar.buscarPregunta(pre.getIdPregunta());
    			pre.setOpciones(respuestas);
    			pre.setTipo(tipoPregunta);
    			for(int i = 0; i < pre.getOpciones().size(); i++){
    				Respuesta res = pre.getOpciones().get(i);
    				if(res.isCorrecta())
    					pre.setRespuestaCorrecta(res.getRespuesta());
    			}
    			AccionesCategoria ac = new AccionesCategoria();
    			Categoria cat = ac.buscarCategoria(idCat);
    			pre.setNombreCategoria(cat.getNombreCategoria());
    		}
		} catch (SQLException e) {
            logger.fatal(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
            logger.fatal(e.getMessage(), e);
		}
    	return pre;
    }
    
    public ArrayList<Pregunta> buscarPreguntasxCat(boolean tipoPregunta, int idCat){
    	ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>(); 
       	try{
    		dbc = new DBConnector();
    		rs = dbc.dbConsult(Constantes.TABLE_PREGUNTA, null, "id_categoria = " + idCat + " ORDER BY id_pregunta");
    		while(rs.next()){
    			Pregunta pre = new Pregunta();
    			pre.setIdCategoria(idCat);
    			pre.setPregunta(rs.getString("pregunta"));
    			pre.setIdPregunta(rs.getInt("id_pregunta"));
    			AccionesRespuesta ar = new AccionesRespuesta();
    			ArrayList<Respuesta> respuestas = ar.buscarPregunta(pre.getIdPregunta());
    			pre.setOpciones(respuestas);
    			pre.setTipo(tipoPregunta);
    			for(int i = 0; i < pre.getOpciones().size(); i++){
    				Respuesta res = pre.getOpciones().get(i);
    				if(res.isCorrecta())
    					pre.setRespuestaCorrecta(res.getRespuesta());
    			}
    			preguntas.add(pre);
    		}
    		logger.debug(preguntas);
		} catch (SQLException e) {
            logger.fatal(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
            logger.fatal(e.getMessage(), e);
		}
    	return preguntas;
    }
    
    public boolean cambiarTurnoPregunta(Pregunta pre){
    	ArrayList<Pregunta> preguntas = null;
    	boolean actualizarMenor = true;
    	try{
    		preguntas = this.buscarPreguntasxCat(false, pre.getIdCategoria());
    		if(preguntas != null){
	    		for(int i = 0; i < preguntas.size(); i++){
	    			Pregunta pregunta = preguntas.get(i);
	    			logger.debug(pregunta);
	    			if(pregunta.getIdPregunta() > pre.getIdPregunta()){
	    	    		dbc = new DBConnector();
	    	    		dbc.dbUpdate(Constantes.TABLE_PREGUNTA, "id_pregunta = " + pregunta.getIdPregunta(), "turno = 1");
	    	    		actualizarMenor = false;
	    	    		break;
	    			}
	    		}
	    		logger.debug("actualizarMenor: " + actualizarMenor);
	    		if(actualizarMenor){
	    			Pregunta pregunta = preguntas.get(0);
    	    		dbc = new DBConnector();
    	    		dbc.dbUpdate(Constantes.TABLE_PREGUNTA, "id_pregunta = " + pregunta.getIdPregunta(), "turno = 1");
	    		}
    		}
    		dbc = new DBConnector();
    		dbc.dbUpdate(Constantes.TABLE_PREGUNTA, "id_pregunta = " + pre.getIdPregunta(), "turno = 0");
    	}catch (SQLException e) {
            logger.fatal(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
            logger.fatal(e.getMessage(), e);
		}
		return true;
    }

}
