package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class ao {
    public static java.lang.String a(int i) {
        java.util.Random random = new java.util.Random();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(62)));
        }
        return stringBuffer.toString();
    }

    public static java.lang.String a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(c(str));
            return java.lang.String.format("%1$032X", new java.math.BigInteger(1, messageDigest.digest()));
        } catch (java.security.NoSuchAlgorithmException unused) {
            return str;
        }
    }

    public static java.lang.String a(java.lang.String str, int i) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int length = str.length();
        if (length < 3) {
            i = length / 3;
            if (i <= 1) {
                i = 1;
            }
            if (i > 3) {
                i = 3;
            }
        }
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (i3 % i == 0) {
                sb.append("*");
            } else {
                sb.append(str.charAt(i2));
            }
            i2 = i3;
        }
        return sb.toString();
    }

    public static java.lang.String a(java.util.Collection<?> collection, java.lang.String str) {
        if (collection == null) {
            return null;
        }
        return a(collection.iterator(), str);
    }

    private static java.lang.String a(java.util.Iterator<?> it, java.lang.String str) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        java.lang.Object next = it.next();
        if (!it.hasNext()) {
            return next.toString();
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(256);
        if (next != null) {
            stringBuffer.append(next);
        }
        while (it.hasNext()) {
            if (str != null) {
                stringBuffer.append(str);
            }
            java.lang.Object next2 = it.next();
            if (next2 != null) {
                stringBuffer.append(next2);
            }
        }
        return stringBuffer.toString();
    }

    public static java.lang.String a(byte[] bArr) {
        java.lang.String str;
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            str = java.lang.String.format("%1$032X", new java.math.BigInteger(1, messageDigest.digest()));
        } catch (java.lang.Exception unused) {
            str = "";
        }
        return str.toLowerCase();
    }

    public static java.lang.String b(java.lang.String str) {
        if (str == null) {
            return null;
        }
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA1");
            messageDigest.update(c(str));
            return java.lang.String.format("%1$032X", new java.math.BigInteger(1, messageDigest.digest()));
        } catch (java.security.NoSuchAlgorithmException unused) {
            return str;
        }
    }

    public static java.lang.String b(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return new java.lang.String(bArr, "UTF-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            return new java.lang.String(bArr);
        }
    }

    public static byte[] c(java.lang.String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static boolean d(java.lang.String str) {
        if (str == null) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt < 0 || charAt > 127) {
                return false;
            }
        }
        return true;
    }

    public static boolean e(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return java.util.regex.Pattern.compile("^[A-Za-z0-9]+$").matcher(str).matches();
    }

    public static boolean f(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        char charAt = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != charAt) {
                return false;
            }
        }
        return true;
    }
}
