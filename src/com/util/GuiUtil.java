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

//GUI����


public class GuiUtil {
	// ͼƬ·��
	private static String imageFolder = "img";
	//��������Ƿ�Ϊ��
	public static boolean checkEmpty(JTextField tf, String input) {
		String text = tf.getText().trim();// ȥ���ո�
		if (text.length() == 0) {
			JOptionPane.showMessageDialog(null, input + "����Ϊ��");
			tf.grabFocus();// �������tf�����,��ȡ����
			return false;
		}
		return true;// ��Ϊ�շ���true
	}

	//��������Ƿ�Ϊ����
	public static boolean checkNumber(JTextField tf, String input) {
		if (!checkEmpty(tf, input)) {
			return false;
		}
		String text = tf.getText().trim();
		try {
			Integer.parseInt(text);// ת��Ϊ����
			return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, input + "��Ҫ������");// ��������
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
			JOptionPane.showMessageDialog(null, input + "����Ϊ��");
			tf.grabFocus();
			return false;
		}
		return true;
	}

	public static int getInt(JTextField tf) {
		return Integer.parseInt(tf.getText());
	}
	//Ϊһ�������������ǰ��ɫ
	public static void setColor(Color color, JComponent... cs) {
		for (JComponent j : cs) {
			j.setForeground(color);
		}
	}
	//����ť����ͼ�꣬��ť�ڵ����֣��Լ���ʾ����
	public static void setImageIcon(JButton b, String fileName, String tip) {
		// File(String parent, String child),���� parent ·�����ַ����� child ·�����ַ�������һ���� File ʵ��
		// ��ȡͼ����Ϣ
		ImageIcon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
		// ���ð�ťͼ��
		b.setIcon(i);
		// Dimension ���װ��������������Ŀ�Ⱥ͸߶ȣ���ȷ����������Dimension(int width, int height)
		// ����һ�� Dimension���������ʼ��Ϊָ����Ⱥ͸߶�
		// �����������ѡ��С
		b.setPreferredSize(new Dimension(61, 81));
		// �����ڿؼ�����ʾ��ʾ��Ϣ���������л��ڰ�ť����ʾtip��Ϣ
		// ������ʾ����
		b.setToolTipText(tip);
		// setVerticalTextPosition���ñ�ǩ���ı������ͼ��Ĵ�ֱλ�á� �����Ե�Ĭ��ֵΪ center��
		b.setVerticalTextPosition(JButton.BOTTOM);
		// setHorizontalTextPosition���ñ�ǩ���ı���bai����ͼ���ˮƽλ��du��
		b.setHorizontalTextPosition(JButton.CENTER);
		b.setText(tip);// ������ʾ��Ϣ
	}

	//����Ƥ��
	public static void useLNF() {
		try {
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 //��ʾ���,strechΪ�����,1Ϊ����
	public static void showPanel(JPanel p, double strech) {
		GuiUtil.useLNF();
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);// ��ʾ�����м�
		CenterPanel cp = new CenterPanel(strech);
		// ��cp�������ó�Ϊf���������
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
		p.add(new JButton("��ť1"));
		p.add(new JButton("��ť2"));
		GuiUtil.showPanel(p);
	}
}
