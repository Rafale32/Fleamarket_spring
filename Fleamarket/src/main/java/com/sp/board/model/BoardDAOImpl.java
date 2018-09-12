package com.sp.board.model;

import java.util.List;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sp.board.domain.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession session;
	private static String namespace = "BoardMapper";
	
	@Override
	public void create() throws Exception {
		session.insert(namespace+".create");
	}
	
	@Override
	public void make(BoardDTO dto) throws Exception {
		session.insert(namespace + ".make", dto);
	}
	
	@Override
	public List<BoardDTO> list() throws Exception {
		return session.selectList(namespace+".listview");
	}
//
//	@Override
//	public BoardDTO read(Integer notice_no) throws Exception {
//		return session.selectOne(namespace+".read", notice_no);
//	}
//
//	@Override
//	public void update(BoardDTO dto) throws Exception {
//		session.update(namespace+".update", dto);
//	}
//
//	@Override
//	public void delete(Integer notice_no) throws Exception {
//		session.delete(namespace+".delete", notice_no);
//	}
//

	
}
