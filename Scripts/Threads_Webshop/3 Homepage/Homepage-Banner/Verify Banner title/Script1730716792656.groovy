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

WebUI.navigateToUrl('https://accounts.shopify.com/lookup?rid=0afa009d-54e4-4293-85aa-e6413ed2f1d5&verify=1730713676-ynuqOa0Hs%2FJY+t6ojqHu++2TLa7otw1DETPdL%2FQmTWw%3D')

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Log in  Shopify account/input_Email_accountemail'), 
    'samajit_k@pursuitsoftware.com')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Log in  Shopify account/span_Continue with email'))

WebUI.setEncryptedText(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Shopify/input_Password_accountpassword'), 
    'DRbH8EpD41YzIH0RHeeTVRgk/CyhY5Tq4LbYao5MnUo=')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Shopify/button_Log in'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Shopify account profile/img'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Log in  Shopify/div_samajit_kpursuitsoftware.com'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Threads  Home  Shopify/span_Online Store'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Threads  Themes  Shopify/a_Customize'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Threads  Customize Dawn  Shopify/button_Uncover your wardrobe essentials_Onl_54202d (2)'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Threads  Customize Dawn  Shopify/input_First button link_UrlSetting1 (4)'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Threads  Customize Dawn  Shopify/div_Collections (2)'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Threads  Customize Dawn  Shopify/div_ASICS TIGER (2)'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Threads  Customize Dawn  Shopify/span_Save (4)'))

WebUI.delay(2)

//Checking the Banner
WebUI.callTestCase(findTestCase('Threads_Webshop/ReUsable Testcases/Enter Password'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Banner/Page_Threads/a_Explore Threads'))

String text_after_change = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Banner/Page_ASICS TIGER  Threads/h1_Collection ASICS TIGER'))


