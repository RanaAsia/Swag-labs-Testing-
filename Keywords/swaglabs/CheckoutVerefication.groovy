package swaglabs

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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
import com.kms.katalon.core.testobject.ConditionType
import internal.GlobalVariable
import org.openqa.selenium.WebElement


public class CheckoutVerification {


	final static def ITEM_TITLE_LINKS() {
		return findTestObject('Object Repository/Product_page/item_title_links')
	}

	static final TestObject ITEM_NAME() {
		return findTestObject('Object Repository/Product_page/item_name')
	}

	static final def COMPLETE_TEXT() {
		return findTestObject('Object Repository/Complete_page/complete_text')
	}

	static final def CART_PAGE_BUTTON() {
		return findTestObject('Object Repository/Product_page/page_header/cart_button')
	}

	static final def CART_PAGE_TITLE() {
		return findTestObject('Object Repository/Cart_page/cart_title')
	}

	static final def CART_ITEM_NAME() {
		return findTestObject('Object Repository/Cart_page/cart_item_name')
	}

	static final def CART_ITEM_DESCRIPTION() {
		return findTestObject('Object Repository/Cart_page/cart_item_description')
	}

	static final def CART_ITEM_PRICE() {
		return findTestObject('Object Repository/Cart_page/cart_item_price')
	}

	static final def PRODUCT_PAGE_TITLE() {
		return findTestObject('Object Repository/Product_page/product_title')
	}

	static final def ITEM_PRICE() {
		return findTestObject('Object Repository/Product_page/item_price')
	}


	// Method to retrieve item details from the product page
	public static Map<String, String> getProductPageDetails(int index) {
		String itemName = CheckoutActions.getItemNameAtIndex(index)
		String itemDescription = CheckoutActions.getItemDescriptionAtIndex(index)
		String itemPrice = CheckoutActions.getItemPriceAtIndex(index)

		Map<String, String> productPageDetails = new HashMap<>()
		productPageDetails.put('name', itemName)
		productPageDetails.put('description', itemDescription)
		productPageDetails.put('price', itemPrice)

		return productPageDetails
	}

	// Method to navigate to the cart page
	public static void navigateToCart() {
		WebUI.click(CART_PAGE_BUTTON())
		WebUI.waitForPageLoad(10)

		boolean isCartPageDisplayed = WebUI.verifyElementPresent(CART_PAGE_TITLE(),10)
		if (!isCartPageDisplayed) {
			WebUI.comment('Failed to navigate to the Cart page.')
			WebUI.closeBrowser()
			throw new Exception('Cart page navigation failed. Test execution stopped.')
		}
	}

	// Method to retrieve item details from the cart page
	public static Map<String, String> getCartPageDetails() {
		String cartItemName = WebUI.getText(CART_ITEM_NAME())
		String cartItemDescription = WebUI.getText(CART_ITEM_DESCRIPTION())
		String cartItemPrice = WebUI.getText(CART_ITEM_PRICE())

		Map<String, String> cartPageDetails = new HashMap<>()
		cartPageDetails.put('name', cartItemName)
		cartPageDetails.put('description', cartItemDescription)
		cartPageDetails.put('price', cartItemPrice)

		return cartPageDetails
	}

	// Method to compare product and cart details
	public static void compareDetails(Map<String, String> productPageDetails, Map<String, String> cartPageDetails) {
		WebUI.verifyEqual(productPageDetails.get('name'), cartPageDetails.get('name'))
		WebUI.verifyEqual(productPageDetails.get('description'), cartPageDetails.get('description'))
		WebUI.verifyEqual(productPageDetails.get('price'), cartPageDetails.get('price'))
	}

