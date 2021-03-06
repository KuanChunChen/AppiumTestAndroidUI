package com.oring.shengda_ui_test_appium.apkTest

import com.aventstack.extentreports.ExtentReports
import com.aventstack.extentreports.reporter.ExtentSparkReporter
import com.google.gson.Gson
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import org.json.JSONObject
import org.junit.After
import org.junit.Before
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL

open class BaseExtentReportTest  {

    protected var driver: AndroidDriver<MobileElement>? = null
    protected open var capabilities: DesiredCapabilities? = null
    private val webDriverURL: URL = URL("http://127.0.0.1:4723/wd/hub")
    protected open var extent: ExtentReports? = null




    @Before
    fun setUp() {
        println("before ,${Gson().toJson(capabilities)} ")
        this.driver = AndroidDriver(webDriverURL, capabilities)
        this.extent = ExtentReports().apply {
            attachReporter(ExtentSparkReporter(System.getProperty("user.dir") + "//auto_test//reports//spark.html"))
        }
    }

    @After
    fun tearDown() {
        println("after")
//        this.driver?.quit() ?: throw Exception("Driver instance was unable to quit.")
        extent?.flush()
    }

}