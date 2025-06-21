package com.anythink.core.common.o;

/* loaded from: classes12.dex */
public final class t {
    private static java.lang.String a(java.lang.String str, java.lang.String str2) {
        int length = str.length();
        int length2 = str2.length();
        if (length == length2) {
            return str;
        }
        int abs = java.lang.Math.abs(length2 - length);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str);
        for (int i = 0; i < abs; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static boolean a(java.lang.CharSequence charSequence) {
        if (android.text.TextUtils.isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!java.lang.Character.isDigit(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(java.lang.String str) {
        return str.matches("[\\u4e00-\\u9fa5]+");
    }
}
