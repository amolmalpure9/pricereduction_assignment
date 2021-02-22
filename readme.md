Requirements:

1. 	Use below API to obtain a list of products:

	https://api.johnlewis.com/search/api/rest/v2/catalog/products/search/keyword?q=dresses&key=AIzaSyDD_6O5gUgC4tRW5f9kxC0_76XRC8W7_mI
	
2.	The array of products should only contain products with a price reduction and should be sorted to show the highest price reduction first. 
	Price reduction is calculated using price.was - price.now
	
3. 	priceLabel <String>. An optional query parm called labelType can be set to any of:

	1. 	ShowWasNow - in which case return a string saying “Was £x.xx, now £y.yyy”.
	2. 	ShowWasThenNow - in which case return a string saying “Was £x.xx, then £y.yy, now
		£z.zzz”. If the original price.then2 is not empty use that for the “then” price otherwise use
		the then1 price. If the then1 price is also empty then don’t show the “then” price.
	3. 	ShowPercDscount - in which case return “x% off - now £y.yy”.
	If the query param is not set default to use ShowWasNow format.
	In all cases use the price formatting as described for nowPrice.
	
4.	Basic color in colorSwatches should not be returned back but should be retrieved from API to calculate the value for rgb in six digit
	hexadecimal format, e.g. “F0A1C2”.
	
	a. Looking up RGB values
		Create a hash table or similar device to translate basicColor to RGB.
		
5.	