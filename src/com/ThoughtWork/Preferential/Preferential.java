package com.ThoughtWork.Preferential;

public class Preferential {
	public float preferential(int num, float price,String type) {
		//���ش��ۺ����Ʒ�۸�,���������뱣����λС��
		if(type.equals("�����۳���")) {
			return (float)Math.round(num * price * 0.95 * 100)/100;
		}else{		
			return num * price;
		}
	}
}
