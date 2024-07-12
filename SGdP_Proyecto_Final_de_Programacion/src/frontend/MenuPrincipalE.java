package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MenuPrincipalE extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipalE frame = new MenuPrincipalE();
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
	public MenuPrincipalE() {
		setTitle("Menú Estudiante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 749);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		setSize(1024, 768);								
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel_1 = new JLabel("SISTEMA DE GESTIÓN DE PROYECTOS");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Artifakt Element", Font.BOLD, 40));
		lblNewLabel_1.setBounds(142, 140, 726, 48);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Inscribir En  Proyecto");
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btnNewButton_1.setBounds(302, 219, 406, 91);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Ver Perfil");
		btnNewButton_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btnNewButton_1_1.setBounds(302, 495, 406, 91);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Ver Inscripciones");
		btnNewButton_1_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btnNewButton_1_2.setBounds(302, 354, 406, 91);
		contentPane.add(btnNewButton_1_2);
		
		
	}
}
