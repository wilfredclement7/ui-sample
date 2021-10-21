# ui-sample

Navigate to \src\test\java\TestRunner.java and run as "TestNG" test

Console Output :

[RemoteTestNG] detected TestNG version 7.4.0

@assessment
Scenario: Online Assessment                             [90m# src/test/resources/features/Assessment.feature:4[0m
Starting ChromeDriver 94.0.4606.61 (418b78f5838ed0b1c69bb4e51ea0252171854915-refs/branch-heads/4606@{#1204}) on port 46082
Only local connections are allowed.
Please see https://chromedriver.chromium.org/security-considerations for suggestions on keeping ChromeDriver safe.
ChromeDriver was started successfully.
Oct 21, 2021 4:24:52 AM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
C:\Users\Wilfred\eclipse-workspace\Opportunity
  [32mGiven [0m[32mI add four different products to my wish list[0m   [90m# stepDefinitions.HomeSteps.i_add_four_different_products_to_my_wish_list()[0m
  [32mWhen [0m[32mI view my wishlist table[0m                         [90m# stepDefinitions.HomeSteps.i_view_my_wishlist_table()[0m
  [32mThen [0m[32mI find total four selected items in my Wishlist[0m  [90m# stepDefinitions.HomeSteps.i_find_total_four_selected_items_in_my_wishlist()[0m
  [32mWhen [0m[32mI search for lowest price product[0m                [90m# stepDefinitions.HomeSteps.i_search_for_lowest_price_product()[0m
  [32mAnd [0m[32mI am able to add the lowest price item to my cart[0m [90m# stepDefinitions.HomeSteps.i_am_able_to_add_the_lowest_price_item_to_my_cart()[0m
  [32mThen [0m[32mI am able to verify the item in my cart[0m          [90m# stepDefinitions.HomeSteps.i_am_able_to_verify_the_item_in_my_cart()[0m
PASSED: scenario("Online Assessment", "Optional[Assessment]")
        Runs Cucumber Feature

===============================================
    Default test
    Tests run: 1, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
===============================================

