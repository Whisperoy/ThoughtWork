package com.ThoughtWork.Demo;

import java.util.ArrayList;

import com.ThoughtWork.Goods.Goods;
import com.ThoughtWork.PrintList.PrintList;

public class Demo {
	public static void main(String[] args) {
		Goods g1 = new Goods();
		Goods g2 = new Goods();
		Goods g3 = new Goods();
		g1.setBarcode("ITEM000001");
		g1.setName("可口可乐");
		g1.setPrice(3.00f);
		g1.setUnit("瓶");
		g1.setType("批发价出售");
		g2.setBarcode("ITEM000002");
		g2.setName("雪碧");
		g2.setPrice(2.50f);
		g2.setUnit("瓶");
		g2.setType("批发价出售");
		g3.setBarcode("ITEM000003");
		g3.setName("羽毛球");
		g3.setPrice(1.00f);
		g3.setUnit("个");
		g3.setType("");
		ArrayList<Goods> arr = new ArrayList<>();
		
		PrintList pl = new PrintList();
		arr.add(g1); 
		arr.add(g2);
		arr.add(g3);
		
		String[] barcodes = {"ITEM000003-9", "ITEM000001-4","ITEM000001-4","ITEM000002-7","ITEM000002","ITEM000001"
				,"ITEM000003","ITEM000002","ITEM000001","ITEM000003-2","ITEM000002-8","ITEM000003"};
		pl.printList(arr, barcodes);
		System.out.println();
	}
}
