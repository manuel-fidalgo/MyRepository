

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class VentanaSensores {

	private JFrame frame;
	private JLabel lblHumedad;
	private JTextField textField;
	private JLabel lblGas;
	private JTextField textField_1;
	private JLabel lblPpm;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSensores window = new VentanaSensores();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	/**
	 * Create the application.
	 */
	public VentanaSensores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblHumedad = new JLabel("Humedad");
		lblHumedad.setBounds(60, 92, 67, 15);
		frame.getContentPane().add(lblHumedad);
		
		textField = new JTextField();
		textField.setBounds(132, 90, 114, 19);
		textField.setText("lectura");
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblGas = new JLabel("Gas");
		lblGas.setBounds(60, 168, 27, 15);
		frame.getContentPane().add(lblGas);
		
		lblPpm = new JLabel("ppm");
		lblPpm.setBounds(272, 168, 30, 15);
		frame.getContentPane().add(lblPpm);
		
		textField_1 = new JTextField();
		textField_1.setBounds(132, 164, 114, 19);
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField_1.setText("lectura");
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnAceptar.setBounds(132, 214, 117, 25);
		frame.getContentPane().add(btnAceptar);
	}
}