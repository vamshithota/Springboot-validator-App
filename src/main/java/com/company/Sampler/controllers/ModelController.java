package com.company.Sampler.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelController {

	@RequestMapping(path = "/model", method = RequestMethod.GET)
	public String modelEg(Model model) {
		Map<String,String> mapData = new HashMap<>();
		model.addAttribute("message", "vamshi");
		// we can use map with model interface
		mapData.put("user", "thota");
		//model.addAttribute(null, "");
		model.mergeAttributes(mapData);
		return "viewPage";
		
	}
	@GetMapping(path = "/modelmap")
	public String modelMapEg(ModelMap modelMap) {
		modelMap.addAttribute("message", "vamshi");
		modelMap.addAttribute("user", "thota2");
		return "viewPage";
	}
	@GetMapping(path = "/modelview")
	public ModelAndView modelAndViewEg() {
		ModelAndView modelView = new ModelAndView("viewPage");
		modelView.addObject("message", "vamshi3");
		modelView.addObject("user", "thota2");
		return modelView;
	}
	
}
