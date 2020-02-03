package com.java.board.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.java.aop.HomeAspect;
import com.java.board.dao.BoardDao;
import com.java.board.dto.BoardDto;

public class BoardServiceImp implements BoardService {
	private BoardDao boardDao;
	
	public BoardServiceImp() {}

	public BoardServiceImp(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public void boardWrite(ModelAndView mav) {
		
		//ROOT글일때
		int boardNumber = 0;
		int groupNumber = 1;
		int sequenceNumber = 0;
		int sequenceLevel = 0;
		
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		//답글일때 - 부모글번호
		if(request.getParameter("boardNumber")!=null) {
			boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
			groupNumber = Integer.parseInt(request.getParameter("groupNumber"));
			sequenceNumber = Integer.parseInt(request.getParameter("sequenceNumber"));
			sequenceLevel = Integer.parseInt(request.getParameter("sequenceLevel"));
		}
		
		mav.addObject("boardNumber",boardNumber);
		mav.addObject("groupNumber",groupNumber);
		mav.addObject("sequenceNumber",sequenceNumber);
		mav.addObject("sequenceLevel",sequenceLevel);
		
		mav.setViewName("/WEB-INF/view/board/write.jsp");
			
	}

	@Override
	public void boardWriteOk(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		BoardDto boardDto  = (BoardDto) map.get("boardDto");
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		boardWriterNumber(boardDto);
		
		boardDto.setWriteDate(new Date());
		boardDto.setReadCount(0);//초기값
		
		int check=boardDao.boardWrite(boardDto);
		HomeAspect.logger.info(HomeAspect.logMsg+ check);
		
		mav.addObject("check",check);
		mav.setViewName("/WEB-INF/view/board/writeOk.jsp"); //이동할 페이지
	}
	
		public void boardWriterNumber(BoardDto boardDto) {
			int boardNumber = boardDto.getBoardNumber();
			int groupNumber = boardDto.getGroupNumber();
			int sequenceNumber = boardDto.getSequenceNumber();
			int sequenceLevel = boardDto.getSequenceLevel();
			
			if(boardNumber==0) {	//ROOT - 그룹번호
				int max = boardDao.boardGroupNumberMax();
				HomeAspect.logger.info(HomeAspect.logMsg+boardDto.getGroupNumber());
				boardDto.setGroupNumber(max+1);
			} else {				//답글 - 글순서, 글레벨
				
			}
		}

		@Override
		public void boardList(ModelAndView mav) {
			//페이지 번호를 가지고 온다
			Map<String, Object> map = mav.getModelMap();
			HttpServletRequest request = (HttpServletRequest) map.get("request");
			
			String pageNumber = request.getParameter("pageNumber");
			if(pageNumber==null) {
				pageNumber="1";	
			}
			int currentPage = Integer.parseInt(pageNumber);	//10개씩
			int boardSize = 10;
			
			int startRow = (currentPage-1)*boardSize+1;	//0*10=0+1=1	1*10=10+1=11
			int endRow = currentPage*boardSize;			//1*10=10		2*10=20	
			
			int count = boardDao.boardCount();
			HomeAspect.logger.info(HomeAspect.logMsg+count);
			
			List<BoardDto> boardList = null;
			if(count > 0){
				boardList=boardDao.boardList(startRow,endRow);
			}
			HomeAspect.logger.info(HomeAspect.logMsg+boardList.size());
			
			mav.addObject("boardList",boardList);
			mav.addObject("count",count);
			mav.addObject("boardSize",boardSize);
			mav.addObject("currentPage",currentPage);
			mav.setViewName("/WEB-INF/view/board/list.jsp");
			
		}
		
	
}
