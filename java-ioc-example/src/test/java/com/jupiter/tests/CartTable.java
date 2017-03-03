package com.jupiter.tests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartTable {

	private WebDriver driver;

	public CartTable(WebDriver driver) {
		this.driver = driver;
	}

	public int getCartRowSize() {
		List<WebElement> cartRow =driver.findElements(By.xpath("//div[2]//table/tbody/tr"));
		int rowsize = cartRow.size();
		return rowsize;
	}

	public int getCartColumnSize() {
		WebElement cartTable = driver.findElement(By.cssSelector(".cart-items"));
		List<WebElement> cartColumn = cartTable.findElements(By.tagName("th"));
		int columnsize = cartColumn.size();
		return columnsize;
	}

	public void deleteItem(String product) {
		int i=0;
		for(int j=1; j <= this.getCartRowSize(); j++) {
			String columnpath = String.format("//div[2]//table/tbody/tr[%s]/td[%s]", j,this.getHeaderIndex("Item"));
			boolean check = driver.findElement(By.xpath(columnpath)).getText().trim().equalsIgnoreCase(product);
			if(check) {
				i= j;
				break;
			}
		}
		String actionPath = String.format("//div[2]//table/tbody/tr[%s]/td[%s]/ng-confirm/a/i", i,this.getHeaderIndex("Action"));
		driver.findElement(By.xpath(actionPath)).click();

	}

	public double getTotal(String headername) {
		double columnValues = 0.00;
		for(int i=1; i <= this.getCartRowSize(); i++) {
			String columnpath = String.format("//div[2]//table/tbody/tr[%s]/td[%s]", i,this.getHeaderIndex(headername));
			String columnValue= driver.findElement(By.xpath(columnpath)).getText();
			double singleColumnValue = Double.parseDouble(columnValue.substring(1));			
			columnValues += singleColumnValue;
		}

		return columnValues;
	}

	public int getCartQuantity(String headername) {
		int totalQuantity=0;
		for(int i=1; i <= this.getCartRowSize(); i++) {
			String columnpath = String.format("//div[2]//table/tbody/tr[%s]/td[%s]/input", i,this.getHeaderIndex(headername));
			String columnValue= driver.findElement(By.xpath(columnpath)).getAttribute("value");
			int perItemquantity = Integer.parseInt(columnValue);
			totalQuantity +=perItemquantity;
		}

		return totalQuantity;

	}

	public int getCartMenuQuantity() {
		int totalQuantity = Integer.parseInt(driver.findElement(By.cssSelector(".cart-count")).getText());
		return totalQuantity;
	}

	public int getHeaderIndex(String headername) {

		int i =0;
		List<WebElement> cartColumn = driver.findElements(By.cssSelector(".cart-items th"));
		for(i=0; i < getCartColumnSize();i++)
		{
			if(cartColumn.get(i).getText().trim().equals(headername.trim()))
			{
				return i+1;
			}
		}
		return i;
	}

}




