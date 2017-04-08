/*
 * This package will provides implementation of sending of mail with java mail API. 
 */
package com.sendmail.all.type.org;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * This class will implements to send mail with attachment and without
 * attachment.
 * 
 * @author ravi ranjan kumar
 * @since 2017-04-08
 *
 */
public class SendAllTypeMail {

	/**
	 * This method will send mail in Text/Html format.
	 * 
	 * @param host
	 *            host name.
	 * @param port
	 *            port number.
	 * @param userName
	 *            sender mail address.
	 * @param password
	 *            sender mail password.
	 * @param toAddress
	 *            reciever's mail address.
	 * @param subject
	 *            subject of mail.
	 * @param messageBody
	 *            this is content of mail.
	 */

	public void sendEmail(final String host, final String port, final String userName, final String password,
			final String toAddress, final String subject, final String messageBody) {

		// set SMTP server properties.
		Properties prop = new Properties();
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", port);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", true);
		// Listing out all properties with actual data.
		System.out.println("the properties is : " + prop);
		// create a new session with authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};
		// create session
		Session session = Session.getInstance(prop, auth);
		// create new mime message
		Message message = new MimeMessage(session);
		try {
			// setting the sender's mail address.
			message.setFrom(new InternetAddress(userName));
			/*
			 * adding the all reciever's mail address to variable array
			 * toAddresses . can be more than one and can have from different
			 * domain.(Like: Gmail, outlook,yahoo, e.t.c, or custom)
			 */
			InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
			// setting recipients mail id information.
			message.setRecipients(Message.RecipientType.TO, toAddresses);
			// setting the subject line of mail.
			message.setSubject(subject);
			// setting the date.
			message.setSentDate(new Date());
			// set content type of message.
			message.setContent(messageBody, "text/html");
			// sends the e-mail
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method is responsible to send email with attachments.
	 * 
	 * @param host
	 *            host name.
	 * @param port
	 *            port number.
	 * @param userName
	 *            sender's mail address.
	 * @param password
	 *            sender's mail password.
	 * @param toAddress
	 *            reciever's mail address.
	 * @param subject
	 *            subject of mail.
	 * @param messageBody
	 *            content of mail.
	 * @param attchedFiles
	 *            file attached.
	 */

	public void sendEmailWithAttachment(final String host, final String port, final String userName,
			final String password, final String toAddress, final String subject, final String messageBody,
			String[] attchedFiles) {

		// set SMTP server properties.
		Properties prop = new Properties();
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", port);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.user", userName);
		prop.put("mail.password", password);
		// Listing out all properties with actual data.
		System.out.println("the properties is : " + prop);
		// create a new session with authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};
		// create session
		Session session = Session.getInstance(prop, auth);
		// create new mime message
		Message message = new MimeMessage(session);
		try {
			// setting the sender's mail address.
			message.setFrom(new InternetAddress(userName));
			/*
			 * adding the all reciever's mail address to variable array
			 * toAddresses . can be more than one and can have from different
			 * domain.(Like: Gmail, outlook,yahoo, e.t.c, or custom)
			 */
			InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
			// setting recipients mail id information.
			message.setRecipients(Message.RecipientType.TO, toAddresses);
			// setting the subject line of mail.
			message.setSubject(subject);
			// setting the date.
			message.setSentDate(new Date());

			// code goes here for attachment.
			/*
			 * create a new mime body part. this mime body is send text/ html
			 * content.
			 */
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(messageBody, "text/html");

			// creates multi-part to hold the attachments.
			Multipart multipart = new MimeMultipart();
			// here add message body for text/html data.
			multipart.addBodyPart(mimeBodyPart);

			// now add all the attachments.
			if (null != attchedFiles && attchedFiles.length > 0) {
				for (final String attchFile : attchedFiles) {
					// create mime body part to attach each file.
					MimeBodyPart attachPart = new MimeBodyPart();
					attachPart.attachFile(attchFile);
					multipart.addBodyPart(attachPart);
				}
			}

			// set content type of message as multi-part.
			message.setContent(multipart);
			// sends the e-mail
			Transport.send(message);
		} catch (MessagingException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
