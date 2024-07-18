package frontend;

import backend.DSSU;
import backend.ManejoSQL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class DSSUMenuPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public DSSUMenuPrincipal(DSSU usuario, ManejoSQL db) {	
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
		
		JLabel lbl_tipo_usuario = new JLabel("DSSU");
		lbl_tipo_usuario.setFont(ConstantesEstilo.texto);
		lbl_tipo_usuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_tipo_usuario.setBounds(733, 39, 267, 38);
		contenedor.add(lbl_tipo_usuario);
		
		//BOTONES
		JButton btn_evaluar_propuesta = new JButton("Evaluar Propuestas");
		btn_evaluar_propuesta.setFont(ConstantesEstilo.boton);
		btn_evaluar_propuesta.setBounds(302, 219, 406, 91);
		btn_evaluar_propuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DSSUPropuestasSinEvaluar propuestasSinEvaluar = new DSSUPropuestasSinEvaluar(usuario, db);
				propuestasSinEvaluar.setVisible(true);
			}
		});
		contenedor.add(btn_evaluar_propuesta);
		
		JButton btn_publicar_convocatoria = new JButton("Publicar Convocatoria");
		btn_publicar_convocatoria.setFont(ConstantesEstilo.boton);
		btn_publicar_convocatoria.setBounds(302, 341, 406, 91);
		btn_publicar_convocatoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DSSUProyectosAprobados proyectosAprobados = new DSSUProyectosAprobados(usuario, db);
				proyectosAprobados.setVisible(true);
			}
		});
		contenedor.add(btn_publicar_convocatoria);
		
		JButton btn_ver_convocatoria = new JButton("Ver Convocatorias");
		btn_ver_convocatoria.setFont(ConstantesEstilo.boton);
		btn_ver_convocatoria.setBounds(302, 463, 406, 91);
		contenedor.add(btn_ver_convocatoria);
		
		JButton btn_cerrar_sesion = new JButton("Cerrar Sesión");
		btn_cerrar_sesion.setFont(ConstantesEstilo.boton);
		btn_cerrar_sesion.setBounds(10, 683, 242, 38);
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
