package com.supinfo.supsale.utils;


import org.mindrot.jbcrypt.BCrypt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class SecurityUtils {

    private static String getHashfromPassword(String password, String salt){
        return BCrypt.hashpw(password, salt);
    }

    public static String getHashfromPassword(String password){return getHashfromPassword(password, BCrypt.gensalt(12));}

    public static boolean checkPassword(String password, String hash){
        return BCrypt.checkpw(password, hash);
    }

    public static boolean validateEmailAddress(String email){
        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
        Matcher m = p.matcher(email.toUpperCase());
        return m.matches();
    }

}
