package frontend;

import backend.DSSU;
import backend.ManejoSQL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.sql.SQLException;

public class DSSUEvaluarPropuesta extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lbl_titulo;
	private JLabel lbl_organismo_receptor;
	private JLabel lbl_tipo;
	
	private JTextArea txt_resumen;
	private JTextArea txt_objetivo;
	private JTextArea txt_beneficiarios;
	private JTextArea txt_objetivosODS;
	
	private JLabel lbl_lugar;
	private JLabel lbl_horario;
	
	private JLabel lbl_estudiantes;
	private JLabel lbl_facultad;
	private JTextArea txt_perfil_estudiante;
	
	private JTextArea txt_materiales;
	private JCheckBox check_transporte;
	private JCheckBox check_almuerzo;
	
	private JLabel lbl_encargado;
	private JLabel lbl_cargo;
	private JLabel lbl_cedula;
	private JLabel lbl_correo;
	private JLabel lbl_telefono;

	public DSSUEvaluarPropuesta(DSSU usuario, int id_propuesta, ManejoSQL db) {
		
		// JFrame
		setSize(ConstantesEstilo.ventana);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
    	
		// Contenedor
		JPanel contenedor_general = new JPanel();
		contenedor_general.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		//Contenedor scrolleable
		JScrollPane contenedor_scrolleable = new JScrollPane(contenedor_general);
		contenedor_scrolleable.setPreferredSize(ConstantesEstilo.ventana);
		setContentPane(contenedor_scrolleable);
		
		// General
		JLabel lbl_bienvenida = new JLabel("Bienvenido, " + usuario.getUsuario());
		lbl_bienvenida.setFont(ConstantesEstilo.texto);
		lbl_bienvenida.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lbl_tipo_usuario = new JLabel("DSSU");
		lbl_tipo_usuario.setFont(ConstantesEstilo.texto);
		lbl_tipo_usuario.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lbl_evaluar_propuesta = new JLabel("Evaluar Propuesta");
		lbl_evaluar_propuesta.setFont(ConstantesEstilo.titulo);
		lbl_evaluar_propuesta.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Información de propuesta
		// Título
		lbl_titulo = new JLabel("Título: ");
		lbl_titulo.setFont(ConstantesEstilo.texto);
		
		// Organismo receptor
		lbl_organismo_receptor = new JLabel("Organismo Receptor: ");
		lbl_organismo_receptor.setFont(ConstantesEstilo.texto);
		
		// Tipo de proyecto
		lbl_tipo = new JLabel("Tipo: ");
		lbl_tipo.setFont(ConstantesEstilo.texto);
		
		// Resumen
		JLabel lbl_resumen = new JLabel("Resumen: ");
		lbl_resumen.setFont(ConstantesEstilo.texto);
		
		txt_resumen = new JTextArea();
		txt_resumen.setEditable(false);
		txt_resumen.setLineWrap(true);
		txt_resumen.setFont(ConstantesEstilo.texto);
		
		JScrollPane contenedor_resumen = new JScrollPane(txt_resumen);
		
		// Objetivo
		JLabel lbl_objetivo = new JLabel("Objetivo: ");
		lbl_objetivo.setFont(ConstantesEstilo.texto);	
		
		txt_objetivo = new JTextArea();
		txt_objetivo.setEditable(false);
		txt_objetivo.setLineWrap(true);
		txt_objetivo.setFont(ConstantesEstilo.texto);
		
		JScrollPane contenedor_objetivo = new JScrollPane(txt_objetivo);
		
		// Beneficiarios
		JLabel lbl_beneficiarios = new JLabel("Beneficiarios: ");
		lbl_beneficiarios.setFont(ConstantesEstilo.texto);
		
		txt_beneficiarios = new JTextArea();
		txt_beneficiarios.setEditable(false);
		txt_beneficiarios.setLineWrap(true);
		txt_beneficiarios.setFont(ConstantesEstilo.texto);
		
		JScrollPane contenedor_beneficiarios = new JScrollPane(txt_beneficiarios);
		
		// Objetivos de desarrollo sostenible
		JLabel lbl_objetivosODS = new JLabel("Objetivos de desarrollo sostenible:");
		lbl_objetivosODS.setFont(ConstantesEstilo.texto);
		
		txt_objetivosODS = new JTextArea();
		txt_objetivosODS.setEditable(false);
		txt_objetivosODS.setLineWrap(true);
		txt_objetivosODS.setFont(ConstantesEstilo.texto);
		
		JScrollPane contenedor_objetivosODS = new JScrollPane(txt_objetivosODS);
		
		// Lugar
		lbl_lugar = new JLabel("Lugar: ");
		lbl_lugar.setFont(ConstantesEstilo.texto);
		
		// Horario	
		lbl_horario = new JLabel("Horario: ");
		lbl_horario.setFont(ConstantesEstilo.texto);
				
		// Estudiantes
		lbl_estudiantes = new JLabel("Cupos: ");
		lbl_estudiantes.setFont(ConstantesEstilo.texto);
		
		// Facultad
		lbl_facultad = new JLabel("Facultad: ");
		lbl_facultad.setFont(ConstantesEstilo.texto);
		
		// Perfil de estudiante
		JLabel lbl_perfil_estudiante = new JLabel("Perfil de estudiante:");
		lbl_perfil_estudiante.setFont(ConstantesEstilo.texto);
		
		txt_perfil_estudiante = new JTextArea();
		txt_perfil_estudiante.setEditable(false);
		txt_perfil_estudiante.setLineWrap(true);
		txt_perfil_estudiante.setFont(ConstantesEstilo.texto);
		
		JScrollPane contenedor_perfil_estudiante = new JScrollPane(txt_perfil_estudiante);
		
		// Materiales
		JLabel lbl_materiales = new JLabel("Materiales: ");
		lbl_materiales.setFont(ConstantesEstilo.texto);
		
		txt_materiales = new JTextArea();
		txt_materiales.setEditable(false);
		txt_materiales.setLineWrap(true);
		txt_materiales.setFont(ConstantesEstilo.texto);
		
		JScrollPane contenedor_materiales = new JScrollPane(txt_materiales);
		
		// Transporte
		JLabel lbl_transporte = new JLabel("Transporte ");
		lbl_transporte.setFont(ConstantesEstilo.texto);
		
		check_transporte = new JCheckBox();
		check_transporte.setEnabled(false);
		
		// Almuerzo
		JLabel lbl_almuerzo = new JLabel("Almuerzo ");
		lbl_almuerzo.setFont(ConstantesEstilo.texto);
		
		check_almuerzo = new JCheckBox();
		check_almuerzo.setEnabled(false);
		
		// Datos del encargado
		lbl_encargado = new JLabel("Encargado: ");
		lbl_encargado.setFont(ConstantesEstilo.texto);
		
		lbl_cargo = new JLabel("Cargo: ");
		lbl_cargo.setFont(ConstantesEstilo.texto);
		
		lbl_cedula = new JLabel("Cédula: ");
		lbl_cedula.setFont(ConstantesEstilo.texto);
		
		lbl_correo = new JLabel("Correo: ");
		lbl_correo.setFont(ConstantesEstilo.texto);
		
		lbl_telefono = new JLabel("Teléfono: ");
		lbl_telefono.setFont(ConstantesEstilo.texto);
		
		// Botones
        JButton btn_volver = new JButton("Volver");
  		btn_volver.setFont(ConstantesEstilo.boton);
  		btn_volver.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				dispose();
				DSSUPropuestasSinEvaluar propuestas_sin_evaluar = new DSSUPropuestasSinEvaluar(usuario, db);
				propuestas_sin_evaluar.setVisible(true);
  			}
  		});
  		
  		JButton btn_aprobar = new JButton("Aprobar");
  		btn_aprobar.setFont(ConstantesEstilo.boton);
  		btn_aprobar.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				usuario.evaluarPropuesta(id_propuesta, true, null, db);
  				JOptionPane.showMessageDialog(null, "Proyecto aprobado", "", JOptionPane.INFORMATION_MESSAGE);
  				
  				dispose();
				DSSUPropuestasSinEvaluar propuestasSinEvaluar = new DSSUPropuestasSinEvaluar(usuario, db);
				propuestasSinEvaluar.setVisible(true);
  			}
  		});
  		
  		JButton btn_rechazar = new JButton("Rechazar");
  		btn_rechazar.setFont(ConstantesEstilo.boton);
  		btn_rechazar.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				String motivo = JOptionPane.showInputDialog(null, "Motivo del rechazo:", "", JOptionPane.QUESTION_MESSAGE);
  				usuario.evaluarPropuesta(id_propuesta, false, motivo, db);
  				JOptionPane.showMessageDialog(null, "Proyecto rechazado", "", JOptionPane.INFORMATION_MESSAGE);
  				
  				dispose();
				DSSUPropuestasSinEvaluar propuestasSinEvaluar = new DSSUPropuestasSinEvaluar(usuario, db);
				propuestasSinEvaluar.setVisible(true);
  			}
  		});
		
  		consultarPropuesta(id_propuesta, db);
  		
  		GroupLayout layout = new GroupLayout(contenedor_general);
  		
		layout.setHorizontalGroup(layout.createParallelGroup()
				
				.addGroup(layout.createSequentialGroup()
						.addComponent(btn_volver, 150, 150, 150)
						.addGroup(layout.createParallelGroup()
								.addComponent(lbl_bienvenida, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lbl_tipo_usuario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				
				.addComponent(lbl_evaluar_propuesta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								
				.addComponent(lbl_titulo)
		        .addComponent(lbl_organismo_receptor)
		        .addComponent(lbl_tipo)
		        
		        .addGroup(layout.createSequentialGroup()
		                .addComponent(lbl_resumen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                .addGap(10)
		                .addComponent(lbl_objetivo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		        
		        .addGroup(layout.createSequentialGroup()
		                .addComponent(contenedor_resumen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                .addGap(10)
		                .addComponent(contenedor_objetivo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		        
		        .addGroup(layout.createSequentialGroup()
		                .addComponent(lbl_beneficiarios, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                .addGap(10)
		                .addComponent(lbl_objetivosODS, 475, 475, 475))
		        
		        .addGroup(layout.createSequentialGroup()
		                .addComponent(contenedor_beneficiarios, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                .addGap(10)
		                .addComponent(contenedor_objetivosODS, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		        
		        .addComponent(lbl_lugar)
		        .addComponent(lbl_horario)
		        
		        .addComponent(lbl_estudiantes)
		        .addComponent(lbl_facultad)
		        .addComponent(lbl_perfil_estudiante)
		        .addComponent(contenedor_perfil_estudiante, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		        
		        .addComponent(lbl_materiales)
		        .addComponent(contenedor_materiales, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		        
		        .addGroup(layout.createSequentialGroup()
		                .addComponent(lbl_transporte, 110, 110, 110)
		                .addComponent(check_transporte)
		                .addGap(360)
		                .addComponent(lbl_almuerzo, 100, 100, 100)
		                .addComponent(check_almuerzo))
		        
		        .addComponent(lbl_encargado)
		        .addComponent(lbl_cargo)
		        .addComponent(lbl_cedula)
		        .addComponent(lbl_correo)
		        .addComponent(lbl_telefono)
		        
		        .addGroup(layout.createSequentialGroup()
		        		.addGap(200)
		                .addComponent(btn_aprobar, 200, 200, 200)
		                .addGap(150)
		                .addComponent(btn_rechazar, 200, 200, 200)
		                .addGap(200))
		        
		);

		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup()
						.addComponent(btn_volver)
						
						.addGroup(layout.createSequentialGroup()
								.addComponent(lbl_bienvenida)
								.addComponent(lbl_tipo_usuario)))
				
		        .addComponent(lbl_evaluar_propuesta)
		        
		        .addComponent(lbl_titulo)
		        .addComponent(lbl_organismo_receptor)
		        .addComponent(lbl_tipo)
		        .addGap(20)
		        
		        .addGroup(layout.createParallelGroup()
		                .addComponent(lbl_resumen)
		                .addComponent(lbl_objetivo))
		        
		        .addGroup(layout.createParallelGroup()
		                .addComponent(contenedor_resumen, 200, 200, 200)
		                .addComponent(contenedor_objetivo, 200, 200, 200))
		        .addGap(10)
		        
		        .addGroup(layout.createParallelGroup()
		                .addComponent(lbl_beneficiarios)
		                .addComponent(lbl_objetivosODS))
		        
		        .addGroup(layout.createParallelGroup()
		                .addComponent(contenedor_beneficiarios, 200, 200, 200)
		                .addComponent(contenedor_objetivosODS, 200, 200, 200))
		        
		        .addGap(20)
		        .addComponent(lbl_lugar)
		        .addComponent(lbl_horario)
		        
		        .addGap(20)
		        .addComponent(lbl_estudiantes)
		        .addComponent(lbl_facultad)
		        .addComponent(lbl_perfil_estudiante)
		        .addComponent(contenedor_perfil_estudiante, 200, 200, 200)
		        
		        .addGap(20)
		        .addComponent(lbl_materiales)
		        .addComponent(contenedor_materiales, 200, 200, 200)
		        
		        .addGroup(layout.createParallelGroup()
		                .addComponent(lbl_transporte)
		                .addComponent(check_transporte)
		                .addComponent(lbl_almuerzo)
		                .addComponent(check_almuerzo))
		        
		        .addGap(20)
		        .addComponent(lbl_encargado)
		        .addComponent(lbl_cargo)
		        .addComponent(lbl_cedula)
		        .addComponent(lbl_correo)
		        .addComponent(lbl_telefono)
		        
		        .addGap(20)
		        .addGroup(layout.createParallelGroup()
		                .addComponent(btn_aprobar, 50, 50, 50)
		                .addComponent(btn_rechazar, 50, 50, 50))
		        
		);
		
		contenedor_general.setLayout(layout);
	}
	
	public void consultarPropuesta(int id_propuesta, ManejoSQL db) {
		
		try {
			// Consulta de datos
			db.consultarDatos("SELECT "
					+ "titulo, "
					+ "usuario, "
					+ "Proyectos.tipo, "
					+ "resumen, "
					+ "objetivo, "
					+ "beneficiarios, "
					+ "contribucionODS, "
					+ "lugar, "
					+ "dia, "
					+ "inicio, "
					+ "final, "
					+ "estudiantes, "
					+ "facultades, "
					+ "perfil_estudiante, "
					+ "materiales, "
					+ "transporte, "
					+ "almuerzo, "
					+ "nombre, "
					+ "cargo, "
					+ "cedula, "
					+ "Encargados.correo,"
					+ "Encargados.telefono "
					+ "FROM Proyectos "
					+ "INNER JOIN Usuarios ON or_id = Usuarios.id "
					+ "INNER JOIN Horarios ON proyecto_id = Proyectos.id "
					+ "INNER JOIN Encargados ON encargado_id = Encargados.id "
					+ "WHERE Proyectos.id = " + id_propuesta);
			
			lbl_titulo.setText("Título: " + db.datos.getString("titulo"));
			lbl_organismo_receptor.setText("Organismo Receptor: " + db.datos.getString("usuario"));
			lbl_tipo.setText("Tipo: " + db.datos.getString("tipo"));
			txt_resumen.setText(db.datos.getString("resumen"));
			txt_objetivo.setText(db.datos.getString("objetivo"));
			txt_beneficiarios.setText(db.datos.getString("beneficiarios"));
			txt_objetivosODS.setText(db.datos.getString("contribucionODS"));
			lbl_lugar.setText("Lugar: " + db.datos.getString("lugar"));
			lbl_horario.setText("Horario: " + db.datos.getString("dia") + " [" + db.datos.getString("inicio") + " - " + db.datos.getString("final") + "]");
			lbl_estudiantes.setText("Cupos: " + Integer.toString(db.datos.getInt("estudiantes")));
			lbl_facultad.setText("Facultad: " + db.datos.getString("facultades"));
			txt_perfil_estudiante.setText(db.datos.getString("perfil_estudiante"));
			txt_materiales.setText(db.datos.getString("materiales"));
			check_transporte.setSelected(db.datos.getInt("transporte") == 1 ? true : false);
			check_almuerzo.setSelected(db.datos.getInt("almuerzo") == 1 ? true : false);
			lbl_encargado.setText("Encargado: " + db.datos.getString("nombre"));
			lbl_cargo.setText("Cargo: " + db.datos.getString("cargo"));
			lbl_cedula.setText("Cédula: " + db.datos.getString("cedula"));
			lbl_correo.setText("Correo: " + db.datos.getString("correo"));
			lbl_telefono.setText("Teléfono: " + db.datos.getString("telefono"));

		}
		
		catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
		}
		
		finally {
			db.cerrarConexion();
		}
	}
}
