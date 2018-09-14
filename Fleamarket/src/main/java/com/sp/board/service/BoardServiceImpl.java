package com.sp.board.service;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.sp.board.domain.BoardDTO;
import com.sp.board.model.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;

	@Override
	public void create() throws Exception {	}

	@Override
	public void regist(BoardDTO board) throws Exception {
		dao.make(board);
	}

	@Override
	public List<BoardDTO> noList() throws Exception {
		System.out.println("|BoardServiceImpl| noList");
		return dao.noList();
	}
	
	 @Override
	 public BoardDTO read(Integer notice_no) throws Exception {
		 System.out.println("|BoardServiceImpl| read");
	 return dao.read(notice_no);
	 }
	
	// @Override
	// public void modify(BoardDTO board) throws Exception {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void remove(Integer notice_no) throws Exception {
	// // TODO Auto-generated method stub
	//
	// }
	//

}
