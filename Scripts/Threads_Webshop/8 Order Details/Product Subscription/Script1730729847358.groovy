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
String screenshotFolder = "screenshots/subscription_" + timestamp + "/"

WebUI.callTestCase(findTestCase('Threads_Webshop/ReUsable Testcases/Enter Password'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot(screenshotFolder + "home.png")

WebUI.click(findTestObject('Object Repository/Page_Threads/span_Catalog'))

WebUI.click(findTestObject('Object Repository/Page_Products  Threads/a_ADIDAS  SUPERSTAR 80S'))

WebUI.takeScreenshot(screenshotFolder + "select_product.png")

WebUI.verifyTextPresent('One-time purchase', false)

WebUI.verifyTextPresent('Subscribe and deliver every', false)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_ADIDAS  SUPERSTAR 80S  Threads/select_month3 months'), 
    '3 month', true)

WebUI.click(findTestObject('Object Repository/Page_ADIDAS  SUPERSTAR 80S  Threads/span_One-time purchase_sls-custom-radio'))

WebUI.click(findTestObject('Object Repository/Page_ADIDAS  SUPERSTAR 80S  Threads/button_Add to cart'))

WebUI.click(findTestObject('Object Repository/Page_ADIDAS  SUPERSTAR 80S  Threads/a_View cart (1)'))

WebUI.takeScreenshot(screenshotFolder + "subscription.png")

//WebUI.click(findTestObject('Object Repository/Page_Your Shopping Cart  Threads/div_Subscription interval                  _3bdc82'))
WebUI.verifyTextPresent('Discount on next order', false)

WebUI.closeBrowser()

