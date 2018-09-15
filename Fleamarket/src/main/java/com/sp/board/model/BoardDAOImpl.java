package com.sp.board.model;

import java.util.List;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sp.board.domain.BoardDTO;
import com.sp.board.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession session;
	private static String namespace = "BoardMapper";
	
	@Override
	public void create() {	}
	
	@Override
	public void make(BoardDTO dto) throws Exception {
		System.out.println("|BoardDAOImpl| make");
		session.insert(namespace + ".make", dto);
	}
	
	@Override
	public List<BoardDTO> noList() throws Exception {
		System.out.println("|BoardDAOImpl| noList");
		return session.selectList(namespace + ".noList");
	}

	@Override
	public BoardDTO read(Integer notice_no) throws Exception {
		System.out.println("|BoardDAOImpl| read 번호");
		return session.selectOne(namespace + ".read", notice_no);
	}
	
	@Override
	public void delete(Integer notice_no) throws Exception {
		System.out.println("|BoardDAOImpl| 삭제");
		session.delete(namespace+".delete", notice_no);
	}

	@Override
	public void update(BoardDTO dto) throws Exception {
		System.out.println("|BoardDAOImpl| 업데이트");
		session.update(namespace+".update", dto);
	}

	@Override
	public List<BoardDTO> listPage(int page) throws Exception {
		System.out.println("|BoardDAOImpl| 페이징 리스트");
		
		if(page <=0){
			page = 1;
		}
		page = (page -1) * 10;
		
		return session.selectList(namespace+".listPage", page);
	}

	@Override
	public List<BoardDTO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace+".listCriteria", cri);
	}



}
