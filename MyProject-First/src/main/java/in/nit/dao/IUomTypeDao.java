package in.nit.dao;

import in.nit.model.UomType;

import java.util.List;

public interface IUomTypeDao {

	Integer saveUomType(UomType ut);
	List<UomType> getAllUomType();
	void deleteUomType(Integer id);
	public UomType getOneUomType(Integer id);
	public void updateUomType(UomType ut);
	public List<Object[]> getUomTypePackingCount();
	public List<Object[]> getUomIdAndModel();
	
}
