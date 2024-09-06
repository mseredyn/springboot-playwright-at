package com.example.springboottests.tests;

import com.example.springboottests.pages.Exercise2Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise2Test extends AbstractBaseTest {

    @Autowired
    private Exercise2Page exercise2Page;

    @BeforeMethod(alwaysRun = true)
    public void navigate(){
        exercise2Page.navigateToExercise();
    }

    @Test
    public void editBox(){
        exercise2Page.fillT14With("Seven level.");
        exercise2Page.clickBtn1();
        exercise2Page.assertTrailTextIs("t14:Seven level.b1");
        exercise2Page.clickSolution();
        exercise2Page.assertTrailTextIs("OK. Good answer");
    }

}
