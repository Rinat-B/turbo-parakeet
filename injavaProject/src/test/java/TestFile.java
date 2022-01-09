import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigFileReader;

import java.util.NoSuchElementException;


public class TestFile {

    ConfigFileReader configFileReader = new ConfigFileReader();

    @Test
    public void test() throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

       try {
           driver.get(configFileReader.path());
           WebElement table1=driver.findElement(By.id(configFileReader.id()));
           Boolean response = verifyTableCellTextByXpath(table1, configFileReader.getSearchColumn(),
                   configFileReader.searchText(), configFileReader.returnColumnText(), configFileReader.exeptedText());
       }
       catch (WebDriverException e) {
            System.out.println("You have probably closed your browser.");
        }
       finally {
           driver.close();

       }
    }

    public String getTableCellTextByXpath(WebElement table, int searchColumn,
                                          String searchText, int returnColumnText) throws Exception {
        String exeptedText = null;
        try {
            WebElement cell = table.findElement(By.xpath("//table/tbody/tr/td["+returnColumnText+"]"));
            exeptedText = cell.getText();
        }
        catch (NoSuchElementException e){
            System.out.println("You are trying to access a non-existent cell. Check the values you entered.");
        }

        finally {
            return exeptedText;
        }
    }

    public Boolean verifyTableCellTextByXpath(WebElement table, int searchColumn,
                                              String searchText, int returnColumnText, String exeptedText) throws Exception {
        String cellText = getTableCellTextByXpath(table,searchColumn, searchText,returnColumnText);
        if(cellText.equals(exeptedText) )
            return true;
        return false;
    }



    }
