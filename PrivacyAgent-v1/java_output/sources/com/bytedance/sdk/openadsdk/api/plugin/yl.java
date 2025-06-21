package com.bytedance.sdk.openadsdk.api.plugin;

/* loaded from: classes31.dex */
public class yl {
    private static volatile dalvik.system.BaseDexClassLoader v;
    private static volatile com.bytedance.sdk.openadsdk.TTPluginListener vl;
    private final android.content.Context x;
    private static final java.lang.String vw = "next" + java.io.File.separator;
    private static final java.util.HashMap<java.lang.String, com.bytedance.sdk.openadsdk.TTPluginListener> wg = new java.util.HashMap<>();
    private static final java.util.HashMap<java.lang.String, android.os.Handler> t = new java.util.HashMap<>();
    private static volatile com.bytedance.sdk.openadsdk.api.plugin.yl yl = null;
    private final java.util.concurrent.CountDownLatch kz = new java.util.concurrent.CountDownLatch(1);
    private volatile boolean bt = false;
    private volatile java.lang.String o = "none";
    private org.json.JSONObject es = new org.json.JSONObject();
    private com.bykv.vk.openvk.api.proto.EventListener z = null;

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.yl$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    public class AnonymousClass1 implements com.bytedance.pangle.log.IZeusReporter {
        public AnonymousClass1() {
        }

        @Override // com.bytedance.pangle.log.IZeusReporter
        public void report(java.lang.String str, org.json.JSONObject jSONObject) {
            if ("load_finish".equals(str) && jSONObject != null && "com.byted.pangle".endsWith(jSONObject.optString("plugin_package_name"))) {
                try {
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put("duration", jSONObject.opt("duration"));
                    jSONObject2.put("message", jSONObject.opt("message"));
                    com.bytedance.sdk.openadsdk.api.plugin.yl.this.es.put("zeus", jSONObject2);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
            if (com.bytedance.sdk.openadsdk.TTAdSdk.isInitSuccess()) {
                com.bytedance.sdk.openadsdk.api.plugin.t.vw(str, jSONObject);
            } else {
                com.bytedance.sdk.openadsdk.api.plugin.t.wg(str, jSONObject);
            }
        }

        @Override // com.bytedance.pangle.log.IZeusReporter
        public void saveRecord(java.lang.String str, java.lang.String str2) {
            com.bytedance.sdk.openadsdk.api.plugin.wg.vw(str, str2);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.yl$2, reason: invalid class name */
    /* loaded from: classes22.dex */
    public class AnonymousClass2 extends com.bytedance.pangle.ZeusPluginStateListener {
        public AnonymousClass2() {
        }

        @Override // com.bytedance.pangle.ZeusPluginStateListener
        public void onPluginStateChange(java.lang.String str, int i, java.lang.Object... objArr) {
            com.bytedance.sdk.openadsdk.api.t.wg("TTPluginManager", str + " state changed, " + i);
            if (i != 9 || android.text.TextUtils.equals(str, "com.byted.pangle")) {
                return;
            }
            com.bytedance.sdk.openadsdk.api.plugin.yl.this.t(str);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.yl$3, reason: invalid class name */
    /* loaded from: classes22.dex */
    public class AnonymousClass3 implements com.bytedance.pangle.ZeusPluginInstallListener {
        public AnonymousClass3() {
        }

        @Override // com.bytedance.pangle.ZeusPluginInstallListener
        public void onPluginInstall(java.lang.String str, int i, java.lang.String str2) {
            if (i == 7) {
                com.bytedance.sdk.openadsdk.api.plugin.yl.this.wg(str, i);
                return;
            }
            if (i == 6) {
                com.bytedance.sdk.openadsdk.api.plugin.yl.this.wg(str, i);
                if (com.bytedance.sdk.openadsdk.api.plugin.yl.this.z == null || !"com.byted.pangle".equals(str)) {
                    com.bytedance.sdk.openadsdk.api.t.wg("TTPluginManager", "no main pl");
                } else {
                    com.bytedance.sdk.openadsdk.api.plugin.yl.this.z.onEvent(0, com.bykv.vw.vw.vw.vw.vw.vw().vw(true).wg());
                }
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.yl$4, reason: invalid class name */
    /* loaded from: classes22.dex */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ com.bytedance.sdk.openadsdk.TTPluginListener vw;

        public AnonymousClass4(com.bytedance.sdk.openadsdk.TTPluginListener tTPluginListener) {
            this.vw = tTPluginListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.api.t.wg("TTPluginManager", "Load plugin failed, caused by timeout.");
            this.vw.onPluginListener(1001, null, null, null);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.yl$5, reason: invalid class name */
    /* loaded from: classes22.dex */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ com.bytedance.sdk.openadsdk.TTPluginListener vw;

        public AnonymousClass5(com.bytedance.sdk.openadsdk.TTPluginListener tTPluginListener) {
            this.vw = tTPluginListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.String packageName = this.vw.packageName();
            com.bytedance.pangle.plugin.Plugin plugin = (com.bytedance.pangle.Zeus.isPluginInstalled(packageName) && (com.bytedance.pangle.Zeus.isPluginLoaded(packageName) || com.bytedance.pangle.Zeus.loadPlugin(packageName))) ? com.bytedance.pangle.Zeus.getPlugin(packageName) : null;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Find plugin:");
            sb.append(plugin != null);
            com.bytedance.sdk.openadsdk.api.t.wg("TTPluginManager", sb.toString());
            if (plugin == null) {
                com.bytedance.sdk.openadsdk.TTPluginListener unused = com.bytedance.sdk.openadsdk.api.plugin.yl.vl = this.vw;
            } else {
                com.bytedance.sdk.openadsdk.api.plugin.yl.wg(plugin);
                this.vw.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
            }
        }
    }

    /* loaded from: classes22.dex */
    public static final class t implements com.bykv.vk.openvk.api.proto.EventListener, java.io.Serializable {
        private void vw(com.bytedance.sdk.openadsdk.api.plugin.yl.vw vwVar) {
            try {
                if (android.text.TextUtils.isEmpty(vwVar.mPackageName) || !vwVar.mPackageName.equals("com.byted.pangle")) {
                    return;
                }
                com.bytedance.sdk.openadsdk.api.plugin.yl.vw(com.bytedance.sdk.openadsdk.TTAppContextHolder.getContext()).wg();
            } catch (java.lang.Exception unused) {
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.EventListener
        public com.bykv.vk.openvk.api.proto.ValueSet onEvent(int i, com.bykv.vk.openvk.api.proto.Result result) {
            com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw();
            if (i == 1) {
                com.bytedance.sdk.openadsdk.api.plugin.wg.vw("plugin_download", "plugin update start");
                com.bykv.vk.openvk.api.proto.ValueSet values = result.values();
                if (values == null) {
                    com.bytedance.sdk.openadsdk.api.plugin.wg.vw("plugin_download", "valueSet empty");
                    return null;
                }
                java.lang.String stringValue = values.stringValue(3);
                int code = result.code();
                if (!result.isSuccess()) {
                    com.bytedance.sdk.openadsdk.api.plugin.wg.vw("plugin_download", "plugin update received failed");
                    com.bytedance.sdk.openadsdk.api.t.v("TTPluginManager", "plugin update received failed");
                    com.bytedance.sdk.openadsdk.api.plugin.yl.t(stringValue, code);
                    return null;
                }
                com.bytedance.sdk.openadsdk.api.plugin.yl.vw v = com.bytedance.sdk.openadsdk.api.plugin.yl.v(values.stringValue(2));
                if (v == null || android.text.TextUtils.isEmpty(v.mPackageName)) {
                    com.bytedance.sdk.openadsdk.api.plugin.wg.vw("plugin_download", "plugin update received with invalid config");
                    com.bytedance.sdk.openadsdk.api.t.v("TTPluginManager", "plugin update received with invalid config");
                    return null;
                }
                com.bytedance.sdk.openadsdk.api.plugin.wg.vw("plugin_download", "plugin update received: " + v.mPackageName);
                com.bytedance.sdk.openadsdk.api.t.v("TTPluginManager", "plugin update received: " + v.mPackageName);
                if (v.isRevert()) {
                    com.bytedance.sdk.openadsdk.api.plugin.wg.vw("plugin_download", "plugin revert " + v.mPackageName);
                    com.bytedance.pangle.Zeus.unInstallPlugin(v.mPackageName);
                } else {
                    vw(v);
                    com.bytedance.sdk.openadsdk.api.plugin.wg.vw("plugin_download", "plugin install");
                    if (com.bytedance.sdk.openadsdk.api.plugin.yl.wg(v)) {
                        vw.vw(4, true);
                    }
                }
            }
            return vw.wg();
        }
    }

    /* loaded from: classes22.dex */
    public static final class vw extends com.bytedance.pangle.download.PluginDownloadBean {
        public java.lang.String vw = "";
        public java.io.File wg = null;

        public vw() {
            this.mBackupUrlList = null;
        }
    }

    /* loaded from: classes22.dex */
    public static final class wg implements com.bytedance.pangle.log.IZeusLogger {
        private wg() {
        }

        public /* synthetic */ wg(com.bytedance.sdk.openadsdk.api.plugin.yl.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
            com.bytedance.sdk.openadsdk.api.t.t(str, str2, th);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void i(java.lang.String str, java.lang.String str2) {
            com.bytedance.sdk.openadsdk.api.t.t(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void v(java.lang.String str, java.lang.String str2) {
            com.bytedance.sdk.openadsdk.api.t.vw(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(java.lang.String str, java.lang.String str2) {
            com.bytedance.sdk.openadsdk.api.t.v(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
            com.bytedance.sdk.openadsdk.api.t.wg(str, str2, th);
        }
    }

    private yl(android.content.Context context) {
        this.x = context.getApplicationContext();
        try {
            com.bytedance.pangle.GlobalParam.getInstance().closeHookHuaweiOnInit(true);
        } catch (java.lang.Throwable th) {
            com.bytedance.sdk.openadsdk.api.t.wg("TTPluginManager", "Unexpected error for closeHookHuaweiOnInit.", th);
        }
        wg(context.getApplicationContext());
    }

    private static java.io.File t(android.content.Context context) {
        return new java.io.File(new java.io.File(context.getDir("tt_pangle_bykv_file", 0), "pangle_com.byted.pangle"), vw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(java.lang.String str) {
        com.bytedance.pangle.plugin.Plugin plugin = com.bytedance.pangle.Zeus.getPlugin(str, false);
        try {
            if (plugin.mClassLoader != null) {
                com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager().register(com.bykv.vw.vw.vw.vw.wg.vw(3).vw(0, 1).vw(1, str).vw(2, plugin.mClassLoader).wg());
            }
        } catch (java.lang.Throwable th) {
            com.bytedance.sdk.openadsdk.api.t.vw("TTPluginManager", "initPluginService failed in ".concat(java.lang.String.valueOf(str)), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t(java.lang.String str, int i) {
        com.bytedance.sdk.openadsdk.api.t.v("TTPluginManager", "plugin update failed");
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("code", i);
        com.bytedance.sdk.openadsdk.TTPluginListener tTPluginListener = wg.get(str);
        if (tTPluginListener != null) {
            tTPluginListener.onPluginListener(1001, null, null, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.api.plugin.yl.vw v(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            return vw(new org.json.JSONObject(str));
        } catch (org.json.JSONException unused) {
            com.bytedance.sdk.openadsdk.api.t.yl("TTPluginManager", "Invalid plugin info:".concat(java.lang.String.valueOf(str)));
            return null;
        }
    }

    private static com.bytedance.sdk.openadsdk.api.plugin.yl.vw vw(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.api.plugin.yl.vw vwVar = new com.bytedance.sdk.openadsdk.api.plugin.yl.vw();
        vwVar.mPackageName = jSONObject.optString("package_name");
        vwVar.mVersionCode = jSONObject.optInt("version_code");
        vwVar.mUrl = jSONObject.optString("download_url");
        vwVar.mMd5 = jSONObject.optString("md5");
        vwVar.mApiVersionMin = jSONObject.optInt("min_version");
        vwVar.mApiVersionMax = jSONObject.optInt("max_version");
        vwVar.vw = jSONObject.optString("sign");
        vwVar.mFlag = jSONObject.optBoolean("is_revert") ? 3 : 2;
        vwVar.wg = new java.io.File(jSONObject.optString("plugin_file"));
        return vwVar;
    }

    public static com.bytedance.sdk.openadsdk.api.plugin.yl vw(android.content.Context context) {
        if (yl == null) {
            synchronized (com.bytedance.sdk.openadsdk.api.plugin.yl.class) {
                if (yl == null) {
                    yl = new com.bytedance.sdk.openadsdk.api.plugin.yl(context);
                }
            }
        }
        return yl;
    }

    public static java.lang.String vw(int i) {
        char[] charArray = java.lang.String.valueOf(i).toCharArray();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            sb.append(charArray[i2]);
            if (i2 < charArray.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    public static java.lang.String vw(java.lang.String str) {
        com.bytedance.pangle.plugin.Plugin plugin;
        try {
            if (!com.bytedance.pangle.Zeus.isPluginInstalled(str) || (plugin = com.bytedance.pangle.Zeus.getPlugin(str)) == null) {
                return null;
            }
            return vw(plugin.getVersion());
        } catch (java.lang.Throwable unused) {
            com.bytedance.sdk.openadsdk.api.t.v("TTPluginManager", "Get local version failed");
            return null;
        }
    }

    public static void vw(java.lang.Throwable th) {
        if (th instanceof java.lang.AbstractMethodError) {
            com.bytedance.pangle.Zeus.unInstallPlugin("com.byted.pangle");
            com.bytedance.sdk.openadsdk.api.t.v("TTPluginManager", "AbstractMethodError, rollback to builtin version.");
        }
    }

    private static void vw(boolean z, java.lang.String str) {
        java.util.HashMap<java.lang.String, com.bytedance.sdk.openadsdk.TTPluginListener> hashMap = wg;
        com.bytedance.sdk.openadsdk.TTPluginListener tTPluginListener = hashMap.get(str);
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Install dl plugin ");
        sb.append(str);
        sb.append(z ? " success" : " failed");
        sb.append(", need notify: ");
        sb.append(tTPluginListener != null);
        com.bytedance.sdk.openadsdk.api.t.wg("TTPluginManager", sb.toString());
        java.util.HashMap<java.lang.String, android.os.Handler> hashMap2 = t;
        android.os.Handler handler = hashMap2.get(str);
        if (z) {
            com.bytedance.sdk.openadsdk.TTPluginListener tTPluginListener2 = vl;
            if (!vw(tTPluginListener2, str) && (tTPluginListener == null || handler == null)) {
                return;
            }
            if (com.bytedance.pangle.Zeus.loadPlugin(str)) {
                com.bytedance.pangle.plugin.Plugin plugin = com.bytedance.pangle.Zeus.getPlugin(str);
                wg(plugin);
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                if (tTPluginListener != null) {
                    tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                }
                if (vw(tTPluginListener2, str)) {
                    tTPluginListener2.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                    vl = null;
                }
            } else {
                com.bytedance.sdk.openadsdk.api.t.wg("TTPluginManager", "handle installed, load failed");
                t(str, 1002);
            }
        } else {
            com.bytedance.sdk.openadsdk.api.t.wg("TTPluginManager", "handle installed failed");
            t(str, 1003);
        }
        hashMap.remove(str);
        hashMap2.remove(str);
    }

    private static boolean vw(com.bytedance.sdk.openadsdk.TTPluginListener tTPluginListener, java.lang.String str) {
        if (tTPluginListener == null || tTPluginListener.packageName() == null) {
            return false;
        }
        return tTPluginListener.packageName().equals(str);
    }

    private void wg(android.content.Context context) {
        try {
            com.bytedance.sdk.openadsdk.api.plugin.yl.AnonymousClass1 anonymousClass1 = new com.bytedance.sdk.openadsdk.api.plugin.yl.AnonymousClass1();
            com.bytedance.pangle.GlobalParam globalParam = com.bytedance.pangle.GlobalParam.getInstance();
            globalParam.setReporter(anonymousClass1);
            globalParam.setCheckPermission(false);
            globalParam.setDownloadDir(t(context));
            globalParam.setLogger(new com.bytedance.sdk.openadsdk.api.plugin.yl.wg(null));
            globalParam.setSignature("com.byted.pangle", "MIIDfTCCAmWgAwIBAgIEfRwYPjANBgkqhkiG9w0BAQsFADBvMQswCQYDVQQGEwJDTjEQMA4GA1UECBMHQmVpamluZzEQMA4GA1UEBxMHQmVpamluZzESMBAGA1UEChMJQnl0ZURhbmNlMQ8wDQYDVQQLEwZQYW5nbGUxFzAVBgNVBAMTDkNodWFuIFNoYW4gSmlhMB4XDTIxMTEwODA2MjQzOVoXDTQ2MTEwMjA2MjQzOVowbzELMAkGA1UEBhMCQ04xEDAOBgNVBAgTB0JlaWppbmcxEDAOBgNVBAcTB0JlaWppbmcxEjAQBgNVBAoTCUJ5dGVEYW5jZTEPMA0GA1UECxMGUGFuZ2xlMRcwFQYDVQQDEw5DaHVhbiBTaGFuIEppYTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAIBKeRL+4mfCn1SLYv6OemfwwItkjlLPyqOEugkV6lanFTcZgLwEl5LIkL0y28UncPtMX1Mii6DzCdJ/plw7S9+RT/hYDneu339IKWojaU2qai/5FokHlQ0MMnYl5yry00ghVPsl1u+03cQA2ZnjIMiFhrBJpQzHt7IYvq2aEEMBcY8uT7iFoBI848e1mL1joVS2z02C3NliP7ZNARkXH+rTQAlCJulT5IZk+V/PTaKqzgNrkhsKh0/tBmU7m8u79x/xpgGsE19H18AgS4P/9/MDCRe2Z35boZeccaUy2MXCwv3djzUcDk3rRzQPYzdpyyRnrFMuhiKesc5VHgUMs9kCAwEAAaMhMB8wHQYDVR0OBBYEFENENrNWGzc2WhxdvhoMDs57U70zMA0GCSqGSIb3DQEBCwUAA4IBAQAHqDCrmvyBBmIGXwuL1rwS/Qv9ZJIZykBIaNMm+H1IfitCl4yXd9N2n+PjE0UZtxZ21UZOt9wAr+RFiSl5YRXqpt7WLARTy4YW3RiQ+wiL7bshzeSYBoSiC427Bfeq0WjwY0/jHlr8uouppyJOz++6U9hrYX2EW/6UjH5XlWiKQJ6b2ZzPcP8Xpg/TJn4tWvXJP6jw9kRRP2GmMttY78leWQst2QEZILmWJubXRLPj9O+qx2uP9oGTD4sc1vb9hzkOHBIHzGaalqLFbbGaeFpLFHoGTsnOfPTwUVKDZYmxbkcmR1bp7eYOW+nSQNMLn0FjDewZl5l37Sa/gz0WVHon");
            globalParam.setSignature("com.byted.csj.ext", "MIIDezCCAmOgAwIBAgIENkE1KDANBgkqhkiG9w0BAQsFADBtMQswCQYDVQQGEwI4NjEQMA4GA1UECBMHYmVpamluZzEQMA4GA1UEBxMHYmVpamluZzESMBAGA1UEChMJYnl0ZWRhbmNlMRIwEAYDVQQLEwlieXRlZGFuY2UxEjAQBgNVBAMTCWJ5dGVkYW5jZTAgFw0yMjExMDIwODI3MzlaGA8yMDUwMDMyMDA4MjczOVowbTELMAkGA1UEBhMCODYxEDAOBgNVBAgTB2JlaWppbmcxEDAOBgNVBAcTB2JlaWppbmcxEjAQBgNVBAoTCWJ5dGVkYW5jZTESMBAGA1UECxMJYnl0ZWRhbmNlMRIwEAYDVQQDEwlieXRlZGFuY2UwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCc9Z2F3xxOMX1qTXMy2aPmS9OSkqrp8C8bHwS1hkNVR4umKREuqOn73INNo+R706jaCVnlPwxDwWjtX6H74DE4CveivyM9f2wNC3yIyDW+5j7lW/keTQcOlGLDEJQv4O/6FbB/jNU6epjyNaNIZhgZcvTpgaSixbdyHzRTFmvMh+WovdVK/J9LnHOQ+pmPZj7NB6MQRGMUrPEotLHQca3cmnLrnPAaZQaVoaFE9lOt9syyqEuf361SprNIGDtbkJuX3EqV/QOKWFwZX94IS7ZGSvfyCojcD4kaUSbaSoZC7zEuBb7l69g+ZMrJ/v6wkm01wxsNNssUwF7k6Sp0zubbAgMBAAGjITAfMB0GA1UdDgQWBBSxk+gVdDco1dP65hP67qoKNlMEYDANBgkqhkiG9w0BAQsFAAOCAQEAfosExl/AYEbS2xqHBTHa28cvnp/SElUQuzW6aWLqkfk9cxmFSI/euUV3/eB8RN+U2X47Y05u6+XUxTv0tSSEtyXNawm0qWH8jkR4gZY38YqBChKjhea668oT5X3Uocrw7SYXO/BfI8SKPa0uI/U8Cyl3uctbmmq/pPUkd3mKAy+HgyJoThD6K0oyiADlygngUMVTv6Uvid4qPj/bBnxI+LvVeX4l1dxGqWkiafQW9sz+RbFdge3X2XsSH4eo01BsCwOYEv1lHO2FrbAtFNpnIsSqrERdFaAJZ3tlJmg9bA03png8A2AajEjkhaOhduJB8zkSlvHNpoQMIAS9WtkG/w==");
            globalParam.setSignature("com.byted.live.lite", "MIIDSTCCAjGgAwIBAgIEaLy5tzANBgkqhkiG9w0BAQsFADBVMQswCQYDVQQGEwIxMTEMMAoGA1UECBMDMTExMQ4wDAYDVQQHEwUxMTExMTEMMAoGA1UEChMDMTExMQwwCgYDVQQLEwMxMTExDDAKBgNVBAMTAzExMTAeFw0yMDEyMDMxMjQyMTJaFw00NTExMjcxMjQyMTJaMFUxCzAJBgNVBAYTAjExMQwwCgYDVQQIEwMxMTExDjAMBgNVBAcTBTExMTExMQwwCgYDVQQKEwMxMTExDDAKBgNVBAsTAzExMTEMMAoGA1UEAxMDMTExMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA45E52YdkJm4gPCXZq7KDoM1h6pgSswllC/CwDOmh8pDGvX4ROaYP1vr2biRlXMHg7G0iXpxWVdlTtx+4QFd3dC+cGJQk0f6apGo2n2RpMA0zIsSf0VO1a3GjWLei5INo+4RDdciqJ4jfsoqBIjZETRkky+UU4eO/oyrAwOu4KdMln3Bg3u7eHWU4kMFrXxrRruT3Q/9gzlO90yQa0CZPWVDrk6cGJtJwJGhWm+62S3U8D26HE++eGP7ve83QBDGtKqx7HpCAFWUiYBgXGq12H0amQDkKcPcr/EFCaBlombSgkN0t6zBX80m+wcUPC75IBTmMV/DT2dXcgjZ2I1JSCQIDAQABoyEwHzAdBgNVHQ4EFgQUPDyIeKI0KhZFPHyn36gMMIYrpukwDQYJKoZIhvcNAQELBQADggEBAHkl0DoCRwn+XKsDJE+wGMpBBqUDzL6DSOnJx4SNqb7YZZU0ThcDK7jY4If3QRkvMio6ODrVZc2U/m/Tc3VeMk5h2W2UZRUWHNH3k9Xe0720uL20ZeH2Y6IG4L5HG8kIbTbFtX3gJpPG/xAcez+CzyCFLWQAZt1N+csG0syWkXJ0Nryq8VrgSCyCXD1KzFxrOe+65wtu50Vi68Vlbk7BZe/G8Qm0RhKmxq5BPMBJ4uY3be+03Ba5qC//o1XQHOEAjrJKXcN5wqHdFZTkmuxVyIPogZOzx4JlNl0zOrYGDJxp7aZfKF9FkXQyF7x0Ns3mZEtjx/+flXRzAAU9MDhPr/0=");
            com.bytedance.pangle.Zeus.registerPluginStateListener(new com.bytedance.sdk.openadsdk.api.plugin.yl.AnonymousClass2());
            globalParam.closeBgDex2oat(true);
            com.bytedance.pangle.Zeus.init((android.app.Application) context, true);
            com.bytedance.pangle.Zeus.registerPluginInstallListener(new com.bytedance.sdk.openadsdk.api.plugin.yl.AnonymousClass3());
            this.bt = true;
        } catch (java.lang.Throwable th) {
            com.bytedance.sdk.openadsdk.api.t.wg("TTPluginManager", "Unexpected error for init zeus.", th);
            this.o = th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void wg(com.bytedance.pangle.plugin.Plugin plugin) {
        if (plugin == null) {
            com.bytedance.sdk.openadsdk.api.t.v("TTPluginManager", "plugin is null.");
            return;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("action", 0);
        bundle.putString("plugin_pkg_name", plugin.mPkgName);
        bundle.putString(com.bytedance.sdk.openadsdk.api.plugin.PluginConstants.KEY_PLUGIN_VERSION, vw(plugin.getVersion()));
        com.bytedance.sdk.openadsdk.TTAdManager adManager = com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager();
        if (adManager != null) {
            adManager.getExtra(android.os.Bundle.class, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wg(java.lang.String str, int i) {
        if ("com.byted.pangle".equals(str) && i == 6) {
            com.bytedance.sdk.openadsdk.api.t.v("TTPluginManager", "notify to end wait");
            this.kz.countDown();
        }
        vw(i == 6, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean wg(com.bytedance.sdk.openadsdk.api.plugin.yl.vw vwVar) {
        java.io.File file;
        if (vwVar == null || (file = vwVar.wg) == null) {
            com.bytedance.sdk.openadsdk.api.t.v("TTPluginManager", "plugin config is null");
            return false;
        }
        boolean syncInstallPlugin = com.bytedance.pangle.Zeus.syncInstallPlugin(vwVar.mPackageName, file.getAbsolutePath());
        vw(syncInstallPlugin, vwVar.mPackageName);
        return syncInstallPlugin;
    }

    public android.os.Bundle vw(java.lang.String str, android.os.Bundle bundle) {
        java.lang.String vw2 = vw(str);
        if (!android.text.TextUtils.isEmpty(vw2)) {
            bundle.putString(com.bytedance.sdk.openadsdk.api.plugin.PluginConstants.KEY_PLUGIN_VERSION, vw2);
        }
        android.os.Bundle bundle2 = new android.os.Bundle();
        bundle2.putBundle(str, bundle);
        android.os.Bundle bundle3 = new android.os.Bundle();
        bundle3.putBundle(com.bytedance.sdk.openadsdk.api.plugin.PluginConstants.KEY_PL_CONFIG_INFO, bundle2);
        return bundle3;
    }

    public dalvik.system.BaseDexClassLoader vw(com.bytedance.sdk.openadsdk.api.plugin.v vVar) throws java.lang.Exception {
        return vw(vVar, 60000);
    }

    public dalvik.system.BaseDexClassLoader vw(com.bytedance.sdk.openadsdk.api.plugin.v vVar, int i) throws java.lang.Exception {
        boolean z;
        if (!this.bt) {
            com.bytedance.sdk.openadsdk.api.t.v("TTPluginManager", "Zeus init failed.");
            throw new com.bytedance.sdk.openadsdk.api.plugin.vw(4, this.o);
        }
        if (!com.bytedance.pangle.Zeus.isPluginInstalled("com.byted.pangle")) {
            try {
                com.bytedance.sdk.openadsdk.api.t.wg("TTPluginManager", "wait start");
                this.kz.await(i, java.util.concurrent.TimeUnit.MILLISECONDS);
                com.bytedance.sdk.openadsdk.api.t.wg("TTPluginManager", "wait done");
                vVar.wg("wait_install_cost");
            } catch (java.lang.Exception unused) {
                com.bytedance.sdk.openadsdk.api.t.wg("TTPluginManager", "Install wait time out");
                throw new com.bytedance.sdk.openadsdk.api.plugin.vw(8, "install wait timeout");
            }
        }
        if (com.bytedance.pangle.Zeus.isPluginLoaded("com.byted.pangle") || com.bytedance.pangle.Zeus.loadPlugin("com.byted.pangle")) {
            v = com.bytedance.pangle.Zeus.getPlugin("com.byted.pangle").mClassLoader;
            z = true;
        } else {
            z = false;
        }
        vVar.wg("get_classloader_cost");
        com.bytedance.pangle.Zeus.installFromDownloadDir();
        if (v == null) {
            if (this.kz.getCount() != 0) {
                com.bytedance.sdk.openadsdk.api.t.v("TTPluginManager", "Install wait time out");
                throw new com.bytedance.sdk.openadsdk.api.plugin.vw(8, "install wait timeout");
            }
            if (z) {
                com.bytedance.sdk.openadsdk.api.t.v("TTPluginManager", "Get null after load");
                throw new com.bytedance.sdk.openadsdk.api.plugin.vw(9, "Get null after load");
            }
        }
        vVar.wg("get_classloader_done");
        return v;
    }

    public org.json.JSONObject vw() {
        return this.es;
    }

    public void vw(com.bytedance.sdk.openadsdk.TTPluginListener tTPluginListener) {
        if (!this.bt) {
            com.bytedance.sdk.openadsdk.api.t.v("TTPluginManager", "Zeus init failed.");
            if (tTPluginListener != null) {
                tTPluginListener.onPluginListener(1002, null, null, null);
                return;
            }
            return;
        }
        android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
        handler.postDelayed(new com.bytedance.sdk.openadsdk.api.plugin.yl.AnonymousClass4(tTPluginListener), org.apache.tools.ant.taskdefs.WaitFor.DEFAULT_MAX_WAIT_MILLIS);
        java.lang.String packageName = tTPluginListener.packageName();
        com.bytedance.pangle.plugin.Plugin plugin = (com.bytedance.pangle.Zeus.isPluginInstalled(packageName) && (com.bytedance.pangle.Zeus.isPluginLoaded(packageName) || com.bytedance.pangle.Zeus.loadPlugin(packageName))) ? com.bytedance.pangle.Zeus.getPlugin(packageName) : null;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Find plugin:");
        sb.append(plugin != null);
        com.bytedance.sdk.openadsdk.api.t.wg("TTPluginManager", sb.toString());
        if (plugin == null) {
            wg.put(packageName, tTPluginListener);
            t.put(packageName, handler);
        } else {
            wg(plugin);
            handler.removeCallbacksAndMessages(null);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
        }
    }

    public void wg() {
        com.bykv.vk.openvk.api.proto.EventListener eventListener = this.z;
        if (eventListener != null) {
            eventListener.onEvent(1, com.bykv.vw.vw.vw.vw.vw.vw().vw(true).wg());
        }
    }

    public void wg(com.bytedance.sdk.openadsdk.TTPluginListener tTPluginListener) {
        com.bytedance.sdk.openadsdk.yl.vw.vw().wg(new com.bytedance.sdk.openadsdk.api.plugin.yl.AnonymousClass5(tTPluginListener));
    }
}
