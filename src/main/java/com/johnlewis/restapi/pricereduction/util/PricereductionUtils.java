package com.johnlewis.restapi.pricereduction.util;

import com.johnlewis.restapi.pricereduction.contants.PricereductionConstants;

public class PricereductionUtils {

	public static String checkAndReturnLabelType(String labelType) {
		if (null != labelType && !labelType.isEmpty()
				&& (labelType.equals(PricereductionConstants.SHOW_WAS_NOW)
						|| labelType.equals(PricereductionConstants.SHOW_PERC_DISCOUNT)
						|| labelType.equals(PricereductionConstants.SHOW_WAS_THEN_NOW))) {
			return labelType;
		} else {
			return PricereductionConstants.SHOW_WAS_NOW;
		}
	}
}
