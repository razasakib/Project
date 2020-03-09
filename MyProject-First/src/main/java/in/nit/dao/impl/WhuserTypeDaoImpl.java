package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IWhuserTypeDao;
import in.nit.model.WhuserType;
@Repository
public class WhuserTypeDaoImpl implements IWhuserTypeDao {
	@Autowired
	private HibernateTemplate ht;

	@Transactional
	public Integer saveWhuserType(WhuserType wh) {
		return (Integer)ht.save(wh);
	}

	public List<WhuserType> getAllWhuserType() {
		return ht.loadAll(WhuserType.class);
	}

	public WhuserType getOneWhuser(Integer id) {
		return ht.get(WhuserType.class, id);
	}
@Override
	public void deleteWhuserType(Integer id) {
	
	WhuserType wh=new WhuserType();
	wh.setWhuId(id);
			ht.delete(wh);
	}

	public void updateWhuserType(WhuserType wh) {
		ht.update(wh);
	}
@SuppressWarnings({ "deprecation", "unchecked" })
@Override
public List<Object[]> getWhuserTypeUseForCount() {
String hql="SELECT whusefor, count(whusefor) from in.nit.model.WhuserType group by whusefor";

	return (List<Object[]>) ht.find(hql);
}
}
