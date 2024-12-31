package uiTest.implementations;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class homePageImplement extends PageObject {


    public void clickAccount(){
        $(By.xpath("/html/body/header/div/div[2]/div[2]/ul/li[3]/a")).click();
    }

    public void selectLogin(){
        $(By.xpath("/html/body/header/div/div[2]/div[2]/ul/li[3]/ul/li[1]/a")).click();
    }

}
