package com.huawei.secure.android.common.util;

/* loaded from: classes22.dex */
public class SafeString {
    public static java.lang.String replace(java.lang.String str, java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
        if (str != null && charSequence != null && charSequence2 != null) {
            try {
                return str.replace(charSequence, charSequence2);
            } catch (java.lang.Exception e) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("replace: ");
                sb.append(e.getMessage());
            }
        }
        return str;
    }

    public static java.lang.String substring(java.lang.String str, int i) {
        if (str != null && str.length() >= i && i >= 0) {
            try {
                return str.substring(i);
            } catch (java.lang.Exception e) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("substring exception: ");
                sb.append(e.getMessage());
            }
        }
        return "";
    }

    public static java.lang.String substring(java.lang.String str, int i, int i2) {
        if (str != null && i >= 0 && i2 <= str.length() && i2 >= i) {
            try {
                return str.substring(i, i2);
            } catch (java.lang.Exception e) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("substring: ");
                sb.append(e.getMessage());
            }
        }
        return "";
    }
}
