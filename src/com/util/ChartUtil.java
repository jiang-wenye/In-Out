package com.util;

import java.awt.*;
import javax.swing.*;

import java.util.List;

import com.objectplanet.chart.BarChart;
import com.objectplanet.chart.Chart;

import com.entity.Record;

import com.service.ReportService;

//�����ѱ�����״ͼ
public class ChartUtil {
	// ��ʾ��״ͼ����Ķ��ٺ�
	private static String[] sampleLabels(List<Record> rs) {
		String[] sampleLables = new String[rs.size()];
		for (int i = 0; i < sampleLables.length; i++) {
			if (0 == i % 5) {
				sampleLables[i] = String.valueOf(i + 1 + "��");// ÿ��5����ʾ����
			}
		}
		return sampleLables;
	}

	// ��ʾ��������
	private static double[] sampleValues(List<Record> rs) {
		double[] result = new double[rs.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = rs.get(i).spend;
		}
		return result;
	}

	// �����е����ֵ
	public static int max(double[] sampleValues) {
		int max = 0;
		for (double v : sampleValues) {
			if (v > max)
				max = (int) v;
		}
		return max;
	}
	
	public static Image getImage(List<Record> rs, int width, int height) {
		// �������Ѽ�¼�ĵ�����������
		double[] sampleValues = sampleValues(rs);
		// �����������ڵõ�ͼ�����������
		String[] sampleLabels = sampleLabels(rs);
		// �����е����ֵ
		int max = max(sampleValues);
		// ������ɫ
		Color[] sampleColors = new Color[] { ColorUtil.blueColor };
		// ��״ͼ
		BarChart chart = new BarChart();
		// ������������
		chart.setSampleCount(sampleValues.length);
		// ������������
		chart.setSampleValues(0, sampleValues);
		// ������������
		chart.setSampleLabels(sampleLabels);
		// ����������ɫ
		chart.setSampleColors(sampleColors);
		// ����ȡֵ��Χ(��״ͼ�����޷�Χ)
		chart.setRange(0, max * 1.2);
		// ��ʾ��������
		chart.setValueLinesOn(true);
		// ��ʾ����
		chart.setSampleLabelsOn(true);
		// ��������ʾ���·�
		chart.setSampleLabelStyle(Chart.BELOW);
		// ����ֵ������
		chart.setFont("rangeLabelFont", new Font("Arial", Font.BOLD, 12));
		// ��ʾͼ��˵��
		chart.setLegendOn(true);
		// ����ͼ���
		chart.setLegendPosition(Chart.LEFT);
		// ͼ��˵���е�����
		chart.setLegendLabels(new String[] { "�����ѱ���" });
		// ͼ��˵���е�����
		chart.setFont("legendFont", new Font("Dialog", Font.BOLD, 13));
		// �·����ֵ�����
		chart.setFont("sampleLabelFont", new Font("Dialog", Font.BOLD, 13));
		// ͼ���м䱳��
		chart.setChartBackground(Color.white);
		// ͼ�����屳��
		chart.setBackground(ColorUtil.backgroundColor);
		// ��ͼ��ת��ΪImage����
		Image im = chart.getImage(width, height);
		return im;
		
	}}