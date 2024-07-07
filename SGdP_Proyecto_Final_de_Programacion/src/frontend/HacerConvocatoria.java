package frontend;

import java.awt.EventQueue;
import backend.DSSU;
import backend.ManejoSQL;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;



public class HacerConvocatoria extends JFrame{
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HacerConvocatoria frame = new HacerConvocatoria(new DSSU (1,1,"asd","asdw", "qwer", "gkgkg"));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	private JPanel contenedor;
	private JTable proyectosAprobados;
	private DefaultTableModel proyectosAprobadosModelo;
	private JScrollPane contenedorTabla;

	public HacerConvocatoria(DSSU usuario) {
		setSize(1024, 768);								//Dimensiones
		setResizable(false);
		setLocationRelativeTo(null);	
		setBounds(100, 100, 894, 666);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contenedor = new JPanel();							//Inicializar
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));		//Bordes
		contenedor.setLayout(null);								//Layout (absoluto)
		setContentPane(contenedor);	
		
		JLabel lblBienvenida = new JLabel("Bienvenido, " + usuario.getUsuario());
		lblBienvenida.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		lblBienvenida.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBienvenida.setBounds(822, 10, 178, 38);
		contenedor.add(lblBienvenida);
		
		JLabel lblTipoUsuario = new JLabel("DSSU");
		lblTipoUsuario.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		lblTipoUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoUsuario.setBounds(822, 39, 178, 38);
		contenedor.add(lblTipoUsuario);
		
		JLabel lblNewLabel = new JLabel("PROYECTOS APROBADOS");
		lblNewLabel.setForeground(new Color(128, 128, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNewLabel.setBounds(171, 70, 532, 59);
		contenedor.add(lblNewLabel);
		
		proyectosAprobados = new JTable();
		proyectosAprobados.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		proyectosAprobados.setBounds(40, 224, 929, 497);
		proyectosAprobados.setEnabled(false);		//Desactivar edición de celdas
		
        //Modelo de tabla (definición de columnas)
		proyectosAprobadosModelo = new DefaultTableModel();
		proyectosAprobadosModelo.setColumnIdentifiers(new String[] {"Título", "Organismo Receptor", ""});
		proyectosAprobados.setModel(proyectosAprobadosModelo);
		
		//Títulos de columna
		JTableHeader encabezado = proyectosAprobados.getTableHeader();
        encabezado.setFont(new Font("Arial Unicode MS", Font.BOLD, 20));
		
		//Personalizar columnas
		DefaultTableCellRenderer centrarCelda = new DefaultTableCellRenderer();
		centrarCelda.setHorizontalAlignment(SwingConstants.CENTER);
		
		proyectosAprobados.getColumnModel().getColumn(0).setPreferredWidth(600);
		proyectosAprobados.getColumnModel().getColumn(1).setPreferredWidth(200);
		proyectosAprobados.getColumnModel().getColumn(1).setCellRenderer(centrarCelda);
		proyectosAprobados.getColumnModel().getColumn(2).setCellRenderer(centrarCelda);
		
		//Personalizar filas
		proyectosAprobados.setRowHeight(30);
		
		//Celda clickeable
		proyectosAprobados.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {									//Doble clic
                    int fila = proyectosAprobados.rowAtPoint(e.getPoint());
                    int columna = proyectosAprobados.columnAtPoint(e.getPoint());

                    if (columna == 2) {											//Columna de acción
                        JOptionPane.showMessageDialog(null, "Evaluando proyecto: " + proyectosAprobados.getValueAt(fila, 0));
                    }
                }
            }
        });
		
        contenedorTabla = new JScrollPane(proyectosAprobados);
        contenedorTabla.setBounds(40, 224, 929, 497);
        contenedor.add(contenedorTabla);
		
        buscarProyectosAprobados();
	}
	
	public void buscarProyectosAprobados() {
		//Variables
		ResultSet datos = null;
		
		try {
			//Consulta de datos
			datos = ManejoSQL.consultarDatos("SELECT titulo, usuario FROM Proyectos INNER JOIN Usuarios, Evaluaciones ON Proyectos.or_id = Usuarios.id WHERE Evaluaciones.aprobado = 1 AND Proyectos.evaluacion_id NOT NULL");
			
			//Búsqueda de credenciales
			while(datos.next()) {
				Object[] propuesta = {datos.getString("titulo"), datos.getString("usuario"), "Convocar"};
		        proyectosAprobadosModelo.addRow(propuesta);
		        }
			}
		
		catch(SQLException e){
			System.out.println("Error al consultar la base de datos. " + e.getMessage());
		}
			
	}

}
