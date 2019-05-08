package com.whiskas.shiro.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Util {

    private static final String SALT = "whiskas68";
    private static final String ALGORITH_NAME = "md5";
    private static final int HASH_ITERATIONS = 2;

    public static String encrypt(String passwd){
        String newPasswd = new SimpleHash(ALGORITH_NAME, passwd, ByteSource.Util.bytes(SALT), HASH_ITERATIONS).toHex();
        return newPasswd;
    }

    public static String encrypt(String username, String passwd){
        String newPasswd = new SimpleHash(ALGORITH_NAME,passwd,ByteSource.Util.bytes(username + SALT)
                ,HASH_ITERATIONS).toHex();
        return newPasswd;

    }

    public static void main(String[] args){
        System.out.println(MD5Util.encrypt("test","123456"));
    }
}
