package com.example.springboottests.config;

import com.microsoft.playwright.*;
import org.springframework.stereotype.Component;

import java.nio.file.Paths;

@Component
public class PlaywrightManager {

    private static ThreadLocal<Playwright> playwrightThread = new ThreadLocal<>();
    private static ThreadLocal<Browser> browserThread = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> browserContextThread = new ThreadLocal<>();
    private static ThreadLocal<Page> pageThread = new ThreadLocal<>();

    public static void initialisePlaywright() {
        if (playwrightThread.get() == null) {
            Playwright.CreateOptions createOptions = new Playwright.CreateOptions();
            playwrightThread.set(Playwright.create(createOptions));
        }
        if (browserThread.get() == null) {
            browserThread.set(playwrightThread.get().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome")));
        }
        if (browserThread.get().contexts().isEmpty()) {
            browserContextThread.set(browserThread.get().newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/"))));
        }
        if (pageThread.get() == null) {
            pageThread.set(browserContextThread.get().newPage());
        }
    }

    public static Page getPage() {
        initialisePlaywright();
        return pageThread.get();
    }

    public static void closePlaywright() {
        closePage();
        BrowserContext browserContext = browserContextThread.get();
        if (browserContext != null) {
            browserContext.close();
        }
        browserContextThread.remove();

        Browser browser = browserThread.get();
        if (browser != null) {
            browser.close();
        }
        browserThread.remove();

        Playwright playwright = playwrightThread.get();
        if (playwright != null) {
            playwright.close();
        }
        playwrightThread.remove();
    }

    public static void closePage() {
        Page page = pageThread.get();
        if (page != null) {
            page.close();
        }
        pageThread.remove();
    }

    public static boolean isPageInitialised() {

        return pageThread.get() != null;
    }
}
