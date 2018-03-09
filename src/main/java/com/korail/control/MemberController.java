package com.korail.control;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.korail.domain.AuthorizeVO;
import com.korail.domain.MemberVO;
import com.korail.service.MemberService;
import com.korail.utillpage.MemberJoinUtil;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
@RequestMapping("/basic")
public class MemberController {

	@Inject
	private MemberService memberService;

	@RequestMapping("/login")
	public void login() {
		System.out.println("로그인시도");
	}

	@RequestMapping("/mainView2")
	public void mainView2() {
	}

	@RequestMapping(value = "/loginpost", method = RequestMethod.POST)
	public String loginPOST(String member_Loginid, String member_Pw, HttpSession session, HttpServletRequest request)
			throws Exception {

		MemberVO MemberVO = memberService.login(member_Loginid, member_Pw);
		System.out.println(MemberVO);

		if (MemberVO != null) {
			session.setAttribute("MemberVO", MemberVO);
		} else if (MemberVO == null) {
			System.out.println("로그인실패");
			return "redirect:login";
		}
		return "redirect:mainView";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("MemberVO", null);
		return "redirect:login";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void memberInsertget() {
		System.out.println("회원가입 창");
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String memberInsert(HttpServletRequest request, RedirectAttributes attr) throws Exception {
		// 회원 가입

		String saveDir = request.getServletContext().getRealPath("resources/img/imgMember");
		System.out.println("저장경로 saveDir >>>" + saveDir);
		int maxSize = 5 * 1025 * 1024;

		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());
		// ---------------- 파일 업로드 END ------------------------

		String path = "resources/img/imgMember";

		String member_Profile = path + "/" + multi.getFilesystemName("member_Profile");
		String member_Birth = multi.getParameter("member_Birth").replace("-", "");
		String member_Email = multi.getParameter("authorized_Mail");
		String tempCode = multi.getParameter("authorized_Code");// 회원가입시 인증받은 코드
		String authorize_Id = memberService.selectAuthId(member_Email, tempCode);

		MemberVO MemberVO = new MemberVO();
		MemberVO.setMember_Loginid(multi.getParameter("member_Loginid"));
		MemberVO.setMember_Pw(multi.getParameter("member_Pw"));
		MemberVO.setMember_Name(multi.getParameter("member_Name"));
		MemberVO.setMember_Ques(multi.getParameter("member_Ques"));
		MemberVO.setMember_Answer(multi.getParameter("member_Answer"));
		MemberVO.setMember_Addr(multi.getParameter("member_Addr"));
		MemberVO.setMember_Gender(multi.getParameter("member_Gender"));
		MemberVO.setMember_Birth(member_Birth);
		MemberVO.setMember_Profile(member_Profile);
		MemberVO.setMember_Type("1");// 회원 1 or 관리자 0 - 타입생성 추후 보완
		MemberVO.setMember_Email(member_Email);
		MemberVO.setMember_Phone(multi.getParameter("member_Phone"));
		MemberVO.setAuthorize_Id(authorize_Id);
		

		System.out.println(MemberVO);
		memberService.insert(MemberVO);

		return "redirect:/basic/login";
	}

	@RequestMapping("/sendEmail")
	public @ResponseBody String sendEmail(String email, Model model) throws Exception {
		System.out.println("sendEmail 메소드 진입 / 회원 이메일 :" + email);
		// 회원가입시 이메일 인증
		MemberJoinUtil util = new MemberJoinUtil();
		String tempCode = Integer.toString(util.getRandomCode(8));// 임시 코드 8자리 생성

		System.out.println("sendEmail>tempCode>>>" + tempCode);

		AuthorizeVO authorizeVO = new AuthorizeVO();
		authorizeVO.setAuthorize_Mail(email);
		authorizeVO.setAuthorize_Code(tempCode);

		util.mailSender(authorizeVO, "sendTempCode");
		memberService.createAuthorize(authorizeVO);
		model.addAttribute("tempCode", tempCode);

		return tempCode;
	}

	@RequestMapping(value = "/idsearch", method = RequestMethod.GET)
	public void idSearchGet() throws Exception {
	}

	@RequestMapping(value = "/idsearch", method = RequestMethod.POST)
	public void idSearchPost(Model model) throws Exception {

	}

	@RequestMapping("/mainView")
	public void mainPage() {
	}

	/*@RequestMapping("validID")
	public @ResponseBody int validID(String keyword) {
		
	   return memberService.validID(keyword);
	}*/
}
