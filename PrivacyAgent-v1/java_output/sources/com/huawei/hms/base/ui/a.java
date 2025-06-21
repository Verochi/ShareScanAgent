package com.huawei.hms.base.ui;

/* loaded from: classes22.dex */
public class a {
    public static final java.util.regex.Pattern a = java.util.regex.Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    public static java.lang.String a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i = 1;
        if (1 == length) {
            return java.lang.String.valueOf('*');
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(length);
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (a.matcher(java.lang.String.valueOf(charAt)).matches()) {
                if (i % 2 == 0) {
                    charAt = '*';
                }
                i++;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static java.lang.String a(java.lang.String str, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(512);
        if (!android.text.TextUtils.isEmpty(str)) {
            if (z) {
                sb.append(a(str));
            } else {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        a(str2, false);
    }

    public static void a(java.lang.String str, java.lang.String str2, boolean z) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        a(str2, z);
    }
}
