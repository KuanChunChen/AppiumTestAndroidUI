package com.oring.shengda_ui_test_appium.apkTest

import com.aventstack.extentreports.ExtentTest
import com.oring.shengda_ui_test_appium.apkTest.constant.Target
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import org.junit.Test
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait


class AndroidReportTest: BaseExtentReportTest() {

    private val targetPackageName = Target.PackageName.ORING_LIGHT_PACKAGE


    override var capabilities: DesiredCapabilities? = ProjectCapabilities.AndroidBaseCapabilities().apply {
        addApkPath(Target.ApkName.ORING_LIGHT_APK)
        addPlatformVersion(Target.AndroidVersion.Android7)
        addDeviceName(Target.DeviceName.MonitorPixel2_API_24)
        addPlatformName(Target.Platform.Android)
        addPackage(targetPackageName)
    }



    private val confirmButton: String = "${targetPackageName}:id/btn_login"
    private val layoutBaby: String = "${targetPackageName}:id/layout_baby"

    private val startButton: String = "${targetPackageName}:id/intoMenu"
    private val signUpButton: String = "${targetPackageName}:id/btn_createAccount"
    private val forgetButton: String = "${targetPackageName}:id/btn_forget"

    @Test
    fun oRingLightDemo() {
        val wait = WebDriverWait(driver?.let { it }, 10)
        val extentTest: ExtentTest = extent!!.createTest("login page")
        extentTest.screenshotInfo(driver!!, "loginPage", "login page")
        if (driver!!.isKeyboardShown) {
            driver?.hideKeyboard()
        }
        val editTextAccount: String = "${targetPackageName}:id/edt_username"
        val editTextPassword: String = "${targetPackageName}:id/edt_password"
        val loginButton = "${targetPackageName}:id/txt_login"


        driver?.findElementById(editTextAccount)?.sendKeys("admin")
        wait.until(ExpectedConditions.attributeToBeNotEmpty(driver?.findElementById(editTextAccount), "text"))
        extentTest.screenshotInfo(driver!!, "afterInputAccount", "input account")


        driver?.findElementById(editTextPassword)?.sendKeys("oring28942349")
        wait.until(ExpectedConditions.attributeToBeNotEmpty(driver?.findElementById(editTextPassword), "text"))
        extentTest.screenshotInfo(driver!!, "afterInputPassword", "input password")
        driver?.findElementById(loginButton)?.click()


        val mainPageToolbarText = "${targetPackageName}:id/nav_txtTitle"
        val listTable = "${targetPackageName}:id/list_table"

        val parentPanel = "android:id/parentPanel"
        val parentPanelEditText = "${targetPackageName}:id/editText"
        val parentPanelConfirm = "android:id/button1"

        val extentTest2: ExtentTest = extent!!.createTest("main menu page")
        wait.untilViewLoad(mainPageToolbarText)

        extentTest2.screenshotInfo(driver!!, "mainMenuPageTop", "after login and go on page")
        driver?.let { driver ->
            scrollToText(driver, "(聯嘉)台中港案")
            extentTest2.screenshotInfo(driver, "mainMenuPageBottom", "scroll to bottom")
        }

        driver?.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow[6]")
                ?.click()


        wait.untilViewLoad(parentPanel)
        extentTest2.screenshotInfo(driver, "powerDialog", "please input power on dialog edit text.")

        driver?.findElementById(parentPanelEditText)?.sendKeys("123")
        wait.until(ExpectedConditions.attributeToBeNotEmpty(driver?.findElementById(parentPanelEditText), "text"))
        extentTest2.screenshotInfo(driver!!, "afterInputPower", "after input power")
        driver?.findElementById(parentPanelConfirm)?.click()

        val lightCheckPage = "android:id/content"

        val extentTest3: ExtentTest = extent!!.createTest("insert page")
        wait.untilViewLoad(lightCheckPage)
        extentTest3.screenshotInfo(driver!!, "lightCheckPage", "on light check page")


    }


