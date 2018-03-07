package com.korail.control;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.korail.service.MypageService;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	@Inject
	private MypageService mypageService;
	
	@RequestMapping("/myScrapList")
	public void myPageList(String member_Id,Model m) throws Exception {
		System.out.println(member_Id);
		m.addAttribute("myScrap",mypageService.myScrap(member_Id));
		//m.addAttribute("myScrapList",mypageService.myScrap(member_Id));
	}
	
	@RequestMapping(value="/myScrapDelete",method=RequestMethod.POST)
	public String myScrapDelete(@RequestParam("tipreview_Ids") String[] tipreview_Ids,ModelMap modelMap) throws Exception {
		for(String tipreview_Id : tipreview_Ids) {
			System.out.println(tipreview_Id);			
			mypageService.myScrapdelete(tipreview_Id);
		}
		return "redirect:myScrapList";	
	}
}
