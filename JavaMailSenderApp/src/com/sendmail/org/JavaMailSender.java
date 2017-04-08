package com.sendmail.org;

import java.util.Arrays;

import com.sendmail.all.type.org.SendAllTypeMail;

/**
 * This class accepts all input to setup java mail to send mail.
 * 
 * @author ravi ranjan kumar
 *
 */
public class JavaMailSender {

	/**
	 * This method is responsible to send a plain text mail.
	 * 
	 * @param sendMail
	 */
	private static void sendPlainTextMail(final SendAllTypeMail sendMail) {
		// define host name
		String host = "smtp.gmail.com";
		// port number
		String port = "587";
		// sender Email Id.
		String mailFrom = "your_mail_id";
		// sender Email Password.
		String password = "your_mail_passowrd";

		// outgoing message information
		// reciever's email Id
		String mailTo = "raviranjankumar.cse@gmail.com";
		// subject Line of Email.
		String subject = "Hi Ravi,";
		// message Body
		String message = "Hope you enjoying your weekends.";

		try {
			// sending email.
			sendMail.sendEmail(host, port, mailFrom, password, mailTo, subject, message);

			System.out.println("Email sent.");
		} catch (Exception ex) {
			System.out.println("Failed to sent email.");
			ex.printStackTrace();
		}

	}

	/**
	 * This method is responsible to send an <HTML>HTML</HTML> Formatted mail.
	 * 
	 * @param sendMail
	 */
	private static void sendHtmlMail(final SendAllTypeMail sendMail) {
		// define host name
		String host = "smtp.gmail.com";
		// port number
		String port = "587";
		// sender Email Id.
		String mailFrom = "your_mail_id";
		// sender Email Password.
		String password = "your_mail_passowrd";

		// outgoing message information
		// reciever's email Id
		String mailTo = "raviranjankumar.cse@gmail.com";
		// subject Line of Email.
		String subject = "This is an HTML Format Mail.";
		// message Body
		String message = "<i>Greetings From Ravi.</i><br/>"
				+ "<p style=\"color:red;background-color:green;font-size:50px\">This is paragraph of html</p>";

		try {
			// sending email.
			sendMail.sendEmail(host, port, mailFrom, password, mailTo, subject, message);

			System.out.println("HTMML formatted Email sent.");
		} catch (Exception ex) {
			System.out.println("Failed to sent email.");
			ex.printStackTrace();
		}

	}

	/**
	 * This method is responsible to send Email with attachments.
	 * 
	 * @param sendMail
	 */
	private static void sendEmailWithAttachment(final SendAllTypeMail sendMail) {
		// define host name
		String host = "smtp.gmail.com";
		// port number
		String port = "587";
		// sender Email Id.
		String mailFrom = "your_mail_id";
		// sender Email Password.
		String password = "your_mail_passowrd";

		// outgoing message information
		// reciever's email Id
		String mailTo = "raviranjankumar.cse@gmail.com";
		// subject Line of Email.
		String subject = "Attachment Email.";
		// message Body
		String message = "<i>Greetings From Ravi.</i><br/>"
				+ "<p style=\"color:red;background-color:green;font-size:50px\">Find all attachment" + "<br/>"
				+ "<h1 style=\"color:pink\">Mp3, Pdf, Image</h1>" + "</p>";
		// providing file name
		String[] attachFiles = new String[3];
		attachFiles[0] = "E:\\BOOKS (in pdf)\\algorithm-book-by-karumanchi.pdf";
		attachFiles[1] = "F:\\PHOTO\\mypic.jpg";
		attachFiles[2] = "F:\\MUSIC\\MIXED SONG\\01 bindaas.mp3";
		System.out.println("the attached file locations are : " + Arrays.toString(attachFiles));
		try {
			// sending email.
			sendMail.sendEmailWithAttachment(host, port, mailFrom, password, mailTo, subject, message, attachFiles);

			System.out.println("Attchment Email sent.");
		} catch (Exception ex) {
			System.out.println("Failed to sent email.");
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		/*
		 * creating an instance of class where all setup is written to send a
		 * mail.
		 */
		SendAllTypeMail sendMail = new SendAllTypeMail();

		// send a plain text mail.
		sendPlainTextMail(sendMail);

		// send an HTML formatted mail.
		sendHtmlMail(sendMail);

		// send Email with attchments.can be more than one attachment.
		// sendEmailWithAttachment(sendMail);
	}

}
