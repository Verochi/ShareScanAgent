package com.umeng.commonsdk.statistics.internal;

/* loaded from: classes19.dex */
public class a {
    private static android.content.Context a;
    private java.lang.String b;
    private java.lang.String c;

    /* renamed from: com.umeng.commonsdk.statistics.internal.a$a, reason: collision with other inner class name */
    public static class C0522a {
        private static final com.umeng.commonsdk.statistics.internal.a a = new com.umeng.commonsdk.statistics.internal.a(null);

        private C0522a() {
        }
    }

    private a() {
        this.b = null;
        this.c = null;
    }

    public /* synthetic */ a(com.umeng.commonsdk.statistics.internal.a.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.umeng.commonsdk.statistics.internal.a a(android.content.Context context) {
        if (a == null && context != null) {
            a = context.getApplicationContext();
        }
        return com.umeng.commonsdk.statistics.internal.a.C0522a.a;
    }

    private void f(java.lang.String str) {
        try {
            this.b = str.replaceAll("&=", " ").replaceAll("&&", " ").replaceAll("==", net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + "Android " + com.umeng.commonsdk.statistics.common.HelperUtils.getUmengMD5(com.umeng.commonsdk.utils.UMUtils.getAppkey(a));
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(a, th);
        }
    }

    private void g(java.lang.String str) {
        try {
            java.lang.String str2 = str.split("&&")[0];
            if (android.text.TextUtils.isEmpty(str2)) {
                return;
            }
            java.lang.String[] split = str2.split("&=");
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.umeng.analytics.pro.bo.aW);
            for (java.lang.String str3 : split) {
                if (!android.text.TextUtils.isEmpty(str3)) {
                    java.lang.String substring = str3.substring(0, 2);
                    if (substring.endsWith(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER)) {
                        substring = substring.replace(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER, "");
                    }
                    sb.append(substring);
                }
            }
            this.c = sb.toString();
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(a, th);
        }
    }

    public java.lang.String a() {
        return this.c;
    }

    public boolean a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("a");
    }

    public java.lang.String b() {
        return this.b;
    }

    public boolean b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("t");
    }

    public boolean c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(com.umeng.analytics.pro.bo.aJ);
    }

    public boolean d(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("h");
    }

    public void e(java.lang.String str) {
        java.lang.String substring = str.substring(0, str.indexOf(95));
        g(substring);
        f(substring);
    }
}
