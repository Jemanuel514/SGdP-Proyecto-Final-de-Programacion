package frontend;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import java.awt.BorderLayout;
import java.awt.Dimension;

public class ProponerProyecto extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contenedorPrincipal;
    private JScrollPane scrollPane;
    private JLabel lblNewLabel;
    private JTextField nombreEncargado;
    private JTextField cedulaEncargado;
    private JTextField cargoEncargado;
    private JTextField correoEncargado;
    private JTextField telefonoEncargado;
    private JTextField tituloProyecto;
    private JTextField lugarProyecto;
    private JTextField cantidadEstudiantesPP;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProponerProyecto frame = new ProponerProyecto();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ProponerProyecto() {
    	setSize(new Dimension(1024, 768));
        setTitle("Proponer proyecto");
        setResizable(false);
        setSize(1024,768);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 768);
        contenedorPrincipal = new JPanel();
        contenedorPrincipal.setSize(new Dimension(1024, 768));
        contenedorPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
        contenedorPrincipal.setLayout(null);
        
        setContentPane(contenedorPrincipal);
        
        scrollPane = new JScrollPane();
        scrollPane.setSize(new Dimension(1024, 768));
        scrollPane.setPreferredSize(new Dimension(1024, 768));
        contenedorPrincipal.add(scrollPane, BorderLayout.CENTER);
        
        lblNewLabel = new JLabel("PROPUESTA DE PROYECTO");
        lblNewLabel.setFont(new Font("Artifakt Element", Font.BOLD, 40));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scrollPane.setColumnHeaderView(lblNewLabel);
        
        JPanel contenedorFormulario = new JPanel();
        contenedorFormulario.setSize(new Dimension(1024, 768));
        scrollPane.setViewportView(contenedorFormulario);
        
        JPanel contenedorEncargado = new JPanel();
        
        JPanel contenedorDescripcionDeProyecto = new JPanel();
        
        JPanel contenedorContribuyentes = new JPanel();
        
        JLabel lblNewLabel_1_1_6 = new JLabel("Cantidad de estudiantes:");
        lblNewLabel_1_1_6.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_6.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        cantidadEstudiantesPP = new JTextField();
        cantidadEstudiantesPP.setHorizontalAlignment(SwingConstants.LEFT);
        cantidadEstudiantesPP.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        cantidadEstudiantesPP.setColumns(10);
        
        JLabel lblNewLabel_1_3 = new JLabel("Contribuyentes");
        lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_3.setFont(new Font("Arial Unicode MS", Font.BOLD, 20));
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Facultad:");
        lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_1_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JLabel lblNewLabel_1_1_2_1 = new JLabel("Perfil estudiantil");
        lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_2_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JComboBox facultadPP = new JComboBox();
        facultadPP.setModel(new DefaultComboBoxModel(new String[] {"TODAS", "FCT", "FIC", "FIE", "FII", "FIM", "FISC"}));
        facultadPP.setToolTipText("");
        facultadPP.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JTextArea perfilEstudiantil = new JTextArea();
        perfilEstudiantil.setLineWrap(true);
        perfilEstudiantil.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        GroupLayout gl_contenedorContribuyentes = new GroupLayout(contenedorContribuyentes);
        gl_contenedorContribuyentes.setHorizontalGroup(
        	gl_contenedorContribuyentes.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_contenedorContribuyentes.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_contenedorContribuyentes.createParallelGroup(Alignment.LEADING)
        				.addComponent(perfilEstudiantil)
        				.addComponent(lblNewLabel_1_1_2_1, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        				.addGroup(gl_contenedorContribuyentes.createSequentialGroup()
        					.addComponent(lblNewLabel_1_1_6)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(cantidadEstudiantesPP, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
        				.addComponent(lblNewLabel_1_3, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        				.addGroup(gl_contenedorContribuyentes.createSequentialGroup()
        					.addComponent(lblNewLabel_1_1_1_1)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(facultadPP, 0, 333, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        gl_contenedorContribuyentes.setVerticalGroup(
        	gl_contenedorContribuyentes.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contenedorContribuyentes.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel_1_3)
        			.addGap(18)
        			.addGroup(gl_contenedorContribuyentes.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblNewLabel_1_1_6, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cantidadEstudiantesPP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_contenedorContribuyentes.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(facultadPP, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(perfilEstudiantil, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        			.addContainerGap())
        );
        contenedorContribuyentes.setLayout(gl_contenedorContribuyentes);
        
        JPanel contenedorRoundBottons = new JPanel();
        
        JButton botonEnviarPP = new JButton("Enviar");
        botonEnviarPP.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        
        JButton botonMenu = new JButton("Men\u00FA");
        botonMenu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        
        JLabel lblNewLabel_1_1_5 = new JLabel("Tipo:");
        lblNewLabel_1_1_5.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_5.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JPanel contenedorTipo = new JPanel();
        
        JRadioButton botonServicioSocial = new JRadioButton("Servicio social");
        botonServicioSocial.setHorizontalAlignment(SwingConstants.LEFT);
        botonServicioSocial.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        
        JRadioButton botonVoluntariado = new JRadioButton("Voluntariado");
        botonVoluntariado.setHorizontalAlignment(SwingConstants.LEFT);
        botonVoluntariado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        GroupLayout gl_contenedorTipo = new GroupLayout(contenedorTipo);
        gl_contenedorTipo.setHorizontalGroup(
        	gl_contenedorTipo.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contenedorTipo.createSequentialGroup()
        			.addComponent(botonServicioSocial)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(botonVoluntariado, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(69, Short.MAX_VALUE))
        );
        gl_contenedorTipo.setVerticalGroup(
        	gl_contenedorTipo.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contenedorTipo.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(gl_contenedorTipo.createParallelGroup(Alignment.BASELINE)
        				.addComponent(botonServicioSocial)
        				.addComponent(botonVoluntariado, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
        );
        contenedorTipo.setLayout(gl_contenedorTipo);
        
        ButtonGroup tipoProyecto = new ButtonGroup();
        tipoProyecto.add(botonServicioSocial);
        tipoProyecto.add(botonVoluntariado);
        
        JLabel lblNewLabel_1_1_5_3 = new JLabel("Transporte:");
        lblNewLabel_1_1_5_3.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_5_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JPanel contenedorTransporte = new JPanel();
        
        JRadioButton botonSiTransporte = new JRadioButton("S\u00ED");
        botonSiTransporte.setHorizontalAlignment(SwingConstants.LEFT);
        botonSiTransporte.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        
        JRadioButton botonNoTransporte = new JRadioButton("No");
        botonNoTransporte.setHorizontalAlignment(SwingConstants.LEFT);
        botonNoTransporte.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        GroupLayout gl_contenedorTransporte = new GroupLayout(contenedorTransporte);
        gl_contenedorTransporte.setHorizontalGroup(
        	gl_contenedorTransporte.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 106, Short.MAX_VALUE)
        		.addGroup(gl_contenedorTransporte.createSequentialGroup()
        			.addComponent(botonSiTransporte)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(botonNoTransporte, GroupLayout.PREFERRED_SIZE, 55, Short.MAX_VALUE)
        			.addContainerGap())
        );
        gl_contenedorTransporte.setVerticalGroup(
        	gl_contenedorTransporte.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 39, Short.MAX_VALUE)
        		.addGroup(gl_contenedorTransporte.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(gl_contenedorTransporte.createParallelGroup(Alignment.LEADING)
        				.addComponent(botonSiTransporte, Alignment.TRAILING)
        				.addComponent(botonNoTransporte, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
        );
        
        ButtonGroup transporte = new ButtonGroup();
        tipoProyecto.add(botonSiTransporte);
        tipoProyecto.add(botonNoTransporte);
        
        contenedorTransporte.setLayout(gl_contenedorTransporte);
        
        JLabel lblNewLabel_1_1_5_4 = new JLabel("Almuerzo:");
        lblNewLabel_1_1_5_4.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_5_4.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JPanel contenedorAlmuerzo = new JPanel();
        
        JRadioButton botonSiAlmuerzo = new JRadioButton("S\u00ED");
        botonSiAlmuerzo.setHorizontalAlignment(SwingConstants.LEFT);
        botonSiAlmuerzo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        
        JRadioButton botonNoAlmuerzo = new JRadioButton("No");
        botonNoAlmuerzo.setHorizontalAlignment(SwingConstants.LEFT);
        botonNoAlmuerzo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        GroupLayout gl_contenedorAlmuerzo = new GroupLayout(contenedorAlmuerzo);
        gl_contenedorAlmuerzo.setHorizontalGroup(
        	gl_contenedorAlmuerzo.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 106, Short.MAX_VALUE)
        		.addGroup(gl_contenedorAlmuerzo.createSequentialGroup()
        			.addComponent(botonSiAlmuerzo)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(botonNoAlmuerzo, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
        			.addContainerGap())
        );
        gl_contenedorAlmuerzo.setVerticalGroup(
        	gl_contenedorAlmuerzo.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 39, Short.MAX_VALUE)
        		.addGroup(gl_contenedorAlmuerzo.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(gl_contenedorAlmuerzo.createParallelGroup(Alignment.LEADING)
        				.addComponent(botonSiAlmuerzo, Alignment.TRAILING)
        				.addComponent(botonNoAlmuerzo, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
        );
        contenedorAlmuerzo.setLayout(gl_contenedorAlmuerzo);
        GroupLayout gl_contenedorRoundBottons = new GroupLayout(contenedorRoundBottons);
        gl_contenedorRoundBottons.setHorizontalGroup(
        	gl_contenedorRoundBottons.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contenedorRoundBottons.createSequentialGroup()
        			.addComponent(lblNewLabel_1_1_5)
        			.addGap(5)
        			.addComponent(contenedorTipo, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
        			.addGap(164)
        			.addComponent(lblNewLabel_1_1_5_3)
        			.addGap(5)
        			.addComponent(contenedorTransporte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(180)
        			.addComponent(lblNewLabel_1_1_5_4)
        			.addGap(5)
        			.addComponent(contenedorAlmuerzo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        gl_contenedorRoundBottons.setVerticalGroup(
        	gl_contenedorRoundBottons.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contenedorRoundBottons.createSequentialGroup()
        			.addGap(5)
        			.addGroup(gl_contenedorRoundBottons.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contenedorRoundBottons.createSequentialGroup()
        					.addGap(6)
        					.addComponent(lblNewLabel_1_1_5_3))
        				.addComponent(contenedorTransporte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_contenedorRoundBottons.createSequentialGroup()
        					.addGap(6)
        					.addComponent(lblNewLabel_1_1_5_4))
        				.addComponent(contenedorAlmuerzo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(contenedorTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_contenedorRoundBottons.createSequentialGroup()
        					.addGap(6)
        					.addComponent(lblNewLabel_1_1_5)))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        ButtonGroup almuerzo = new ButtonGroup();
        tipoProyecto.add(botonSiAlmuerzo);
        tipoProyecto.add(botonNoAlmuerzo);
        
        contenedorRoundBottons.setLayout(gl_contenedorRoundBottons);
        
        JLabel lblNewLabel_1_2 = new JLabel("Descripci\u00F3n del proyecto:");
        lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_2.setFont(new Font("Arial Unicode MS", Font.BOLD, 20));
        
        JLabel lblNewLabel_1_1_5_1 = new JLabel("Lugar:");
        lblNewLabel_1_1_5_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_5_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JLabel lblNewLabel_1_1_5_2 = new JLabel("Objetivo:");
        lblNewLabel_1_1_5_2.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_5_2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JLabel lblNewLabel_1_1_5_1_1 = new JLabel("T\u00EDtulo:");
        lblNewLabel_1_1_5_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_5_1_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JLabel lblNewLabel_1_1_5_1_2 = new JLabel("Resumen:");
        lblNewLabel_1_1_5_1_2.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_5_1_2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JLabel lblNewLabel_1_1_5_1_3 = new JLabel("Beneficiarios:");
        lblNewLabel_1_1_5_1_3.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_5_1_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JLabel lblNewLabel_1_1_5_1_4 = new JLabel("Contribuci\u00F3nODS:");
        lblNewLabel_1_1_5_1_4.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_5_1_4.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JLabel lblNewLabel_1_1_5_1_5 = new JLabel("Materiales:");
        lblNewLabel_1_1_5_1_5.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_5_1_5.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        tituloProyecto = new JTextField();
        tituloProyecto.setHorizontalAlignment(SwingConstants.LEFT);
        tituloProyecto.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        tituloProyecto.setColumns(10);
        
        lugarProyecto = new JTextField();
        lugarProyecto.setHorizontalAlignment(SwingConstants.LEFT);
        lugarProyecto.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        lugarProyecto.setColumns(10);
        
        JTextArea objetivo = new JTextArea();
        objetivo.setLineWrap(true);
        objetivo.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JTextArea resumen = new JTextArea();
        resumen.setLineWrap(true);
        resumen.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JTextArea beneficiarios = new JTextArea();
        beneficiarios.setLineWrap(true);
        beneficiarios.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JTextArea contribucionODS = new JTextArea();
        contribucionODS.setLineWrap(true);
        contribucionODS.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JTextArea materiales = new JTextArea();
        materiales.setLineWrap(true);
        materiales.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        GroupLayout gl_contenedorDescripcionDeProyecto = new GroupLayout(contenedorDescripcionDeProyecto);
        gl_contenedorDescripcionDeProyecto.setHorizontalGroup(
        	gl_contenedorDescripcionDeProyecto.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contenedorDescripcionDeProyecto.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_contenedorDescripcionDeProyecto.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contenedorDescripcionDeProyecto.createSequentialGroup()
        					.addGroup(gl_contenedorDescripcionDeProyecto.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblNewLabel_1_2, GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
        						.addGroup(gl_contenedorDescripcionDeProyecto.createSequentialGroup()
        							.addGroup(gl_contenedorDescripcionDeProyecto.createParallelGroup(Alignment.LEADING)
        								.addComponent(lblNewLabel_1_1_5_1)
        								.addComponent(lblNewLabel_1_1_5_1_1))
        							.addGap(11)
        							.addGroup(gl_contenedorDescripcionDeProyecto.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(lugarProyecto)
        								.addComponent(tituloProyecto, GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE))))
        					.addContainerGap())
        				.addGroup(gl_contenedorDescripcionDeProyecto.createSequentialGroup()
        					.addComponent(lblNewLabel_1_1_5_1_5, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(563, Short.MAX_VALUE))
        				.addGroup(gl_contenedorDescripcionDeProyecto.createSequentialGroup()
        					.addComponent(lblNewLabel_1_1_5_1_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addGap(556))
        				.addGroup(gl_contenedorDescripcionDeProyecto.createSequentialGroup()
        					.addComponent(lblNewLabel_1_1_5_2)
        					.addContainerGap(598, Short.MAX_VALUE))
        				.addGroup(gl_contenedorDescripcionDeProyecto.createSequentialGroup()
        					.addComponent(objetivo, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(gl_contenedorDescripcionDeProyecto.createSequentialGroup()
        					.addComponent(lblNewLabel_1_1_5_1_2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(574, Short.MAX_VALUE))
        				.addGroup(gl_contenedorDescripcionDeProyecto.createSequentialGroup()
        					.addComponent(resumen, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(27, Short.MAX_VALUE))
        				.addGroup(gl_contenedorDescripcionDeProyecto.createSequentialGroup()
        					.addComponent(lblNewLabel_1_1_5_1_4)
        					.addContainerGap(514, Short.MAX_VALUE))
        				.addGroup(gl_contenedorDescripcionDeProyecto.createSequentialGroup()
        					.addComponent(beneficiarios, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(27, Short.MAX_VALUE))
        				.addGroup(gl_contenedorDescripcionDeProyecto.createSequentialGroup()
        					.addComponent(contribucionODS, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(27, Short.MAX_VALUE))
        				.addGroup(gl_contenedorDescripcionDeProyecto.createSequentialGroup()
        					.addComponent(materiales, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(27, Short.MAX_VALUE))))
        );
        gl_contenedorDescripcionDeProyecto.setVerticalGroup(
        	gl_contenedorDescripcionDeProyecto.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contenedorDescripcionDeProyecto.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel_1_2)
        			.addGap(16)
        			.addGroup(gl_contenedorDescripcionDeProyecto.createParallelGroup(Alignment.BASELINE)
        				.addComponent(tituloProyecto, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNewLabel_1_1_5_1_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_contenedorDescripcionDeProyecto.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_1_1_5_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lugarProyecto, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(lblNewLabel_1_1_5_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(objetivo, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(lblNewLabel_1_1_5_1_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(resumen, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(lblNewLabel_1_1_5_1_3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        			.addGap(9)
        			.addComponent(beneficiarios, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblNewLabel_1_1_5_1_4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(contribucionODS, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        			.addGap(18)
        			.addComponent(lblNewLabel_1_1_5_1_5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(materiales, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        			.addGap(14))
        );
        contenedorDescripcionDeProyecto.setLayout(gl_contenedorDescripcionDeProyecto);
        
        JLabel lblNewLabel_1 = new JLabel("Encargado");
        lblNewLabel_1.setFont(new Font("Arial Unicode MS", Font.BOLD, 20));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel lblNewLabel_1_1 = new JLabel("Nombre:");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JLabel lblNewLabel_1_1_1 = new JLabel("C\u00E9dula:");
        lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JLabel lblNewLabel_1_1_2 = new JLabel("Cargo:");
        lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JLabel lblNewLabel_1_1_3 = new JLabel("Correo:");
        lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JLabel lblNewLabel_1_1_4 = new JLabel("Tel\u00E9fono:");
        lblNewLabel_1_1_4.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_4.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        nombreEncargado = new JTextField();
        nombreEncargado.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        nombreEncargado.setHorizontalAlignment(SwingConstants.LEFT);
        nombreEncargado.setColumns(10);
        
        cedulaEncargado = new JTextField();
        cedulaEncargado.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        cedulaEncargado.setHorizontalAlignment(SwingConstants.LEFT);
        cedulaEncargado.setColumns(10);
        
        cargoEncargado = new JTextField();
        cargoEncargado.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        cargoEncargado.setHorizontalAlignment(SwingConstants.LEFT);
        cargoEncargado.setColumns(10);
        
        correoEncargado = new JTextField();
        correoEncargado.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        correoEncargado.setHorizontalAlignment(SwingConstants.LEFT);
        correoEncargado.setColumns(10);
        
        telefonoEncargado = new JTextField();
        telefonoEncargado.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        telefonoEncargado.setHorizontalAlignment(SwingConstants.LEFT);
        telefonoEncargado.setColumns(10);
        GroupLayout gl_contenedorEncargado = new GroupLayout(contenedorEncargado);
        gl_contenedorEncargado.setHorizontalGroup(
        	gl_contenedorEncargado.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contenedorEncargado.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_contenedorEncargado.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contenedorEncargado.createSequentialGroup()
        					.addComponent(lblNewLabel_1_1)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(nombreEncargado, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE))
        				.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        				.addGroup(gl_contenedorEncargado.createSequentialGroup()
        					.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(cedulaEncargado, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_contenedorEncargado.createSequentialGroup()
        					.addComponent(lblNewLabel_1_1_4)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(telefonoEncargado, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_contenedorEncargado.createSequentialGroup()
        					.addGroup(gl_contenedorEncargado.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(lblNewLabel_1_1_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(lblNewLabel_1_1_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
        					.addGroup(gl_contenedorEncargado.createParallelGroup(Alignment.TRAILING)
        						.addComponent(cargoEncargado, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
        						.addComponent(correoEncargado, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap())
        );
        gl_contenedorEncargado.setVerticalGroup(
        	gl_contenedorEncargado.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contenedorEncargado.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel_1)
        			.addGap(18)
        			.addGroup(gl_contenedorEncargado.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(nombreEncargado))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_contenedorEncargado.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cedulaEncargado, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_contenedorEncargado.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cargoEncargado, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_contenedorEncargado.createParallelGroup(Alignment.LEADING)
        				.addComponent(correoEncargado, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNewLabel_1_1_3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_contenedorEncargado.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblNewLabel_1_1_4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(telefonoEncargado, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(369, Short.MAX_VALUE))
        );
        contenedorEncargado.setLayout(gl_contenedorEncargado);
        GroupLayout gl_contenedorFormulario = new GroupLayout(contenedorFormulario);
        gl_contenedorFormulario.setHorizontalGroup(
        	gl_contenedorFormulario.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contenedorFormulario.createSequentialGroup()
        			.addGap(10)
        			.addGroup(gl_contenedorFormulario.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contenedorFormulario.createSequentialGroup()
        					.addGroup(gl_contenedorFormulario.createParallelGroup(Alignment.LEADING)
        						.addComponent(contenedorEncargado, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
        						.addComponent(contenedorContribuyentes, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addComponent(contenedorDescripcionDeProyecto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addComponent(contenedorRoundBottons, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_contenedorFormulario.createSequentialGroup()
        					.addComponent(botonMenu)
        					.addGap(945)
        					.addComponent(botonEnviarPP))))
        );
        gl_contenedorFormulario.setVerticalGroup(
        	gl_contenedorFormulario.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contenedorFormulario.createSequentialGroup()
        			.addGroup(gl_contenedorFormulario.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contenedorFormulario.createSequentialGroup()
        					.addComponent(contenedorEncargado, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(contenedorContribuyentes, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
        				.addGroup(gl_contenedorFormulario.createSequentialGroup()
        					.addComponent(contenedorDescripcionDeProyecto, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
        					.addGap(4)))
        			.addGap(2)
        			.addComponent(contenedorRoundBottons, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        			.addGap(6)
        			.addGroup(gl_contenedorFormulario.createParallelGroup(Alignment.LEADING)
        				.addComponent(botonMenu)
        				.addComponent(botonEnviarPP))
        			.addGap(9))
        );
        contenedorFormulario.setLayout(gl_contenedorFormulario);
        GroupLayout gl_contenedorPrincipal = new GroupLayout(contenedorPrincipal);
        gl_contenedorPrincipal.setHorizontalGroup(
        	gl_contenedorPrincipal.createParallelGroup(Alignment.LEADING)
        		.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1171, Short.MAX_VALUE)
        );
        gl_contenedorPrincipal.setVerticalGroup(
        	gl_contenedorPrincipal.createParallelGroup(Alignment.LEADING)
        		.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 690, GroupLayout.PREFERRED_SIZE)
        );
        contenedorPrincipal.setLayout(gl_contenedorPrincipal);
    }
}



