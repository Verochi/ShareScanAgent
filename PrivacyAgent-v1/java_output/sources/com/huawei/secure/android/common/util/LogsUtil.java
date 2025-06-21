package com.huawei.secure.android.common.util;

/* loaded from: classes22.dex */
public class LogsUtil {
    public static final java.util.regex.Pattern a = java.util.regex.Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    public static class a extends java.lang.Throwable {
        private static final long d = 7129050843360571879L;
        private java.lang.String a;
        private java.lang.Throwable b;
        private java.lang.Throwable c;

        public a(java.lang.Throwable th) {
            this.c = th;
        }

        public void a(java.lang.String str) {
            this.a = str;
        }

        public void a(java.lang.Throwable th) {
            this.b = th;
        }

        @Override // java.lang.Throwable
        public java.lang.Throwable getCause() {
            java.lang.Throwable th = this.b;
            if (th == this) {
                return null;
            }
            return th;
        }

        @Override // java.lang.Throwable
        public java.lang.String getMessage() {
            return this.a;
        }

        @Override // java.lang.Throwable
        public java.lang.String toString() {
            java.lang.Throwable th = this.c;
            if (th == null) {
                return "";
            }
            java.lang.String name = th.getClass().getName();
            if (this.a == null) {
                return name;
            }
            java.lang.String str = name + ": ";
            if (this.a.startsWith(str)) {
                return this.a;
            }
            return str + this.a;
        }
    }

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

    public static java.lang.String b(java.lang.String str, java.lang.String str2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(512);
        if (!android.text.TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (!android.text.TextUtils.isEmpty(str2)) {
            sb.append(a(str2));
        }
        return sb.toString();
    }

    public static java.lang.String c(java.lang.String str, boolean z) {
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

    public static java.lang.Throwable d(java.lang.Throwable th) {
        if (th == null) {
            return null;
        }
        com.huawei.secure.android.common.util.LogsUtil.a aVar = new com.huawei.secure.android.common.util.LogsUtil.a(th);
        aVar.setStackTrace(th.getStackTrace());
        aVar.a(e(th.getMessage()));
        java.lang.Throwable cause = th.getCause();
        com.huawei.secure.android.common.util.LogsUtil.a aVar2 = aVar;
        while (cause != null) {
            com.huawei.secure.android.common.util.LogsUtil.a aVar3 = new com.huawei.secure.android.common.util.LogsUtil.a(cause);
            aVar3.setStackTrace(cause.getStackTrace());
            aVar3.a(e(cause.getMessage()));
            aVar2.a(aVar3);
            cause = cause.getCause();
            aVar2 = aVar3;
        }
        return aVar;
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2, false);
    }

    public static void d(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str2) && android.text.TextUtils.isEmpty(str3)) {
            return;
        }
        b(str2, str3);
    }

    public static void d(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.Throwable th) {
        if (android.text.TextUtils.isEmpty(str2) && android.text.TextUtils.isEmpty(str3)) {
            return;
        }
        b(str2, str3);
        d(th);
    }

    public static void d(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (android.text.TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        c(str2, false);
        d(th);
    }

    public static void d(java.lang.String str, java.lang.String str2, java.lang.Throwable th, boolean z) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2, z);
        d(th);
    }

    public static void d(java.lang.String str, java.lang.String str2, boolean z) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2, z);
    }

    public static java.lang.String e(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i % 2 == 0) {
                charArray[i] = '*';
            }
        }
        return new java.lang.String(charArray);
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2, false);
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str2) && android.text.TextUtils.isEmpty(str3)) {
            return;
        }
        b(str2, str3);
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.Throwable th) {
        if (android.text.TextUtils.isEmpty(str2) && android.text.TextUtils.isEmpty(str3)) {
            return;
        }
        b(str2, str3);
        d(th);
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (android.text.TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        c(str2, false);
        d(th);
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th, boolean z) {
        if (android.text.TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        c(str2, z);
        d(th);
    }

    public static void e(java.lang.String str, java.lang.String str2, boolean z) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2, z);
    }

    public static void i(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2, false);
    }

    public static void i(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str2) && android.text.TextUtils.isEmpty(str3)) {
            return;
        }
        b(str2, str3);
    }

    public static void i(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.Throwable th) {
        if (android.text.TextUtils.isEmpty(str2) && android.text.TextUtils.isEmpty(str3)) {
            return;
        }
        b(str2, str3);
        d(th);
    }

    public static void i(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (android.text.TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        c(str2, false);
        d(th);
    }

    public static void i(java.lang.String str, java.lang.String str2, java.lang.Throwable th, boolean z) {
        if (android.text.TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        c(str2, z);
        d(th);
    }

    public static void i(java.lang.String str, java.lang.String str2, boolean z) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2, z);
    }

    public static void w(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2, false);
    }

    public static void w(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str2) && android.text.TextUtils.isEmpty(str3)) {
            return;
        }
        b(str2, str3);
    }

    public static void w(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.Throwable th) {
        if (android.text.TextUtils.isEmpty(str2) && android.text.TextUtils.isEmpty(str3)) {
            return;
        }
        b(str2, str3);
        d(th);
    }

    public static void w(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (android.text.TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        c(str2, false);
        d(th);
    }

    public static void w(java.lang.String str, java.lang.String str2, java.lang.Throwable th, boolean z) {
        if (android.text.TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        c(str2, z);
        d(th);
    }

    public static void w(java.lang.String str, java.lang.String str2, boolean z) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2, z);
    }
}
