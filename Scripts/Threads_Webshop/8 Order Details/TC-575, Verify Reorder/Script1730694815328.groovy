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
String screenshotFolder = "screenshots/reorder_" + timestamp + "/"
WebUI.openBrowser('')

WebUI.navigateToUrl('https://threads0.myshopify.com/password')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Account/Reorder/Page_Threads/div_Enter using password'))

WebUI.setEncryptedText(findTestObject('Object Repository/Thread_Webshop/Account/Reorder/Page_Threads/input_Enter store using password_password'), 
    'gnzTAVlujIw+lTr0To6+Cg==')

WebUI.takeScreenshot(screenshotFolder + "catalog_page.png")

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Account/Reorder/Page_Threads/button_Enter'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Account/Reorder/Page_Threads/svg_Search_icon icon-account'))

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Account/Reorder/Page_Account  Threads/input_Login_customeremail'), 
    'cenaalice1234@mailinator.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Thread_Webshop/Account/Reorder/Page_Account  Threads/input_Email_customerpassword'), 
    'UDMlkmqWREzH+mr49N5wRw==')

WebUI.takeScreenshot(screenshotFolder + "login.png")

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Account/Reorder/Page_Account  Threads/button_Sign in'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Account/Reorder/Page_Account  Threads/button_Reorder'))

WebUI.takeScreenshot(screenshotFolder + "reorder.png")

WebUI.verifyTextPresent('Payment', false)

WebUI.closeBrowser()