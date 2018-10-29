package com.github.mingruyue.sbmoon.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
    private static final String SALT = "1a2b3c4d";
    private static String nullMd5 = null;

    private static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    /**
     * 如果用户未输入密码，产生的md5是固定的
     *
     * @return md5 hex
     */
    public static final String getNullMd5() {
        if (nullMd5 == null) {
            nullMd5 = inputPass2FormPass("");
        }
        return nullMd5;
    }

    public static String inputPass2FormPass(String inputPass) {
        String str = "" + SALT.charAt(0) + SALT.charAt(2) +
                inputPass +
                SALT.charAt(5) + SALT.charAt(4);
        return md5(str);
    }

    public static String formPass2DbPass(String formPass, String salt) {
        String str = "" + salt.charAt(0) + salt.charAt(2) +
                formPass +
                salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String inputPass2DbPass(String input, String saltDb) {
        String formPass = inputPass2FormPass(input);
        String dbPass = formPass2DbPass(formPass, saltDb);
        return dbPass;
    }

    public static void main(String[] args) {
        System.out.println(inputPass2FormPass(""));
//        System.out.println(formPass2DbPass("12345", "12345678"));
        //这个值就是要填入数据库的，用于登录功能
        System.out.println(inputPass2DbPass("123456", "12345678"));
    }
}
