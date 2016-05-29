package com.ThoughtWork.PrintList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ThoughtWork.Amount.Amount;
import com.ThoughtWork.Goods.Goods;
import com.ThoughtWork.Preferential.Preferential;

public class PrintList {
	public void printList(ArrayList<Goods> arr,String[] barcodes) {
		Amount a = new Amount();
		Preferential p = new Preferential();
		HashMap<String, String> hm = new HashMap<>();
		boolean hasPre = false;
		float count = 0f;
		float pre = 0f;
		System.out.println("*****<没钱赚商店>购物清单*****");
		List<Map.Entry<String, Integer>> list = a.amount(barcodes);
		for(int i = 0 ; i < list.size(); i++) {
			String barcode = list.get(i).getKey();
			
			int num = list.get(i).getValue();
			String name = "";			
			float price = 0.0f;
			String type = "";
			String unit = "";
			//获取对象信息
			for(int j = 0; j < arr.size(); j++) {				
				if(arr.get(j).getBarcode().equals(barcode)) {
					
					Goods g = arr.get(j);
					name = g.getName();
					price = g.getPrice();
					type = g.getType();
					unit = g.getUnit();
					break;
				}			
			}			
			float tatal = num * price;
			tatal = (float)Math.round(tatal * 100)/100;
			float preTatal = p.preferential(num, price, type);
			System.out.print("名称:" + name + ",");
			System.out.print("数量:" + num + unit + ",");
			System.out.print("单价:" + price + "(元)" + ",");						
			if(type.equals("九点五折出售")) {
				hasPre = true;
				hm.put(name, num + unit);
				count += preTatal;
				pre = pre + tatal - preTatal;			
				System.out.print("小计:" + preTatal + "(元)");
				System.out.println("优惠:" + (float)Math.round((tatal - preTatal) * 100)/100 + "(元)");
			}else{
				count += tatal;
				System.out.println("小计:" + (float)Math.round(tatal *100)/100 + "(元)");
			}			
		}
		Iterator<String> it = hm.keySet().iterator();
		if(hasPre) {
			System.out.println("批发价出售商品:");
			while(it.hasNext()) {
				String str = it.next();
				System.out.print("名称:" + str + ",");
				System.out.println("数量" + hm.get(str));
			}
			System.out.println("总计:" + count + "(元)" + "节省" + (float)Math.round(pre * 100)/100 + "(元)");
		}else {
			System.out.println("总计" + count + "(元)");
		}
	}
}
