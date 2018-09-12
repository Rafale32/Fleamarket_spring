package com.sp.mainDetail.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sp.mainDetail.domain.ItemQnaDTO;
import com.sp.mainDetail.model.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Inject
	private ReplyDAO dao;
	
	@Override
	public List<ItemQnaDTO> listQna(Integer itemboard_no) throws Exception {
		return dao.listQna(itemboard_no);
	}

	@Override
	public void createQna(ItemQnaDTO qna) throws Exception {
		dao.createQna(qna);
	}

	@Override
	public void deleteQna(Integer item_qna_no) throws Exception {
		dao.deleteQna(item_qna_no);
	}

	@Override
	public int countQna(Integer itemboard_no) throws Exception {
		return dao.countQna(itemboard_no);
	}

	@Override
	public int getItemboard_no(Integer item_qna_no) throws Exception {
		return dao.getItemboard_no(item_qna_no);
	}

	@Override
	public int maxQnaNo(Integer item_qna_no) throws Exception {
		return dao.maxQnaNo(item_qna_no);
	}

	@Override
	public void updateQna(ItemQnaDTO qna) throws Exception {
		dao.updateQna(qna);
	}

}
