package com.sp.board.service;

import java.util.List;

import com.sp.board.domain.BoardDTO;

public interface BoardService {
	
	public void create()throws Exception;
	
	public void regist(BoardDTO board)throws Exception;
	
	public List<BoardDTO> noList() throws Exception;
	
	public BoardDTO read(Integer notice_no) throws Exception;
//	
//	public void modify(BoardDTO board) throws Exception;
//	
//	public void remove(Integer notice_no) throws Exception;
	
	


}
