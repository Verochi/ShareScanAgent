package com.igexin.push.h;

/* loaded from: classes23.dex */
public final class p {
    private static final char[] a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz`~!@#$%^&*()-_=+[{}];:'/?.>,<".toCharArray();

    public static java.lang.String a() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(16);
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < 16; i++) {
            char[] cArr = a;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    public static java.lang.String b() {
        java.util.Random random = new java.util.Random();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < 16; i++) {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt(62)));
        }
        return sb.toString();
    }

    private static long c() {
        return (new java.util.Random().nextInt(6) + 2) * 60000;
    }
}
