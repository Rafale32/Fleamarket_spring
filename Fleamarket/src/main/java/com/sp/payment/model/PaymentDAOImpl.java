package com.sp.payment.model;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sp.payment.domain.Criteria2;
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
	public List<PuerchaseDTO_gy> listPuerchase(DeliveryDTO_gy dto,Criteria2 cri) throws Exception {
		//로우 바운즈 개허니맛
		return session.selectList(namespace+".puerchaseList",dto,new RowBounds(cri.getPageStart() , cri.getPerPageNum()));
	}

	//구매자 변경
	@Override
	public void changDeliverState(DeliveryDTO_gy dto) throws Exception {
		
		session.update(namespace +".perchasedeliveryupdate" , dto);
		
	}
	//판매 리스트
	@Override
	public List<PuerchaseDTO_gy> listSell(DeliveryDTO_gy dto, Criteria2 cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace +".SellList",dto,new RowBounds(cri.getPageStart() , cri.getPerPageNum()));
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
	public List<MystoreReviewDTO_gy> MystoreReview(MystoreDTO_gy sdto, Criteria2 cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".MystoreReview", sdto,new RowBounds(cri.getPageStart() , cri.getPerPageNum()));
	}
	
	
	//줄수 카운팅 자료 수 
	@Override
	public int puerchasecounting(DeliveryDTO_gy dto) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".puerchasecounting", dto);
	}

	@Override
	public int sellListcounting(DeliveryDTO_gy dto) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".SellListcounting", dto);
	}

	@Override
	public int MystoreReviewcounting(MystoreDTO_gy sdto) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".MystoreReviewCounting", sdto);
	}
	
}
