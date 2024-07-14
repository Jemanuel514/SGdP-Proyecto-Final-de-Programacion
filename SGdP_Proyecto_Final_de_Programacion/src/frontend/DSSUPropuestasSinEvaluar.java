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
	
	private ManejoSQL db;
	
	private static final long serialVersionUID = 1L;
	private JPanel contenedor;
	private JScrollPane contenedorTabla;
	private JTable propuestas;
	private DefaultTableModel propuestasModelo;

	public DSSUPropuestasSinEvaluar(DSSU usuario, ManejoSQL db) {
		
		this.db = db;
		
		//JFRAME
		setSize(ConstantesEstilo.ventana);				//Dimensiones
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);					//Centrar en la pantalla
		
		//CONTENEDOR
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenedor.setLayout(null);
		setContentPane(contenedor);
		
		//ETIQUETAS
		JLabel lblBienvenida = new JLabel("Bienvenido, " + usuario.getUsuario());	//Inicializar y texto
		lblBienvenida.setFont(ConstantesEstilo.texto);								//Fuente
		lblBienvenida.setHorizontalAlignment(SwingConstants.RIGHT);					//Alineación
		lblBienvenida.setBounds(822, 10, 178, 38);									//Posición
		contenedor.add(lblBienvenida);
		
		JLabel lblTipoUsuario = new JLabel("DSSU");
		lblTipoUsuario.setFont(ConstantesEstilo.texto);
		lblTipoUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoUsuario.setBounds(822, 39, 178, 38);
		contenedor.add(lblTipoUsuario);
		
		JLabel lblEvaluarPropuestas = new JLabel("Evaluar Propuestas");
		lblEvaluarPropuestas.setFont(ConstantesEstilo.titulo);
		lblEvaluarPropuestas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvaluarPropuestas.setBounds(256, 100, 497, 56);
		contenedor.add(lblEvaluarPropuestas);
		
		JLabel lblSeleccione = new JLabel("Seleccione el proyecto a evaluar [Haga doble clic en 'Evaluar']");
		lblSeleccione.setFont(ConstantesEstilo.texto);
		lblSeleccione.setBounds(40, 160, 600, 38);
		contenedor.add(lblSeleccione);
		
		//TABLA
		//General
		propuestas = new JTable();
		propuestas.setFont(ConstantesEstilo.texto);
		propuestas.setBounds(40, 224, 929, 497);
		propuestas.setEnabled(false);				//Desactivar edición de celdas
		
        //Modelo de tabla (definición de columnas)
		propuestasModelo = new DefaultTableModel();
		propuestasModelo.setColumnIdentifiers(new String[] {"ID", "Título", "Organismo Receptor", ""});
		propuestas.setModel(propuestasModelo);
		
		//Títulos de columna
		JTableHeader encabezado = propuestas.getTableHeader();
        encabezado.setFont(new Font("Arial Unicode MS", Font.BOLD, 20));
		
		//Personalizar columnas
		DefaultTableCellRenderer centrarCelda = new DefaultTableCellRenderer();
		centrarCelda.setHorizontalAlignment(SwingConstants.CENTER);
		
		propuestas.getColumnModel().getColumn(0).setPreferredWidth(50);
		propuestas.getColumnModel().getColumn(1).setPreferredWidth(475);
		propuestas.getColumnModel().getColumn(2).setPreferredWidth(250);
		propuestas.getColumnModel().getColumn(0).setCellRenderer(centrarCelda);
		propuestas.getColumnModel().getColumn(2).setCellRenderer(centrarCelda);
		propuestas.getColumnModel().getColumn(3).setCellRenderer(centrarCelda);
		
		//Personalizar filas
		propuestas.setRowHeight(30);
		
		//Celda clickeable
		propuestas.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {									//Doble clic
                    int fila = propuestas.rowAtPoint(e.getPoint());
                    int columna = propuestas.columnAtPoint(e.getPoint());

                    if (columna == 3) {											//Columna de acción
                    	dispose();
        				DSSUEvaluarPropuesta evaluarPropuesta = new DSSUEvaluarPropuesta(usuario, (int) propuestas.getValueAt(fila, 0), db);
        				evaluarPropuesta.setVisible(true);
                    }
                }
            }
        });
		
        contenedorTabla = new JScrollPane(propuestas);
        contenedorTabla.setBounds(40, 224, 929, 497);
        contenedor.add(contenedorTabla);
		
        buscarPropuestas();
        
        //BOTONES
        JButton btnVolver = new JButton("Volver");
  		btnVolver.setFont(ConstantesEstilo.boton);
  		btnVolver.setBounds(30, 30, 199, 36);
  		btnVolver.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				dispose();
				DSSUMenuPrincipal menuDSSU = new DSSUMenuPrincipal(usuario, db);
				menuDSSU.setVisible(true);
  			}
  		});
  		contenedor.add(btnVolver);
				
	}
	
	public void buscarPropuestas() {

		try {
			//Consulta de datos
			db.consultarDatos("SELECT Proyectos.id, titulo, usuario FROM Proyectos INNER JOIN Usuarios ON Proyectos.or_id = Usuarios.id WHERE Proyectos.evaluacion_id IS NULL");
			
			//Búsqueda de credenciales
			while(db.datos.next()) {
				Object[] propuesta = {db.datos.getInt("id"), db.datos.getString("titulo"), db.datos.getString("usuario"), "Evaluar"};
		        propuestasModelo.addRow(propuesta);
		        }
			}
		
		catch(SQLException e){
			System.out.println("Error al consultar la base de datos. " + e.getMessage());
		}
		
		finally {
			db.cerrarConexion();
		}
			
	}
}