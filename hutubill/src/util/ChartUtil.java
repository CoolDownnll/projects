package util;
 
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.List;

import com.objectplanet.chart.BarChart;
import com.objectplanet.chart.Chart;

import entity.Record;
 
/**
 * 柱状图工具类(借助第三方jar包)
 * @author OCEAN
 *
 */
public class ChartUtil {
	
    /**
     * 生成真实样本数据
     * @return
     */
    public static double[] sampleValues(List<Record> rs) {
        double[] sampleValues = new double[rs.size()];
        
        for (int i = 0; i < sampleValues.length; i++) {
            sampleValues[i] = rs.get(i).spend;
        }
 
        return sampleValues;
    }
	
    
    /**
     * 生成下方显示的文字
     * @return
     */
    private static String[] sampleLabels(List<Record> rs) {
        String[] sampleLabels = new String[rs.size()];
        
        for (int i = 0; i < sampleLabels.length; i++) {
            if (0 == i % 5)
                sampleLabels[i] = String.valueOf(i + 1 + "日");
        }
 
        return sampleLabels;
    }
    
    
    /**
     * 获取样本中的最大值
     * @param sampleValues
     * @return
     */
    public static int max(double[] sampleValues) {
        int max = 0;
        for (double v : sampleValues) {
            if (v > max)
                max = (int) v;
        }
        return max;
 
    }
    
    
    public static Image getImage(List<Record> rs, int width, int height) {
        // 根据消费记录得到的样本数据
        double[] sampleValues = sampleValues(rs);
        // 根据消费记录得到的下方日期文本
        String[] sampleLabels = sampleLabels(rs);
        // 样本中的最大值
        int max = max(sampleValues);
 
        // 数据颜色
        Color[] sampleColors = new Color[] { ColorUtil.blueColor };
 
        // 柱状图
        BarChart chart = new BarChart();
 
        // 设置样本个数
        chart.setSampleCount(sampleValues.length);
        // 设置样本数据
        chart.setSampleValues(0, sampleValues);
        // 设置文字
        chart.setSampleLabels(sampleLabels);
        // 设置样本颜色
        chart.setSampleColors(sampleColors);
        // 设置取值范围
        chart.setRange(0, max * 1.2);
        // 显示背景横线
        chart.setValueLinesOn(true);
        // 显示文字
        chart.setSampleLabelsOn(true);
        // 把文字显示在下方
        chart.setSampleLabelStyle(Chart.BELOW);
 
        // 样本值的字体
        chart.setFont("rangeLabelFont", new Font("Arial", Font.BOLD, 12));
        // 显示图例说明
        chart.setLegendOn(true);
        // 把图例说明放在左侧
        chart.setLegendPosition(Chart.LEFT);
        // 图例说明中的文字
        chart.setLegendLabels(new String[] { "月消费报表" });
        // 图例说明的字体
        chart.setFont("legendFont", new Font("Dialog", Font.BOLD, 13));
        // 下方文字的字体
        chart.setFont("sampleLabelFont", new Font("Dialog", Font.BOLD, 13));
        // 图表中间背景颜色
        chart.setChartBackground(Color.white);
        // 图表整体背景颜色
        chart.setBackground(ColorUtil.backgroundColor);
        // 把图表转换为Image类型
        Image im = chart.getImage(width, height);
        return im;
    }
    
    
    /**
     * 生成模拟样本数据
     * @return
     */
/*    private static double[] sampleValues() {
        double[] result = new double[30];
        
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) (Math.random() * 300);
        }
        
        return result;
    }*/
    
    
    /**
     * 生成下方显示的文字
     * @return
     */
/*    private static String[] sampleLabels() {
        String[] sampleLabels = new String[30];
 
        for (int i = 0; i < sampleLabels.length; i++) {
            if (0 == i % 5)
                sampleLabels[i] = String.valueOf(i + 1 + "日");
        }
        return sampleLabels;
    }*/
    
    
    /**
     * 生成一个模拟数据的柱状图表
     * @param width
     * @param height
     * @return
     */
/*    public static Image getImage(int width, int height) {
        double[] sampleValues = sampleValues();
        String[] sampleLabels = sampleLabels();
        int max = max(sampleValues);
        Color[] sampleColors = new Color[] { ColorUtil.blueColor };    // 数据颜色
        
        
        BarChart chart = new BarChart();    // 柱状图
 
        chart.setSampleCount(sampleValues.length);// 设置样本个数
        
        chart.setSampleValues(0, sampleValues);// 设置样本数据
        
        chart.setSampleLabels(sampleLabels);// 设置文字
        
        chart.setSampleColors(sampleColors);// 设置样本颜色
        
        chart.setRange(0, max * 1.2);// 设置取值范围
        
        chart.setValueLinesOn(true);// 显示背景横线
        
        chart.setSampleLabelsOn(true);// 显示文字
        
        chart.setSampleLabelStyle(Chart.BELOW);// 把文字显示在下方
        
        chart.setFont("rangeLabelFont", new Font("Arial", Font.BOLD, 12));// 样本值的字体
        
        chart.setLegendOn(true);// 显示图例说明
        
        chart.setLegendPosition(Chart.LEFT);// 把图例说明放在左侧
        
        chart.setLegendLabels(new String[] { "月消费报表" });// 图例说明中的文字
        
        chart.setFont("legendFont", new Font("Dialog", Font.BOLD, 13));// 图例说明的字体
        
        chart.setFont("sampleLabelFont", new Font("Dialog", Font.BOLD, 13));// 下方文字的字体
        
        chart.setChartBackground(Color.white);// 图表中间背景颜色
        
        chart.setBackground(ColorUtil.backgroundColor);// 图表整体背景颜色
        
        Image im = chart.getImage(width, height);// 把图表转换为Image类型
        return im;
    }*/
 
}