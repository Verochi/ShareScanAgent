package com.efs.sdk.net.a.a;

/* loaded from: classes22.dex */
public final class g implements com.efs.sdk.net.a.a.f {
    private static java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger(0);
    private static com.efs.sdk.net.a.a.g c;
    private com.efs.sdk.net.a.a.b b = new com.efs.sdk.net.a.a.b();

    private g() {
    }

    public static com.efs.sdk.net.a.a.g c() {
        if (c == null) {
            c = new com.efs.sdk.net.a.a.g();
        }
        return c;
    }

    @Override // com.efs.sdk.net.a.a.f
    @org.jetbrains.annotations.Nullable
    public final java.io.InputStream a(java.lang.String str, @org.jetbrains.annotations.Nullable java.lang.String str2, @org.jetbrains.annotations.Nullable java.lang.String str3, @org.jetbrains.annotations.Nullable java.io.InputStream inputStream) {
        com.efs.sdk.base.core.util.Log.d("NetTrace-Interceptor", "interpret response stream");
        return com.efs.sdk.net.a.a.b.a(str, str2, str3, inputStream);
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a() {
        com.efs.sdk.base.core.util.Log.d("NetTrace-Interceptor", "data sent");
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a(com.efs.sdk.net.a.a.f.b bVar) {
        java.lang.String str;
        com.efs.sdk.base.core.util.Log.d("NetTrace-Interceptor", "request will be sent");
        com.efs.sdk.net.a.a.b bVar2 = this.b;
        try {
            java.lang.String a2 = bVar.a();
            bVar2.a.put(bVar.a(), java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            com.efs.sdk.base.core.util.Log.i("NetTrace-Interceptor", "save request");
            com.efs.sdk.net.a.c a3 = com.efs.sdk.net.a.a.a().a(a2);
            java.lang.String b = bVar.b();
            if (!android.text.TextUtils.isEmpty(b)) {
                a3.d = b;
            }
            a3.e = bVar.c();
            java.util.HashMap hashMap = new java.util.HashMap();
            int e = bVar.e();
            for (int i = 0; i < e; i++) {
                hashMap.put(bVar.a(i), bVar.b(i));
            }
            if (com.efs.sdk.net.NetManager.getNetConfigManager().getNetRequestHeaderCollectState()) {
                a3.f = hashMap;
            }
            a3.g = com.efs.sdk.net.a.a.b.a(bVar);
            if (com.efs.sdk.net.NetManager.getNetConfigManager().getNetRequestBodyCollectState()) {
                java.lang.String str2 = a3.e;
                if ((str2 == null || !str2.equalsIgnoreCase(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET)) && (str = a3.e) != null && str.equalsIgnoreCase("post") && a3.g < com.huawei.hms.utils.FileUtil.LOCAL_REPORT_FILE_MAX_SIZE) {
                    if (hashMap.containsKey("Content-Type") || hashMap.containsKey(com.alipay.sdk.m.p.e.f)) {
                        java.lang.String str3 = (java.lang.String) hashMap.get("Content-Type");
                        if (android.text.TextUtils.isEmpty(str3)) {
                            str3 = (java.lang.String) hashMap.get(com.alipay.sdk.m.p.e.f);
                        }
                        if (str3 != null) {
                            if (str3.contains(com.baidu.mobads.sdk.internal.am.d) || str3.contains(com.anythink.expressad.foundation.g.f.g.b.e)) {
                                a3.h = new java.lang.String(bVar.d());
                            }
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a(com.efs.sdk.net.a.a.f.d dVar) {
        com.efs.sdk.base.core.util.Log.d("NetTrace-Interceptor", "response headers received");
        com.efs.sdk.net.a.a.b bVar = this.b;
        com.efs.sdk.base.core.util.Log.i("NetTrace-Interceptor", "save response");
        java.lang.String a2 = dVar.a();
        if (bVar.a != null) {
            com.efs.sdk.net.a.c a3 = com.efs.sdk.net.a.a.a().a(a2);
            a3.i = dVar.b();
            try {
                if (com.efs.sdk.net.NetManager.getNetConfigManager().getNetResponseHeaderCollectState()) {
                    java.util.HashMap hashMap = new java.util.HashMap();
                    int e = dVar.e();
                    for (int i = 0; i < e; i++) {
                        hashMap.put(dVar.a(i), dVar.b(i));
                    }
                    a3.l = hashMap;
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.efs.sdk.net.a.a.f
    public final java.lang.String b() {
        com.efs.sdk.base.core.util.Log.d("NetTrace-Interceptor", "next request id");
        return java.lang.String.valueOf(a.getAndIncrement());
    }
}
