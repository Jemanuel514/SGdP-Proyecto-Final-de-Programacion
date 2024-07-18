package frontend;

import backend.DSSU;
import backend.Estudiante;
import backend.ManejoSQL;
import backend.OrganismoReceptor;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.sql.SQLException;

public class InicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	
	// Variables de captura de datos
	private JTextField txt_usuario;
	private JPasswordField txt_contrasena;
	
	// Variable de acceso a la base de datos
	private ManejoSQL db = new ManejoSQL();
	
	// Inicialización de la ventana
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
		// JFrame
		setSize(ConstantesEstilo.ventana);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		// Contenedor
		JPanel contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(20, 20, 20, 20));
		contenedor.setLayout(null);
		setContentPane(contenedor);
		
		// Etiquetas
		JLabel etiqueta_SGdP = new JLabel("SISTEMA DE GESTIÓN DE PROYECTOS");
		etiqueta_SGdP.setFont(ConstantesEstilo.titulo);
		etiqueta_SGdP.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta_SGdP.setBounds(142, 215, 726, 48);
		contenedor.add(etiqueta_SGdP);
		
		JLabel etiqueta_usuario = new JLabel("Usuario");
		etiqueta_usuario.setFont(ConstantesEstilo.texto);
		etiqueta_usuario.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta_usuario.setBounds(349, 290, 312, 36);
		contenedor.add(etiqueta_usuario);
		
		JLabel lbl_contrasena = new JLabel("Contraseña");
		lbl_contrasena.setFont(ConstantesEstilo.texto);
		lbl_contrasena.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_contrasena.setBounds(349, 379, 312, 36);
		contenedor.add(lbl_contrasena);
		
		// Campos de texto
		txt_usuario = new JTextField();
		txt_usuario.setFont(ConstantesEstilo.texto);
		txt_usuario.setHorizontalAlignment(SwingConstants.CENTER);
		txt_usuario.setBounds(348, 336, 314, 36);
		contenedor.add(txt_usuario);
		
		txt_contrasena = new JPasswordField();
		txt_contrasena.setFont(ConstantesEstilo.texto);
		txt_contrasena.setHorizontalAlignment(SwingConstants.CENTER);
		txt_contrasena.setBounds(349, 425, 312, 36);
		contenedor.add(txt_contrasena);
		
		// Botones
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
		String usuario = txt_usuario.getText();
		char[] contrasena_array = txt_contrasena.getPassword();
		String contrasena = new String(contrasena_array);
				
		boolean encontrado = false;
		
		try {
			// Consulta de datos
			db.consultarDatos("SELECT * FROM Usuarios");
			
			//Búsqueda de credenciales
			while(db.datos.next()) {
				if(db.datos.getString("usuario").equals(usuario) && db.datos.getString("contrasena").equals(contrasena)) {
					encontrado = true;
					break;
				}
			}
			
			//Usuario no encontrado
			if(!encontrado) {
				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.", "", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			//Mensaje de bienvenida según el tipo de usuario (0: OR, 1: DSSU, 2: Estudiante)
			switch(db.datos.getInt("tipo")) {
			case 0:
				dispose();
				ORMenuPrincipal menu_or = new ORMenuPrincipal(new OrganismoReceptor(db.datos.getInt("id"), db.datos.getInt("tipo"), db.datos.getString("usuario"), db.datos.getString("contrasena"), db.datos.getString("correo"), db.datos.getString("telefono"), db.datos.getString("max_autoridad"), db.datos.getString("direccion")), db);
				menu_or.setVisible(true);
				break;
			case 1:
				dispose();
				DSSUMenuPrincipal menu_dssu = new DSSUMenuPrincipal(new DSSU(db.datos.getInt("id"), db.datos.getInt("tipo"), db.datos.getString("usuario"), db.datos.getString("contrasena"), db.datos.getString("correo"), db.datos.getString("telefono")), db);
				menu_dssu.setVisible(true);
				break;
			case 2:
				dispose();
				EstudianteMenuPrincipal menu_estudiante = new EstudianteMenuPrincipal(new Estudiante(db.datos.getInt("id"), db.datos.getInt("tipo"), db.datos.getString("usuario"), db.datos.getString("contrasena"), db.datos.getString("correo"), db.datos.getString("telefono"), db.datos.getString("facultad")), db);
				menu_estudiante.setVisible(true);
				break;
			default: break;
			}
			
		}
		
		catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
		}
		
		finally {
			db.cerrarConexion();
		}
			
	}
}
