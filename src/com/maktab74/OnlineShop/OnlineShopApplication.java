package com.maktab74.OnlineShop;

import com.maktab74.OnlineShop.domain.*;
import com.maktab74.OnlineShop.util.ApplicationContext;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class OnlineShopApplication {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        ApplicationContext context = new ApplicationContext();

        context.getDatabaseInitializer().init();

        boolean globalLoop = true;

        while (globalLoop) {
            context.getMenu().showWelcomeMenu();
            boolean isSelectedNumberInValid = true;
            while (isSelectedNumberInValid) {
                int selectedNumber = context.getNumberScanner().nextInt();
                if (selectedNumber == 1 || selectedNumber == 2) {
                    isSelectedNumberInValid = false;
                    redirectUser(selectedNumber, context);
                } else if (selectedNumber == 3) {
                    isSelectedNumberInValid = false;
                    context.getMenu().showExitMessage();
                    globalLoop = false;
                } else {
                    context.getMenu().showIncorrectNumberMessage();
                }
            }
        }
    }

    private static void redirectUser(int selectedNumber, ApplicationContext context) throws SQLException, ParseException {
        if (selectedNumber == 1) {
            boolean isLoginSuccess = login(context);
            if (isLoginSuccess) {
                redirectUserToPanel(context);
            }
        } else {
            signup(context);
        }
    }

    private static void redirectUserToPanel(ApplicationContext context) throws SQLException {
        context.getMenu().showUserPanelMenu();
        boolean isSelectedNumberInValid = true;
        while (isSelectedNumberInValid) {
            int selectedNumber = context.getNumberScanner().nextInt();
            if (selectedNumber >= 1 && selectedNumber <= 5) {
                showUserSelectedPage(selectedNumber, context);
                context.getMenu().showUserPanelMenu();
            } else if (selectedNumber == 6) {
                isSelectedNumberInValid = false;
                context.getCartRepository().delete();
                context.getMenu().showLogoutMessage();
                context.getSecurityContext().logout();
            } else {
                context.getMenu().showIncorrectNumberMessage();
                context.getMenu().showUserPanelMenu();
            }
        }
    }

    private static void showUserSelectedPage(int selectedNumber, ApplicationContext context) throws SQLException {
        switch (selectedNumber) {
            case 1:
                showUserCart(context);
                break;
            case 2:
                showAllProduct(context);
                break;
            case 3:
                if (CheckUserCart(context))
                    addProductToCart(context);
                break;
            case 4:
                deleteProductFromCart(context);
                break;
            case 5:
                purchaseConfirmation(context);
                break;
        }
    }

    private static void purchaseConfirmation(ApplicationContext context) throws SQLException {

        ArrayList<Cart> carts = context.getCartRepository().getAllCart();

        for (int numCart = 0; numCart < carts.size(); numCart++) {
            context.getCartRepository().update(carts.get(numCart));
        }

        context.getCartRepository().delete();
    }

    private static void deleteProductFromCart(ApplicationContext context) throws SQLException {
        showUserCart(context);
        ArrayList<Cart> carts = context.getCartRepository().getAllCart();
        int cartId;
        global:
        while (true) {
            context.getMenu().showSelectedCartMessage();
            cartId = context.getNumberScanner().nextInt();

            for (int numCart = 0; numCart < carts.size(); numCart++) {
                if (carts.get(numCart).getId() == cartId)
                    break global;
            }
            context.getMenu().showIncorrectNumberMessage();
        }

        context.getCartRepository().deleteCartById(cartId);
    }

    private static boolean CheckUserCart(ApplicationContext context) throws SQLException {
        ArrayList<Cart> carts = context.getCartRepository().getAllCart();
        if (carts.size() >= 5) {
            context.getMenu().showUserCartFullMessage();
            return false;
        }
        return true;
    }

    private static void addProductToCart(ApplicationContext context) throws SQLException {
        Cart cart = new Cart();
        cart.setUserId(context.getSecurityContext().getCurrentUser().getId());
        context.getMenu().showProductMenu();

        int selectedNumber;
        while (true) {
            selectedNumber = context.getNumberScanner().nextInt();
            if (selectedNumber >= 1 && selectedNumber <= 5)
                break;
        }
        String category = setCategory(selectedNumber);
        cart.setProductType(category);

        int productLength = showSelectedProduct(context, selectedNumber);

        int selectedProductId;
        while (true) {
            context.getMenu().showSelectedProductMessage();
            selectedProductId = context.getNumberScanner().nextInt();

            if (selectedProductId >= 0 && selectedProductId <= productLength)
                break;
        }
        cart.setProductId(selectedProductId);

        context.getMenu().showEnterNumberOfProductMessage();
        int numberOfProduct;
        while (true) {
            numberOfProduct = context.getNumberScanner().nextInt();
            if (numberOfProduct >= 1 && numberOfProduct <= 5)
                break;
        }
        cart.setCount(numberOfProduct);
        context.getCartRepository().insert(cart);
    }

    private static String setCategory(int selectedNumber) {
        switch (selectedNumber) {
            case 1:
                return "tv";
            case 2:
                return "radio";
            case 3:
                return "shoe";
            case 4:
                return "book";
            case 5:
                return "magazine";
        }
        return "";
    }

    private static int showSelectedProduct(ApplicationContext context, int selectedNumber) throws SQLException {
        switch (selectedNumber) {
            case 1:
                showTVProduct(context);
                return context.getTvRepository().getCountTV();
            case 2:
                showRadioProduct(context);
                return context.getRadioRepository().getCountRadio();
            case 3:
                showShoeProduct(context);
                return context.getShoeRepository().getCountShoe();
            case 4:
                showBookProduct(context);
                return context.getBookRepository().getCountBook();
            case 5:
                showMagazineProduct(context);
                return context.getMagazineRepository().getCountMagazine();
        }
        return 0;
    }

    private static void showUserCart(ApplicationContext context) throws SQLException {
        ArrayList<Cart> carts = context.getCartRepository().getAllCart();
        if (carts.size() != 0) {
            for (int numCart = 0; numCart < carts.size(); numCart++) {
                System.out.println(carts.get(numCart).toString());
            }
        } else {
            context.getMenu().showCartEmptyMessage();
        }
    }

    private static void showAllProduct(ApplicationContext context) throws SQLException {
        showTVProduct(context);
        showRadioProduct(context);
        showShoeProduct(context);
        showBookProduct(context);
        showMagazineProduct(context);
    }

    private static void showTVProduct(ApplicationContext context) throws SQLException {
        context.getMenu().showTVHeaderMessage();
        ArrayList<TV> tvs = context.getTvRepository().getAllTV();
        for (int numTV = 0; numTV < tvs.size(); numTV++) {
            System.out.println(tvs.get(numTV).toString());
        }
    }

    private static void showRadioProduct(ApplicationContext context) throws SQLException {
        context.getMenu().showRadioHeaderMessage();
        ArrayList<Radio> radios = context.getRadioRepository().getAllRadio();
        for (int numRadio = 0; numRadio < radios.size(); numRadio++) {
            System.out.println(radios.get(numRadio).toString());
        }
    }

    private static void showShoeProduct(ApplicationContext context) throws SQLException {
        context.getMenu().showShoeHeaderMessage();
        ArrayList<Shoe> shoes = context.getShoeRepository().getAllShoe();
        for (int numShoe = 0; numShoe < shoes.size(); numShoe++) {
            System.out.println(shoes.get(numShoe).toString());
        }
    }

    private static void showBookProduct(ApplicationContext context) throws SQLException {
        context.getMenu().showBookHeaderMessage();
        ArrayList<Book> books = context.getBookRepository().getAllBook();
        for (int numBook = 0; numBook < books.size(); numBook++) {
            System.out.println(books.get(numBook).toString());
        }
    }

    private static void showMagazineProduct(ApplicationContext context) throws SQLException {
        context.getMenu().showMagazineHeaderMessage();
        ArrayList<Magazine> magazines = context.getMagazineRepository().getAllMagazine();
        for (int numMagazine = 0; numMagazine < magazines.size(); numMagazine++) {
            System.out.println(magazines.get(numMagazine).toString());
        }
    }

    private static boolean login(ApplicationContext context) throws SQLException {
        context.getMenu().seperator();
        context.getMenu().showFillInformationMessage();

        context.getMenu().showEnterUsernameMessage();
        String username = context.getStringScanner().nextLine();

        context.getMenu().showEnterPasswordMessage();
        String password = context.getStringScanner().nextLine();

        User user = context.getUserRepository()
                .getUserByUsernameAndPassword(username, password);
        if (user != null) {
            context.getMenu().showLoginSuccessMessage(user);
            context.getSecurityContext().setCurrentUser(user);
            return true;
        } else {
            context.getMenu().showLoginFailMessage();
            return false;
        }
    }

    private static void signup(ApplicationContext context) throws SQLException, ParseException {
        context.getMenu().seperator();

        boolean flag = false;
        User user = new User();
        Address address = new Address();
        context.getMenu().showFillInformationMessage();

        do {
            context.getMenu().showEnterUsernameMessage();
            user.setUsername(context.getStringScanner().nextLine());
            flag = checkUsername(context, user.getUsername());
        } while (flag);

        context.getMenu().showEnterPasswordMessage();
        user.setPassword(context.getStringScanner().nextLine());

        context.getMenu().showEnterFirstNameMessage();
        user.setFirstName(context.getStringScanner().nextLine());

        context.getMenu().showEnterLastNameMessage();
        user.setLastName(context.getStringScanner().nextLine());

        context.getMenu().showEnterPhoneNumberMessage();
        user.setPhoneNumber(context.getStringScanner().nextLine());

        context.getMenu().showEnterEmailMessage();
        user.setEmail(context.getStringScanner().nextLine());

        context.getMenu().showEnterProvinceMessage();
        address.setProvince(context.getStringScanner().nextLine());

        context.getMenu().showEnterCityMessage();
        address.setCity(context.getStringScanner().nextLine());

        context.getMenu().showEnterStreetMessage();
        address.setStreet(context.getStringScanner().nextLine());

        context.getMenu().showEnterPostalCodeMessage();
        address.setPostalCode(context.getStringScanner().nextLine());

        user.setAddress(address);

        user = context.getUserRepository().insert(user);

        System.out.println(user.toString());
    }

    private static boolean checkUsername(ApplicationContext context, String username) throws SQLException {
        boolean find = false;
        if (username.length() < 5) {
            context.getMenu().showShortUsernameMessage();
            find = true;
        } else {
            if (username.charAt(0) == '_' || username.charAt(username.length() - 1) == '_') {
                context.getMenu().showUnderlineErrorMessage();
                find = true;
            } else {
                find = checkChar(username);
                if (find)
                    context.getMenu().showNotStandardUsernameMessage();
                else {
                    find = checkForDuplicateUsername(context, username);
                    if (find)
                        context.getMenu().showTakenUsernameMessage();
                }
            }
        }
        return find;
    }

    private static boolean checkForDuplicateUsername(ApplicationContext context, String username) throws SQLException {
        if (context.getUserRepository().getUserByUsername(username) == 1) {
            return true;
        }
        return false;
    }

    private static boolean checkChar(String username) {
        boolean flag = false;
        int ascii;
        for (int chararcter = 0; chararcter < username.length(); chararcter++) {
            ascii = (int) username.charAt(chararcter);
            if (ascii < 48 || ascii > 57) {
                if (ascii < 65 || ascii > 90) {
                    if (ascii < 97 || ascii > 122) {
                        if (ascii != 95) {
                            flag = true;
                            break;
                        }
                    }
                }
            }
        }
        return flag;
    }
}
