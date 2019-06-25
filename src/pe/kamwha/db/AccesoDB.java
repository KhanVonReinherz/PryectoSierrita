
package pe.kamwha.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccesoDB {
    private static AccesoDB instancia; 
    private Connection cn; 

    private AccesoDB() {
     
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Driver
            try {
                cn = DriverManager.getConnection("jdbc:sqlserver://chifakamwha.database.windows.net:1433;databaseName=DBKamWha", "KamWhaAdmin", "Kamwha123456");
            } catch (SQLException ex) {
                System.out.println("ERROR en SQL: " + ex);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR en CLASS" + ex);
        }
    }

    public synchronized static AccesoDB saberEstado(){
        if(instancia == null){
            instancia = new AccesoDB();
        }
        
        return instancia;
    }
    
    public Connection getCn() {
        return cn;
    }
    
    public void cerrarConexion(){
        instancia = null;
    }
    
}
