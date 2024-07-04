package backend;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManejoSQL {
	
	public static Connection conectar() {
		//Variables
		Path rutaProyecto = Paths.get(".").toAbsolutePath().normalize();
		Path rutaDB = rutaProyecto.resolve("db/SGdP_DB.db");
		String ruta = "jdbc:sqlite:" + rutaDB.toString();
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(ruta);
			System.out.println("Conexión establecida.");
		}
		catch(SQLException e) {
			System.out.println("Eror al conectar con la base de datos." + e.getMessage());
		}
		
		return conexion;
	}
	
	public static ResultSet consultarDatos(String instruccion) {
		//Variables
		Connection conexion = null;
		Statement consulta = null;
		ResultSet datos = null;
		
		try {
			conexion = conectar();
			consulta = conexion.createStatement();
			datos = consulta.executeQuery(instruccion);
			System.out.println("Consulta realizada.");
		}
		catch(SQLException e) {
			System.out.println("Error al consultar la base de datos. " + e.getMessage());
		}
		
		return datos;
	}
}
