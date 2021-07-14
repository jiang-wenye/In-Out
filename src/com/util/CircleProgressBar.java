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

//������ϸ�еĻ��ν�����

public class CircleProgressBar extends JPanel {


	private static final long serialVersionUID = 1L;
	private int minimumProgress;
	private int maximumProgress;
	private int progress;
	private String progressText;
	private Color backgroundColor;// ����ɫ
	private Color foregroundColor;// ǰ��ɫ
	// ��ʼ��

	public CircleProgressBar() {
		minimumProgress = 0;
		maximumProgress = 100;
		progressText = "0%";
	}

	public void paint(Graphics g) {
		super.paint(g);
		// ������ Java(tm) ƽ̨�ϳ��ֶ�ά��״���ı���ͼ��Ļ����ࡣ
		Graphics2D graphics2d = (Graphics2D) g;
		// KEY_ANTIALIASING���������ʾ����VALUE_ANTIALIAS_ON���������ʾֵ����ʹ�ÿ����ģʽ��ɳ���
		// ���������
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int x = 0, y = 0, width = 0, height = 0;// ��������
		int fontSize = 0;// �����С����
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
		// ��ֵָʾ��ʱ����ת����ֵ��ָʾ˳ʱ����ת
		graphics2d.drawArc(x, y, width, height, 90,
				-(int) (360 * (progress * 1.0) / (maximumProgress - minimumProgress)));
		graphics2d.setFont(new Font("����", Font.BOLD, fontSize));
		// FontMetrics �ඨ����������󣬸ö����װ�����ض���Ļ�ϳ����ض�������й���Ϣ��
		FontMetrics fontMetrics = graphics2d.getFontMetrics();
		// ���ش� Font ��ָ�� String ���� advance width
		int digitaWidth = fontMetrics.stringWidth(progressText);
		// ȷ���� FontMetrics ������������ Font �� font ascent
		int digitaAscent = fontMetrics.getAscent();
		graphics2d.setColor(foregroundColor);
		// ���� TextAttribute ��Ĺ淶Ӧ��ָ�������������ԣ�����ָ�����������ı���
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
		this.repaint();// ���¹�����С
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
