Feature: Validating the Checkout feature
  I want to use this template for my feature file

  @OrderProdcut
  Scenario Outline: Add Product to cart and verify that the same product is on the checkout page
    Given I am on the greenkart home page.
    And I am searching for <Product>
    When Product is displayed on the home page.
    Then Increase the count of the product to 3 and add to cart
    And I will click on the cart icon
    And I verify weather the searched product is displayed in the kart or not.
    And I will apply the promo code "rahul" and validate its working or not
    Then I will place the order

    Examples: 
      | Product |
      | Broc    |
