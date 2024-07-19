package frontend;

import backend.ManejoSQL;
import backend.Usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class VerInscritos extends JFrame {

    private static final long serialVersionUID = 1L;
    
    private JTable tabla_inscripciones;
    private DefaultTableModel inscripciones_modelo;
    
	public VerInscritos(Usuario usuario, int id_convocatoria, ManejoSQL db) {
		
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
		
		default:
			break;
		}
		
		JLabel lbl_tipo_usuario = new JLabel(tipo_usuario);
		lbl_tipo_usuario.setFont(ConstantesEstilo.TEXTO);
		lbl_tipo_usuario.setHorizontalAlignment(SwingConstants.RIGHT);
	
		JLabel lbl_inscripciones = new JLabel("Inscripciones");
		lbl_inscripciones.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_inscripciones.setFont(ConstantesEstilo.TITULO);
		
		// Botones
		JButton btn_volver = new JButton("Volver");
		btn_volver.setFont(ConstantesEstilo.BOTON);
		btn_volver.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				dispose();
  				VerConvocatoria ver_convocatoria = new VerConvocatoria(usuario, id_convocatoria, db);
				ver_convocatoria.setVisible(true);
  			}
  		});
		
		// Tabla
		tabla_inscripciones = new JTable();
		tabla_inscripciones.setEnabled(false);
		tabla_inscripciones.setFont(ConstantesEstilo.TEXTO);
						
		//Modelo de tabla (definición de columnas)
		inscripciones_modelo = new DefaultTableModel();
		inscripciones_modelo.setColumnIdentifiers(new String[] {"Estudiante", "Correo", "Facultad"});
		tabla_inscripciones.setModel(inscripciones_modelo);
						
		//Títulos de columna
		JTableHeader encabezado = tabla_inscripciones.getTableHeader();
		encabezado.setFont(ConstantesEstilo.SUBTITULO);
		encabezado.setReorderingAllowed(false);
						
		//Personalizar columnas
		DefaultTableCellRenderer centrar_celda = new DefaultTableCellRenderer();
		centrar_celda.setHorizontalAlignment(SwingConstants.CENTER);
						
		tabla_inscripciones.getColumnModel().getColumn(0).setCellRenderer(centrar_celda);
		tabla_inscripciones.getColumnModel().getColumn(1).setCellRenderer(centrar_celda);
		tabla_inscripciones.getColumnModel().getColumn(2).setCellRenderer(centrar_celda);
		
		// Personalizar filas
		tabla_inscripciones.setRowHeight(30);
		
		JScrollPane contenedor_tabla = new JScrollPane(tabla_inscripciones);
		
		buscarInscritos(id_convocatoria, db);
			
		GroupLayout gl_contenedor_principal = new GroupLayout(contenedor_principal);
		
	    gl_contenedor_principal.setHorizontalGroup(gl_contenedor_principal.createParallelGroup()
	    		.addGroup(gl_contenedor_principal.createSequentialGroup()
	    				.addComponent(btn_volver, 150, 150, 150)
	    				.addGroup(gl_contenedor_principal.createParallelGroup()
	    						.addComponent(lbl_bienvenida, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    						.addComponent(lbl_tipo_usuario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
	    		
				.addComponent(lbl_inscripciones, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(contenedor_tabla, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
				
		gl_contenedor_principal.setVerticalGroup(gl_contenedor_principal.createSequentialGroup()
				.addGroup(gl_contenedor_principal.createParallelGroup()
						.addComponent(btn_volver)
						.addGroup(gl_contenedor_principal.createSequentialGroup()
								.addComponent(lbl_bienvenida)
	    						.addComponent(lbl_tipo_usuario)))
				
				.addComponent(lbl_bienvenida)
				.addComponent(lbl_tipo_usuario)
				.addComponent(lbl_inscripciones)
				.addComponent(contenedor_tabla, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		
		contenedor_principal.setLayout(gl_contenedor_principal);

    }
	public void buscarInscritos(int id_convocatoria, ManejoSQL db) {
		
		try {
			// Consulta de datos
			db.consultarDatos("SELECT usuario, Usuarios.correo, facultad FROM Usuarios INNER JOIN Inscripciones on Inscripciones.estudiante_id = Usuarios.id WHERE Inscripciones.convocatoria_id = " + id_convocatoria); 
			
			while(db.datos.next()) {
				Object[] inscripciones = {db.datos.getString("usuario"), db.datos.getString("correo"),db.datos.getString("facultad")};
		        inscripciones_modelo.addRow(inscripciones);
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

