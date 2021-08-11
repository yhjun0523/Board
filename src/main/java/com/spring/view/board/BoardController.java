package com.spring.view.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;
import com.spring.biz.board.CommonVO;
import com.spring.biz.board.PageMaker;

@Controller
@SessionAttributes("board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	// 글 등록
	@RequestMapping(value = "/write.do")
	public String insertBoard(BoardVO vo, HttpServletRequest request) throws Exception {
		boardService.insertBoard(vo);
		return "redirect:list.do";
	}

	// 글 수정
	@RequestMapping("/update.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		boardService.updateBoard(vo);
		return "redirect:list.do";
	}

	// 글 삭제
	@RequestMapping("/delete.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "redirect:list.do";
	}

	// 글 상세 보기
	@RequestMapping("/detail.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo));
		return "detail.jsp";
	}

	// 글 목록 보기
	@RequestMapping("/list.do")
	public String getBoardList(BoardVO vo, CommonVO com, Model model) {

		// 페이징 관련
		int total = boardService.totalCnt(vo);
		model.addAttribute("paging", new PageMaker(vo, total));
		model.addAttribute("menuList", boardService.getMenuList(com));
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "list.jsp";
	}
	
	@RequestMapping("/register.do")
	public String getPhoneList(CommonVO com, Model model) {

		model.addAttribute("phoneList", boardService.getPhoneList(com));
		System.out.println(boardService.getPhoneList(com));
		return "join.jsp";
	}
	
	@RequestMapping("/create.do")
	public String getMenuList(CommonVO com, Model model) {

		model.addAttribute("menuList", boardService.getMenuList(com));
		System.out.println(boardService.getMenuList(com));
		return "write.jsp";
	}
	
	@RequestMapping("/searchList.do")
	public String getSearchList(BoardVO vo, CommonVO com, Model model) {

		int total = boardService.searchTotalCnt(vo);
		model.addAttribute("paging", new PageMaker(vo, total));
		model.addAttribute("menuList", boardService.getMenuList(com));
		model.addAttribute("boardList", boardService.getSearchList(vo));
		System.out.println(boardService.getSearchList(vo));
		return "list.jsp";
	}
}
