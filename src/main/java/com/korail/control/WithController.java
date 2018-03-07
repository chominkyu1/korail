package com.korail.control;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.korail.domain.Criteria;
import com.korail.domain.PageMaker;
import com.korail.domain.TrainScheduleVO;
import com.korail.domain.WithAskVO;
import com.korail.domain.WithBoardVO;
import com.korail.dto.WithSearchDTO;
import com.korail.service.WithBoardService;
import com.korail.utillpage.StationSearch;

@Controller
@RequestMapping("/with")
public class WithController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	private WithBoardService service;

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("첫번 째 도전. 과연 성공할까?");
		model.addAttribute("list", service.listAllBoard());
		System.out.println(service.listAllBoard());

	}

	@RequestMapping(value = "read", method = RequestMethod.GET)
	public void readWithBoard(Model model, @RequestParam("member_Id") String member_Id,
			@RequestParam("withboard_Id") String withboard_Id, Criteria cri) throws Exception {
		logger.info("두번 째 도전. 과연 성공할까?");
		model.addAttribute(service.readWithBoard(withboard_Id));
		model.addAttribute("list", service.readSche(withboard_Id));
		model.addAttribute("writerInfo", service.writerInfo(member_Id));
		System.out.println(service.readWithBoard(withboard_Id));
		System.out.println(service.readSche(withboard_Id));
		model.addAttribute("cri", cri);
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public void registerGET(Model model, @RequestParam("member_Id") String member_Id) throws Exception {
		logger.info("세번 째 도전. 과연 성공할까?");
		model.addAttribute("writerInfo", service.writerInfo(member_Id));

	}

	@RequestMapping(value = "register", method = { RequestMethod.POST }) // 가상경로 설정
	public void registerPost(WithBoardVO withBoardVO, RedirectAttributes attr) throws Exception {// DB입력 요청
		logger.info("네번 째 도전. 과연 성공할까?");
		logger.info("DB입력 요청........");
		service.writeWithBoard(withBoardVO);

		System.out.println("입력데이터 vo>>>" + withBoardVO);

		attr.addFlashAttribute("msg", "SUCCESS");
	}

	@RequestMapping(value = "remove", method = RequestMethod.POST)
	public String remove(@RequestParam("withboard_Id") String withboard_Id, RedirectAttributes rttr, Criteria cri)
			throws Exception {
		logger.info("다섯번 째 도전. 과연 성공할까?");

		service.remove(withboard_Id);
		rttr.addFlashAttribute("page", cri.getPage());
		rttr.addFlashAttribute("perPageNum", cri.getPerPageNum());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/with/list";

	}

	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public void modifyGET(String withboard_Id, Model model, @RequestParam("member_Id") String member_Id, Criteria cri)
			throws Exception {
		model.addAttribute("writerInfo", service.writerInfo(member_Id));
		model.addAttribute(service.readWithBoard(withboard_Id));
		model.addAttribute("withScheVO", service.readSche(withboard_Id));
		model.addAttribute("cri", cri);
	}

	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modifyPOST(WithBoardVO withBoardVO, RedirectAttributes rttr,
			@RequestParam("member_Id") String member_Id, Criteria cri) throws Exception {
		logger.info("여섯번째 도전, 이름하여 수정");
		service.modify(withBoardVO);
		rttr.addFlashAttribute("msg", "SUCCESS");
		// 수정한 페이지 정보를 listPage.jsp에게 전달
		rttr.addAttribute("page");
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		return "redirect:/with/list";
	}

	@RequestMapping("/listCri")
	public void listCri(Criteria cri, Model m) throws Exception {
		System.out.println("특정페이지 게시물 조회");
		m.addAttribute("list", service.listCriteria(cri));
	} // 전체 게시물조회

	@RequestMapping("/list")
	public void listPage(Criteria cri, Model model, @RequestParam("member_Id") String member_Id) throws Exception {
		System.out.println("특정페이지 게시물 조회");
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker maker = new PageMaker();
		maker.setCri(cri);
		maker.setTotalCount(12);
		model.addAttribute("pageMaker", maker);
	} // 전체 게시물조회

	@RequestMapping(value = "/ask", method = RequestMethod.POST)
	public String listPage(Model model, WithAskVO withAskVO) throws Exception {
		logger.info("에스크에스크");
		System.out.println(withAskVO);
		service.ask(withAskVO);
		return "redirect:/with/list";
	} // 전체 게시물조회

	@RequestMapping(value = "/myAskList", method = RequestMethod.GET)
	public void myAskList(@RequestParam("member_Id") String sender_Id, Model model) throws Exception {
		logger.info("에스크에스크askAllow 내가보낸 요청");

		model.addAttribute("list", service.askList(sender_Id));

	}

	@RequestMapping(value = "/askAllow", method = RequestMethod.GET)
	public void askAllow(@RequestParam("member_Id") String sender_Id, Model model) throws Exception {
		logger.info("에스크에스크askAllow 내가보낸 요청2");

		model.addAttribute("list", service.askList(sender_Id));

	}

	@RequestMapping(value = "/askAllow", method = RequestMethod.POST)
	public void updateState(@RequestParam("withAsk_State") String withAsk_State,
			@RequestParam("withAsk_Id") String withAsk_Id, Model model) throws Exception {
		logger.info("에스크에스크askAllow 내가보낸 요청3");
		Map<String, String> map = new HashMap<String, String>();
		map.put("withAsk_Id", withAsk_Id);
		map.put("withAsk_State", withAsk_State);

		service.updateState(map);
		System.out.println(map);

	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public void searchGET(Model model) {
		logger.info("searchGET 기차 일정찾기 겟 메소드예유");
	}

	@RequestMapping(value = "/search2", method = RequestMethod.GET)
	public @ResponseBody String searchPOST(String StationName, Model model) throws Exception {
		logger.info("searchPOST 기차 일정찾기 겟 메소드예유");
		System.out.println(service.searchCode(StationName));
		model.addAttribute("StationName", service.searchCode(StationName));
		return service.searchCode(StationName);

	}

	@RequestMapping(value = "/trainsearch", method = RequestMethod.GET)
	public @ResponseBody List<TrainScheduleVO>  trainsearchPOST( String arrSearchCode, String depSearchCode) throws Exception {
		logger.info("searchPOST 기차 일정찾기 겟 메소드예유");
		StationSearch search = new StationSearch();
		return search.getInfo(arrSearchCode,depSearchCode);
	}

	@RequestMapping(value = "/withSearch", method = RequestMethod.GET)
	@ResponseBody
	public List<WithBoardVO> searchWithPOST(WithSearchDTO dto, Model model) throws Exception {
		logger.info("searchWith 동행 일정찾기 포스트 메소드예유");
		System.out.println(dto);
		System.out.println(service.listSearch2(dto));
		return service.listSearch2(dto);

	}

}
