
package pe.kamwha.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import pe.kamwha.dao.impl.ReservaDaoImpl;
import pe.kamwha.model.ReservaModel;


public class CorreoUtil {
    
    public void enviarCorreo(ReservaModel beanReserva){
    	Properties props = new Properties();
      
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.auth", "true");
        
        Session session = Session.getDefaultInstance(props);
        
        ReservaDaoImpl reservaDaoImpl = new ReservaDaoImpl();
        ReservaModel bean = reservaDaoImpl.enviarCorreoCliente(beanReserva);
        
        String correoRemitente = "chifa.kam.wha1@gmail.com";
        String contrasena = "chifakamwhaadmin";
        String correoReceptor = bean.getCliente().getClienteEmail();
        String asunto = "Gracias por su reserva. Chifa Kam Wha";
        String mensajePrincipal = "Estimado(a), \n" + bean.getCliente().getClienteNombres() + " " +  bean.getCliente().getClienteApePaterno() + " " + bean.getCliente().getClienteApeMaterno() + " con D.N.I. " + bean.getCliente().getClienteDni()
        		+ "\nSe realizo una reserva en una de nuestras mesas para el día " + bean.getReservafecha() + " con un codigo de Identificación " + bean.getReservaID()
        		+ "\nRecuerde que podra comunicarse con nosotros, tambien nos estaremos comunicando con usted por su num. telefonico proporcionado. "
        		+ "\n\nAtt. Gerente."
        		+ "\nChifa Kam Wha.\n";
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(correoRemitente));
            
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            
            message.setSubject(asunto);
            message.setText(mensajePrincipal);
            
            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, contrasena);

            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

        } catch (MessagingException ex) {
            System.out.println("Error en message de enviar Correo Util: " + ex);
        }
    }
    
}
