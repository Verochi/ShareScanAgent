package com.huawei.secure.android.common.ssl.util;

/* loaded from: classes22.dex */
public class h {
    public static final java.lang.String a = "h";

    public static java.lang.String a(java.lang.String str) {
        android.content.Context a2 = com.huawei.secure.android.common.ssl.util.c.a();
        if (a2 == null) {
            return "";
        }
        try {
            return a2.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            com.huawei.secure.android.common.ssl.util.g.b(a, "getVersion NameNotFoundException : " + e.getMessage());
            return "";
        } catch (java.lang.Exception e2) {
            com.huawei.secure.android.common.ssl.util.g.b(a, "getVersion: " + e2.getMessage());
            return "";
        } catch (java.lang.Throwable unused) {
            com.huawei.secure.android.common.ssl.util.g.b(a, "throwable");
            return "";
        }
    }

    public static int b(java.lang.String str) {
        android.content.Context a2 = com.huawei.secure.android.common.ssl.util.c.a();
        if (a2 == null) {
            return 0;
        }
        try {
            return a2.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            com.huawei.secure.android.common.ssl.util.g.b(a, "getVersion NameNotFoundException");
            return 0;
        } catch (java.lang.Exception e) {
            com.huawei.secure.android.common.ssl.util.g.b(a, "getVersion: " + e.getMessage());
            return 0;
        }
    }
}
