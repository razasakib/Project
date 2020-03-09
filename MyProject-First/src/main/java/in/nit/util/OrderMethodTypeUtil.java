package in.nit.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class OrderMethodTypeUtil {
	
	public void generatePie(String path,List<Object[]> data) {
		//1.create data set
		
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] arr:data) {
			//key-shipment mode, val-count
			dataset.setValue(arr[0].toString(),Double.valueOf(arr[1].toString()));
		}
		//crete jfree chart
		
		JFreeChart chart=ChartFactory.createPieChart3D("OrderMethodType", dataset, true, true, false);
		
		//save as image
		
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/OrderMethodA.jpg"), chart, 400, 400);
			
		} catch (IOException e) {
				System.out.println(e.getMessage());
				
		}
		
		
	}

	public void generateBarChart(String path,List<Object[]> data) {
		//create dataset
		
		
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		
		for(Object[] arr:data) {
			//val-index-1(y-axis) key=index 0(x-axis)
			dataset.setValue(Double.valueOf(arr[1].toString()), arr[0].toString(), "");
		}
		
		//create j free chart
		
		JFreeChart chart=ChartFactory.createBarChart("OrderMethodType", "Modes", "Count", dataset);
		
		//save image
		
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/OrderMethodB.jpg"), chart, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
