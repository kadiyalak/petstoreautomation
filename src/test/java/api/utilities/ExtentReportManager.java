package api.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.ITestListener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//import testBase.BaseClass;

public class ExtentReportManager implements ITestListener{
	public ExtentSparkReporter sparkReporter;//UI of the report
	public ExtentReports extent;//populate common info on the report

String repName;
	public  ExtentTest test;//creating test case entries in the report and update status of the test methods
	public void onStart(ITestContext testcontext) {
		
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		repName="Test-Report-" + timestamp + ".html";
		
		sparkReporter =new ExtentSparkReporter("./reports/" + repName);//specific location
	sparkReporter .config().setDocumentTitle("PetStoreAutomation");//title of report
	sparkReporter.config().setReportName("Pet Store UsersAPI");//name of the report
	sparkReporter.config().setTheme(Theme.DARK);
	extent =new ExtentReports();

	extent.attachReporter(sparkReporter);
	extent.setSystemInfo("Application","pet store users API" );
	extent.setSystemInfo("module","Admin");
	extent.setSystemInfo("submodule", System.getProperty("user.name"));extent.setSystemInfo("environment", "QA");
	extent.setSystemInfo("operatingsystem", System.getProperty("os.name"));
	extent.flush();
	}
	public void onTestSuccess(ITestResult result) {
		
		test=extent.createTest(result.getName());//create a new entry in the report
		test.assignCategory(result.getMethod().getGroups());test.createNode(result.getName());
		test.log(Status.PASS, "test case passed is:"+result.getName());extent.flush();
	}
	public void onTestFailure(ITestResult result) {
		

	test=extent.createTest(result.getName());test.createNode(result.getName());
	test.assignCategory(result.getMethod().getGroups());
	test.log(Status.FAIL, "test case failed is:"+result.getName());
		test.log(Status.FAIL, "test case failed is:"+result.getThrowable().getMessage());
		
		
		extent.flush();
		
	}
	public void onTestSkipped(ITestResult result) {
		
	test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "test case skipped is:"+result.getName());
		test.log(Status.SKIP,"result.getThrowable().getMessage()");
		
	}
	public void onTestFinish(ITestContext context) {
		
		
		extent. flush();
}
}