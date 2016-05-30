package com.ThoughtWork.Preferential;

public class Preferential {
	public float preferential(int num, float price,String type) {
		//返回打折后的商品价格,并四舍五入保留两位小数
		if(type.equals("批发价出售")) {
			return (float)Math.round(num * price * 0.95 * 100)/100;
		}else{		
			return num * price;
		}
	}
}
