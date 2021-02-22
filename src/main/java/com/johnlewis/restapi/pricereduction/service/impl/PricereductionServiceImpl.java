package com.johnlewis.restapi.pricereduction.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.johnlewis.restapi.pricereduction.bean.AllProducts;
import com.johnlewis.restapi.pricereduction.bean.Products;
import com.johnlewis.restapi.pricereduction.contants.PricereductionConstants;
import com.johnlewis.restapi.pricereduction.service.PricereductionService;

@Service
public class PricereductionServiceImpl implements PricereductionService {

	@Autowired
	RestTemplate restTemplate;

	@Value("${api.key}")
	private String apiKey;

	@Override
	public List<Products> getPriceReducedItems(String labelType) {
		String uri = "https://api.johnlewis.com/search/api/rest/v2/catalog/products/search/keyword?q=dresses&key="
				+ apiKey;
		AllProducts products = restTemplate.getForObject(uri, AllProducts.class);
		List<Products> productList = null;
		// check if the products are not null and call
		if (null != products && null != products.getProducts() && products.getProducts().size() > 0) {
			productList = products.getProducts();

			// only get the list with price reduction
			productList = productList.stream().filter(o -> o.getPrice() != null)
					.filter(o -> (o.getPrice().getNow() instanceof String && o.getPrice().getWas() instanceof String))
					.filter(o -> (o.getPrice().getNow() != null && !o.getPrice().getNow().toString().isEmpty()
							&& o.getPrice().getWas() != null && !o.getPrice().getWas().toString().isEmpty()))
					.filter(o -> (Double.parseDouble(o.getPrice().getWas().toString())
							- Double.parseDouble(o.getPrice().getNow().toString()) > 0))
					.sorted(Comparator.comparingDouble((o) -> (Double.parseDouble(o.getPrice().getNow().toString())
							- Double.parseDouble(o.getPrice().getWas().toString()))))
					.collect(Collectors.toList());

			// set the price label
			setPriceLabel(productList, labelType);

		}
		return productList;
	}

	private void setPriceLabel(List<Products> productList, String labelType) {
		if (labelType.equals(PricereductionConstants.SHOW_WAS_NOW)) {
			productList.forEach((o) -> {
				if (null != o.getPrice() && null != o.getPrice().getNow() && null != o.getPrice().getWas())
					o.setPriceLabel("Was £" + o.getPrice().getWas() + ", now £" + o.getPrice().getNow());
			});
		} else if (labelType.equals(PricereductionConstants.SHOW_WAS_THEN_NOW)) {
			productList.forEach((o) -> {
				if (null != o.getPrice() && null != o.getPrice().getNow() && null != o.getPrice().getWas()) {
					if (null != o.getPrice().getThen2() && !o.getPrice().getThen2().isEmpty()) {
						o.setPriceLabel("Was £" + o.getPrice().getWas() + ", then £" + o.getPrice().getThen2()
								+ ", now £" + o.getPrice().getNow());
					} else if (null != o.getPrice().getThen1() && !o.getPrice().getThen1().isEmpty()) {
						o.setPriceLabel("Was £" + o.getPrice().getWas() + ", then £" + o.getPrice().getThen1()
								+ ", now £" + o.getPrice().getNow());
					} else {
						o.setPriceLabel("Was £" + o.getPrice().getWas() + ", now £" + o.getPrice().getNow());
					}
				}
			});
		} else if (labelType.equals(PricereductionConstants.SHOW_PERC_DISCOUNT)) {

			Double discountPerc = 0.0;
			for (Products product : productList) {
				if (null != product.getPrice() && null != product.getPrice().getNow()
						&& null != product.getPrice().getWas()) {
					Double difference = Double.parseDouble(product.getPrice().getWas().toString())
							- Double.parseDouble(product.getPrice().getNow().toString());
					if (difference > 0) {
						discountPerc = (difference * 100)
								/ (Double.parseDouble(product.getPrice().getWas().toString()));
						product.setPriceLabel(Math.round(discountPerc) + "% off - now £" + product.getPrice().getNow());
					}
				}
			}
		}
	}
}
