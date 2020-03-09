package in.nit.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.OrderMethodType;
import in.nit.service.IOrderMethodTypeService;
import in.nit.util.OrderMethodTypeUtil;
import in.nit.view.OrderTypeExcelView;
import in.nit.view.OrderTypePdfView;
@Controller
@RequestMapping("/order")
public class OrderMethodtypeController {
	@Autowired
	private IOrderMethodTypeService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private OrderMethodTypeUtil util;

	@RequestMapping("/show")
	public String showShipemntType(@ModelAttribute OrderMethodType orderMethodType) {
		return "OrderTypeRegister";
	}
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveOrderType(@ModelAttribute OrderMethodType orderMethodType,
			Model  model) {

		Integer id=service.saveOrderMethodtype(orderMethodType);
		String message="Record Inserted and Id is:"+id;

		model.addAttribute("message", message);

		return "OrderTypeRegister";
	}
	@RequestMapping("/all")
	public String getOrderType(Model model) {
		List<OrderMethodType> list=service.getAllOrderMethodType();
		model.addAttribute("list",list);
		return "OrderTypeData";
	}

	@RequestMapping("/delete")
	public String deleteShipment(
			@RequestParam("uid") Integer id,
			Model model) {

		service.deleteOrderMethodType(id);
		String message=id+" deleted";
		model.addAttribute("message",message);
		List<OrderMethodType> list=service.getAllOrderMethodType();

		model.addAttribute("list",list);

		return "OrderTypeData";
	}
	@RequestMapping("/view")
	public String viewOrderMethodType(@RequestParam("uid") Integer id,
			Model model) {
		OrderMethodType omt=service.viewOrderMethodType(id);
		model.addAttribute("omt",omt);

		return "OrderTypeView";
	}
	@RequestMapping(value = "/edit")
	public String showEditOrderType(@RequestParam ("uid") Integer id,
			Model  model) {

		OrderMethodType omt=service.viewOrderMethodType(id);
		model.addAttribute("orderMethodType",omt);

		return "OrderTypeEdit";

	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateOrderType(@ModelAttribute OrderMethodType orderMethodType,
			Model  model) {

		service.updateOrderMethodType(orderMethodType);
		String message="Order no '"+orderMethodType.getOrderId()+ "' is Updated";
		model.addAttribute("message",message);
		List<OrderMethodType> list=service.getAllOrderMethodType();
		model.addAttribute("list",list);
		return "OrderTypeData";

	}


	@RequestMapping(value = "/excel")
	public ModelAndView excelView(@RequestParam (value = "oid",required = false)Integer id) {
		ModelAndView mav= new ModelAndView();
		mav.setView(new OrderTypeExcelView());

		if(id!=null) {

			mav.addObject("list",Arrays.asList(service.viewOrderMethodType(id)));

		}
		else
			mav.addObject("list", service.getAllOrderMethodType());

		return mav;
	}

	@RequestMapping(value = "/pdf")
	public ModelAndView excelExport(@RequestParam (value = "oid",required = false)Integer id) {
		ModelAndView mav= new ModelAndView();
		mav.setView(new OrderTypePdfView());

		if(id!=null) {

			mav.addObject("list",Arrays.asList(service.viewOrderMethodType(id)));

		}
		else
			mav.addObject("list", service.getAllOrderMethodType());

		return mav;
	}
	@RequestMapping("/charts")
	public String showCharts() {
		List<Object[]> list=service.getOrderMethodTypeMethodCount();
		String path=context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBarChart(path, list);

		return "OrderMethodCharts";
	}

}
