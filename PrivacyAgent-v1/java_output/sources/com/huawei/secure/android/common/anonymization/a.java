package com.huawei.secure.android.common.anonymization;

/* loaded from: classes22.dex */
public class a {
    public static int a(java.lang.String str, char c, int i) {
        int length = str.length() - 1;
        while (length >= 0 && (str.charAt(length) != c || i - 1 > 0)) {
            length--;
        }
        return length;
    }

    public static java.lang.String a(java.lang.String str, char c) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int length = str.length();
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = c;
        }
        return new java.lang.String(cArr);
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (str == null || str.length() <= 0 || str2.length() <= 0 || str3.length() <= 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        char[] cArr = new char[str.length()];
        char charAt = str3.charAt(str3.length() - 1);
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            int lastIndexOf = str2.lastIndexOf(c);
            if (lastIndexOf < 0) {
                cArr[i] = c;
            } else {
                cArr[i] = lastIndexOf >= str3.length() ? charAt : str3.charAt(lastIndexOf);
            }
        }
        return new java.lang.String(cArr);
    }

    public static java.lang.String a(java.lang.String str, java.lang.String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            if (strArr[i] != null) {
                sb.append(str);
                sb.append(strArr[i]);
            }
        }
        return sb.toString();
    }

    public static java.lang.String a(java.lang.String[] strArr, int i) {
        return (strArr == null || strArr.length <= 0 || i < 0 || i >= strArr.length) ? "" : strArr[i];
    }

    public static java.lang.String[] a(java.lang.String str, int i) {
        return str == null ? new java.lang.String[]{"", ""} : (i < 0 || i > str.length()) ? new java.lang.String[]{str, ""} : new java.lang.String[]{str.substring(0, i), str.substring(i)};
    }

    public static java.lang.String[] a(java.lang.String str, int i, int i2) {
        java.lang.String[] a = a(str, i);
        return b(a(a, 0), a(a(a, 1), i2 - i));
    }

    public static java.lang.String[] a(java.lang.String str, int i, int i2, int i3) {
        java.lang.String[] a = a(str, i);
        return b(a(a, 0), a(a(a, 1), i2 - i, i3 - i));
    }

    public static java.lang.String[] a(java.lang.String str, int... iArr) {
        if (str == null) {
            return new java.lang.String[]{""};
        }
        if (str.length() <= 1 || iArr.length <= 0) {
            return new java.lang.String[]{str};
        }
        if (iArr.length <= 1) {
            return a(str, iArr[0]);
        }
        int i = iArr[0];
        int length = iArr.length - 1;
        int[] iArr2 = new int[length];
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            iArr2[i2] = iArr[i3] - i;
            i2 = i3;
        }
        java.lang.String[] a = a(str, i);
        return b(a(a, 0), a(a(a, 1), iArr2));
    }

    public static java.lang.String[] a(java.lang.String[] strArr, java.lang.String str) {
        return a(strArr, new java.lang.String[]{str});
    }

    public static java.lang.String[] a(java.lang.String[] strArr, java.lang.String[] strArr2) {
        if (strArr.length <= 0) {
            return strArr2.length <= 0 ? new java.lang.String[0] : strArr2;
        }
        if (strArr2.length <= 0) {
            return strArr;
        }
        java.lang.String[] strArr3 = new java.lang.String[strArr.length + strArr2.length];
        java.lang.System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        java.lang.System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    public static java.lang.String[] b(java.lang.String str, char c) {
        if (str == null) {
            return new java.lang.String[0];
        }
        if (str.length() <= 0) {
            return new java.lang.String[]{str};
        }
        int i = 1;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == c) {
                i++;
            }
        }
        if (i <= 1) {
            return new java.lang.String[]{str};
        }
        java.lang.String[] strArr = new java.lang.String[i];
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str.length());
        int i3 = 0;
        for (int i4 = 0; i4 < str.length() && i3 < i; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == c) {
                strArr[i3] = sb.toString();
                sb.setLength(0);
                i3++;
            } else {
                sb.append(charAt);
            }
        }
        strArr[i3] = sb.toString();
        return strArr;
    }

    public static java.lang.String[] b(java.lang.String str, java.lang.String[] strArr) {
        return a(new java.lang.String[]{str}, strArr);
    }
}
