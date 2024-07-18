package frontend;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.nio.file.Path;
import java.nio.file.Paths;


public class Presentacion extends JFrame {

	private static final long serialVersionUID = 1L;

  	public static void main(String[] args) {
  		EventQueue.invokeLater(new Runnable() {
  			public void run() {
  				try {
  					Presentacion frame = new Presentacion();
  					frame.setVisible(true);
  				} catch (Exception e) {
  					e.printStackTrace();
  				}
  			}
  		});
  	}
  	
	public Presentacion() {
		Path rutaProyecto = Paths.get(".").toAbsolutePath().normalize();
		
		setSize(ConstantesEstilo.ventana);
		setPreferredSize(ConstantesEstilo.ventana);
		setResizable(false);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contenedorPresentacion = new JPanel();
		contenedorPresentacion.setBackground(new Color(240, 255, 255));
		contenedorPresentacion.setForeground(new Color(135, 206, 235));
		contenedorPresentacion.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenedorPresentacion.setLayout(null);
		setContentPane(contenedorPresentacion);

		//LOGO UTP
		//Cargar imagen
		Path rutaLogoUTP = rutaProyecto.resolve("Resources/logoUTP.png");
		ImageIcon iconoUTPoriginal = new ImageIcon(rutaLogoUTP.toString());
		
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
		Path rutaLogoFISC = rutaProyecto.resolve("Resources/logoFISC.png");
		ImageIcon iconoFISC = new ImageIcon(rutaLogoFISC.toString());
				
		//Redimensionar imagen
		Image imgFISC = iconoFISC.getImage();
		Image logoFISCredimensionado = imgFISC.getScaledInstance(115, 115, Image.SCALE_SMOOTH);
		ImageIcon iconoFISCredimensionado = new ImageIcon(logoFISCredimensionado);
		
		JLabel logoFISC = new JLabel("");
		logoFISC.setBorder(null);
		logoFISC.setBounds(870, 25, 110, 110);
		logoFISC.setIcon(iconoFISCredimensionado);
		contenedorPresentacion.add(logoFISC);
		
		JLabel lbl_universidad = new JLabel("UNIVERSIDAD TECNOLÓGICA DE PANAMÁ");
		lbl_universidad.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_universidad.setFont(new Font("Arial Unicode MS", Font.BOLD, 24));
		lbl_universidad.setBounds(165, 11, 682, 58);
		contenedorPresentacion.add(lbl_universidad);
		
		JLabel lbl_facultad = new JLabel("FACULTAD DE ING. DE SISTEMAS COMPUTACIONALES");
		lbl_facultad.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_facultad.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_facultad.setFont(new Font("Arial Unicode MS", Font.BOLD, 24));
		lbl_facultad.setBounds(154, 67, 704, 58);
		contenedorPresentacion.add(lbl_facultad);
		
		JLabel lbl_carrera = new JLabel("LICENCIATURA EN INGENIERÍA DE SOFTWARE ");
		lbl_carrera.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_carrera.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_carrera.setFont(new Font("Arial Unicode MS", Font.BOLD, 24));
		lbl_carrera.setBounds(180, 123, 651, 58);
		contenedorPresentacion.add(lbl_carrera);
		
		JLabel lbl_grupo = new JLabel("GRUPO 1SF122");
		lbl_grupo.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_grupo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_grupo.setFont(new Font("Artifakt Element", Font.BOLD, 24));
		lbl_grupo.setBounds(375, 179, 262, 58);
		contenedorPresentacion.add(lbl_grupo);
		
		JLabel lbl_profesor = new JLabel("FACILITADOR: RODRIGO YÁNGÜEZ");
		lbl_profesor.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_profesor.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_profesor.setFont(new Font("Artifakt Element", Font.BOLD, 24));
		lbl_profesor.setBounds(95, 571, 821, 58);
		contenedorPresentacion.add(lbl_profesor);
		
		JLabel lbl_miembros = new JLabel("MIEMBROS DE EQUIPO:");
		lbl_miembros.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_miembros.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_miembros.setFont(new Font("Artifakt Element", Font.BOLD, 24));
		lbl_miembros.setBounds(95, 235, 821, 58);
		contenedorPresentacion.add(lbl_miembros);
		
		JLabel lbl_danna = new JLabel("DANNA DAWKINS 8-1010-1542");
		lbl_danna.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_danna.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_danna.setFont(new Font("Artifakt Element", Font.BOLD, 24));
		lbl_danna.setBounds(95, 291, 821, 58);
		contenedorPresentacion.add(lbl_danna);
		
		JLabel lbl_manuel = new JLabel("MANUEL GUILLÉN 8-1016-1618");
		lbl_manuel.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_manuel.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_manuel.setFont(new Font("Artifakt Element", Font.BOLD, 24));
		lbl_manuel.setBounds(95, 347, 821, 58);
		contenedorPresentacion.add(lbl_manuel);
		
		JLabel lbl_jose = new JLabel("JOSÉ HUERTAS 2-754-1176");
		lbl_jose.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_jose.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_jose.setFont(new Font("Artifakt Element", Font.BOLD, 24));
		lbl_jose.setBounds(95, 403, 821, 58);
		contenedorPresentacion.add(lbl_jose);
		
		JLabel lbl_joaquin = new JLabel("JOAQUÍN LU 8-1024-2466");
		lbl_joaquin.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_joaquin.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_joaquin.setFont(new Font("Artifakt Element", Font.BOLD, 24));
		lbl_joaquin.setBounds(95, 459, 821, 58);
		contenedorPresentacion.add(lbl_joaquin);
		
		JLabel lbl_anie = new JLabel("ANIE LUO 8-1016-414");
		lbl_anie.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_anie.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_anie.setFont(new Font("Artifakt Element", Font.BOLD, 24));
		lbl_anie.setBounds(95, 515, 821, 58);
		contenedorPresentacion.add(lbl_anie);
		
		JLabel lbl_fecha = new JLabel("FECHA DE ENTREGA: 19 DE JULIO DE 2024");
		lbl_fecha.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_fecha.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha.setFont(new Font("Artifakt Element", Font.BOLD, 24));
		lbl_fecha.setBounds(95, 627, 821, 58);
		contenedorPresentacion.add(lbl_fecha);
		
		JButton boton_empezar = new JButton("Empecemos");
		boton_empezar.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				dispose();
				InicioSesion iniciarSesion = new InicioSesion();
				iniciarSesion.setVisible(true);
  			}
  		});
		
		boton_empezar.setForeground(new Color(0, 0, 0));
		boton_empezar.setBackground(new Color(173, 216, 230));
		boton_empezar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		boton_empezar.setBounds(818, 640, 162, 33);
		contenedorPresentacion.add(boton_empezar);
		
		//IMAGEN DE GATO NYEHEHE
		//Cargar imagen
		Path rutaGato = rutaProyecto.resolve("Resources/gato.jpg");
		ImageIcon iconoGato = new ImageIcon(rutaGato.toString());
				
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
