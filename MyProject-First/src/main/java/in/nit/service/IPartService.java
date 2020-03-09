package in.nit.service;

import java.util.List;

import in.nit.model.Part;

public interface IPartService {
	Integer savePart(Part p);
	List<Part> getAllPart();
	void deletePart(Integer id);
	 public Part OnePart(Integer id);
	 public void updatePart(Part p);
}
