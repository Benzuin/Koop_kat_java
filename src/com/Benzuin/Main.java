package com.Benzuin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


public class Main {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
//        navigate to webpage
        driver.get("http://specialisatieopleiding.northeurope.cloudapp.azure.com/");
//        select category
        driver.findElement(By.xpath("//*[text()='Cats']")).click();
//        navigate to sub-category
        driver.findElement(By.xpath("//*[text()='Short Haired Cats (18)']")).click();
//        select designated animal
        driver.findElement(By.xpath("//*[text()='Abyssinian Cat']")).click();
//        select add to cart
        driver.findElement(By.id("button-cart")).click();
//        verify it is added to cart by displaying success message
        try {
            WebElement firstResult = new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.elementToBeClickable(By.className("alert-success")));
            System.out.println("success");
        }
        catch (Exception e){
            System.out.println("not in cart");
        }
//        Open mini cart
        driver.findElement(By.id("cart")).click();
//        navigate to checkout
        driver.findElement(By.xpath("//a[contains(@href,'checkout/checkout')]")).click();
//        select register
        WebElement firstResult = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='register']")));
        firstResult.click();
        driver.findElement(By.id("button-account")).click();

//        fill in form
        WebElement firstname = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='firstname']")));
        firstname.sendKeys("Benzuin");
        WebElement lastName = driver.findElement(By.id("input-payment-lastname"));
        lastName.sendKeys("Benzuin");
        WebElement email = driver.findElement(By.id("input-payment-email"));
        email.sendKeys("Java@test1234517.com");
        WebElement telephone = driver.findElement(By.id("input-payment-telephone"));
        telephone.sendKeys("62654621");
        WebElement address1 =driver.findElement(By.id("input-payment-address-1"));
        address1.sendKeys("myadress");
        WebElement city = driver.findElement(By.id("input-payment-city"));
        city.sendKeys("Vianen");
        Select countryList = new Select(driver.findElement(By.id("input-payment-country")));
        countryList.selectByValue("150");
        Select regionList = new Select(driver.findElement(By.id("input-payment-zone")));
        regionList.selectByValue("2338");
        WebElement password = driver.findElement(By.id("input-payment-password"));
        password.sendKeys("123456test");
        WebElement passwordConfirm = driver.findElement(By.id("input-payment-confirm"));
        passwordConfirm.sendKeys("123456test");
        WebElement privacyPolicy = driver.findElement(By.xpath("//input[@name='agree']"));
        privacyPolicy.click();
//        send form
        WebElement continueButton = driver.findElement(By.id("button-register"));
        continueButton.click();
//        continue delivery details
//        error start with NoSuchElementException for "WebElement existing"

        WebElement existing = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@value='existing']"))));
        existing.click();
        WebElement buttonDeliveryDetails = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("button-shipping-address"))));
        buttonDeliveryDetails.click();
//        delivery method
        WebElement flatRate = driver.findElement(By.xpath("//input[@value='flat.flat']"));
        flatRate.click();
        WebElement buttonDeliveryMethod = driver.findElement(By.id("button-shipping-method"));
        buttonDeliveryMethod.click();
//        Payment method
        WebElement cashOnDelivery = driver.findElement(By.xpath("//input[@value='cod']"));
        cashOnDelivery.click();
        WebElement termsConditions = driver.findElement(By.xpath("//input[@name='agree']"));
        termsConditions.click();
        WebElement buttonPaymentMethod = driver.findElement(By.id("button-payment-method"));
        buttonPaymentMethod.click();
//        confirm order
        WebElement buttonConfirmOrder = driver.findElement(By.id("button-confirm"));
        buttonConfirmOrder.click();

    }
}
