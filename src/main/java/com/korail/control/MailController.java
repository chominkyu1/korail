package com.korail.control;

import java.util.Properties;

import javax.inject.Inject;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import com.korail.domain.AuthorizeVO;
import com.korail.service.MemberService;


@Controller
public class MailController {
	
	@Inject
	private MemberService memberService; 
	
	public void mailSender(AuthorizeVO authorizeVO, String category, ModelMap mo) throws AddressException, MessagingException{
		
		String host = "smtp.naver.com";
		
		final String username = "jmk2618";
		final String password = "Hayate7754";
		int port=465;
		
		String recipient = null;
		String subject =null;
		String body =null;
		
		if (category.equals("sendTempCode")) {//ȸ������ �����ڵ� 	�߼��϶� 
			
			recipient = authorizeVO.getAuthorize_Mail();
			subject = "ȸ������ �����ڵ��Դϴ�.";
			body = "ȸ������ �����ڵ�� "+authorizeVO.getAuthorize_Code()+" �Դϴ�. ȸ������ ����â�� ��Ȯ�� �Է����ּ��� ~!";
			
		}else if (category.equals("sendTempPass")) {//�ӽú�й�ȣ �߼��϶� 
			
			String tempPassword = "";
			for (int i = 0; i < 8; i++) {
				int rndVal = (int) (Math.random() * 62);
				if (rndVal < 10) {
					tempPassword += rndVal;
				} else if (rndVal > 35) {
					tempPassword += (char) (rndVal + 61);
				} else {
					tempPassword += (char) (rndVal + 55);
				}
			}
			
			recipient = "hayate7754@gmail.com";
			subject = "�űԾ�ȣ�Դϴ�.";
			body = "����Ⱦ�ȣ�� "+tempPassword+" �Դϴ�.";
			
			
		}
		
		
		Properties props = System.getProperties();

		props.put("mail.smtp.host", host); 
		props.put("mail.smtp.port", port); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.ssl.enable", "true"); 
		props.put("mail.smtp.ssl.trust", host);

		Session session = Session.getDefaultInstance(props,new Authenticator() {
			String un = username;
			String pw = password;
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() { 
				return new javax.mail.PasswordAuthentication(un, pw); 
				}
		});
		
		session.setDebug(true);
		
		Message mimeMessage = new MimeMessage(session);
		mimeMessage.setFrom(new InternetAddress("jmk2618@naver.com"));
		
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		
		mimeMessage.setSubject(subject); 
		mimeMessage.setText(body);
		Transport.send(mimeMessage); 

	}

}
