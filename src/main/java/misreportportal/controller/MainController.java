package misreportportal.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import misreportportal.pojos.Subscription;
import misreportportal.service.Services;

@RestController 
public class MainController {
	
    @Autowired
	private Services service;
	 
	@GetMapping(value="/home" ,produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
	public Subscription getHome()
	{
		
		return service.getServiceName().get(1);
	}
	
	@RequestMapping("/mis")
//	@ResponseBody
	public String getMissData()
	{
		String action="1";
		service.getMisReportData(action);
		return "Call Success";
	}
	
}
