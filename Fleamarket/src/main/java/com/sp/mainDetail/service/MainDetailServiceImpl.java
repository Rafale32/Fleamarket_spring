package com.sp.mainDetail.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sp.mainDetail.domain.CategoryDTO;
import com.sp.mainDetail.domain.HotItemDTO;
import com.sp.mainDetail.domain.HotListDTO;
import com.sp.mainDetail.domain.ItemDetailDTO;
import com.sp.mainDetail.domain.ItemImgDTO;
import com.sp.mainDetail.domain.ItemQnaDTO;
import com.sp.mainDetail.domain.RecommendDTO;
import com.sp.mainDetail.domain.StoreInfoDTO;
import com.sp.mainDetail.domain.SubCategoryDTO;
import com.sp.mainDetail.model.MainDetailDAO;

@Service
public class MainDetailServiceImpl implements MainDetailService {
	
	@Inject
	private MainDetailDAO dao;

	@Override
	public List<RecommendDTO> recommend() throws Exception {
		List<RecommendDTO> recoList = new ArrayList<RecommendDTO>();
    recoList = dao.recommend();
    
    for(int i=0; i<recoList.size(); i++){
      recoList.get(i).setImgList(dao.itemImgList(recoList.get(i).getItemboard_no()));
      recoList.get(i).setItemboard_date(time(recoList.get(i).getItemboard_date()));
    }
    
    return recoList;
	}

	@Override
	public List<HotItemDTO> hotItemList() throws Exception {
		List<HotItemDTO> hotItemList = new ArrayList<HotItemDTO>();
    hotItemList = dao.hotItemList();
    
    for(int i=0; i<hotItemList.size(); i++){
      hotItemList.get(i).setImgList(dao.itemImgList(hotItemList.get(i).getItemboard_no()));
    }
    return hotItemList;
	}

	@Override
	public List<CategoryDTO> categoryList() throws Exception {
		List<CategoryDTO> categoryList = new ArrayList<CategoryDTO>();
    List<SubCategoryDTO> subCategoryList = new ArrayList<SubCategoryDTO>();
    categoryList = dao.categoryList();
    subCategoryList = dao.subCategoryList();

    for (int i = 0; i < categoryList.size(); i++) {
      List<SubCategoryDTO> list = new ArrayList<SubCategoryDTO>();
      for (int j = 0; j < subCategoryList.size(); j++) {
        if (categoryList.get(i).getCategory_no() == subCategoryList.get(j).getCategory_no()) {
          list.add(subCategoryList.get(j));
        }
      }
      categoryList.get(i).setSubCategory(list);
    }
    return categoryList;
	}

	@Override
	public List<ItemImgDTO> itemImgList(Integer itemboard_no) throws Exception {
		List<ItemImgDTO> itemImgList = new ArrayList<ItemImgDTO>();
    itemImgList = dao.itemImgList(itemboard_no);
    return itemImgList;
	}

	@Override
	public ItemDetailDTO itemDetail(Integer itemboard_no) throws Exception {
		ItemDetailDTO itemDetail = new ItemDetailDTO();
    itemDetail = dao.itemDetail(itemboard_no);
    
    itemDetail.setItemboard_viewcount(itemDetail.getItemboard_viewcount()+1);
    itemDetail.setItemboard_date(time(itemDetail.getItemboard_date()));

    //태그쪼개서 태그리스트 처리
    if (itemDetail.getTag_name() == null) {
      return itemDetail;
    } else {
      List<String> strList = new ArrayList<String>();
      StringTokenizer st = new StringTokenizer(itemDetail.getTag_name(), ",");

      while (st.hasMoreTokens()) {
        strList.add(st.nextToken());
      }
      itemDetail.setTagList(strList);

      return itemDetail;
    }
	}

	@Override
	public List<HotListDTO> hotList() throws Exception {
		List<HotListDTO> hotList = new ArrayList<HotListDTO>();
    hotList = dao.hotList();
    List<HotItemDTO> hotItemList = new ArrayList<HotItemDTO>();
    hotItemList = dao.hotItemList();
    
    for(int i=0; i<hotItemList.size(); i++){
      hotItemList.get(i).setImgList(dao.itemImgList(hotItemList.get(i).getItemboard_no()));
    }
    
    for (int i = 0; i < hotList.size(); i++) {
      List<HotItemDTO> list = new ArrayList<HotItemDTO>();
      for (int j = 0; j < hotItemList.size(); j++) {
        if (hotList.get(i).getCategory_title().equals(hotItemList.get(j).getCategory_title())) {
          hotItemList.get(j).setItemboard_date(time(hotItemList.get(j).getItemboard_date()));
          list.add(hotItemList.get(j));
        }
      }
      hotList.get(i).setHotItemList(list);
    }
    return hotList;
	}

	@Override
	public StoreInfoDTO storeInfo(Integer itemboard_no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemQnaDTO> itemQnaList(Integer itemboard_no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertQna(ItemQnaDTO qna) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteQna(Integer item_qna_no) throws Exception {
		// TODO Auto-generated method stub
		
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
