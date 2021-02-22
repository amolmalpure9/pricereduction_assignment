package com.johnlewis.restapi.pricereduction.bean;

import java.util.List;

public class Products {

	public Products() {

	}

	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
