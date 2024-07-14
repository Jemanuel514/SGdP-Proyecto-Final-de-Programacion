package backend;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManejoSQL {
	
	public Connection conexion = null;
	public Statement consulta = null;
	public ResultSet datos = null;
	
	public Connection conectar() {
		//Variables
		Path rutaProyecto = Paths.get(".").toAbsolutePath().normalize();
		Path rutaDB = rutaProyecto.resolve("db/SGdP_DB.db");
		String ruta = "jdbc:sqlite:" + rutaDB.toString();
		
		try {
			conexion = DriverManager.getConnection(ruta);
			System.out.println("Conexión establecida.");
		}
		catch(SQLException e) {
			System.out.println("Eror al conectar con la base de datos." + e.getMessage());
		}
		
		return conexion;
	}
	
	public void consultarDatos(String instruccion) {
		
		try {
			conexion = conectar();
			consulta = conexion.createStatement();
			datos = consulta.executeQuery(instruccion);
			System.out.println("Consulta realizada.");
		}
		catch(SQLException e) {
			System.out.println("Error al consultar la base de datos. " + e.getMessage());
		}
		
	}
	
	
	public int insertarDatos(String instruccion) {
		//Variables
	    int idGenerado = -1;

	    try {
	        conexion = conectar();
	        consulta = conexion.createStatement();
	        consulta.executeUpdate(instruccion, Statement.RETURN_GENERATED_KEYS);
	        System.out.println("Consulta realizada.");
	        
	        datos = consulta.getGeneratedKeys();
	        idGenerado = datos.getInt(1);
	        
	    }
	    catch (SQLException e) {
	        System.out.println("Error al consultar la base de datos. " + e.getMessage());
	    }
	    
	    return idGenerado;
	    
	}
	
	public void cerrarConexion() {
        try {
        	if (datos != null) {
        		datos.close();
        	}
            if (consulta != null) {
                consulta.close();
            }

            if (conexion != null) {
                conexion.close();
            }

        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
        
    }
	
}
