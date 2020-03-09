package in.nit.service;

import java.util.List;

import in.nit.model.OrderMethodType;

public interface IOrderMethodTypeService {
	Integer saveOrderMethodtype(OrderMethodType omt);
	List<OrderMethodType> getAllOrderMethodType();
	void deleteOrderMethodType(Integer id);
	public OrderMethodType viewOrderMethodType(Integer id);
	public void updateOrderMethodType(OrderMethodType omt);
	 public List<Object[]> getOrderMethodTypeMethodCount();


}
