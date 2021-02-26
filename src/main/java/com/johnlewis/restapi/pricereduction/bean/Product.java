package com.johnlewis.restapi.pricereduction.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

	public Product() {
		
	}
	
	public Product(String productId, String title, List<ColorSwatches> colorSwatches, String priceLabel, Price price) {
		super();
		this.productId = productId;
		this.title = title;
		this.colorSwatches = colorSwatches;
		this.priceLabel = priceLabel;
		this.price = price;
	}

	private String productId;
	private String title;
	List<ColorSwatches> colorSwatches;
	private String priceLabel;
	private Price price;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<ColorSwatches> getColorSwatches() {
		return colorSwatches;
	}

	public void setColorSwatches(List<ColorSwatches> colorSwatches) {
		this.colorSwatches = colorSwatches;
	}

	public String getPriceLabel() {
		return priceLabel;
	}

	public void setPriceLabel(String priceLabel) {
		this.priceLabel = priceLabel;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}
}
