package com.example.selenium.steps;

import com.example.selenium.pages.LoginPage;
import com.example.selenium.pages.MainPage;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;

public class UserSteps {
    LoginPage loginPage;
    private MainPage mainPage;
    private WebDriver driver;

    public UserSteps(WebDriver driver) {
        this.driver = driver;
    }

    public com.example.selenium.steps.UserSteps login(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        mainPage = loginPage.setUsername(username)
            .setPassword(password)
            .clickLogin();

        assertEquals(mainPage.getTitle(), "Secure Area", "Login failed");
        return this;
    }

    public UserSteps logout() {
        mainPage.clickLogout();
        return this;
    }
}