package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IUomTypeDao;
import in.nit.model.UomType;

@Repository
public class UomTypeDaoImpl implements IUomTypeDao {
	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveUomType(UomType ut) {

		return (Integer)ht.save(ut);
	}
	@Override
	public List<UomType> getAllUomType() {
		return ht.loadAll(UomType.class);
	}
	@Override
	public void deleteUomType(Integer id) {
		UomType ut=new UomType(id);
		ht.delete(ut);
	}
	@Override
	public UomType getOneUomType(Integer id) {
		return ht.get(UomType.class, id);
	}
	@Override
	public void updateUomType(UomType ut) {
		ht.update(ut);
		
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getUomTypePackingCount() {
		String hql="SELECT uomType,COUNT(uomType) FROM in.nit.model.UomType group by uomType";
		
		return (List<Object[]>) ht.find(hql);
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getUomIdAndModel() {
		String hql=" SELECT uomId, uomModel from in.nit.model.UomType";
		List<Object[]> list=null;
		
		list=(List<Object[]>) ht.find(hql);
		
		list.forEach(System.out::println);
		return list; 
		
	}
	
}
