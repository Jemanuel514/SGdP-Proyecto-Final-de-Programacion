package backend;

public class OrganismoReceptor extends Usuario{
	//Atributos
	private String maxima_autoridad;
	private String direccion;
	
	//Constructor
	public OrganismoReceptor(int id, int tipo, String usuario, String contrasena, String correo, String telefono, String maxima_autoridad, String direccion) {
		super(id, tipo, usuario, contrasena, correo, telefono);
		this.maxima_autoridad = maxima_autoridad;
		this.direccion = direccion;
	}
	
	public String getMaximaAutoridad() {return maxima_autoridad;}
	public String getDireccion() {return direccion;}
	
	public void proponerProyecto(	int or_id, String titulo, String lugar, String objetivo, String resumen, String beneficiarios, String contribucionODS, String materiales, String tipo,
									String nombre_encargado, String cedula_encargado, String cargo_encargado, String correo_encargado, String telefono_encargado,
									int cantidad_estudiantes, String facultad, String perfil_estudiantil, int transporte, int almuerzo,
									String dia, String hora_inicio, String hora_final,
									ManejoSQL db) {
		
		int id_encargado;
		int id_proyecto;
		
		// Agregar el encargado a la base de datos
		id_encargado = db.insertarDatos("INSERT INTO Encargados "
				+ "(nombre, cedula, cargo, correo, telefono) VALUES "
				+ "('" + nombre_encargado + "', '" + cedula_encargado + "', '" + cargo_encargado + "', '" + correo_encargado + "', '" + telefono_encargado + "')");
		
		// Agregar el proyecto a la base de datos
		id_proyecto = db.insertarDatos("INSERT INTO Proyectos "
				+ "(or_id, titulo, lugar, objetivo, resumen, beneficiarios, contribucionODS, materiales, tipo, "
				+ "encargado_id, "
				+ "estudiantes, facultades, perfil_estudiante, transporte, almuerzo) VALUES "
				+ "('" + or_id + "', '" + titulo + "', '" + lugar + "', '" + objetivo + "', '" + resumen + "', '" + beneficiarios + "', '" + contribucionODS + "', '" + materiales + "', '" + tipo + "', '"
				+ id_encargado + "', '"
				+ cantidad_estudiantes + "', '" + facultad + "', '" + perfil_estudiantil + "', '" + transporte + "', '" + almuerzo + "')");
		
		// Agregar el horario a la base de datos
		db.insertarDatos("INSERT INTO Horarios (dia, inicio, final, proyecto_id) VALUES ('" + dia + "', '" + hora_inicio + "', '" + hora_final + "', '" + id_proyecto + "')");
		
		db.cerrarConexion();
		
	}
	
}
