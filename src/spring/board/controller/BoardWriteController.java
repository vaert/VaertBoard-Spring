package spring.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import model.board.BoardModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.board.BoardDAOImpl;

/**
 * 등록 컨트롤러 클래스
 * @author vaertoon.com
 * @since 2014.05
 */
@Controller("boardWriteController")
public class BoardWriteController {
	
	@Resource(name="boardDAO")
	private BoardDAOImpl boardDAO;
	
	@RequestMapping(value="/board/boardWrite", method=RequestMethod.GET)
	public String boardWriteForm(HttpServletRequest request, BoardModel boardModel, 
			Model model) throws Exception {
		return "/board/boardWrite";
	}
	
	@RequestMapping(value="/board/boardWrite", method=RequestMethod.POST)
	public String boardWrite(HttpServletRequest request, BoardModel boardModel, 
			Model model) throws Exception {
		String ip = request.getRemoteAddr();
		boardModel.setIp(ip);
		// 게시물 등록
		this.boardDAO.insert(boardModel);
		// 페이지 이동
		return "redirect:boardList";
	}

}
