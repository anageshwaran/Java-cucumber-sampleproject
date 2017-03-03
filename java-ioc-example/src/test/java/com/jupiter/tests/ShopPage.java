package com.jupiter.tests;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopPage extends BasePage {

	public ShopPage(WebDriver driver) {
		super(driver);
		
	}
	
	
//	public ShopPg(WebDriver driver) {
//		super(driver);
//		product= new Product(driver);
//	}

	public void verifyShopPage(String expected) {

		String actual = driver.getCurrentUrl();
		Assert.assertTrue("Navigation to shop page is unsuccessfull", actual.trim().equalsIgnoreCase(expected.trim()));
	}

	public void verifyQuantityInCartMenu(String cartQuantity) {
		String actual = driver.findElement(By.cssSelector(".cart-count")).getText();
		System.out.println("actual quantity is : " +actual);
		Assert.assertTrue("Count is wrong", actual.equals(cartQuantity));		
	}

	public void  clickBuy(int noOfClick, String productToClick) {
		for(int i=0; i < noOfClick; i++) {
			ProductEntity pe= this.getProduct(new ProductTitleStrategy(productToClick));
			pe.clickBuyButton();
			 
		}
	}

	public void  clickBuy(String[] productsToClick) {
	
		for(String singleProduct : productsToClick) {
		ProductEntity pe= this.getProduct(new ProductTitleStrategy(singleProduct));
		pe.clickBuyButton();
		}
	}
	
	public ProductEntity getProduct(ICompareProduct compare)
	{
		List<WebElement> products = driver.findElements(By.cssSelector(".products .product"));
		ProductEntity productEntity = null;
		for(WebElement product : products)
		{
			productEntity = new ProductEntity(product);
			if(compare.compareProduct(productEntity))
			{
				return productEntity;
				
			}
		}
		
		return productEntity;
		
	}
	
	public void verifyProductPrice(String expectedPrice, String singleProduct) {
//		ShopPg pg = new ShopPg(driver);
		ProductEntity pe= this.getProduct(new ProductTitleStrategy(singleProduct));
		String actualPrice = pe.getProductPrice();
		System.out.println("actual price %s and expected price %s is:" +actualPrice +expectedPrice);
//		pe.clickBuyButton();
//		String actualPrice = product.getProductPrice(singleProduct);
		Assert.assertTrue("Price is wrong", actualPrice.equals(expectedPrice));		
	}
	
	public void clickBuy(String productToClick) {
		
//		ShopPg pg = new ShopPg(driver);
		ProductEntity pe= this.getProduct(new ProductTitleStrategy(productToClick));
		pe.clickBuyButton();
		
	}
	
//	public ProductEntity getProductByTitle(String title)
//	{
//		List<WebElement> products = driver.findElements(By.cssSelector(".products .product"));
//		ProductEntity productEntity = null;
//		for(WebElement product : products)
//		{
//			productEntity = new ProductEntity(product);
//			
//			if(productEntity.getProductTitle().equals(title))
//			{
//				
//				return productEntity;
//			}
//			
//		}
//		
//		return productEntity;
//	}
//	
//	public ProductEntity getProductByPrice(String price)
//	{
//		
//		List<WebElement> products = driver.findElements(By.cssSelector(".products .product"));
//		ProductEntity productEntity = null;
//		for(WebElement product : products)
//		{
//			productEntity = new ProductEntity(product);
//			
//			if(productEntity.getProductPrice().equals(price))
//			{
//				
//				return productEntity;
//			}
//			
//		}
//		
//		return productEntity;
//	}
	
	
}


