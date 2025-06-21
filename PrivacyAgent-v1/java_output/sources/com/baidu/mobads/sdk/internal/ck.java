package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class ck {
    public static final java.lang.String b = "404";
    public static final int c = 843;
    protected final com.baidu.mobads.sdk.internal.bt d = com.baidu.mobads.sdk.internal.bt.a();
    private android.content.Context h;
    public static final java.lang.String a = com.baidu.mobads.sdk.internal.z.b;
    private static com.baidu.mobads.sdk.internal.ck g = new com.baidu.mobads.sdk.internal.ck();
    public static volatile java.lang.String e = "";
    public static volatile java.lang.String f = "";
    private static java.util.concurrent.atomic.AtomicBoolean i = new java.util.concurrent.atomic.AtomicBoolean(false);
    private static java.lang.String j = "";
    private static java.util.concurrent.atomic.AtomicBoolean k = new java.util.concurrent.atomic.AtomicBoolean(false);
    private static java.lang.String l = "";

    private ck() {
    }

    public static com.baidu.mobads.sdk.internal.ck a() {
        return g;
    }

    private java.lang.String a(java.lang.String str) {
        try {
            return java.net.URLEncoder.encode(str, "UTF-8");
        } catch (java.io.UnsupportedEncodingException e2) {
            throw new java.lang.IllegalArgumentException(e2);
        }
    }

    private java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            java.lang.String str3 = (java.lang.String) cls.getDeclaredMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class).invoke(cls, str);
            return android.text.TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (java.lang.Throwable th) {
            this.d.a(th);
            return str2;
        }
    }

    private java.lang.String a(java.lang.String str, java.lang.Object... objArr) {
        com.baidu.mobads.sdk.api.IXAdContainerFactory c2;
        com.baidu.mobads.sdk.internal.aa a2 = com.baidu.mobads.sdk.internal.aa.a();
        if (a2 == null || (c2 = a2.c()) == null) {
            return "";
        }
        java.lang.Object remoteParam = c2.getRemoteParam(str, objArr);
        return remoteParam instanceof java.lang.String ? (java.lang.String) remoteParam : "";
    }

    private void a(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        android.net.Uri.Builder builder = new android.net.Uri.Builder();
        try {
            android.net.Uri.Builder appendQueryParameter = builder.appendQueryParameter("type", str2).appendQueryParameter(com.aliyun.svideo.downloader.FileDownloaderModel.SUBTYPE, java.lang.String.valueOf(c)).appendQueryParameter(com.umeng.analytics.pro.bo.bl, "9.3711").appendQueryParameter("appsid", a("appsid", new java.lang.Object[0])).appendQueryParameter("v", "android_" + d() + "_" + com.baidu.mobads.sdk.internal.cl.f);
            android.content.Context context = this.h;
            appendQueryParameter.appendQueryParameter("pack", context != null ? context.getPackageName() : "").appendQueryParameter("sn", a("encodedSn", this.h)).appendQueryParameter("cuid", a("encodedCUID", this.h)).appendQueryParameter("os", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM).appendQueryParameter("osv", com.baidu.mobads.sdk.internal.bm.a(this.h).c()).appendQueryParameter("romn", b()).appendQueryParameter("romv", c()).appendQueryParameter("bdr", "" + com.baidu.mobads.sdk.internal.bm.a(this.h).a()).appendQueryParameter("brd", "" + a(com.baidu.mobads.sdk.internal.bm.a(this.h).e()));
            if (str != null && str.length() > 128) {
                int indexOf = str.indexOf(10);
                if (indexOf <= 0) {
                    indexOf = 127;
                }
                str = str.substring(0, indexOf);
            }
            builder.appendQueryParameter("reason", str);
            if (hashMap != null) {
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : hashMap.entrySet()) {
                    builder.appendQueryParameter(entry.getKey(), entry.getValue());
                }
            }
        } catch (java.lang.Throwable th) {
            this.d.a(th);
        }
        com.baidu.mobads.sdk.internal.am amVar = new com.baidu.mobads.sdk.internal.am(a, "POST");
        amVar.a(builder);
        amVar.b();
    }

    private java.lang.String d() {
        java.lang.String str = com.baidu.mobads.sdk.internal.cl.e;
        if (!com.baidu.mobads.sdk.internal.cl.d.equals(str)) {
            return str;
        }
        try {
            double b2 = com.baidu.mobads.sdk.internal.bz.b(com.baidu.mobads.sdk.internal.bz.a(this.h));
            return b2 > 0.0d ? java.lang.String.valueOf(b2) : str;
        } catch (java.lang.Throwable th) {
            this.d.a(th);
            return str;
        }
    }

    public void a(android.content.Context context) {
        if (this.h == null) {
            this.h = context;
        }
    }

    public void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
            hashMap.put(com.umeng.analytics.pro.bo.aC, str3);
            hashMap.put("stacktrace", str2);
            a(str, b, hashMap);
        } catch (java.lang.Exception e2) {
            this.d.a(e2);
        }
    }

    public java.lang.String b() {
        try {
            if (i.compareAndSet(false, true)) {
                java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.system.BuildEx");
                java.lang.String str = (java.lang.String) cls.getMethod("getOsBrand", new java.lang.Class[0]).invoke(cls, new java.lang.Object[0]);
                if (!android.text.TextUtils.isEmpty(str)) {
                    j = str;
                }
            }
            return j;
        } catch (java.lang.Throwable th) {
            this.d.a(th);
            return j;
        }
    }

    public java.lang.String c() {
        try {
            if (k.get()) {
                return l;
            }
            if (!i.get()) {
                b();
            }
            if (j.equalsIgnoreCase("")) {
                k.set(true);
                return "";
            }
            if (k.compareAndSet(false, true)) {
                java.lang.String a2 = a(com.alipay.sdk.m.c.a.b, "");
                if (!android.text.TextUtils.isEmpty(a2)) {
                    l = a2;
                }
            }
            return l;
        } catch (java.lang.Throwable th) {
            this.d.a(th);
            return l;
        }
    }
}
