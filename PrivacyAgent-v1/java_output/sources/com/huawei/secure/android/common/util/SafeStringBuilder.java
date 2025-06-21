package com.huawei.secure.android.common.util;

/* loaded from: classes22.dex */
public class SafeStringBuilder {
    public static java.lang.String substring(java.lang.StringBuilder sb, int i) {
        if (!android.text.TextUtils.isEmpty(sb) && sb.length() >= i && i >= 0) {
            try {
                return sb.substring(i);
            } catch (java.lang.Exception e) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("substring exception: ");
                sb2.append(e.getMessage());
            }
        }
        return "";
    }

    public static java.lang.String substring(java.lang.StringBuilder sb, int i, int i2) {
        if (!android.text.TextUtils.isEmpty(sb) && i >= 0 && i2 <= sb.length() && i2 >= i) {
            try {
                return sb.substring(i, i2);
            } catch (java.lang.Exception e) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("substring: ");
                sb2.append(e.getMessage());
            }
        }
        return "";
    }
}
