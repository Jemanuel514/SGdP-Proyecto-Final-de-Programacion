package frontend;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import backend.Estudiante;
import backend.ManejoSQL;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;

import java.awt.Color;

public class EstudianteInscribirse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane contenedorTabla;
	private JTable propuestas;
	private DefaultTableModel propuestasModelo;


	
	public EstudianteInscribirse(Estudiante usuario) {
		setTitle("Inscribir en Proyecto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 768);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);
		
        JLabel lblNewLabel_1 = new JLabel("INSCRIBIR EN PROYECTO");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Artifakt Element", Font.BOLD, 40));
        lblNewLabel_1.setBounds(214, 33, 633, 155);
        contentPane.add(lblNewLabel_1);
        
        JButton btnVolver = new JButton("Volver");
  		btnVolver.setFont(ConstantesEstilo.boton);
  		btnVolver.setBounds(30, 30, 199, 36);
  		btnVolver.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				dispose();
				EstudianteMenuPrincipal menuEstudiante = new EstudianteMenuPrincipal(usuario);
				menuEstudiante.setVisible(true);
  			}
  		});
  		contentPane.add(btnVolver);
		
        //TABLA
  		//General
  		propuestas = new JTable();
  		propuestas.setFont(ConstantesEstilo.texto);
  		propuestas.setBounds(40, 224, 929, 497);
  		propuestas.setEnabled(false);				//Desactivar edición de celdas
  		
          //Modelo de tabla (definición de columnas)
  		propuestasModelo = new DefaultTableModel();
  		propuestasModelo.setColumnIdentifiers(new String[] {"ID", "Título", "Organismo Receptor", "Horas",""});
  		propuestas.setModel(propuestasModelo);
  		
  		//Títulos de columna
  		JTableHeader encabezado = propuestas.getTableHeader();
        encabezado.setFont(new Font("Arial Unicode MS", Font.BOLD, 20));
  		
  		//Personalizar columnas
  		DefaultTableCellRenderer centrarCelda = new DefaultTableCellRenderer();
  		centrarCelda.setHorizontalAlignment(SwingConstants.CENTER);
  		
  		propuestas.getColumnModel().getColumn(0).setPreferredWidth(50);
  		propuestas.getColumnModel().getColumn(1).setPreferredWidth(350);
  		propuestas.getColumnModel().getColumn(2).setPreferredWidth(250);
  		propuestas.getColumnModel().getColumn(3).setPreferredWidth(100);
  		propuestas.getColumnModel().getColumn(0).setCellRenderer(centrarCelda);
  		propuestas.getColumnModel().getColumn(2).setCellRenderer(centrarCelda);
  		propuestas.getColumnModel().getColumn(3).setCellRenderer(centrarCelda);
  		propuestas.getColumnModel().getColumn(4).setCellRenderer(centrarCelda);
  		
  		//Personalizar filas
  		propuestas.setRowHeight(30);
  		
  		//Celda clickeable
  		propuestas.addMouseListener(new MouseAdapter() {
              public void mouseClicked(MouseEvent e) {
                  if (e.getClickCount() == 2) {									//Doble clic
                      int fila = propuestas.rowAtPoint(e.getPoint());
                      int columna = propuestas.columnAtPoint(e.getPoint());

                      if (columna == 3) {											//Columna de acción
                      	//dispose();
          				//MasInfoE convocatoria = new MasInfoE(usuario, (int) propuestas.getValueAt(fila, 0));
          				//convocatoria.setVisible(true);
                      }
                  }
              }
          });
  		
          contenedorTabla = new JScrollPane(propuestas);
          contenedorTabla.setBounds(40, 224, 929, 497);
          contentPane.add(contenedorTabla);
  		
          buscarConvocatorias();
								
		setSize(1024, 768);								
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);					
		

		
	}
	
	public void buscarConvocatorias() {
		//Variables
		ResultSet datos = null;
		
		try {
			//Consulta de datos
			datos = ManejoSQL.consultarDatos("SELECT Convocatorias.id, Proyectos.titulo, Usuarios.usuario, horas FROM Convocatorias INNER JOIN Proyectos ON Proyectos.id = Convocatorias.proyecto_id, Usuarios ON Proyectos.or_id = Usuarios.id");
			
			//Búsqueda de credenciales
			while(datos.next()) {
				Object[] convocatoria = {datos.getInt("id"), datos.getString("titulo"), datos.getString("usuario"), datos.getInt("horas"), "Inscribirse"};
		        propuestasModelo.addRow(convocatoria);
		        }
			}
		
		catch(SQLException e){
			System.out.println("Error al consultar la base de datos. " + e.getMessage());
		}
			
	}
}
