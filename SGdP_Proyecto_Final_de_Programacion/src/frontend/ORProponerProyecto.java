package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import backend.ManejoSQL;
import backend.OrganismoReceptor;
import backend.Validaciones;

import java.util.ArrayList;
import java.util.Arrays;

public class ORProponerProyecto extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txt_titulo;
    private JTextField txt_lugar;
    private JTextArea txt_objetivo;
    private JTextArea txt_resumen;
    private JTextArea txt_beneficiarios;
    private JTextArea txt_contribucionODS;
    private JTextArea txt_materiales;
    private JRadioButton btn_servicio_social;
    private JRadioButton btn_voluntariado;
    
    private JTextField txt_nombre_encargado;
    private JTextField txt_cedula_encargado;
    private JTextField txt_cargo_encargado;
    private JTextField txt_correo_encargado;
    private JTextField txt_telefono_encargado;
    
    private JTextField txt_cantidad_estudiantes;
    private JComboBox<String> comboBox_facultad;
    private JTextArea txt_perfil_estudiantil;
    private JRadioButton btn_si_transporte;
    private JRadioButton btn_no_transporte;
    private JRadioButton btn_si_almuerzo;
    private JRadioButton btn_no_almuerzo;
    
    private JTextField txt_dia;
    private JTextField txt_hora_inicio;
    private JTextField txt_hora_final;
        
    public ORProponerProyecto(OrganismoReceptor usuario, ManejoSQL db) {
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
		
		// Título de la ventana
		JLabel lbl_propuesta_de_proyecto = new JLabel("PROPUESTA DE PROYECTO");
        lbl_propuesta_de_proyecto.setFont(ConstantesEstilo.titulo);
        lbl_propuesta_de_proyecto.setHorizontalAlignment(SwingConstants.CENTER);
		
        
        // ----------Datos generales----------
        JPanel contenedor_descripcion_proyecto = new JPanel();
        
        JLabel lbl_descripcion_proyecto = new JLabel("Descripción del proyecto");
        lbl_descripcion_proyecto.setFont(ConstantesEstilo.subtitulo);
        lbl_descripcion_proyecto.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Título
        JLabel lbl_titulo = new JLabel("Título:");
        lbl_titulo.setFont(ConstantesEstilo.texto);
        
        txt_titulo = new JTextField();
        txt_titulo.setFont(ConstantesEstilo.texto);
        
        // Lugar
        JLabel lbl_lugar = new JLabel("Lugar:");
        lbl_lugar.setFont(ConstantesEstilo.texto);
        
        txt_lugar = new JTextField();
        txt_lugar.setFont(ConstantesEstilo.texto);
        
        // Objetivo
        JLabel lbl_objetivo = new JLabel("Objetivo:");
        lbl_objetivo.setFont(ConstantesEstilo.texto);
       
        txt_objetivo = new JTextArea();
        txt_objetivo.setFont(ConstantesEstilo.texto);
        txt_objetivo.setLineWrap(true);
        
        JScrollPane scroll_objetivo = new JScrollPane(txt_objetivo);
        
        // Resumen        
        JLabel lbl_resumen = new JLabel("Resumen:");
        lbl_resumen.setFont(ConstantesEstilo.texto);
        
        txt_resumen = new JTextArea();
        txt_resumen.setFont(ConstantesEstilo.texto);
        txt_resumen.setLineWrap(true);
        
        JScrollPane scroll_resumen = new JScrollPane(txt_resumen);
        
        // Beneficiarios
        JLabel lbl_beneficiarios = new JLabel("Beneficiarios:");
        lbl_beneficiarios.setFont(ConstantesEstilo.texto);
        
        txt_beneficiarios = new JTextArea();
        txt_beneficiarios.setFont(ConstantesEstilo.texto);
        txt_beneficiarios.setLineWrap(true);
        
        JScrollPane scroll_beneficiarios = new JScrollPane(txt_beneficiarios);
        
        // Contribución ODS
        JLabel lbl_contribucion_ods = new JLabel("Contribución ODS:");
        lbl_contribucion_ods.setFont(ConstantesEstilo.texto);
        
        txt_contribucionODS = new JTextArea();
        txt_contribucionODS.setFont(ConstantesEstilo.texto);
        txt_contribucionODS.setLineWrap(true);
        
        JScrollPane scroll_contribucion_ods = new JScrollPane(txt_contribucionODS);
        
        // Materiales
        JLabel lbl_materiales = new JLabel("Materiales:");
        lbl_materiales.setFont(ConstantesEstilo.texto);

        txt_materiales = new JTextArea();
        txt_materiales.setFont(ConstantesEstilo.texto);
        txt_materiales.setLineWrap(true);
        
        JScrollPane scroll_materiales = new JScrollPane(txt_materiales);
        
        // Tipo
        JLabel lbl_tipo = new JLabel("Tipo:");
        lbl_tipo.setFont(ConstantesEstilo.texto);
        
        btn_servicio_social = new JRadioButton("Servicio social");
        btn_servicio_social.setFont(ConstantesEstilo.boton);
        btn_servicio_social.setSelected(true);
        
        btn_voluntariado = new JRadioButton("Voluntariado");
        btn_voluntariado.setFont(ConstantesEstilo.boton);
        
        ButtonGroup tipo_proyecto = new ButtonGroup();
        tipo_proyecto.add(btn_servicio_social);
        tipo_proyecto.add(btn_voluntariado);
        
        GroupLayout gl_descripcion_proyecto = new GroupLayout(contenedor_descripcion_proyecto);
        
        gl_descripcion_proyecto.setHorizontalGroup(gl_descripcion_proyecto.createParallelGroup()
				.addComponent(lbl_descripcion_proyecto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				
				.addGroup(gl_descripcion_proyecto.createSequentialGroup()
						.addComponent(lbl_titulo, 70, 70, 70)
						.addComponent(txt_titulo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				
				.addGroup(gl_descripcion_proyecto.createSequentialGroup()
						.addComponent(lbl_lugar, 70, 70, 70)
						.addComponent(txt_lugar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						
				.addComponent(lbl_objetivo)
				.addComponent(scroll_objetivo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				
				.addComponent(lbl_resumen)
				.addComponent(scroll_resumen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				
				.addComponent(lbl_beneficiarios)
				.addComponent(scroll_beneficiarios, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				
				.addComponent(lbl_contribucion_ods)
				.addComponent(scroll_contribucion_ods, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				
				.addComponent(lbl_materiales)
				.addComponent(scroll_materiales, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				
        		.addComponent(lbl_tipo)
        		.addGroup(gl_descripcion_proyecto.createSequentialGroup()
        				.addComponent(btn_servicio_social)
        				.addGap(10)
        				.addComponent(btn_voluntariado)));
        								
        gl_descripcion_proyecto.setVerticalGroup(gl_descripcion_proyecto.createSequentialGroup()
    			.addComponent(lbl_descripcion_proyecto)
    			.addGap(10)
    			
    			.addGroup(gl_descripcion_proyecto.createParallelGroup()
    					.addComponent(lbl_titulo)
    					.addComponent(txt_titulo))
    			.addGap(10)
    			
    			.addGroup(gl_descripcion_proyecto.createParallelGroup()
    					.addComponent(lbl_lugar)
    					.addComponent(txt_lugar))
    			.addGap(10)
    			
    			.addComponent(lbl_objetivo)
    			.addComponent(scroll_objetivo, 140, 140, 140)
    			.addGap(10)
    			
    			.addComponent(lbl_resumen)
    			.addComponent(scroll_resumen, 140, 140, 140)
    			.addGap(10)
    			
    			.addComponent(lbl_beneficiarios)
    			.addComponent(scroll_beneficiarios, 140, 140, 140)
    			.addGap(10)
    			
    			.addComponent(lbl_contribucion_ods)
    			.addComponent(scroll_contribucion_ods, 140, 140, 140)
    			.addGap(10)
    			
    			.addComponent(lbl_materiales)
    			.addComponent(scroll_materiales, 140, 140, 140)
    			.addGap(10)
    			
        		.addComponent(lbl_tipo)
        		.addGroup(gl_descripcion_proyecto.createParallelGroup()
        				.addComponent(btn_servicio_social)
        				.addComponent(btn_voluntariado)));
        
        contenedor_descripcion_proyecto.setLayout(gl_descripcion_proyecto);
        
        
        // ----------Datos del encargado----------
        JPanel contenedor_encargado = new JPanel();
        
        JLabel lbl_encargado = new JLabel("Encargado");
        lbl_encargado.setFont(ConstantesEstilo.subtitulo);
        lbl_encargado.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Nombre
        JLabel lbl_nombre_encargado = new JLabel("Nombre:");
        lbl_nombre_encargado.setFont(ConstantesEstilo.texto);
        
        txt_nombre_encargado = new JTextField();
        txt_nombre_encargado.setFont(ConstantesEstilo.texto);
        
        // Cédula
        JLabel lbl_cedula_encargado = new JLabel("Cédula:");
        lbl_cedula_encargado.setFont(ConstantesEstilo.texto);
        
        txt_cedula_encargado = new JTextField();
        txt_cedula_encargado.setFont(ConstantesEstilo.texto);
        
        // Cargo
        JLabel lbl_cargo_encargado = new JLabel("Cargo:");
        lbl_cargo_encargado.setFont(ConstantesEstilo.texto);
        
        txt_cargo_encargado = new JTextField();
        txt_cargo_encargado.setFont(ConstantesEstilo.texto);
        
        // Correo
        JLabel lbl_correo_encargado = new JLabel("Correo:");
        lbl_correo_encargado.setFont(ConstantesEstilo.texto);
        
        txt_correo_encargado = new JTextField();
        txt_correo_encargado.setFont(ConstantesEstilo.texto);
        
        // Teléfono
        JLabel lbl_telefono_encargado = new JLabel("Teléfono:");
        lbl_telefono_encargado.setFont(ConstantesEstilo.texto);
        
        txt_telefono_encargado = new JTextField();
        txt_telefono_encargado.setFont(ConstantesEstilo.texto);
        
        GroupLayout gl_encargado = new GroupLayout(contenedor_encargado);
        
        gl_encargado.setHorizontalGroup(gl_encargado.createParallelGroup()
				.addComponent(lbl_encargado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					
				.addGroup(gl_encargado.createSequentialGroup()
						.addComponent(lbl_nombre_encargado, 100, 100, 100)
						.addComponent(txt_nombre_encargado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				
				.addGroup(gl_encargado.createSequentialGroup()
						.addComponent(lbl_cedula_encargado, 100, 100, 100)
						.addComponent(txt_cedula_encargado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				
				.addGroup(gl_encargado.createSequentialGroup()
						.addComponent(lbl_cargo_encargado, 100, 100, 100)
						.addComponent(txt_cargo_encargado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				
				.addGroup(gl_encargado.createSequentialGroup()
						.addComponent(lbl_correo_encargado, 100, 100, 100)
						.addComponent(txt_correo_encargado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				
				.addGroup(gl_encargado.createSequentialGroup()
						.addComponent(lbl_telefono_encargado, 100, 100, 100)
						.addComponent(txt_telefono_encargado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        
        gl_encargado.setVerticalGroup(gl_encargado.createSequentialGroup()
        		.addComponent(lbl_encargado)
        		.addGap(10)
        		
    			.addGroup(gl_encargado.createParallelGroup()
    					.addComponent(lbl_nombre_encargado)
    				.	addComponent(txt_nombre_encargado, 34, 34, 34))
    			.addGap(10)
    			
    			.addGroup(gl_encargado.createParallelGroup()
    					.addComponent(lbl_cedula_encargado)
    					.addComponent(txt_cedula_encargado, 34, 34, 34))
    			.addGap(10)
    			
    			.addGroup(gl_encargado.createParallelGroup()
    					.addComponent(lbl_cargo_encargado)
    					.addComponent(txt_cargo_encargado, 34, 34, 34))
    			.addGap(10)
    			
    			.addGroup(gl_encargado.createParallelGroup()
    					.addComponent(lbl_correo_encargado)
    					.addComponent(txt_correo_encargado, 34, 34, 34))
    			.addGap(10)
    			
    			.addGroup(gl_encargado.createParallelGroup()
    					.addComponent(lbl_telefono_encargado)
    					.addComponent(txt_telefono_encargado, 34, 34, 34)));
        
        contenedor_encargado.setLayout(gl_encargado);
        
        
        // ----------Datos de contribuyentes (estudiantes)----------
        JPanel contenedor_contribuyentes = new JPanel();
        
        JLabel lbl_contribuyentes = new JLabel("Contribuyentes");
        lbl_contribuyentes.setFont(ConstantesEstilo.subtitulo);
        lbl_contribuyentes.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Cantidad
        JLabel lbl_cantidad_estudiantes = new JLabel("Cantidad de estudiantes:");
        lbl_cantidad_estudiantes.setFont(ConstantesEstilo.texto);
        
        txt_cantidad_estudiantes = new JTextField();
        txt_cantidad_estudiantes.setFont(ConstantesEstilo.texto);
        
        // Facultad
        JLabel lbl_facultad = new JLabel("Facultad:");
        lbl_facultad.setFont(ConstantesEstilo.texto);
        
        comboBox_facultad = new JComboBox<String>();
        comboBox_facultad.setModel(new DefaultComboBoxModel<>(new String[] {"TODAS", "FCT", "FIC", "FIE", "FII", "FIM", "FISC"}));
        comboBox_facultad.setFont(ConstantesEstilo.texto);
        
        // Perfil de estudiante
        JLabel lbl_perfil_estudiantil = new JLabel("Perfil estudiantil:");
        lbl_perfil_estudiantil.setFont(ConstantesEstilo.texto);
        
        txt_perfil_estudiantil = new JTextArea();
        txt_perfil_estudiantil.setFont(ConstantesEstilo.texto);
        txt_perfil_estudiantil.setLineWrap(true);
        
        JScrollPane scroll_perfil_estudiantil = new JScrollPane(txt_perfil_estudiantil);
        
        // Transporte
        JLabel lbl_transporte = new JLabel("Brindará transporte:");
        lbl_transporte.setFont(ConstantesEstilo.texto);
        
        btn_si_transporte = new JRadioButton("Sí");
        btn_si_transporte.setFont(ConstantesEstilo.boton);
        btn_si_transporte.setSelected(true);
        
        btn_no_transporte = new JRadioButton("No");
        btn_no_transporte.setFont(ConstantesEstilo.boton);
        
        ButtonGroup transporte = new ButtonGroup();
        transporte.add(btn_si_transporte);
        transporte.add(btn_no_transporte);
        
        // Almuerzo
        JLabel lbl_almuerzo = new JLabel("Brindará almuerzo:");
        lbl_almuerzo.setFont(ConstantesEstilo.texto);
        
        btn_si_almuerzo = new JRadioButton("Sí");
        btn_si_almuerzo.setFont(ConstantesEstilo.boton);
        btn_si_almuerzo.setSelected(true);
        
        btn_no_almuerzo = new JRadioButton("No");
        btn_no_almuerzo.setFont(ConstantesEstilo.boton);
        
        ButtonGroup almuerzo = new ButtonGroup();
        almuerzo.add(btn_si_almuerzo);
        almuerzo.add(btn_no_almuerzo);
        
        GroupLayout gl_contribuyentes = new GroupLayout(contenedor_contribuyentes);
        
        gl_contribuyentes.setHorizontalGroup(gl_contribuyentes.createParallelGroup()
				.addComponent(lbl_contribuyentes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				
				.addGroup(gl_contribuyentes.createSequentialGroup()
						.addComponent(lbl_cantidad_estudiantes, 240, 240, 240)
						.addComponent(txt_cantidad_estudiantes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				
				.addGroup(gl_contribuyentes.createSequentialGroup()
					.addComponent(lbl_facultad, 100, 100, 100)
					.addComponent(comboBox_facultad, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				
				.addComponent(lbl_perfil_estudiantil)
				.addComponent(scroll_perfil_estudiantil, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				
        		.addComponent(lbl_transporte)
        		.addGroup(gl_contribuyentes.createSequentialGroup()
        				.addComponent(btn_si_transporte)
        				.addGap(10)
        				.addComponent(btn_no_transporte))
        		
        		.addComponent(lbl_almuerzo)
        		.addGroup(gl_contribuyentes.createSequentialGroup()
        				.addComponent(btn_si_almuerzo)
        				.addGap(10)
        				.addComponent(btn_no_almuerzo)));
        				
        gl_contribuyentes.setVerticalGroup(gl_contribuyentes.createSequentialGroup()
        		.addComponent(lbl_contribuyentes)
        		.addGap(10)
        		
        		.addGroup(gl_contribuyentes.createParallelGroup()
        				.addComponent(lbl_cantidad_estudiantes)
        				.addComponent(txt_cantidad_estudiantes, 34, 34, 34))
        		.addGap(10)
        		
        		.addGroup(gl_contribuyentes.createParallelGroup()
        				.addComponent(lbl_facultad)
        				.addComponent(comboBox_facultad, 34, 34, 34))
        		.addGap(10)
        		
        		.addComponent(lbl_perfil_estudiantil)
        		.addComponent(scroll_perfil_estudiantil, 140, 140, 140)
        		.addGap(10)
        		
        		.addComponent(lbl_transporte)
        		.addGroup(gl_contribuyentes.createParallelGroup()
        				.addComponent(btn_si_transporte)
        				.addComponent(btn_no_transporte))
        		.addGap(10)
        		
        		.addComponent(lbl_almuerzo)
        		.addGroup(gl_contribuyentes.createParallelGroup()
        				.addComponent(btn_si_almuerzo)
        				.addComponent(btn_no_almuerzo)));
        
        contenedor_contribuyentes.setLayout(gl_contribuyentes);
        
        
        // ----------Horario----------
        JPanel contenedor_horario = new JPanel();
        
        JLabel lbl_horario = new JLabel("HORARIO");
        lbl_horario.setFont(ConstantesEstilo.subtitulo);
        lbl_horario.setHorizontalAlignment(SwingConstants.CENTER);
        
        //Día
        JLabel lbl_dia = new JLabel("Día [dd/mm/aaaa]");
        lbl_dia.setFont(ConstantesEstilo.subtitulo);
        
        txt_dia = new JTextField();
        txt_dia.setFont(ConstantesEstilo.texto);
        
        //Hora de inicio
        JLabel lbl_hora_inicio = new JLabel("Hora de inicio [24:00]");
        lbl_hora_inicio.setFont(ConstantesEstilo.subtitulo);
        
        txt_hora_inicio = new JTextField();
        txt_hora_inicio.setFont(ConstantesEstilo.texto);
        
        //Hora de finalización
        JLabel lbl_hora_final = new JLabel("Hora de finalización [24:00]");
        lbl_hora_final.setFont(ConstantesEstilo.subtitulo);
        
        txt_hora_final = new JTextField();
        txt_hora_final.setFont(ConstantesEstilo.texto);
        
        GroupLayout gl_horario = new GroupLayout(contenedor_horario);
        
        gl_horario.setHorizontalGroup(gl_horario.createParallelGroup()
        		.addComponent(lbl_horario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		
        		.addGroup(gl_horario.createSequentialGroup()
        				.addComponent(lbl_dia, 310, 310, 310)
        				.addGap(10)
        				.addComponent(lbl_hora_inicio, 310, 310, 310)
        				.addGap(10)
        				.addComponent(lbl_hora_final, 310, 310, 310))
        		
        		.addGroup(gl_horario.createSequentialGroup()
        				.addComponent(txt_dia, 310, 310, 310)
        				.addGap(10)
        				.addComponent(txt_hora_inicio, 310, 310, 310)
        				.addGap(10)
        				.addComponent(txt_hora_final, 310, 310, 310)));
        
        gl_horario.setVerticalGroup(gl_horario.createSequentialGroup()
        		.addComponent(lbl_horario)
        		
        		.addGroup(gl_horario.createParallelGroup()
        				.addComponent(lbl_dia)
        				.addComponent(lbl_hora_inicio)
        				.addComponent(lbl_hora_final))
        		
        		.addGroup(gl_horario.createParallelGroup()
        				.addComponent(txt_dia, 34, 34, 34)
        				.addComponent(txt_hora_inicio, 34, 34, 34)
        				.addComponent(txt_hora_final, 34, 34, 34)));
        
        contenedor_horario.setLayout(gl_horario);
        
        
        // ----------Botones de navegación----------
        JButton btn_enviar = new JButton("Enviar");
        btn_enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validarDatos()) {
					// Manejo de datos
					String tipo = btn_servicio_social.isSelected() ? "Servicio Social" : "Voluntariado";
					int transporte = btn_si_transporte.isSelected() ? 1 : 0;
					int almuerzo = btn_si_almuerzo.isSelected() ? 1 : 0;
					
					usuario.proponerProyecto(	usuario.getId(), txt_titulo.getText(), txt_lugar.getText(), txt_objetivo.getText(), txt_resumen.getText(), txt_beneficiarios.getText(), txt_contribucionODS.getText(), txt_materiales.getText(), tipo, 
												txt_nombre_encargado.getText(), txt_cedula_encargado.getText(), txt_cargo_encargado.getText(), txt_correo_encargado.getText(), txt_telefono_encargado.getText(), 
												Integer.parseInt(txt_cantidad_estudiantes.getText()), comboBox_facultad.getSelectedItem().toString(), txt_perfil_estudiantil.getText(), transporte, almuerzo, 
												txt_dia.getText(), txt_hora_inicio.getText(), txt_hora_final.getText(),
												db);
				}
			}
		});
        btn_enviar.setFont(ConstantesEstilo.boton);
        
        JButton btn_menu = new JButton("Menú");
        btn_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ORMenuPrincipal menu_or = new ORMenuPrincipal(usuario, db);
				menu_or.setVisible(true);
			}
		});
        btn_menu.setFont(ConstantesEstilo.boton);
        
        GroupLayout gl_general = new GroupLayout(contenedor_general);
        
        gl_general.setHorizontalGroup(gl_general.createParallelGroup()
        		.addComponent(btn_menu, 130, 130, 130)
        		
        		.addComponent(lbl_propuesta_de_proyecto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		
        		.addGroup(gl_general.createSequentialGroup()
        				.addComponent(contenedor_descripcion_proyecto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addGap(20)
        				
        				.addGroup(gl_general.createParallelGroup()
        						.addComponent(contenedor_encargado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(contenedor_contribuyentes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        		
        		.addComponent(contenedor_horario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		
        		.addGroup(gl_general.createSequentialGroup()
        				.addGap(800)
        				.addComponent(btn_enviar, 150, 150, 150)));
        
        gl_general.setVerticalGroup(gl_general.createSequentialGroup()
        		.addComponent(btn_menu)
        		.addGap(10)
        		
        		.addComponent(lbl_propuesta_de_proyecto)
        		.addGap(20)
        		
        		.addGroup(gl_general.createParallelGroup()
        				.addComponent(contenedor_descripcion_proyecto)
        				
        				.addGroup(gl_general.createSequentialGroup()
        						.addComponent(contenedor_encargado)
        						.addGap(55)
        						.addComponent(contenedor_contribuyentes)))
        		.addGap(20)
        		
        		.addComponent(contenedor_horario)
        		.addGap(20)
        		
        		.addComponent(btn_enviar));
        
        contenedor_general.setLayout(gl_general);
    }
    
    private boolean validarDatos() {
    	
    	// Comprobar campos vacíos
    	ArrayList<JTextComponent> campos_texto = new ArrayList<JTextComponent>(Arrays.asList(	txt_titulo, txt_lugar, txt_objetivo, txt_resumen, txt_beneficiarios, txt_contribucionODS, txt_materiales, 
				txt_nombre_encargado, txt_cedula_encargado, txt_cargo_encargado, txt_correo_encargado, txt_telefono_encargado, 
				txt_cantidad_estudiantes, txt_perfil_estudiantil, 
				txt_dia, txt_hora_inicio, txt_hora_final));
    	
    	for (JTextComponent campo_texto : campos_texto) {
    		if((campo_texto).getText().equals("")) {
    			JOptionPane.showMessageDialog(null, "Hay campos vacíos.", "", JOptionPane.ERROR_MESSAGE);
    			return false;
    		}
    	}
    	
    	// Validar nombre
    	if (!Validaciones.soloLetras(txt_nombre_encargado.getText())) {
    		JOptionPane.showMessageDialog(null, "El nombre del encargado no es válido.", "", JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	
    	// Validar formato de cédula
    	if (!Validaciones.validarCedula(txt_cedula_encargado.getText())) {
    		JOptionPane.showMessageDialog(null, "La cédula del encargado no es válida.", "", JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	
    	// Validar correo
    	if (!Validaciones.validaCorreo(txt_correo_encargado.getText())) {
    		JOptionPane.showMessageDialog(null, "El correo del encargado no es válido.", "", JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	
    	// Validar formato de teléfono (6XXX-XXXX)
    	if (!Validaciones.validarTelefono(txt_telefono_encargado.getText())) {
    		JOptionPane.showMessageDialog(null, "El teléfono del encargado no es válido.", "", JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	
    	// Validar cantidad de estudiantes >= 1
    	if (!Validaciones.validarEnteroPositivo(txt_cantidad_estudiantes.getText())) {
    		JOptionPane.showMessageDialog(null, "La cantidad de estudiantes no es válida.", "", JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	
    	// Validar fecha (formato y que la actividad se realice con 1 día de anticipación)
    	switch(Validaciones.validarDia(txt_dia.getText())) {
    	case -1:
    		JOptionPane.showMessageDialog(null, "El formato de fecha no es válido.", "", JOptionPane.ERROR_MESSAGE);
    		return false;
    	case 0:
    		JOptionPane.showMessageDialog(null, "La fecha de la actividad no es válida. Debe haber al menos un día de preparación.", "", JOptionPane.WARNING_MESSAGE);
    		return false;
    	case 1: break;
    	default: break;
    	}
    	
    	// Validar hora (formato y que la actividad dure al menos 1 hora)
    	switch(Validaciones.validarHora(txt_hora_inicio.getText(), txt_hora_final.getText())) {
    	case -2:
    		JOptionPane.showMessageDialog(null, "El formato de la hora de inicio no es válido.", "", JOptionPane.ERROR_MESSAGE);
    		return false;
    	case -1:
    		JOptionPane.showMessageDialog(null, "El formato de la hora de finalización no es válido.", "", JOptionPane.ERROR_MESSAGE);
    		return false;
    	case 0:
    		JOptionPane.showMessageDialog(null, "La actividad debe durar al menos 1 hora.", "", JOptionPane.WARNING_MESSAGE);
    		return false;
    	case 1: break;
    	default: break;
    	}
    	
    	return true;
    	
    }
    
}