package com.amorepacific.service.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.amorepacific.repository.statistics.StatisticsDao;

@Service
public class StatisticsServicelmpl implements StatisticsService{
	@Resource
	public StatisticsDao statisticsdao;
	
		public ArrayList<ArrayList<Object>> statistics(){
			
			ArrayList<ArrayList<Object>> Result = new ArrayList<ArrayList<Object>>();
			ArrayList<HashMap<String, Object>> temp =  statisticsdao.findList();
			int i;
			ArrayList<Object> result2 = new ArrayList<Object>();
			
			String a = "월";
			String b = "회의횟수";
			
			result2.add(a);
			result2.add(b);
			
			//result2.add(String.valueOf("회의횟수"));
			Result.add(result2);
			
			for(i=0; i<temp.size(); i++){

				result2 = new ArrayList<Object>();
				result2.add(String.valueOf(temp.get(i).get("month")));//템프가 0부터 temp사이즈까지 증가하며 month값을 가져옴
				result2.add(temp.get(i).get("cnt"));//cnt값을 가져옴
				Result.add(result2);
				System.out.println(Result);
			}
			//result2는 [1월,17번] 같이 1개를 이룸 temp 값을 result2에 집어 넣고 result2를 다시 result로 넣고 result를 반환시키면 됌
			return Result;
		}
public ArrayList<ArrayList<Object>> statistics2(){
			
			ArrayList<ArrayList<Object>> Result = new ArrayList<ArrayList<Object>>();
			ArrayList<HashMap<String, Object>> temp =  statisticsdao.findList_2018();
			int i;
			ArrayList<Object> result2 = new ArrayList<Object>();
			
			String a = "월";
			String b = "회의횟수";
			
			result2.add(a);
			result2.add(b);
			
			Result.add(result2);
			
			for(i=0; i<temp.size(); i++){

				result2 = new ArrayList<Object>();
				result2.add(String.valueOf(temp.get(i).get("month")));
				result2.add(temp.get(i).get("cnt"));
				Result.add(result2);
				System.out.println(Result);
			}
			return Result;
		}
public ArrayList<ArrayList<Object>> statistics3(){
	
	ArrayList<ArrayList<Object>> Result = new ArrayList<ArrayList<Object>>();
	ArrayList<HashMap<String, Object>> temp =  statisticsdao.findList_2019();
	int i;
	ArrayList<Object> result2 = new ArrayList<Object>();
	
	String a = "월";
	String b = "회의횟수";
	
	result2.add(a);
	result2.add(b);
	
	Result.add(result2);
	
	for(i=0; i<temp.size(); i++){

		result2 = new ArrayList<Object>();
		result2.add(String.valueOf(temp.get(i).get("month")));
		result2.add(temp.get(i).get("cnt"));
		Result.add(result2);
		System.out.println(Result);
	}

	return Result;
}
	}