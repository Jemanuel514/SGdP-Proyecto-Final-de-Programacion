package frontend;

import backend.DSSU;
import backend.ManejoSQL;

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

public class DSSUProyectosAprobados extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTable proyectos_aprobados;
	private DefaultTableModel proyectos_aprobados_modelo;

	public DSSUProyectosAprobados(DSSU usuario, ManejoSQL db) {
		
		// JFrame
		setSize(ConstantesEstilo.VENTANA);
        setPreferredSize(ConstantesEstilo.VENTANA);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
		
        // Contenedor
        JPanel contenedor = new JPanel();
        contenedor.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contenedor);
		
		// Etiquetas
		JLabel lbl_bienvenida = new JLabel("Bienvenido, " + usuario.getUsuario());
		lbl_bienvenida.setFont(ConstantesEstilo.TEXTO);
		lbl_bienvenida.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lbl_tipo_usuario = new JLabel("DSSU");
		lbl_tipo_usuario.setFont(ConstantesEstilo.TEXTO);
		lbl_tipo_usuario.setHorizontalAlignment(SwingConstants.RIGHT);
	
		JLabel lbl_propuestas = new JLabel("Proyectos Aprobados");
		lbl_propuestas.setFont(ConstantesEstilo.TITULO);
		lbl_propuestas.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Botones		
		JButton boton_menu = new JButton("Menú");
		boton_menu.setFont(ConstantesEstilo.BOTON);
		boton_menu.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				dispose();
				DSSUMenuPrincipal menu_dssu = new DSSUMenuPrincipal(usuario, db);
				menu_dssu.setVisible(true);
  			}
  		});
		
		// Tabla
		proyectos_aprobados = new JTable();
		proyectos_aprobados.setEnabled(false);
		proyectos_aprobados.setFont(ConstantesEstilo.TEXTO);
		
        // Modelo de tabla (definición de columnas)
		proyectos_aprobados_modelo = new DefaultTableModel();
		proyectos_aprobados_modelo.setColumnIdentifiers(new String[] {"ID", "Título", "Organismo Receptor", ""});
		proyectos_aprobados.setModel(proyectos_aprobados_modelo);
		
		// Títulos de columna
		JTableHeader encabezado = proyectos_aprobados.getTableHeader();
        encabezado.setFont(ConstantesEstilo.SUBTITULO);
        encabezado.setReorderingAllowed(false);
		
		// Personalizar columnas
		DefaultTableCellRenderer centrar_celda = new DefaultTableCellRenderer();
		centrar_celda.setHorizontalAlignment(SwingConstants.CENTER);
		
		proyectos_aprobados.getColumnModel().getColumn(0).setPreferredWidth(50);
		proyectos_aprobados.getColumnModel().getColumn(1).setPreferredWidth(475);
		proyectos_aprobados.getColumnModel().getColumn(2).setPreferredWidth(250);
		proyectos_aprobados.getColumnModel().getColumn(0).setCellRenderer(centrar_celda);
		proyectos_aprobados.getColumnModel().getColumn(2).setCellRenderer(centrar_celda);
		proyectos_aprobados.getColumnModel().getColumn(3).setCellRenderer(centrar_celda);
		
		// Personalizar filas
		proyectos_aprobados.setRowHeight(30);
		
		// Celda clickeable
		proyectos_aprobados.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int fila = proyectos_aprobados.rowAtPoint(e.getPoint());
                    int columna = proyectos_aprobados.columnAtPoint(e.getPoint());

                    if (columna == 3) {
                    	dispose();
        				DSSUPublicarConvocatoria publicar_convocatoria = new DSSUPublicarConvocatoria(usuario, (int) proyectos_aprobados.getValueAt(fila, 0), db);
        				publicar_convocatoria.setVisible(true);
                    }
                }
            }
        });
		
		JScrollPane contenedor_tabla = new JScrollPane(proyectos_aprobados);
		
		buscarProyectosAprobados(db);
		
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
	
	public void buscarProyectosAprobados(ManejoSQL db) {
		
		try {
			// Consulta de datos
			db.consultarDatos("SELECT Proyectos.id, titulo, usuario FROM Proyectos "
					+ "INNER JOIN Usuarios ON Usuarios.id = or_id "
					+ "INNER JOIN Evaluaciones ON Evaluaciones.id = evaluacion_id "
					+ "LEFT JOIN Convocatorias ON Convocatorias.proyecto_id = Proyectos.id "
					+ "WHERE Evaluaciones.aprobado = 1 AND Convocatorias.id IS NULL");
			
			while(db.datos.next()) {
				Object[] propuesta = {db.datos.getInt("id"), db.datos.getString("titulo"), db.datos.getString("usuario"), "Convocar"};
				proyectos_aprobados_modelo.addRow(propuesta);
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
