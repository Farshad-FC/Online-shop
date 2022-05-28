package com.maktab74.OnlineShop.util;

import com.maktab74.OnlineShop.domain.User;

public class Menu {
    public void showWelcomeMenu() {
        seperator();
        System.out.println("welcome to online shop application");
        System.out.println("1: login");
        System.out.println("2: signup");
        System.out.println("3: exit");
        System.out.print("plz choose a number: ");
    }

    public void seperator() {
        System.out.println("-".repeat(30));
    }

    //User
    public void showFillInformationMessage() {
        System.out.println("plz fill your information");
    }

    public void showEnterUsernameMessage() {
        System.out.println("plz enter your username: ");
    }

    public void showEnterPasswordMessage() {
        System.out.println("plz enter your password: ");
    }

    public void showLoginSuccessMessage(User currentUser) {
        seperator();
        System.out.println("login successfully done");
        System.out.println(
                "welcome dear user: " + currentUser.getFirstName() + " " + currentUser.getLastName());

    }

    public void showLoginFailMessage() {
        System.out.println("username or password is incorrect");
    }

    public void showExitMessage() {
        System.out.println("Bye!!! have nice time");
    }

    public void showUserPanelMenu() {
        seperator();
        System.out.println("1: show my cart");
        System.out.println("2: show all products");
        System.out.println("3: add product to cart");
        System.out.println("4: remove product from cart");
        System.out.println("5: purchase confirmation");
        System.out.println("6: logout");
        System.out.print("plz choose a number: ");
    }

    public void showIncorrectNumberMessage() {
        System.out.println("plz enter right number");
    }

    public void showLogoutMessage() {
        System.out.println("logout successful");
    }

    public void showUserProfile(User currentUser) {
        System.out.println("username: " + currentUser.getUsername());
    }

    public void showShortUsernameMessage() {
        System.out.println("this is a short username!!!");
    }

    public void showUnderlineErrorMessage() {
        System.out.println("the first and last username should not be underline!!!");
    }

    public void showNotStandardUsernameMessage() {
        System.out.println("this is not a standard username!!!");
    }

    public void showTakenUsernameMessage() {
        System.out.println("this username already is taken!!!");
    }

    public void showEnterFirstNameMessage() {
        System.out.println("plz enter your first name:");
    }

    public void showEnterLastNameMessage() {
        System.out.println("plz enter your last name:");
    }

    public void showEnterPhoneNumberMessage() {
        System.out.println("plz enter your phone number:");
    }

    public void showEnterEmailMessage() {
        System.out.println("plz enter your email address:");
    }

    public void showEnterProvinceMessage() {
        System.out.println("plz enter your province:");
    }

    public void showEnterCityMessage() {
        System.out.println("plz enter your city:");
    }

    public void showEnterStreetMessage() {
        System.out.println("plz enter your street:");
    }

    public void showEnterPostalCodeMessage() {
        System.out.println("plz enter your postal code:");
    }

    //Cart

    public void showCartEmptyMessage() {
        System.out.println("your cart is empty.");
    }

    public void showProductMenu() {
        seperator();
        System.out.println("1: TV");
        System.out.println("2: Radio");
        System.out.println("3: Shoe");
        System.out.println("4: Book");
        System.out.println("5: Magazine");
        System.out.print("plz choose a number: ");
    }

    public void showSelectedProductMessage() {
        System.out.print("plz choose a product id: ");
    }

    public void showEnterNumberOfProductMessage() {
        System.out.println("please enter the number of products selected(min:1 , max:5): ");
    }

    public void showUserCartFullMessage() {
        System.out.println("your cart is full, you can not add products.");
    }

    public void showSelectedCartMessage() {
        System.out.println("plz enter the cart id: ");
    }

    //TV

    public void showTVHeaderMessage() {
        System.out.println("TV:");
    }

    //Radio

    public void showRadioHeaderMessage() {
        System.out.println("Radio:");
    }

    //Shoe

    public void showShoeHeaderMessage() {
        System.out.println("Shoe:");
    }

    //Book

    public void showBookHeaderMessage() {
        System.out.println("Book:");
    }

    //Magazine

    public void showMagazineHeaderMessage() {
        System.out.println("Magazine:");
    }
}
