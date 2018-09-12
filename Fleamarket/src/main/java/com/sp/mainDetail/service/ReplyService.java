package com.sp.mainDetail.service;

import java.util.List;

import com.sp.mainDetail.domain.ItemQnaDTO;

public interface ReplyService {

	public List<ItemQnaDTO> listQna(Integer itemboard_no)throws Exception;
	
	public void createQna(ItemQnaDTO qna)throws Exception;
	
	public void deleteQna(Integer item_qna_no)throws Exception;
	
	public void updateQna(ItemQnaDTO qna)throws Exception;
	
	public int countQna(Integer itemboard_no)throws Exception;
	
	public int getItemboard_no(Integer item_qna_no)throws Exception;
	
	public int maxQnaNo(Integer item_qna_no) throws Exception;
}
