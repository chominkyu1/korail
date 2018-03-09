package com.korail.control;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.korail.domain.TOrderVO;
import com.korail.domain.TicketVO;
import com.korail.service.PurchaseService;
import com.korail.service.TorderService;

@Controller
@RequestMapping("purchase")
public class PurchaseController {//주문, 티켓 구매 컨트롤러 : 한정숙

	
	@Inject
	private PurchaseService purchaseService;
	
	
	@RequestMapping("ticketInfo")
	public String ticketInfo() {//티켓정보 페이지 단순 jsp이동
		System.out.println("ffffffffffffffffffffffff");
		return "purchase/ticketInfo";
	}
	
	@RequestMapping(value="order",method=RequestMethod.GET)
	public String purchaseGet() {//티켓결제 단순jsp이동
		return "purchase/purchaseTicket";
	}
	
	@RequestMapping(value="order",method=RequestMethod.POST)
	public String purchasePost(TOrderVO tOrderVO,TicketVO ticketVO) {//무통장입금 
		tOrderVO.settOrder_PayType("1");//무통장입금
		tOrderVO.settOrder_State("1");//입금대기 
		purchaseService.create(tOrderVO,ticketVO);
		return "mypage/myTicket";
	}
	
	@RequestMapping(value="creditPage",method=RequestMethod.POST)
	public String paycreditGET(TOrderVO tOrderVO,Model model) {
		model.addAttribute("tOrderVO", tOrderVO);
		return "purchase/purchaseCredit";
	}
	
	@RequestMapping(value="credit",method=RequestMethod.POST)
	public String paycreditPOST(TOrderVO tOrderVO,TicketVO ticketVO,RedirectAttributes attr) {//신용카드 결제
		tOrderVO.settOrder_PayType("0");//신용카드 
		tOrderVO.settOrder_State("0");//결제 완료 
		purchaseService.create(tOrderVO,ticketVO);
		
		
		//attr.addAttribute("ticket_Id", arg1);
		return "redirect:mypage/myTicket";
	}
	
	
	
	
	
}
