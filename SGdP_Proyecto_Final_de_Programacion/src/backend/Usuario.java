package backend;

abstract class Usuario {
	//Atributos
	private int id;
	private int tipo;
	private String usuario;
	private String contrasena;
	private String correo;
	private String telefono;
	
	//Constructor
	public Usuario(int id, int tipo, String usuario, String contrasena, String correo, String telefono) {
		this.id = id;
		this.tipo = tipo;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.correo = correo;
		this.telefono = telefono;
	}
	
	public int getId() {return id;}
	public int getTipo() {return tipo;}
	public String getUsuario() {return usuario;}
	public String getContrasena() {return contrasena;}
	public String getCorreo() {return correo;}
	public String getTelefono() {return telefono;}
}
