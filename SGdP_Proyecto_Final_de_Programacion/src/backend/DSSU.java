package backend;

public class DSSU extends Usuario{
	
	//Constructor
	public DSSU(int id, int tipo, String usuario, String contrasena, String correo, String telefono) {
		super(id, tipo, usuario, contrasena, correo, telefono);
	}
	
	public void evaluarPropuesta(int id_propuesta, boolean evaluacion, String motivo, ManejoSQL db) {
		//Variables
		int evaluacion_db;
		int id_evaluacion;
		
		evaluacion_db = evaluacion ? 1 : 0;
		id_evaluacion = db.insertarDatos("INSERT INTO Evaluaciones (aprobado, motivo) VALUES (" + evaluacion_db + ", '" + motivo + "')");
		
		db.insertarDatos("UPDATE Proyectos SET evaluacion_id = " + id_evaluacion + " WHERE id = " + id_propuesta);
		
		db.cerrarConexion();
		
	}
	
	public void publicarConvocatoria(int id_proyecto, int horas, ManejoSQL db) {
		
		db.insertarDatos("INSERT INTO Convocatorias (proyecto_id, horas) VALUES (" + id_proyecto + ", " + horas + ")");
		
		db.cerrarConexion();
		
	}
	
}
