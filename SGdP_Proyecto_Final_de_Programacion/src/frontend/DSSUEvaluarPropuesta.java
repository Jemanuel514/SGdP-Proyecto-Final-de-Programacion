package frontend;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import backend.DSSU;
import backend.ManejoSQL;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;

public class DSSUEvaluarPropuesta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contenedorGeneral;
	private JScrollPane contenedorScrolleable;
	private JLabel lblTitulo;
	private JLabel lblOrganismoReceptor;
	private JLabel lblTipo;
	private JTextField txtResumen;
	private JScrollPane contenedorResumen;
	private JTextField txtObjetivo;
	private JScrollPane contenedorObjetivo;
	

	public DSSUEvaluarPropuesta(DSSU usuario, int id) {
		//JFRAME
		setSize(ConstantesEstilo.ventana);				//Dimensiones
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);					//Centrar en la pantalla
		
		//CONTENEDOR DE CONTENIDO
		contenedorGeneral = new JPanel();
		contenedorGeneral.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenedorGeneral.setLayout(null);
		
		//CONTENEDOR SCROLLEABLE
		contenedorScrolleable = new JScrollPane(contenedorGeneral);
		contenedorScrolleable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contenedorScrolleable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contenedorScrolleable.setPreferredSize(ConstantesEstilo.ventana);
		setContentPane(contenedorScrolleable);
		
		//ETIQUETAS
		JLabel lblBienvenida = new JLabel("Bienvenido, " + usuario.getUsuario());	//Inicializar y texto
		lblBienvenida.setFont(ConstantesEstilo.texto);								//Fuente
		lblBienvenida.setHorizontalAlignment(SwingConstants.RIGHT);					//Alineación
		lblBienvenida.setBounds(822, 10, 178, 38);									//Posición
		contenedorGeneral.add(lblBienvenida);
		
		JLabel lblTipoUsuario = new JLabel("DSSU");
		lblTipoUsuario.setFont(ConstantesEstilo.texto);
		lblTipoUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoUsuario.setBounds(822, 39, 178, 38);
		contenedorGeneral.add(lblTipoUsuario);
		
		JLabel lblEvaluarPropuesta = new JLabel("Evaluar Propuesta");
		lblEvaluarPropuesta.setFont(ConstantesEstilo.titulo);
		lblEvaluarPropuesta.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvaluarPropuesta.setBounds(256, 100, 497, 56);
		contenedorGeneral.add(lblEvaluarPropuesta);
		
		//Información de propuesta
		//Título
		lblTitulo = new JLabel("Título: ");
		lblTitulo.setFont(ConstantesEstilo.texto);
		lblTitulo.setBounds(30, 176, 442, 38);
		contenedorGeneral.add(lblTitulo);
		
		//Organismo receptor
		lblOrganismoReceptor = new JLabel("Organismo Receptor: ");
		lblOrganismoReceptor.setFont(ConstantesEstilo.texto);
		lblOrganismoReceptor.setBounds(30, 216, 442, 38);
		contenedorGeneral.add(lblOrganismoReceptor);
		
		//Tipo de proyecto
		lblTipo = new JLabel("Tipo: ");
		lblTipo.setFont(ConstantesEstilo.texto);
		lblTipo.setBounds(30, 256, 442, 38);
		contenedorGeneral.add(lblTipo);
		
		//Resumen
		JLabel lblResumen = new JLabel("Resumen: ");
		lblResumen.setFont(ConstantesEstilo.texto);
		lblResumen.setBounds(30, 296, 442, 38);
		contenedorGeneral.add(lblResumen);
		
		contenedorResumen = new JScrollPane();
		contenedorResumen.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contenedorResumen.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contenedorResumen.setBounds(30, 336, 442, 200);
		contenedorGeneral.add(contenedorResumen);
		
		txtResumen = new JTextField();
		txtResumen.setFont(ConstantesEstilo.texto);
		txtResumen.setEditable(false);
		txtResumen.setColumns(10);
		txtResumen.setBounds(30, 336, 442, 200);
		contenedorResumen.add(txtResumen);
		
		//Objetivo
		JLabel lblObjetivo = new JLabel("Objetivo: ");
		lblObjetivo.setFont(ConstantesEstilo.texto);
		lblObjetivo.setBounds(532, 296, 442, 38);
		contenedorGeneral.add(lblObjetivo);		
		
		contenedorObjetivo = new JScrollPane();
		contenedorObjetivo.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contenedorObjetivo.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contenedorObjetivo.setBounds(532, 336, 442, 200);
		contenedorGeneral.add(contenedorObjetivo);
		
		txtObjetivo = new JTextField();
		txtObjetivo.setFont(ConstantesEstilo.texto);
		txtObjetivo.setEditable(false);
		txtObjetivo.setColumns(10);
		txtObjetivo.setBounds(532, 336, 442, 200);
		contenedorResumen.add(txtObjetivo);
		
		
		
		consultarPropuesta(id);
	}
	
	public void consultarPropuesta(int id) {
		ResultSet datos = null;
		
		try {
			//Consulta de datos
			datos = ManejoSQL.consultarDatos("SELECT * from Proyectos WHERE id = " + id);
			txtLugar.setText(datos.getString("lugar"));
			txtNombreProyecto.setText(datos.getString("titulo"));
			txtRequisitos.setText(datos.getString("perfil_estudiante"));
			txtDetalles.setText(datos.getString("resumen"));
			}
		
		catch(SQLException e){
			System.out.println("Error al consultar la base de datos. " + e.getMessage());
		}
	}
}
