package com.oring.shengda_ui_test_appium.apkTest

import io.appium.java_client.remote.AndroidMobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import java.io.File

class ProjectCapabilities {

    companion object {

        fun AndroidBaseCapabilities(): DesiredCapabilities {
            val capabilities = DesiredCapabilities()
            capabilities.setCapability("browserstack.appiumLogs", "true")
            capabilities.setCapability("autoAcceptAlerts", true)
            capabilities.setCapability("automationName", "UiAutomator2")
            capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);

//            capabilities.setCapability("appPackage", "dbx.taiwantaxi.dev")
//            capabilities.setCapability("appActivity", "dbx.taiwantaxi.v9.login.LoginActivity")

            return capabilities
        }
    }


}

fun DesiredCapabilities.addDeviceName(deviceName: String) {

    setCapability("deviceName", deviceName)
}

fun DesiredCapabilities.addPlatformName(platformName: String) {

    setCapability("platformName", platformName)
}

fun DesiredCapabilities.addPlatformVersion(platformVersion: String) {

    setCapability("platformVersion", platformVersion)
}

fun DesiredCapabilities.addApkPath(apkName: String) {

    val filePath = File(System.getProperty("user.dir"),"auto_test/apk/")
    val app = File(filePath, apkName)
    setCapability("app", app.absolutePath)
}

fun DesiredCapabilities.addPackage(packageName: String) {

    setCapability("appPackage", packageName)
}

fun DesiredCapabilities.addAppActivity(activityName: String){
    setCapability("appActivity", activityName)
}