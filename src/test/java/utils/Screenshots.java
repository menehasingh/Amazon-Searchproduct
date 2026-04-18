package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.BaseClass;

public class Screenshots extends BaseClass{
	public String Capturescreen(String name) throws IOException {
		TakesScreenshot screenshorts= (TakesScreenshot) driver; 
		File soucefile=screenshorts.getScreenshotAs(OutputType.FILE);
		String Targetpath=System.getProperty("user.dir")+"/screenshot/"+name+".png";
		File targetfile=new File(Targetpath);
		FileHandler.copy(soucefile, targetfile);  
		return Targetpath;
		
		}


}
