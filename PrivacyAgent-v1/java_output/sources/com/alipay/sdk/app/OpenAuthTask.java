package com.alipay.sdk.app;

/* loaded from: classes.dex */
public final class OpenAuthTask {
    public static final int Duplex = 5000;
    public static final int NOT_INSTALLED = 4001;
    public static final int OK = 9000;
    public static final int SYS_ERR = 4000;
    public static final java.util.Map<java.lang.String, com.alipay.sdk.app.OpenAuthTask.Callback> e = new java.util.concurrent.ConcurrentHashMap();
    public static long f = -1;
    public static final int g = 122;
    public final android.app.Activity b;
    public com.alipay.sdk.app.OpenAuthTask.Callback c;
    public volatile boolean a = false;
    public final android.os.Handler d = new android.os.Handler(android.os.Looper.getMainLooper());

    public enum BizType {
        Invoice("20000920"),
        AccountAuth("20000067"),
        Deduct("60000157");

        public java.lang.String appId;

        BizType(java.lang.String str) {
            this.appId = str;
        }
    }

    public interface Callback {
        void onResult(int i, java.lang.String str, android.os.Bundle bundle);
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.alipay.sdk.app.OpenAuthTask.BizType.values().length];
            a = iArr;
            try {
                iArr[com.alipay.sdk.app.OpenAuthTask.BizType.Deduct.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.alipay.sdk.app.OpenAuthTask.BizType.AccountAuth.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.alipay.sdk.app.OpenAuthTask.BizType.Invoice.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public final class b implements java.lang.Runnable {
        public final int a;
        public final java.lang.String b;
        public final android.os.Bundle c;

        public b(int i, java.lang.String str, android.os.Bundle bundle) {
            this.a = i;
            this.b = str;
            this.c = bundle;
        }

        public /* synthetic */ b(com.alipay.sdk.app.OpenAuthTask openAuthTask, int i, java.lang.String str, android.os.Bundle bundle, com.alipay.sdk.app.OpenAuthTask.a aVar) {
            this(i, str, bundle);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.alipay.sdk.app.OpenAuthTask.this.c != null) {
                com.alipay.sdk.app.OpenAuthTask.this.c.onResult(this.a, this.b, this.c);
            }
        }
    }

    public OpenAuthTask(android.app.Activity activity) {
        this.b = activity;
        com.alipay.sdk.m.s.b.d().a(activity);
    }

    private java.lang.String a(long j, java.lang.String str, com.alipay.sdk.app.OpenAuthTask.BizType bizType, java.lang.String str2) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME, java.lang.String.valueOf(j));
        jSONObject.put(com.umeng.analytics.pro.f.aC, str);
        jSONObject.put("package", this.b.getPackageName());
        if (bizType != null) {
            jSONObject.put(com.anythink.expressad.videocommon.e.b.u, bizType.appId);
        }
        jSONObject.put(com.heytap.mcssdk.constant.b.C, "h.a.3.8.11");
        jSONObject.put("mqpURL", str2);
        return android.util.Base64.encodeToString(jSONObject.toString().getBytes(java.nio.charset.Charset.forName("UTF-8")), 2);
    }

    private java.lang.String a(com.alipay.sdk.app.OpenAuthTask.BizType bizType, java.util.Map<java.lang.String, java.lang.String> map) {
        if (bizType == null) {
            throw new java.lang.RuntimeException("missing bizType");
        }
        android.net.Uri.Builder appendQueryParameter = new android.net.Uri.Builder().scheme("alipays").authority("platformapi").path(com.igexin.push.core.b.p).appendQueryParameter(com.anythink.expressad.videocommon.e.b.u, bizType.appId);
        if (com.alipay.sdk.app.OpenAuthTask.a.a[bizType.ordinal()] == 1) {
            appendQueryParameter.appendQueryParameter("appClearTop", com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE).appendQueryParameter("startMultApp", "YES");
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            appendQueryParameter.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return appendQueryParameter.build().toString();
    }

    public static void a(java.lang.String str, int i, java.lang.String str2, android.os.Bundle bundle) {
        com.alipay.sdk.app.OpenAuthTask.Callback remove = e.remove(str);
        if (remove != null) {
            try {
                remove.onResult(i, str2, bundle);
            } catch (java.lang.Throwable th) {
                com.alipay.sdk.m.u.e.a(th);
            }
        }
    }

    private boolean a(com.alipay.sdk.m.s.a aVar, java.lang.String str, com.alipay.sdk.app.OpenAuthTask.BizType bizType, java.util.Map<java.lang.String, java.lang.String> map, boolean z) {
        android.content.pm.PackageInfo packageInfo;
        java.lang.String str2;
        if (this.a) {
            this.d.post(new com.alipay.sdk.app.OpenAuthTask.b(this, 4000, "该 OpenAuthTask 已在执行", null, null));
            return true;
        }
        this.a = true;
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        if (elapsedRealtime - f <= 3000) {
            this.d.post(new com.alipay.sdk.app.OpenAuthTask.b(this, 5000, "3s 内重复支付", null, null));
            return true;
        }
        f = elapsedRealtime;
        com.alipay.sdk.m.j.a.a("");
        java.lang.String a2 = com.alipay.sdk.m.u.n.a(32);
        java.util.HashMap hashMap = new java.util.HashMap(map);
        hashMap.put("mqpPkgName", this.b.getPackageName());
        hashMap.put("mqpScene", "sdk");
        java.util.List<com.alipay.sdk.m.m.a.b> l = com.alipay.sdk.m.m.a.D().l();
        if (!com.alipay.sdk.m.m.a.D().h || l == null) {
            l = com.alipay.sdk.m.j.a.d;
        }
        com.alipay.sdk.m.u.n.c a3 = com.alipay.sdk.m.u.n.a(aVar, this.b, l);
        if (a3 != null && !a3.a(aVar) && !a3.a() && (packageInfo = a3.a) != null) {
            try {
                if (packageInfo.versionCode >= 122) {
                    try {
                        java.util.HashMap<java.lang.String, java.lang.String> a4 = com.alipay.sdk.m.s.a.a(aVar);
                        a4.put("ts_scheme", java.lang.String.valueOf(android.os.SystemClock.elapsedRealtime()));
                        hashMap.put("mqpLoc", new org.json.JSONObject(a4).toString());
                    } catch (java.lang.Throwable th) {
                        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "OpenAuthLocEx", th);
                    }
                    java.lang.String a5 = a(bizType, hashMap);
                    e.put(a2, this.c);
                    try {
                        str2 = a(elapsedRealtime, a2, bizType, a5);
                    } catch (org.json.JSONException e2) {
                        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.q0, e2);
                        str2 = null;
                    }
                    if (android.text.TextUtils.isEmpty(str2)) {
                        this.d.post(new com.alipay.sdk.app.OpenAuthTask.b(this, 4000, "参数错误", null, null));
                        return true;
                    }
                    android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", new android.net.Uri.Builder().scheme("alipays").authority("platformapi").path(com.igexin.push.core.b.p).appendQueryParameter(com.anythink.expressad.videocommon.e.b.u, "20001129").appendQueryParameter("payload", str2).build());
                    intent.addFlags(268435456);
                    intent.setPackage(a3.a.packageName);
                    try {
                        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.Y, "" + elapsedRealtime);
                        com.alipay.sdk.m.s.a.C0043a.a(aVar, a2);
                        this.b.startActivity(intent);
                    } catch (java.lang.Throwable th2) {
                        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "StartWalletEx", th2);
                    }
                    return false;
                }
            } catch (java.lang.Throwable unused) {
                this.d.post(new com.alipay.sdk.app.OpenAuthTask.b(this, 4000, "业务参数错误", null, null));
                return true;
            }
        }
        if (!z) {
            this.d.post(new com.alipay.sdk.app.OpenAuthTask.b(this, 4001, "支付宝未安装或签名错误", null, null));
            return true;
        }
        hashMap.put("mqpScheme", java.lang.String.valueOf(str));
        hashMap.put("mqpNotifyName", a2);
        hashMap.put("mqpScene", "landing");
        java.lang.String a6 = a(bizType, hashMap);
        android.content.Intent intent2 = new android.content.Intent(this.b, (java.lang.Class<?>) com.alipay.sdk.app.H5OpenAuthActivity.class);
        intent2.putExtra("url", java.lang.String.format("https://render.alipay.com/p/s/i?scheme=%s", android.net.Uri.encode(a6)));
        com.alipay.sdk.m.s.a.C0043a.a(aVar, intent2);
        this.b.startActivity(intent2);
        return false;
    }

    public void execute(java.lang.String str, com.alipay.sdk.app.OpenAuthTask.BizType bizType, java.util.Map<java.lang.String, java.lang.String> map, com.alipay.sdk.app.OpenAuthTask.Callback callback, boolean z) {
        com.alipay.sdk.m.s.a aVar = new com.alipay.sdk.m.s.a(this.b, java.lang.String.valueOf(map), "oa-" + bizType);
        this.c = callback;
        if (a(aVar, str, bizType, map, z)) {
            com.alipay.sdk.m.k.a.b(this.b, aVar, "", aVar.d);
        }
    }
}
