package com.ecommerce.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;



public class MailSender {
	
	public int sendRegistrationConformation(String toEmail) throws IOException {
		System.out.println("Inside mail sender");
		// the sender email should be the same as we used to Create a Single Sender Verification
		    Email from = new Email("saikrishnareddy9291@gmail.com");
		    String subject = "Registration Successful";
		    Email to = new Email("saikrishnareddy9291@gmail.com");
		    Content content = new Content("text/plain", "This is a test email");
		    Mail mail = new Mail(from, subject, to, content);
		
		    SendGrid sg = new SendGrid("SENDGRID_API_KEY");
		    Request request = new Request();
		    try {
		      request.setMethod(Method.POST);
		      request.setEndpoint("mail/send");
		      request.setBody(mail.build());
		      Response response = sg.api(request);
		      System.out.println("response :" + response.getStatusCode());
		      System.out.println("response.getbody()  :" + response.getBody());
		      //logger.info(response.getBody());
		      return response.getStatusCode();	     
		    } catch (IOException ex) {
		      throw ex;
		    }	   
	}
	
	
	
	public int forgotPassword(String toEmail) throws IOException {
		System.out.println("Inside mail sender");
		// the sender email should be the same as we used to Create a Single Sender Verification
		    Email from = new Email("saikrishnareddy9291@gmail.com");
		    String subject = "Reset password link";
		    Email to = new Email("saikrishnareddy9291@gmail.com");
		    Content content = new Content("text/plain", "reset password should be sent using html code");
		    Mail mail = new Mail(from, subject, to, content);
		
		    SendGrid sg = new SendGrid("SENDGRID_API_KEY");
		    Request request = new Request();
		    try {
		      request.setMethod(Method.POST);
		      request.setEndpoint("mail/send");
		      request.setBody(mail.build());
		      Response response = sg.api(request);
		      System.out.println("response :" + response.getStatusCode());
		      System.out.println("response.getbody()  :" + response.getBody());
		      //logger.info(response.getBody());
		      return response.getStatusCode();	     
		    } catch (IOException ex) {
		      throw ex;
		    }	   
	}
	
	
	public int updatePassword(String toEmail) throws IOException {
		System.out.println("Inside mail sender");
		// the sender email should be the same as we used to Create a Single Sender Verification
		    Email from = new Email("saikrishnareddy9291@gmail.com");
		    String subject = "update email password link";
		    Email to = new Email("saikrishnareddy9291@gmail.com");
		    Content content = new Content("text/plain", "reset password should be sent using html code");
		    Mail mail = new Mail(from, subject, to, content);
		
		    SendGrid sg = new SendGrid("SENDGRID_API_KEY");
		    Request request = new Request();
		    try {
		      request.setMethod(Method.POST);
		      request.setEndpoint("mail/send");
		      request.setBody(mail.build());
		      Response response = sg.api(request);
		      System.out.println("response :" + response.getStatusCode());
		      System.out.println("response.getbody()  :" + response.getBody());
		      //logger.info(response.getBody());
		      return response.getStatusCode();	     
		    } catch (IOException ex) {
		      throw ex;
		    }	   
	}

}
