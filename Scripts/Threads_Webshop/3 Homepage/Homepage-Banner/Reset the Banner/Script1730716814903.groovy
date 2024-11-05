import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.text.SimpleDateFormat

// Get unique folder path based on the current timestamp
String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
String screenshotFolder = "screenshots/Banner_" + timestamp + "/"
 
//Reset the value
WebUI.openBrowser('')

WebUI.navigateToUrl('https://accounts.shopify.com/lookup?rid=dae83e14-2e3c-4fcf-a6be-3804591d53e3&verify=1730703470-n9Qi9cu+W2Oet%2FisWWWPznB2IGXxJqGTPM3%2FTJl8RoU%3D')

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Log in  Shopify/input_Email_accountemail'), 'samajit_k@pursuitsoftware.com')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Log in  Shopify/span_Continue with email'))

WebUI.setEncryptedText(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Shopify/input_Password_accountpassword'), 
    'DRbH8EpD41YzIH0RHeeTVRgk/CyhY5Tq4LbYao5MnUo=')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Shopify/button_Log in'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Shopify account profile/img'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Log in  Shopify/div_Samajit Kundu'))

WebUI.takeScreenshot(screenshotFolder + "shopify_website.png")

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Threads  Home  Shopify/span_Online Store'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Threads  Themes  Shopify/span_Customize'))

WebUI.takeScreenshot(screenshotFolder + "customize_page.png")

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Threads  Customize Dawn  Shopify/button_Uncover your wardrobe essentials_Onl_54202d'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Threads  Customize Dawn  Shopify/input_First button link_UrlSetting1 (1)'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Threads  Customize Dawn  Shopify/input_First button link_UrlSetting1 (2)'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Threads  Customize Dawn  Shopify/div_Products (2)'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Threads  Customize Dawn  Shopify/div_All products'))

WebUI.takeScreenshot(screenshotFolder + "selection_banner.png")

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Threads  Customize Dawn  Shopify/span_Save (4)'))

WebUI.delay(2)

//Verify reset
WebUI.callTestCase(findTestCase('Threads_Webshop/ReUsable Testcases/Enter Password'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Threads/a_Explore Threads_1'))

WebUI.takeScreenshot(screenshotFolder + "check_banner.png")

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Products  Threads/a_ADIDAS  CLASSIC BACKPACK'))

WebUI.closeBrowser()

