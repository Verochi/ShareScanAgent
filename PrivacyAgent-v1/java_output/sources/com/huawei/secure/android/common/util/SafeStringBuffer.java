package com.huawei.secure.android.common.util;

/* loaded from: classes22.dex */
public class SafeStringBuffer {
    public static java.lang.String substring(java.lang.StringBuffer stringBuffer, int i) {
        if (stringBuffer != null && stringBuffer.length() >= i && i >= 0) {
            try {
                return stringBuffer.substring(i);
            } catch (java.lang.Exception e) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("substring exception: ");
                sb.append(e.getMessage());
            }
        }
        return "";
    }

    public static java.lang.String substring(java.lang.StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer != null && i >= 0 && i2 <= stringBuffer.length() && i2 >= i) {
            try {
                return stringBuffer.substring(i, i2);
            } catch (java.lang.Exception e) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("substring: ");
                sb.append(e.getMessage());
            }
        }
        return "";
    }
}
