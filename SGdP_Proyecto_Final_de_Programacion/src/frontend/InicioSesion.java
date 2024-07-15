package frontend;

import backend.ManejoSQL;
import backend.OrganismoReceptor;
import backend.DSSU;
import backend.Estudiante;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contenedor;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	
	private ManejoSQL db = new ManejoSQL();
	
	//Inicialización de la ventana
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion frame = new InicioSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InicioSesion() {
		//JFRAME
		setSize(ConstantesEstilo.ventana);					//Dimensiones
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);						//Centrar en la pantalla
		
		//CONTENEDOR
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenedor.setLayout(null);
		setContentPane(contenedor);
		
		//ETIQUETAS
		JLabel etiquetaSGdP = new JLabel("SISTEMA DE GESTIÓN DE PROYECTOS");		//Inicializar y texto
		etiquetaSGdP.setFont(ConstantesEstilo.titulo);								//Fuente
		etiquetaSGdP.setHorizontalAlignment(SwingConstants.CENTER);					//Alineación
		etiquetaSGdP.setBounds(142, 215, 726, 48);									//Posición
		contenedor.add(etiquetaSGdP);
		
		JLabel etiquetaUsuario = new JLabel("Usuario");
		etiquetaUsuario.setFont(ConstantesEstilo.texto);
		etiquetaUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaUsuario.setBounds(349, 290, 312, 36);
		contenedor.add(etiquetaUsuario);
		
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(ConstantesEstilo.texto);
		lblContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasena.setBounds(349, 379, 312, 36);
		contenedor.add(lblContrasena);
		
		//CAMPOS DE TEXTO
		txtUsuario = new JTextField();
		txtUsuario.setFont(ConstantesEstilo.texto);
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(348, 336, 314, 36);
		contenedor.add(txtUsuario);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setFont(ConstantesEstilo.texto);
		txtContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		txtContrasena.setBounds(349, 425, 312, 36);
		contenedor.add(txtContrasena);
		
		//BOTONES
		JButton btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setFont(ConstantesEstilo.boton);
		btnIniciarSesion.setBounds(405, 501, 199, 36);
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarSesion();
			}
		});
		contenedor.add(btnIniciarSesion);
		
	}
	
	public void iniciarSesion() {
		//Variables
		String usuario = txtUsuario.getText();
		char[] contrasenaArray = txtContrasena.getPassword();
		String contrasena = new String(contrasenaArray);
				
		boolean encontrado = false;
		
		try {
			//Consulta de datos
			db.consultarDatos("SELECT * FROM Usuarios");
			
			//Búsqueda de credenciales
			while(db.datos.next()) {
				if(db.datos.getString("usuario").equals(usuario) && db.datos.getString("contrasena").equals(contrasena)) {
					System.out.println("Sesión iniciada.");
					encontrado = true;
					break;
				}
			}
			
			//Usuario no encontrado
			if(!encontrado) {
				System.out.println("Usuario o contraseña incorrectos.");
				return;
			}
			
			//Mensaje de bienvenida según el tipo de usuario (0: OR, 1: DSSU, 2: Estudiante)
			switch(db.datos.getInt("tipo")) {
			case 0:
				System.out.print("Bienvenido Organismo Receptor: ");
				dispose();
				ORMenuPrincipal menuOR = new ORMenuPrincipal(new OrganismoReceptor(db.datos.getInt("id"), db.datos.getInt("tipo"), db.datos.getString("usuario"), db.datos.getString("contrasena"), db.datos.getString("correo"), db.datos.getString("telefono"), db.datos.getString("max_autoridad"), db.datos.getString("direccion")), db);
				menuOR.setVisible(true);
				break;
			case 1:
				dispose();
				DSSUMenuPrincipal menuDSSU = new DSSUMenuPrincipal(new DSSU(db.datos.getInt("id"), db.datos.getInt("tipo"), db.datos.getString("usuario"), db.datos.getString("contrasena"), db.datos.getString("correo"), db.datos.getString("telefono")), db);
				menuDSSU.setVisible(true);
				break;
			case 2:
				dispose();
				MenuPrincipalE menuEstudiante = new MenuPrincipalE(new Estudiante(db.datos.getInt("id"), db.datos.getInt("tipo"), db.datos.getString("usuario"), db.datos.getString("contrasena"), db.datos.getString("correo"), db.datos.getString("telefono"), db.datos.getString("facultad")), db);
				menuEstudiante.setVisible(true);
				break;
			default:
				System.out.print("Usuario no reconocido.");
				break;
			}
			System.out.println(db.datos.getString("usuario"));
		}
		
		catch(SQLException e){
			System.out.println("Error al consultar la base de datos. " + e.getMessage());
		}
		
		finally {
			db.cerrarConexion();
		}
			
	}
}
