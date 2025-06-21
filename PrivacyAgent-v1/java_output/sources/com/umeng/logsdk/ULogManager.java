package com.umeng.logsdk;

/* loaded from: classes19.dex */
public class ULogManager {
    public static final java.lang.String TAG = "CodeLogManager";
    private static android.content.Context a = null;
    private static com.umeng.logsdk.ULogConfigManager b = null;
    private static com.efs.sdk.base.EfsReporter c = null;
    private static boolean d = false;
    private static java.lang.String e = "";
    private static java.lang.String f = "";
    private static long h = 0;
    private static long i = 0;
    public static boolean isDebug = true;
    private static org.json.JSONArray g = new org.json.JSONArray();
    private static android.os.Handler j = new com.umeng.logsdk.ULogManager.AnonymousClass1(android.os.Looper.getMainLooper());
    private static int k = 0;

    /* renamed from: com.umeng.logsdk.ULogManager$1, reason: invalid class name */
    public static class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 0) {
                com.umeng.logsdk.ULogManager.a(message);
            } else {
                if (i != 1) {
                    return;
                }
                com.umeng.logsdk.ULogManager.e();
            }
        }
    }

    /* renamed from: com.umeng.logsdk.ULogManager$2, reason: invalid class name */
    public static class AnonymousClass2 implements android.app.Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(android.app.Activity activity) {
            com.umeng.logsdk.ULogManager.b();
            int unused = com.umeng.logsdk.ULogManager.k;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(android.app.Activity activity) {
            com.umeng.logsdk.ULogManager.d();
            if (com.umeng.logsdk.ULogManager.k == 0) {
                com.umeng.logsdk.ULogManager.e();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void a(android.os.Message message) {
        android.os.Bundle data;
        org.json.JSONObject jSONObject;
        if (message == null || message.getData() == null || (data = message.getData()) == null) {
            return;
        }
        java.lang.String string = data.getString("tag");
        java.lang.String string2 = data.getString("message");
        boolean z = false;
        if (!android.text.TextUtils.isEmpty(string) && !android.text.TextUtils.isEmpty(string2) && string.length() <= com.umeng.logsdk.a.a && string2.length() <= com.umeng.logsdk.a.b && isInit() && (!android.text.TextUtils.isEmpty(getDeviceID()) || !android.text.TextUtils.isEmpty(getUserID()))) {
            z = true;
        }
        if (z) {
            org.json.JSONObject jSONObject2 = null;
            try {
                jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("tag", string);
                    jSONObject.put("msg", string2);
                    jSONObject.put(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL, message.arg1);
                    jSONObject.put("time", java.lang.System.currentTimeMillis());
                    jSONObject.put("process", com.efs.sdk.base.core.util.ProcessUtil.getCurrentProcessName());
                    jSONObject.put("thread", java.lang.Thread.currentThread().getName());
                } catch (java.lang.Throwable th) {
                    th = th;
                    jSONObject2 = jSONObject;
                    th.printStackTrace();
                    jSONObject = jSONObject2;
                    if (jSONObject != null) {
                    }
                    if (g.toString().getBytes().length < 18432) {
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
            if (jSONObject != null) {
                if (g.length() == 0) {
                    h = java.lang.System.currentTimeMillis();
                }
                g.put(jSONObject);
                new java.lang.StringBuilder("add mem is ").append(jSONObject.toString());
            }
            if (g.toString().getBytes().length < 18432) {
                new java.lang.StringBuilder("over max size upload. size is ").append(g.toString().getBytes().length);
                e();
            }
        }
    }

    public static /* synthetic */ int b() {
        int i2 = k;
        k = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int d() {
        int i2 = k;
        k = i2 - 1;
        return i2;
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        android.os.Message message = new android.os.Message();
        message.what = 0;
        message.arg1 = 1;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("tag", str);
        bundle.putString("message", str2);
        message.setData(bundle);
        j.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e() {
        org.json.JSONObject jSONObject;
        java.lang.Throwable th;
        if (g.length() > 0) {
            i = java.lang.System.currentTimeMillis();
            try {
                jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("taskid", "");
                    jSONObject.put("status", 0);
                    jSONObject.put("time_start", h);
                    jSONObject.put("time_end", i);
                    jSONObject.put("uid", com.umeng.logsdk.c.b(getUserID().getBytes()));
                    jSONObject.put("did", getDeviceID());
                    jSONObject.put("body", g);
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    th.printStackTrace();
                    if (jSONObject == null) {
                    }
                }
            } catch (java.lang.Throwable th3) {
                jSONObject = null;
                th = th3;
            }
            if (jSONObject == null) {
                com.efs.sdk.base.protocol.record.EfsJSONLog efsJSONLog = new com.efs.sdk.base.protocol.record.EfsJSONLog(com.efs.sdk.base.Constants.LOG_TYPE_CODELOGPERF);
                efsJSONLog.setLogBeginTime(h);
                efsJSONLog.setLogEndTime(i);
                efsJSONLog.put("codelog", jSONObject);
                com.efs.sdk.base.EfsReporter reporter = getReporter();
                if (reporter != null) {
                    reporter.send(efsJSONLog);
                    g = new org.json.JSONArray();
                }
            }
        }
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        android.os.Message message = new android.os.Message();
        message.what = 0;
        message.arg1 = 4;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("tag", str);
        bundle.putString("message", str2);
        message.setData(bundle);
        j.sendMessage(message);
    }

    public static java.lang.String getDeviceID() {
        return e;
    }

    public static com.efs.sdk.base.EfsReporter getReporter() {
        return c;
    }

    public static com.umeng.logsdk.ULogConfigManager getULogConfigManager() {
        return b;
    }

    public static java.lang.String getUserID() {
        return f;
    }

    public static void i(java.lang.String str, java.lang.String str2) {
        android.os.Message message = new android.os.Message();
        message.what = 0;
        message.arg1 = 2;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("tag", str);
        bundle.putString("message", str2);
        message.setData(bundle);
        j.sendMessage(message);
    }

    public static void init(android.content.Context context, com.efs.sdk.base.EfsReporter efsReporter) {
        if (context == null || efsReporter == null) {
            return;
        }
        try {
            if (isInit()) {
                return;
            }
            android.content.Context applicationContext = context.getApplicationContext();
            a = applicationContext;
            c = efsReporter;
            b = new com.umeng.logsdk.ULogConfigManager(applicationContext, efsReporter);
            registerActivityCallback(context);
            d = true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean isInit() {
        return d;
    }

    public static void registerActivityCallback(android.content.Context context) {
        if (context instanceof android.app.Application) {
            ((android.app.Application) context).registerActivityLifecycleCallbacks(new com.umeng.logsdk.ULogManager.AnonymousClass2());
        }
    }

    public static void setDeviceID(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || str.length() <= 128) {
            e = str;
        }
    }

    public static void setUserID(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || str.length() <= 128) {
            f = com.umeng.logsdk.c.a(str.getBytes());
        }
    }

    public static void v(java.lang.String str, java.lang.String str2) {
        android.os.Message message = new android.os.Message();
        message.what = 0;
        message.arg1 = 0;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("tag", str);
        bundle.putString("message", str2);
        message.setData(bundle);
        j.sendMessage(message);
    }

    public static void w(java.lang.String str, java.lang.String str2) {
        android.os.Message message = new android.os.Message();
        message.what = 0;
        message.arg1 = 3;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("tag", str);
        bundle.putString("message", str2);
        message.setData(bundle);
        j.sendMessage(message);
    }
}
