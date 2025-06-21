package com.huawei.secure.android.common.anonymization;

/* loaded from: classes22.dex */
public class Anonymizer {
    public static java.lang.String maskAccountId(java.lang.String str) {
        return (str == null || str.length() <= 0) ? "" : str.length() <= 1 ? "*" : str.length() < 8 ? maskCommonString(str, 0, 1) : maskCommonString(str, 0, 4);
    }

    public static java.lang.String maskBankAccount(java.lang.String str) {
        return (str == null || str.length() <= 0) ? "" : str.length() <= 2 ? com.huawei.secure.android.common.anonymization.a.a(str, '*') : (str.length() < 11 || str.length() >= 20) ? maskCommonString(str, 6, 4) : maskCommonString(str, 4, 4);
    }

    public static java.lang.String maskBirthday(java.lang.String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 4) {
            return com.huawei.secure.android.common.anonymization.a.a(str, '*');
        }
        java.lang.String[] a = com.huawei.secure.android.common.anonymization.a.a(str, 4);
        return com.huawei.secure.android.common.anonymization.a.a("", com.huawei.secure.android.common.anonymization.a.a(a, 0), com.huawei.secure.android.common.anonymization.a.a(com.huawei.secure.android.common.anonymization.a.a(a, 1), "0123456789", "*"));
    }

    public static java.lang.String maskCommonString(java.lang.String str, int i, int i2) {
        int length;
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (str.length() <= i + i2) {
            length = str.length() - 1;
            i = 1;
        } else {
            length = str.length() - i2;
        }
        java.lang.String[] a = com.huawei.secure.android.common.anonymization.a.a(str, i, length);
        return com.huawei.secure.android.common.anonymization.a.a("", com.huawei.secure.android.common.anonymization.a.a(a, 0), com.huawei.secure.android.common.anonymization.a.a(com.huawei.secure.android.common.anonymization.a.a(a, 1), '*'), com.huawei.secure.android.common.anonymization.a.a(a, 2));
    }

    public static java.lang.String maskEmail(java.lang.String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 1) {
            return "*";
        }
        int indexOf = str.indexOf(64);
        if (indexOf < 0) {
            java.lang.String[] a = com.huawei.secure.android.common.anonymization.a.a(str, 1);
            return com.huawei.secure.android.common.anonymization.a.a("", com.huawei.secure.android.common.anonymization.a.a(a, 0), com.huawei.secure.android.common.anonymization.a.a(com.huawei.secure.android.common.anonymization.a.a(a, 1), '*'));
        }
        java.lang.String[] a2 = com.huawei.secure.android.common.anonymization.a.a(str, indexOf, indexOf + 1, str.lastIndexOf(46));
        return com.huawei.secure.android.common.anonymization.a.a("", com.huawei.secure.android.common.anonymization.a.a(com.huawei.secure.android.common.anonymization.a.a(a2, 0), '*'), com.huawei.secure.android.common.anonymization.a.a(a2, 1), com.huawei.secure.android.common.anonymization.a.a(com.huawei.secure.android.common.anonymization.a.a(a2, 2), '*'), com.huawei.secure.android.common.anonymization.a.a(a2, 3));
    }

    public static java.lang.String maskId(java.lang.String str) {
        return (str == null || str.length() <= 0) ? "" : maskCommonString(str, str.length() - 12, 0);
    }

    public static java.lang.String maskImeiImsi(java.lang.String str) {
        return (str == null || str.length() <= 0) ? "" : maskCommonString(str, str.length() - 4, 0);
    }

    public static java.lang.String maskIpV4(java.lang.String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return com.huawei.secure.android.common.anonymization.a.a(str, '*');
        }
        java.lang.String[] a = com.huawei.secure.android.common.anonymization.a.a(str, lastIndexOf + 1);
        return com.huawei.secure.android.common.anonymization.a.a("", com.huawei.secure.android.common.anonymization.a.a(a, 0), com.huawei.secure.android.common.anonymization.a.a(com.huawei.secure.android.common.anonymization.a.a(a, 1), '*'));
    }

    public static java.lang.String maskIpV6(java.lang.String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        java.lang.String[] b = com.huawei.secure.android.common.anonymization.a.b(str, ':');
        if (b.length <= 1) {
            return com.huawei.secure.android.common.anonymization.a.a(str, '*');
        }
        if (b.length != 8) {
            java.lang.String[] a = com.huawei.secure.android.common.anonymization.a.a(str, str.indexOf(58) + 1);
            return com.huawei.secure.android.common.anonymization.a.a("", com.huawei.secure.android.common.anonymization.a.a(a, 0), com.huawei.secure.android.common.anonymization.a.a(com.huawei.secure.android.common.anonymization.a.a(a, 1), "0123456789ABCDEFabcdef", "*"));
        }
        b[2] = maskLower8Bit(b[2]);
        for (int i = 3; i < b.length; i++) {
            b[i] = com.huawei.secure.android.common.anonymization.a.a(b[i], '*');
        }
        return com.huawei.secure.android.common.anonymization.a.a(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, b);
    }

    public static java.lang.String maskLower8Bit(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.length() <= 2) {
            return com.huawei.secure.android.common.anonymization.a.a(str, '*');
        }
        java.lang.String[] a = com.huawei.secure.android.common.anonymization.a.a(str, str.length() - 2);
        return com.huawei.secure.android.common.anonymization.a.a("", com.huawei.secure.android.common.anonymization.a.a(a, 0), com.huawei.secure.android.common.anonymization.a.a(com.huawei.secure.android.common.anonymization.a.a(a, 1), '*'));
    }

    public static java.lang.String maskMac(java.lang.String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int a = com.huawei.secure.android.common.anonymization.a.a(str, '-', 2);
        if (a < 0) {
            return com.huawei.secure.android.common.anonymization.a.a(str, "0123456789ABCDEFabcdef", "*");
        }
        java.lang.String[] a2 = com.huawei.secure.android.common.anonymization.a.a(str, a);
        return com.huawei.secure.android.common.anonymization.a.a("", com.huawei.secure.android.common.anonymization.a.a(a2, 0), com.huawei.secure.android.common.anonymization.a.a(com.huawei.secure.android.common.anonymization.a.a(a2, 1), "0123456789ABCDEFabcdef", "*"));
    }

    public static java.lang.String maskName(java.lang.String str) {
        return (str == null || str.length() <= 0) ? "" : str.length() <= 1 ? "*" : maskCommonString(str, 1, 0);
    }

    public static java.lang.String maskPhone(java.lang.String str) {
        return (str == null || str.length() <= 0) ? "" : str.length() <= 2 ? com.huawei.secure.android.common.anonymization.a.a(str, '*') : (str.length() < 8 || str.length() >= 11) ? maskCommonString(str, 3, 4) : maskCommonString(str, 2, 2);
    }
}
