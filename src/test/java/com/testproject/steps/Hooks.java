package com.testproject.steps;


import com.testproject.base.BasePage;
import com.testproject.utilities.DBUtils;
import com.testproject.utils.Driver;
import com.testproject.utils.Environment;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    private static final Logger LOG = LoggerFactory.getLogger(BasePage.class.getName());

    @Before
    public void setUp(Scenario scenario) {
        LOG.info("Setting up browser");
        Driver.get().get(Environment.URL);
        LOG.info("Executing scenario: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Scenario fail");
            } catch (Exception e) {
                e.printStackTrace();
                LOG.info("Failed scenario: " + scenario.getName());
            } finally {
                LOG.info("Closing browser");
                Driver.closeDriver();
            }
        }
    }

    @Before("@db")
    public void dbSetUp() {
        try {
            DBUtils.createConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOG.info("Failed to create db connection");
    }

    @After("@db")
    public void dbTearDown() {
        try {
            DBUtils.destroyConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOG.info("Failed to destroy db connection");
    }
}
