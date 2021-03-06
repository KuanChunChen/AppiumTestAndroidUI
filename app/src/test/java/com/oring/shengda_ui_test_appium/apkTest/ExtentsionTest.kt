package com.oring.shengda_ui_test_appium.apkTest

import com.aventstack.extentreports.ExtentTest
import com.aventstack.extentreports.MediaEntityBuilder
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import org.apache.commons.io.FileUtils
import org.openqa.selenium.By
import org.openqa.selenium.OutputType
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.io.File


var screenShotsDir: String = System.getProperty("user.dir")+ "//auto_test///reports//screenshots//"



private fun screenShot(driver: AndroidDriver<MobileElement>?, saveDir: String){
    val screenshot: File = driver!!.getScreenshotAs(OutputType.FILE)
    FileUtils.copyFile(screenshot, File(saveDir))
}

fun ExtentTest.screenshotPass(driver: AndroidDriver<MobileElement>?, fileName: String, message: String) {

    val saveDir = "$screenShotsDir$fileName.png"
    screenShot(driver, saveDir)
    addScreenCaptureFromPath(saveDir)
    pass(message, MediaEntityBuilder.createScreenCaptureFromPath(saveDir).build())
}

fun ExtentTest.screenshotInfo(driver: AndroidDriver<MobileElement>?, fileName: String, message: String) {
    val saveDir = "$screenShotsDir$fileName.png"
    screenShot(driver, saveDir)
    addScreenCaptureFromPath(saveDir)
    info(message, MediaEntityBuilder.createScreenCaptureFromPath(saveDir).build())
}

fun WebDriverWait.untilViewLoad(viewID: String): WebElement {
    return this.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id(viewID)))

}

fun scrollToId(driver: AndroidDriver<MobileElement?>, id: String) {
    val el =
        driver.findElementByAndroidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceIdMatches(\"$id\"));")
}
fun scrollToText(driver: AndroidDriver<MobileElement>, text: String) {
    val el = driver.findElementByAndroidUIAutomator("new UiScrollable("
            + "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().text(\"" + text + "\"));")
}
