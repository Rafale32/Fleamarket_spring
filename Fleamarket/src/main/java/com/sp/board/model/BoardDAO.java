package com.sp.board.model;

import java.util.List;

import com.sp.board.domain.BoardDTO;

public interface BoardDAO {
	
	public void create() throws Exception;
	
	public void make(BoardDTO dto) throws Exception;
//	
//	public BoardDTO read(Integer notice_no) throws Exception;
//	
//	public void update(BoardDTO dto) throws Exception;
//	
//	public void delete(Integer notice_no) throws Exception;
//	
	public List<BoardDTO> list() throws Exception;
}
