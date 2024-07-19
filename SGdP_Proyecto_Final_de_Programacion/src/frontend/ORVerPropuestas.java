package frontend;

import backend.ManejoSQL;
import backend.OrganismoReceptor;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.SQLException;

public class ORVerPropuestas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable tabla_propuestas;
    private DefaultTableModel propuestas_modelo;

	public ORVerPropuestas(OrganismoReceptor usuario, ManejoSQL db) {
		
		// JFrame
		setSize(ConstantesEstilo.VENTANA);
        setPreferredSize(ConstantesEstilo.VENTANA);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Contenedor
		JPanel contenedor_principal = new JPanel();
		contenedor_principal.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contenedor_principal);
		
		// Etiquetas
		JLabel lbl_bienvenida = new JLabel("Bienvenido, " + usuario.getUsuario());
		lbl_bienvenida.setFont(ConstantesEstilo.TEXTO);
		lbl_bienvenida.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lbl_tipo_usuario = new JLabel("ORGANISMO RECEPTOR");
		lbl_tipo_usuario.setFont(ConstantesEstilo.TEXTO);
		lbl_tipo_usuario.setHorizontalAlignment(SwingConstants.RIGHT);
	
		JLabel lbl_propuestas = new JLabel("Propuestas");
		lbl_propuestas.setFont(ConstantesEstilo.TITULO);
		lbl_propuestas.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Botones		
		JButton boton_menu = new JButton("Menú");
		boton_menu.setFont(ConstantesEstilo.BOTON);
		boton_menu.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				dispose();
				ORMenuPrincipal menuOR = new ORMenuPrincipal(usuario, db);
				menuOR.setVisible(true);
  			}
  		});

		// Tabla
		tabla_propuestas = new JTable();
		tabla_propuestas.setEnabled(false);
		tabla_propuestas.setFont(ConstantesEstilo.TEXTO);
		
        // Modelo de tabla (definición de columnas)
		propuestas_modelo = new DefaultTableModel();
		propuestas_modelo.setColumnIdentifiers(new String[] {"ID", "Título", "Estado", "Evaluación"});
		tabla_propuestas.setModel(propuestas_modelo);
		
		// Títulos de columna
		JTableHeader encabezado = tabla_propuestas.getTableHeader();
        encabezado.setFont(ConstantesEstilo.SUBTITULO);
        encabezado.setReorderingAllowed(false);
		
		// Personalizar columnas
		DefaultTableCellRenderer centrar_celda = new DefaultTableCellRenderer();
		centrar_celda.setHorizontalAlignment(SwingConstants.CENTER);
		
		tabla_propuestas.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabla_propuestas.getColumnModel().getColumn(1).setPreferredWidth(475);
		tabla_propuestas.getColumnModel().getColumn(2).setPreferredWidth(200);
		tabla_propuestas.getColumnModel().getColumn(0).setCellRenderer(centrar_celda);
		tabla_propuestas.getColumnModel().getColumn(2).setCellRenderer(centrar_celda);
		tabla_propuestas.getColumnModel().getColumn(3).setCellRenderer(centrar_celda);
				
		// Personalizar filas
		tabla_propuestas.setRowHeight(30);
		
		// Función para ver el motivo de rechazo
		tabla_propuestas.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	String motivo = "";
            	
            	if (e.getClickCount() == 1) {
                    int fila = tabla_propuestas.rowAtPoint(e.getPoint());
                    int columna = tabla_propuestas.columnAtPoint(e.getPoint());
                    
                    if (columna == 3) {
                    	// Solo los proyectos rechazados tienen motivo
                    	if (tabla_propuestas.getValueAt(fila, columna).equals("Rechazado")) {
                    		db.consultarDatos("SELECT motivo FROM Evaluaciones INNER JOIN Proyectos on Evaluaciones.id = Proyectos.evaluacion_id WHERE Proyectos.id = " + tabla_propuestas.getValueAt(fila, 0));
	                    	
                    		try {
								motivo = db.datos.getString("motivo");
							}
                    		catch (SQLException e1) {
								JOptionPane.showMessageDialog(null, "Error al consultar la base de datos.", "", JOptionPane.ERROR_MESSAGE);
							}
                    		
                    		JOptionPane.showMessageDialog(null, "Su proyecto fue rechazado por: " + motivo, "", JOptionPane.INFORMATION_MESSAGE);
                    			db.cerrarConexion();
                    	}
                    	
                    }
                }
            }
        });
		
		JScrollPane contenedor_tabla = new JScrollPane(tabla_propuestas);
		
	    buscarPropuestas(usuario, db);
	    
	    GroupLayout gl_contenedor_principal = new GroupLayout(contenedor_principal);
		
	    gl_contenedor_principal.setHorizontalGroup(gl_contenedor_principal.createParallelGroup()
	    		.addGroup(gl_contenedor_principal.createSequentialGroup()
	    				.addComponent(boton_menu, 150, 150, 150)
	    				.addGroup(gl_contenedor_principal.createParallelGroup()
	    						.addComponent(lbl_bienvenida, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    						.addComponent(lbl_tipo_usuario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
	    		
				.addComponent(lbl_propuestas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(contenedor_tabla, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
				
		gl_contenedor_principal.setVerticalGroup(gl_contenedor_principal.createSequentialGroup()
				.addGroup(gl_contenedor_principal.createParallelGroup()
						.addComponent(boton_menu)
						.addGroup(gl_contenedor_principal.createSequentialGroup()
								.addComponent(lbl_bienvenida)
	    						.addComponent(lbl_tipo_usuario)))
				
				.addComponent(lbl_bienvenida)
				.addComponent(lbl_tipo_usuario)
				.addComponent(lbl_propuestas)
				.addComponent(contenedor_tabla, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		
		contenedor_principal.setLayout(gl_contenedor_principal);
		
    }
	
	public void buscarPropuestas(OrganismoReceptor usuario, ManejoSQL db) {
		@SuppressWarnings("unused")
		int evaluacion_id;
		String estado;
		String calificacion;
		
		try {
			// Consulta de datos
			db.consultarDatos("SELECT Proyectos.id, titulo, evaluacion_id, aprobado FROM Proyectos LEFT JOIN Evaluaciones on Proyectos.evaluacion_id = Evaluaciones.id WHERE Proyectos.or_id = " + usuario.getId());
			
			while(db.datos.next()) {
				evaluacion_id = db.datos.getInt("evaluacion_id");
				
				// Si el proyecto no tiene un evaluacion_id asociado es porque no ha sido evaluado
				if (db.datos.wasNull()) {
					estado = "En revisión"; 
					calificacion = "";
				} else {
					estado = "Evaluado";
					calificacion = db.datos.getInt("aprobado") == 1 ? "Aprobado" : "Rechazado";
				}
			
				Object[] propuesta = {db.datos.getInt("id"), db.datos.getString("titulo"), estado, calificacion};
		        propuestas_modelo.addRow(propuesta);
		        }
			}
		
		catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
		}
		
		finally {
			db.cerrarConexion();
		}
			
	}
	
}

