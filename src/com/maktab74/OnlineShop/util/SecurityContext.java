package com.maktab74.OnlineShop.util;

import com.maktab74.OnlineShop.domain.User;

public class SecurityContext {
    private User currentUser = null;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void logout() {
        this.currentUser = null;
    }
}
