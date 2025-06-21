package com.google.android.gms.common.util;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class WorkSourceUtil {
    public static final int a = android.os.Process.myUid();

    @androidx.annotation.Nullable
    public static final java.lang.reflect.Method b = e();

    @androidx.annotation.Nullable
    public static final java.lang.reflect.Method c = g();

    @androidx.annotation.Nullable
    public static final java.lang.reflect.Method d = h();

    @androidx.annotation.Nullable
    public static final java.lang.reflect.Method e = i();

    @androidx.annotation.Nullable
    public static final java.lang.reflect.Method f = j();

    @androidx.annotation.Nullable
    public static final java.lang.reflect.Method g = k();

    @androidx.annotation.Nullable
    public static final java.lang.reflect.Method h = l();

    public static int a(android.content.Context context, java.lang.String str) {
        try {
            android.content.pm.ApplicationInfo applicationInfo = com.google.android.gms.common.wrappers.Wrappers.packageManager(context).getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.uid;
            }
            java.lang.String valueOf = java.lang.String.valueOf(str);
            if (valueOf.length() != 0) {
                "Could not get applicationInfo from package: ".concat(valueOf);
            }
            return -1;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            java.lang.String valueOf2 = java.lang.String.valueOf(str);
            if (valueOf2.length() != 0) {
                "Could not find package: ".concat(valueOf2);
            }
            return -1;
        }
    }

    public static int b(android.os.WorkSource workSource) {
        java.lang.reflect.Method method = d;
        if (method != null) {
            try {
                return ((java.lang.Integer) com.google.android.gms.common.internal.Preconditions.checkNotNull(method.invoke(workSource, new java.lang.Object[0]))).intValue();
            } catch (java.lang.Exception e2) {
                android.util.Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
        return 0;
    }

    public static android.os.WorkSource c(int i, java.lang.String str) {
        android.os.WorkSource workSource = new android.os.WorkSource();
        f(workSource, i, str);
        return workSource;
    }

    @androidx.annotation.Nullable
    public static java.lang.String d(@androidx.annotation.Nullable android.os.WorkSource workSource, int i) {
        java.lang.reflect.Method method = f;
        if (method == null) {
            return null;
        }
        try {
            return (java.lang.String) method.invoke(workSource, java.lang.Integer.valueOf(i));
        } catch (java.lang.Exception e2) {
            android.util.Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            return null;
        }
    }

    @androidx.annotation.Nullable
    public static java.lang.reflect.Method e() {
        try {
            return android.os.WorkSource.class.getMethod(com.anythink.expressad.d.a.b.ay, java.lang.Integer.TYPE);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static void f(android.os.WorkSource workSource, int i, @androidx.annotation.Nullable java.lang.String str) {
        java.lang.reflect.Method method = c;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, java.lang.Integer.valueOf(i), str);
                return;
            } catch (java.lang.Exception e2) {
                android.util.Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                return;
            }
        }
        java.lang.reflect.Method method2 = b;
        if (method2 != null) {
            try {
                method2.invoke(workSource, java.lang.Integer.valueOf(i));
            } catch (java.lang.Exception e3) {
                android.util.Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
            }
        }
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public static android.os.WorkSource fromPackage(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.Nullable java.lang.String str) {
        if (context != null && context.getPackageManager() != null && str != null) {
            try {
                android.content.pm.ApplicationInfo applicationInfo = com.google.android.gms.common.wrappers.Wrappers.packageManager(context).getApplicationInfo(str, 0);
                if (applicationInfo != null) {
                    return c(applicationInfo.uid, str);
                }
                if (str.length() != 0) {
                    "Could not get applicationInfo from package: ".concat(str);
                }
                return null;
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                if (str.length() != 0) {
                    "Could not find package: ".concat(str);
                }
            }
        }
        return null;
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public static android.os.WorkSource fromPackageAndModuleExperimentalPi(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.String str2) {
        java.lang.reflect.Method method;
        android.os.WorkSource workSource = null;
        if (context != null && context.getPackageManager() != null && str2 != null && str != null) {
            int a2 = a(context, str);
            if (a2 < 0) {
                return null;
            }
            workSource = new android.os.WorkSource();
            java.lang.reflect.Method method2 = g;
            if (method2 == null || (method = h) == null) {
                f(workSource, a2, str);
            } else {
                try {
                    java.lang.Object invoke = method2.invoke(workSource, new java.lang.Object[0]);
                    int i = a;
                    if (a2 != i) {
                        method.invoke(invoke, java.lang.Integer.valueOf(a2), str);
                    }
                    method.invoke(invoke, java.lang.Integer.valueOf(i), str2);
                } catch (java.lang.Exception unused) {
                }
            }
        }
        return workSource;
    }

    @androidx.annotation.Nullable
    public static java.lang.reflect.Method g() {
        if (com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()) {
            try {
                return android.os.WorkSource.class.getMethod(com.anythink.expressad.d.a.b.ay, java.lang.Integer.TYPE, java.lang.String.class);
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static java.util.List<java.lang.String> getNames(@androidx.annotation.Nullable android.os.WorkSource workSource) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int b2 = workSource == null ? 0 : b(workSource);
        if (b2 == 0) {
            return arrayList;
        }
        for (int i = 0; i < b2; i++) {
            java.lang.String d2 = d(workSource, i);
            if (!com.google.android.gms.common.util.Strings.isEmptyOrWhitespace(d2)) {
                arrayList.add((java.lang.String) com.google.android.gms.common.internal.Preconditions.checkNotNull(d2));
            }
        }
        return arrayList;
    }

    @androidx.annotation.Nullable
    public static java.lang.reflect.Method h() {
        try {
            return android.os.WorkSource.class.getMethod(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, new java.lang.Class[0]);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean hasWorkSourcePermission(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        return (context == null || context.getPackageManager() == null || com.google.android.gms.common.wrappers.Wrappers.packageManager(context).checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) ? false : true;
    }

    @androidx.annotation.Nullable
    public static java.lang.reflect.Method i() {
        try {
            return android.os.WorkSource.class.getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.Integer.TYPE);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    @androidx.annotation.Nullable
    public static java.lang.reflect.Method j() {
        if (com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()) {
            try {
                return android.os.WorkSource.class.getMethod("getName", java.lang.Integer.TYPE);
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static final java.lang.reflect.Method k() {
        if (com.google.android.gms.common.util.PlatformVersion.isAtLeastP()) {
            try {
                return android.os.WorkSource.class.getMethod("createWorkChain", new java.lang.Class[0]);
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    @android.annotation.SuppressLint({"PrivateApi"})
    public static final java.lang.reflect.Method l() {
        if (com.google.android.gms.common.util.PlatformVersion.isAtLeastP()) {
            try {
                return java.lang.Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", java.lang.Integer.TYPE, java.lang.String.class);
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }
}
