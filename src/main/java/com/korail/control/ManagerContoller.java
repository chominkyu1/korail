package com.korail.control;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.korail.domain.DiscountVO;
import com.korail.dto.PurchaseDTO;
import com.korail.dto.SearchDTO;
import com.korail.service.ManagerService;
import com.korail.service.PurchaseService;

@Controller
@RequestMapping("/manager")
public class ManagerContoller {
	@Inject
	private ManagerService managerService;
	
	@Inject
	private PurchaseService purchaseService;
	
	@RequestMapping("/memberList")
	public void memberList(SearchDTO searchDTO,Model m) throws Exception {
		//System.out.println(searchDTO);
		m.addAttribute("memberList", managerService.memberSearch(searchDTO));
	}
/*	@RequestMapping("/memberDetail")
	public void memberDetail(String member_Id,Model m) throws Exception {
		System.out.println(member_Id);
		m.addAttribute("memberDetail",managerService.memberSearchDetail(member_Id));
		m.addAttribute("memberwithboard",managerService.memberwithboard(member_Id));
		
	}*/
	
	@RequestMapping("/saleBoardList")
	public void saleBoardList(Model m) throws Exception {
		m.addAttribute("discountAll",managerService.discountAll());
		List<DiscountVO> discountVO = managerService.discountAll();
		for(int i = 0;i<discountVO.size();i++) {
			System.out.println(discountVO.get(2));
		}
	
	}
	

	@RequestMapping("purchaseList")//회원구매목록,구매상태 변경(무통장입금일 경우), 환불목록 조회(환불상태 변경 )
	public String purchaseList(Model model) {
		List<PurchaseDTO> dtolist = purchaseService.selectListALL();
		System.out.println(dtolist);
		model.addAttribute("dto", dtolist);
		return "manager/memberPurchase";
	}
	
	@RequestMapping("refundUpdate")//환불상태 변경 
	public String refundList(String tOrder_Id) {
		purchaseService.refundstate(tOrder_Id);
		return "purchaseList";
	}
	
	@RequestMapping("searchPurchase")//구매내역 조회페이지에서 검색
	public String searchPurchase(String type,String keyword, Model model) {
		List<PurchaseDTO> dtolist =null;
		
		if(type.equals("all")) {
			 dtolist =purchaseService.selectListALL();
		} else {
			 dtolist =purchaseService.searchPurchase(type,keyword);
		}
		
		System.out.println("검색한 dtolist>>>>>"+dtolist);
		model.addAttribute("dto", dtolist);
		return "manager/searchPurchase";
	}
	
	

}
