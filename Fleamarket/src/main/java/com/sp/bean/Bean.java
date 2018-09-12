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
import com.sp.product.domain.ItemDTO;
import com.sp.product.domain.PageModel;
import com.sp.safepay.domain.DeliveryDTO_jh;
import com.sp.safepay.domain.ItemImgDTO_jh;
import com.sp.safepay.domain.PaymentDTO;
import com.sp.safepay.domain.SpellDTO_jh;




public class Bean  {
	

	// 20180816,재헌 DeliveryDTO 추가
	DeliveryDTO_jh deliveryDTO_jh; // 배송정보
	// 20180817,재헌 PaymentDTO, SpellDTO_jh 추가
	PaymentDTO paymentDTO;       // 결제정보
	SpellDTO_jh spellDTO_jh;     //주문정보
	ItemDTO itemDTO;             // 상품정보
	MemManageDTO memManageDTO;   //회원정보
	// 20180823,재헌 상품이미지추가
	ItemImgDTO_jh itemImgDTO_jh; //상품 이미지

	
	//두연
	List<ItemDTO> itemList;
	private HttpServletRequest request;
	//List<String> cateList; //카테고리 리스트  //수정 폼에서는 대 카테로 쓰임
	List<String> sub_cateList; // 물품 수정폼에서 쓰기위해 만듬
	List<CateDTO> cateList;//대분류 카테고리 객체 리스트
	PageModel pageModel;//페이지 처리위한넘
	
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
	
	
	
	
	
	
	
	
	public DeliveryDTO_jh getDeliveryDTO_jh() {
		return deliveryDTO_jh;
	}
	public void setDeliveryDTO_jh(DeliveryDTO_jh deliveryDTO_jh) {
		this.deliveryDTO_jh = deliveryDTO_jh;
	}
	public PaymentDTO getPaymentDTO() {
		return paymentDTO;
	}
	public void setPaymentDTO(PaymentDTO paymentDTO) {
		this.paymentDTO = paymentDTO;
	}
	public SpellDTO_jh getSpellDTO_jh() {
		return spellDTO_jh;
	}
	public void setSpellDTO_jh(SpellDTO_jh spellDTO_jh) {
		this.spellDTO_jh = spellDTO_jh;
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
