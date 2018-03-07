package com.korail.control;

import java.io.File;
import java.util.ArrayList;
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
public class DiscountController {//������ : ���ΰԽù� ��Ʈ�ѷ� 
	
	@Inject
	private DiscountService discountService;
	
	@RequestMapping("register")
	public String register() {//�����ڰ� ��������� ����
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
	
	/*@RequestMapping("uploadsale")//�Խñ۾��ε�
	public String updiscount(@ModelAttribute("article") DiscountVO discountVO,
            MultipartHttpServletRequest mhsq, RedirectAttributes attr) throws Exception {
		 
		List<MultipartFile> mf = mhsq.getFiles("addfile");
		 
	        if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {
	        } else {
	            for (int i = 0; i < mf.size(); i++) {
	                // ���� �ߺ��� ó��
	                String genId = UUID.randomUUID().toString();
	                // ���� ���ϸ�
	                String originalfileName = mf.get(i).getOriginalFilename();
	                 
	                String saveFileName = genId + "." + getExtension(originalfileName);
	                // ����Ǵ� ���� �̸�
	 
	                String savePath = realFolder + saveFileName; // ���� �� ���� ���
	 
	                long fileSize = mf.get(i).getSize(); // ���� ������
	 
	                mf.get(i).transferTo(new File(savePath)); // ���� ����
	 
	                bbsService.fileUpload(originalfileName, saveFileName, fileSize);
	            }
	        }
	    attr.addFlashAttribute("msg", "success");
		return "redirect:list";
	}*/
	
	@RequestMapping("uploadsale")//�Խñ۾��ε�
	public String updiscount(String []addFile,HttpServletRequest request,RedirectAttributes attr) throws Exception {
		/*System.out.println(addfile);
		System.out.println(discountVO);*/
		 
		String saveDir = request.getServletContext().getRealPath("img/imgdiscount");
		System.out.println("������ saveDir >>>"+saveDir);
		int maxSize = 5*1025*1024;
		
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		Enumeration fileName = multi.getFileNames();
		System.out.println("Enumeration fileName >>>>"+fileName);
		String path = "/resources/img/imgdiscount";
		System.out.println("db�� ����� ���� ��� >>>>>>"+path);
		File file = multi.getFile("addfile");
		String name = file.getName();
		System.out.println("����� �迭 "+file);
		
		
		
		
		List<AddFileVO> addFileList = null;
		
		/*for (int i = 0; i < addfile.length; i++) {
			String addFile_StoredName= path + "/" + multi.getFilesystemName(addfile[i]);// ���ε��� ������ ��ü ��θ� DB�� �����ϱ� ����
			String addFile_Name = path + "/" + multi.getFileNames();
			
			AddFileVO addFileVO = new AddFileVO();
			addFileVO.setAddFile_Name(addFile_Name);
			addFileVO.setAddFile_Path(addFile_Path);
			addFileVO.setAddFile_Size(addFile_Size);
			addFileVO.setAddFile_StoredName(addFile_StoredName);
			
			addFileList.add(addFileVO);
			
		}*/
		
		String spacepost_image3 = path + "/" + multi.getFilesystemName("image3");
		
		
		
		DiscountVO discountVO = new DiscountVO();
		discountVO.setDiscount_Title(multi.getParameter("discount_Title"));
		discountVO.setStation_Id(multi.getParameter("station_Id"));
		discountVO.setMember_Id(multi.getParameter("member_Id"));
		discountVO.setDiscount_Price(multi.getParameter("discount_Price"));
		discountVO.setDiscount_Map(multi.getParameter("discount_Map"));
		discountVO.setDiscount_Shophone(multi.getParameter("discount_Shophone"));
		discountVO.setDiscount_Shopname(multi.getParameter("discount_Shopname"));
		discountVO.setDiscount_Content(multi.getParameter("discount_Content"));
		
		AddFileVO addFileVO = new AddFileVO();
		
		
		
		discountService.create(discountVO, addFileVO);
		
		
		//System.out.println(multi.getParameter("station_Id"));
		
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
		//System.out.println("����Ʈ: "+list.size()+">>"+list);
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
