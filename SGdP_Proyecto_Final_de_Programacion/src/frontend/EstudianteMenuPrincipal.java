package frontend;

import java.awt.EventQueue;

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
	private JPanel contentPane;

	
	public EstudianteMenuPrincipal(Estudiante usuario, ManejoSQL db) {
		setTitle("Menú Estudiante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 749);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		setSize(1024, 768);								
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JLabel lblBienvenida = new JLabel("Bienvenido, " + usuario.getUsuario());
		lblBienvenida.setFont(ConstantesEstilo.texto);
		lblBienvenida.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBienvenida.setBounds(822, 10, 178, 38);
		contentPane.add(lblBienvenida);
		
		JLabel lblTipoUsuario = new JLabel("Estudiante");
		lblTipoUsuario.setFont(ConstantesEstilo.texto);
		lblTipoUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoUsuario.setBounds(822, 39, 178, 38);
		contentPane.add(lblTipoUsuario);
		
		JLabel lblNewLabel_1 = new JLabel("SISTEMA DE GESTIÓN DE PROYECTOS");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Artifakt Element", Font.BOLD, 40));
		lblNewLabel_1.setBounds(142, 140, 726, 48);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Inscribir En  Proyecto");
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btnNewButton_1.setBounds(302, 219, 406, 91);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EstudianteInscribirse convocatorias = new EstudianteInscribirse(usuario);
				convocatorias.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_1);
		
		
		JButton btnNewButton_1_1 = new JButton("Ver Perfil");
		btnNewButton_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btnNewButton_1_1.setBounds(302, 495, 406, 91);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Ver Inscripciones");
		btnNewButton_1_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btnNewButton_1_2.setBounds(302, 354, 406, 91);
		contentPane.add(btnNewButton_1_2);
		
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
		contentPane.add(btnCerrarSesion);
		
		
	}
}
