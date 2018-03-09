package com.korail.control;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.korail.domain.AuthorizeVO;
import com.korail.domain.MemberVO;
import com.korail.dto.IdsearchDTO;
import com.korail.service.MemberService;
import com.korail.utillpage.AES256Util;

@Controller
@RequestMapping("/basic")
public class MemberController {
	 private String iv;
	 private Key keySpec;

	
	@Inject
	private MemberService memberService; 
	 
	
	@RequestMapping("/login")
	public void login() {	
		System.out.println("로그인시도");
	}
	
	@RequestMapping("/mainView2")
	public void mainView2() {
	}
	
	@RequestMapping(value="/loginpost", method = RequestMethod.POST)
	public String loginPOST(String member_Loginid,String member_Pw, 
			HttpSession session, HttpServletRequest request) throws Exception {
		
		MemberVO memberVO = memberService.login(member_Loginid,member_Pw);
		System.out.println(memberVO);
		
		if(memberVO != null) {
			session.setAttribute("memberVO", memberVO);
		}else if(memberVO == null)
		{
			System.out.println("로그인실패");
			return "redirect:login";
		}
		return "redirect:mainView";
	}
	
	@RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.setAttribute("memberVO", null);
        return "redirect:login";
    }
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public void memberInsertget() {
		System.out.println("야호");
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String memberInsert(MemberVO memberVO,RedirectAttributes attr) throws Exception {
		
		return "redirect:/basic/login";
	}
	
	@RequestMapping("sendEmail")
	public void name(String email,Model model) throws Exception {
	
		String tempCode = getRandomCode(8);//임시 코드 8자리 생성 
		
		AuthorizeVO authorizeVO= new AuthorizeVO();
		authorizeVO.setAuthorie_Mail(email);
		authorizeVO.setAuthorie_Code(tempCode);
	
		memberService.createAuthorize(authorizeVO);
		model.addAttribute("code", tempCode);
	}
	
	
	
	
	@RequestMapping(value= "/idsearch" ,method=RequestMethod.GET)
	public void idSearchGet() throws Exception {
	}
	@RequestMapping(value= "/idsearch" ,method=RequestMethod.POST)
	public void idSearchPost(IdsearchDTO idsearchDTO,Model model) throws Exception {
		System.out.println(idsearchDTO);
		String member_Loginid = memberService.idSearch(idsearchDTO);
		System.out.println(member_Loginid);
		model.addAttribute("member_Loginid",member_Loginid);
	}
	@RequestMapping("/mainView")
	public void mainPage() {
	}
	
	
	/*public String encrypt(String str) throws NoSuchAlgorithmException, GeneralSecurityException, UnsupportedEncodingException{
       //비밀번호 암호화 
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, KeySpec, new IvParameterSpec(iv.getBytes()));
        byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
        String enStr = new String(Base64.encodeBase64(encrypted));
        return enStr;
    }


	public String decrypt(String str) throws NoSuchAlgorithmException, GeneralSecurityException, UnsupportedEncodingException {
		//비밀번호 복호화
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
        byte[] byteStr = Base64.decodeBase64(str.getBytes());
        return new String(c.doFinal(byteStr), "UTF-8");
    }
*/

	public String getRandomCode(int length){//임시코드 생성 메소드 

        char[] charaters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
        StringBuffer sb = new StringBuffer();
        Random rn = new Random();

        for( int i = 0 ; i < length ; i++ ) {
            sb.append( charaters[ rn.nextInt( charaters.length ) ] );
        }
        return sb.toString();
    }

}
