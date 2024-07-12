package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class ORVerInscripciones extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contenedorPrincipal;
    private JTable tablaInscripciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ORVerInscripciones frame = new ORVerInscripciones();
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
	public ORVerInscripciones() {
		setMaximumSize(new Dimension(1024, 768));
		setSize(new Dimension(1014, 737));
		setTitle("Ver inscripciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024,768);
        setResizable(false);
		setBounds(100, 100, 1024, 768);
		contenedorPrincipal = new JPanel();
		contenedorPrincipal.setPreferredSize(new Dimension(1010, 764));
		contenedorPrincipal.setMinimumSize(new Dimension(1010, 764));
		contenedorPrincipal.setMaximumSize(new Dimension(1010, 764));
		contenedorPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenedorPrincipal.setLayout(null);

		setContentPane(contenedorPrincipal);
		
		JLabel lblNewLabel = new JLabel("INSCRPCIONES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Artifakt Element", Font.BOLD, 40));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		
		JButton botonMenu = new JButton("Men\u00FA");
		botonMenu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		GroupLayout gl_contenedorPrincipal = new GroupLayout(contenedorPrincipal);
		gl_contenedorPrincipal.setHorizontalGroup(
			gl_contenedorPrincipal.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contenedorPrincipal.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contenedorPrincipal.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
						.addGroup(gl_contenedorPrincipal.createSequentialGroup()
							.addComponent(botonMenu)
							.addPreferredGap(ComponentPlacement.RELATED, 800, Short.MAX_VALUE)
							.addComponent(botonVolver)))
					.addContainerGap())
		);
		gl_contenedorPrincipal.setVerticalGroup(
			gl_contenedorPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contenedorPrincipal.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 562, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contenedorPrincipal.createParallelGroup(Alignment.LEADING)
						.addComponent(botonMenu)
						.addComponent(botonVolver, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		
		tablaInscripciones = new JTable();
		tablaInscripciones.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ESTUDIANTE", "CORREO", "FACULTAD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablaInscripciones.getColumnModel().getColumn(0).setResizable(false);
		tablaInscripciones.getColumnModel().getColumn(1).setResizable(false);
		tablaInscripciones.getColumnModel().getColumn(2).setResizable(false);
		tablaInscripciones.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		scrollPane.setViewportView(tablaInscripciones);
		contenedorPrincipal.setLayout(gl_contenedorPrincipal);

    }
}

