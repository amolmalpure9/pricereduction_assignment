Tips to execute the code

1. 	Service runs on port 8001

2. 	To get the list of price reduced item call like this
   
   	http://localhost:8001/getPriceReducedItems
   	
   	labelType : (query_param(optional) : default value is 'ShowWasNow'), pass the different possible values as below
   	
   	for ShowPercDscount => 	http://localhost:8001/getPriceReducedItems?labelType=ShowPercDscount
	for ShowWasThenNow 	=> 	http://localhost:8001/getPriceReducedItems?labelType=ShowWasThenNow
   	for ShowWasNow 		=>	http://localhost:8001/getPriceReducedItems?labelType=ShowWasNow
   	
Possible improvements 

1.	Implement swagger for API documentation

2.	Test set can be improved