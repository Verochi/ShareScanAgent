package com.alibaba.sdk.android.oss.common.utils;

/* loaded from: classes.dex */
public class StringUtils {
    public static final java.nio.charset.Charset UTF8 = java.nio.charset.Charset.forName("utf-8");

    public static boolean isNullOrEmpty(java.lang.String str) {
        return str == null || str.isEmpty();
    }

    public static java.lang.String join(java.lang.String str, java.util.Collection<java.lang.String> collection) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Iterator<java.lang.String> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            sb.append(it.next());
            if (i < collection.size() - 1) {
                sb.append(str);
            }
            i++;
        }
        return sb.toString();
    }

    public static java.lang.String join(java.lang.String str, java.lang.String... strArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i]);
            if (i < strArr.length - 1) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static java.lang.String replaceEach(java.lang.String str, java.lang.String[] strArr, java.lang.String[] strArr2) {
        java.lang.String str2;
        java.lang.String str3;
        int length;
        int length2 = strArr.length;
        int length3 = strArr2.length;
        if (isNullOrEmpty(str) || (length2 == 0 && length3 == 0)) {
            return str;
        }
        if (length2 != length3) {
            throw new java.lang.IllegalArgumentException("Search and Replace array lengths don't match: " + length2 + " vs " + length3);
        }
        boolean[] zArr = new boolean[length2];
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < length2; i3++) {
            if (!zArr[i3] && !isNullOrEmpty(strArr[i3]) && strArr2[i3] != null) {
                int indexOf = str.indexOf(strArr[i3]);
                if (indexOf == -1) {
                    zArr[i3] = true;
                } else if (i == -1 || indexOf < i) {
                    i2 = i3;
                    i = indexOf;
                }
            }
        }
        if (i == -1) {
            return str;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < strArr.length; i5++) {
            if (strArr[i5] != null && (str3 = strArr2[i5]) != null && (length = str3.length() - strArr[i5].length()) > 0) {
                i4 += length * 3;
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str.length() + java.lang.Math.min(i4, str.length() / 5));
        int i6 = 0;
        while (i != -1) {
            while (i6 < i) {
                sb.append(str.charAt(i6));
                i6++;
            }
            sb.append(strArr2[i2]);
            i6 = strArr[i2].length() + i;
            i = -1;
            i2 = -1;
            for (int i7 = 0; i7 < length2; i7++) {
                if (!zArr[i7] && (str2 = strArr[i7]) != null && !str2.isEmpty() && strArr2[i7] != null) {
                    int indexOf2 = str.indexOf(strArr[i7], i6);
                    if (indexOf2 == -1) {
                        zArr[i7] = true;
                    } else if (i == -1 || indexOf2 < i) {
                        i2 = i7;
                        i = indexOf2;
                    }
                }
            }
        }
        int length4 = str.length();
        while (i6 < length4) {
            sb.append(str.charAt(i6));
            i6++;
        }
        return sb.toString();
    }

    public static java.lang.String trim(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }
}
