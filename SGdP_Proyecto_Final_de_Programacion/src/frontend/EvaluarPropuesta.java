package frontend;

import backend.DSSU;
import backend.ManejoSQL;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

import java.sql.ResultSet;
import java.sql.SQLException;

public class EvaluarPropuesta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contenedor;
	private JScrollPane contenedorTabla;
	private JTable propuestas;
	private DefaultTableModel propuestasModelo;

	public EvaluarPropuesta(DSSU usuario) {
		//Configurar el Jframe
		setTitle("Evaluar Propuestas");					//Título
		setSize(1024, 768);								//Dimensiones
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);					//Centrar en la pantalla
		
		//Configurar el contenedor
		contenedor = new JPanel();							//Inicializar
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));		//Bordes
		contenedor.setLayout(null);								//Layout (absoluto)
		setContentPane(contenedor);								//Establecer en la ventana
		
		//CONFIGURACIÓN DE ETIQUETAS
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
		
		JLabel lblEvaluarPropuestas = new JLabel("Evaluar Propuestas");
		lblEvaluarPropuestas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvaluarPropuestas.setFont(new Font("Artifakt Element", Font.BOLD, 40));
		lblEvaluarPropuestas.setBounds(256, 100, 497, 56);
		contenedor.add(lblEvaluarPropuestas);
		
		JLabel lblSeleccione = new JLabel("Seleccione el proyecto a evaluar [Haga doble clic en 'Evaluar']");
		lblSeleccione.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		lblSeleccione.setBounds(40, 160, 600, 38);
		contenedor.add(lblSeleccione);
		
		//CONFIGURACIÓN DE TABLA
		//General
		propuestas = new JTable();
		propuestas.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		propuestas.setBounds(40, 224, 929, 497);
		propuestas.setEnabled(false);		//Desactivar edición de celdas
		
        //Modelo de tabla (definición de columnas)
		propuestasModelo = new DefaultTableModel();
		propuestasModelo.setColumnIdentifiers(new String[] {"Título", "Organismo Receptor", ""});
		propuestas.setModel(propuestasModelo);
		
		//Títulos de columna
		JTableHeader encabezado = propuestas.getTableHeader();
        encabezado.setFont(new Font("Arial Unicode MS", Font.BOLD, 20));
		
		//Personalizar columnas
		DefaultTableCellRenderer centrarCelda = new DefaultTableCellRenderer();
		centrarCelda.setHorizontalAlignment(SwingConstants.CENTER);
		
		propuestas.getColumnModel().getColumn(0).setPreferredWidth(600);
		propuestas.getColumnModel().getColumn(1).setPreferredWidth(200);
		propuestas.getColumnModel().getColumn(1).setCellRenderer(centrarCelda);
		propuestas.getColumnModel().getColumn(2).setCellRenderer(centrarCelda);
		
		//Personalizar filas
		propuestas.setRowHeight(30);
		
		//Celda clickeable
		propuestas.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {									//Doble clic
                    int fila = propuestas.rowAtPoint(e.getPoint());
                    int columna = propuestas.columnAtPoint(e.getPoint());

                    if (columna == 2) {											//Columna de acción
                        JOptionPane.showMessageDialog(null, "Evaluando proyecto: " + propuestas.getValueAt(fila, 0));
                    }
                }
            }
        });
		
        contenedorTabla = new JScrollPane(propuestas);
        contenedorTabla.setBounds(40, 224, 929, 497);
        contenedor.add(contenedorTabla);
		
        buscarPropuestas();
        
        //CONFIGURACIÓN DE BOTONES
        JButton btnVolver = new JButton("Volver");
  		btnVolver.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
  		btnVolver.setBounds(30, 30, 199, 36);
  		btnVolver.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				dispose();
				MenuPrincipalDSSU menuDSSU = new MenuPrincipalDSSU(usuario);
				menuDSSU.setVisible(true);
  			}
  		});
  		contenedor.add(btnVolver);
				
	}
	
	public void buscarPropuestas() {
		//Variables
		ResultSet datos = null;
		
		try {
			//Consulta de datos
			datos = ManejoSQL.consultarDatos("SELECT titulo, usuario FROM Proyectos INNER JOIN Usuarios ON Proyectos.or_id = Usuarios.id");
			
			//Búsqueda de credenciales
			while(datos.next()) {
				Object[] propuesta = {datos.getString("titulo"), datos.getString("usuario"), "Evaluar"};
		        propuestasModelo.addRow(propuesta);
		        }
			}
		
		catch(SQLException e){
			System.out.println("Error al consultar la base de datos. " + e.getMessage());
		}
			
	}
}