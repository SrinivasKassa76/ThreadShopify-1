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

WebUI.navigateToUrl('https://threads0.myshopify.com/password')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Threads/div_Enter using password'))

WebUI.setEncryptedText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Threads/input_Enter store using password_password'), 
    'gnzTAVlujIw+lTr0To6+Cg==')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Threads/button_Enter'))

WebUI.verifyElementClickable(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Threads/svg_Search_icon icon-account'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Threads/svg_Search_icon icon-account'))

//Click on login and provide valid id password from local variable
WebUI.verifyTextPresent('Login', false)

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Account  Threads/input_Login_customeremail'), 
    validemail)

//WebUI.setEncryptedText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Account  Threads/input_Email_customerpassword'), 
//    'UDMlkmqWREzH+mr49N5wRw==')
WebUI.setEncryptedText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Account  Threads/input_Email_customerpassword'), 
    validpass)

WebUI.verifyElementClickable(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Account  Threads/button_Sign in'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Account  Threads/button_Sign in'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Account  Threads/span_Home'))

WebUI.verifyTextPresent('Home', false)

//Select a product and Checkout
WebUI.verifyElementClickable(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Threads/a_ADIDAS  CLASSIC BACKPACK'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Threads/a_ADIDAS  CLASSIC BACKPACK'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_ADIDAS  CLASSIC BACKPACK  Threads/button_Buy it now'))

WebUI.verifyTextPresent('Threads', false)

//Storing Product Price
String productText = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/span_56.00'))

String clothWithoutDollar = productText.substring(1).replace(',', '').trim()

float productPrice = Float.parseFloat(clothWithoutDollar)

println("$productPrice")

//Storing Shipping Price
String shippinfText = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/span_10.00'))

String ShippinfTextW$ = shippinfText.substring(1).replace(',', '').trim()

float shippingPrice = Float.parseFloat(ShippinfTextW$)

println("$shippingPrice")

String taxText = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/span_10.08'))

String taxText$ = taxText.substring(1).replace(',', '').trim()

float taxPrice = Float.parseFloat(taxText$)

println("$taxPrice")

String totalText = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/strong_76.08'))

String totalText$ = totalText.substring(1).replace(',', '').trim()

float totalPrice = Float.parseFloat(totalText$)

println(totalPrice)

float total = (taxPrice + shippingPrice) + productPrice

println("$total")

//Compare between cost total and product total
if (total == totalPrice) {
    println('The price has matched')
} else {
    println('Price not matched ERROR')
}

//Edit the address and saved it
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/div_Ship to__1fragemfz _1fragemeo _1fragemh_6626dd'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/button_Bob Chen, Pursuit Software, abc apar_ab85f8'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/button_Edit'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/input_Address_address1'))

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/input_Apartment, suite, etc. (optional)_address2'), 
    'abc')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/button_Save'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/a_Threads'))

WebUI.closeBrowser()

