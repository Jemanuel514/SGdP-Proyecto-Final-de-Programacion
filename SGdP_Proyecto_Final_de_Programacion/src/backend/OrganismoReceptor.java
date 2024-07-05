package backend;

public class OrganismoReceptor extends Usuario{
	//Atributos
	private String maximaAutoridad;
	private String direccion;
	
	//Constructor
	public OrganismoReceptor(int id, int tipo, String usuario, String contrasena, String correo, String telefono, String maximaAutoridad, String direccion) {
		super(id, tipo, usuario, contrasena, correo, telefono);
		this.maximaAutoridad = maximaAutoridad;
		this.direccion = direccion;
	}
	
	public String getMaximaAutoridad() {return maximaAutoridad;}
	public String getDireccion() {return direccion;}
	
}
