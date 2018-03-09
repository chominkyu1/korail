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
public class PurchaseController {//�ֹ�, Ƽ�� ���� ��Ʈ�ѷ� : ������

	
	@Inject
	private PurchaseService purchaseService;
	
	
	@RequestMapping("ticketInfo")
	public String ticketInfo() {//Ƽ������ ������ �ܼ� jsp�̵�
		System.out.println("ffffffffffffffffffffffff");
		return "purchase/ticketInfo";
	}
	
	@RequestMapping(value="order",method=RequestMethod.GET)
	public String purchaseGet() {//Ƽ�ϰ��� �ܼ�jsp�̵�
		return "purchase/purchaseTicket";
	}
	
	@RequestMapping(value="order",method=RequestMethod.POST)
	public String purchasePost(TOrderVO tOrderVO,TicketVO ticketVO) {//�������Ա� 
		tOrderVO.settOrder_PayType("1");//�������Ա�
		tOrderVO.settOrder_State("1");//�Աݴ�� 
		purchaseService.create(tOrderVO,ticketVO);
		return "mypage/myTicket";
	}
	
	@RequestMapping(value="creditPage",method=RequestMethod.POST)
	public String paycreditGET(TOrderVO tOrderVO,Model model) {
		model.addAttribute("tOrderVO", tOrderVO);
		return "purchase/purchaseCredit";
	}
	
	@RequestMapping(value="credit",method=RequestMethod.POST)
	public String paycreditPOST(TOrderVO tOrderVO,TicketVO ticketVO,RedirectAttributes attr) {//�ſ�ī�� ����
		tOrderVO.settOrder_PayType("0");//�ſ�ī�� 
		tOrderVO.settOrder_State("0");//���� �Ϸ� 
		purchaseService.create(tOrderVO,ticketVO);
		
		
		//attr.addAttribute("ticket_Id", arg1);
		return "redirect:mypage/myTicket";
	}
	
	
	
	
	
}
