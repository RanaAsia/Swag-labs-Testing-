package swaglabs

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static org.assertj.core.api.InstanceOfAssertFactories.list

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement
import java.util.Random
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.testobject.ConditionType

public class CheckoutActions {

	//		public static int SelectRandomItem() {
	//			// Find all item title links
	//			List<WebElement> items = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Product_page/item_title_links'), 30)
	//			int totalItems = items.size()
	//
	//			// Generate a random index for the item selection
	//			Random rand = new Random()
	//			int index = rand.nextInt(totalItems)
	//			return index
	//		}
	//
	//
	//		// Method to retrieve the price of an item based on its index
	//		public static String getItemPriceAtIndex(int index) {
	//			// Find all item prices
	//			List<WebElement> itemsPrices = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Product_page/item_price'), 30)
	//
	//			// Convert the WebElement at the specified index to TestObject and get the text (price)
	//			TestObject targetPrice = WebUI.convertWebElementToTestObject(itemsPrices.get(index))
	//			String itemPrice = WebUI.getText(targetPrice)
	//
	//			return itemPrice
	//		}
	//
	//		// Method to retrieve the description of an item based on its index
	//		public static String getItemDescriptionAtIndex(int index) {
	//			// Find all item descriptions
	//			List<WebElement> itemsDescription = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Product_page/item_description'), 30)
	//
	//			// Convert the WebElement at the specified index to TestObject and  the text (description)
	//			TestObject targetDescription = WebUI.convertWebElementToTestObject(itemsDescription.get(index))
	//			String itemDescription = WebUI.getText(targetDescription)
	//
	//			return itemDescription
	//		}
	//
	//		// Method to retrieve the name of an item based on its index
	//		public static String getItemNameAtIndex(int index) {
	//			// Find all item names
	//			List<WebElement> itemsName = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Product_page/item_name'), 30)
	//
	//			// Convert the WebElement at the specified index to TestObject and get the text (name)
	//			TestObject targetName = WebUI.convertWebElementToTestObject(itemsName.get(index))
	//			String itemName = WebUI.getText(targetName)
	//
	//			return itemName
	//		}
	//
	//		//Method to click the "Add to Cart" button for the item at the specified index
	//		public static void clickAddToCartAtIndex(int index) {
	//			// Find all Add to Cart buttons
	//			List<WebElement> addToCartButtons = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Product_page/add_to_cart_button'), 30)
	//
	//			// Convert the WebElement at the specified index to TestObject and perform a click action
	//			TestObject targetAddToCartButton = WebUI.convertWebElementToTestObject(addToCartButtons.get(index))
	//			WebUI.click(targetAddToCartButton)
	//		}
	//
	//		// Method to compare items between Product Page and Cart Page
	//		public static void compareItems(int index) {
	//			// Retrieve item details from the product page using the random index
	//			String itemName = getItemNameAtIndex(index)
	//			String itemDescription = getItemDescriptionAtIndex(index)
	//			String itemPrice = getItemPriceAtIndex(index)
	//
	//			// Navigate to the cart page by clicking the cart button
	//			WebUI.click(findTestObject('Object Repository/Product_page/page_header/cart_button'))
	//
	//			// Ensure the cart page is fully loaded before comparing
	//			WebUI.waitForPageLoad(10)
	//
	//			boolean isCartPageDisplayed = WebUI.verifyElementPresent(findTestObject('Object Repository/Cart_page/cart_title'), 10)
	//
	//			if (isCartPageDisplayed) {
	//				WebUI.comment('Successfully navigated to the Cart page.')
	//			} else {
	//				WebUI.comment('Failed to navigate to the Cart page.')
	//				WebUI.closeBrowser()  // Closes the browser and ends the session
	//				throw new Exception('Cart page navigation failed. Test execution stopped.')
	//			}
	//
	//			// Retrieve item details from the cart
	//			String cartItemName = WebUI.getText(findTestObject('Object Repository/Cart_page/cart_item_name'))
	//			String cartItemDescription = WebUI.getText(findTestObject('Object Repository/Cart_page/cart_item_description'))
	//			String cartItemPrice = WebUI.getText(findTestObject('Object Repository/Cart_page/cart_item_price'))
	//
	//			// Compare the name, description, and price of the product page item with the cart item
	//			WebUI.verifyEqual(itemName, cartItemName)
	//			WebUI.verifyEqual(itemDescription, cartItemDescription)
	//			WebUI.verifyEqual(itemPrice, cartItemPrice)
	//
	//			WebUI.closeBrowser()
	//		}
	//	////////////////////////////////

