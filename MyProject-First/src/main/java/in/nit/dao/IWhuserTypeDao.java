package in.nit.dao;

import java.util.List;

import in.nit.model.WhuserType;

public interface IWhuserTypeDao {
	
	public Integer saveWhuserType(WhuserType wh );
	public List<WhuserType> getAllWhuserType();
	public WhuserType getOneWhuser(Integer id);
	public void deleteWhuserType(Integer Id);
	public void updateWhuserType(WhuserType wh);
	public List<Object[]> getWhuserTypeUseForCount();
	
	
	
	
	
	

}
