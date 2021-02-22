package com.johnlewis.restapi.pricereduction.service;

import java.util.List;

import com.johnlewis.restapi.pricereduction.bean.Product;

/**
 * 
 * @author Amol
 * This interface is used for defining service methods
 */
public interface PricereductionService {

	/**
	 * This method is used to get the list of products for which the price is
	 * reduced
	 * 
	 * @param labelType
	 * @return
	 */
	public List<Product> getPriceReducedItems(String labelType);
}
