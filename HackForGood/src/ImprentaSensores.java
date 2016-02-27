import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class ImprentaSensores {

	private JFrame frame;

	static JTextPane textPaneGas = new JTextPane();
	/**
	 * Launch the application.
	 */
	public static void imprentaSensores(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImprentaSensores window = new ImprentaSensores();
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
	public ImprentaSensores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 442, 205);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblGas = new JLabel("ppm");
		lblGas.setBounds(84, 12, 70, 15);
		panel.add(lblGas);
		
		JLabel lblHumedad = new JLabel("humedad");
		lblHumedad.setBounds(255, 12, 70, 15);
		panel.add(lblHumedad);
		
		
		textPaneGas.setBounds(101, 67, 6, 21);
		panel.add(textPaneGas);
		
	}
}
