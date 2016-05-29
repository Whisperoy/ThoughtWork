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
		System.out.println("*****<ûǮ׬�̵�>�����嵥*****");
		List<Map.Entry<String, Integer>> list = a.amount(barcodes);
		for(int i = 0 ; i < list.size(); i++) {
			String barcode = list.get(i).getKey();
			
			int num = list.get(i).getValue();
			String name = "";			
			float price = 0.0f;
			String type = "";
			String unit = "";
			//��ȡ������Ϣ
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
			System.out.print("����:" + name + ",");
			System.out.print("����:" + num + unit + ",");
			System.out.print("����:" + price + "(Ԫ)" + ",");						
			if(type.equals("�ŵ����۳���")) {
				hasPre = true;
				hm.put(name, num + unit);
				count += preTatal;
				pre = pre + tatal - preTatal;			
				System.out.print("С��:" + preTatal + "(Ԫ)");
				System.out.println("�Ż�:" + (float)Math.round((tatal - preTatal) * 100)/100 + "(Ԫ)");
			}else{
				count += tatal;
				System.out.println("С��:" + (float)Math.round(tatal *100)/100 + "(Ԫ)");
			}			
		}
		Iterator<String> it = hm.keySet().iterator();
		if(hasPre) {
			System.out.println("�����۳�����Ʒ:");
			while(it.hasNext()) {
				String str = it.next();
				System.out.print("����:" + str + ",");
				System.out.println("����" + hm.get(str));
			}
			System.out.println("�ܼ�:" + count + "(Ԫ)" + "��ʡ" + (float)Math.round(pre * 100)/100 + "(Ԫ)");
		}else {
			System.out.println("�ܼ�" + count + "(Ԫ)");
		}
	}
}
