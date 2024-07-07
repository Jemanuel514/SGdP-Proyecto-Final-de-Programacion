package frontend;
import backend.DSSU;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class MenuPrincipalDSSU extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contenedor;

	public MenuPrincipalDSSU(DSSU usuario) {
		//Configurar el Jframe
		setTitle("Menú DSSU");							//Título
		setSize(1024, 768);								//Dimensiones
		setResizable(false);
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
		etiquetaSGdP.setBounds(142, 140, 726, 48);									//Posición
		contenedor.add(etiquetaSGdP);
		
		JLabel lblBienvenida = new JLabel("Bienvenido, " + usuario.getUsuario());
		lblBienvenida.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		lblBienvenida.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBienvenida.setBounds(822, 10, 178, 38);
		contenedor.add(lblBienvenida);
		
		JLabel lblTipoUsuario = new JLabel("DSSU");
		lblTipoUsuario.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		lblTipoUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoUsuario.setBounds(822, 39, 178, 38);
		contenedor.add(lblTipoUsuario);
		
		//CONFIGURACIÓN DE BOTONES
		JButton btnEvaluarPropuesta = new JButton("Evaluar Propuestas");
		btnEvaluarPropuesta.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btnEvaluarPropuesta.setBounds(302, 219, 406, 91);
		btnEvaluarPropuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EvaluarPropuesta evaluarPropuesta = new EvaluarPropuesta(usuario);
				evaluarPropuesta.setVisible(true);
			}
		});
		contenedor.add(btnEvaluarPropuesta);
		
		JButton btnPublicarConvocatoria = new JButton("Publicar Convocatoria");
		btnPublicarConvocatoria.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btnPublicarConvocatoria.setBounds(302, 341, 406, 91);
		btnPublicarConvocatoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HacerConvocatoria hacerConvocatoria = new HacerConvocatoria(usuario);
				hacerConvocatoria.setVisible(true);
			}
		});
		contenedor.add(btnPublicarConvocatoria);
		
		JButton btnVerConvocatoria = new JButton("Ver Convocatorias");
		btnVerConvocatoria.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btnVerConvocatoria.setBounds(302, 463, 406, 91);
		contenedor.add(btnVerConvocatoria);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
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
