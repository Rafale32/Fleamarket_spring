package com.sp.mainDetail.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sp.mainDetail.domain.Criteria_jy;
import com.sp.mainDetail.domain.ItemQnaDTO;
import com.sp.mainDetail.model.ReplyDAO;
import com.sp.memManage.domain.MemManageDTO;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Inject
	private ReplyDAO dao;
	
	@Override
	public List<ItemQnaDTO> listQna(Integer itemboard_no) throws Exception {
		
		List<ItemQnaDTO> list = dao.listQna(itemboard_no);
		
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i).getItem_qna_date());
		}
		
		for(int i=0; i<list.size(); i++){
			list.get(i).setStore_no(dao.storeNoInfo((list.get(i).getMember_no())).getStore_no());
			list.get(i).setStore_name(dao.storeNoInfo((list.get(i).getMember_no())).getStore_name());
			list.get(i).setItem_qna_date(time(list.get(i).getItem_qna_date()));
		}
		
		return list; 
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

	@Override
	public List<ItemQnaDTO> listQnaPage(Integer itemboard_no, Criteria_jy cri) throws Exception {
		return dao.listPage(itemboard_no, cri);
	}

	@Override
	public int count(Integer itemboard_no) throws Exception {
		return dao.count(itemboard_no);
	}
	
	public String time(String itemTime){
	  //아이템상세글 작성시간 처리
	    Date date = new Date();
	    SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a");
	    String today = f.format(date);
	    String itemDate = itemTime;
	    
	    List<Integer> tlist = new ArrayList<Integer>();
	    List<Integer> ilist = new ArrayList<Integer>();
	    tlist.add(Integer.parseInt(today.substring(0,4)));
	    tlist.add(Integer.parseInt(today.substring(5,7)));
	    tlist.add(Integer.parseInt(today.substring(8,10)));
	    tlist.add(Integer.parseInt(today.substring(11,13)));
	    tlist.add(Integer.parseInt(today.substring(14,16)));
	    tlist.add(Integer.parseInt(today.substring(17,19)));

	    ilist.add(Integer.parseInt(itemDate.substring(0,4)));
	    ilist.add(Integer.parseInt(itemDate.substring(5,7)));
	    ilist.add(Integer.parseInt(itemDate.substring(8,10)));
	    if(today.substring(20,22).equals("오후")){
	      ilist.add(Integer.parseInt(itemDate.substring(11,13))-12);
	    }else{
	      ilist.add(Integer.parseInt(itemDate.substring(11,13)));
	    }
	    ilist.add(Integer.parseInt(itemDate.substring(14,16)));
	    ilist.add(Integer.parseInt(itemDate.substring(17,19)));

	    String val1 = null;
	    String val2 = null;
	    int cnt = 0;
	    for(int i=0; i<6; i++){
	      cnt++;
	      if((tlist.get(i)-ilist.get(i))!=0){
	        val1 = String.valueOf((tlist.get(i)-ilist.get(i)));
	        break;
	      }
	    }
	    if(cnt == 1){
	      val2 = "년 전";
	    }else if(cnt == 2){
	      val2 = "달 전";
	    }else if(cnt == 3){
	      val2 = "일 전";
	    }else if(cnt == 4){
	      val2 = "시간 전";
	    }else if(cnt == 5){
	      val2 = "분 전";
	    }else if(cnt == 6){
	      val2 = "초 전";
	    }
	    String time = val1+val2;
	    
	    return time;
	  }

}
