package frontend;

import backend.ManejoSQL;
import backend.OrganismoReceptor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ORMenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public ORMenuPrincipal(OrganismoReceptor usuario, ManejoSQL db) {
		
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
		JLabel lbl_SGdP = new JLabel("SISTEMA DE GESTIÓN DE PROYECTOS");
		lbl_SGdP.setFont(ConstantesEstilo.titulo);
		lbl_SGdP.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SGdP.setBounds(142, 140, 726, 48);
		contenedor.add(lbl_SGdP);
		
		JLabel lbl_bienvenida = new JLabel("Bienvenido, " + usuario.getUsuario());
		lbl_bienvenida.setFont(ConstantesEstilo.texto);
		lbl_bienvenida.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_bienvenida.setBounds(683, 10, 317, 38);
		contenedor.add(lbl_bienvenida);
		
		JLabel lbl_tipo_usuario = new JLabel("ORGANISMO RECEPTOR");
		lbl_tipo_usuario.setFont(ConstantesEstilo.texto);
		lbl_tipo_usuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_tipo_usuario.setBounds(733, 39, 267, 38);
		contenedor.add(lbl_tipo_usuario);
		
		// Botones
		JButton btn_proponer_proyecto = new JButton("Proponer Proyecto");
		btn_proponer_proyecto.setFont(ConstantesEstilo.boton);
		btn_proponer_proyecto.setBounds(302, 219, 406, 91);
		btn_proponer_proyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ORProponerProyecto proponer_proyecto = new ORProponerProyecto(usuario, db);
				proponer_proyecto.setVisible(true);
			}
		});
		contenedor.add(btn_proponer_proyecto);
		
		JButton btn_ver_propuestas = new JButton("Ver Propuestas");
		btn_ver_propuestas.setFont(ConstantesEstilo.boton);
		btn_ver_propuestas.setBounds(302, 341, 406, 91);
		btn_ver_propuestas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ORVerPropuestas ver_propuestas = new ORVerPropuestas(usuario, db);
				ver_propuestas.setVisible(true);
			}
		});
		contenedor.add(btn_ver_propuestas);
		
		JButton btn_ver_convocatoria = new JButton("Ver Convocatorias");
		btn_ver_convocatoria.setFont(ConstantesEstilo.boton);
		btn_ver_convocatoria.setBounds(302, 463, 406, 91);
		btn_ver_convocatoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ORVerConvocatorias ver_convocatorias = new ORVerConvocatorias(usuario, db);
				ver_convocatorias.setVisible(true);
			}
		});
		contenedor.add(btn_ver_convocatoria);
		
		JButton btn_cerrar_sesion = new JButton("Cerrar Sesión");
		btn_cerrar_sesion.setFont(ConstantesEstilo.boton);
		btn_cerrar_sesion.setBounds(10, 651, 242, 38);
		btn_cerrar_sesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InicioSesion iniciar_sesion = new InicioSesion();
				iniciar_sesion.setVisible(true);
			}
		});
		contenedor.add(btn_cerrar_sesion);
		
	}
}
