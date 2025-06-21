package com.huawei.secure.android.common.util;

/* loaded from: classes22.dex */
public class EncodeUtil {
    public static final char[] a = {',', '.', '-'};
    public static final java.lang.String[] b = new java.lang.String[256];

    static {
        for (char c = 0; c < 255; c = (char) (c + 1)) {
            if ((c < '0' || c > '9') && ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z'))) {
                b[c] = f(c).intern();
            } else {
                b[c] = null;
            }
        }
    }

    public static java.lang.Character a(com.huawei.secure.android.common.util.a aVar) {
        aVar.c();
        java.lang.Character d = aVar.d();
        if (d == null) {
            aVar.i();
            return null;
        }
        if (d.charValue() != '\\') {
            aVar.i();
            return null;
        }
        java.lang.Character d2 = aVar.d();
        if (d2 == null) {
            aVar.i();
            return null;
        }
        if (d2.charValue() == 'b') {
            return '\b';
        }
        if (d2.charValue() == 't') {
            return '\t';
        }
        if (d2.charValue() == 'n') {
            return '\n';
        }
        if (d2.charValue() == 'v') {
            return (char) 11;
        }
        if (d2.charValue() == 'f') {
            return '\f';
        }
        if (d2.charValue() == 'r') {
            return '\r';
        }
        if (d2.charValue() == '\"') {
            return java.lang.Character.valueOf(kotlin.text.Typography.quote);
        }
        if (d2.charValue() == '\'') {
            return '\'';
        }
        if (d2.charValue() == '\\') {
            return '\\';
        }
        int i = 0;
        if (java.lang.Character.toLowerCase(d2.charValue()) == 'x') {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            while (i < 2) {
                java.lang.Character e = aVar.e();
                if (e == null) {
                    aVar.i();
                    return null;
                }
                sb.append(e);
                i++;
            }
            try {
                int parseInt = java.lang.Integer.parseInt(sb.toString(), 16);
                if (java.lang.Character.isValidCodePoint(parseInt)) {
                    return java.lang.Character.valueOf((char) parseInt);
                }
            } catch (java.lang.NumberFormatException unused) {
                aVar.i();
                return null;
            }
        } else if (java.lang.Character.toLowerCase(d2.charValue()) == 'u') {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            while (i < 4) {
                java.lang.Character e2 = aVar.e();
                if (e2 == null) {
                    aVar.i();
                    return null;
                }
                sb2.append(e2);
                i++;
            }
            try {
                int parseInt2 = java.lang.Integer.parseInt(sb2.toString(), 16);
                if (java.lang.Character.isValidCodePoint(parseInt2)) {
                    return java.lang.Character.valueOf((char) parseInt2);
                }
            } catch (java.lang.NumberFormatException unused2) {
                aVar.i();
                return null;
            }
        } else if (com.huawei.secure.android.common.util.a.c(d2)) {
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append(d2);
            java.lang.Character d3 = aVar.d();
            if (com.huawei.secure.android.common.util.a.c(d3)) {
                sb3.append(d3);
                java.lang.Character d4 = aVar.d();
                if (com.huawei.secure.android.common.util.a.c(d4)) {
                    sb3.append(d4);
                } else {
                    aVar.a(d4);
                }
            } else {
                aVar.a(d3);
            }
            try {
                int parseInt3 = java.lang.Integer.parseInt(sb3.toString(), 8);
                if (java.lang.Character.isValidCodePoint(parseInt3)) {
                    return java.lang.Character.valueOf((char) parseInt3);
                }
            } catch (java.lang.NumberFormatException unused3) {
                aVar.i();
                return null;
            }
        }
        return d2;
    }

    public static java.lang.String b(char c) {
        return c < 255 ? b[c] : f(c);
    }

    public static java.lang.String c(char[] cArr, java.lang.Character ch) {
        if (e(ch.charValue(), cArr)) {
            return "" + ch;
        }
        if (b(ch.charValue()) == null) {
            return "" + ch;
        }
        java.lang.String hexString = java.lang.Integer.toHexString(ch.charValue());
        if (ch.charValue() < 256) {
            return "\\x" + org.apache.tools.tar.TarConstants.VERSION_POSIX.substring(hexString.length()) + hexString.toUpperCase(java.util.Locale.ENGLISH);
        }
        return "\\u" + "0000".substring(hexString.length()) + hexString.toUpperCase(java.util.Locale.ENGLISH);
    }

    public static java.lang.String d(char[] cArr, java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(c(cArr, java.lang.Character.valueOf(str.charAt(i))));
        }
        return sb.toString();
    }

    public static java.lang.String decodeForJavaScript(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            com.huawei.secure.android.common.util.a aVar = new com.huawei.secure.android.common.util.a(str);
            while (aVar.a()) {
                java.lang.Character a2 = a(aVar);
                if (a2 != null) {
                    sb.append(a2);
                } else {
                    sb.append(aVar.d());
                }
            }
            return sb.toString();
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("decode js: ");
            sb2.append(e.getMessage());
            return "";
        }
    }

    public static boolean e(char c, char[] cArr) {
        for (char c2 : cArr) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    public static java.lang.String encodeForJavaScript(java.lang.String str) {
        return encodeForJavaScript(str, a);
    }

    public static java.lang.String encodeForJavaScript(java.lang.String str, char[] cArr) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return d(cArr, str);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("encode js: ");
            sb.append(e.getMessage());
            return "";
        }
    }

    public static java.lang.String f(char c) {
        return java.lang.Integer.toHexString(c);
    }
}
