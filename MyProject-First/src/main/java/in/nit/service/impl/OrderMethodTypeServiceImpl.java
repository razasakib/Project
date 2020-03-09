package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IOrderMethodTypeDao;
import in.nit.model.OrderMethodType;
import in.nit.service.IOrderMethodTypeService;
@Service
public class OrderMethodTypeServiceImpl implements IOrderMethodTypeService {
	@Autowired
	private IOrderMethodTypeDao dao;

	@Override
	@Transactional
	public Integer saveOrderMethodtype(OrderMethodType omt) {
		System.out.println("save medthod successfu;;");

		return dao.saveOrderMethodtype(omt);
	}
	@Override
	@Transactional(readOnly = true)
	public List<OrderMethodType> getAllOrderMethodType() {
		List<OrderMethodType> list=dao.getAllOrderMethodType();
		Collections.sort(list,(o1,o2)->o1.getOrderId()-o2.getOrderId());
		return list;
	}
	@Override
	@Transactional
	public void deleteOrderMethodType(Integer id) {
		dao.deleteOrderMethodType(id);

	}
	@Override
	@Transactional(readOnly = true)
	public OrderMethodType viewOrderMethodType(Integer id) {
		return dao.viewOrderMethodType(id);
	}
	@Override
	public void updateOrderMethodType(OrderMethodType omt) {
			dao.updateOrderMethodType(omt);
	}
	@Override
	public List<Object[]> getOrderMethodTypeMethodCount() {
		// TODO Auto-generated method stub
		return dao.getOrderMethodTypeMethodCount();
	}
}
