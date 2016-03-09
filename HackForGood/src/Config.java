
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Config extends JDialog {
	
	private JPasswordField pwdCorreo;
	private JTextField textFieldEnvio;
	
	
	JRadioButton rdbtnSensorDeGas;
	JRadioButton rdbtnSensorDeHumedad;
	
	static boolean gas = false;
	static boolean humedad = false;
	static String correoDest = "";
	static String correoPropio = "";
	static String contra = "";
	private JTextField textFieldDestino;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			Config dialog = new Config();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public Config() {
		setResizable(false);
		setBounds(100, 100, 436, 269);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						/*Aplicar configuracion y cerrar*/
						if(rdbtnSensorDeGas.isSelected()){
							gas=true;
						}else{
							gas=false;
						}
						if(rdbtnSensorDeHumedad.isSelected()){
							humedad=true;
						}else{
							humedad=false;
						}
						if (!textFieldDestino.getText().isEmpty() ) correoDest = textFieldDestino.getText();
						if (!textFieldEnvio.getText().isEmpty() ) correoPropio = textFieldEnvio.getText();
						
						StringBuffer s = new StringBuffer();
						for(int i=0; i<pwdCorreo.getPassword().length;i++)
						{
							s.append(pwdCorreo.getPassword()[i]);
						}
						contra = s.toString();
						setVisible(false);
				}});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				pwdCorreo = new JPasswordField();
				pwdCorreo.setBounds(168, 123, 170, 28);
				pwdCorreo.setText("hackforgood");
				panel.add(pwdCorreo);
			}
			
			textFieldEnvio = new JTextField();
			textFieldEnvio.setText("berryteamleon@gmail.com");
			textFieldEnvio.setToolTipText("");
			textFieldEnvio.setBounds(168, 77, 170, 28);
			panel.add(textFieldEnvio);
			textFieldEnvio.setColumns(10);
			
			JLabel lblCorreoElectronico = new JLabel("Correo Envio");
			lblCorreoElectronico.setBounds(12, 77, 100, 28);
			panel.add(lblCorreoElectronico);
			
			JLabel lblContrasea = new JLabel("Contrase\u00F1a");
			lblContrasea.setBounds(12, 123, 100, 28);
			panel.add(lblContrasea);
			
			rdbtnSensorDeGas = new JRadioButton("Sensor de Gas");
			rdbtnSensorDeGas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			rdbtnSensorDeGas.setBounds(56, 159, 133, 46);
			panel.add(rdbtnSensorDeGas);
			
			rdbtnSensorDeHumedad = new JRadioButton("Sensor de humedad");
			rdbtnSensorDeHumedad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			rdbtnSensorDeHumedad.setBounds(212, 159, 133, 46);
			panel.add(rdbtnSensorDeHumedad);
			
			JLabel lblCorreoDestino = new JLabel("Correo Destino");
			lblCorreoDestino.setBounds(12, 23, 123, 28);
			panel.add(lblCorreoDestino);
			
			textFieldDestino = new JTextField();
			textFieldDestino.setText("pablo.gonzalez.alvarez1@gmail.com");
			textFieldDestino.setColumns(10);
			textFieldDestino.setBounds(168, 23, 170, 28);
			panel.add(textFieldDestino);
		}
	}
	}
