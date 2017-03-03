package com.jupiter.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductEntity {

	protected WebElement productElement;
	
	public ProductEntity(WebElement productElement) {
		this.productElement = productElement;
	}
	
	
	public String getProductPrice() {
		return productElement.findElement(By.cssSelector(".product-price")).getText();
	}
	
	public String getProductTitle() {
		return productElement.findElement(By.cssSelector(".product-title")).getText();
	}
	
	
	public void clickBuyButton() {
		 productElement.findElement(By.linkText("Buy")).click();
	}
	
	
	
}


