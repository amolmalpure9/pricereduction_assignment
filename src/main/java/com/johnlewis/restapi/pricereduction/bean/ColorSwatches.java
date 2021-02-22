package com.johnlewis.restapi.pricereduction.bean;

import java.util.Hashtable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javafx.scene.paint.Color;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ColorSwatches {

	private String color;

	@JsonProperty(access = Access.READ_ONLY)
	private String rgbColor;

	private String skuId;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String basicColor;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	private Map<String, String> rgbHexMap = new Hashtable<String, String>();

	public String getRgbColor() {
		String hex = "";
		if (this.basicColor != null && !this.basicColor.isEmpty()) {
			if (rgbHexMap.get(this.basicColor) != null) {
				hex = rgbHexMap.get(this.basicColor);
				rgbColor = hex;
			} else {
				/**
				 * If the color value is different than valid color then it throws
				 * IllegalArgumentException. Set the hash value as blank in that case
				 */
				try {
					Color color = Color.web(this.basicColor);
					if (null != color) {
						hex = color.toString().substring(2, 8);
						rgbColor = hex;
						rgbHexMap.put(this.basicColor, hex);
					}
				} catch (IllegalArgumentException e) {
					rgbColor = "";
				}
			}
		}

		return rgbColor;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getBasicColor() {
		return basicColor;
	}

	public void setBasicColor(String basicColor) {
		this.basicColor = basicColor;
	}

}
