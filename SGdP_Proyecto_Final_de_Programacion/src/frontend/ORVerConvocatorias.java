package frontend;

import backend.ManejoSQL;
import backend.OrganismoReceptor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

import java.sql.SQLException;

public class ORVerConvocatorias extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable tabla_convocatorias;
    private DefaultTableModel convocatorias_modelo;

	public ORVerConvocatorias(OrganismoReceptor usuario, ManejoSQL db) {
		
		// JFrame
		setSize(ConstantesEstilo.ventana);
        setPreferredSize(ConstantesEstilo.ventana);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
		
		// Contenedor
		JPanel contenedor_principal = new JPanel();
		contenedor_principal.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contenedor_principal);
		
		// Etiquetas
		JLabel lbl_bienvenida = new JLabel("Bienvenido, " + usuario.getUsuario());
		lbl_bienvenida.setFont(ConstantesEstilo.texto);
		lbl_bienvenida.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lbl_tipo_usuario = new JLabel("ORGANISMO RECEPTOR");
		lbl_tipo_usuario.setFont(ConstantesEstilo.texto);
		lbl_tipo_usuario.setHorizontalAlignment(SwingConstants.RIGHT);
	
		JLabel lbl_convocatorias = new JLabel("CONVOCATORIAS");
		lbl_convocatorias.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_convocatorias.setFont(ConstantesEstilo.titulo);
		
		// Botones
		JButton boton_menu = new JButton("Menú");
		boton_menu.setFont(ConstantesEstilo.boton);
		boton_menu.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				dispose();
				ORMenuPrincipal menu_or = new ORMenuPrincipal(usuario, db);
				menu_or.setVisible(true);
  			}
  		});
		
		// Tabla
		tabla_convocatorias = new JTable();
		tabla_convocatorias.setEnabled(false);
		tabla_convocatorias.setFont(ConstantesEstilo.texto);
		tabla_convocatorias.getTableHeader().setReorderingAllowed(false);
		
        // Modelo de tabla (definición de columnas)
		convocatorias_modelo = new DefaultTableModel();
		convocatorias_modelo.setColumnIdentifiers(new String[] {"ID", "Título", ""});
		tabla_convocatorias.setModel(convocatorias_modelo);
		
		// Títulos de columna
		JTableHeader encabezado = tabla_convocatorias.getTableHeader();
        encabezado.setFont(ConstantesEstilo.subtitulo);
		
		// Personalizar columnas
		DefaultTableCellRenderer centrar_celda = new DefaultTableCellRenderer();
		centrar_celda.setHorizontalAlignment(SwingConstants.CENTER);
		
		tabla_convocatorias.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabla_convocatorias.getColumnModel().getColumn(1).setPreferredWidth(475);
		tabla_convocatorias.getColumnModel().getColumn(0).setCellRenderer(centrar_celda);
		tabla_convocatorias.getColumnModel().getColumn(2).setCellRenderer(centrar_celda);
		
		// Personalizar filas
		tabla_convocatorias.setRowHeight(30);
		
		// Función para ver los detalles de la convocatoria
		tabla_convocatorias.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {   	
            	if (e.getClickCount() == 1) {
                    int fila = tabla_convocatorias.rowAtPoint(e.getPoint());
                    int columna = tabla_convocatorias.columnAtPoint(e.getPoint());
                    
                    if (columna == 2) {
                    	dispose();
        				//ORVerInscripciones verInscritos = new ORVerInscripciones(usuario, (int) tabla_convocatorias.getValueAt(fila, 0), db);
        				//verInscritos.setVisible(true);
                    }
                }
            }
        });
		
		JScrollPane contenedor_tabla = new JScrollPane(tabla_convocatorias);
						
		buscarConvocatorias(usuario, db);
					    
		GroupLayout gl_contenedor_principal = new GroupLayout(contenedor_principal);
		
	    gl_contenedor_principal.setHorizontalGroup(gl_contenedor_principal.createParallelGroup()
	    		.addGroup(gl_contenedor_principal.createSequentialGroup()
	    				.addComponent(boton_menu, 150, 150, 150)
	    				.addGroup(gl_contenedor_principal.createParallelGroup()
	    						.addComponent(lbl_bienvenida, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    						.addComponent(lbl_tipo_usuario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
	    		
				.addComponent(lbl_convocatorias, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(contenedor_tabla, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
				
		gl_contenedor_principal.setVerticalGroup(gl_contenedor_principal.createSequentialGroup()
				.addGroup(gl_contenedor_principal.createParallelGroup()
						.addComponent(boton_menu)
						.addGroup(gl_contenedor_principal.createSequentialGroup()
								.addComponent(lbl_bienvenida)
	    						.addComponent(lbl_tipo_usuario)))
				
				.addComponent(lbl_bienvenida)
				.addComponent(lbl_tipo_usuario)
				.addComponent(lbl_convocatorias)
				.addComponent(contenedor_tabla, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		
		contenedor_principal.setLayout(gl_contenedor_principal);
		
    }
	
	public void buscarConvocatorias(OrganismoReceptor usuario, ManejoSQL db) {
		
		try {
			// Consulta de datos
			db.consultarDatos("SELECT Convocatorias.id, Proyectos.titulo FROM Convocatorias INNER JOIN Proyectos on Convocatorias.proyecto_id = Proyectos.id WHERE Proyectos.or_id = " + usuario.getId()); 
			
			while(db.datos.next()) {
				Object[] convocatoria = {db.datos.getInt("id"), db.datos.getString("titulo"), "Ver convocatoria"};
		        convocatorias_modelo.addRow(convocatoria);
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

