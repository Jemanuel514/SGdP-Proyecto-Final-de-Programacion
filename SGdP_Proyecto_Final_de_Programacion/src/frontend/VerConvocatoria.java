package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class VerConvocatoria {

	private JFrame frmAsdasd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerConvocatoria window = new VerConvocatoria();
					window.frmAsdasd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VerConvocatoria() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAsdasd = new JFrame();
		frmAsdasd.setBounds(100, 100, 967, 679);
		frmAsdasd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAsdasd.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VER CONVOCATORIAS");
		lblNewLabel.setForeground(new Color(128, 128, 128));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNewLabel.setBounds(241, 73, 465, 61);
		frmAsdasd.getContentPane().add(lblNewLabel);
	}

}
