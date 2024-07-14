package backend;

public class DSSU extends Usuario{
	
	//Constructor
	public DSSU(int id, int tipo, String usuario, String contrasena, String correo, String telefono) {
		super(id, tipo, usuario, contrasena, correo, telefono);
	}
	
	public void evaluarPropuesta(int id, boolean evaluacion, String motivo, ManejoSQL db) {
		//Variables
		int evaluacionDB;
		int idEvaluacion;
		
		evaluacionDB = evaluacion ? 1 : 0;
		idEvaluacion = db.insertarDatos("INSERT INTO Evaluaciones (aprobado, motivo) VALUES (" + evaluacionDB + ", " + motivo + ")");
		
		db.insertarDatos("UPDATE Proyectos SET evaluacion_id = " + idEvaluacion + " WHERE id = " + id);
		
	}
	
}
