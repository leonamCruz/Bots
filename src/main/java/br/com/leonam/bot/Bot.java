package br.com.leonam.bot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class Bot {
    private final WebDriver webDriver;
    private Actions actions;
    private final Random random;

    public Bot() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        actions = new Actions(webDriver);
        random = new Random();
    }

    public void login(String login, String senha) throws InterruptedException {
        webDriver.get(Palavra.SITE_INSTAGRAM);
        Thread.sleep(1500);
        webDriver.findElement(By.xpath(Palavra.XPATH_USERNAME)).click();
        actions.sendKeys(login);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(senha);
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();
        Thread.sleep(3500);
        webDriver.findElement(By.xpath(Palavra.NAO_SALVAR)).click();
        Thread.sleep(1500);
        webDriver.findElement(By.xpath(Palavra.AGORA_NAO)).click();
    }

    public void verTodosOsStories() throws InterruptedException {
        webDriver.findElement(By.xpath(Palavra.XPATH_STORIE_UM)).click();
        try {
            while (true) {
                actions = new Actions(webDriver);
                actions.sendKeys(Keys.ARROW_RIGHT);
                actions.build().perform();
                Thread.sleep(random.nextInt(1001, 4568));
                webDriver.findElement(By.xpath(Palavra.TELA_STORIES));
            }
        }catch (Exception exception){
            System.exit(0);
        }
    }
}
