package com.aliyun.common.utils;

/* loaded from: classes.dex */
public class JsonFormatUtils {
    private static void doFill(java.lang.StringBuilder sb, int i, java.lang.String str) {
        sb.append("\n");
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(str);
        }
    }

    public static java.lang.String formatJson(java.lang.String str) {
        int length;
        int i;
        java.lang.String str2;
        if (str == null || str.trim().length() == 0) {
            return "";
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (str.length() > 0) {
            java.lang.String token = getToken(str);
            str = str.substring(token.length());
            arrayList.add(token.trim());
        }
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            int length2 = ((java.lang.String) arrayList.get(i3)).getBytes().length;
            if (length2 > i2 && i3 < arrayList.size() - 1 && ((java.lang.String) arrayList.get(i3 + 1)).equals(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                i2 = length2;
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i4 = 0;
        int i5 = 0;
        while (i4 < arrayList.size()) {
            java.lang.String str3 = (java.lang.String) arrayList.get(i4);
            if (!str3.equals(",")) {
                if (str3.equals(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                    sb.append(" ");
                    sb.append(str3);
                    sb.append(" ");
                } else if (str3.equals("{")) {
                    i = i4 + 1;
                    if (((java.lang.String) arrayList.get(i)).equals(com.alipay.sdk.m.u.i.d)) {
                        str2 = "{ }";
                        sb.append(str2);
                        i4 = i;
                    }
                    i5++;
                } else {
                    if (!str3.equals(com.alipay.sdk.m.u.i.d)) {
                        if (str3.equals("[")) {
                            i = i4 + 1;
                            if (((java.lang.String) arrayList.get(i)).equals("]")) {
                                str2 = "[ ]";
                                sb.append(str2);
                                i4 = i;
                            }
                            i5++;
                        } else if (!str3.equals("]")) {
                            sb.append(str3);
                            if (i4 < arrayList.size() - 1 && ((java.lang.String) arrayList.get(i4 + 1)).equals(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) && (length = i2 - str3.getBytes().length) > 0) {
                                for (int i6 = 0; i6 < length; i6++) {
                                    sb.append(" ");
                                }
                            }
                        }
                    }
                    i5--;
                    doFill(sb, i5, "\t");
                    sb.append(str3);
                }
                i4++;
            }
            sb.append(str3);
            doFill(sb, i5, "\t");
            i4++;
        }
        return sb.toString();
    }

    private static java.lang.String getToken(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        boolean z = false;
        while (str.length() > 0) {
            java.lang.String substring = str.substring(0, 1);
            str = str.substring(1);
            if (z || !(substring.equals(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) || substring.equals("{") || substring.equals(com.alipay.sdk.m.u.i.d) || substring.equals("[") || substring.equals("]") || substring.equals(","))) {
                if (substring.equals("\\")) {
                    sb.append(substring);
                    sb.append(str.substring(0, 1));
                    str = str.substring(1);
                } else {
                    boolean equals = substring.equals("\"");
                    sb.append(substring);
                    if (!equals) {
                        continue;
                    } else {
                        if (z) {
                            break;
                        }
                        z = true;
                    }
                }
            } else if (sb.toString().trim().length() == 0) {
                sb.append(substring);
            }
        }
        return sb.toString();
    }
}
