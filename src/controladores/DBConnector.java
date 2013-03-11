package controladores;

import java.sql.*;

import org.apache.log4j.Logger;

public class DBConnector {

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
	private static Logger logger = Logger.getLogger(DBConnector.class);

    
    public DBConnector() throws SQLException, ClassNotFoundException{
    	logger.info("realizando coneccion con la Base de datos");
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/ruleta","ruleta_user","valencia2011");
        stmt = conn.createStatement();
        if (!conn.isClosed()) {
			logger.info("conectado a la Base de datos");
		}
    }

    public int dbInsercion(String table, String values, String args) throws SQLException{
        int rtValue;
        if(args == null){
        	logger.debug("ejecutando: INSERT INTO "+table+" VALUES("+values+")");
            rtValue = stmt.executeUpdate("INSERT INTO "+table+" VALUES("+values+")");
        }else{
        	logger.debug("INSERT INTO "+table+" ("+args+") VALUES("+values+")");
            rtValue = stmt.executeUpdate("INSERT INTO "+table+" ("+args+") VALUES("+values+")");
        }
        if(rtValue != 0)
            System.out.println("Guardado... Filas afectadas: "+rtValue+"\nTabla: '"+table+"'\nValues: '"+values+"'\n============================");
        return rtValue;
    }

    public ResultSet dbConsult(String table, String select, String param) throws SQLException{
        String query = new String("SELECT ");
        if(select == null)
            select = "*";
        query += select+" FROM "+table;
        if(param != null)
            query += " WHERE "+param;
        logger.info("Ejecutando SQL: "+query);
        rs = stmt.executeQuery(query);
        logger.info("Consulta realizada....\nBucando en la tabla: '"+table+"'\nSelect: '"+select+"'\nParam: '"+param+"'\n============================");
        return rs;
    }

    public void dbUpdate(String table, String args, String values) throws SQLException{
        String query = new String("UPDATE "+table+" SET "+values+" WHERE "+args);
        System.out.println("sql: "+query);
        stmt.executeUpdate(query);
        stmt.close();
        System.out.println("Actualizacion realizada....\nEn la tabla: '"+table+"'\nargs: '"+args+"'\nValues: '"+values+"'\n============================");
    }

    public void dbDelete(String table, String args) throws SQLException{
        String query = new String("DELETE FROM "+table);
        if(args != null)
            query += " WHERE "+args;
        stmt.executeUpdate(query);
        stmt.close();
        System.out.println("Borrado realizado....\nEn la tabla: '"+table+"'\nargs: "+args+"'\n============================");
    }
}
