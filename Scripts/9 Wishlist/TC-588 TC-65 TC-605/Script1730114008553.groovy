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
 
WebUI.click(findTestObject('Object Repository/Wishlist_An/Page_Threads/div_Enter using password'))
 
WebUI.setEncryptedText(findTestObject('Object Repository/Wishlist_An/Page_Threads/input_Enter store using password_password'),
    'gnzTAVlujIw+lTr0To6+Cg==')
 
WebUI.click(findTestObject('Object Repository/Wishlist_An/Page_Threads/button_Enter'))
 
WebUI.click(findTestObject('Object Repository/Wishlist_An/Page_Threads/span_Catalog'))
 
WebUI.click(findTestObject('Object Repository/Wishlist_An/Page_Products  Threads/a_ADIDAS  CLASSIC BACKPACK'))
 
WebUI.getText(findTestObject('Object Repository/Wishlist_An/Page_ADIDAS  CLASSIC BACKPACK  Threads/h1_ADIDAS  CLASSIC BACKPACK'))
 
WebUI.getText(findTestObject('Object Repository/Wishlist_An/Page_ADIDAS  CLASSIC BACKPACK  Threads/span_Rs. 56.00'))
 
WebUI.click(findTestObject('Object Repository/Wishlist_An/Page_ADIDAS  CLASSIC BACKPACK  Threads/button_Add To Wishlist'))
 
WebUI.click(findTestObject('Object Repository/Wishlist_An/Page_ADIDAS  CLASSIC BACKPACK  Threads/div_ADIDAS  CLASSIC BACKPACK - OS  black ha_7c7ea2'))
 
WebUI.verifyTextPresent('My Wishlist', false)
 
WebUI.click(findTestObject('Object Repository/Wishlist_An/Page_Wishlist  Threads/h2_ADIDAS  CLASSIC BACKPACK'))
 
WebUI.verifyTextPresent(prodname, false)
 
WebUI.verifyTextPresent(price, false)
 
WebUI.closeBrowser()