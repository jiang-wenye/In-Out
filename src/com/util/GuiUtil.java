package com.util;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//GUI工具


public class GuiUtil {
	// 图片路径
	private static String imageFolder = "img";
	//检查输入是否为空
	public static boolean checkEmpty(JTextField tf, String input) {
		String text = tf.getText().trim();// 去除空格
		if (text.length() == 0) {
			JOptionPane.showMessageDialog(null, input + "不能为空");
			tf.grabFocus();// 让鼠标在tf组件上,获取焦点
			return false;
		}
		return true;// 不为空返回true
	}

	//检查输入是否为整数
	public static boolean checkNumber(JTextField tf, String input) {
		if (!checkEmpty(tf, input)) {
			return false;
		}
		String text = tf.getText().trim();
		try {
			Integer.parseInt(text);// 转化为数字
			return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, input + "需要是整数");// 弹出窗口
			tf.grabFocus();
			return false;
		}
	}

	public static boolean checkZero(JTextField tf, String input) {
		if (!checkEmpty(tf, input)) {
			return false;
		}
		String text = tf.getText().trim();
		if (Integer.parseInt(text) == 0) {
			JOptionPane.showMessageDialog(null, input + "不能为零");
			tf.grabFocus();
			return false;
		}
		return true;
	}

	public static int getInt(JTextField tf) {
		return Integer.parseInt(tf.getText());
	}
	//为一个或多个组件设置前景色
	public static void setColor(Color color, JComponent... cs) {
		for (JComponent j : cs) {
			j.setForeground(color);
		}
	}
	//给按钮设置图标，按钮内的文字，以及提示文字
	public static void setImageIcon(JButton b, String fileName, String tip) {
		// File(String parent, String child),根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例
		// 获取图标信息
		ImageIcon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
		// 设置按钮图标
		b.setIcon(i);
		// Dimension 类封装单个对象中组件的宽度和高度（精确到整数），Dimension(int width, int height)
		// 构造一个 Dimension，并将其初始化为指定宽度和高度
		// 设置组件的首选大小
		b.setPreferredSize(new Dimension(61, 81));
		// 用于在控件上显示提示信息，本方法中会在按钮上显示tip信息
		// 设置提示文字
		b.setToolTipText(tip);
		// setVerticalTextPosition设置标签的文本相对其图像的垂直位置。 此属性的默认值为 center。
		b.setVerticalTextPosition(JButton.BOTTOM);
		// setHorizontalTextPosition设置标签的文本相bai对其图像的水平位置du。
		b.setHorizontalTextPosition(JButton.CENTER);
		b.setText(tip);// 设置提示信息
	}

	//设置皮肤
	public static void useLNF() {
		try {
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 //显示面板,strech为拉伸比,1为满屏
	public static void showPanel(JPanel p, double strech) {
		GuiUtil.useLNF();
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);// 显示在最中间
		CenterPanel cp = new CenterPanel(strech);
		// 把cp对象设置成为f的内容面板
		f.setContentPane(cp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		cp.show(p);
	}

	public static void showPanel(JPanel p) {
		showPanel(p, 0.85);
	}

	public static void main(String[] args) {
		GuiUtil.useLNF();
		JPanel p = new JPanel();
		p.add(new JButton("按钮1"));
		p.add(new JButton("按钮2"));
		GuiUtil.showPanel(p);
	}
}