	//	public static int SelectRandomItem() {
	//		// Find all item title links
	//		List<WebElement> items = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Product_page/item_title_links'), 30)
	//		int totalItems = items.size()
	//
	//		// Generate a random index for the item selection
	//		Random rand = new Random()
	//		int index = rand.nextInt(totalItems)
	//		return index
	//	}
	//
	//	// Method to retrieve the price of an item based on its index
	//	public static String getItemPriceAtIndex(int index) {
	//		// Dynamically retrieve the item's price using the index parameter
	//		String itemPrice = WebUI.getText(findTestObject('Object Repository/Product_page/item_price', [('index'): index]))
	//
	//		return itemPrice
	//	}
	//
	//	// Method to retrieve the description of an item based on its index
	//	public static String getItemDescriptionAtIndex(int index) {
	//		// Dynamically retrieve the item's description using the index parameter
	//		String itemDescription = WebUI.getText(findTestObject('Object Repository/Product_page/item_description', [('index'): index]))
	//
	//		return itemDescription
	//	}
	//
	//	// Method to retrieve the name of an item based on its index
	//	public static String getItemNameAtIndex(int index) {
	//		// Dynamically retrieve the item's name using the index parameter
	//		String itemName = WebUI.getText(findTestObject('Object Repository/Product_page/item_name', [('index'): index]))
	//
	//		return itemName
	//	}
	//
	//	// Method to click the "Add to Cart" button for the item at the specified index
	//	public static void clickAddToCartAtIndex(int index) {
	//		// Dynamically click the "Add to Cart" button using the index parameter
	//		WebUI.click(findTestObject('Object Repository/Product_page/add_to_cart_button', [('index'): index]))
	//	}
	//
	//	// Method to compare items between Product Page and Cart Page
	//	public static void compareItems(int index) {
	//		// Retrieve item details from the product page using the random index
	//		String itemName = getItemNameAtIndex(index)
	//		String itemDescription = getItemDescriptionAtIndex(index)
	//		String itemPrice = getItemPriceAtIndex(index)
	//
	//		// Navigate to the cart page by clicking the cart button
	//		WebUI.click(findTestObject('Object Repository/Product_page/page_header/cart_button'))
	//
	//		// Ensure the cart page is fully loaded before comparing
	//		WebUI.waitForPageLoad(10)
	//
	//		boolean isCartPageDisplayed = WebUI.verifyElementPresent(findTestObject('Object Repository/Cart_page/cart_title'), 10)
	//
	//		if (isCartPageDisplayed) {
	//			WebUI.comment('Successfully navigated to the Cart page.')
	//		} else {
	//			WebUI.comment('Failed to navigate to the Cart page.')
	//			WebUI.closeBrowser()  // Closes the browser and ends the session
	//			throw new Exception('Cart page navigation failed. Test execution stopped.')
	//		}
	//
	//		// Retrieve item details from the cart
	//		String cartItemName = WebUI.getText(findTestObject('Object Repository/Cart_page/cart_item_name'))
	//		String cartItemDescription = WebUI.getText(findTestObject('Object Repository/Cart_page/cart_item_description'))
	//		String cartItemPrice = WebUI.getText(findTestObject('Object Repository/Cart_page/cart_item_price'))
	//
	//		// Compare the name, description, and price of the product page item with the cart item
	//		WebUI.verifyEqual(itemName, cartItemName)
	//		WebUI.verifyEqual(itemDescription, cartItemDescription)
	//		WebUI.verifyEqual(itemPrice, cartItemPrice)
	//
	//		//WebUI.closeBrowser()
	//	}

	final static def ITEM_TITLE_LINKS() {
		return findTestObject('Object Repository/Product_page/item_title_links')
	}

	static final def ITEM_NAME() {
		return findTestObject('Object Repository/Product_page/item_name')
	}

	static final def ITEM_DESCRIPTION() {
		return findTestObject('Object Repository/Product_page/item_description')
	}

