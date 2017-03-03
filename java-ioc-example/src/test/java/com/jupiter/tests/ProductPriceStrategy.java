package com.jupiter.tests;

public class ProductPriceStrategy implements ICompareProduct
{

	String price = null;
	public ProductPriceStrategy(String price)
	{
		
		this.price = price;
	}
	
	public boolean compareProduct(ProductEntity productEntity) {
		return productEntity.getProductPrice().equals(price);
	}
	
}

