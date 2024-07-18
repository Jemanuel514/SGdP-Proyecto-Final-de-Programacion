package frontend;

import backend.DSSU;
import backend.ManejoSQL;

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

public class DSSUPropuestasSinEvaluar extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTable tabla_propuestas;
	private DefaultTableModel propuestas_modelo;

	public DSSUPropuestasSinEvaluar(DSSU usuario, ManejoSQL db) {
		
		// JFrame
		setSize(ConstantesEstilo.ventana);
        setPreferredSize(ConstantesEstilo.ventana);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
		
		// Contenedor
        JPanel contenedor = new JPanel();
        contenedor.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contenedor);
		
		// Etiquetas
		JLabel lbl_bienvenida = new JLabel("Bienvenido, " + usuario.getUsuario());
		lbl_bienvenida.setFont(ConstantesEstilo.texto);
		lbl_bienvenida.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lbl_tipo_usuario = new JLabel("DSSU");
		lbl_tipo_usuario.setFont(ConstantesEstilo.texto);
		lbl_tipo_usuario.setHorizontalAlignment(SwingConstants.RIGHT);
	
		JLabel lbl_propuestas = new JLabel("Propuestas Sin Evaluar");
		lbl_propuestas.setFont(ConstantesEstilo.titulo);
		lbl_propuestas.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Botones		
		JButton boton_menu = new JButton("Menú");
		boton_menu.setFont(ConstantesEstilo.boton);
		boton_menu.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				dispose();
				DSSUMenuPrincipal menu_dssu = new DSSUMenuPrincipal(usuario, db);
				menu_dssu.setVisible(true);
  			}
  		});
		
		// Tabla
		tabla_propuestas = new JTable();
		tabla_propuestas.setEnabled(false);
		tabla_propuestas.setFont(ConstantesEstilo.texto);
		
        // Modelo de tabla (definición de columnas)
		propuestas_modelo = new DefaultTableModel();
		propuestas_modelo.setColumnIdentifiers(new String[] {"ID", "Título", "Organismo Receptor", ""});
		tabla_propuestas.setModel(propuestas_modelo);
		
		// Títulos de columna
		JTableHeader encabezado = tabla_propuestas.getTableHeader();
        encabezado.setFont(ConstantesEstilo.subtitulo);
        encabezado.setReorderingAllowed(false);
		
		// Personalizar columnas
		DefaultTableCellRenderer centrar_celda = new DefaultTableCellRenderer();
		centrar_celda.setHorizontalAlignment(SwingConstants.CENTER);
		
		tabla_propuestas.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabla_propuestas.getColumnModel().getColumn(1).setPreferredWidth(475);
		tabla_propuestas.getColumnModel().getColumn(2).setPreferredWidth(250);
		tabla_propuestas.getColumnModel().getColumn(0).setCellRenderer(centrar_celda);
		tabla_propuestas.getColumnModel().getColumn(2).setCellRenderer(centrar_celda);
		tabla_propuestas.getColumnModel().getColumn(3).setCellRenderer(centrar_celda);
		
		// Personalizar filas
		tabla_propuestas.setRowHeight(30);
		
		// Celda clickeable
		tabla_propuestas.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int fila = tabla_propuestas.rowAtPoint(e.getPoint());
                    int columna = tabla_propuestas.columnAtPoint(e.getPoint());

                    if (columna == 3) {
                    	dispose();
        				DSSUEvaluarPropuesta evaluar_propuesta = new DSSUEvaluarPropuesta(usuario, (int) tabla_propuestas.getValueAt(fila, 0), db);
        				evaluar_propuesta.setVisible(true);
                    }
                }
            }
        });
		
		JScrollPane contenedor_tabla = new JScrollPane(tabla_propuestas);
		
        buscarPropuestas(db);
        
        GroupLayout gl_contenedor_principal = new GroupLayout(contenedor);
		
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
		
		contenedor.setLayout(gl_contenedor_principal);		
	}
	
	public void buscarPropuestas(ManejoSQL db) {

		try {
			//Consulta de datos
			db.consultarDatos("SELECT Proyectos.id, titulo, usuario FROM Proyectos INNER JOIN Usuarios ON Proyectos.or_id = Usuarios.id WHERE Proyectos.evaluacion_id IS NULL");
			
			//Búsqueda de credenciales
			while(db.datos.next()) {
				Object[] propuesta = {db.datos.getInt("id"), db.datos.getString("titulo"), db.datos.getString("usuario"), "Evaluar"};
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