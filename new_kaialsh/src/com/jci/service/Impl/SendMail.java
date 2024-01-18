package com.jci.service.Impl;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

 
public class SendMail {

	 public void sendEmail(String to, String body, String subject, String filename, String username)
	 {
		 String from = "cyfuturejavateam14@gmail.com";
		 Properties prop = new Properties();
		 prop.put("mail.smtp.auth",true);
		 prop.put("mail.smtp.starttls.enable",true);
		 prop.put("mail.smtp.port","587");
		 prop.put("mail.smtp.host","smtp.gmail.com");
		 prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		 prop.put("mail.smtp.ssl.protocols","TLSv1.2");
		 String user = "cyfuturejavateam14";
		 String pass = "myqnupehvjafufaz";
		 Session session = Session.getInstance(prop, new Authenticator() {
		 @Override
		 protected PasswordAuthentication getPasswordAuthentication()
		 {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(user,pass);
			}
		});
		 
		 try {
			 
			 Message message = new MimeMessage(session);
			 //message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
			 
			 message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			 
			 
			 message.setFrom(new InternetAddress(from));
			 message.setSubject(subject);
			 
	         BodyPart messageBodyPart = new MimeBodyPart();
	         messageBodyPart.setText(body);
	         
	         Multipart multipart = new MimeMultipart();
	         multipart.addBodyPart(messageBodyPart);
	         
	         messageBodyPart = new MimeBodyPart();
	         
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(username);
	         multipart.addBodyPart(messageBodyPart);
	         message.setContent(multipart);
	         Transport.send(message);

	         System.out.println("Sent message successfully....");
			 
			 }catch(Exception e)
			 {
				 System.out.println("error in sending mail"+e);
				 e.printStackTrace();
			 }
	 }
	    
}
