package org.xiuyuan.example.algorithms.digest;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * created by helanzhou
 * Date: 2018/10/30
 * Time: 5:04 PM
 */
public class SHA256Demo {

    public static String getSHA256(String str) {
        String encode = "";

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(str.getBytes("UTF-8"));
            encode = byte2Hex(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return encode;
    }

    private static String byte2Hex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();

        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);

            if (temp.length() == 1) {
                builder.append("0");
            }
            builder.append(temp);
        }

        return builder.toString();
    }

}
