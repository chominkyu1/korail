package com.korail.utillpage;


import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.codec.binary.Base64;

import com.korail.domain.AuthorizeVO;

public class MemberJoinUtil {
	//ȸ�����Խ� �ʿ��� �޼ҵ�
	
	 private String iv;
	 private Key keySpec;

	
	public int getRandomCode(int length){//�ӽ��ڵ� ���� �޼ҵ� 

		String numStr = "1";
	    String plusNumStr = "1";
	 
	    for (int i = 0; i < length; i++) {
	        numStr += "0";
	 
	        if (i != length - 1) {
	            plusNumStr += "0";
	        }
	    }
	 
	    Random random = new Random();
	    int result = random.nextInt(Integer.parseInt(numStr)) + Integer.parseInt(plusNumStr);
	 
	    if (result > Integer.parseInt(numStr)) {
	        result = result - Integer.parseInt(plusNumStr);
	    }
	 
	    return result;
    }
	
	 //@RequestMapping("authMail")
	 public void mailSender(AuthorizeVO authorizeVO, String category) 
			                                 throws AddressException, MessagingException{
		System.out.println(">>>>>>>>>>>>>>>>>>>>>> mailSender");
		//�̸��� ������ �޼ҵ�
		
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
			body = "ȸ������ �����ڵ�� ["+authorizeVO.getAuthorize_Code()+"] �Դϴ�. ȸ������ ����â�� ��Ȯ�� �Է����ּ��� ~!";
			
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
	 
	 public void AES256Util(String key) throws UnsupportedEncodingException {

	        this.iv = key.substring(0, 16);
	        byte[] keyBytes = new byte[16];
	        byte[] b = key.getBytes("UTF-8");
	        int len = b.length;
	        
	        if(len > keyBytes.length){
	            len = keyBytes.length;
	        }

	        System.arraycopy(b, 0, keyBytes, 0, len);
	        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
	        this.keySpec = keySpec;
	    }


	   public String encrypt(String member_Pw) throws NoSuchAlgorithmException, GeneralSecurityException, UnsupportedEncodingException{
	       //��й�ȣ ��ȣȭ 
			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
	        byte[] encrypted = c.doFinal(member_Pw.getBytes("UTF-8"));
	        String enStr = new String(Base64.encodeBase64(encrypted));
	        return enStr;
	    }


		public String decrypt(String member_Pw) throws NoSuchAlgorithmException, GeneralSecurityException, UnsupportedEncodingException {
			//��й�ȣ ��ȣȭ
	        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
	        byte[] byteStr = Base64.decodeBase64(member_Pw.getBytes());
	        return new String(c.doFinal(byteStr), "UTF-8");
	    }

}
