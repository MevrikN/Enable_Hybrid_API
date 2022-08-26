package org.example;

import Base_Pages.Utils;
import CheckoutEnd2End.*;
import RegistartionProcess.RegistrationPage;
import RegistartionProcess.VerifyRegisterSuccess;
import SearchProduct.SearchResultsNike;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefs {


    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    VerifyRegisterSuccess verifyRegisterSuccess = new VerifyRegisterSuccess();
    BuildYourOwnComputerPage buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    AddToCartPage addToCartPage = new AddToCartPage();
    CheckOutBillingAddress checkOutBillingAddress = new CheckOutBillingAddress();
    ShippingPage shippingPage = new ShippingPage();
    PaymentSelectionCheckout paymentSelectionCheckout = new PaymentSelectionCheckout();
    CreditCardDetails creditCardDetails = new CreditCardDetails();
    ConfirmOrderPage confirmOrderPage = new ConfirmOrderPage();
    OrderCheckOutCompletedMsg orderCheckOutCompletedMsg = new OrderCheckOutCompletedMsg();
    SearchResultsNike searchResultsNike = new SearchResultsNike();
    LoginPage loginPage = new LoginPage();


    //@@@@@@@@@@@@@@@@@@@@
    //Error Vote

    @Given("user is on home page for give a vote")
    public void userIsOnHomePageForGiveAVote() {
    }

    @When("user click on vote button by select any category")
    public void userClickOnVoteButtonBySelectAnyCategoryAs() {
        homePage.clickOnPollRadioButton();
        homePage.clickOnVote();
    }

    @Then("user can see Error message")
    public void userCanSeeErrorMessage() {
        homePage.verifyErrorMessageOfPole();
    }

    //@@@@@@@@@@@@@@@@@@@@@@@@


    @Given("user is on homepage")
    public void userIsOnHomepage() {
    }

    @When("user click on vote button without selecting radio button")
    public void userClickOnVoteButtonWithoutSelectingRadioButton() {
        homePage.clickOnVote();
    }

    @Then("popup window will show the error message")
    public void popupWindowWillShowTheErrorMessage() {
        homePage.getPopUpText();
    }

    @And("click ok to comeback on homepage")
    public void clickOkToComebackOnHomepage() {
        homePage.switchToPopUpAlertAccept();
    }

    //@@@@@@@@@@@@@@@@@@@@@@@@

    @Given("user is logged in and is on homepage")
    public void userIsLoggedInAndIsOnHomepage() {
        homePage.logintab();
        loginPage.enterEmail();
        loginPage.enterPassword();
        loginPage.clickLoginBtn();
    }

    @When("user click on poor radio button")
    public void userClickOnPoorRadioButton() {
        homePage.verifyHomepageURL();
        homePage.clickOnPollRadioButton();
    }

    @And("click on vote button")
    public void clickOnVoteButton() {
        homePage.clickOnVote();
    }

    @Then("user can see success message of vote")
    public void userCanSeeSuccessMessageOfVote() {
        homePage.verifyVoteSuccess();
    }


    //@@@@@@@@@@@@@@@@@@@@@@@
    //Search

    @Given("user is on homepage to search products")
    public void userIsOnHomepageToSearchProducts() {
        homePage.verifyHomepageURL();
    }

    @When("user type keyword as {string}")
    public void user_type_keyword_as(String string) {
        homePage.typeInSearch(string);

    }

    @When("click on search button")
    public void click_on_search_button() {
        homePage.clickOnSearchBtn();

    }

    @Then("user should be able to see relevant product name containing {string}")
    public void userShouldBeAbleToSeeRelevantProductNameContaining(String string) {
        searchResultsNike.findWordInProductTitle(string);
    }

    //@@@@@@@@@@@@@@@@@@@@@
    // Checkout
    @Given("User register successfully")
    public void user_register_successfully() {
        homePage.clickOnRegister();
        registrationPage.verifyRegistrationPageURL();
        registrationPage.firstName("Raj");
        registrationPage.lastName("Shah");
        registrationPage.set_emailAddress("asd");
        registrationPage.set_passwordField("asd@123");
        registrationPage.set_confPassword("asd@123");
        registrationPage.clickOnRegisterBtn();
        verifyRegisterSuccess.verifyRegistrationSuccess();
    }

    @Then("click on continue button after successful registration")
    public void click_on_continue_button_after_successful_registration() {
        verifyRegisterSuccess.clickOnContinue();
    }

    @Then("user should be on Homepage")
    public void userShouldBeOnHomepage() {
        homePage.verifyHomepageURL();
    }

    @When("user click on build your owen computer name")
    public void user_click_on_build_your_owen_computer_name() {
        homePage.clickOnProductName();
    }

    @Then("user should be navigated to relevant product page")
    public void user_should_be_navigated_to_relevant_product_page() {
        buildYourOwnComputerPage.verifyURLOfBuildYourOwnDesktopProduct();
    }

    @Then("Fill mandatory fields")
    public void fill_mandatory_fields() {
        buildYourOwnComputerPage.selectAllOptionsBuildYourOwnComp();
    }

    @Then("Click add to cart button")
    public void click_add_to_cart_button() {
        buildYourOwnComputerPage.addToCartBtn();
    }

    @Then("click on shopping cart button")
    public void click_on_shopping_cart_button() {
        buildYourOwnComputerPage.shoppingCartButton();
    }

    @Then("user can see checkout page")
    public void user_can_see_checkout_page() {
        addToCartPage.verifyTitleOfPage();
    }

    @When("user checked Terms and condition box")
    public void user_checked_terms_and_condition_box() {
        addToCartPage.checkBoxTandC();
    }

    @When("Click on checkout button")
    public void click_on_checkout_button() {
        addToCartPage.addToCartBtn();
    }

    @Then("user should be navigated to Billing page")
    public void user_should_be_navigated_to_billing_page() {
        checkOutBillingAddress.verifyUrl();
    }

    @When("user enter all billing mandatory information")
    public void user_enter_all_billing_mandatory_information() {
        checkOutBillingAddress.selectCountry("United Kingdom");
        checkOutBillingAddress.cityName("london");
        checkOutBillingAddress.address1("london");
        checkOutBillingAddress.zipCode("012UB5");
        checkOutBillingAddress.phoneNum("0123456789");
    }

    @And("click on continue button on billing page")
    public void clickOnContinueButtonOnBillingPage() {
        checkOutBillingAddress.continueBtn();
    }

    @Then("user should be on Shipping page")
    public void userShouldBeOnShippingPage() {
        shippingPage.verifyUrl();
    }

    @And("user can able to select one day delivery")
    public void userCanAbleToSelectOneDayDelivery() {
        shippingPage.selectRadioOneDay();
    }

    @And("user can able to select second day delivery")
    public void userCanAbleToSelectSecondDayDelivery() {
        shippingPage.selectRadioSecond();
    }

    @When("user click on Continue button")
    public void userClickOnContinueButton() {
        shippingPage.continueBtn();
    }

    @Then("user should be navigated to payment selection page")
    public void userShouldBeNavigatedToPaymentSelectionPage() {
        paymentSelectionCheckout.verifyUrl();
    }

    @And("user select credit option")
    public void userSelectCreditOption() {
        paymentSelectionCheckout.clickOnCrediCard();
    }

    @And("click on continue button on payment page")
    public void clickOnContinueButtonOnPaymentPage() {
        paymentSelectionCheckout.clickContinueBtn();
    }

    @Then("user should be on card details page")
    public void userShouldBeOnCardDetailsPage() {
        creditCardDetails.verifyUrl();
    }

    @When("select card type")
    public void selectCardType() {
        creditCardDetails.selectCardType("Visa");
    }

    @And("enter card holder name")
    public void enterCardHolderName() {
        creditCardDetails.carHolderName("paul Smith");
    }

    @And("enter card number")
    public void enterCardNumber() {
        creditCardDetails.cardNumber("00000000000000000000");
    }

    @And("select expiry month and year")
    public void selectExpiryMonthAndYear() {
        creditCardDetails.expDateYear("05", "2026");
    }

    @And("enter CVC code")
    public void enterCVCCode() {
        creditCardDetails.cvcNumber("456");
    }

    @And("click continue button on card details page")
    public void clickContinueButtononCardonDetailsPage() {
        creditCardDetails.continueBtn();
    }

    @Then("user should be navigated to confirm order page")
    public void userShouldBeNavigatedToConfirmOrderPage() {
        confirmOrderPage.verifyUrl();
    }

    @And("user can see email address")
    public void userCanSeeEmailAddress() {
        confirmOrderPage.getEmailId();
    }

    @And("user click on confirm button")
    public void userClickOnConfirmButton() {
        confirmOrderPage.clickContinueBtn();
    }

    @Then("user can see order success message")
    public void userCanSeeOrderSuccessMessage() {
        orderCheckOutCompletedMsg.verifyTitle();
    }

    @And("click on continue button on confirmation page")
    public void clickOnContinueButtonOnConfirmationPage() {
        orderCheckOutCompletedMsg.clickContinue();
    }

    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    //Registration
    @Given("User is on Registration page")
    public void user_is_on_registration_page() {
    }

    @And("click on Registration tab")
    public void clickOnRegistrationTab() {
        homePage.clickOnRegister();
    }

    @When("user click on male radio button")
    public void user_click_on_male_radio_button() {
        registrationPage.radioBtn();
    }  //Method Over loading

    @When("enter firstname as {string}")
    public void enter_firstname_as(String string) {
        registrationPage.firstName(string);
    }

    @When("enter lastname as {string}")
    public void enter_lastname_as(String string) {
        registrationPage.lastName(string);
    }

    @When("enter email address first part as {string}")
    public void enter_email_address_first_part_as(String string) {
        registrationPage.set_emailAddress(string);
    }

    @When("enter password as {string}")
    public void enter_password_as(String string) {
        registrationPage.set_passwordField(string);
    }

    @When("enter conform password as {string}")
    public void enter_conform_password_as(String string) {
        registrationPage.set_confPassword(string);
    }

    @When("Click on Register button")
    public void click_on_register_button() {
        registrationPage.clickOnRegisterBtn();
    }

    @Then("user can see success message")
    public void user_can_see_success_message() {
        verifyRegisterSuccess.verifyRegistrationSuccess();
    }


    @And("click on continue button")
    public void clickOnContinueButton() {
        verifyRegisterSuccess.clickOnContinue();
    }

    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@       Parameterized X-Path

    @Given("User is on homepage")
    public void user_is_on_homepage() {
    }

    @When("User click on {string} link from top menu header")
    public void user_click_on_link_from_top_menu_header(String string) {
        homePage.clickOnCategory(string);
    }

    @Then("User should be navigated to related {string} category page successfully")
    public void user_should_be_navigated_to_related_category_page_successfully(String string) {
        Utils.driverWaitUrlToBe(string, 5);
    }

    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    @Given("user is on home page")
    public void user_is_on_home_page() {
    }

    @When("user click on Build your own computer product name")
    public void user_click_on_build_your_own_computer_product_name() {
        homePage.clickOnProductName();
    }

    @Then("user should be navigate to product details page")
    public void user_should_be_navigate_to_product_details_page() {
        buildYourOwnComputerPage.verifyURLOfBuildYourOwnDesktopProduct();
    }

    @Then("select all mandatory option")
    public void select_all_mandatory_option() {
        buildYourOwnComputerPage.selectAllOptionsBuildYourOwnComp();
    }

    @Then("click on Add to cart button")
    public void click_on_add_to_cart_button() {
        buildYourOwnComputerPage.addToCartBtn();
    }

    @Then("user should see success message on screen")
    public void user_should_see_success_message_on_screen() {
        buildYourOwnComputerPage.addToCartBtn();
    }


}
