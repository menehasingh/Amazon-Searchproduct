package lisnter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ExtentManager;
import utils.Screenshots;

public class Listner implements ITestListener {
	ExtentReports extent=ExtentManager.getinstance();
	ExtentTest Test;
	public void onStart(ITestContext context) {
		System.out.println("Test Started");
		
	}
	public void onTestStart(ITestResult result) {
		Test = extent.createTest(result.getName());
		Test.info("Test execution started");

		   }
	public void onTestSuccess(ITestResult result) {
		Test.log(Status.PASS, result.getName()+" got sucessfully executed");
	}
	public void onTestFailure(ITestResult result) {
		Test.log(Status.FAIL, result.getName()+" got fail");
		Test.log(Status.INFO, result.getThrowable().getMessage());
		try {
			String imgpath=new Screenshots().Capturescreen(result.getName());
			Test.addScreenCaptureFromPath(imgpath);
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
	public void onTestSkipped(ITestResult result) {
		Test.log(Status.SKIP, result.getName()+" Test got Skipped");
		
	}
	public void onFinish(ITestContext context) {
        System.out.println("Flushing report...");
        extent.flush();
    }
	

}
