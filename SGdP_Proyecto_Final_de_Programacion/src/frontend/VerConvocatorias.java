package frontend;

import backend.DSSU;
import backend.Estudiante;
import backend.ManejoSQL;
import backend.OrganismoReceptor;
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

public class VerConvocatorias extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable tabla_convocatorias;
    private DefaultTableModel convocatorias_modelo;
    
	public VerConvocatorias(Usuario usuario, ManejoSQL db) {
		
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
		
		String tipo_usuario = "";
		switch(usuario.getTipo()) {
		case 0:
			tipo_usuario = "ORGANISMO RECEPTOR";
			break;
		
		case 1:
			tipo_usuario = "DSSU";
			break;
		
		case 2:
			tipo_usuario = "ESTUDIANTE";
			break;
			
		default:
			break;
		}
		
		JLabel lbl_tipo_usuario = new JLabel(tipo_usuario);
		lbl_tipo_usuario.setFont(ConstantesEstilo.TEXTO);
		lbl_tipo_usuario.setHorizontalAlignment(SwingConstants.RIGHT);
	
		JLabel lbl_convocatorias = new JLabel("Convocatorias");
		lbl_convocatorias.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_convocatorias.setFont(ConstantesEstilo.TITULO);
		
		// Botones
		JButton boton_menu = new JButton("Menú");
		boton_menu.setFont(ConstantesEstilo.BOTON);
		boton_menu.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				dispose();
  				
  				switch(usuario.getTipo()) {
  				case 0:
  					ORMenuPrincipal menu_or = new ORMenuPrincipal((OrganismoReceptor) usuario, db);
  					menu_or.setVisible(true);
  					break;
  				
  				case 1:
  					DSSUMenuPrincipal menu_dssu = new DSSUMenuPrincipal((DSSU) usuario, db);
  					menu_dssu.setVisible(true);
  					break;
  				
  				case 2:
  					EstudianteMenuPrincipal menu_estudiante = new EstudianteMenuPrincipal((Estudiante) usuario, db);
  					menu_estudiante.setVisible(true);
  					break;
  					
  				default:
  					break;
  				}
  					
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
	
	public void buscarConvocatorias(Usuario usuario, ManejoSQL db) {
		String consulta = "";
		
		switch(usuario.getTipo()) {
		// Organismo Receptor: solo puede ver las convocatorias de sus proyectos
		case 0:
			consulta = "SELECT Convocatorias.id, Proyectos.titulo FROM Convocatorias INNER JOIN Proyectos on Convocatorias.proyecto_id = Proyectos.id WHERE Proyectos.or_id = " + usuario.getId();
			break;
		// DSSU: puede ver todas las convocatorias
		case 1:
			consulta = "SELECT Convocatorias.id, Proyectos.titulo FROM Convocatorias INNER JOIN Proyectos on Convocatorias.proyecto_id = Proyectos.id";
			break;
		// Estudiante: solo puede ver las convocatorias de su facultad
		case 2:
			consulta = "SELECT Convocatorias.id, Proyectos.titulo FROM Convocatorias INNER JOIN Proyectos on Convocatorias.proyecto_id = Proyectos.id WHERE Proyectos.facultades IN ('TODAS', '" + ((Estudiante) usuario).getFacultad() + "')";
			break;
		default: break;
		}
		
		try {
			// Consulta de datos
			db.consultarDatos(consulta); 
			
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

