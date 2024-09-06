package com.example.springboottests.tests;

import com.example.springboottests.SpringboottestsApplication;
import com.example.springboottests.config.PlaywrightManager;
import io.qameta.allure.testng.AllureTestNg;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

@SpringBootTest(classes = SpringboottestsApplication.class)
@Listeners({AllureTestNg.class})
public class AbstractBaseTest extends AbstractTestNGSpringContextTests {

    @BeforeMethod
    public void initializePage(){
        PlaywrightManager.initialisePlaywright();
    }

    @AfterSuite
    public void closePlaywright(){
        PlaywrightManager.closePlaywright();
    }
    @AfterMethod
    public void closePage(){
        PlaywrightManager.closePage();
    }


}
