package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IWhuserTypeDao;
import in.nit.model.WhuserType;
import in.nit.service.IWhuserTypeService;
@Service

public class WhuserTypeServiceImpl implements IWhuserTypeService {
	@Autowired
	private IWhuserTypeDao dao;
	@Transactional
	public void deleteWhuserType(Integer id) {
		dao.deleteWhuserType(id);
		
	}
	@Transactional
	public Integer saveWhuserType(WhuserType wh) {
		return dao.saveWhuserType(wh);
	}
	@Transactional(readOnly = true)
	public List<WhuserType> getAllWhuserType() {
		
		List<WhuserType> list=dao.getAllWhuserType();
		Collections.sort(list, (o1,o2)->o1.getWhuId()-o2.getWhuId());
		return list;
		
	}

	@Transactional(readOnly = true)
	public WhuserType getOneWhuser(Integer id) {
		return dao.getOneWhuser(id);
	}

	@Transactional
	@Override
	public void updateWhuserType(WhuserType wh) {
		dao.updateWhuserType(wh);
		
	}

@Override
	public List<Object[]> getWhuserTypeUseForCount() {
		// TODO Auto-generated method stub
		return dao.getWhuserTypeUseForCount();
	}	
}
