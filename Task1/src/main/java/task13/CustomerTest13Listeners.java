package task13;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CustomerTest13Listeners implements ITestListener, ISuiteListener, IExecutionListener, IInvokedMethodListener {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("Test Passed: " + result.getName());
        // Add test result record to DB here
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.error("Test Failed: " + result.getName());
        takeScreenshot(result.getName());
        saveHtmlToFile(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOGGER.warn("Test Skipped: " + result.getName() + " Reason: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        LOGGER.info("Test Suite Finished");
    }

    @Override
    public void onStart(ISuite suite) {
        LOGGER.info("Test Suite Started: " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        LOGGER.info("Test Suite Finished: " + suite.getName());
    }

    @Override
    public void onExecutionStart() {
        LOGGER.info("Execution Started");
    }

    @Override
    public void onExecutionFinish() {
        LOGGER.info("Execution Finished");
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        LOGGER.info("Before Method Invocation: " + method.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        LOGGER.info("After Method Invocation: " + method.getTestMethod().getMethodName());
    }

    private void takeScreenshot(String testName) {
        LOGGER.info("Taking screenshot for test: " + testName);
    }

    private void saveHtmlToFile(ITestResult result) {
        String testName = result.getName();
        String htmlContent = "<html><body>" + result.getThrowable() + "</body></html>";
        String fileName = "test_results/" + testName + "_" + System.currentTimeMillis() + ".html";

        try {
            Files.createDirectories(Paths.get("test_results"));
            Files.write(Paths.get(fileName), htmlContent.getBytes());
            LOGGER.info("Saved HTML to file: " + fileName);
        } catch (IOException e) {
            LOGGER.error("Failed to save HTML to file", e);
        }
    }
}
