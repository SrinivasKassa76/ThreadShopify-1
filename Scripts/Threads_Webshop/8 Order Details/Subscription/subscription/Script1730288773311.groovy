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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://threads0.myshopify.com/password')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/Page_Threads/div_Enter using password'))

WebUI.setEncryptedText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/Page_Threads/input_Enter store using password_password'), 
    'gnzTAVlujIw+lTr0To6+Cg==')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/Page_Threads/button_Enter'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/Page_Threads/a_Explore Threads'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/Page_Products  Threads/a_ADIDAS  SUPERSTAR 80S'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/Page_ADIDAS  SUPERSTAR 80S  Threads/span_One-time purchase_sls-custom-radio'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/Page_ADIDAS  SUPERSTAR 80S  Threads/select_month3 months'), 
    '3 month', true)

//WebUI.delay(2)
//WebUI.verifyTextPresent('You will get a 5 discount on every recurring order.', false)
//WebUI.waitForTextPresent('You will get a 5 discount on every recurring order.', 10)
not_run: WebUI.verifyTextPresent('You will get a 5 discount on every recurring order.', false)

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/Page_ADIDAS  SUPERSTAR 80S  Threads/div_See details'))

WebUI.verifyTextPresent('You will receive a payment link and won\'t be charged automatically', false)

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/Page_ADIDAS  SUPERSTAR 80S  Threads/button_Add to cart'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/Page_ADIDAS  SUPERSTAR 80S  Threads/a_View cart (1)'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/Page_Your Shopping Cart  Threads/button_Check out'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/Page_Checkout - Threads/button_Pay now'))

WebUI.closeBrowser()

