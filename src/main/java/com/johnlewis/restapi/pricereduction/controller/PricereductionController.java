package com.johnlewis.restapi.pricereduction.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.johnlewis.restapi.pricereduction.bean.Product;
import com.johnlewis.restapi.pricereduction.service.PricereductionService;

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
	public ResponseEntity<List<Product>> getPriceReducedItems(@RequestParam(required = false) String labelType) {

		List<Product> productList = pricereductionService.getPriceReducedItems(labelType);
		productList = null == productList ? new ArrayList<Product>() : productList;
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}

}
