package com.anythink.expressad.foundation.g.d;

/* loaded from: classes12.dex */
public final class e {
    private static java.lang.String a(long j) {
        if (j <= 0) {
            return "0M";
        }
        return java.lang.String.format("%.1f", java.lang.Float.valueOf((j / 1024.0f) / 1024.0f)) + "M";
    }

    private static java.lang.String a(java.lang.String str, java.lang.String str2) {
        if (b(str) || str.getBytes().length == str.length()) {
            return str;
        }
        try {
            return java.net.URLEncoder.encode(str, "UTF-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            return str2;
        }
    }

    public static boolean a(java.lang.String str) {
        return str == null || str.trim().length() == 0;
    }

    private static boolean b(java.lang.String str) {
        return str == null || str.length() == 0;
    }

    private static java.lang.String c(java.lang.String str) {
        return str == null ? "" : str;
    }

    private static java.lang.String d(java.lang.String str) {
        if (b(str)) {
            return str;
        }
        char charAt = str.charAt(0);
        if (!java.lang.Character.isLetter(charAt) || java.lang.Character.isUpperCase(charAt)) {
            return str;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str.length());
        sb.append(java.lang.Character.toUpperCase(charAt));
        sb.append(str.substring(1));
        return sb.toString();
    }

    private static java.lang.String e(java.lang.String str) {
        if (b(str) || str.getBytes().length == str.length()) {
            return str;
        }
        try {
            return java.net.URLEncoder.encode(str, "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.RuntimeException("UnsupportedEncodingException occurred. ", e);
        }
    }

    private static java.lang.String f(java.lang.String str) {
        if (b(str)) {
            return "";
        }
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(".*<[\\s]*a[\\s]*.*>(.+?)<[\\s]*/a[\\s]*>.*", 2).matcher(str);
        return matcher.matches() ? matcher.group(1) : str;
    }

    private static java.lang.String g(java.lang.String str) {
        return b(str) ? str : str.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replaceAll("&quot;", "\"");
    }

    private static java.lang.String h(java.lang.String str) {
        if (b(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == 12288) {
                charArray[i] = ' ';
            } else if (c < 65281 || c > 65374) {
                charArray[i] = c;
            } else {
                charArray[i] = (char) (c - 65248);
            }
        }
        return new java.lang.String(charArray);
    }

    private static java.lang.String i(java.lang.String str) {
        if (b(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == ' ') {
                charArray[i] = 12288;
            } else if (c < '!' || c > '~') {
                charArray[i] = c;
            } else {
                charArray[i] = (char) (c + 65248);
            }
        }
        return new java.lang.String(charArray);
    }
}
