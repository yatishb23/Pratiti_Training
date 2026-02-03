package com.yatish.training.models;

public class CurrentUser {
    private static CurrentUser instance;
    private User loggedInUser;

    private CurrentUser() {
    }

    public static synchronized CurrentUser getInstance() {
        if (instance == null) {
            instance = new CurrentUser();
        }
        return instance;
    }

    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void logout() {
        loggedInUser = null;
    }

    public boolean isLoggedIn() {
        return loggedInUser != null;
    }

    public boolean isAdmin() {
        return loggedInUser != null && "ADMIN".equalsIgnoreCase(loggedInUser.getRole());
    }

    public boolean isEmployee() {
        return loggedInUser != null && "EMPLOYEE".equalsIgnoreCase(loggedInUser.getRole());
    }

    public int getCurrentUserId() {
        return loggedInUser != null ? loggedInUser.getId() : -1;
    }

    public String getCurrentUsername() {
        return loggedInUser != null ? loggedInUser.getUsername() : null;
    }
}
