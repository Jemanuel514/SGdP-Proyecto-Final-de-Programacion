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

public class ORVerProyectos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contenedorPrincipal;
    private JTable tablaProyectos;
    private DefaultTableModel proyectosModelo;
    private JScrollPane contenedorTabla;
    private ManejoSQL db;
    private OrganismoReceptor usuario;

	/**
	 * Create the frame.
	 */
	public ORVerProyectos(OrganismoReceptor usuario, ManejoSQL db) {
		this.db = db;
		this.usuario = usuario;
		
		setMaximumSize(new Dimension(1024, 768));
		setSize(new Dimension(1014, 737));
		setTitle("Ver proyectos");
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
	
		JLabel lblNewLabel = new JLabel("PROYECTOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Artifakt Element", Font.BOLD, 40));
		
		//JScrollPane contenedorTabla = new JScrollPane();
		//contenedorTabla.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		
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
				tablaProyectos = new JTable();
				tablaProyectos.setEnabled(false);
				tablaProyectos.setFont(ConstantesEstilo.texto);
				tablaProyectos.setBounds(40, 224, 929, 497);
				tablaProyectos.getTableHeader().setReorderingAllowed(false);
				
		        //Modelo de tabla (definiciÃ³n de columnas)
				proyectosModelo = new DefaultTableModel();
				proyectosModelo.setColumnIdentifiers(new String[] {"ID", "Título", "Estado", "Evaluación"});
				tablaProyectos.setModel(proyectosModelo);
				
				//TÃ­tulos de columna
				JTableHeader encabezado = tablaProyectos.getTableHeader();
		        encabezado.setFont(new Font("Arial Unicode MS", Font.BOLD, 20));
				
				//Personalizar columnas
				DefaultTableCellRenderer centrarCelda = new DefaultTableCellRenderer();
				centrarCelda.setHorizontalAlignment(SwingConstants.CENTER);
				
				tablaProyectos.getColumnModel().getColumn(0).setPreferredWidth(50);
				tablaProyectos.getColumnModel().getColumn(1).setPreferredWidth(475);
				tablaProyectos.getColumnModel().getColumn(2).setPreferredWidth(250);
				tablaProyectos.getColumnModel().getColumn(0).setCellRenderer(centrarCelda);
				tablaProyectos.getColumnModel().getColumn(2).setCellRenderer(centrarCelda);
				tablaProyectos.getColumnModel().getColumn(3).setCellRenderer(centrarCelda);
				
				//Personalizar filas
				tablaProyectos.setRowHeight(30);
				
				tablaProyectos.addMouseListener(new MouseAdapter() {
		            public void mouseClicked(MouseEvent e) {
		            	String motivo = "";
		            	if (e.getClickCount() == 2) {									//Doble clic
		                    int fila = tablaProyectos.rowAtPoint(e.getPoint());
		                    int columna = tablaProyectos.columnAtPoint(e.getPoint());
		                    if (columna == 3) {											//Columna de acciÃ³n
		                    	if (tablaProyectos.getValueAt(fila, columna).equals("Rechazado") ) {
		                    		db.consultarDatos("SELECT motivo FROM Evaluaciones INNER JOIN Proyectos on Evaluaciones.id = Proyectos.evaluacion_id WHERE Proyectos.id = " + tablaProyectos.getValueAt(fila, 0));
			                    	try {
										motivo = db.datos.getString("motivo");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
		                    		JOptionPane.showMessageDialog(null, "Su proyecto fue rechazado por: " + motivo, "", JOptionPane.INFORMATION_MESSAGE);
		                    			db.cerrarConexion();
		                    	}
		                    	
		                    }
		                }
		            }
		        });
				
				contenedorTabla = new JScrollPane(tablaProyectos);
					
			    buscarPropuestas();
			    
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
	public void buscarPropuestas() {
		String estado;
		int evaluacion;
		String calificacion;
		
		try {
			//Consulta de datos
			db.consultarDatos("SELECT Proyectos.id,titulo,evaluacion_id,aprobado FROM Proyectos LEFT JOIN Evaluaciones on Proyectos.evaluacion_id = Evaluaciones.id WHERE Proyectos.or_id = " + usuario.getId());
			
			//Búsqueda de credenciales
			while(db.datos.next()) {
				evaluacion = db.datos.getInt("evaluacion_id");
				if (db.datos.wasNull()) {
					estado = "En revisión"; 
					calificacion = "";
				} else {
					estado = "Evaluado";
					calificacion = db.datos.getInt("aprobado") == 1 ? "Aprobado" : "Rechazado";
				}
			
				Object[] propuesta = {db.datos.getInt("id"), db.datos.getString("titulo"), estado, calificacion};
		        proyectosModelo.addRow(propuesta);
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

