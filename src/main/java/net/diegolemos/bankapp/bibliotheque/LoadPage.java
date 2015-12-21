package net.diegolemos.bankapp.bibliotheque;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

//import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * name of class : LoadPage. description : Open browser and load page
 * 
 * @version : 1.0
 * @since : 15/12/2015
 * @author : Talan Tunis
 */
public abstract  class LoadPage {
  
  /**
   * choix browser.
   * 
   * @param url go to url
   * @param browser Type of browser
   * @throws IOException
   *           If an input exception occurred
   * @return webdriver
   */
  public static final WebDriver openurl(final String url, 
      final String browser) throws IOException {

    WebDriver driver = null;
    if (browser.equals("GC")) {
      driver = google(url);
    } else if (browser.equals("ie")) {
      driver = ie(url);
    } else {
      driver = firefoxe(url);
    }

    driver.manage().window().maximize();

    return driver;
  }

  /**
   * Open Firefox.
   * @param url go to url
   * @throws IOException
   *           If an input exception occurred
   * @return webdriver
   */
  public static final WebDriver firefoxe(final String url) throws IOException {
    FirefoxProfile prof = new FirefoxProfile();

    prof.setPreference("browser.download.dir", "Save");
    prof.setPreference("browser.download.folderList", 2);
    prof.setPreference("browser.helperApps.neverAsk.saveToDisk",
        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"
            + "application/pdf;" // MIME types Of PDF File.
            + "application/vnd.openxmlformats-officedocument."
            + "wordprocessingml.document;"
            + "text/plain;" // MIME types Of text File.
            + "text/csv"); // MIME types Of CSV File.
    prof.setPreference("browser.download.manager.showWhenStarting", false);
    prof.setPreference("pdfjs.disabled", true);

    prof.setPreference("webdriver.load.strategy", "unstable");
    prof.setAssumeUntrustedCertificateIssuer(false);

    WebDriver driver = new FirefoxDriver(prof);
    driver.get(url);

    return driver;
  }

  /**
   * Open chrome.
   * @param url go to url
   * @throws IOException If an input exception occurred
   * @return webdriver
   */
  public static final WebDriver google(final String url) throws IOException { 
    System.setProperty("webdriver.chrome.driver", "Lib/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get(url);

    return driver;
  }

  /**
   * Open ie.
   * @param url go to url
   * @throws IOException
   *           If an input exception occurred
   * @return webdriver
   */
  public static final WebDriver ie(final String url) throws IOException {
    // Internet Explorer
    System.setProperty("webdriver.ie.driver", "Lib/IEDriverServer.exe");
    // WebDriver driver = new InternetExplorerDriver();
    WebDriver driver = new ChromeDriver();
    driver.get(url);

    return driver;
  }

}
