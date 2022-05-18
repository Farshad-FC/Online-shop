package com.maktab74.OnlineShop;

import com.maktab74.OnlineShop.domain.Address;
import com.maktab74.OnlineShop.domain.User;
import com.maktab74.OnlineShop.util.ApplicationContext;

import java.sql.SQLException;
import java.text.ParseException;

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

    private static boolean login(ApplicationContext context) throws SQLException {
        context.getMenu().seperator();
        context.getMenu().showFillInformationMessage();

        context.getMenu().showEnterUsernameMessage();
        String username = context.getStringScanner().nextLine();

        context.getMenu().showEnterPasswordMessage();
        String password = context.getStringScanner().nextLine();

        User user = context.getUserRepository()
                .getByUsernameAndPassword(username, password);
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

        System.out.println(user);
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
