package com.payroll.model;

import com.payroll.util.PasswordUtil;

public class RegularEmployee extends User {

    private UserAccount account;

    public RegularEmployee(UserAccount account) {
        super(account.getUsername(), account.getRole());
        this.account = account;
    }

    @Override
    public boolean authenticate(String password) {
        String encryptedInput = PasswordUtil.encryptPassword(password);
        return encryptedInput.equals(account.getEncryptedPassword());
    }

    public UserAccount getAccount() {
        return account;
    }
}