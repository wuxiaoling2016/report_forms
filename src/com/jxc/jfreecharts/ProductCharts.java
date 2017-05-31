package com.jxc.jfreecharts;

import java.awt.Color;
import java.awt.Font;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.TextAnchor;

import com.jxc.utils.SpringBeanFactoryUtils;
import com.jxc.model.Product;
import com.jxc.service.ProductService;

public class ProductCharts {
	
	private  ProductService productService=(ProductService) SpringBeanFactoryUtils.getBean("productService");

	public  String genBarChart(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception {
		double [][] data;
		
		List<Product> products=productService.findAll();
		data=new double[products.size()][];
		System.out.println(products.size());
		for(int j=0;j<products.size();j++){
			data[j]=new double[2];
			data[j][0]=products.get(j).getPrice();
			data[j][1]=products.get(j).getCost();
		}
		String []columnKeys={"价格","成本"};
		String []rowKeys=new String[products.size()];
		for(int j=0;j<products.size();j++){
			rowKeys[j]=products.get(j).getPname();
		}
		System.out.println(products.size());
//		double [][]data=new double[][]{{1320,1110,1123,321},{720,210,1423,1321},{830,1310,123,521},{400,1110,623,321}};
//		String []rowKeys={"苹果","香蕉","橘子","梨子"};
//		String []columnKeys={"深圳","北京","上海","南京"};
		CategoryDataset dataset=DatasetUtilities.createCategoryDataset(rowKeys,columnKeys ,data);
		JFreeChart chart=ChartFactory.createBarChart3D("手机利润统计图", "手机", "利润", dataset,
				PlotOrientation.VERTICAL, true, true, true);
		
		CategoryPlot plot=chart.getCategoryPlot();
		
		Font titleFont = new Font("黑体", Font.BOLD, 20);  
		TextTitle textTitle = chart.getTitle();  
		textTitle.setFont(titleFont);// 为标题设置上字体  
		  
		Font plotFont = new Font("宋体", Font.PLAIN, 16);  
//		
//		plot.setNoDataMessageFont(plotFont); 
//		
		Font LegendFont = new Font("楷体", Font.PLAIN, 18);  
		LegendTitle legend = chart.getLegend(0);  
		legend.setItemFont(LegendFont);// 为图例说明设置字体  
		
		CategoryAxis categoryaxis = plot.getDomainAxis();
		categoryaxis.setTickLabelFont(plotFont);
		plot.getRangeAxis().setLabelFont(plotFont);
		
		
		// 设置网格背景颜色
		plot.setBackgroundPaint(Color.white);
		// 设置网格竖线颜色
		plot.setDomainGridlinePaint(Color.pink);
		// 设置网格横线颜色
		plot.setRangeGridlinePaint(Color.pink);
		
		// 显示每个柱的数值，并修改该数值的字体属性
		BarRenderer3D renderer=new BarRenderer3D();
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		
		renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		renderer.setItemLabelAnchorOffset(10D);  
		
		// 设置平行柱的之间距离
		renderer.setItemMargin(0.4);
		
		plot.setRenderer(renderer);
		
		
		String fileName=ServletUtilities.saveChartAsPNG(chart, 700, 500, null,session);
		
//		String chartURL=request.getContextPath() + "/printProductChart1?filename="+fileName;
//		model.addAttribute("chartURL", chartURL);
		return fileName;
	}
}
