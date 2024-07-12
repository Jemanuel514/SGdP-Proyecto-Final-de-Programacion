package frontend;

import java.awt.EventQueue;
import backend.DSSU;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import backend.ManejoSQL;

import javax.swing.JButton;

public class DSSUPublicarConvocatoria extends JFrame {

	private JTextField txtNombreProyecto;
	private JTextField textField_1;
	private JTextField txtLugar;
	private JTextField txtHoras;
	private JTextField txtRequisitos;
	private JTextField txtDetalles;
	private JPanel contenedor;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public DSSUPublicarConvocatoria(DSSU usuario, int id) {
		setSize(1024, 768);								//Dimensiones
		setResizable(false);
		setLocationRelativeTo(null);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		contenedor = new JPanel();								//Inicializar
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));		//Bordes
		contenedor.setLayout(null);								//Layout (absoluto)
		setContentPane(contenedor);	
		
		JLabel lblNewLabel = new JLabel("PUBLICAR CONVOCATORIA");
		lblNewLabel.setForeground(new Color(128, 128, 128));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNewLabel.setBounds(234, 42, 565, 71);
		contenedor.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del proyecto");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(45, 169, 196, 24);
		contenedor.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Horario");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(45, 264, 196, 24);
		contenedor.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Lugar de Ejecucion");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(45, 367, 196, 24);
		contenedor.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Horas otorgadas");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(45, 474, 196, 24);
		contenedor.add(lblNewLabel_1_1_1_1);
		
		txtNombreProyecto = new JTextField();
		txtNombreProyecto.setBounds(45, 204, 232, 42);
		contenedor.add(txtNombreProyecto);
		txtNombreProyecto.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(45, 299, 232, 42);
		contenedor.add(textField_1);
		
		txtLugar = new JTextField();
		txtLugar.setColumns(10);
		txtLugar.setBounds(45, 402, 232, 42);
		contenedor.add(txtLugar);
		
		txtHoras = new JTextField();
		txtHoras.setColumns(10);
		txtHoras.setBounds(45, 509, 232, 42);
		contenedor.add(txtHoras);
		
		JLabel lblNewLabel_1_2 = new JLabel("Requisitos de los estudiantes");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(444, 169, 279, 24);
		contenedor.add(lblNewLabel_1_2);
		
		txtRequisitos = new JTextField();
		txtRequisitos.setColumns(10);
		txtRequisitos.setBounds(444, 204, 279, 125);
		contenedor.add(txtRequisitos);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Detalles adicionales");
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(444, 367, 279, 24);
		contenedor.add(lblNewLabel_1_2_1);
		
		txtDetalles = new JTextField();
		txtDetalles.setColumns(10);
		txtDetalles.setBounds(444, 402, 279, 125);
		contenedor.add(txtDetalles);
		
		JButton btnNewButton = new JButton("Hacer convocatoria");
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btnNewButton.setBounds(742, 623, 241, 42);
		contenedor.add(btnNewButton);
		
		 JButton btnVolver = new JButton("Volver");
	  		btnVolver.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
	  		btnVolver.setBounds(30, 30, 199, 36);
	  		btnVolver.addActionListener(new ActionListener() {
	  			public void actionPerformed(ActionEvent e) {
	  				dispose();
					DSSUProyectosAprobados hacerConvocatoria = new DSSUProyectosAprobados(usuario);
					hacerConvocatoria.setVisible(true);
	  			}
	  		});
	  		contenedor.add(btnVolver);
		
		consultarProyecto(id);
	}
	
	public void consultarProyecto(int id) {
		ResultSet datos = null;
		
		try {
			//Consulta de datos
			datos = ManejoSQL.consultarDatos("SELECT titulo, resumen, lugar, perfil_estudiante from Proyectos WHERE id = " + id);
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
