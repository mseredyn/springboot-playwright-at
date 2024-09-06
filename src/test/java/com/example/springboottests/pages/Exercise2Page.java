package com.example.springboottests.pages;

import org.springframework.stereotype.Component;

@Component
public class Exercise2Page extends BasePage {

    public void navigateToExercise(){
        this.navigateToExercise("exercise2");
    }

    public void fillT14With(String value) {
        this.fillWithBy(value, "#t14");
    }

    public void clickBtn1() {
        this.clickBy("#btnButton1");
    }

    public void clickSolution() {
        this.clickBy("#solution");
    }

    public void assertTrailTextIs(String expectedText) {
        this.assertTextBy(expectedText, "#trail .wrap");
    }
}
