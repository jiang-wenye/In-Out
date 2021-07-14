package com.util;

import java.awt.Color;

//ͨ��RBG�仯������ɫ

public class ColorUtil {
	//RGBɫ��ģʽ
	public static Color blueColor = Color.decode("#3399FF");//��ɫ RGB(51,153,255)
	public static Color grayColor = Color.decode("#999999");//��ɫ RGB(153,153,153)
	public static Color backgroundColor = Color.decode("#eeeeee");//����ɫ RGB(238,238,238)	
	public static Color warningColor = Color.decode("#FF3333");//������ɫcRGB(255,51,51)
	
	public static Color getByPercentage(int per){
		if(per>100)
			per=100;
		int R=51;
		int G=255;
		int B=51;
		float rate = per/100f;//Բ���İٷֱ�
		G=(int)((255-51)*rate-51);//��ɫ�任
		G=255-R+51;
		Color color = new Color(R,G,B);
		return color;
	}
}

