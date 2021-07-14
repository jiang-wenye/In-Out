package com.util;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

//消费明细中的环形进度条

public class CircleProgressBar extends JPanel {


	private static final long serialVersionUID = 1L;
	private int minimumProgress;
	private int maximumProgress;
	private int progress;
	private String progressText;
	private Color backgroundColor;// 背景色
	private Color foregroundColor;// 前景色
	// 初始化

	public CircleProgressBar() {
		minimumProgress = 0;
		maximumProgress = 100;
		progressText = "0%";
	}

	public void paint(Graphics g) {
		super.paint(g);
		// 用于在 Java(tm) 平台上呈现二维形状、文本和图像的基础类。
		Graphics2D graphics2d = (Graphics2D) g;
		// KEY_ANTIALIASING：抗锯齿提示键，VALUE_ANTIALIAS_ON：抗锯齿提示值——使用抗锯齿模式完成呈现
		// 抗锯齿设置
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int x = 0, y = 0, width = 0, height = 0;// 坐标设置
		int fontSize = 0;// 字体大小设置
		if (getWidth() > getHeight()) {
			x = (getWidth() - getHeight()) / 2 + 25;
			y = 25;
			width = getHeight() - 50;
			height = getHeight() - 50;
			fontSize = getWidth() / 8;
		} else {
			x = 25;
			y = (getHeight() - getWidth()) / 2 + 25;
			width = getWidth() - 50;
			height = getWidth() - 50;
			fontSize = getHeight() / 8;
		}

		graphics2d.setStroke(new BasicStroke(20.0f));
		graphics2d.setColor(backgroundColor);
		graphics2d.drawArc(x, y, width, height, 0, 360);
		graphics2d.setColor(foregroundColor);
		// 正值指示逆时针旋转，负值则指示顺时针旋转
		graphics2d.drawArc(x, y, width, height, 90,
				-(int) (360 * (progress * 1.0) / (maximumProgress - minimumProgress)));
		graphics2d.setFont(new Font("黑体", Font.BOLD, fontSize));
		// FontMetrics 类定义字体规格对象，该对象封装将在特定屏幕上呈现特定字体的有关信息。
		FontMetrics fontMetrics = graphics2d.getFontMetrics();
		// 返回此 Font 中指定 String 的总 advance width
		int digitaWidth = fontMetrics.stringWidth(progressText);
		// 确定此 FontMetrics 对象所描述的 Font 的 font ascent
		int digitaAscent = fontMetrics.getAscent();
		graphics2d.setColor(foregroundColor);
		// 依照 TextAttribute 类的规范应用指定迭代器的属性，呈现指定迭代器的文本。
		graphics2d.drawString(progressText, getWidth() / 2 - digitaWidth / 2, getHeight() / 2 + digitaAscent / 2);
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		if (progress >= minimumProgress && progress <= maximumProgress) {
			this.progress = progress;
		}
		if (progress > maximumProgress) {
			this.progress = maximumProgress;
		}
		this.progressText = String.valueOf(progress + "%");
		this.repaint();// 更新构件大小
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
		this.repaint();
	}

	public Color getForegroundColor() {
		return foregroundColor;
	}

	public void setForegroundColor(Color foregroundColor) {
		this.foregroundColor = foregroundColor;
		this.repaint();

	}
}
