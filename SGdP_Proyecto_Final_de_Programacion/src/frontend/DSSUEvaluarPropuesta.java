package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import backend.DSSU;
import backend.ManejoSQL;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class DSSUEvaluarPropuesta extends JFrame {
	
	private ManejoSQL db;
	
	private static final long serialVersionUID = 1L;
	private JLabel lblTitulo;
	private JLabel lblOrganismoReceptor;
	private JLabel lblTipo;
	
	private JTextArea txtResumen;
	private JTextArea txtObjetivo;
	private JTextArea txtBeneficiarios;
	private JTextArea txtObjetivosODS;
	
	private JLabel lblLugar;
	private JTextArea txtHorario;
	
	private JLabel lblEstudiantes;
	private JLabel lblFacultad;
	private JTextArea txtPerfilEstudiante;
	
	private JTextArea txtMateriales;
	private JCheckBox checkTransporte;
	private JCheckBox checkAlmuerzo;
	
	private JLabel lblEncargado;
	private JLabel lblCargo;
	private JLabel lblCedula;
	private JLabel lblCorreo;
	private JLabel lblTelefono;

	public DSSUEvaluarPropuesta(DSSU usuario, int id, ManejoSQL db) {
		
		this.db = db;
		
		//JFRAME
		setSize(ConstantesEstilo.ventana);				//Dimensiones
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);					//Centrar en la pantalla
		
		//CONTENEDOR DE CONTENIDO
		JPanel contenedorGeneral = new JPanel();
		contenedorGeneral.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contenedorGeneral.setLayout(null);
		
		//CONTENEDOR SCROLLEABLE
		JScrollPane contenedorScrolleable = new JScrollPane(contenedorGeneral);
		contenedorScrolleable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contenedorScrolleable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contenedorScrolleable.setPreferredSize(ConstantesEstilo.ventana);
		setContentPane(contenedorScrolleable);
		
		//GROUP LAYOUT
		GroupLayout layout = new GroupLayout(contenedorGeneral);
		contenedorGeneral.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		JLabel lblBienvenida = new JLabel("Bienvenido, " + usuario.getUsuario());	//Inicializar y texto
		lblBienvenida.setFont(ConstantesEstilo.texto);								//Fuente
		lblBienvenida.setHorizontalAlignment(SwingConstants.RIGHT);					//Alineación
		
		JLabel lblTipoUsuario = new JLabel("DSSU");
		lblTipoUsuario.setFont(ConstantesEstilo.texto);
		lblTipoUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblEvaluarPropuesta = new JLabel("Evaluar Propuesta");
		lblEvaluarPropuesta.setFont(ConstantesEstilo.titulo);
		lblEvaluarPropuesta.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Información de propuesta
		//Título
		lblTitulo = new JLabel("Título: ");
		lblTitulo.setFont(ConstantesEstilo.texto);
		
		//Organismo receptor
		lblOrganismoReceptor = new JLabel("Organismo Receptor: ");
		lblOrganismoReceptor.setFont(ConstantesEstilo.texto);
		
		//Tipo de proyecto
		lblTipo = new JLabel("Tipo: ");
		lblTipo.setFont(ConstantesEstilo.texto);
		
		//Resumen
		JLabel lblResumen = new JLabel("Resumen: ");
		lblResumen.setFont(ConstantesEstilo.texto);
		
		txtResumen = new JTextArea();
		txtResumen.setEditable(false);
		txtResumen.setWrapStyleWord(true);
		txtResumen.setLineWrap(true);
		txtResumen.setFont(ConstantesEstilo.texto);
		
		JScrollPane contenedorResumen = new JScrollPane(txtResumen);
		contenedorResumen.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contenedorResumen.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		//Objetivo
		JLabel lblObjetivo = new JLabel("Objetivo: ");
		lblObjetivo.setFont(ConstantesEstilo.texto);	
		
		txtObjetivo = new JTextArea();
		txtObjetivo.setEditable(false);
		txtObjetivo.setWrapStyleWord(true);
		txtObjetivo.setLineWrap(true);
		txtObjetivo.setFont(ConstantesEstilo.texto);
		
		JScrollPane contenedorObjetivo = new JScrollPane(txtObjetivo);
		contenedorObjetivo.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contenedorObjetivo.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		//Beneficiarios
		JLabel lblBeneficiarios = new JLabel("Beneficiarios: ");
		lblBeneficiarios.setFont(ConstantesEstilo.texto);
		
		txtBeneficiarios = new JTextArea();
		txtBeneficiarios.setEditable(false);
		txtBeneficiarios.setWrapStyleWord(true);
		txtBeneficiarios.setLineWrap(true);
		txtBeneficiarios.setFont(ConstantesEstilo.texto);
		
		JScrollPane contenedorBeneficiarios = new JScrollPane(txtBeneficiarios);
		contenedorBeneficiarios.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contenedorBeneficiarios.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		//Objetivos de desarrollo sostenible
		JLabel lblObjetivosODS = new JLabel("Objetivos de desarrollo sostenible:");
		lblObjetivosODS.setFont(ConstantesEstilo.texto);
		
		txtObjetivosODS = new JTextArea();
		txtObjetivosODS.setEditable(false);
		txtObjetivosODS.setWrapStyleWord(true);
		txtObjetivosODS.setLineWrap(true);
		txtObjetivosODS.setFont(ConstantesEstilo.texto);
		
		JScrollPane contenedorObjetivosODS = new JScrollPane(txtObjetivosODS);
		contenedorObjetivosODS.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contenedorObjetivosODS.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		//Lugar
		lblLugar = new JLabel("Lugar: ");
		lblLugar.setFont(ConstantesEstilo.texto);
		
		//Horario
		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setFont(ConstantesEstilo.texto);
		
		txtHorario = new JTextArea();
		txtHorario.setEditable(false);
		txtHorario.setWrapStyleWord(true);
		txtHorario.setLineWrap(true);
		txtHorario.setFont(ConstantesEstilo.texto);
		
		JScrollPane contenedorHorario = new JScrollPane(txtHorario);
		contenedorHorario.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contenedorHorario.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		//Estudiantes
		lblEstudiantes = new JLabel("Cupos: ");
		lblEstudiantes.setFont(ConstantesEstilo.texto);
		
		//Facultad
		lblFacultad = new JLabel("Facultad: ");
		lblFacultad.setFont(ConstantesEstilo.texto);
		
		//Perfil de estudiante
		JLabel lblPerfilEstudiante = new JLabel("Perfil de estudiante:");
		lblPerfilEstudiante.setFont(ConstantesEstilo.texto);
		
		txtPerfilEstudiante = new JTextArea();
		txtPerfilEstudiante.setEditable(false);
		txtPerfilEstudiante.setWrapStyleWord(true);
		txtPerfilEstudiante.setLineWrap(true);
		txtPerfilEstudiante.setFont(ConstantesEstilo.texto);
		
		JScrollPane contenedorPerfilEstudiante = new JScrollPane(txtPerfilEstudiante);
		contenedorPerfilEstudiante.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contenedorPerfilEstudiante.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		//Perfil de estudiante
		JLabel lblMateriales = new JLabel("Materiales: ");
		lblMateriales.setFont(ConstantesEstilo.texto);
		
		txtMateriales = new JTextArea();
		txtMateriales.setEditable(false);
		txtMateriales.setWrapStyleWord(true);
		txtMateriales.setLineWrap(true);
		txtMateriales.setFont(ConstantesEstilo.texto);
		
		JScrollPane contenedorMateriales = new JScrollPane(txtMateriales);
		contenedorMateriales.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contenedorMateriales.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		//Transporte
		JLabel lblTransporte = new JLabel("Transporte ");
		lblTransporte.setFont(ConstantesEstilo.texto);
		
		checkTransporte = new JCheckBox();
		checkTransporte.setEnabled(false);
		
		//Transporte
		JLabel lblAlmuerzo = new JLabel("Almuerzo ");
		lblAlmuerzo.setFont(ConstantesEstilo.texto);
		
		checkAlmuerzo = new JCheckBox();
		checkAlmuerzo.setEnabled(false);
		
		//Datos del encargado
		lblEncargado = new JLabel("Encargado: ");
		lblEncargado.setFont(ConstantesEstilo.texto);
		
		lblCargo = new JLabel("Cargo: ");
		lblCargo.setFont(ConstantesEstilo.texto);
		
		lblCedula = new JLabel("Cédula: ");
		lblCedula.setFont(ConstantesEstilo.texto);
		
		lblCorreo = new JLabel("Correo: ");
		lblCorreo.setFont(ConstantesEstilo.texto);
		
		lblTelefono = new JLabel("Teléfono: ");
		lblTelefono.setFont(ConstantesEstilo.texto);
		
		//BOTONES
        JButton btnVolver = new JButton("Volver");
  		btnVolver.setFont(ConstantesEstilo.boton);
  		btnVolver.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				dispose();
				DSSUPropuestasSinEvaluar propuestasSinEvaluar = new DSSUPropuestasSinEvaluar(usuario, db);
				propuestasSinEvaluar.setVisible(true);
  			}
  		});
  		
  		JButton btnAprobar = new JButton("Aprobar");
  		btnAprobar.setFont(ConstantesEstilo.boton);
  		btnAprobar.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				usuario.evaluarPropuesta(id, true, null, db);
  				JOptionPane.showMessageDialog(null, "Proyecto aprobado", "", JOptionPane.INFORMATION_MESSAGE);
  				dispose();
				DSSUPropuestasSinEvaluar propuestasSinEvaluar = new DSSUPropuestasSinEvaluar(usuario, db);
				propuestasSinEvaluar.setVisible(true);
  			}
  		});
  		
  		JButton btnRechazar = new JButton("Rechazar");
  		btnRechazar.setFont(ConstantesEstilo.boton);
  		btnRechazar.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				String motivo = JOptionPane.showInputDialog(null, "Motivo del rechazo:", "", JOptionPane.QUESTION_MESSAGE);
  				usuario.evaluarPropuesta(id, true, motivo, db);
  				JOptionPane.showMessageDialog(null, "Proyecto rechazado", "", JOptionPane.INFORMATION_MESSAGE);
  				dispose();
				DSSUPropuestasSinEvaluar propuestasSinEvaluar = new DSSUPropuestasSinEvaluar(usuario, db);
				propuestasSinEvaluar.setVisible(true);
  			}
  		});
		
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				
				.addGroup(layout.createSequentialGroup()
						.addComponent(btnVolver, 150, 150, 150)
						.addComponent(lblBienvenida, 0, 0, Short.MAX_VALUE))
				
				.addComponent(lblTipoUsuario, 0, 0, Short.MAX_VALUE)
				.addComponent(lblEvaluarPropuesta, 0, 0, Short.MAX_VALUE)
								
				.addComponent(lblTitulo)
		        .addComponent(lblOrganismoReceptor)
		        .addComponent(lblTipo)
		        
		        .addGroup(layout.createSequentialGroup()
		                .addComponent(lblResumen, 480, 480, 480)
		                .addGap(10)
		                .addComponent(lblObjetivo, 480, 480, 480))
		        
		        .addGroup(layout.createSequentialGroup()
		                .addComponent(contenedorResumen, 480, 480, 480)
		                .addGap(10)
		                .addComponent(contenedorObjetivo, 480, 480, 480))
		        
		        .addGroup(layout.createSequentialGroup()
		                .addComponent(lblBeneficiarios, 480, 480, 480)
		                .addGap(10)
		                .addComponent(lblObjetivosODS, 480, 480, 480))
		        
		        .addGroup(layout.createSequentialGroup()
		                .addComponent(contenedorBeneficiarios, 480, 480, 480)
		                .addGap(10)
		                .addComponent(contenedorObjetivosODS, 480, 480, 480))
		        
		        .addComponent(lblLugar)
		        .addComponent(lblHorario)
		        .addComponent(contenedorHorario)
		        
		        .addComponent(lblEstudiantes)
		        .addComponent(lblFacultad)
		        .addComponent(lblPerfilEstudiante)
		        .addComponent(contenedorPerfilEstudiante)
		        
		        .addComponent(lblMateriales)
		        .addComponent(contenedorMateriales)
		        
		        .addGroup(layout.createSequentialGroup()
		                .addComponent(lblTransporte, 110, 110, 110)
		                .addComponent(checkTransporte)
		                .addGap(360)
		                .addComponent(lblAlmuerzo, 100, 100, 100)
		                .addComponent(checkAlmuerzo))
		        
		        .addComponent(lblEncargado)
		        .addComponent(lblCargo)
		        .addComponent(lblCedula)
		        .addComponent(lblCorreo)
		        .addComponent(lblTelefono)
		        
		        .addGroup(layout.createSequentialGroup()
		        		.addGap(200)
		                .addComponent(btnAprobar, 200, 200, 200)
		                .addGap(150)
		                .addComponent(btnRechazar, 200, 200, 200)
		                .addGap(200))
		        
		);

		layout.setVerticalGroup(
				layout.createSequentialGroup()
				
				.addGroup(layout.createParallelGroup()
						.addComponent(btnVolver)
						.addComponent(lblBienvenida))
				
		        .addComponent(lblTipoUsuario)
		        .addComponent(lblEvaluarPropuesta)
		        
		        .addComponent(lblTitulo)
		        .addComponent(lblOrganismoReceptor)
		        .addComponent(lblTipo)
		        
		        .addGroup(layout.createParallelGroup()
		                .addComponent(lblResumen)
		                .addComponent(lblObjetivo))
		        
		        .addGroup(layout.createParallelGroup()
		                .addComponent(contenedorResumen, 200, 200, 200)
		                .addComponent(contenedorObjetivo, 200, 200, 200))
		        
		        .addGroup(layout.createParallelGroup()
		                .addComponent(lblBeneficiarios)
		                .addComponent(lblObjetivosODS))
		        
		        .addGroup(layout.createParallelGroup()
		                .addComponent(contenedorBeneficiarios, 200, 200, 200)
		                .addComponent(contenedorObjetivosODS, 200, 200, 200))
		        
		        .addGap(20)
		        .addComponent(lblLugar)
		        .addComponent(lblHorario)
		        .addComponent(contenedorHorario, 200, 200, 200)
		        
		        .addGap(20)
		        .addComponent(lblEstudiantes)
		        .addComponent(lblFacultad)
		        .addComponent(lblPerfilEstudiante)
		        .addComponent(contenedorPerfilEstudiante, 200, 200, 200)
		        
		        .addGap(20)
		        .addComponent(lblMateriales)
		        .addComponent(contenedorMateriales, 200, 200, 200)
		        
		        .addGroup(layout.createParallelGroup()
		                .addComponent(lblTransporte)
		                .addComponent(checkTransporte)
		                .addComponent(lblAlmuerzo)
		                .addComponent(checkAlmuerzo))
		        
		        .addGap(20)
		        .addComponent(lblEncargado)
		        .addComponent(lblCargo)
		        .addComponent(lblCedula)
		        .addComponent(lblCorreo)
		        .addComponent(lblTelefono)
		        
		        .addGap(20)
		        .addGroup(layout.createParallelGroup()
		                .addComponent(btnAprobar, 50, 50, 50)
		                .addComponent(btnRechazar, 50, 50, 50))
		        
		);
		
		consultarPropuesta(id);
	}
	
	public void consultarPropuesta(int id) {
		
		try {
			//Consulta de datos
			db.consultarDatos("SELECT "
					+ "titulo, "
					+ "usuario, "
					+ "Proyectos.tipo, "
					+ "resumen, "
					+ "objetivo, "
					+ "beneficiarios, "
					+ "contribucionODS, "
					+ "lugar, "
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
					+ "INNER JOIN Encargados ON encargado_id = Encargados.id "
					+ "WHERE Proyectos.id = " + id);
			
			lblTitulo.setText("Título: " + db.datos.getString("titulo"));
			lblOrganismoReceptor.setText("Organismo Receptor: " + db.datos.getString("usuario"));
			lblTipo.setText("Tipo: " + db.datos.getString("tipo"));
			txtResumen.setText(db.datos.getString("resumen"));
			txtObjetivo.setText(db.datos.getString("objetivo"));
			txtBeneficiarios.setText(db.datos.getString("beneficiarios"));
			txtObjetivosODS.setText(db.datos.getString("contribucionODS"));
			lblLugar.setText("Lugar: " + db.datos.getString("lugar"));
			lblEstudiantes.setText("Cupos: " + Integer.toString(db.datos.getInt("estudiantes")));
			lblFacultad.setText("Facultad: " + db.datos.getString("facultades"));
			txtPerfilEstudiante.setText(db.datos.getString("perfil_estudiante"));
			txtMateriales.setText(db.datos.getString("materiales"));
			checkTransporte.setSelected(db.datos.getInt("transporte") == 1 ? true : false);
			checkAlmuerzo.setSelected(db.datos.getInt("almuerzo") == 1 ? true : false);
			lblEncargado.setText("Encargado: " + db.datos.getString("nombre"));
			lblCargo.setText("Cargo: " + db.datos.getString("cargo"));
			lblCedula.setText("Cédula: " + db.datos.getString("cedula"));
			lblCorreo.setText("Correo: " + db.datos.getString("correo"));
			lblTelefono.setText("Teléfono: " + db.datos.getString("telefono"));

		}
		
		catch(SQLException e){
			System.out.println("Error al consultar la base de datos. " + e.getMessage());
		}
		
		finally {
			db.cerrarConexion();
		}
	}
}
