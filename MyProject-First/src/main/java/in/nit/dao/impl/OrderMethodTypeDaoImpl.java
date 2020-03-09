package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import in.nit.dao.IOrderMethodTypeDao;
import in.nit.model.OrderMethodType;
@Repository
public class OrderMethodTypeDaoImpl implements IOrderMethodTypeDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveOrderMethodtype(OrderMethodType omt) {
		return (Integer)ht.save(omt);
	}

	@Override
	public List<OrderMethodType> getAllOrderMethodType() {
		return ht.loadAll(OrderMethodType.class);
	}
	@Override
	public void deleteOrderMethodType(Integer id) {
		OrderMethodType omt= new OrderMethodType();
		omt.setOrderId(id);
		ht.delete(omt);

	}
	@Override
	public OrderMethodType viewOrderMethodType(Integer id) {
		return ht.get(OrderMethodType.class, id);
	}
	@Override
	public void updateOrderMethodType(OrderMethodType omt) {
		ht.update(omt);	
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getOrderMethodTypeMethodCount() {
		String hql="SELECT orderMeth,COUNT(orderMeth) FROM in.nit.model.OrderMethodType group by orderMeth";
		
		return (List<Object[]>) ht.find(hql);

	}
}
