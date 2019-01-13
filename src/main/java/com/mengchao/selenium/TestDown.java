package com.mengchao.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Auther: mengchao
 * @Date: 2019-1-12 11:31
 * @Description:
 * @Version 1.0
 * @ClassName TestDown
 */
public class TestDown {
    public static void main(String[] arg){
//        for(int i=0;i<5;i++) {
            System.setProperty("webdriver.chrome.driver", "E:\\workspace\\selenium\\lib\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();    //通过配置参数禁止data;的出现
            options.addArguments("--user-data-dir=C:/Users/Administrator/AppData/Local/Google/Chrome/User Data/Default");      //通过配置参数删除“您使用的是不受支持的命令行标记：--ignore-certificate-errors。稳定性和安全性会有所下降。”提示
            options.addArguments("--start-maximized", "allow-running-insecure-content", "--test-type");
        final WebDriver driver = new ChromeDriver(options);
        Date date = new Date();
        long start = date.getTime();
        int c=30;
        for(int i=0;i<c;i++) {
            driver.get("http://");
        }
        Date date1 = new Date();
        long end = date.getTime();
        System.out.println("下载"+c+"次,需要时间为"+(end-start)/1000+"秒");
            /* int ci = 200;
        Date start = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 16); //凌晨1点
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date date=calendar.getTime();
        for(int i=0;i<ci;i++){

            Timer timer = new Timer();
            timer.schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            new Mytask(driver).start();
                        }
                    },date,1000*90
            );
        }*/
    }


}
class Mytask extends Thread{
    WebDriver driver = null;
    public Mytask(WebDriver driver){
        this.driver=driver;
    }

    @Override
    public void run() {
        driver.findElement(By.id("app1")).click();
        driver.findElement(By.id("app2")).click();
    }
}
