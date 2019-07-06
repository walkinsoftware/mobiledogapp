package com.ws.spring.email.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {

	Logger logger = LogManager.getLogger(this.getClass().getName());

	@Autowired
	public MailSender emailSender;

	public void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}

	/*
	 * public String sendMail(String recepientId,String subject, String content) {
	 * MimeMessage message = emailSender.createMimeMessage(); MimeMessageHelper
	 * helper = new MimeMessageHelper(message);
	 * 
	 * try { helper.setTo(recepientId); helper.setText(content);
	 * helper.setSubject(subject); } catch (MessagingException e) {
	 * e.printStackTrace(); return "Error while sending mail .."; }
	 * emailSender.send(message); return "Mail Sent Success!"; }
	 * 
	 * public String sendMailInHTML(String recepientId,String subject, String
	 * content,boolean isHtml) { MimeMessage message =
	 * emailSender.createMimeMessage(); MimeMessageHelper helper = new
	 * MimeMessageHelper(message);
	 * 
	 * try { helper.setTo(recepientId); helper.setText(content);
	 * helper.setSubject(subject); } catch (MessagingException e) {
	 * e.printStackTrace(); return "Error while sending mail .."; }
	 * emailSender.send(message); return "Mail Sent Success!"; }
	 * 
	 * public void send(EmailBean eParams) {
	 * 
	 * if (eParams.isHtml()) { try { sendHtmlMail(eParams); } catch
	 * (MessagingException e) {
	 * logger.error("Could not send email to : {} Error = {}",
	 * eParams.getToAsList(), e.getMessage()); } } else {
	 * sendPlainTextMail(eParams); }
	 * 
	 * }
	 * 
	 * private void sendHtmlMail(EmailBean eParams) throws MessagingException {
	 * 
	 * boolean isHtml = true;
	 * 
	 * MimeMessage message = emailSender.createMimeMessage(); MimeMessageHelper
	 * helper = new MimeMessageHelper(message);
	 * helper.setTo(eParams.getTo().toArray(new String[eParams.getTo().size()]));
	 * helper.setSubject(eParams.getSubject()); helper.setText(eParams.getMessage(),
	 * isHtml);
	 * 
	 * if (eParams.getCc().size() > 0) { helper.setCc(eParams.getCc().toArray(new
	 * String[eParams.getCc().size()])); }
	 * 
	 * emailSender.send(message); }
	 * 
	 * private void sendPlainTextMail(EmailBean eParams) {
	 * 
	 * SimpleMailMessage mailMessage = new SimpleMailMessage();
	 * 
	 * eParams.getTo().toArray(new String[eParams.getTo().size()]);
	 * mailMessage.setTo(eParams.getTo().toArray(new
	 * String[eParams.getTo().size()]));
	 * mailMessage.setSubject(eParams.getSubject());
	 * mailMessage.setText(eParams.getMessage());
	 * 
	 * if (eParams.getCc().size() > 0) {
	 * mailMessage.setCc(eParams.getCc().toArray(new
	 * String[eParams.getCc().size()])); }
	 * 
	 * emailSender.send(mailMessage);
	 * 
	 * }
	 */
}
