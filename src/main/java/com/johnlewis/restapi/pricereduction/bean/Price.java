package com.johnlewis.restapi.pricereduction.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {

	public Price() {

	}

	@JsonProperty(access = Access.WRITE_ONLY)
	private Object now;

	private Object nowPrice;

	@JsonProperty(access = Access.WRITE_ONLY)
	private Object was;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String then1;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String then2;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String currency;

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Object getNow() {
		return (null != now) ? formatPrice(now) : "";
	}

	public void setNow(Object now) {
		this.now = now;
	}

	public Object getWas() {
		return (null != was) ? formatPrice(was) : "";
	}

	public void setWas(Object was) {
		this.was = was;
	}

	public String getThen1() {
		return (null != then1) ? formatPrice(then1).toString() : "";
	}

	public void setThen1(String then1) {
		this.then1 = then1;
	}

	public String getThen2() {
		return (null != then2) ? formatPrice(then2).toString() : "";
	}

	public void setThen2(String then2) {
		this.then2 = then2;
	}

	public Object getNowPrice() {
		return "£" + formatPrice(now);
	}

	public Object formatPrice(Object price) {
		Object formatedPrice = "";
		if (null != price && price instanceof String && !price.toString().isEmpty()) {
			if (Double.parseDouble(price.toString()) < 10) {
				formatedPrice = now.toString();
			} else {
				formatedPrice = String.valueOf(Math.round(Double.parseDouble(price.toString())));
			}
		} else {
			formatedPrice = price;
		}
		return formatedPrice;
	}

}
