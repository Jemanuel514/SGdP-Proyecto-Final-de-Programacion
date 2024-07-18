package backend;

public class Estudiante extends Usuario{
	//Atributos
	private String facultad;
	
	//Constructor
	public Estudiante(int id, int tipo, String usuario, String contrasena, String correo, String telefono, String facultad) {
		super(id, tipo, usuario, contrasena, correo, telefono);
		this.facultad = facultad;
	}
	
	public String getFacultad() {return facultad;}
	
	public void inscribirseConvocatoria(int id_estudiante, int id_convocatoria, ManejoSQL db) {
		
		db.insertarDatos("INSERT INTO Inscripciones (estudiante_id, convocatoria_id) VALUES (" + id_estudiante + ", " + id_convocatoria + ")");
		
		db.cerrarConexion();
		
	}
	
}
