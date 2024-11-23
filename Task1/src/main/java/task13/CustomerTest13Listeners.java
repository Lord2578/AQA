package task13;

import org.apache.logging.log4j.LogManager;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.Logger;


public class CustomerTest13Listeners implements ITestListener {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());


    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("info message");
    }

}
