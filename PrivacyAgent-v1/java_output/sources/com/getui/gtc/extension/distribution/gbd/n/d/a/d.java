package com.getui.gtc.extension.distribution.gbd.n.d.a;

/* loaded from: classes22.dex */
public final class d {
    private static final java.lang.String[] a = {"", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          "};

    public static java.lang.String a(int i) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("width must be > 0");
        }
        java.lang.String[] strArr = a;
        if (i < strArr.length) {
            return strArr[i];
        }
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = ' ';
        }
        return java.lang.String.valueOf(cArr);
    }

    public static java.lang.String a(java.util.Collection collection, java.lang.String str) {
        java.util.Iterator it = collection.iterator();
        if (!it.hasNext()) {
            return "";
        }
        java.lang.String obj = it.next().toString();
        if (!it.hasNext()) {
            return obj;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(64);
        sb.append(obj);
        while (it.hasNext()) {
            sb.append(str);
            sb.append(it.next());
        }
        return sb.toString();
    }

    private static java.lang.String a(java.util.Iterator it, java.lang.String str) {
        if (!it.hasNext()) {
            return "";
        }
        java.lang.String obj = it.next().toString();
        if (!it.hasNext()) {
            return obj;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(64);
        sb.append(obj);
        while (it.hasNext()) {
            sb.append(str);
            sb.append(it.next());
        }
        return sb.toString();
    }

    public static boolean a(java.lang.String str) {
        if (str != null && str.length() != 0) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                if (!b(str.codePointAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean a(java.lang.String str, java.lang.String... strArr) {
        for (java.lang.String str2 : strArr) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(int i) {
        return i == 32 || i == 9 || i == 10 || i == 12 || i == 13;
    }

    public static boolean b(java.lang.String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!java.lang.Character.isDigit(str.codePointAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static java.lang.String c(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str.length());
        int length = str.length();
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < length; i++) {
            int codePointAt = str.codePointAt(i);
            if (!b(codePointAt)) {
                sb.appendCodePoint(codePointAt);
                z2 = false;
            } else if (z2) {
                z = true;
            } else {
                if (codePointAt != 32) {
                    z = true;
                }
                sb.append(' ');
                z2 = true;
            }
        }
        return z ? sb.toString() : str;
    }
}
