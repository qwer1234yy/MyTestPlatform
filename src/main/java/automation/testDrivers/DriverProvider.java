package automation.testDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import automation.testmanagement.FileExtractor;

import java.net.URL;

@Component
//@Scope("singleton")
public class DriverProvider {
    private static WebDriver webDriver;
    private static EventFiringWebDriver driver;
    private static String webDriverRuntime;
    private static final Logger logger = LoggerFactory.getLogger(DriverProvider.class);

    @Value("${webDriver.config.folder:webdrivers}")
    private String webDriverConfigFolder;
    @Value("${browser.name:chrome}")
    private String browserName;
    @Value("${browser.headless:false}")
    private String browserHeadless;
    @Value("${chrome.driver.name:chromedriver.exe}")
    private String chromeDriverName;
    @Value("${ie.driver.name:IEDriverServer.exe}")
    private String ieDriverName;
    @Value("${firefox.driver.name:geckodriver.exe}")
    private String firefoxdriverName;
    @Value("${os.name}")
    private String osName;
    private String osType;

    public DriverProvider(){
        logger.info("Invoke Driver Provider class!");
    }

    public static EventFiringWebDriver getDriver() {
        return driver;
    }

    public EventFiringWebDriver initDriverInstance(){
        if(null == driver){
            Class driverClass = DriverProvider.class;
            synchronized (DriverProvider.class){
                if(null == driver){
                    this.initWebDriver();
                }
            }
        }
        return driver;
    }

    private void initWebDriver() {
        
        String osNameWindows = "win";
        String osNameMac = "mac";
        String osNameLinuxNix = "nix";
        String osNameLinuxNux = "nux";
        String osNameLinuxAix = "aix";
        String chromeName = "chrome";
        String firefoxName = "firefox";
        String ieName = "IE";

        if(this.osName.toLowerCase().contains(osNameWindows)){
            this.osType = "Windows";
        }else if(this.osName.toLowerCase().contains(osNameMac)){
            this.osType = "MAC";
        }else if(this.osName.toLowerCase().contains(osNameLinuxAix)
        ||this.osName.toLowerCase().contains(osNameLinuxNux)
        ||this.osName.toLowerCase().contains(osNameLinuxNix)){
            this.osType = "Linux";
        }
        
        String driverPath = this.webDriverConfigFolder + "/" + this.osType + "/";
        String webDriverSuffixName = "Windows".equals(this.osType) ? ".exe":"";
        
        URL webDriverSrc;
        
        if(chromeName.equalsIgnoreCase(this.browserName)){
            webDriverRuntime = this.chromeDriverName + webDriverSuffixName;
            driverPath = driverPath + webDriverRuntime;
            webDriverSrc = this.getClass().getClassLoader().getResource(driverPath);

            FileExtractor.exactFile(webDriverSrc,webDriverRuntime);
            System.setProperty("webdriver.chrome.driver",webDriverRuntime);
            logger.info("Set chrome driver path " + webDriverRuntime);

            ChromeOptions opt = new ChromeOptions();
            opt.addArguments(new String[]{"disable-infobars"});
            opt.addArguments(new String[]{"--disable-extensions"});
            
            if(Boolean.valueOf(this.browserHeadless)){
                opt.addArguments(new String[]{"headless"});
            }
            
            webDriver = new ChromeDriver();
            
            if(Boolean.valueOf(this.browserHeadless)){
                logger.info("Open headless chrome browser with resolution 1920*1080");
                webDriver.manage().window().maximize();
            }
        }else if(firefoxName.equalsIgnoreCase(this.browserName)){
            webDriverRuntime = this.firefoxdriverName + webDriverSuffixName;
            driverPath = driverPath + webDriverRuntime;
            webDriverSrc = this.getClass().getClassLoader().getResource(driverPath);
            FileExtractor.exactFile(webDriverSrc,webDriverRuntime);
            System.setProperty("webdriver.gecko.driver",webDriverRuntime);

            FirefoxOptions options = new FirefoxOptions();
            options.setCapability("marionette",true);
            webDriver = new FirefoxDriver(options);
            webDriver.manage().window().maximize();
            logger.info("Created GeckoDriver object");
            
        }

        if(webDriver == null){
            driver = null;
        }else{
            driver = new EventFiringWebDriver(webDriver);
            driver.register(new WebEventListener());
        }
        
    }

    public static void clearDriverInstance(){
        if(null != driver){
            driver.quit();
            logger.info("Browser closed");
        }else{
            logger.info("No Active Browser");
        }

        driver = null;
        webDriver = null;
        FileExtractor.deleteFile(webDriverRuntime);
    }
}
