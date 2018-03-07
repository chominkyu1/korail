package com.korail.control;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.korail.domain.TicketVO;
import com.korail.dto.MyPurchaseDTO;
import com.korail.service.MypageService;
import com.korail.service.PurchaseService;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	@Inject
	private MypageService mypageService;
	
	@Inject
	private PurchaseService purchaseService;
	
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
	

	@RequestMapping(value="myticket",method=RequestMethod.GET)
	public String setStationGET(String ticket_Id, Model model ) {
		TicketVO ticketVO = purchaseService.ticketdetail(ticket_Id);
		if(ticketVO.getTicket_Station()==null&&ticketVO.getTicket_StartDate()==null) {
			ticketVO.setTicket_Station("����");
			ticketVO.setTicket_StartDate("����");
		}
		model.addAttribute("vo", ticketVO);
		return "mypage/myTicket";
	}
	
	@RequestMapping(value="myticket",method=RequestMethod.POST)
	public String setStationPOST(TicketVO ticketVO, RedirectAttributes attr) {//�߱��� ���� 
		System.out.println(ticketVO.getTicket_Station());
		System.out.println(ticketVO.getTicket_StartDate());
		
		String StartDate = ticketVO.getTicket_StartDate();
		String ticket_StartDate = StartDate.replace("-", "");
		
		System.out.println("�ٲ� ��¥ !! >>" + ticket_StartDate);
		
		ticketVO.setTicket_StartDate(ticket_StartDate);
		
		purchaseService.ticketUpdate(ticketVO);
		
		return "mypage/myTicket";
	}
	
	@RequestMapping(value="mypurchase",method=RequestMethod.GET)
	public String purchaseList(String member_Id,Model model) {//mypage>���� Ƽ�ϱ��Ÿ�� �ܼ�jsp�̵�
		// MyPurchaseDTO �޾ƿͼ� view �Ѱ����� 
		List<MyPurchaseDTO> dtoList = purchaseService.selectList(member_Id);
		model.addAttribute("dtoList", dtoList);
		return "mypage/purchaseList";
	}
	
	@RequestMapping("refund")
	public String refund(String tOrder_Id,RedirectAttributes attr) {//mypage>���� ���Ÿ�� ȯ�ҽ�û
		System.out.println("refund�޼ҵ��� tOrder_Id>>"+tOrder_Id);
		purchaseService.refund(tOrder_Id);
		attr.addFlashAttribute("msg", "success");
		return "redirect:/mypage/mypurchase";
	}
	
}
