package com.example.springboottests.config.listeners;

import com.example.springboottests.config.PlaywrightManager;
import com.google.common.io.ByteSource;
import io.qameta.allure.Allure;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.StepResult;
import lombok.SneakyThrows;

public class ScreenshotAfterStepListener implements StepLifecycleListener {
    @SneakyThrows
    @Override
    public void afterStepStop(StepResult result) {
        if (PlaywrightManager.isPageInitialised()) {
            Allure.addAttachment(result.getName(), ByteSource.wrap(PlaywrightManager.getPage().screenshot()).openStream());
        }
    }
}
