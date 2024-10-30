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

//Open Browser and Enter password 
WebUI.openBrowser('')
 
WebUI.maximizeWindow()
 
WebUI.navigateToUrl('https://threads0.myshopify.com/password')
 
WebUI.click(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_Threads/div_Enter using password'))
 
WebUI.setEncryptedText(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_Threads/input_Enter store using password_password'),
    'gnzTAVlujIw+lTr0To6+Cg==')
 
WebUI.click(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_Threads/button_Enter'))
 
WebUI.click(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_Threads/span_Catalog'))
 
WebUI.click(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_Products  Threads/a_CONVERSE  CHUCK TAYLOR ALL STAR LO'))
 
WebUI.delay(2)
 
WebUI.click(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_CONVERSE  CHUCK TAYLOR ALL STAR LO  Threads/label_4Variant sold out or unavailable'))
 
WebUI.click(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_CONVERSE  CHUCK TAYLOR ALL STAR LO  Threads/button_Add to cart'))
 
WebUI.click(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_CONVERSE  CHUCK TAYLOR ALL STAR LO  Threads/a_View cart (1)'))
 
WebUI.click(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_Your Shopping Cart  Threads/button_Check out'))
 
WebUI.setText(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_Checkout - Threads/input_Discount code_reductions'),
    'WINTER10')
 
WebUI.click(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_Checkout - Threads/button_Apply'))
 
String prodPrice = WebUI.getText(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_Checkout - Threads/span_100.00'))
 
float originalPrice = parsePrice(prodPrice)
 
println(originalPrice)
 
float discountedPrice = (originalPrice / 100) * 10
 
float discount = parseDisc(WebUI.getText(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_Checkout - Threads/span_10.00')))
 
if (discount == discountedPrice) {
    println('Discounted price matches')
} else {
    println('Discounted price does not match')
}
 
float taxAmt = parsePrice(WebUI.getText(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_Checkout - Threads/span_8.10')))
 
float totalPrice = (originalPrice - discount) + taxAmt
 
String finalPriceStr = WebUI.getText(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_Checkout - Threads/strong_98.10'))
 
float finalPrice = parsePrice(finalPriceStr)
 
if (totalPrice == finalPrice) {
    println('Final price matches')
} else {
    println('Final price does not match')
 
    WebUI.closeBrowser()
}
 
WebUI.verifyTextPresent('TOTAL SAVINGS', false)
 
float savings = parsePrice(WebUI.getText(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_Checkout - Threads/strong_10.00')))
 
if (savings == discountedPrice) {
    println('Savings match')
} else {
    println('Savings do not match')
}
 
WebUI.closeBrowser()
 
float parsePrice(String price) {
    String cleanText = price.replaceAll('[^\\d.]', '').trim()
 
    return Float.parseFloat(cleanText)
}
 
float parseDisc(String price) {
    String cleanText = price.replaceAll('[^\\d.-]', '').trim()
 
    return Float.parseFloat(cleanText)
}