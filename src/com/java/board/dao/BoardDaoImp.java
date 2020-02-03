package com.java.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.java.board.dto.BoardDto;

public class BoardDaoImp implements BoardDao {

	private SqlSessionTemplate sqlSessionTemplate;

	public BoardDaoImp() {}
	
	public BoardDaoImp(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public int boardGroupNumberMax() {
		return sqlSessionTemplate.selectOne("boardGroupNumberMax");
	}

	@Override
	public int boardWrite(BoardDto boardDto) {
		return sqlSessionTemplate.insert("boardWriter",boardDto);
	}

	@Override
	public int boardCount() {
		return sqlSessionTemplate.selectOne("boardCount");
	}

	@Override
	public List<BoardDto> boardList(int startRow, int endRow) {
		//2개이상이니깐 map방식으로 
		Map<String,Integer> hMap = new HashMap<String, Integer>();
		hMap.put("startRow",startRow);
		hMap.put("endRow",endRow);
		
		return sqlSessionTemplate.selectList("boardList",hMap);
	}
	
}
