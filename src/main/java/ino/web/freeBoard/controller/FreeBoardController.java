package ino.web.freeBoard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ino.web.freeBoard.dto.FreeBoardDto;
import ino.web.freeBoard.service.FreeBoardService;

@Controller
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	@RequestMapping("/main.ino")
	public ModelAndView main(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		

		// mac book push test!!!

		// pull test!!
		//window to commit

		
		List list = freeBoardService.freeBoardList();
//		List list = freeBoardService.freeBoardList2();
		
		mav.setViewName("boardMain");
		mav.addObject("freeBoardList",list);
	return mav;
	}
	
	@RequestMapping("/freeBoardInsert.ino")
	public String freeBoardInsert(){
		return "freeBoardInsert";
	}
	
	@RequestMapping("/freeBoardInsertPro.ino")
	public String freeBoardInsertPro(HttpServletRequest request, FreeBoardDto dto){
		ModelAndView mav = new ModelAndView();
		
		freeBoardService.freeBoardInsertPro(dto);
		
		return "redirect:freeBoardDetail.ino?num="+dto.getNum();
	}
	
	@RequestMapping("/freeBoardDetail.ino")
	public ModelAndView freeBoardDetail(HttpServletRequest request){
		
		int num = Integer.parseInt(request.getParameter("num"));
		FreeBoardDto dto = freeBoardService.getDetailByNum(num);

		System.out.println(dto.toString());
		
		return new ModelAndView("freeBoardDetail", "freeBoardDto", dto);
	}
	
	@RequestMapping("/freeBoardModify.ino")
	public String freeBoardModify(HttpServletRequest request){
		return "freeBoardModify";
/*		int num = Integer.parseInt(request.getParameter("num"));
		FreeBoardDto dto = freeBoardService.getDetailByNum(num);
		return new ModelAndView("freeBoardModify", "freeBoardDto", dto);*/
	}
	
	@RequestMapping("/freeBoardDelete.ino")
	public String freeBoardDelete(){
		return "freeBoardDelete";
	}
	
}
