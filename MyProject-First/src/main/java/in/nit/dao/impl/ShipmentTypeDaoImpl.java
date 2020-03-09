package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IShipmentTypeDao;
import in.nit.model.ShipmentType;
@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveShipemntType(ShipmentType s) {
		return (Integer)ht.save(s);
	}

	@Override
	public List<ShipmentType> getAllShipmentType() {
		return ht.loadAll(ShipmentType.class);
	}
	public void deleteShipmentType(Integer id) {
			ht.delete(new ShipmentType(id));
	}
	@Override
	public void updateShipmentType(ShipmentType s) {
			ht.update(s);
			
	}
	@Override
	public ShipmentType getOneShipmentType(Integer id) {
		return ht.get(ShipmentType.class, id);
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getShipmentModeCount() {
		String hql="SELECT shipMod, count(shipMod) from in.nit.model.ShipmentType group by shipMod";
		return (List<Object[]>) ht.find(hql);
	}
}
