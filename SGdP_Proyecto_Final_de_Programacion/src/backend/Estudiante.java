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
	
}
