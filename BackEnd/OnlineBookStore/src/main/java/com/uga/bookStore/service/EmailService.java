package com.uga.bookStore.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.uga.bookStore.model.Response;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private Configuration config;

	public Response sendEmailVerification(String toEmail, String subject, Map<String, Object> model) {
		Response response = new Response();
		try {

			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,
					MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
			Template t = config.getTemplate("emailTemplate.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

			mimeMessageHelper.setFrom("chaitu392@gmail.com");
			mimeMessageHelper.setTo(toEmail);
			mimeMessageHelper.setText(html, true);
			mimeMessageHelper.setSubject(subject);
			javaMailSender.send(mimeMessage);
			response.setMessage("Mail sent successfully");
			response.setStatus(Boolean.TRUE);
		} catch (MessagingException | IOException | TemplateException e) {
			response.setMessage("Error ending mail" + e.getMessage());
			response.setStatus(Boolean.FALSE);
		}
		return response;
	}

	public Response sendEmailNotification(String email, String subject, String body) {
		Response response = new Response();
		try {

			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,
					MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

			mimeMessageHelper.setFrom("chaitu392@gmail.com");
			mimeMessageHelper.setTo(email);
			mimeMessageHelper.setText(body);
			mimeMessageHelper.setSubject(subject);
			javaMailSender.send(mimeMessage);
			response.setMessage("Mail sent successfully");
			response.setStatus(Boolean.TRUE);
		} catch (MessagingException e) {
			response.setMessage("Error ending mail" + e.getMessage());
			response.setStatus(Boolean.FALSE);
		}
		return response;
	}

	public Response sendEmailOTP(String toEmail, String subject, Map<String, Object> model) {
		Response response = new Response();
		try {

			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,
					MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
			Template t = config.getTemplate("forgotPasswordTemplate.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

			mimeMessageHelper.setFrom("chaitu392@gmail.com");
			mimeMessageHelper.setTo(toEmail);
			mimeMessageHelper.setText(html, true);
			mimeMessageHelper.setSubject(subject);
			javaMailSender.send(mimeMessage);
			response.setMessage("Mail sent successfully");
			response.setStatus(Boolean.TRUE);
		} catch (MessagingException | IOException | TemplateException e) {
			response.setMessage("Error ending mail" + e.getMessage());
			response.setStatus(Boolean.FALSE);
		}
		return response;
	}

	public Response sendPromoDetailsEmail(String toEmail, String subject, Map<String, Object> model) {
		Response response = new Response();
		try {

			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,
					MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
			Template t = config.getTemplate("promoTemplate.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

			mimeMessageHelper.setFrom("chaitu392@gmail.com");
			mimeMessageHelper.setTo(toEmail);
			mimeMessageHelper.setText(html, true);
			mimeMessageHelper.setSubject(subject);
			javaMailSender.send(mimeMessage);
			response.setMessage("Mail sent successfully");
			response.setStatus(Boolean.TRUE);
		} catch (MessagingException | IOException | TemplateException e) {
			response.setMessage("Error ending mail" + e.getMessage());
			response.setStatus(Boolean.FALSE);
		}
		return response;
	}

	public Response sendPlaceOrderEmail(String toEmail, String subject, Map<String, Object> model) {
		Response response = new Response();
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,
					MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
			Template t = config.getTemplate("orderConfirmationTemplate.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
			mimeMessageHelper.setFrom("chaitu392@gmail.com");
			mimeMessageHelper.setTo(toEmail);
			mimeMessageHelper.setText(html, true);
			mimeMessageHelper.setSubject(subject);
			javaMailSender.send(mimeMessage);
			response.setMessage("Mail sent successfully");
			response.setStatus(Boolean.TRUE);
		} catch (MessagingException | IOException | TemplateException e) {
			response.setMessage("Error ending mail" + e.getMessage());
			response.setStatus(Boolean.FALSE);
		}
		return response;
	}

}
