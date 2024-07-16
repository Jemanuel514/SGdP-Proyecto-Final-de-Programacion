package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import backend.ManejoSQL;
import backend.OrganismoReceptor;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class ORVerInscripciones extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contenedorPrincipal;
    private JTable tablaInscripciones;
    private DefaultTableModel inscripcionesModelo;
    private JScrollPane contenedorTabla;
    private ManejoSQL db;
    private OrganismoReceptor usuario;

	/**
	 * Create the frame.
	 */
	public ORVerInscripciones(OrganismoReceptor usuario, int idConvocatoria, ManejoSQL db) {
		this.db = db;
		this.usuario = usuario;
		
		setMaximumSize(new Dimension(1024, 768));
		setSize(new Dimension(1014, 737));
		setTitle("Ver inscripciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024,768);
        setResizable(false);
		setBounds(100, 100, 1024, 768);
		contenedorPrincipal = new JPanel();
		contenedorPrincipal.setPreferredSize(new Dimension(1010, 764));
		
		contenedorPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenedorPrincipal.setLayout(null);

		setContentPane(contenedorPrincipal);
		
		JLabel lblBienvenida = new JLabel("Bienvenido, " + usuario.getUsuario());
		lblBienvenida.setFont(ConstantesEstilo.texto);
		lblBienvenida.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblTipoUsuario = new JLabel("ORGANISMO RECEPTOR");
		lblTipoUsuario.setFont(ConstantesEstilo.texto);
		lblTipoUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNewLabel = new JLabel("INSCRPCIONES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Artifakt Element", Font.BOLD, 40));
		
		//JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		
		JButton botonMenu = new JButton("Men\u00FA");
		botonMenu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		botonMenu.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				dispose();
				ORMenuPrincipal menuOR = new ORMenuPrincipal(usuario, db);
				menuOR.setVisible(true);
  			}
  		});
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		botonVolver.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				dispose();
				ORVerConvocatorias convocatoriasOR = new ORVerConvocatorias(usuario, db);
				convocatoriasOR.setVisible(true);
  			}
  		});
	
		//TABLA
		//General
			tablaInscripciones = new JTable();
			tablaInscripciones.setEnabled(false);
			tablaInscripciones.setFont(ConstantesEstilo.texto);
			tablaInscripciones.setBounds(40, 224, 929, 497);
			tablaInscripciones.getTableHeader().setReorderingAllowed(false);
						
		//Modelo de tabla (definición de columnas)
			inscripcionesModelo = new DefaultTableModel();
			inscripcionesModelo.setColumnIdentifiers(new String[] {"Estudiante", "Correo", "Facultad"});
			tablaInscripciones.setModel(inscripcionesModelo);
						
		//Títulos de columna
			JTableHeader encabezado = tablaInscripciones.getTableHeader();
			encabezado.setFont(new Font("Arial Unicode MS", Font.BOLD, 20));
						
		//Personalizar columnas
			DefaultTableCellRenderer centrarCelda = new DefaultTableCellRenderer();
			centrarCelda.setHorizontalAlignment(SwingConstants.CENTER);
						
			tablaInscripciones.getColumnModel().getColumn(0).setPreferredWidth(50);
			tablaInscripciones.getColumnModel().getColumn(1).setPreferredWidth(475);
			tablaInscripciones.getColumnModel().getColumn(2).setPreferredWidth(250);
			tablaInscripciones.getColumnModel().getColumn(0).setCellRenderer(centrarCelda);
			tablaInscripciones.getColumnModel().getColumn(2).setCellRenderer(centrarCelda);
						
			contenedorTabla = new JScrollPane(tablaInscripciones);
		
			verInscritos(idConvocatoria);
			
		GroupLayout gl_contenedorPrincipal = new GroupLayout(contenedorPrincipal);
		gl_contenedorPrincipal.setHorizontalGroup(
			gl_contenedorPrincipal.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contenedorPrincipal.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contenedorPrincipal.createParallelGroup(Alignment.LEADING)
							.addComponent(lblBienvenida, 0, Short.MAX_VALUE, Short.MAX_VALUE)
							.addComponent(lblTipoUsuario, 0, Short.MAX_VALUE, Short.MAX_VALUE)
							.addComponent(contenedorTabla, GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
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
					.addComponent(lblBienvenida)
					.addComponent(lblTipoUsuario)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(contenedorTabla, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contenedorPrincipal.createParallelGroup(Alignment.LEADING)
						.addComponent(botonMenu)
						.addComponent(botonVolver, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		
	contenedorPrincipal.setLayout(gl_contenedorPrincipal);

    }
	public void verInscritos(int id) {
		try {
			//Consulta de datos
			db.consultarDatos("SELECT usuario,Usuarios.correo,facultad FROM Usuarios INNER JOIN Inscripciones on Inscripciones.estudiante_id = Usuarios.id WHERE Inscripciones.convocatoria_id = " + id); 
			//B�squeda de credenciales
			while(db.datos.next()) {
				
				Object[] inscripciones = {db.datos.getString("usuario"), db.datos.getString("correo"),db.datos.getString("facultad")};
		        inscripcionesModelo.addRow(inscripciones);
		        }
			}
		
		catch(SQLException e){
			System.out.println("Error al consultar la base de datos. " + e.getMessage());
		}
		
		finally {
			db.cerrarConexion();
		}
			
	}
	
}

