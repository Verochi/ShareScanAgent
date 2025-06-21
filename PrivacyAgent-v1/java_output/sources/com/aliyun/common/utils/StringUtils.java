package com.aliyun.common.utils;

/* loaded from: classes.dex */
public class StringUtils {
    public static java.lang.String capitalizeFirstLetter(java.lang.String str) {
        if (isEmpty(str)) {
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

    public static java.lang.String fullWidthToHalfWidth(java.lang.String str) {
        if (isEmpty(str)) {
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

    public static java.lang.String getHrefInnerHtml(java.lang.String str) {
        if (isEmpty(str)) {
            return "";
        }
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(".*<[\\s]*a[\\s]*.*>(.+?)<[\\s]*/a[\\s]*>.*", 2).matcher(str);
        return matcher.matches() ? matcher.group(1) : str;
    }

    public static java.lang.String halfWidthToFullWidth(java.lang.String str) {
        if (isEmpty(str)) {
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

    public static java.lang.String htmlEscapeCharsToString(java.lang.String str) {
        return isEmpty(str) ? str : str.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replaceAll("&quot;", "\"");
    }

    public static boolean isBlank(java.lang.String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isEmpty(java.lang.String str) {
        return (str == null || str.length() == 0) && isBlank(str);
    }

    public static int length(java.lang.CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    public static java.lang.String nullStrToEmpty(java.lang.Object obj) {
        return obj == null ? "" : obj instanceof java.lang.String ? (java.lang.String) obj : obj.toString();
    }

    public static java.lang.String sqliteEscape(java.lang.String str) {
        return str.replace(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR, "//").replace("'", "''").replace("[", "/[").replace("]", "/]").replace("%", "/%").replace("&", "/&").replace("_", "/_").replace("(", "/(").replace(")", "/)");
    }

    public static java.lang.String subString(java.lang.String str) {
        int lastIndexOf = str.lastIndexOf(47);
        return lastIndexOf >= 0 ? str.substring(lastIndexOf + 1) : str;
    }

    public static java.lang.String utf8Encode(java.lang.String str) {
        if (isEmpty(str) || str.getBytes().length == str.length()) {
            return str;
        }
        try {
            return java.net.URLEncoder.encode(str, "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.RuntimeException("UnsupportedEncodingException occurred. ", e);
        }
    }

    public static java.lang.String utf8Encode(java.lang.String str, java.lang.String str2) {
        if (isEmpty(str) || str.getBytes().length == str.length()) {
            return str;
        }
        try {
            return java.net.URLEncoder.encode(str, "UTF-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            return str2;
        }
    }
}
