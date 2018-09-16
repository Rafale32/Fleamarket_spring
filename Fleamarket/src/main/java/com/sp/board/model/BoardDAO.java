package com.sp.board.model;

import java.util.List;

import com.sp.board.domain.BoardDTO;
import com.sp.board.domain.Criteria;

public interface BoardDAO {
	
	public void create() throws Exception;
	
	public void make(BoardDTO dto) throws Exception;
	
	public List<BoardDTO> noList() throws Exception;
	
	public BoardDTO read(Integer notice_no) throws Exception;
	
	public void delete(Integer notice_no) throws Exception;
	
	public void update(BoardDTO dto) throws Exception;
	
	public List<BoardDTO> listPage(int page) throws Exception;	//페이징 처리용
	
	public List<BoardDTO> listCriteria(Criteria cri) throws Exception;
	
	
	
	

	
}
