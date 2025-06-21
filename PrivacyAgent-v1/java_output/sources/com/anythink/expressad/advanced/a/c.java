package com.anythink.expressad.advanced.a;

/* loaded from: classes12.dex */
public class c extends android.content.BroadcastReceiver {
    private static final java.lang.String a = "c";
    private android.webkit.WebView b;
    private int c;

    public c(android.webkit.WebView webView) {
        this.b = webView;
    }

    private static void a(android.webkit.WebView webView, int i) {
        if (webView != null) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put(com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.m, i);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a(webView, com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.l, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }
    }

    public final void a() {
        this.b = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                a(this.b, 0);
                return;
            }
            if (!com.anythink.expressad.foundation.g.a.bW) {
                a(this.b, 0);
                return;
            }
            android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                a(this.b, 0);
                return;
            }
            if (activeNetworkInfo.getState() != android.net.NetworkInfo.State.CONNECTING && activeNetworkInfo.getState() != android.net.NetworkInfo.State.DISCONNECTING) {
                if (activeNetworkInfo.getType() == 1) {
                    a(this.b, 9);
                    return;
                }
                android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
                if (telephonyManager == null) {
                    a(this.b, 0);
                    return;
                }
                int networkType = telephonyManager.getNetworkType();
                this.c = networkType;
                int a2 = com.anythink.expressad.foundation.h.k.a(networkType);
                this.c = a2;
                a(this.b, a2);
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }
}
