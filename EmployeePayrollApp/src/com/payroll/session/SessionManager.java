package com.payroll.session;

import com.payroll.model.User;

public class SessionManager {

    private User currentUser;
    private long loginTime;
    private static final long SESSION_TIMEOUT_MS = 30 * 60 * 1000; // 30 minutes

    public void createSession(User user) {
        this.currentUser = user;
        this.loginTime = System.currentTimeMillis();
    }

    public User getCurrentUser() throws Exception {
        if (currentUser == null) {
            throw new Exception("No active session");
        }

        if (System.currentTimeMillis() - loginTime > SESSION_TIMEOUT_MS) {
            logout();
            throw new Exception("Session expired");
        }

        return currentUser;
    }

    public void logout() {
        this.currentUser = null;
        this.loginTime = 0;
    }

    public boolean isActive() {
        return currentUser != null;
    }
}