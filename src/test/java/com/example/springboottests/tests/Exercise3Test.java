package com.example.springboottests.tests;

import com.example.springboottests.pages.Exercise3Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise3Test extends AbstractBaseTest {

    @Autowired
    private Exercise3Page exercise3Page;

    @BeforeMethod(alwaysRun = true)
    public void navigate() {
        exercise3Page.navigateToExercise();
    }

    @Test
    public void editBox() {
        exercise3Page.selectOptionInS13("Pink Kong");
        exercise3Page.assertTrailTextIs("s13:v5");
        exercise3Page.clickSolution();
        exercise3Page.assertTrailTextIs("OK. Good answer");
    }
}
