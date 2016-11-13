package com.shdev.demo.mail.javamail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * Created by ou_ko on 2016/7/17.
 */
public class PopupAuthenticator extends Authenticator {
    public static final String username = "ou_kongli@163.com";
    public static final String password = "*********";

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }
}
