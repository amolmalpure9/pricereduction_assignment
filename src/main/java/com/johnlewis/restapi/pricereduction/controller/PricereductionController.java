package com.johnlewis.restapi.pricereduction.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.johnlewis.restapi.pricereduction.bean.ColorSwatches;
import com.johnlewis.restapi.pricereduction.bean.Products;
import com.johnlewis.restapi.pricereduction.contants.PricereductionConstants;
import com.johnlewis.restapi.pricereduction.service.PricereductionService;
import com.johnlewis.restapi.pricereduction.util.PricereductionUtils;

/**
 * @author Amol
 * 
 *         This controller is used for getting list of products for which the
 *         price has been reduced.
 */
@RestController
public class PricereductionController {

	@Autowired
	private PricereductionService pricereductionService;

	/**
	 * This method is used to get the list of products for which the price is
	 * reduced.
	 * 
	 * @param labelType
	 * @return
	 */

	@GetMapping(value = "/getPriceReducedItems")
	public List<Products> getPriceReducedItems(@RequestParam(required = false) String labelType) {

		labelType = PricereductionUtils.checkAndReturnLabelType(labelType);
		List<Products> productList = pricereductionService.getPriceReducedItems(labelType);
		return productList;
	}

}
