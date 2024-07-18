package frontend;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import backend.ManejoSQL;
import backend.OrganismoReceptor;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Presentación extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contenedorPresentacion;
	private ManejoSQL db;
    private OrganismoReceptor usuario;

  //InicializaciÃ³n de la ventana
  	public static void main(String[] args) {
  		EventQueue.invokeLater(new Runnable() {
  			public void run() {
  				try {
  					Presentación frame = new Presentación();
  					frame.setVisible(true);
  				} catch (Exception e) {
  					e.printStackTrace();
  				}
  			}
  		});
  	}
  	
	/**
	 * Create the frame.
	 */
	public Presentación() {
		setSize(new Dimension(1024, 768));
		setResizable(false);
		setMinimumSize(new Dimension(1024, 768));
		setMaximumSize(new Dimension(1024, 768));
		this.db = db;
		this.usuario = usuario;
		setPreferredSize(new Dimension(1024, 768));
		setTitle("Presentaci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contenedorPresentacion = new JPanel();
		contenedorPresentacion.setBackground(new Color(240, 255, 255));
		contenedorPresentacion.setForeground(new Color(135, 206, 235));
		contenedorPresentacion.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contenedorPresentacion);
		contenedorPresentacion.setLayout(null);
		
		//LOGO UTP
		//Cargar imagen
		ImageIcon iconoUTPoriginal = new ImageIcon("C:\\Users\\aniel\\OneDrive\\Documentos\\Universidad\\III SEM\\Programaci\u00F3n de Software I\\ECLIPSE-WORKSPACE\\SGdP\\Resources\\logoUTP.png");
		
		//Redimensionar imagen
		Image logoUTPoriginal = iconoUTPoriginal.getImage();
        Image logoUTPredimensionado = logoUTPoriginal.getScaledInstance(125, 125, Image.SCALE_SMOOTH);
        ImageIcon iconoUTPredimensionado = new ImageIcon(logoUTPredimensionado);
      
		JLabel logoUTP = new JLabel("");
		logoUTP.setHorizontalAlignment(SwingConstants.CENTER);
		logoUTP.setBorder(null);
		logoUTP.setBounds(10, 11, 132, 126);
		logoUTP.setIcon(iconoUTPredimensionado);
		contenedorPresentacion.add(logoUTP);
		
		//LOGO FISC
		//Cargar imagen
		ImageIcon iconoFISC = new ImageIcon("C:\\Users\\aniel\\OneDrive\\Documentos\\Universidad\\III SEM\\Programación de Software I\\ECLIPSE-WORKSPACE\\SGdP\\Resources\\logoFISC.png");
				
		//Redimensionar imagen
		Image imgFISC = iconoFISC.getImage();
		Image logoFISCredimensionado = imgFISC.getScaledInstance(115, 115, Image.SCALE_SMOOTH);
		ImageIcon iconoFISCredimensionado = new ImageIcon(logoFISCredimensionado);
		
		JLabel logoFISC = new JLabel("");
		logoFISC.setBorder(null);
		logoFISC.setBounds(870, 25, 110, 110);
		logoFISC.setIcon(iconoFISCredimensionado);
		contenedorPresentacion.add(logoFISC);
		
		JLabel lblNewLabel_2 = new JLabel("UNIVERSIDAD TECNOL\u00D3GICA DE PANAM\u00C1");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial Unicode MS", Font.BOLD, 24));
		lblNewLabel_2.setBounds(165, 11, 682, 58);
		contenedorPresentacion.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("FACULTAD DE ING. DE SISTEMAS COMPUTACIONALES");
		lblNewLabel_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Arial Unicode MS", Font.BOLD, 24));
		lblNewLabel_2_1.setBounds(154, 67, 704, 58);
		contenedorPresentacion.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("LICENCIATURA EN INGENIER\u00CDA DE SOFTWARE ");
		lblNewLabel_2_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("Arial Unicode MS", Font.BOLD, 24));
		lblNewLabel_2_1_1.setBounds(180, 123, 651, 58);
		contenedorPresentacion.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("GRUPO 1SF122");
		lblNewLabel_2_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1.setFont(new Font("Artifakt Element", Font.BOLD, 24));
		lblNewLabel_2_1_1_1.setBounds(375, 179, 262, 58);
		contenedorPresentacion.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("FACILITADOR: RODRIGO Y\u00C1NG\u00DCEZ");
		lblNewLabel_2_1_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_1.setFont(new Font("Artifakt Element", Font.BOLD, 24));
		lblNewLabel_2_1_1_1_1.setBounds(95, 571, 821, 58);
		contenedorPresentacion.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("MIEMBROS DE EQUIPO:");
		lblNewLabel_2_1_1_1_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2.setFont(new Font("Artifakt Element", Font.BOLD, 24));
		lblNewLabel_2_1_1_1_2.setBounds(95, 235, 821, 58);
		contenedorPresentacion.add(lblNewLabel_2_1_1_1_2);
		
		JLabel lblNewLabel_2_1_1_1_2_1 = new JLabel("DANNA DAWKINS 8-1010-1542");
		lblNewLabel_2_1_1_1_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_1.setFont(new Font("Artifakt Element", Font.BOLD, 24));
		lblNewLabel_2_1_1_1_2_1.setBounds(95, 291, 821, 58);
		contenedorPresentacion.add(lblNewLabel_2_1_1_1_2_1);
		
		JLabel lblNewLabel_2_1_1_1_2_1_1 = new JLabel("MANUEL GUILL\u00C9N 8-1016-1618");
		lblNewLabel_2_1_1_1_2_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_1_1.setFont(new Font("Artifakt Element", Font.BOLD, 24));
		lblNewLabel_2_1_1_1_2_1_1.setBounds(95, 347, 821, 58);
		contenedorPresentacion.add(lblNewLabel_2_1_1_1_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1_2_1_2 = new JLabel("JOS\u00C9 HUERTAS 2-754-1176");
		lblNewLabel_2_1_1_1_2_1_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_1_2.setFont(new Font("Artifakt Element", Font.BOLD, 24));
		lblNewLabel_2_1_1_1_2_1_2.setBounds(95, 403, 821, 58);
		contenedorPresentacion.add(lblNewLabel_2_1_1_1_2_1_2);
		
		JLabel lblNewLabel_2_1_1_1_2_1_2_1 = new JLabel("JOAQU\u00CDN LU 8-1024-2466");
		lblNewLabel_2_1_1_1_2_1_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_1_2_1.setFont(new Font("Artifakt Element", Font.BOLD, 24));
		lblNewLabel_2_1_1_1_2_1_2_1.setBounds(95, 459, 821, 58);
		contenedorPresentacion.add(lblNewLabel_2_1_1_1_2_1_2_1);
		
		JLabel lblNewLabel_2_1_1_1_2_1_2_2 = new JLabel("ANIE LUO 8-1016-414");
		lblNewLabel_2_1_1_1_2_1_2_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_1_2_2.setFont(new Font("Artifakt Element", Font.BOLD, 24));
		lblNewLabel_2_1_1_1_2_1_2_2.setBounds(95, 515, 821, 58);
		contenedorPresentacion.add(lblNewLabel_2_1_1_1_2_1_2_2);
		
		JLabel lblNewLabel_2_1_1_1_2_1_2_3 = new JLabel("FECHA DE ENTREGA: 19 DE JULIO DE 2024");
		lblNewLabel_2_1_1_1_2_1_2_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_1_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2_1_2_3.setFont(new Font("Artifakt Element", Font.BOLD, 24));
		lblNewLabel_2_1_1_1_2_1_2_3.setBounds(95, 627, 821, 58);
		contenedorPresentacion.add(lblNewLabel_2_1_1_1_2_1_2_3);
		
		JButton botonEmpezar = new JButton("Empecemos");
		botonEmpezar.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				dispose();
				InicioSesion iniciarSesion = new InicioSesion();
				iniciarSesion.setVisible(true);
  			}
  		});
		
		botonEmpezar.setForeground(new Color(0, 0, 0));
		botonEmpezar.setBackground(new Color(173, 216, 230));
		botonEmpezar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		botonEmpezar.setBounds(818, 640, 162, 33);
		contenedorPresentacion.add(botonEmpezar);
		
		//IMAGEN DE GATO NYEHEHE
		//Cargar imagen
		ImageIcon iconoGato = new ImageIcon("C:\\Users\\aniel\\OneDrive\\Documentos\\Universidad\\III SEM\\Programaci\u00F3n de Software I\\ECLIPSE-WORKSPACE\\SGdP\\Resources\\gato.jpg");
				
		//Redimensionar imagen
		Image imagenGato = iconoGato.getImage();
		Image gatoRedimensionado = imagenGato.getScaledInstance(110, 110, Image.SCALE_SMOOTH);
		ImageIcon iconoGatoRedimensionado = new ImageIcon(gatoRedimensionado);
		
		JLabel gato = new JLabel("");
		gato.setBorder(null);
		gato.setBounds(846, 528, 110, 110);
		gato.setIcon(iconoGatoRedimensionado);
		contenedorPresentacion.add(gato);
		
	}
}
