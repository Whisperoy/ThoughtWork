package com.ThoughtWork.Amount;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Amount {
	public List<Map.Entry<String, Integer>> amount(String[] barcodes) {
		//Map中存放(条形码, 数量)键值对
		HashMap<String, Integer> hm = new HashMap<>();
		
		for(int i = 0; i < barcodes.length; i++) {
			//tmp表示条形码中是否存在"-"
			boolean tmp = false;
			
			for(int j = 0; j < barcodes[i].length(); j++) {	
				//如果条形码中有"-"
				if(barcodes[i].substring(j, j + 1).equals("-")) {
					int num = Integer.parseInt(barcodes[i].substring(j + 1));
					//判断key在Map中存不存在
					if(!hm.containsKey(barcodes[i].substring(0, j))) {
						hm.put(barcodes[i].substring(0, j), num);
					}else{
						int count = hm.get(barcodes[i].substring(0, j));
						hm.put(barcodes[i].substring(0, j), count + num);
					}
					tmp = true;
					break;
				}
			}
			//如果条形码中没有"-"
			if(!tmp){
				if(!hm.containsKey(barcodes[i])) {
					hm.put(barcodes[i], 1);
				}else{
					int count = hm.get(barcodes[i]);
					hm.put(barcodes[i], count + 1);
				}
			}
		}	
		//对Map根据条形码号排序
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(hm.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
				return (m1.getKey()).toString().compareTo(m2.getKey());
			}
		});
		
		return list;
	}
}
