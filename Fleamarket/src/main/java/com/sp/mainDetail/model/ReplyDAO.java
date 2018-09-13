package com.sp.mainDetail.model;

import java.util.List;

import com.sp.mainDetail.domain.Criteria_jy;
import com.sp.mainDetail.domain.ItemQnaDTO;

public interface ReplyDAO {
	
	public List<ItemQnaDTO> listQna(Integer itemboard_no)throws Exception;
	
	public void createQna(ItemQnaDTO qna)throws Exception;
	
	public void deleteQna(Integer item_qna_no)throws Exception;
	
	public void updateQna(ItemQnaDTO qna)throws Exception;
	
	public int countQna(Integer itemboard_no)throws Exception;
	
	public int maxQnaNo(Integer item_qna_no)throws Exception;
	
	public int getItemboard_no(Integer itemboard_no)throws Exception;
	
	public List<ItemQnaDTO> listPage(Integer itemboard_no, Criteria_jy cri)throws Exception;
	
	public int count(Integer itemboard_no)throws Exception;
	
	public ItemQnaDTO storeNoInfo(Integer member_no)throws Exception;
	
	
}
