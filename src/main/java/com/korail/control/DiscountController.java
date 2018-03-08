package com.korail.control;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.korail.domain.AddFileVO;
import com.korail.domain.DiscountVO;
import com.korail.domain.StationVO;
import com.korail.service.DiscountService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
@RequestMapping("discount")
public class DiscountController {//한정숙 : 할인게시물 컨트롤러 
	
	@Inject
	private DiscountService discountService;
	
	@RequestMapping("register")
	public String register() {//관리자가 등록페이지 띄우기
		return "manager/uploadSaleBoard";
	}
	
	@RequestMapping("stationList")
	public String station(String station_Type,Model model) throws Exception {
		model.addAttribute("list", discountService.stationList(station_Type));
		return "manager/stationList";
	}
	
	@RequestMapping("stationId")
	public @ResponseBody String station(String station_Station) throws Exception {
		String station_Id = discountService.selectStation_Id(station_Station);
		System.out.println(station_Id);
		return station_Id;
	}
	
	/*@RequestMapping("uploadsale")//게시글업로드
	public String updiscount(@ModelAttribute("article") DiscountVO discountVO,
            MultipartHttpServletRequest mhsq, RedirectAttributes attr) throws Exception {
		 
		List<MultipartFile> mf = mhsq.getFiles("addfile");
		 
	        if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {
	        } else {
	            for (int i = 0; i < mf.size(); i++) {
	                // 파일 중복명 처리
	                String genId = UUID.randomUUID().toString();
	                // 본래 파일명
	                String originalfileName = mf.get(i).getOriginalFilename();
	                 
	                String saveFileName = genId + "." + getExtension(originalfileName);
	                // 저장되는 파일 이름
	 
	                String savePath = realFolder + saveFileName; // 저장 될 파일 경로
	 
	                long fileSize = mf.get(i).getSize(); // 파일 사이즈
	 
	                mf.get(i).transferTo(new File(savePath)); // 파일 저장
	 
	                bbsService.fileUpload(originalfileName, saveFileName, fileSize);
	            }
	        }
	    attr.addFlashAttribute("msg", "success");
		return "redirect:list";
	}*/
	
	@SuppressWarnings("null")
	@RequestMapping("uploadsale")//게시글업로드
	public String updiscount(HttpServletRequest request,RedirectAttributes attr) throws Exception {
			 
		String saveDir = request.getServletContext().getRealPath("resources/img/imgdiscount");
		System.out.println("저장경로 saveDir >>>"+saveDir);
		int maxSize = 5*1025*1024;
		
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		//---------------- 파일 업로드 END ------------------------
		
		String path = "resources/img/imgdiscount/";
		
		Enumeration fileNames = multi.getFileNames();//type=file에 대한 name--> addfile
	 
		List<AddFileVO> addFileList = new ArrayList<>();
		
		while(fileNames.hasMoreElements()) {
			String names = multi.getFilesystemName(fileNames.nextElement().toString());
			System.out.println("addfile파일명^^*>>>"+names);
			//fileNameList.add(names);
			AddFileVO addFileVO = new AddFileVO();
			addFileVO.setAddFile_Path(path + names);//db에 저장된 사진 경로
			
			System.out.println("DB에 저장되는 사진 경로 >>>"+path + names);
			addFileList.add(addFileVO);	
		}
		
		DiscountVO discountVO = new DiscountVO();
		discountVO.setDiscount_Title(multi.getParameter("discount_Title"));
		discountVO.setStation_Id(multi.getParameter("station_Id"));
		discountVO.setMember_Id(multi.getParameter("member_Id"));
		discountVO.setDiscount_Price(multi.getParameter("discount_Price"));
		discountVO.setDiscount_Map(multi.getParameter("discount_Map"));
		
		discountVO.setDiscount_Shophone(multi.getParameter("discount_Shophone"));
		discountVO.setDiscount_Shopname(multi.getParameter("discount_Shopname"));
		discountVO.setDiscount_Content(multi.getParameter("discount_Content"));
		
		System.out.println(discountVO);
		discountService.create(discountVO, addFileList);
		
		attr.addFlashAttribute("msg", "success");
		return "redirect:list";
	}

	
	
	@RequestMapping(value="modifysale",method=RequestMethod.GET)
	public String getmodify(String discount_Id,Model model) throws Exception {
		DiscountVO discountVO =discountService.read(discount_Id);
		model.addAttribute("vo", discountVO);
		return "manager/modifySaleBoard";
	}
	
	@RequestMapping(value="modifysale",method=RequestMethod.POST)
	public String postmodify(DiscountVO discountVO,String discount_Id,RedirectAttributes attr) throws Exception {
		discountService.update(discountVO);
		return "redirect:discount/list";
	}
	
	@RequestMapping(value="/remove")
	public String removePage(String discount_Id, RedirectAttributes attr) throws Exception{
		discountService.delete(discount_Id);
		return "redirect:/discount/list";
	}

	
	@RequestMapping("list")
	public String list(Model model) throws Exception {
		List<DiscountVO> list = discountService.listAll();
		
		model.addAttribute("list",list);
		//System.out.println("리스트: "+list.size()+">>"+list);
		return "board/saleStationList";
	}
	
	@RequestMapping("detail")
	public String read(String discount_Id,Model model) throws Exception {
		//station_Id
		DiscountVO discountVO = discountService.read(discount_Id);
		StationVO stationVO=discountService.station(discountVO.getStation_Id());
		model.addAttribute("stationVO", stationVO);
		model.addAttribute("vo", discountVO);
		return "board/saleStationDetail";
	}
	

}
