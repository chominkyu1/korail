package com.korail.control;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.korail.domain.PageMaker;
import com.korail.domain.SearchCriteria;
import com.korail.domain.TipReviewVO;
import com.korail.service.TipService;

@Controller
@RequestMapping("/board")
public class TipController {
	
	@Inject
	private TipService service;
	
	@RequestMapping(value="tipReviewUpload", method=RequestMethod.GET)
	public String regist() throws Exception {
	
		return "board/tipReviewUpload";
	}
	
	@RequestMapping(value="tipReviewUpload", method=RequestMethod.POST)
	public String list(TipReviewVO vo) throws Exception {		
		service.regist(vo);
		System.out.println("입력데이터>>>>"+vo);
		return "redirect:tipReviewList";
	}
	
	
	@RequestMapping("/tipReviewList")   //전체 목록 얻기
	public void list(Model model)throws Exception{
	   
	System.out.println(">>전체게시물 조회");
	    List<TipReviewVO> list = service.listAll();	
	   model.addAttribute("list", list);
	}
	
	
	@RequestMapping(value="/tipModify",method=RequestMethod.GET)   //전체 목록 얻기
	public void Modify(@RequestParam("tipreview_Id") String tipreview_Id, Model model)throws Exception{
	   System.out.println("수정페이지고고???" + tipreview_Id);
		model.addAttribute("p",service.read(tipreview_Id));
		
	}
	
	@RequestMapping(value="/tipModify",method=RequestMethod.POST)   //전체 목록 얻기
	public String ModifyPost(TipReviewVO vo,RedirectAttributes attr)throws Exception{
		System.out.println("수정해야지???" + vo);
		service.modify(vo);
		attr.addFlashAttribute("msg","success");
		return "redirect:/board/tipReviewList";
		
	}
	
	
	@RequestMapping(value="/tipDetail", method=RequestMethod.GET) //수정
	public String modifyGet(String tipreview_Id, Model model)throws Exception {
		model.addAttribute("p", service.read(tipreview_Id));
		return "/board/tipDetail";
	}

	
	@RequestMapping(value="/tipDelete")
	public String remove(@RequestParam("tipreview_Id") String tipreview_Id, RedirectAttributes attr)throws Exception {
		if(service.remove(tipreview_Id)) {
			attr.addFlashAttribute("msg", "success");
		}
		return "redirect:/board/tipReviewList";
	}
    
	
@RequestMapping(value="/tipReviewListCri", method=RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception {
		PageMaker maker = new PageMaker();
			maker.setCri(cri);
			maker.setTotalCount(service.listSearchCount(cri));
			
		model.addAttribute("list", service.listSearchCriteria(cri));
		model.addAttribute("cri", cri);
	    model.addAttribute("pageMaker", maker);
			
}


/*
	public void read(String tipreview_id, Model model, SearchCriteria cri) throws Exception{
		System.out.println("글번호>>" + tipreview_id);
		System.out.println("readPage cri>>" + cri);
		
		model.addAttribute(service.read(tipreview_id));
		model.addAttribute("cri", cri);
		*/
		
	}



