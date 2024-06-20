package playwrightFactory.Pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;

    private String emailId = "//input[@id='input-email']";
    private String emailPwd = "//input[@id='input-password']";
    private String loginBtn = "//input[@value='Login']";
    private String forgotPassword = "//*[@id='content']/div/div[2]/div/form/div[2]/a";
    public LoginPage(Page page){
        this.page=page;
    }


    public void doLogin(String userName, String Password) {
          page.fill(emailId,userName);
          page.fill(emailPwd,Password);
          page.click(loginBtn);
    }
    public boolean isForgotPasswordLinkVisible() {
        return page.isVisible(forgotPassword);
    }
}