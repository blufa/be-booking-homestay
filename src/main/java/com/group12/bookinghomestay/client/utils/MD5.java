package com.group12.bookinghomestay.client.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static String getHashedString(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashed = md.digest(input.getBytes());
        BigInteger bi = new BigInteger(1, hashed);
        return bi.toString(16);
    }
}
