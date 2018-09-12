package com.sp.payment.model;

import java.util.List;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.sp.payment.domain.DeliveryDTO_gy;
import com.sp.payment.domain.MystoreDTO_gy;
import com.sp.payment.domain.MystoreReviewDTO_gy;
import com.sp.payment.domain.PuerchaseDTO_gy;

@Repository
public class PaymentDAOImpl implements PaymentDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "PaymentMapper";
	
	//
	@Override
	public void create() throws Exception {
		//session.insert(namespace + ".create", vo);
	}
	
	// 리스트로 오는 것
	@Override
	public List<PuerchaseDTO_gy> listPuerchase(DeliveryDTO_gy dto) throws Exception {
		
		return session.selectList(namespace+".puerchaseList",dto);
	}

	//구매자 변경
	@Override
	public void changDeliverState(DeliveryDTO_gy dto) throws Exception {
		
		session.update(namespace +".perchasedeliveryupdate" , dto);
		
	}
	//판매 리스트
	@Override
	public List<PuerchaseDTO_gy> listSell(DeliveryDTO_gy dto) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace +".SellList",dto);
	}
	
	//판매자 판매승인
	@Override
	public void changDeliverState2(DeliveryDTO_gy dto) throws Exception {
		session.update(namespace +".perchasedeliveryupdate2" , dto);
	}

	@Override
	public MystoreDTO_gy SearchMystore(DeliveryDTO_gy dto) throws Exception {
		
		return (MystoreDTO_gy) session.selectOne(namespace + ".SearchMystore", dto);
	}

	@Override
	public List<MystoreReviewDTO_gy> MystoreReview(MystoreDTO_gy sdto) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".MystoreReview", sdto);
	}
	
}
