package frontend;

import backend.Estudiante;
import backend.ManejoSQL;
import backend.Usuario;

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

public class EstudianteVerInscripciones extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable tabla_convocatorias;
    private DefaultTableModel convocatorias_modelo;
    
	public EstudianteVerInscripciones(Estudiante usuario, ManejoSQL db) {
		
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
		lbl_bienvenida.setFont(ConstantesEstilo.TEXTO);
		lbl_bienvenida.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lbl_tipo_usuario = new JLabel("ESTUDIANTE");
		lbl_tipo_usuario.setFont(ConstantesEstilo.TEXTO);
		lbl_tipo_usuario.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lbl_facultad = new JLabel(usuario.getFacultad());
		lbl_facultad.setFont(ConstantesEstilo.TEXTO);
		lbl_facultad.setHorizontalAlignment(SwingConstants.RIGHT);
	
		JLabel lbl_convocatorias = new JLabel("Proyectos Inscritos");
		lbl_convocatorias.setFont(ConstantesEstilo.TITULO);
		lbl_convocatorias.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Botones
		JButton boton_menu = new JButton("Menú");
		boton_menu.setFont(ConstantesEstilo.BOTON);
		boton_menu.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				dispose();
  					EstudianteMenuPrincipal menu_estudiante = new EstudianteMenuPrincipal(usuario, db);
  					menu_estudiante.setVisible(true);
  				}
  			});
		
		// Tabla
		tabla_convocatorias = new JTable();
		tabla_convocatorias.setEnabled(false);
		tabla_convocatorias.setFont(ConstantesEstilo.TEXTO);
		
        // Modelo de tabla (definición de columnas)
		convocatorias_modelo = new DefaultTableModel();
		convocatorias_modelo.setColumnIdentifiers(new String[] {"ID", "Título", ""});
		tabla_convocatorias.setModel(convocatorias_modelo);
		
		// Títulos de columna
		JTableHeader encabezado = tabla_convocatorias.getTableHeader();
        encabezado.setFont(ConstantesEstilo.SUBTITULO);
        encabezado.setReorderingAllowed(false);
		
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
        				VerConvocatoria ver_convocatoria = new VerConvocatoria(usuario, (int) tabla_convocatorias.getValueAt(fila, 0), db);
        				ver_convocatoria.setVisible(true);
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
	    						.addComponent(lbl_tipo_usuario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    						.addComponent(lbl_facultad, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
	    		
				.addComponent(lbl_convocatorias, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(contenedor_tabla, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
				
		gl_contenedor_principal.setVerticalGroup(gl_contenedor_principal.createSequentialGroup()
				.addGroup(gl_contenedor_principal.createParallelGroup()
						.addComponent(boton_menu)
						.addGroup(gl_contenedor_principal.createSequentialGroup()
								.addComponent(lbl_bienvenida)
	    						.addComponent(lbl_tipo_usuario)
	    						.addComponent(lbl_facultad)))
				
				.addComponent(lbl_bienvenida)
				.addComponent(lbl_tipo_usuario)
				.addComponent(lbl_convocatorias)
				.addComponent(contenedor_tabla, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		
		contenedor_principal.setLayout(gl_contenedor_principal);
		
    }
	
	public void buscarConvocatorias(Usuario usuario, ManejoSQL db) {
		
		try {
			// Consulta de datos
			db.consultarDatos("SELECT Convocatorias.id, Proyectos.titulo FROM Convocatorias "
					+ "INNER JOIN Proyectos on Proyectos.id = Convocatorias.proyecto_id "
					+ "INNER JOIN Inscripciones ON Inscripciones.convocatoria_id = Convocatorias.id "
					+ "INNER JOIN Usuarios ON Usuarios.id = Inscripciones.estudiante_id "
					+ "WHERE estudiante_id = " + usuario.getId()); 
			
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