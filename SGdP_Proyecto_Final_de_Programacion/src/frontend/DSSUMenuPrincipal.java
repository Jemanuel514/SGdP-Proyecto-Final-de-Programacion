package frontend;
import backend.DSSU;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class DSSUMenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contenedor;

	public DSSUMenuPrincipal(DSSU usuario) {
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
		lblBienvenida.setBounds(822, 10, 178, 38);
		contenedor.add(lblBienvenida);
		
		JLabel lblTipoUsuario = new JLabel("DSSU");
		lblTipoUsuario.setFont(ConstantesEstilo.texto);
		lblTipoUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoUsuario.setBounds(822, 39, 178, 38);
		contenedor.add(lblTipoUsuario);
		
		//BOTONES
		JButton btnEvaluarPropuesta = new JButton("Evaluar Propuestas");
		btnEvaluarPropuesta.setFont(ConstantesEstilo.boton);
		btnEvaluarPropuesta.setBounds(302, 219, 406, 91);
		btnEvaluarPropuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DSSUPropuestasSinEvaluar propuestasSinEvaluar = new DSSUPropuestasSinEvaluar(usuario);
				propuestasSinEvaluar.setVisible(true);
			}
		});
		contenedor.add(btnEvaluarPropuesta);
		
		JButton btnPublicarConvocatoria = new JButton("Publicar Convocatoria");
		btnPublicarConvocatoria.setFont(ConstantesEstilo.boton);
		btnPublicarConvocatoria.setBounds(302, 341, 406, 91);
		btnPublicarConvocatoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DSSUProyectosAprobados proyectosAprobados = new DSSUProyectosAprobados(usuario);
				proyectosAprobados.setVisible(true);
			}
		});
		contenedor.add(btnPublicarConvocatoria);
		
		JButton btnVerConvocatoria = new JButton("Ver Convocatorias");
		btnVerConvocatoria.setFont(ConstantesEstilo.boton);
		btnVerConvocatoria.setBounds(302, 463, 406, 91);
		contenedor.add(btnVerConvocatoria);
		
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
