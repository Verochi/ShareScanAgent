package com.aliyun.svideosdk.conan.event;

/* loaded from: classes12.dex */
public class a {
    private java.util.Map<java.lang.String, java.lang.String> a;
    private java.util.Map<java.lang.String, java.lang.String> b;

    public static class b {
        private static com.aliyun.svideosdk.conan.event.a a = new com.aliyun.svideosdk.conan.event.a(null);
    }

    private a() {
    }

    public /* synthetic */ a(com.aliyun.svideosdk.conan.event.a.C0090a c0090a) {
        this();
    }

    private void a(java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2) {
        if (map == null || map2 == null) {
            return;
        }
        try {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                map2.put(entry.getKey(), entry.getValue());
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static com.aliyun.svideosdk.conan.event.a c() {
        return com.aliyun.svideosdk.conan.event.a.b.a;
    }

    private void e() {
        if (this.b == null) {
            this.b = new java.util.HashMap();
        }
        this.b.put("lv", "2.0");
        this.b.put("conan_version", com.aliyun.svideosdk.conan.AlivcConan.getSDKVersion());
        if (com.aliyun.svideosdk.conan.a.p() != null) {
            this.b.put("tt", com.aliyun.svideosdk.conan.a.q());
        }
        this.b.put("dm", com.aliyun.svideosdk.conan.a.i());
        this.b.put("os", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
        this.b.put("ov", com.aliyun.svideosdk.conan.a.n());
        this.b.put("uuid", com.aliyun.svideosdk.conan.a.j());
        if (com.aliyun.svideosdk.conan.a.p() != null) {
            this.b.put("app_id", com.aliyun.svideosdk.conan.a.p().getPackageName());
        }
        this.b.put("bi", "");
    }

    private void f() {
        if (this.a == null) {
            this.a = new java.util.HashMap();
        }
        if (com.aliyun.svideosdk.conan.a.p() != null) {
            this.a.put("gl_v", com.aliyun.svideosdk.conan.a.o());
        }
        this.a.put("db", com.aliyun.svideosdk.conan.a.g());
        this.a.put("dma", com.aliyun.svideosdk.conan.a.h());
        this.a.put(com.alipay.sdk.m.k.b.m, com.aliyun.svideosdk.conan.a.e());
        this.a.put("ci", com.aliyun.svideosdk.conan.a.d());
        this.a.put("gi", com.aliyun.svideosdk.conan.a.l());
    }

    public java.util.Map<java.lang.String, java.lang.String> a() {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("cpu", com.aliyun.svideosdk.conan.a.f());
        hashMap.put("mem", com.aliyun.svideosdk.conan.a.m());
        hashMap.put("ele", com.aliyun.svideosdk.conan.a.k());
        return hashMap;
    }

    public void a(com.aliyun.svideosdk.conan.AlivcSDKEnvironment alivcSDKEnvironment) {
        if (this.b == null) {
            e();
        }
        java.util.Map<java.lang.String, java.lang.String> map = this.b;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (alivcSDKEnvironment == null) {
            alivcSDKEnvironment = com.aliyun.svideosdk.conan.AlivcSDKEnvironment.EN_ONLINE;
        }
        sb.append(alivcSDKEnvironment.getSDKEnv());
        sb.append("");
        map.put("se", sb.toString());
    }

    public void a(java.lang.String str) {
        if (this.b == null) {
            e();
        }
        this.b.put("app_n", str);
    }

    public java.util.Map<java.lang.String, java.lang.String> b() {
        if (this.b == null) {
            e();
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        a(this.b, hashMap);
        return hashMap;
    }

    public void b(java.lang.String str) {
        if (this.b == null) {
            e();
        }
        this.b.put("app_v", str);
    }

    public java.util.Map<java.lang.String, java.lang.String> d() {
        if (this.a == null) {
            f();
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        a(this.a, hashMap);
        return hashMap;
    }
}
