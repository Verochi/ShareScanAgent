package com.efs.sdk.launch;

/* loaded from: classes22.dex */
public class LaunchManager {
    public static final java.lang.String APP_ATTACH_BASE_CONTEXT = "app_attachBaseContext";
    public static final java.lang.String APP_CONSTRUCT = "app_<init>";
    public static final java.lang.String APP_ON_CREATE = "app_onCreate";
    public static final java.lang.String PAGE_ON_CREATE = "page_onCreate";
    public static final java.lang.String PAGE_ON_RESUME = "page_onResume";
    public static final java.lang.String PAGE_ON_RE_START = "page_onReStart";
    public static final java.lang.String PAGE_ON_START = "page_onStart";
    public static final java.lang.String PAGE_ON_STOP = "page_onStop";
    public static final java.lang.String PAGE_ON_WINDOW = "page_on_window";
    private static com.efs.sdk.launch.LaunchConfigManager a = null;
    private static android.content.Context b = null;
    private static com.efs.sdk.base.EfsReporter c = null;
    private static boolean d = false;
    public static boolean isDebug = true;

    /* renamed from: com.efs.sdk.launch.LaunchManager$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ com.efs.sdk.base.EfsReporter b;

        public AnonymousClass1(android.content.Context context, com.efs.sdk.base.EfsReporter efsReporter) {
            this.a = context;
            this.b = efsReporter;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.efs.sdk.launch.LaunchConfigManager unused = com.efs.sdk.launch.LaunchManager.a = new com.efs.sdk.launch.LaunchConfigManager(this.a, this.b);
                com.efs.sdk.launch.LaunchManager.a();
                com.efs.sdk.launch.b.a(this.a, (java.lang.String) null);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static /* synthetic */ boolean a() {
        d = true;
        return true;
    }

    public static com.efs.sdk.launch.LaunchConfigManager getLaunchConfigManager() {
        return a;
    }

    public static com.efs.sdk.base.EfsReporter getReporter() {
        return c;
    }

    public static void init(android.content.Context context, com.efs.sdk.base.EfsReporter efsReporter) {
        if (context == null || efsReporter == null) {
            try {
                if (isDebug) {
                    return;
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        android.content.Context applicationContext = context.getApplicationContext();
        if (com.efs.sdk.launch.c.e(applicationContext) && !isInit()) {
            b = context.getApplicationContext();
            c = efsReporter;
            com.efs.sdk.launch.a.a(new com.efs.sdk.launch.LaunchManager.AnonymousClass1(applicationContext, efsReporter));
        }
    }

    public static boolean isInit() {
        return d;
    }

    public static void onTraceApp(android.app.Application application, java.lang.String str, boolean z) {
        if (application != null) {
            try {
                if (android.text.TextUtils.isEmpty(str)) {
                    return;
                }
                if (str.equals(APP_ATTACH_BASE_CONTEXT) || android.os.Looper.getMainLooper() == android.os.Looper.myLooper()) {
                    com.efs.sdk.launch.b.a(str, z);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void onTraceBegin(android.content.Context context, java.lang.String str, long j) {
        if (context != null) {
            try {
                if (android.text.TextUtils.isEmpty(str)) {
                    return;
                }
                context.getApplicationContext();
                if (android.os.Looper.getMainLooper() == android.os.Looper.myLooper() && str.length() <= 10) {
                    com.efs.sdk.launch.b.a(str, j);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void onTraceEnd(android.content.Context context, java.lang.String str, long j) {
        if (context != null) {
            try {
                if (android.text.TextUtils.isEmpty(str)) {
                    return;
                }
                context.getApplicationContext();
                if (android.os.Looper.getMainLooper() == android.os.Looper.myLooper() && str.length() <= 10) {
                    com.efs.sdk.launch.b.b(str, j);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void onTracePage(android.app.Activity activity, java.lang.String str, boolean z) {
        if (activity != null) {
            try {
                if (android.text.TextUtils.isEmpty(str)) {
                    return;
                }
                activity.getApplicationContext();
                if (android.os.Looper.getMainLooper() != android.os.Looper.myLooper()) {
                    return;
                }
                com.efs.sdk.launch.b.a(activity, str, z);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void sendLaunchCache(android.content.Context context, java.lang.String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            com.efs.sdk.launch.b.a(context, str);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
