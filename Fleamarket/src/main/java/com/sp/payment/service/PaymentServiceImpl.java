package com.sp.payment.service;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.sp.board.model.BoardDAO;
import com.sp.payment.domain.Criteria2;
import com.sp.payment.domain.DeliveryDTO_gy;
import com.sp.payment.domain.MystoreDTO_gy;
import com.sp.payment.domain.MystoreReviewDTO_gy;
import com.sp.payment.domain.PuerchaseDTO_gy;
import com.sp.payment.model.PaymentDAO;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Inject
	private PaymentDAO dao;

	@Override
	public void regist() throws Exception {
		// TODO Auto-generated method stub
		dao.create();
	}
	
	// 구매내역 +페이징
	@Override
	public List<PuerchaseDTO_gy> listPuerchase(DeliveryDTO_gy dto,Criteria2 cri) throws Exception {
		
		return dao.listPuerchase(dto,cri);
	}

	
	@Override
	public void changDeliverState(DeliveryDTO_gy dto) throws Exception {
		dao.changDeliverState(dto);
		
	}

	////


	@Override
	public void changDeliverState2(DeliveryDTO_gy dto) throws Exception {
		dao.changDeliverState2(dto);
		
	}
	
	//내상점 찾기
	@Override
	public MystoreDTO_gy SearchMystore(DeliveryDTO_gy dto) throws Exception {
		
		return dao.SearchMystore(dto);
	}

	@Override
	public List<MystoreReviewDTO_gy> MystoreReview(MystoreDTO_gy sdto,Criteria2 cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.MystoreReview(sdto,cri);
	}

	@Override
	public int puerchasecounting(DeliveryDTO_gy dto) throws Exception {
		// TODO Auto-generated method stub
		return dao.puerchasecounting(dto);
	}
	
	// 판매내역 + 페이징
	@Override
	public List<PuerchaseDTO_gy> listSell(DeliveryDTO_gy dto, Criteria2 cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSell(dto, cri);
	}

	@Override
	public int sellListcounting(DeliveryDTO_gy dto) throws Exception {
		// TODO Auto-generated method stub
		return dao.sellListcounting(dto);
	}
// 스토어 리뷰 카운팅
	@Override
	public int mystoreReviewCounting(MystoreDTO_gy sdto) throws Exception {
		// TODO Auto-generated method stub
		return dao.MystoreReviewcounting(sdto);
	}

	//insert_pdto
	@Override
	public void registerPerchaseAlram(PuerchaseDTO_gy pdto) throws Exception {
		dao.registerPerchaseAlram(pdto);
		
	}

	@Override
	public List<PuerchaseDTO_gy> listFavorit(DeliveryDTO_gy dto, Criteria2 cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listFavorit(dto, cri);
	}

	@Override
	public void deletfavorit(PuerchaseDTO_gy pdto) throws Exception {
		dao.deletfavorit(pdto);
		
	}


}
