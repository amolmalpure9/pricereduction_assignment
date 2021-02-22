package com.johnlewis.restapi.pricereduction.service;

import java.util.List;

import com.johnlewis.restapi.pricereduction.bean.Products;

public interface PricereductionService {

	/**
	 * This method is used to get the list of products for which the price is
	 * reduced
	 * 
	 * @param labelType
	 * @return
	 */
	public List<Products> getPriceReducedItems(String labelType);
}
