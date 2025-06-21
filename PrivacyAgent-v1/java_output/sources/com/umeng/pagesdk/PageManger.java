package com.umeng.pagesdk;

/* loaded from: classes19.dex */
public class PageManger {
    public static final java.lang.String TAG = "PageManger";
    private static android.content.Context a = null;
    private static boolean b = false;
    private static com.efs.sdk.base.EfsReporter c = null;
    private static com.umeng.pagesdk.PageConfigManger d = null;
    private static boolean e = true;
    private static float f = 0.0f;
    public static boolean isDebug = true;

    public static android.content.Context getApplicationContext() {
        return a;
    }

    public static com.umeng.pagesdk.PageConfigManger getPageConfigManger() {
        return d;
    }

    public static float getRefreshRate() {
        return f;
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
        if (isInit()) {
            return;
        }
        a = context.getApplicationContext();
        c = efsReporter;
        d = new com.umeng.pagesdk.PageConfigManger(context, efsReporter);
        b = true;
    }

    public static boolean isControlMainThread() {
        return e;
    }

    public static boolean isInit() {
        return b;
    }

    public static void onTracePageBegin(android.app.Activity activity, java.lang.String str) {
        try {
            onTracePageBegin(activity, str, false);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void onTracePageBegin(android.app.Activity activity, java.lang.String str, boolean z) {
        float refreshRate;
        android.view.Display display;
        if (activity != null) {
            try {
                if (android.text.TextUtils.isEmpty(str)) {
                    return;
                }
                if (z || !(str.equals("onCreate") || str.equals("onStart") || str.equals("onResume") || str.equals("onPause"))) {
                    if (str.length() > 10) {
                        if (isDebug) {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder("tracePageBegin. method name is ");
                            sb.append(str);
                            sb.append("method name over length !");
                            return;
                        }
                        return;
                    }
                    if (e && !com.umeng.pagesdk.e.a(activity.getApplicationContext())) {
                        boolean z2 = isDebug;
                    }
                    java.lang.String name = activity.getClass().getName();
                    if (f <= 0.0f) {
                        if (android.os.Build.VERSION.SDK_INT >= 30) {
                            display = activity.getDisplay();
                            refreshRate = display.getRefreshRate();
                        } else {
                            refreshRate = activity.getWindowManager().getDefaultDisplay().getRefreshRate();
                        }
                        f = refreshRate;
                    }
                    com.umeng.pagesdk.d.a(name, str, z);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void onTracePageEnd(android.app.Activity activity, java.lang.String str) {
        try {
            onTracePageEnd(activity, str, false);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void onTracePageEnd(android.app.Activity activity, java.lang.String str, boolean z) {
        if (activity != null) {
            try {
                if (android.text.TextUtils.isEmpty(str)) {
                    return;
                }
                if (z || !(str.equals("onCreate") || str.equals("onStart") || str.equals("onResume") || str.equals("onPause"))) {
                    if (str.length() <= 10) {
                        if (e && !com.umeng.pagesdk.e.a(activity.getApplicationContext())) {
                            boolean z2 = isDebug;
                        }
                        com.umeng.pagesdk.d.b(activity.getClass().getName(), str, z);
                        return;
                    }
                    if (isDebug) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder("tracePageEnd. method name is ");
                        sb.append(str);
                        sb.append("method name over length !");
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setControlMainThread(boolean z) {
        e = z;
    }
}
