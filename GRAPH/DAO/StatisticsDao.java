package com.amorepacific.repository.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.amorepacific.repository.statistics.StatisticsDao;
import com.amorepacific.model.Management;

public interface StatisticsDao {
	public ArrayList<HashMap<String, Object>> findList();
	public ArrayList<HashMap<String, Object>> findList_2018();
	public ArrayList<HashMap<String, Object>> findList_2019();
}
