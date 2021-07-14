package com.util;

import java.awt.*;
import javax.swing.*;

import java.util.List;

import com.objectplanet.chart.BarChart;
import com.objectplanet.chart.Chart;

import com.entity.Record;

import com.service.ReportService;

//月消费报表柱状图
public class ChartUtil {
	// 显示柱状图下面的多少号
	private static String[] sampleLabels(List<Record> rs) {
		String[] sampleLables = new String[rs.size()];
		for (int i = 0; i < sampleLables.length; i++) {
			if (0 == i % 5) {
				sampleLables[i] = String.valueOf(i + 1 + "日");// 每隔5天显示日期
			}
		}
		return sampleLables;
	}

	// 显示消费数据
	private static double[] sampleValues(List<Record> rs) {
		double[] result = new double[rs.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = rs.get(i).spend;
		}
		return result;
	}

	// 样本中的最大值
	public static int max(double[] sampleValues) {
		int max = 0;
		for (double v : sampleValues) {
			if (v > max)
				max = (int) v;
		}
		return max;
	}
	
	public static Image getImage(List<Record> rs, int width, int height) {
		// 根据消费记录的到消费样本数
		double[] sampleValues = sampleValues(rs);
		// 根据消费日期得到图表下面的日期
		String[] sampleLabels = sampleLabels(rs);
		// 样本中的最大值
		int max = max(sampleValues);
		// 数据颜色
		Color[] sampleColors = new Color[] { ColorUtil.blueColor };
		// 柱状图
		BarChart chart = new BarChart();
		// 设置样本数量
		chart.setSampleCount(sampleValues.length);
		// 设置样本数据
		chart.setSampleValues(0, sampleValues);
		// 设置样本文字
		chart.setSampleLabels(sampleLabels);
		// 设置样本颜色
		chart.setSampleColors(sampleColors);
		// 设置取值范围(柱状图的上限范围)
		chart.setRange(0, max * 1.2);
		// 显示背景横线
		chart.setValueLinesOn(true);
		// 显示文字
		chart.setSampleLabelsOn(true);
		// 把文字显示在下方
		chart.setSampleLabelStyle(Chart.BELOW);
		// 样本值的文字
		chart.setFont("rangeLabelFont", new Font("Arial", Font.BOLD, 12));
		// 显示图例说明
		chart.setLegendOn(true);
		// 放在图左边
		chart.setLegendPosition(Chart.LEFT);
		// 图例说明中的文字
		chart.setLegendLabels(new String[] { "月消费报表" });
		// 图例说明中的字体
		chart.setFont("legendFont", new Font("Dialog", Font.BOLD, 13));
		// 下方文字的字体
		chart.setFont("sampleLabelFont", new Font("Dialog", Font.BOLD, 13));
		// 图表中间背景
		chart.setChartBackground(Color.white);
		// 图标整体背景
		chart.setBackground(ColorUtil.backgroundColor);
		// 把图表转化为Image类型
		Image im = chart.getImage(width, height);
		return im;
		
	}}