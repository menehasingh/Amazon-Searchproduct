package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	public static ExtentReports extent;
	public static  ExtentReports getinstance() {
		if(extent==null) {
			String time= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format (new Date());
			String path=System.getProperty("user.dir")+"/report/"+"test report"+time+".html";
			ExtentSparkReporter report=new ExtentSparkReporter(path);
			report.config().setReportName("Amazon product serch");
			report.config().setDocumentTitle("Amzon");
			report.config().setTheme(Theme.DARK);
			extent=new  ExtentReports();
			extent.attachReporter(report);
			extent.setSystemInfo("Tester", "Neha");
			extent.setSystemInfo("Application", "Amazon");
			
		}
		
		return extent;
		
	}

}
