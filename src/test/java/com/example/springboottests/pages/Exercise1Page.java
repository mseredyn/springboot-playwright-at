package com.example.springboottests.pages;

import org.springframework.stereotype.Component;

@Component
public class Exercise1Page extends BasePage {

    public void navigateToExercise(){
        this.navigateToExercise("exercise1");
    }

    public void clickBtn1(){
        this.clickBy("#btnButton1");
    }
    public void clickBtn2(){
        this.clickBy("#btnButton2");
    }
    public void clickSolution(){
        this.clickBy("#solution");
    }
    public void assertTrailTextIs(String expectedText){
        this.assertTextBy(expectedText, "#trail .wrap");
    }
}
