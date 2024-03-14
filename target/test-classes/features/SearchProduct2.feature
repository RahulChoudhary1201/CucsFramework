Feature: Place An Order
	
	Scenario Outline: Searching The Product and placing order
		Given I am on the Greenkart page
		When I search <Product Name> 
		Then I should see the same product
		
		Examples: 
		| Product Name |
		| Tom					 |