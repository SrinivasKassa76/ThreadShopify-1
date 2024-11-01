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

//Open Browser
WebUI.openBrowser('')

WebUI.navigateToUrl('https://threads0.myshopify.com/password')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Threads/div_Enter using password'))

WebUI.setEncryptedText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Threads/input_Enter store using password_password'), 
    'gnzTAVlujIw+lTr0To6+Cg==')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Threads/button_Enter'))

//Login with an account
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Threads/path'))

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Account  Threads/input_Login_customeremail'), 
    'cenaalice1234@mailinator.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Account  Threads/input_Email_customerpassword'), 
    'UDMlkmqWREzH+mr49N5wRw==')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Account  Threads/button_Sign in'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Account  Threads/span_Home'))

WebUI.verifyTextPresent('', false)

WebUI.verifyElementClickable(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Threads/a_ADIDAS  CLASSIC BACKPACK'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Threads/a_ADIDAS  CLASSIC BACKPACK'))

WebUI.verifyElementClickable(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_ADIDAS  CLASSIC BACKPACK  Threads/button_Buy it now'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_ADIDAS  CLASSIC BACKPACK  Threads/button_Buy it now'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/path'))

//Choose shipping method
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/input_Choose a shipping method_shipping_methods'))

String product1 = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/span_56.00'))

println("$product1")

product1 = product1.replace('₹', '')

Float productPrice1 = Float.parseFloat(product1)

println("$productPrice1")

String shipping1 = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/span_10.00'))

println("$shipping1")

shipping1 = shipping1.replace('₹', '')

Float shippingPrice1 = Float.parseFloat(shipping1)

println("$shippingPrice1")

String tax1 = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/span_10.08'))

println("$tax1")

tax1 = tax1.replace('₹', '')

Float taxPrice1 = Float.parseFloat(tax1)

println("$taxPrice1")

Float priceTotal1 = (productPrice1 + shippingPrice1) + taxPrice1

String total1 = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/strong_76.08'))

println("$total1")

total1 = total1.replace('₹', '')

Float totalPrice1 = Float.parseFloat(total1)

println("$totalPrice1")

//Comparing Actual value to Total Sum value
if (priceTotal1 == totalPrice1) {
    println('The price has matched')
} else {
    println('Price not matched ERROR')
}

//Change the shipping method
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/input_10.00_shipping_methods'))

String product2 = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/span_56.00'))

println("$product2")

product2 = product2.replace('₹', '')

Float productPrice2 = Float.parseFloat(product2)

println("$productPrice2")

String shipping2 = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/span_25.00'))

println("$shipping2")

shipping2 = shipping2.replace('₹', '')

Float shippingPrice2 = Float.parseFloat(shipping2)

println("$shippingPrice2")

String tax2 = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/span_10.08'))

println("$tax2")

tax2 = tax2.replace('₹', '')

Float taxPrice2 = Float.parseFloat(tax2)

println("$taxPrice2")

Float priceTotal2 = (productPrice2 + shippingPrice2) + taxPrice2

String total2 = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/strong_91.08'))

println("$total2")

total2 = total2.replace('₹', '')

Float totalPrice2 = Float.parseFloat(total2)

println("$totalPrice2")

//Comparing Actual value to Total Sum value
if (priceTotal2 == totalPrice2) {
    println('The price has matched')
} else {
    println('Price not matched ERROR')
}

WebUI.closeBrowser()

