package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class Native2AsciiUtils {
    public static int a(java.lang.String str, int i) {
        try {
            return java.lang.Integer.parseInt(str.substring(i, i + 4), 16);
        } catch (java.lang.NumberFormatException unused) {
            return -1;
        }
    }

    public static java.lang.String ascii2native(java.lang.String str) {
        int a;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt != '\\' || i >= length - 5) {
                sb.append(charAt);
            } else {
                i++;
                char charAt2 = str.charAt(i);
                if (charAt2 != 'u' || (a = a(str, i + 1)) < 0) {
                    sb.append(charAt);
                    sb.append(charAt2);
                } else {
                    sb.append((char) a);
                    i += 4;
                }
            }
            i++;
        }
        return sb.toString();
    }

    public static java.lang.String native2ascii(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (char c : str.toCharArray()) {
            if (c <= 127) {
                sb.append(c);
            } else {
                sb.append("\\u");
                java.lang.String hexString = java.lang.Integer.toHexString(c);
                for (int length = hexString.length(); length < 4; length++) {
                    sb.append("0");
                }
                sb.append(hexString);
            }
        }
        return sb.toString();
    }
}