    @Test
    fun fullTest(){
        signUpPageTest()
        loginPageTest()
        mainPageTest()
    }
    @Test
    fun mainPageTest() {
        val hostFragment = "${targetPackageName}:id/nav_host_fragment"
        val toListButton = "${targetPackageName}:id/jump_toList"
        val scanQRCodeButton = "${targetPackageName}:id/scan_QRcode"


        val wait = WebDriverWait(driver?.let { it }, 10)
        val extentTest: ExtentTest = extent!!.createTest("main page")
        wait.untilViewLoad(hostFragment)
        extentTest.screenshotInfo(driver!!, "mainPage", "main page")
        driver?.findElementById(toListButton)?.click()


        val wellListView = "${targetPackageName}:id/thing_list_service"
        wait.untilViewLoad(wellListView)
        extentTest.screenshotInfo(driver!!, "wellListView", "well list page")
        driver?.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")?.click()

        wait.untilViewLoad(hostFragment)
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id(scanQRCodeButton)))
        wait.untilViewLoad(scanQRCodeButton).click()

        extentTest.screenshotInfo(driver!!, "scanQRCode", "qr code page")


    }

    @Test
    fun signUpPageTest() {
        val editTextSignUpName = "${targetPackageName}:id/editText_R_name"
        val editTextSignUpEmail = "${targetPackageName}:id/editText_R_Email"
        val editTextSignUpPhone = "${targetPackageName}:id/editText_R_phone"
        val editTextSignUpPassword = "${targetPackageName}:id/editText_R_Password"
        val editTextSignUpP2ssword = "${targetPackageName}:id/editText_R_AgainPassword"
        val backButton = "${targetPackageName}:id/Back_register"
        val commitButton =  "${targetPackageName}:id/btn_commit"

        val wait = WebDriverWait(driver?.let { it }, 10)
        val extentTest: ExtentTest = extent!!.createTest("sign up")

        wait.untilViewLoad(signUpButton).click()

        extentTest.screenshotInfo(driver!!, "signUpPageBefore", "before input")
        wait.untilViewLoad(commitButton)
        driver?.findElementById(editTextSignUpName)?.sendKeys("0986888333")
        driver?.findElementById(editTextSignUpEmail)?.sendKeys("0986888333@test.com")
        driver?.findElementById(editTextSignUpPhone)?.sendKeys("0986888333")
        driver?.findElementById(editTextSignUpPassword)?.sendKeys("00000000")
        driver?.findElementById(editTextSignUpP2ssword)?.sendKeys("00000000")
        extentTest.screenshotInfo(driver!!, "signUpPageAfter", "after input")
        wait.untilViewLoad(backButton).click()


    }

    @Test
    fun forgetPasswordTest() {
//        val wait = WebDriverWait(driver?.let { it }, 10)
//        val extentTest: ExtentTest = extent!!.createTest("forget password")
//        wait.untilViewLoad(forgetButton).click()


    }
    @Test
    fun loginPageTest() {


        val extentTest: ExtentTest = extent!!.createTest("login")
        extentTest.info("start!")

        val wait = WebDriverWait(driver?.let { it }, 10)
        val editTextAccount: String = "${targetPackageName}:id/L_editText_account"
        val editTextPassword: String = "${targetPackageName}:id/L_editText_pwd"
        val loginButton = "${targetPackageName}:id/btn_login"




        wait.untilViewLoad(loginButton)
        extentTest.screenshotInfo(driver!!, "loginPage", "login page")

        driver?.findElementById(editTextAccount)?.sendKeys("0986888333")
        wait.until(ExpectedConditions.attributeToBeNotEmpty(driver?.findElementById(editTextAccount), "text"))
        extentTest.screenshotInfo(driver!!, "afterInputAccount", "input account")

        driver?.findElementById(editTextPassword)?.sendKeys("00000000")
        wait.until(ExpectedConditions.attributeToBeNotEmpty(driver?.findElementById(editTextPassword), "text"))
        extentTest.screenshotInfo(driver!!, "afterInputPassword", "input password")
        driver?.findElementById(confirmButton)?.click()

        wait.untilViewLoad(layoutBaby)
        extentTest.screenshotInfo(driver!!, "after login", "before start")
        driver?.findElementById(startButton)?.click()

        // Scroll Down
//        val finger: PointerInput = PointerInput(PointerInput.Kind.TOUCH, "finger")
//        val moveToStart: Interaction = finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 726, 2452)
//        val pressDown: Interaction = finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg());
//        val moveToEnd: Interaction = finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), 726, 660)
//        val pressUp: Interaction = finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg())
//
//        val swipe = Sequence(finger, 0)
//        swipe.addAction(moveToStart)
//        swipe.addAction(pressDown)
//        swipe.addAction(moveToEnd)
//        swipe.addAction(pressUp)
//
//        driver?.let { it.perform(arrayListOf(swipe)) }

    }

}