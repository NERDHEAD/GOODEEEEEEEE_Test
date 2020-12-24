package com.nerdhead.edu.ctrl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nerdhead.edu.dto.AnswerBoardDto;
import com.nerdhead.edu.model.service.IService;
@Controller
public class BoardController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private IService service;

	@RequestMapping(value = "boardList.do")
	public String boardlist(Model model) {
		List<AnswerBoardDto> selAll = service.selectAll();
		model.addAttribute("selAll", selAll);

		return "boardList";
	}
	@RequestMapping(value = "writeBoard.do")
	public String writeBoard() {
		return "writeBoard";
	}
	@RequestMapping(value = "writeBoard.do", method = RequestMethod.POST)
	public String writeBoard(AnswerBoardDto dto) {
		System.out.println("내용 : "+dto);
		int result= service.insertBoard(dto);
		log.info("insertBoard : "+((result>0)?"성공":"실패"));
		return "redirect:/boardList.do";
	}
	
	@RequestMapping(value = "detailBoard.do")
	public String detailBoard(Model model, String seq) {
		model.addAttribute("dto", service.selectOne(seq));
		return "detailBoard";
	}
	
	
	@RequestMapping(value = "delBoard.do")
	public String delBoard(String seq) {
		service.multiDelete(seq);
		return "redirect:/boardList.do";
	}
	
	
	@RequestMapping(value = "multiDel.do")
	public String detailBoard(String[] ch) {
		HashMap<String, String[]> seqs=new HashMap<>();
		seqs.put("seqs", ch);
		service.multiDelete2(seqs);
		return "redirect:/boardList.do";
	}
	
	@RequestMapping(value = "moveModifyBoard.do")
	public String moveModifyBoard(Model model, String seq) {
		model.addAttribute("dto", service.selectOne(seq));
		return "modifyBoard";
	}
	
	@RequestMapping(value = "modifyResult.do")
	public String modifyResult(Model model, AnswerBoardDto dto) {
		service.modifyBoard(dto);
		return detailBoard(model, Integer.toString(dto.getSeq()));
	}
	@RequestMapping(value = "moveReplyBoard.do")
	public String moveReplyBoard(Model model, AnswerBoardDto dto) {
		model.addAttribute("dto", dto);
		return "replyBoard";
	}
	
	@RequestMapping(value = "replyResult.do", method = RequestMethod.POST)
	public String replyResult(Model model, AnswerBoardDto dto) {
		service.replyinsert(dto);
		return "redirect:/boardList.do";
	}
}
