package in.nit.dao;

import java.util.List;

import in.nit.model.Part;


public interface IPartDao {
	Integer savePart(Part p);
	List<Part> getAllPart();
	void deletePart(Integer id);
	 public Part OnePart(Integer id);
	 public void updatePart(Part p);
	 

}
