package com.example.springboottests.tests;

import com.example.springboottests.pages.Exercise1Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise1Test extends AbstractBaseTest {
    @Autowired
    private Exercise1Page exercise1Page;

    @BeforeMethod(alwaysRun = true)
    public void navigate(){
        exercise1Page.navigateToExercise();
    }

    @Test
    public void threeButtons() {

        exercise1Page.clickBtn2();
        exercise1Page.assertTrailTextIs("b2");
        exercise1Page.clickBtn1();
        exercise1Page.assertTrailTextIs("b2b1");
        exercise1Page.clickBtn1();
        exercise1Page.assertTrailTextIs("b2b1b1");
        exercise1Page.clickSolution();
        exercise1Page.assertTrailTextIs("OK. Good answer");
    }
}
