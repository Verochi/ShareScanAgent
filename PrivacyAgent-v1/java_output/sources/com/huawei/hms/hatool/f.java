package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public abstract class f {

    public static class a extends java.lang.Exception {
        public a(java.lang.String str) {
            super(str);
        }
    }

    public static java.lang.Object a(java.lang.Class cls, java.lang.String str, java.lang.Class[] clsArr, java.lang.Object[] objArr) {
        java.lang.String str2;
        if (cls == null) {
            throw new com.huawei.hms.hatool.f.a("class is null in invokeStaticFun");
        }
        if (clsArr == null) {
            if (objArr != null) {
                throw new com.huawei.hms.hatool.f.a("paramsType is null, but params is not null");
            }
        } else {
            if (objArr == null) {
                throw new com.huawei.hms.hatool.f.a("paramsType or params should be same");
            }
            if (clsArr.length != objArr.length) {
                throw new com.huawei.hms.hatool.f.a("paramsType len:" + clsArr.length + " should equal params.len:" + objArr.length);
            }
        }
        try {
        } catch (java.lang.NoSuchMethodException unused) {
            com.huawei.hms.hatool.y.f("hmsSdk", "invokeStaticFun(): cls.getMethod(),No Such Method !");
        }
        try {
            return cls.getMethod(str, clsArr).invoke(null, objArr);
        } catch (java.lang.IllegalAccessException unused2) {
            str2 = "invokeStaticFun(): method invoke Exception!";
            com.huawei.hms.hatool.y.f("hmsSdk", str2);
            return null;
        } catch (java.lang.IllegalArgumentException unused3) {
            str2 = "invokeStaticFun(): Illegal Argument!";
            com.huawei.hms.hatool.y.f("hmsSdk", str2);
            return null;
        } catch (java.lang.reflect.InvocationTargetException unused4) {
            str2 = "invokeStaticFun(): Invocation Target Exception!";
            com.huawei.hms.hatool.y.f("hmsSdk", str2);
            return null;
        }
    }

    public static java.lang.Object a(java.lang.String str, java.lang.String str2, java.lang.Class[] clsArr, java.lang.Object[] objArr) {
        java.lang.String str3;
        try {
            return a(java.lang.Class.forName(str), str2, clsArr, objArr);
        } catch (com.huawei.hms.hatool.f.a unused) {
            str3 = "invokeStaticFun(): Static function call Exception ";
            com.huawei.hms.hatool.y.f("hmsSdk", str3);
            return null;
        } catch (java.lang.ClassNotFoundException unused2) {
            str3 = "invokeStaticFun() Not found class!";
            com.huawei.hms.hatool.y.f("hmsSdk", str3);
            return null;
        }
    }

    public static java.lang.String a() {
        return a(com.alipay.sdk.m.c.a.a, "");
    }

    @android.annotation.SuppressLint({"HardwareIds"})
    public static java.lang.String a(android.content.Context context) {
        return context == null ? "" : android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str2;
        }
        java.lang.String a2 = a("android.os.SystemProperties", str, str2);
        return android.text.TextUtils.isEmpty(a2) ? a("com.huawei.android.os.SystemPropertiesEx", str, str2) : a2;
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.Object a2 = a(str, com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, new java.lang.Class[]{java.lang.String.class, java.lang.String.class}, new java.lang.Object[]{str2, str3});
        return a2 != null ? (java.lang.String) a2 : str3;
    }

    public static java.lang.String b() {
        java.lang.String a2 = a("com.huawei.android.os.SystemPropertiesEx", "ro.huawei.build.display.id", "");
        com.huawei.hms.hatool.y.c("hmsSdk", "SystemPropertiesEx: get rom_ver: " + a2);
        if (!android.text.TextUtils.isEmpty(a2)) {
            return a2;
        }
        java.lang.String str = android.os.Build.DISPLAY;
        com.huawei.hms.hatool.y.c("hmsSdk", "SystemProperties: get rom_ver: " + str);
        return str;
    }

    public static java.lang.String b(android.content.Context context) {
        android.os.Bundle bundle;
        java.lang.Object obj;
        try {
            android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("CHANNEL")) == null) {
                return "Unknown";
            }
            java.lang.String obj2 = obj.toString();
            return obj2.length() > 256 ? "Unknown" : obj2;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            com.huawei.hms.hatool.y.f("hmsSdk", "getChannel(): The packageName is not correct!");
            return "Unknown";
        }
    }

    public static java.lang.String c(android.content.Context context) {
        return context == null ? "" : context.getPackageName();
    }

    public static java.lang.String d(android.content.Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(c(context), 16384).versionName;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            com.huawei.hms.hatool.y.f("hmsSdk", "getVersion(): The package name is not correct!");
            return "";
        }
    }
}