	static final def ITEM_PRICE() {
		return findTestObject('Object Repository/Product_page/item_price')
	}

	static final def ADD_TO_CART_BUTTON() {
		return findTestObject('Object Repository/Product_page/add_to_cart_button')
	}

	static final def CART_PAGE_BUTTON() {
		return findTestObject('Object Repository/Product_page/page_header/cart_button')
	}

	static final def CHECKOUT_BUTTON() {
		return findTestObject('Object Repository/Cart_page/checkout_button')
	}

	static final def YOURINFORMATION_PAGE_FIRSTNAME() {
		return findTestObject('Object Repository/Your_Information_page/firstname')
	}

	static final def YOURINFORMATION_PAGE_LASTNAME() {
		return findTestObject('Object Repository/Your_Information_page/lastname')
	}

	static final def YOURINFORMATION_PAGE_POSTAL_CODE() {
		return findTestObject('Object Repository/Your_Information_page/postal_code')
	}

	static final def CONTINUE_BUTTON() {
		return findTestObject('Object Repository/Your_Information_page/continue_button')
	}

	static final def REMOVE_BUTTON() {
		return findTestObject('Object Repository/Cart_page/remove_button')
	}

	static final def FINISH_BUTTON() {
		return findTestObject('Object Repository/Cart_page/Description_page/button_finish')
	}

	static final def BACK_HOME_BUTTON() {
		return findTestObject('Object Repository/Complete_page/button_back_home')
	}

	static final def CONTINUE_SHOPPING_BUTTON() {
		return findTestObject('Object Repository/Cart_page/button_continue_shopping')
	}

	static final def PRODUCT_FILTER_DROPDOWN() {
		return findTestObject('Object Repository/Product_page/product_filter')
	}





	//static final TestObject ITEM_TITLE_LINKS = new TestObject().addProperty('css', ConditionType.EQUALS, 'a[id^="item_"][id$="_title_link"')
	//	static final TestObject ITEM_NAME = new TestObject().addProperty('css', ConditionType.EQUALS, "div.inventory_item_name")
	//	static final TestObject ITEM_DESCRIPTION = new TestObject().addProperty('css', ConditionType.EQUALS, "div.inventory_item_desc")
	//	static final TestObject ITEM_PRICE = new TestObject().addProperty('css', ConditionType.EQUALS, "div.inventory_item_price")
	//	static final TestObject ADD_TO_CART_BUTTON = new TestObject().addProperty('css', ConditionType.EQUALS, "button.btn_inventory")
	//	static final TestObject CHECKOUT_BUTTON = new TestObject().addProperty('css', ConditionType.EQUALS, 'button[class="btn btn_action btn_medium checkout_button "]')
	//	static final TestObject YOURINFORMATION_PAGE_FIRSTNAME  = new TestObject().addProperty('css', ConditionType.EQUALS, 'input[id="first-name"]')
	//	static final TestObject YOURINFORMATION_PAGE_LASTNAME  = new TestObject().addProperty('css', ConditionType.EQUALS, 'input[id="last-name"]')
	//	static final TestObject YOURINFORMATION_POSTAL_CODE = new TestObject().addProperty('css', ConditionType.EQUALS, 'input[id="postal-code"]')


	public static int SelectRandomItem() {
		// Find all item title links
		List<WebElement> items = WebUiCommonHelper.findWebElements(ITEM_TITLE_LINKS(), 30)
		int totalItems = items.size()
		// Generate a random index for the item selection
		Random rand = new Random()
		int index = rand.nextInt(totalItems)
		return index
	}


	// Method to retrieve the price of an item based on its index
	//	public static String getItemPriceAtIndex(int index) {
	//
	//		String itemPrice = WebUI.getText(ITEM_PRICE(), [('index'): index])
	//		return itemPrice
	//	}
	//
	//	// Method to retrieve the description of an item based on its index
	//	public static String getItemDescriptionAtIndex(int index) {
	//		String itemDescription = WebUI.getText(ITEM_DESCRIPTION(), [('index'): index])
	//		return itemDescription
	//	}

	public static String getItemPriceAtIndex(int index) {
		// Find all item prices
		List<WebElement> itemsPrices = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Product_page/item_price'), 30)

		// Convert the WebElement at the specified index to TestObject and get the text (price)
		TestObject targetPrice = WebUI.convertWebElementToTestObject(itemsPrices.get(index))
		String itemPrice = WebUI.getText(targetPrice)

		return itemPrice
	}

