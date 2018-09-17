package com.sp.bean;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sp.mainDetail.domain.CategoryDTO;
import com.sp.mainDetail.domain.HotItemDTO;
import com.sp.mainDetail.domain.HotListDTO;
import com.sp.mainDetail.domain.ItemDetailDTO;
import com.sp.mainDetail.domain.ItemImgDTO;
import com.sp.mainDetail.domain.ItemQnaDTO;
import com.sp.mainDetail.domain.RecommendDTO;
import com.sp.mainDetail.domain.StoreInfoDTO;
import com.sp.mainDetail.domain.SubCategoryDTO;
import com.sp.memManage.domain.MemManageDTO;
import com.sp.memManage.domain.StoreDTO;
import com.sp.product.domain.CateDTO;
import com.sp.product.domain.CateSubDTO;
import com.sp.product.domain.ItemDTO;
import com.sp.product.domain.PageModel;
import com.sp.safepay.domain.DeliveryDTO;
import com.sp.safepay.domain.ItemImgDTO_jh;
import com.sp.safepay.domain.OorderDTO;
import com.sp.safepay.domain.PaymentDTO;




public class Bean  {
	

	// 재헌
	DeliveryDTO deliveryDTO;     // 배송정보
	PaymentDTO paymentDTO;       // 결제정보
	OorderDTO oorderDTO;         //주문정보
	ItemDTO itemDTO;             // 상품정보
	MemManageDTO memManageDTO;   //회원정보
	ItemImgDTO_jh itemImgDTO_jh; //상품 이미지

	
	//두연
	List<ItemDTO> itemList;
	private HttpServletRequest request;
	//List<String> cateList; //카테고리 리스트  //수정 폼에서는 대 카테로 쓰임
	private List<String> sub_cateList; // 물품 수정폼에서 쓰기위해 만듬
	private List<CateDTO> cateList;//대분류 카테고리 객체 리스트
	private PageModel pageModel;//페이지 처리위한넘
	private List<CateSubDTO> subCate;//수정폼에서 대분류별로 카테고리 뿌려 쓰기위함
	private String searchSubj;//검색시 검색 한 글 가지고 가지위함
	private String store_Name;//레프트 메뉴 분기때문에 넣어둠
	
	//추천상품리스트 추가
	private List<RecommendDTO> recommend;
	//인기상품리스트 추가(주영)
	private List<HotItemDTO> hotItemList;
	private List<HotListDTO> hotList;
	private List<CategoryDTO> categoryList;
	private List<SubCategoryDTO> subCategoryList;
	private List<ItemImgDTO> itemImgList;
	private ItemDetailDTO itemDetail;
	private StoreInfoDTO storeInfo;
	private List<ItemQnaDTO> itemQnaList;
	private List<ItemDetailDTO> categoryItemList;
	
	//상점추가-주원 0823
	private StoreDTO storeDTO;
	
	
	//--------------------------
	public Bean() {	}
	public Bean(HttpServletRequest request) {
		this.request=request;
	}
	//--------------------------
	
	
	
	
	
	
	
	

	public PaymentDTO getPaymentDTO() {
		return paymentDTO;
	}

	public String getStore_Name() {
		return store_Name;
	}
	public void setStore_Name(String store_Name) {
		this.store_Name = store_Name;
	}
	public String getSearchSubj() {
		return searchSubj;
	}
	public void setSearchSubj(String searchSubj) {
		this.searchSubj = searchSubj;
	}
	public List<CateSubDTO> getSubCate() {
		return subCate;
	}
	public void setSubCate(List<CateSubDTO> subCate) {
		this.subCate = subCate;
	}
	public DeliveryDTO getDeliveryDTO() {
    return deliveryDTO;
  }
  public void setDeliveryDTO(DeliveryDTO deliveryDTO) {
    this.deliveryDTO = deliveryDTO;
  }
  public OorderDTO getOorderDTO() {
    return oorderDTO;
  }
  public void setOorderDTO(OorderDTO oorderDTO) {
    this.oorderDTO = oorderDTO;
  }
  public void setPaymentDTO(PaymentDTO paymentDTO) {
		this.paymentDTO = paymentDTO;
	}
	public ItemDTO getItemDTO() {
		return itemDTO;
	}
	public void setItemDTO(ItemDTO itemDTO) {
		this.itemDTO = itemDTO;
	}
	public MemManageDTO getMemManageDTO() {
		return memManageDTO;
	}
	public void setMemManageDTO(MemManageDTO memManageDTO) {
		this.memManageDTO = memManageDTO;
	}
	public ItemImgDTO_jh getItemImgDTO_jh() {
		return itemImgDTO_jh;
	}
	public void setItemImgDTO_jh(ItemImgDTO_jh itemImgDTO_jh) {
		this.itemImgDTO_jh = itemImgDTO_jh;
	}
	public List<ItemDTO> getItemList() {
		return itemList;
	}
	public void setItemList(List<ItemDTO> itemList) {
		this.itemList = itemList;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public List<CateDTO> getCateList() {
		return cateList;
	}
	public void setCateList(List<CateDTO> cateList) {
		this.cateList = cateList;
	}
	public List<String> getSub_cateList() {
		return sub_cateList;
	}
	public void setSub_cateList(List<String> sub_cateList) {
		this.sub_cateList = sub_cateList;
	}
	public PageModel getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
	public List<RecommendDTO> getRecommend() {
		return recommend;
	}
	public void setRecommend(List<RecommendDTO> recommend) {
		this.recommend = recommend;
	}
	public List<HotItemDTO> getHotItemList() {
		return hotItemList;
	}
	public void setHotItemList(List<HotItemDTO> hotItemList) {
		this.hotItemList = hotItemList;
	}
	public List<HotListDTO> getHotList() {
		return hotList;
	}
	public void setHotList(List<HotListDTO> hotList) {
		this.hotList = hotList;
	}
	public List<CategoryDTO> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<CategoryDTO> categoryList) {
		this.categoryList = categoryList;
	}
	public List<SubCategoryDTO> getSubCategoryList() {
		return subCategoryList;
	}
	public void setSubCategoryList(List<SubCategoryDTO> subCategoryList) {
		this.subCategoryList = subCategoryList;
	}
	public List<ItemImgDTO> getItemImgList() {
		return itemImgList;
	}
	public void setItemImgList(List<ItemImgDTO> itemImgList) {
		this.itemImgList = itemImgList;
	}
	public ItemDetailDTO getItemDetail() {
		return itemDetail;
	}
	public void setItemDetail(ItemDetailDTO itemDetail) {
		this.itemDetail = itemDetail;
	}
	public StoreInfoDTO getStoreInfo() {
		return storeInfo;
	}
	public void setStoreInfo(StoreInfoDTO storeInfo) {
		this.storeInfo = storeInfo;
	}
	public List<ItemQnaDTO> getItemQnaList() {
		return itemQnaList;
	}
	public void setItemQnaList(List<ItemQnaDTO> itemQnaList) {
		this.itemQnaList = itemQnaList;
	}
	public List<ItemDetailDTO> getCategoryItemList() {
		return categoryItemList;
	}
	public void setCategoryItemList(List<ItemDetailDTO> categoryItemList) {
		this.categoryItemList = categoryItemList;
	}
	public StoreDTO getStoreDTO() {
		return storeDTO;
	}
	public void setStoreDTO(StoreDTO storeDTO) {
		this.storeDTO = storeDTO;
	}
	
	
	
	
	
}
