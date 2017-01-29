package com.supinfo.supsale.utils;


import org.mindrot.jbcrypt.BCrypt;

public abstract class SecurityUtils {

    private static String getHashfromPassword(String password, String salt){
        return BCrypt.hashpw(password, salt);
    }

    public static String getHashfromPassword(String password){
        return getHashfromPassword(password, BCrypt.gensalt(12));
    }

    public static boolean checkPassworc(String password, String hash){
        return BCrypt.checkpw(password, hash);
    }

}
