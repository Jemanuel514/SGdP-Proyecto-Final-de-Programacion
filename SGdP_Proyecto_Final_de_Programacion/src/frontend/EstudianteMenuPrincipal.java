package frontend;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Estudiante;
import backend.ManejoSQL;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class EstudianteMenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public EstudianteMenuPrincipal(Estudiante usuario, ManejoSQL db) {
		
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
		etiqueta_SGdP.setBounds(142, 140, 726, 48);
		contenedor.add(etiqueta_SGdP);
		
		JLabel lbl_bienvenida = new JLabel("Bienvenido, " + usuario.getUsuario());
		lbl_bienvenida.setFont(ConstantesEstilo.texto);
		lbl_bienvenida.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_bienvenida.setBounds(683, 10, 317, 38);
		contenedor.add(lbl_bienvenida);
		
		JLabel lbl_tipo_usuario = new JLabel("ESTUDIANTE");
		lbl_tipo_usuario.setFont(ConstantesEstilo.texto);
		lbl_tipo_usuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_tipo_usuario.setBounds(733, 40, 267, 38);
		contenedor.add(lbl_tipo_usuario);
		
		JLabel lbl_facultad = new JLabel(usuario.getFacultad());
		lbl_facultad.setFont(ConstantesEstilo.texto);
		lbl_facultad.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_facultad.setBounds(733, 70, 267, 38);
		contenedor.add(lbl_facultad);
		
		JButton btn_inscribirse_proyecto = new JButton("Ver Convocatorias");
		btn_inscribirse_proyecto.setFont(ConstantesEstilo.boton);
		btn_inscribirse_proyecto.setBounds(302, 219, 406, 91);
		btn_inscribirse_proyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VerConvocatorias convocatorias = new VerConvocatorias(usuario, db);
				convocatorias.setVisible(true);
			}
		});
		contenedor.add(btn_inscribirse_proyecto);
		
		JButton btn_ver_inscripciones = new JButton("Ver Inscripciones");
		btn_ver_inscripciones.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btn_ver_inscripciones.setBounds(302, 354, 406, 91);
		btn_ver_inscripciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EstudianteVerInscripciones convocatorias = new EstudianteVerInscripciones(usuario, db);
				convocatorias.setVisible(true);
			}
		});
		contenedor.add(btn_ver_inscripciones);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setFont(ConstantesEstilo.boton);
		btnCerrarSesion.setBounds(10, 683, 242, 38);
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InicioSesion iniciarSesion = new InicioSesion();
				iniciarSesion.setVisible(true);
			}
		});
		contenedor.add(btnCerrarSesion);
	}
}
