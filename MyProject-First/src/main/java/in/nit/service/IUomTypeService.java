package in.nit.service;

import java.util.List;

import in.nit.model.UomType;

public interface IUomTypeService {

	public Integer saveUomType(UomType ut);
	List<UomType> getAllUomType();
	void deleteUomType(Integer id);
	public UomType getOneUomType(Integer id);
	public void updateUomType(UomType ut);
	public List<Object[]> getUomTypePackingCount();
	public List<Object[]> getUomIdAndModel();


}
