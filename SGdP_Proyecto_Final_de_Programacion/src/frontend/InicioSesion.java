package frontend;
import backend.ManejoSQL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class InicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	
	//Elementos dinámicos
	private JPanel contenedor;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	
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
		setResizable(false);
		//Configurar el Jframe
		setTitle("Inicio de Sesión");					//Título
		setSize(1024, 768);								//Dimensiones
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);					//Centrar en la pantalla
		
		
		//Configurar el contenedor
		contenedor = new JPanel();								//Inicializar
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));		//Bordes
		contenedor.setLayout(null);								//Layout (absoluto)
		setContentPane(contenedor);								//Establecer en la ventana
		
		//CONFIGURACIÓN DE ETIQUETAS
		JLabel etiquetaSGdP = new JLabel("SISTEMA DE GESTIÓN DE PROYECTOS");		//Inicializar y texto
		etiquetaSGdP.setFont(new Font("Artifakt Element", Font.BOLD, 40));			//Fuente
		etiquetaSGdP.setForeground(new Color(127, 127, 127));						//Color
		etiquetaSGdP.setHorizontalAlignment(SwingConstants.CENTER);					//Alinear al centro
		etiquetaSGdP.setBounds(142, 227, 726, 36);									//Posición
		contenedor.add(etiquetaSGdP);
		
		JLabel etiquetaUsuario = new JLabel("Usuario");
		etiquetaUsuario.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		etiquetaUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaUsuario.setBounds(349, 290, 312, 36);
		contenedor.add(etiquetaUsuario);
		
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		lblContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasena.setBounds(349, 379, 312, 36);
		contenedor.add(lblContrasena);
		
		//CONFIGURACIÓN DE CAMPOS DE TEXTO
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(348, 336, 314, 36);
		contenedor.add(txtUsuario);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		txtContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		txtContrasena.setBounds(349, 425, 312, 36);
		contenedor.add(txtContrasena);
		
		//CONFIGURACIÓN DE BOTONES
		JButton btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
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
		
		ResultSet datos = null;
		
		boolean encontrado = false;
		
		try {
			//Consulta de datos
			datos = ManejoSQL.consultarDatos("SELECT usuario, contrasena, tipo FROM Usuarios");
			
			//Búsqueda de credenciales
			while(datos.next()) {
				if(datos.getString("usuario").equals(usuario) && datos.getString("contrasena").equals(contrasena)) {
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
			switch(datos.getInt("tipo")) {
			case 0:
				System.out.print("Bienvenido Organismo Receptor: ");
				break;
			case 1:
				System.out.print("Bienvenido DSSU: ");
				break;
			case 2:
				System.out.print("Bienvenido Estudiante: ");
				break;
			default:
				System.out.print("Usuario no reconocido.");
				break;
			}
			System.out.println(datos.getString("usuario"));
		}
		
		catch(SQLException e){
			System.out.println("Error al consultar la base de datos. " + e.getMessage());
		}
			
	}
}
