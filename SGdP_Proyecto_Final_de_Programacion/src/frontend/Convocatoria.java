package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Convocatoria {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Convocatoria window = new Convocatoria();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Convocatoria() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PUBLICAR CONVOCATORIA");
		lblNewLabel.setForeground(new Color(128, 128, 128));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNewLabel.setBounds(234, 42, 565, 71);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del proyecto");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(45, 169, 196, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Horario");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(45, 264, 196, 24);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Lugar de Ejecucion");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(45, 367, 196, 24);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Horas otorgadas");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(45, 474, 196, 24);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(45, 204, 232, 42);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(45, 299, 232, 42);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(45, 402, 232, 42);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(45, 509, 232, 42);
		frame.getContentPane().add(textField_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Requisitos de los estudiantes");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(444, 169, 279, 24);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(444, 204, 279, 125);
		frame.getContentPane().add(textField_4);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Detalles adicionales");
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(444, 367, 279, 24);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(444, 402, 279, 125);
		frame.getContentPane().add(textField_5);
		
		JButton btnNewButton = new JButton("Hacer convocatoria");
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btnNewButton.setBounds(742, 623, 241, 42);
		frame.getContentPane().add(btnNewButton);
	}
}
