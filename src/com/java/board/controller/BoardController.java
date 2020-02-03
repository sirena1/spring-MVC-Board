package com.java.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.java.aop.HomeAspect;
import com.java.board.dto.BoardDto;
import com.java.board.service.BoardService;

public class BoardController extends MultiActionController {

	private BoardService boardService;

	public BoardController() {
	}

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	public ModelAndView boardWrite(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);

		boardService.boardWrite(mav);

		return mav;
	}

	public ModelAndView boardWriteOk(HttpServletRequest request, HttpServletResponse response, BoardDto boardDto) {
		HomeAspect.logger.info(HomeAspect.logMsg + boardDto.toString());

		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		mav.addObject("boardDto", boardDto);

		boardService.boardWriteOk(mav);

		return mav;
	}
	
	public ModelAndView boardList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request",request);
		
		boardService.boardList(mav);
		return mav;
	}
	
	public ModelAndView boardRead(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request",request);
		
		boardService.boardRead(mav);
		return mav;
	}
}
