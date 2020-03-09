package in.nit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.Part;
import in.nit.model.UomType;
import in.nit.service.IPartService;
import in.nit.service.IUomTypeService;
import in.nit.util.CommonConverter;
@Controller
@RequestMapping("/part")
public class PartController {
	@Autowired
	private IPartService service;
	@Autowired
	private IUomTypeService uomService;
	
	
	private void CommonUiUom(Model model) {
		List<UomType> uomlist=uomService.getAllUomType();
		model.addAttribute("uomlist", uomlist);
	}
	
	private void CommonUi(Model model) {
	List<Object[]> list=uomService.getUomIdAndModel();
	
	list.forEach(System.out::println);
	System.out.println("commnui execute");
	Map<Integer,String> uomMap=CommonConverter.convert(list);
	model.addAttribute("uomMap", uomMap);
	}
	
	
	
	@RequestMapping("/show")
	public String showPart( Model model) {
		model.addAttribute("part", new Part());
		CommonUi(model);
		return "PartRegister";
	}
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String savePart(@ModelAttribute Part part,
			Model  model) {

		Integer id=service.savePart(part);
		String message="Record Inserted and Id is:"+id;

		model.addAttribute("message", message);
		model.addAttribute("part", new Part());
		//CommonUiUom(model);
		CommonUi(model);
		return "PartRegister";
	}
	@RequestMapping("/all")
	public String getPart(Model model) {
		List<Part> list=service.getAllPart();
		model.addAttribute("list",list);
		return "PartData";
	}

	@RequestMapping("/delete")
	public String deletePart(
			@RequestParam("pid") Integer id,
			Model model) {

		service.deletePart(id);
		String message=id+" deleted";
		model.addAttribute("message",message);
		List<Part> list=service.getAllPart();

		model.addAttribute("list",list);

		return "redirect:all";
	}
	@RequestMapping("/view")
	public String viewOnePart(@RequestParam("pid") Integer id,
			Model model) {
		Part pt=service.OnePart(id);
		model.addAttribute("part",pt);

		return "PartView";
	}
	@RequestMapping(value = "/edit")
	public String showEditPart(@RequestParam ("pid") Integer id,
			Model  model) {

		Part pt=service.OnePart(id);
		model.addAttribute("part",pt);
		CommonUiUom(model);

		return "PartEdit";

	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePart(@ModelAttribute Part part,
			Model  model) {

		service.updatePart(part);
		String message="Part no '"+part.getPartId()+ "' is Updated";
		model.addAttribute("message",message);
		List<Part> list=service.getAllPart();
		model.addAttribute("list",list);
		return "PartData";

	}


	/*
	 * @RequestMapping(value = "/excel") public ModelAndView excelView(@RequestParam
	 * (value = "pid",required = false)Integer id) { ModelAndView mav= new
	 * ModelAndView(); mav.setView(new OrderTypeExcelView());
	 * 
	 * if(id!=null) {
	 * 
	 * mav.addObject("list",Arrays.asList(service.viewOrderMethodType(id)));
	 * 
	 * } else mav.addObject("list", service.getAllOrderMethodType());
	 * 
	 * return mav; }
	 * 
	 * @RequestMapping(value = "/pdf") public ModelAndView excelExport(@RequestParam
	 * (value = "oid",required = false)Integer id) { ModelAndView mav= new
	 * ModelAndView(); mav.setView(new OrderTypePdfView());
	 * 
	 * if(id!=null) {
	 * 
	 * mav.addObject("list",Arrays.asList(service.viewOrderMethodType(id)));
	 * 
	 * } else mav.addObject("list", service.getAllOrderMethodType());
	 * 
	 * return mav; }
	 * 
	 * @RequestMapping("/charts") public String showCharts() { List<Object[]>
	 * list=service.getOrderMethodTypeMethodCount(); String
	 * path=context.getRealPath("/"); util.generatePie(path, list);
	 * util.generateBarChart(path, list);
	 * 
	 * return "OrderMethodCharts"; }
	 * 
	 */}
