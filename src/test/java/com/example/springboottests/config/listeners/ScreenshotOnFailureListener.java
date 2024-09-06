package com.example.springboottests.config.listeners;

import com.example.springboottests.config.PlaywrightManager;
import com.google.common.io.ByteSource;
import io.qameta.allure.Allure;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import lombok.SneakyThrows;

public class ScreenshotOnFailureListener implements TestLifecycleListener {

    @SneakyThrows
    @Override
    public void beforeTestStop(TestResult result){
        if(PlaywrightManager.isPageInitialised() && (result.getStatus().equals(Status.FAILED) || result.getStatus().equals(Status.BROKEN))){
            Allure.addAttachment(result.getName(), ByteSource.wrap(PlaywrightManager.getPage().screenshot()).openStream());
        }
    }
}
