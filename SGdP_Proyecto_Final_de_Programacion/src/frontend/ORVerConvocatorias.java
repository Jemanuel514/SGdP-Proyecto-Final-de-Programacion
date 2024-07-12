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

public class ORVerConvocatorias extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contenedorPrincipal;
    private JTable tablaConvocatorias;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ORVerConvocatorias frame = new ORVerConvocatorias();
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
	public ORVerConvocatorias() {
		setMaximumSize(new Dimension(1024, 768));
		setSize(new Dimension(1014, 737));
		setTitle("Ver convocatorias");
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
		
		JLabel lblNewLabel = new JLabel("CONVOCATORIAS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Artifakt Element", Font.BOLD, 40));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		
		JButton botonMenu = new JButton("Men\u00FA");
		botonMenu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		GroupLayout gl_contenedorPrincipal = new GroupLayout(contenedorPrincipal);
		gl_contenedorPrincipal.setHorizontalGroup(
			gl_contenedorPrincipal.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contenedorPrincipal.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contenedorPrincipal.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
						.addComponent(botonMenu))
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
					.addComponent(botonMenu)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		
		tablaConvocatorias = new JTable();
		tablaConvocatorias.setModel(new DefaultTableModel(
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
				"ID", "NOMBRE", "INSCRITOS"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablaConvocatorias.getColumnModel().getColumn(0).setResizable(false);
		tablaConvocatorias.getColumnModel().getColumn(1).setResizable(false);
		tablaConvocatorias.getColumnModel().getColumn(2).setResizable(false);
		tablaConvocatorias.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		scrollPane.setViewportView(tablaConvocatorias);
		contenedorPrincipal.setLayout(gl_contenedorPrincipal);
        
    }
}

