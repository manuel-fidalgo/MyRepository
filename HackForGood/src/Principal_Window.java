import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Principal_Window {

	private JFrame frame;
	public Activities_Window act_win;
	public Config configuracion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DomoticaCocina.domoticaCocina(null);
					Principal_Window window = new Principal_Window();
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
	public Principal_Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		configuracion = new Config();
		act_win = new Activities_Window();
		frame = new JFrame();
		frame.setTitle("HackForAlzehimer");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				act_win.getFrame().setVisible(true);
			}
		});
		panel.setLayout(new BorderLayout());
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Runtime.getRuntime().exec("epiphany http://www.afal.es/ https://www.youtube.com/watch?v=IO8nPGljnOs&list=PLkbIYEqD5xixqKNTK2mfFhEfOrCYw46oc http://www.alzheimerleon.org/");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					try {
						Runtime.getRuntime().exec("epiphany https://www.youtube.com/watch?v=IO8nPGljnOs&list=PLkbIYEqD5xixqKNTK2mfFhEfOrCYw46oc");
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			}
		});
		panel_1.setLayout(new BorderLayout());
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				configuracion.setVisible(true);
				
			}
		});
		panel_2.setLayout(new BorderLayout());
		frame.getContentPane().add(panel_2);
		
		/*A�adimos la imagenes de cada panel*/
		Imagen[] images = {new Imagen("1.jpg"), new Imagen("2.jpg"), new Imagen("3.jpg")};
		
		panel.add(images[0],BorderLayout.CENTER);
		panel.repaint();
		panel_1.add(images[1],BorderLayout.CENTER);
		panel_1.repaint();
		panel_2.add(images[2],BorderLayout.CENTER);
		panel_2.repaint();
			
	}

}
