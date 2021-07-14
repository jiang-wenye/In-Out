package com.util;

import java.awt.Color;

//通过RBG变化更改颜色

public class ColorUtil {
	//RGB色彩模式
	public static Color blueColor = Color.decode("#3399FF");//蓝色 RGB(51,153,255)
	public static Color grayColor = Color.decode("#999999");//灰色 RGB(153,153,153)
	public static Color backgroundColor = Color.decode("#eeeeee");//背景色 RGB(238,238,238)	
	public static Color warningColor = Color.decode("#FF3333");//警告颜色cRGB(255,51,51)
	
	public static Color getByPercentage(int per){
		if(per>100)
			per=100;
		int R=51;
		int G=255;
		int B=51;
		float rate = per/100f;//圆环的百分比
		G=(int)((255-51)*rate-51);//颜色变换
		G=255-R+51;
		Color color = new Color(R,G,B);
		return color;
	}
}

