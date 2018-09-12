package com.sp.mainDetail.model;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.sp.mainDetail.domain.ItemQnaDTO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "MainDetailMapper";
	
	@Override
	public List<ItemQnaDTO> listQna(Integer itemboard_no) throws Exception {
		return session.selectList(namespace+".listQna", itemboard_no);
	}

	@Override
	public void createQna(ItemQnaDTO qna) throws Exception {
		session.insert(namespace+".createQna", qna);
	}

	@Override
	public void deleteQna(Integer item_qna_no) throws Exception {
		session.delete(namespace+".deleteQna", item_qna_no);

	}

	@Override
	public int countQna(Integer itemboard_no) throws Exception {
		return session.selectOne(namespace+".countQna",itemboard_no);
	}

	@Override
	public int getItemboard_no(Integer item_qna_no) throws Exception {
		return session.selectOne(namespace+".getItemboard_no", item_qna_no);
	}

	@Override
	public int maxQnaNo(Integer itemboard_no) throws Exception {
		return session.selectOne(namespace+".maxQnaNo",itemboard_no);
	}

	@Override
	public void updateQna(ItemQnaDTO qna) throws Exception {
		session.update(namespace+".updateQna", qna);
	}

}
