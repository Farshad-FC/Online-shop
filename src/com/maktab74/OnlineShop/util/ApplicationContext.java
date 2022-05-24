package com.maktab74.OnlineShop.util;

import com.maktab74.OnlineShop.repository.*;

import java.sql.SQLException;
import java.util.Scanner;

public class ApplicationContext {
    private DatabaseUtil databaseUtil;

    private DatabaseInitializer databaseInitializer;

    private Menu menu = null;

    private Scanner stringScanner = null;

    private Scanner numberScanner = null;

    private UserRepository userRepository = null;

    private TVRepository tvRepository = null;

    private RadioRepository radioRepository = null;

    private ShoeRepository shoeRepository = null;

    private BookRepository bookRepository = null;

    private MagazineRepository magazineRepository = null;

    private CartRepository cartRepository = null;

    private SecurityContext securityContext = new SecurityContext();

    public ApplicationContext() throws SQLException, ClassNotFoundException {
        this.databaseUtil = new DatabaseUtil();
        this.databaseInitializer = new DatabaseInitializer(
                this.databaseUtil.getConnection()
        );
    }

    public DatabaseUtil getDatabaseUtil() {
        return databaseUtil;
    }

    public DatabaseInitializer getDatabaseInitializer() {
        return databaseInitializer;
    }

    public Menu getMenu() {
        if (menu == null) {
            this.menu = new Menu();
        }
        return menu;
    }

    public Scanner getStringScanner() {
        if (stringScanner == null) {
            this.stringScanner = new Scanner(System.in);
        }
        return stringScanner;
    }

    public Scanner getNumberScanner() {
        if (numberScanner == null) {
            this.numberScanner = new Scanner(System.in);
        }
        return numberScanner;
    }

    public UserRepository getUserRepository() {
        if (userRepository == null) {
            this.userRepository = new UserRepository(databaseUtil.getConnection());
        }
        return userRepository;
    }

    public TVRepository getTvRepository() {
        if (tvRepository == null) {
            this.tvRepository = new TVRepository(databaseUtil.getConnection());
        }
        return tvRepository;
    }

    public RadioRepository getRadioRepository() {
        if (radioRepository == null) {
            this.radioRepository = new RadioRepository(databaseUtil.getConnection());
        }
        return radioRepository;
    }

    public ShoeRepository getShoeRepository() {
        if (shoeRepository == null) {
            this.shoeRepository = new ShoeRepository(databaseUtil.getConnection());
        }
        return shoeRepository;
    }

    public BookRepository getBookRepository() {
        if (bookRepository == null) {
            this.bookRepository = new BookRepository(databaseUtil.getConnection());
        }
        return bookRepository;
    }

    public MagazineRepository getMagazineRepository() {
        if (magazineRepository == null) {
            this.magazineRepository = new MagazineRepository(databaseUtil.getConnection());
        }
        return magazineRepository;
    }

    public CartRepository getCartRepository() {
        if (cartRepository == null) {
            this.cartRepository = new CartRepository(databaseUtil.getConnection());
        }
        return cartRepository;
    }

    public SecurityContext getSecurityContext() {
        return securityContext;
    }
}
