package frontend;
import backend.ManejoSQL;
import backend.OrganismoReceptor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class ORMenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contenedor;

	public ORMenuPrincipal(OrganismoReceptor usuario, ManejoSQL db) {
		//JFRAME
		setSize(ConstantesEstilo.ventana);				//Dimensiones
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);					//Centrar en la pantalla
		
		//CONTENEDOR
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenedor.setLayout(null);
		setContentPane(contenedor);
		
		//ETIQUETAS
		JLabel etiquetaSGdP = new JLabel("SISTEMA DE GESTIÓN DE PROYECTOS");		//Inicializar y texto
		etiquetaSGdP.setFont(ConstantesEstilo.titulo);								//Fuente
		etiquetaSGdP.setHorizontalAlignment(SwingConstants.CENTER);					//Alineación
		etiquetaSGdP.setBounds(142, 140, 726, 48);									//Posición
		contenedor.add(etiquetaSGdP);
		
		JLabel lblBienvenida = new JLabel("Bienvenido, " + usuario.getUsuario());
		lblBienvenida.setFont(ConstantesEstilo.texto);
		lblBienvenida.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBienvenida.setBounds(683, 10, 317, 38);
		contenedor.add(lblBienvenida);
		
		JLabel lblTipoUsuario = new JLabel("ORGANISMO RECEPTOR");
		lblTipoUsuario.setFont(ConstantesEstilo.texto);
		lblTipoUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoUsuario.setBounds(733, 39, 267, 38);
		contenedor.add(lblTipoUsuario);
		
		//BOTONES
		JButton btnProponerProyecto = new JButton("Proponer proyecto");
		btnProponerProyecto.setFont(ConstantesEstilo.boton);
		btnProponerProyecto.setBounds(302, 219, 406, 91);
		btnProponerProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				//ORProponerProyecto proponerProyecto = new ORProponerProyecto(usuario, db);
				//proponerProyecto.setVisible(true);
			}
		});
		contenedor.add(btnProponerProyecto);
		
		JButton btnVerPropuestas = new JButton("Ver propuestas");
		btnVerPropuestas.setFont(ConstantesEstilo.boton);
		btnVerPropuestas.setBounds(302, 341, 406, 91);
		btnVerPropuestas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ORVerProyectos verProyectos = new ORVerProyectos(usuario, db);
				verProyectos.setVisible(true);
			}
		});
		contenedor.add(btnVerPropuestas);
		
		JButton btnVerConvocatoria = new JButton("Ver convocatorias");
		btnVerConvocatoria.setFont(ConstantesEstilo.boton);
		btnVerConvocatoria.setBounds(302, 463, 406, 91);
		btnVerConvocatoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ORVerConvocatorias verConvocatorias = new ORVerConvocatorias(usuario, db);
				verConvocatorias.setVisible(true);
			}
		});
		contenedor.add(btnVerConvocatoria);
		
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setFont(ConstantesEstilo.boton);
		btnCerrarSesion.setBounds(10, 651, 242, 38);
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
