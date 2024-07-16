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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class ORVerConvocatorias extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contenedorPrincipal;
    private JTable tablaConvocatorias;
    private DefaultTableModel convocatoriasModelo;
    private JScrollPane contenedorTabla;
    private ManejoSQL db;
    private OrganismoReceptor usuario;

	/**
	 * Create the frame.
	 */
	public ORVerConvocatorias(OrganismoReceptor usuario, ManejoSQL db) {
		this.db = db;
		this.usuario = usuario;
		
		setMaximumSize(new Dimension(1024, 768));
		setSize(new Dimension(1014, 737));
		setTitle("Ver convocatorias");
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
	
		JLabel lblNewLabel = new JLabel("CONVOCATORIAS");
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
		
		//TABLA
				//General
						tablaConvocatorias = new JTable();
						tablaConvocatorias.setEnabled(false);
						tablaConvocatorias.setFont(ConstantesEstilo.texto);
						tablaConvocatorias.setBounds(40, 224, 929, 497);
						tablaConvocatorias.getTableHeader().setReorderingAllowed(false);
						
				        //Modelo de tabla (definiciÃ³n de columnas)
						convocatoriasModelo = new DefaultTableModel();
						convocatoriasModelo.setColumnIdentifiers(new String[] {"ID", "Título", "Inscritos"});
						tablaConvocatorias.setModel(convocatoriasModelo);
						
						//TÃ­tulos de columna
						JTableHeader encabezado = tablaConvocatorias.getTableHeader();
				        encabezado.setFont(new Font("Arial Unicode MS", Font.BOLD, 20));
						
						//Personalizar columnas
						DefaultTableCellRenderer centrarCelda = new DefaultTableCellRenderer();
						centrarCelda.setHorizontalAlignment(SwingConstants.CENTER);
						
						tablaConvocatorias.getColumnModel().getColumn(0).setPreferredWidth(50);
						tablaConvocatorias.getColumnModel().getColumn(1).setPreferredWidth(475);
						tablaConvocatorias.getColumnModel().getColumn(2).setPreferredWidth(250);
						tablaConvocatorias.getColumnModel().getColumn(0).setCellRenderer(centrarCelda);
						tablaConvocatorias.getColumnModel().getColumn(2).setCellRenderer(centrarCelda);
						
						//Personalizar filas
						tablaConvocatorias.setRowHeight(30);
						
						tablaConvocatorias.addMouseListener(new MouseAdapter() {
				            public void mouseClicked(MouseEvent e) {
				            	
				            	if (e.getClickCount() == 1) {									//un clic sobre inscritos debe abrir interfaz ORVerInscripciones
				                    int fila = tablaConvocatorias.rowAtPoint(e.getPoint());
				                    int columna = tablaConvocatorias.columnAtPoint(e.getPoint());
				                    if (columna == 2) {											//Columna de acción 
				                    	dispose();
				        				ORVerInscripciones verInscritos = new ORVerInscripciones(usuario, (int) tablaConvocatorias.getValueAt(fila, 0), db);
				        				verInscritos.setVisible(true);
				                    }
				                }
				            }
				        });
		
		contenedorTabla = new JScrollPane(tablaConvocatorias);
						
		verConvocatorias();
					    
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
						.addComponent(botonMenu))
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
					.addComponent(botonMenu)
					.addContainerGap(16, Short.MAX_VALUE))
		);
	
		contenedorPrincipal.setLayout(gl_contenedorPrincipal);
		
    }
	
	public void verConvocatorias() {
		String inscritos = "";
		try {
			//Consulta de datos
			db.consultarDatos("SELECT Convocatorias.id,Proyectos.titulo,count(estudiante_id) as Inscritos, Proyectos.estudiantes FROM Convocatorias "
								+ "INNER JOIN Proyectos on Convocatorias.proyecto_id = Proyectos.id "
								+ "INNER JOIN Inscripciones on Convocatorias.id = Inscripciones.convocatoria_id "
								+ "INNER JOIN Usuarios on Proyectos.or_id = Usuarios.id "
								+ "WHERE Proyectos.or_id = " + usuario.getId() 
								+ " GROUP by Convocatorias.id"); 
			//Búsqueda de credenciales
			while(db.datos.next()) {
				inscritos = db.datos.getInt("Inscritos") + "/" + db.datos.getInt("estudiantes");
				
				Object[] convocatoria = {db.datos.getInt("id"), db.datos.getString("titulo"),inscritos};
		        convocatoriasModelo.addRow(convocatoria);
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

