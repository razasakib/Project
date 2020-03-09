package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IPartDao;
import in.nit.model.Part;

@Repository
public class PartDaoImpl implements IPartDao {
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer savePart(Part p) {

		return (Integer) ht.save(p);
	}

	@Override
	public List<Part> getAllPart() {
		
		return ht.loadAll(Part.class);
	}

	@Override
	public void deletePart(Integer id) {
		
		ht.delete(new Part(id));
	}

	@Override
	public Part OnePart(Integer id) {
		
		return ht.get(Part.class, id);
	}

	@Override
	public void updatePart(Part p) {
		ht.update(p);

	}

}
