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
		System.out.println("�α��νõ�");
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
			System.out.println("�α��ν���");
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
		System.out.println("ȸ������ â");
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String memberInsert(HttpServletRequest request, RedirectAttributes attr) throws Exception {
		// ȸ�� ����

		String saveDir = request.getServletContext().getRealPath("resources/img/imgMember");
		System.out.println("������ saveDir >>>" + saveDir);
		int maxSize = 5 * 1025 * 1024;

		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());
		// ---------------- ���� ���ε� END ------------------------

		String path = "resources/img/imgMember";

		String member_Profile = path + "/" + multi.getFilesystemName("member_Profile");
		String member_Birth = multi.getParameter("member_Birth").replace("-", "");
		String member_Email = multi.getParameter("authorized_Mail");
		String tempCode = multi.getParameter("authorized_Code");// ȸ�����Խ� �������� �ڵ�
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
		MemberVO.setMember_Type("1");// ȸ�� 1 or ������ 0 - Ÿ�Ի��� ���� ����
		MemberVO.setMember_Email(member_Email);
		MemberVO.setMember_Phone(multi.getParameter("member_Phone"));
		MemberVO.setAuthorize_Id(authorize_Id);
		

		System.out.println(MemberVO);
		memberService.insert(MemberVO);

		return "redirect:/basic/login";
	}

	@RequestMapping("/sendEmail")
	public @ResponseBody String sendEmail(String email, Model model) throws Exception {
		System.out.println("sendEmail �޼ҵ� ���� / ȸ�� �̸��� :" + email);
		// ȸ�����Խ� �̸��� ����
		MemberJoinUtil util = new MemberJoinUtil();
		String tempCode = Integer.toString(util.getRandomCode(8));// �ӽ� �ڵ� 8�ڸ� ����

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
