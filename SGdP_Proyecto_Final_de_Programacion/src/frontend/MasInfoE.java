package frontend;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import backend.Estudiante;

public class MasInfoE extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	
	public MasInfoE(Estudiante usuario, int id) {
		setTitle("Más Información");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		setSize(1024, 768);								
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel_1 = new JLabel("MÁS INFORMACIÓN");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Artifakt Element", Font.BOLD, 40));
		lblNewLabel_1.setBounds(141, 65, 726, 48);
		contentPane.add(lblNewLabel_1);
	}

}