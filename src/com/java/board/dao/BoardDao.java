package com.java.board.dao;

import java.util.List;

import com.java.board.dto.BoardDto;

public interface BoardDao {

	public int boardGroupNumberMax();

	public int boardWrite(BoardDto boardDto);

	public int boardCount();

	public List<BoardDto> boardList(int startRow, int endRow);

	public BoardDto boardRead(int boardNumber);

}
