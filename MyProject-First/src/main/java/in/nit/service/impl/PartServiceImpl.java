package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IPartDao;
import in.nit.model.Part;
import in.nit.service.IPartService;
@Service
public class PartServiceImpl implements IPartService {

	@Autowired
	private IPartDao dao;
	
	@Override
	@Transactional()
	public Integer savePart(Part p) {

		return dao.savePart(p);
	}
	@Override
	
	@Transactional(readOnly = true)
	public List<Part> getAllPart() {
		return dao.getAllPart();
	}
	@Override
	@Transactional(readOnly = true)
	public Part OnePart(Integer id) {
		return dao.OnePart(id);
	}
	@Override
	@Transactional()
	public void updatePart(Part p) {
		
		dao.updatePart(p);
	}
	@Override
	@Transactional()
	public void deletePart(Integer id) {

		dao.deletePart(id);
	}
}

