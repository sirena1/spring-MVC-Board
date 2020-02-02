package com.java.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class BoardController extends MultiActionController{

	public String boardWrite(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("OK");
		
		//service - DAO - DTO
		
		return "/WEB-INF/view/board/write.jsp";
	}
}
