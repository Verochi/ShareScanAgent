package com.efs.sdk.base.core.a;

/* loaded from: classes22.dex */
public final class a {
    private static volatile long b = -1;
    public boolean a;

    /* renamed from: com.efs.sdk.base.core.a.a$a, reason: collision with other inner class name */
    public static class C0282a {
        private static final com.efs.sdk.base.core.a.a a = new com.efs.sdk.base.core.a.a((byte) 0);
    }

    private a() {
        this.a = true;
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    public static com.efs.sdk.base.core.a.a a() {
        return com.efs.sdk.base.core.a.a.C0282a.a;
    }

    private static java.lang.String a(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.efs.sdk.base.core.a.c cVar) {
        byte b2 = cVar.g;
        return str + (b2 != 1 ? b2 != 2 ? b2 != 3 ? "/api/v1/raw/upload" : "/api/v1/mix/upload" : "/perf_upload" : "/apm_logs");
    }

    public static void a(@androidx.annotation.Nullable com.efs.sdk.base.http.HttpResponse httpResponse) {
        if (httpResponse == null || !httpResponse.succ || android.text.TextUtils.isEmpty(httpResponse.data)) {
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(httpResponse.data);
            java.lang.String optString = jSONObject.optString("code", "-1");
            httpResponse.setBizCode(optString);
            if (!"0".equals(optString)) {
                httpResponse.succ = false;
            }
            if (jSONObject.has("cver")) {
                ((java.util.Map) httpResponse.extra).put("cver", jSONObject.getString("cver"));
            }
            long j = jSONObject.getLong("stm") * 1000;
            if (java.lang.Math.abs(j - b()) > 1500000) {
                b = j - android.os.SystemClock.elapsedRealtime();
            }
        } catch (java.lang.Throwable th) {
            com.efs.sdk.base.core.util.Log.e("efs.px.api", "checkPxReturn error", th);
        }
    }

    public static long b() {
        return b == -1 ? java.lang.System.currentTimeMillis() : android.os.SystemClock.elapsedRealtime() + b;
    }

    @androidx.annotation.NonNull
    public final com.efs.sdk.base.http.HttpResponse a(java.lang.String str, com.efs.sdk.base.core.a.c cVar, java.io.File file, boolean z) {
        java.lang.String b2 = cVar.b();
        java.lang.String a = a(str, cVar);
        if (this.a) {
            com.efs.sdk.base.core.util.Log.i("efs.px.api", "Upload file, url is ".concat(java.lang.String.valueOf(a)));
        }
        java.util.HashMap hashMap = new java.util.HashMap(1);
        hashMap.put("wpk-header", b2);
        com.efs.sdk.base.core.util.a.d a2 = new com.efs.sdk.base.core.util.a.d(a).a(hashMap);
        a2.a.d = file;
        com.efs.sdk.base.core.util.a.d a3 = a2.a("type", cVar.h);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(cVar.o);
        return a3.a(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, sb.toString()).a("flow_limit", java.lang.Boolean.toString(z)).a(com.efs.sdk.base.core.a.d.a()).a().b();
    }

    @androidx.annotation.NonNull
    public final com.efs.sdk.base.http.HttpResponse a(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.efs.sdk.base.core.a.c cVar, @androidx.annotation.NonNull byte[] bArr, boolean z) {
        java.lang.String b2 = cVar.b();
        java.lang.String a = a(str, cVar);
        if (this.a) {
            com.efs.sdk.base.core.util.Log.i("efs.px.api", "upload buffer file, url is ".concat(java.lang.String.valueOf(a)));
        }
        java.util.HashMap hashMap = new java.util.HashMap(1);
        hashMap.put("wpk-header", b2);
        com.efs.sdk.base.core.util.a.d a2 = new com.efs.sdk.base.core.util.a.d(a).a(hashMap);
        com.efs.sdk.base.core.util.a.b bVar = a2.a;
        bVar.c = bArr;
        bVar.g = true;
        com.efs.sdk.base.core.util.a.d a3 = a2.a("type", cVar.h);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(cVar.o);
        return a3.a(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, sb.toString()).a("flow_limit", java.lang.Boolean.toString(z)).a(com.efs.sdk.base.core.a.d.a()).a().b();
    }
}
