package com.jupiter.tests;


public class ProductTitleStrategy implements ICompareProduct
{

	String title = null;
	public ProductTitleStrategy(String title)
	{
		
		this.title = title;
	}
	
	public boolean compareProduct(ProductEntity productEntity) {
		return productEntity.getProductTitle().equals(title);
	}
	
}
