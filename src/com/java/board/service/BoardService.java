package com.java.board.service;

import org.springframework.web.servlet.ModelAndView;

public interface BoardService {

	public void boardWrite(ModelAndView mav);

	public void boardWriteOk(ModelAndView mav);

	public void boardList(ModelAndView mav);

	public void boardRead(ModelAndView mav);
}
