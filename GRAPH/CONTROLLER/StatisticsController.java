package com.amorepacific.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.amorepacific.service.statistics.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.amorepacific.service.statistics.StatisticsService;

@Controller
public class StatisticsController {
	
	@Autowired
	private StatisticsService statisticsService;
	
	@RequestMapping(value = "/statistics.do", method = RequestMethod.POST)//데이터
	@ResponseBody
	public HashMap<String,ArrayList<ArrayList<Object>>> statistics() {
		ArrayList<ArrayList<Object>> statistics = new ArrayList<ArrayList<Object>>();
		statistics = statisticsService.statistics();
		HashMap<String,ArrayList<ArrayList<Object>>> result = new HashMap<String,ArrayList<ArrayList<Object>>>();
		result.put("chart", statistics);
		return result;
	}
	@RequestMapping(value = "/statistics2.do", method = RequestMethod.POST)//데이터
	@ResponseBody
	public HashMap<String,ArrayList<ArrayList<Object>>> statistics2() {
		ArrayList<ArrayList<Object>> statistics = new ArrayList<ArrayList<Object>>();
		statistics = statisticsService.statistics2();
		HashMap<String,ArrayList<ArrayList<Object>>> result = new HashMap<String,ArrayList<ArrayList<Object>>>();
		result.put("chart", statistics);
		return result;
	}
	@RequestMapping(value = "/statistics3.do", method = RequestMethod.POST)//데이터
	@ResponseBody
	public HashMap<String,ArrayList<ArrayList<Object>>> statistics3() {
		ArrayList<ArrayList<Object>> statistics = new ArrayList<ArrayList<Object>>();
		statistics = statisticsService.statistics3();
		HashMap<String,ArrayList<ArrayList<Object>>> result = new HashMap<String,ArrayList<ArrayList<Object>>>();
		result.put("chart", statistics);
		return result;
	}
	@RequestMapping(value = "/statisticsView.do", method = RequestMethod.GET)//주소
	public String statisticsView() {
		
		return "front/statistics/statistics";
	}
}