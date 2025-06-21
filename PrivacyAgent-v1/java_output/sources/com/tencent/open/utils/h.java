package com.tencent.open.utils;

/* loaded from: classes19.dex */
public class h {
    private static com.tencent.open.utils.h a;
    private volatile java.lang.ref.WeakReference<android.content.SharedPreferences> b = null;

    public static synchronized com.tencent.open.utils.h a() {
        com.tencent.open.utils.h hVar;
        synchronized (com.tencent.open.utils.h.class) {
            if (a == null) {
                a = new com.tencent.open.utils.h();
            }
            hVar = a;
        }
        return hVar;
    }

    public java.lang.String a(android.content.Context context, java.lang.String str) {
        if (this.b == null || this.b.get() == null) {
            this.b = new java.lang.ref.WeakReference<>(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            java.lang.String host = new java.net.URL(str).getHost();
            if (host == null) {
                com.tencent.open.log.SLog.e("openSDK_LOG.ServerSetting", "Get host error. url=" + str);
                return str;
            }
            java.lang.String string = this.b.get().getString(host, null);
            if (string != null && !host.equals(string)) {
                java.lang.String replace = str.replace(host, string);
                com.tencent.open.log.SLog.v("openSDK_LOG.ServerSetting", "return environment url : " + replace);
                return replace;
            }
            com.tencent.open.log.SLog.v("openSDK_LOG.ServerSetting", "host=" + host + ", envHost=" + string);
            return str;
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.ServerSetting", "getEnvUrl url=" + str + "error.: " + e.getMessage());
            return str;
        }
    }
}