	// Main method to compare items between Product Page and Cart Page
	public static void compareItems(int index) {
		// Step 1: Get product page details
		WebUI.comment("ranaaa1")

		Map<String, String> productPageDetails = getProductPageDetails(index)
		WebUI.comment("ranaaa2")

		// Step 2: Navigate to the cart page
		navigateToCart()

		WebUI.comment('ranaa3')

		// Step 3: Get cart page details
		Map<String, String> cartPageDetails = getCartPageDetails()

		// Step 4: Compare details
		compareDetails(productPageDetails, cartPageDetails)
	}


	public static void verifyCompleteOrder() {
		boolean isCompleteTextDisplayed = WebUI.verifyElementText(COMPLETE_TEXT(),'Your order has been dispatched, and will arrive just as fast as the pony can get there!')
		if (isCompleteTextDisplayed ) {
			WebUI.comment('Completed')
		} else {
			WebUI.comment('Not Completed')
		}
	}

	public static void verifyProductPage() {
		boolean isProductPageDisplayed = WebUI.verifyElementPresent(PRODUCT_PAGE_TITLE(), 10)
		if (isProductPageDisplayed) {
			WebUI.comment('Successfully navigated to the Product page.')
		} else {
			WebUI.comment('Failed to navigate to the Product page.')
		}
	}

	public static void verifyItemsSortedZToA() {

		// Step 1: Find all item names on the page
		List<WebElement> itemNames = WebUI.findWebElements(ITEM_NAME(), 30)
		WebUI.comment("Actual item names: ${itemNames}")
		// Step 2: Extract the text from each WebElement
		List<String> actualNames = itemNames.collect { it.getText() }

		// Debugging: Print actual names
		WebUI.comment("Actual item names: ${actualNames}")

		// Step 3: Sort the list of names in descending order (Z to A)
		List<String> expectedNames = actualNames.sort{a, b -> b.compareTo(a)}


		// Debugging: Print expected names
		WebUI.comment("Expected sorted names (A to Z): ${expectedNames}")

		// Step 4: Assert that the actual list of names matches the expected sorted list
		assert actualNames == expectedNames : "Items are not sorted correctly! Expected: $expectedNames but found: $actualNames"
	}

	public static void VerifyLowToHighPriceSorting() {
		// Define a test object locator for the product price elements
		List<WebElement> itemsPrice = WebUI.findWebElements(ITEM_PRICE(), 30)
		//def priceElements = WebUI.findWebElements(ITEM_PRICE(), 10)
		WebUI.comment("Found ${itemsPrice.size()} price elements")

		List<Double> prices = itemsPrice.collect { it.getText().replace('$', '').toDouble() }
		WebUI.comment("Found ${prices} price elements")




		// Debug: Print the list of parsed prices
		WebUI.comment("Parsed prices: ${prices}")
		// Verify prices are in ascending order
		for (int i = 0; i < prices.size() - 1; i++) {
			assert prices[i] <= prices[i + 1] : "Prices are not sorted correctly: ${prices[i]} should be less than or equal to ${prices[i + 1]}"
		}
	}
	public static void VerifyTotalPrice () {
		String itemsPriceText = WebUI.getText(findTestObject('Object Repository/Overview_page/item_total')).replace('Item total: $', '').trim()
		double itemsPeice = Double.parseDouble(itemsPriceText)

		String taxText = WebUI.getText(findTestObject('Object Repository/Overview_page/tax')).replace('Tax: $', '').trim()
		double tax = Double.parseDouble(taxText)

		double actualTotalPrice= itemsPeice+tax

		String displayedTotalPriceText = WebUI.getText(findTestObject('Object Repository/Overview_page/total_price')).replace('Total: $', '').trim()
		double displayedTotalPrice = Double.parseDouble(displayedTotalPriceText)

		WebUI.verifyEqual(actualTotalPrice, displayedTotalPrice)

		if (actualTotalPrice == displayedTotalPrice) {
			WebUI.comment("The calculated total matches the displayed total: " + displayedTotalPrice)
		} else {
			WebUI.comment("Mismatch found! Calculated Total: " + actualTotalPrice + " does not match Displayed Total: " + displayedTotalPrice)
		}
	}
}
