

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Sensores implements Runnable {

	private String valor;
	
	static boolean alertaSaltado = false;
	
	ImprentaSensores imprentaSensorGas = new ImprentaSensores();
	
	
	public Sensores(String valorAux){
		valor = valorAux;
	}
	
	@Override
	public void run() {
		// Si es un valor de gas
		if ( valor.charAt(0) == 'g'){
			int valorInt = Integer.parseInt(valor.substring(1));
			if ( valorInt > 300 && Config.gas){
				System.out.println("eureka");
				if ( alertaSaltado == false){
				alertaSaltado = true;
				JOptionPane.showMessageDialog(null, "Alerta de Gas");
				
				try{
					SendMailTLS sendMail = new SendMailTLS();
					sendMail.run();
					System.out.println("envio");
					} catch (Exception e){
					}
				}
			}
			
		}
		// Si es un valor de humedad
		if ( valor.charAt(0) == 'h'){
			int valorInt = Integer.parseInt(valor.substring(1));
			if ( valorInt < 500 && Config.humedad){
				JOptionPane.showMessageDialog(null, "Planta excesivamente húmeda");
			}
		}
	}	
	
public static void enviarMail(String[] args) {

		
		final String username = Config.correoPropio;
		final String password = Config.contra;

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			System.out.println(username);
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(Config.correoDest));
			message.setSubject("Alarma Gas");
			message.setText("Estimado hijo ha saltado la alarma de gas");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
