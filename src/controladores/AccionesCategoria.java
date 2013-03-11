package controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.Categoria;
import modelos.Respuesta;

import org.apache.log4j.Logger;

import controladores.utils.Constantes;

public class AccionesCategoria {
    private DBConnector dbc;
    private ResultSet rs;
	private static Logger logger = Logger.getLogger(AccionesCategoria.class);
	
    public Categoria buscarCategoria(int idCategoria){
    	Categoria cat = new Categoria();
       	try{
    		dbc = new DBConnector();
    		rs = dbc.dbConsult(Constantes.TABLE_CATEGORIA, null, "id_categoria = " + idCategoria);
    		while(rs.next()){
    			cat.setIdCategoria(idCategoria);
    			cat.setNombreCategoria(rs.getString("nombre"));
    		}
		} catch (SQLException e) {
            logger.fatal(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
            logger.fatal(e.getMessage(), e);
		}
    	return cat;
    }

    public ArrayList<Categoria> buscarCategorias(){
    	ArrayList<Categoria> categorias = new ArrayList<Categoria>();
       	try{
    		dbc = new DBConnector();
    		rs = dbc.dbConsult(Constantes.TABLE_CATEGORIA, null, null);
    		while(rs.next()){
    			Categoria cat = new Categoria();
    			cat.setIdCategoria(rs.getInt("id_categoria"));
    			cat.setNombreCategoria(rs.getString("nombre"));
    			categorias.add(cat);
    		}
		} catch (SQLException e) {
            logger.fatal(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
            logger.fatal(e.getMessage(), e);
		}
    	return categorias;
    }
}
