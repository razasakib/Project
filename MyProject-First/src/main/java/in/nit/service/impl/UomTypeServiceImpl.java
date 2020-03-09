package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IUomTypeDao;
import in.nit.model.UomType;
import in.nit.service.IUomTypeService;

@Service
public class UomTypeServiceImpl implements IUomTypeService {
	@Autowired
	private IUomTypeDao dao;
	@Override
	@Transactional
	public Integer saveUomType(UomType ut) {
		return dao.saveUomType(ut);
	}
	@Override
	@Transactional(readOnly = false)
	public List<UomType> getAllUomType() {
		List<UomType> list=dao.getAllUomType();
		Collections.sort(list,(o1,o2)->o1.getUomId()-o1.getUomId());
		
	
		return list;
	}
	@Override
	@Transactional
	public void deleteUomType(Integer id) {
		dao.deleteUomType(id);
		
	}
	@Override
	@Transactional(readOnly = true)
	public UomType getOneUomType(Integer id) {
		return dao.getOneUomType(id);
	}
	@Override
	@Transactional
	public void updateUomType(UomType ut) {
			dao.updateUomType(ut);
	}
	@Override
	public List<Object[]> getUomTypePackingCount() {
		// TODO Auto-generated method stub
		return dao.getUomTypePackingCount();
	}
	@Override
	public List<Object[]> getUomIdAndModel() {

		return dao.getUomIdAndModel();
	}
}