	// Method to retrieve the description of an item based on its index
	public static String getItemDescriptionAtIndex(int index) {
		// Find all item descriptions
		List<WebElement> itemsDescription = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Product_page/item_description'), 30)

		// Convert the WebElement at the specified index to TestObject and  the text (description)
		TestObject targetDescription = WebUI.convertWebElementToTestObject(itemsDescription.get(index))
		String itemDescription = WebUI.getText(targetDescription)

		return itemDescription
	}

	// Method to retrieve the name of an item based on its index
	//	public static String getItemNameAtIndex(int index) {
	//		String itemName = WebUI.getText(ITEM_NAME(), [('index'): index])
	//		return itemName
	//	}
	public static String getItemNameAtIndex(int index) {
		// Find all item names
		List<WebElement> itemsName = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Product_page/item_name'), 30)

		// Convert the WebElement at the specified index to TestObject and get the text (name)
		TestObject targetName = WebUI.convertWebElementToTestObject(itemsName.get(index))
		String itemName = WebUI.getText(targetName)

		return itemName
	}

	// Method to click the "Add to Cart" button for the item at the specified index
	//	public static void clickAddToCartAtIndex(int index) {
	//		WebUI.click(ADD_TO_CART_BUTTON(), [('index'): index])
	//	}

	public static void clickAddToCartAtIndex(int index) {
		// Find all Add to Cart buttons
		List<WebElement> addToCartButtons = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Product_page/add_to_cart_button'), 30)

		// Convert the WebElement at the specified index to TestObject and perform a click action
		TestObject targetAddToCartButton = WebUI.convertWebElementToTestObject(addToCartButtons.get(index))
		WebUI.click(targetAddToCartButton)
	}

	public static void clickCheckoutButton() {
		WebUI.click(CHECKOUT_BUTTON())
	}

	public static String getInformationPageFirstName() {
		String firstname=WebUI.getAttribute(YOURINFORMATION_PAGE_FIRSTNAME(),'value')
		return firstname
	}

	public static String getInformationPageLastName() {
		String lastname=WebUI.getAttribute(YOURINFORMATION_PAGE_LASTNAME(),'value')
		return lastname
	}

	public static String getInformationPagePostalCode() {
		String lastname=WebUI.getAttribute(YOURINFORMATION_PAGE_POSTAL_CODE(),'value')
		return lastname
	}

	public static void navigateToCart() {
		WebUI.click(CART_PAGE_BUTTON())
		WebUI.waitForPageLoad(10)
	}

	public static def clickContinueButton() {
		WebUI.click(CONTINUE_BUTTON())
	}

	public static def clickRemoveButton() {
		WebUI.click(REMOVE_BUTTON())
	}

	public static def clickFinishButton() {
		WebUI.click(FINISH_BUTTON())
	}

	public static def clickBackHomeButton() {
		WebUI.click(BACK_HOME_BUTTON())
	}

	public static def clickContinueShoppingButton() {
		WebUI.click(CONTINUE_SHOPPING_BUTTON())
	}

	public static def DropDownProductFilter() {
		WebUI.click(PRODUCT_FILTER_DROPDOWN())
	}

	public static void ChooseZtoANameFiltering() {

		WebUI.selectOptionByValue(PRODUCT_FILTER_DROPDOWN(), 'za', false)
	}

	public static void ChooseLowtoHighPriceFiltering() {

		WebUI.selectOptionByValue(PRODUCT_FILTER_DROPDOWN(), 'lohi', false)
	}

	public static void ChooseHightoLowPriceFiltering() {

		WebUI.selectOptionByValue(PRODUCT_FILTER_DROPDOWN(), 'hilo', false)
	}

	public static void FillCheckoutInformation() {
		WebUI.setText(YOURINFORMATION_PAGE_FIRSTNAME(), GlobalVariable.firstname)
		WebUI.setText(YOURINFORMATION_PAGE_LASTNAME(),GlobalVariable.lastname)
		WebUI.setText(YOURINFORMATION_PAGE_POSTAL_CODE(), GlobalVariable.postal_code)
	}
}


