package in.nit.service;

import java.util.List;

import in.nit.model.ShipmentType;

public interface IShipmentTypeService {
	Integer saveShipemntType(ShipmentType s);
	List<ShipmentType> getAllShipmentType();
	public void deleteShipmentType(Integer id);
	public void updateShipmentType(ShipmentType s); 
	public ShipmentType getOneShipmentType(Integer id);
	public List<Object[]> getShipmentModeCount();


}
