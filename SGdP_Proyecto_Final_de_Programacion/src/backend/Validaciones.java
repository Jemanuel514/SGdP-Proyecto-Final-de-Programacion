package backend;

import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {
	
	public static boolean soloLetras(String cadena) {
		for (char caracter : cadena.toCharArray()) {
			
			if (!(Character.isLetter(caracter) || caracter == ' ')) {
				return false;
			}
			
		}
		
		return true;
		
	}
	
	public static boolean validarCedula(String cadena) {
        String patron = "^(1[0-3]|[1-9])-\\d{3,5}-\\d{3,6}$";

        Pattern pattern = Pattern.compile(patron);

        Matcher matcher = pattern.matcher(cadena);

        if (matcher.matches()) {
            return true;
        }
        
        return false;
		
	}
	
	public static boolean validaCorreo(String cadena) {
        String patron = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        Pattern pattern = Pattern.compile(patron);

        Matcher matcher = pattern.matcher(cadena);

        if (matcher.matches()) {
            return true;
        }
        
        return false;
		
	}
	
	public static boolean validarTelefono(String cadena) {
        String patron = "^6\\d{3}-\\d{4}$";

        Pattern patron_compilado = Pattern.compile(patron);

        Matcher comparador = patron_compilado.matcher(cadena);

        if (comparador.matches()) {
            return true;
        }
        
        return false;
		
	}
	
	public static boolean validarEnteroPositivo(String cadena) {
        int numero;
		
		try {
        	numero = Integer.parseInt(cadena);
        }
		catch (NumberFormatException e) {
			return false;
		}
		
		if (numero <= 0) {
			return false;
		}
		
		return true;
		
	}
	
	public static int validarDia(String cadena) {
		//Devolver -1 para formato incorrecto, 0 para fecha pasada y 1 para fecha correcta.
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fecha;
		LocalDate manana = LocalDate.now().plusDays(1);

        try {
            fecha = LocalDate.parse(cadena, formato);
        }
        catch (DateTimeParseException e) {
        	return -1;
        }
        
        if (!fecha.isAfter(manana)) {
        	return 0;
        }
        
        return 1;
        
    }
	
	public static int validarHora(String hora1, String hora2) {
		//Devolver -2 para hora de inicio incorrecta, -1 para hora de finalización incorrecta, 0 para duración incorrecta (menos de 1h) y 1 para horas correctas.
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime hora_inicio;
		LocalTime hora_final;
		Duration duracion;
		
        try {
        	hora_inicio = LocalTime.parse(hora1, formato);
        }
        catch (DateTimeParseException e) {
        	return -2;
        }
        
        try {
        	hora_final = LocalTime.parse(hora2, formato);
        }
        catch (DateTimeParseException e) {
        	return -1;
        }
        
        duracion = Duration.between(hora_inicio, hora_final);
        if (duracion.getSeconds() < 3600) {
            return 0;
        }
        
        return 1;
        
    }
	
	public static boolean estaInscrito(int id_estudiante, int id_convocatoria, ManejoSQL db) {
		
		try {
			// Consulta de datos
			db.consultarDatos("SELECT * FROM Inscripciones");
			
			while(db.datos.next()) {
				if(db.datos.getInt("estudiante_id") == id_estudiante && db.datos.getInt("convocatoria_id") == id_convocatoria) {
					return true;
				}
			}
			
			return false;
			
		}
		catch(SQLException e) {
			System.out.println("Error al consultar la base de datos: " + e.getMessage());
		}
		finally {
			db.cerrarConexion();
		}
		
		return false;
		
	}
	
	public static boolean cuposDisponibles(int id_convocatoria, ManejoSQL db) {
		
		try {
			// Consulta de datos
			db.consultarDatos("SELECT estudiantes, count(Inscripciones.id) as inscritos FROM Proyectos "
					+ "INNER JOIN Convocatorias ON Proyectos.id = Convocatorias.proyecto_id "
					+ "LEFT JOIN Inscripciones ON Convocatorias.id = Inscripciones.convocatoria_id "
					+ "WHERE Convocatorias.id = " + id_convocatoria);
			
			if(db.datos.getInt("inscritos") < db.datos.getInt("estudiantes")) {
				return true;				
			}
			
		}
		catch(SQLException e) {
			System.out.println("Error al consultar la base de datos: " + e.getMessage());
		}
		finally {
			db.cerrarConexion();
		}
		
		return false;
		
	}
	
}
