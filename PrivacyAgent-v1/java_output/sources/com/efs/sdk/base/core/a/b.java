package com.efs.sdk.base.core.a;

/* loaded from: classes22.dex */
public final class b extends com.efs.sdk.base.http.AbsHttpListener {

    public static class a {
        private static final com.efs.sdk.base.core.a.b a = new com.efs.sdk.base.core.a.b((byte) 0);
    }

    private b() {
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static com.efs.sdk.base.core.a.b a() {
        return com.efs.sdk.base.core.a.b.a.a;
    }

    private static void a(@androidx.annotation.NonNull com.efs.sdk.base.http.HttpResponse httpResponse) {
        com.efs.sdk.base.core.d.f fVar;
        fVar = com.efs.sdk.base.core.d.f.a.a;
        fVar.a(java.lang.String.valueOf(httpResponse.getHttpCode()), httpResponse.getBizCode(), httpResponse.getReqUrl());
    }

    @Override // com.efs.sdk.base.core.util.concurrent.b
    public final /* bridge */ /* synthetic */ void a(@androidx.annotation.NonNull com.efs.sdk.base.core.util.concurrent.c<com.efs.sdk.base.http.HttpResponse> cVar, @androidx.annotation.Nullable com.efs.sdk.base.http.HttpResponse httpResponse) {
        com.efs.sdk.base.http.HttpResponse httpResponse2 = httpResponse;
        if (httpResponse2 != null) {
            com.efs.sdk.base.core.a.a.a();
            com.efs.sdk.base.core.a.a.a(httpResponse2);
        }
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onError(@androidx.annotation.Nullable com.efs.sdk.base.http.HttpResponse httpResponse) {
        if (httpResponse == null) {
            return;
        }
        a(httpResponse);
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onSuccess(@androidx.annotation.NonNull com.efs.sdk.base.http.HttpResponse httpResponse) {
        com.efs.sdk.base.core.d.f fVar;
        a(httpResponse);
        if (((java.util.Map) httpResponse.extra).containsKey("cver")) {
            java.lang.String str = (java.lang.String) ((java.util.Map) httpResponse.extra).get("cver");
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            int parseInt = java.lang.Integer.parseInt(str);
            fVar = com.efs.sdk.base.core.d.f.a.a;
            if (fVar.b == null || !com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                return;
            }
            com.efs.sdk.base.core.d.b bVar = new com.efs.sdk.base.core.d.b("efs_core", "config_coverage", fVar.a.c);
            bVar.put("cver", java.lang.Integer.valueOf(parseInt));
            fVar.b.send(bVar);
        }
    }
}
