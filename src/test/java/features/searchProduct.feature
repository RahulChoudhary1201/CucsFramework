Feature: Search and place the order for products

  @SearchProduct
  Scenario Outline: Search Experience for product in both home and offers page
    Given User is on Greenkart Landing page
    When user searched with short name <Names> and extract actual name of product
    Then user searched for <Names> in offers page to check if product exist
    And validate product name in offers page matches with landing page

    Examples: 
      | Names |
      | Tom   |
      | Beet  |
