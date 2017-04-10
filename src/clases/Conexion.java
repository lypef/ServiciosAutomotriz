/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lypef
 */
public class Conexion {
    private Connection con;
    private Statement  sentSQL;
    private ResultSet rst;
    ReturnProperties p = new ReturnProperties();
    
    public Conexion () throws ClassNotFoundException,SQLException,InstantiationException,IllegalAccessException{
        String controlador="com.mysql.jdbc.Driver";
        Class.forName(controlador).newInstance();
        conectar();
    }

    public void conectar() throws SQLException{
    
        try {
            String URL_bd ="jdbc:mysql://"+p.ReturnPropiedad(p.ruta_db)+":"+p.ReturnPropiedad(p.puerto_db)+"/" + p.ReturnPropiedad(p.nombre_db);
            
            con = DriverManager.getConnection(URL_bd, p.ReturnPropiedad(p.usuario_db), p.ReturnPropiedad(p.passwors_db));
            sentSQL = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public boolean ejecutar(String sql) throws SQLException
    {
        return sentSQL.executeUpdate(sql)  > 0;
    }
     
    public ResultSet Consulta(String sql) throws SQLException
    {
        return sentSQL.executeQuery(sql);
    }
}