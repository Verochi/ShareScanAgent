package com.anythink.core.common.o;

/* loaded from: classes12.dex */
final class p {
    private final android.content.pm.PackageManager a;

    public enum a {
        ENABLED,
        DISABLED,
        NOT_INSTALLED
    }

    public p(android.content.Context context) {
        this.a = context.getPackageManager();
    }

    private static boolean a(android.content.Context context) {
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context != null) {
            try {
                android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
                if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                    return false;
                }
                for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.processName.equals(context.getPackageName()) && runningAppProcessInfo.importance >= 200) {
                        return true;
                    }
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return false;
    }

    private static byte[] a(byte[] bArr) {
        try {
            return java.security.MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (java.security.NoSuchAlgorithmException unused) {
            return new byte[0];
        }
    }

    private int c(java.lang.String str) {
        try {
            android.content.pm.PackageInfo packageInfo = this.a.getPackageInfo(str, 16);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
        }
        return 0;
    }

    private java.lang.String d(java.lang.String str) {
        try {
            android.content.pm.PackageInfo packageInfo = this.a.getPackageInfo(str, 16);
            if (packageInfo != null) {
                java.lang.String str2 = packageInfo.versionName;
                if (str2 != null) {
                    return str2;
                }
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
        }
        return "";
    }

    private byte[] e(java.lang.String str) {
        android.content.pm.Signature[] signatureArr;
        try {
            android.content.pm.PackageInfo packageInfo = this.a.getPackageInfo(str, 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0) {
                return signatureArr[0].toByteArray();
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
        }
        return new byte[0];
    }

    public final com.anythink.core.common.o.p.a a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return com.anythink.core.common.o.p.a.NOT_INSTALLED;
        }
        try {
            return this.a.getApplicationInfo(str, 0).enabled ? com.anythink.core.common.o.p.a.ENABLED : com.anythink.core.common.o.p.a.DISABLED;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return com.anythink.core.common.o.p.a.NOT_INSTALLED;
        }
    }

    public final java.lang.String b(java.lang.String str) {
        byte[] e = e(str);
        if (e == null || e.length == 0) {
            return null;
        }
        return com.anythink.core.common.o.l.a(a(e));
    }
}
