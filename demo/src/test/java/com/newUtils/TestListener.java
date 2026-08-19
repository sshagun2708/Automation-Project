package com.newUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utils.ExtentReportManager;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.Desktop;
import java.io.File;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentReportManager.getReportInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        // Create a new test entry in the report when a @Test method starts
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log pass status
        test.get().log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log fail status and attach the exception stack trace
        test.get().log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
        test.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Log skip status
        test.get().log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        // 1. Flush writes all collected test steps into the ExtentReport.html file
        if (extent != null) {
            extent.flush();
        }

        // 2. Locate the report file inside the demo/test-output directory
        String reportPath = System.getProperty("user.dir") 
                            + File.separator + "demo" 
                            + File.separator + "test-output" 
                            + File.separator + "ExtentReport.html";
        File reportFile = new File(reportPath);

        System.out.println("Checking report output path: " + reportFile.getAbsolutePath());

        // 3. Automatically launch the generated HTML report in your default browser
        if (reportFile.exists()) {
            try {
                Desktop.getDesktop().browse(reportFile.toURI());
                System.out.println("Report successfully opened in browser!");
            } catch (Exception e) {
                System.err.println("Failed to automatically open report: " + e.getMessage());
            }
        } else {
            System.err.println("Report file was not found at expected path: " + reportPath);
        }
    }
}