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
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dimension;

public class ProponerProyecto extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JScrollPane scrollPane;
    private JLabel lblNewLabel;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;

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
        contentPane = new JPanel();
        contentPane.setSize(new Dimension(1024, 768));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        
        setContentPane(contentPane);
        
        scrollPane = new JScrollPane();
        scrollPane.setSize(new Dimension(1024, 768));
        
        lblNewLabel = new JLabel("PROPUESTA DE PROYECTO");
        lblNewLabel.setFont(new Font("Artifakt Element", Font.BOLD, 40));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scrollPane.setColumnHeaderView(lblNewLabel);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1171, GroupLayout.PREFERRED_SIZE)
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 690, GroupLayout.PREFERRED_SIZE)
        );
        
        JPanel panel = new JPanel();
        panel.setSize(new Dimension(1024, 768));
        scrollPane.setViewportView(panel);
        
        JPanel panel_1 = new JPanel();
        
        JPanel panel_2 = new JPanel();
        
        JPanel panel_1_1 = new JPanel();
        
        JLabel lblNewLabel_1_1_6 = new JLabel("Cantidad de estudiantes:");
        lblNewLabel_1_1_6.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_6.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        textField_7 = new JTextField();
        textField_7.setHorizontalAlignment(SwingConstants.LEFT);
        textField_7.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        textField_7.setColumns(10);
        
        JLabel lblNewLabel_1_3 = new JLabel("Contribuyentes");
        lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_3.setFont(new Font("Arial Unicode MS", Font.BOLD, 20));
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Facultad:");
        lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_1_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JLabel lblNewLabel_1_1_2_1 = new JLabel("Perfil estudiantil");
        lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_2_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"TODAS", "FCT", "FIC", "FIE", "FII", "FIM", "FISC"}));
        comboBox.setToolTipText("");
        comboBox.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JTextArea textArea_3_1 = new JTextArea();
        textArea_3_1.setLineWrap(true);
        textArea_3_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
        gl_panel_1_1.setHorizontalGroup(
        	gl_panel_1_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_panel_1_1.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
        				.addComponent(textArea_3_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
        				.addComponent(lblNewLabel_1_1_2_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        				.addGroup(Alignment.LEADING, gl_panel_1_1.createSequentialGroup()
        					.addComponent(lblNewLabel_1_1_6)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
        				.addComponent(lblNewLabel_1_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        				.addGroup(Alignment.LEADING, gl_panel_1_1.createSequentialGroup()
        					.addComponent(lblNewLabel_1_1_1_1)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(comboBox, 0, 333, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        gl_panel_1_1.setVerticalGroup(
        	gl_panel_1_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1_1.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel_1_3)
        			.addGap(18)
        			.addGroup(gl_panel_1_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblNewLabel_1_1_6, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panel_1_1.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(textArea_3_1, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
        			.addContainerGap())
        );
        panel_1_1.setLayout(gl_panel_1_1);
        
        JPanel panel_3 = new JPanel();
        
        JButton btnNewButton = new JButton("Enviar");
        btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel.createSequentialGroup()
        					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
        						.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 687, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(20, Short.MAX_VALUE))
        				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
        					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
        						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
        							.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED, 945, Short.MAX_VALUE)
        							.addComponent(btnNewButton)
        							.addGap(10))
        						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addGap(20))))
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        				.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 533, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_panel.createSequentialGroup()
        					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
        					.addGap(2)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnNewButton))
        			.addGap(26))
        );
        
        JLabel lblNewLabel_1_1_5 = new JLabel("Tipo:");
        lblNewLabel_1_1_5.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_5.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JPanel panel_3_1 = new JPanel();
        
        JRadioButton rdbtnServicioSocial = new JRadioButton("Servicio social");
        rdbtnServicioSocial.setHorizontalAlignment(SwingConstants.LEFT);
        rdbtnServicioSocial.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        
        JRadioButton rdbtnVoluntariado = new JRadioButton("Voluntariado");
        rdbtnVoluntariado.setHorizontalAlignment(SwingConstants.LEFT);
        rdbtnVoluntariado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        GroupLayout gl_panel_3_1 = new GroupLayout(panel_3_1);
        gl_panel_3_1.setHorizontalGroup(
        	gl_panel_3_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_3_1.createSequentialGroup()
        			.addComponent(rdbtnServicioSocial)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(rdbtnVoluntariado, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(69, Short.MAX_VALUE))
        );
        gl_panel_3_1.setVerticalGroup(
        	gl_panel_3_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_3_1.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(gl_panel_3_1.createParallelGroup(Alignment.BASELINE)
        				.addComponent(rdbtnServicioSocial)
        				.addComponent(rdbtnVoluntariado, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
        );
        panel_3_1.setLayout(gl_panel_3_1);
        
        ButtonGroup tipoProyecto = new ButtonGroup();
        tipoProyecto.add(rdbtnServicioSocial);
        tipoProyecto.add(rdbtnVoluntariado);
        
        JLabel lblNewLabel_1_1_5_3 = new JLabel("Transporte:");
        lblNewLabel_1_1_5_3.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_5_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JPanel panel_3_1_1 = new JPanel();
        
        JRadioButton botonSiTransporte = new JRadioButton("S\u00ED");
        botonSiTransporte.setHorizontalAlignment(SwingConstants.LEFT);
        botonSiTransporte.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        
        JRadioButton botonNoTransporte = new JRadioButton("No");
        botonNoTransporte.setHorizontalAlignment(SwingConstants.LEFT);
        botonNoTransporte.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        GroupLayout gl_panel_3_1_1 = new GroupLayout(panel_3_1_1);
        gl_panel_3_1_1.setHorizontalGroup(
        	gl_panel_3_1_1.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 106, Short.MAX_VALUE)
        		.addGroup(gl_panel_3_1_1.createSequentialGroup()
        			.addComponent(botonSiTransporte)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(botonNoTransporte, GroupLayout.PREFERRED_SIZE, 55, Short.MAX_VALUE)
        			.addContainerGap())
        );
        gl_panel_3_1_1.setVerticalGroup(
        	gl_panel_3_1_1.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 39, Short.MAX_VALUE)
        		.addGroup(gl_panel_3_1_1.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(gl_panel_3_1_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(botonSiTransporte, Alignment.TRAILING)
        				.addComponent(botonNoTransporte, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
        );
        
        ButtonGroup transporte = new ButtonGroup();
        tipoProyecto.add(botonSiTransporte);
        tipoProyecto.add(botonNoTransporte);
        
        panel_3_1_1.setLayout(gl_panel_3_1_1);
        
        JLabel lblNewLabel_1_1_5_4 = new JLabel("Almuerzo:");
        lblNewLabel_1_1_5_4.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_5_4.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JPanel panel_3_1_1_1 = new JPanel();
        
        JRadioButton botonSiAlmuerzo = new JRadioButton("S\u00ED");
        botonSiAlmuerzo.setHorizontalAlignment(SwingConstants.LEFT);
        botonSiAlmuerzo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        
        JRadioButton botonNoAlmuerzo = new JRadioButton("No");
        botonNoAlmuerzo.setHorizontalAlignment(SwingConstants.LEFT);
        botonNoAlmuerzo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        GroupLayout gl_panel_3_1_1_1 = new GroupLayout(panel_3_1_1_1);
        gl_panel_3_1_1_1.setHorizontalGroup(
        	gl_panel_3_1_1_1.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 106, Short.MAX_VALUE)
        		.addGroup(gl_panel_3_1_1_1.createSequentialGroup()
        			.addComponent(botonSiAlmuerzo)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(botonNoAlmuerzo, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
        			.addContainerGap())
        );
        gl_panel_3_1_1_1.setVerticalGroup(
        	gl_panel_3_1_1_1.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 39, Short.MAX_VALUE)
        		.addGroup(gl_panel_3_1_1_1.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(gl_panel_3_1_1_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(botonSiAlmuerzo, Alignment.TRAILING)
        				.addComponent(botonNoAlmuerzo, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
        );
        panel_3_1_1_1.setLayout(gl_panel_3_1_1_1);
        GroupLayout gl_panel_3 = new GroupLayout(panel_3);
        gl_panel_3.setHorizontalGroup(
        	gl_panel_3.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_3.createSequentialGroup()
        			.addComponent(lblNewLabel_1_1_5)
        			.addGap(5)
        			.addComponent(panel_3_1, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
        			.addGap(164)
        			.addComponent(lblNewLabel_1_1_5_3)
        			.addGap(5)
        			.addComponent(panel_3_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(180)
        			.addComponent(lblNewLabel_1_1_5_4)
        			.addGap(5)
        			.addComponent(panel_3_1_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        gl_panel_3.setVerticalGroup(
        	gl_panel_3.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_3.createSequentialGroup()
        			.addGap(5)
        			.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_3.createSequentialGroup()
        					.addGap(6)
        					.addComponent(lblNewLabel_1_1_5_3))
        				.addComponent(panel_3_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_panel_3.createSequentialGroup()
        					.addGap(6)
        					.addComponent(lblNewLabel_1_1_5_4))
        				.addComponent(panel_3_1_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(panel_3_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_panel_3.createSequentialGroup()
        					.addGap(6)
        					.addComponent(lblNewLabel_1_1_5)))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        ButtonGroup almuerzo = new ButtonGroup();
        tipoProyecto.add(botonSiAlmuerzo);
        tipoProyecto.add(botonNoAlmuerzo);
        
        panel_3.setLayout(gl_panel_3);
        
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
        
        textField_5 = new JTextField();
        textField_5.setHorizontalAlignment(SwingConstants.LEFT);
        textField_5.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        textField_5.setColumns(10);
        
        textField_6 = new JTextField();
        textField_6.setHorizontalAlignment(SwingConstants.LEFT);
        textField_6.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        textField_6.setColumns(10);
        
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JTextArea textArea_1 = new JTextArea();
        textArea_1.setLineWrap(true);
        textArea_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JTextArea textArea_2 = new JTextArea();
        textArea_2.setLineWrap(true);
        textArea_2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JTextArea textArea_3 = new JTextArea();
        textArea_3.setLineWrap(true);
        textArea_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        
        JTextArea textArea_4 = new JTextArea();
        textArea_4.setLineWrap(true);
        textArea_4.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(
        	gl_panel_2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_2.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblNewLabel_1_2, GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
        						.addGroup(gl_panel_2.createSequentialGroup()
        							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
        								.addComponent(lblNewLabel_1_1_5_1)
        								.addComponent(lblNewLabel_1_1_5_1_1))
        							.addGap(11)
        							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(textField_6)
        								.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE))))
        					.addContainerGap())
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addComponent(lblNewLabel_1_1_5_1_5, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(563, Short.MAX_VALUE))
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addComponent(lblNewLabel_1_1_5_1_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addGap(556))
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addComponent(lblNewLabel_1_1_5_2)
        					.addContainerGap(598, Short.MAX_VALUE))
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addComponent(lblNewLabel_1_1_5_1_2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(574, Short.MAX_VALUE))
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(27, Short.MAX_VALUE))
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addComponent(lblNewLabel_1_1_5_1_4)
        					.addContainerGap(514, Short.MAX_VALUE))
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addComponent(textArea_2, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(27, Short.MAX_VALUE))
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addComponent(textArea_3, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(27, Short.MAX_VALUE))
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addComponent(textArea_4, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(27, Short.MAX_VALUE))))
        );
        gl_panel_2.setVerticalGroup(
        	gl_panel_2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_2.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel_1_2)
        			.addGap(16)
        			.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
        				.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNewLabel_1_1_5_1_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_1_1_5_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(lblNewLabel_1_1_5_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(lblNewLabel_1_1_5_1_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(textArea_1, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(lblNewLabel_1_1_5_1_3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        			.addGap(9)
        			.addComponent(textArea_2, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblNewLabel_1_1_5_1_4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(textArea_3, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        			.addGap(18)
        			.addComponent(lblNewLabel_1_1_5_1_5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(textArea_4, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        			.addGap(14))
        );
        panel_2.setLayout(gl_panel_2);
        
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
        
        textField = new JTextField();
        textField.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        textField.setHorizontalAlignment(SwingConstants.LEFT);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        textField_1.setHorizontalAlignment(SwingConstants.LEFT);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        textField_2.setHorizontalAlignment(SwingConstants.LEFT);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        textField_3.setHorizontalAlignment(SwingConstants.LEFT);
        textField_3.setColumns(10);
        
        textField_4 = new JTextField();
        textField_4.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        textField_4.setHorizontalAlignment(SwingConstants.LEFT);
        textField_4.setColumns(10);
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addComponent(lblNewLabel_1_1)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE))
        				.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addComponent(lblNewLabel_1_1_4)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(lblNewLabel_1_1_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(lblNewLabel_1_1_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
        						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap())
        );
        gl_panel_1.setVerticalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel_1)
        			.addGap(18)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textField))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNewLabel_1_1_3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblNewLabel_1_1_4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(369, Short.MAX_VALUE))
        );
        panel_1.setLayout(gl_panel_1);
        panel.setLayout(gl_panel);
        contentPane.setLayout(gl_contentPane);
    }
}



