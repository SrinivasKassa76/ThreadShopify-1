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
 
WebUI.click(findTestObject('Object Repository/Search with Category_An/Page_Threads/div_Enter using password'))
 
WebUI.setEncryptedText(findTestObject('Object Repository/Search with Category_An/Page_Threads/input_Enter store using password_password'),
    'gnzTAVlujIw+lTr0To6+Cg==')
 
WebUI.click(findTestObject('Object Repository/Search with Category_An/Page_Threads/button_Enter'))
 
//Verify Home Page
WebUI.verifyTextPresent('Home', false)
 
//verify catalog page
WebUI.verifyTextPresent('Catalog', false)
 
WebUI.click(findTestObject('Object Repository/Search with Category_An/Page_Threads/span_Catalog'))
 
//verify Products page
WebUI.verifyTextPresent('Products', false)
 
//Filter using Price
WebUI.verifyTextPresent('Price', false)
 
WebUI.click(findTestObject('Object Repository/Search with Category_An/Page_Products  Threads/span_Price'))
 
WebUI.delay(2)
 
//Enter price range
WebUI.setText(findTestObject('Object Repository/Search with Category_An/Page_Products  Threads/input__filter.v.price.gte'), '199')
 
WebUI.setText(findTestObject('Object Repository/Search with Category_An/Page_Products  Threads/input__filter.v.price.lte'), '299')
 
WebUI.click(findTestObject('Object Repository/Search with Category_An/Page_Products  Threads/summary_Price'))
 
WebUI.verifyTextPresent('Sort by:', false)
 
/*WebUI.selectOptionByValue(findTestObject('Object Repository/Search with Category_An/s2/Page_Products  Threads/select_Featured                            _7b0490'),
    'price-ascending', true)*/
 
String product1 = WebUI.getText(findTestObject('Object Repository/Search with Category_An/Page_Products  Threads/a_ASICS TIGER  GEL-LYTE V 30 YEARS OF GEL PACK'))
 
println(product1)
 
String price1 = WebUI.getText(findTestObject('Object Repository/Search with Category_An/Page_Products  Threads/a_ASICS TIGER  GEL-LYTE V 30 YEARS OF GEL PACK_1'))
 
println(price1)
 
WebUI.click(findTestObject('Object Repository/Search with Category_An/Page_Products  Threads/a_ASICS TIGER  GEL-LYTE V 30 YEARS OF GEL PACK_1_2'))
 
WebUI.delay(2)
 
WebUI.verifyTextPresent(product1, false)
 
WebUI.verifyTextPresent(price1, false)
 
WebUI.closeBrowser()
 