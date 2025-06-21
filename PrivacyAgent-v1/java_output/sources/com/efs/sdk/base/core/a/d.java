package com.efs.sdk.base.core.a;

/* loaded from: classes22.dex */
public final class d extends com.efs.sdk.base.http.AbsHttpListener {

    public static class a {
        private static final com.efs.sdk.base.core.a.d a = new com.efs.sdk.base.core.a.d((byte) 0);
    }

    private d() {
    }

    public /* synthetic */ d(byte b) {
        this();
    }

    public static com.efs.sdk.base.core.a.d a() {
        return com.efs.sdk.base.core.a.d.a.a;
    }

    private static void a(@androidx.annotation.Nullable com.efs.sdk.base.http.HttpResponse httpResponse) {
        java.lang.String str;
        if (com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().isDebug()) {
            if (httpResponse == null) {
                str = "upload result : " + com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE;
            } else {
                str = "upload result : " + httpResponse.succ + ", resp is " + httpResponse.toString();
            }
            com.efs.sdk.base.core.util.Log.i("efs.px.api", str);
        }
    }

    private static void b(com.efs.sdk.base.http.HttpResponse httpResponse) {
        com.efs.sdk.base.core.d.f fVar;
        fVar = com.efs.sdk.base.core.d.f.a.a;
        fVar.a(java.lang.String.valueOf(httpResponse.getHttpCode()), httpResponse.getBizCode(), httpResponse.getReqUrl());
    }

    private static void c(com.efs.sdk.base.http.HttpResponse httpResponse) {
        int parseInt;
        if (((java.util.Map) httpResponse.extra).containsKey("cver")) {
            java.lang.String str = (java.lang.String) ((java.util.Map) httpResponse.extra).get("cver");
            if (!android.text.TextUtils.isEmpty(str) && (parseInt = java.lang.Integer.parseInt(str)) > com.efs.sdk.base.core.config.remote.b.a().d.mConfigVersion) {
                com.efs.sdk.base.core.config.remote.b.a().a(parseInt);
            }
        }
    }

    @Override // com.efs.sdk.base.core.util.concurrent.b
    public final /* synthetic */ void a(@androidx.annotation.NonNull com.efs.sdk.base.core.util.concurrent.c<com.efs.sdk.base.http.HttpResponse> cVar, @androidx.annotation.Nullable com.efs.sdk.base.http.HttpResponse httpResponse) {
        com.efs.sdk.base.http.HttpResponse httpResponse2 = httpResponse;
        if (httpResponse2 != null) {
            com.efs.sdk.base.core.util.a.b bVar = (com.efs.sdk.base.core.util.a.b) cVar;
            ((java.util.Map) httpResponse2.extra).putAll(bVar.f);
            bVar.f.clear();
            com.efs.sdk.base.core.a.a.a();
            com.efs.sdk.base.core.a.a.a(httpResponse2);
        }
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onError(@androidx.annotation.Nullable com.efs.sdk.base.http.HttpResponse httpResponse) {
        a(httpResponse);
        if (httpResponse == null) {
            return;
        }
        b(httpResponse);
        c(httpResponse);
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onSuccess(@androidx.annotation.NonNull com.efs.sdk.base.http.HttpResponse httpResponse) {
        int i;
        com.efs.sdk.base.core.d.f fVar;
        if (!((java.util.Map) httpResponse.extra).containsKey("flow_limit") || !java.lang.Boolean.FALSE.toString().equals(((java.util.Map) httpResponse.extra).get("flow_limit"))) {
            java.lang.String str = ((java.util.Map) httpResponse.extra).containsKey("type") ? (java.lang.String) ((java.util.Map) httpResponse.extra).get("type") : "";
            if (((java.util.Map) httpResponse.extra).containsKey(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE)) {
                java.lang.String str2 = (java.lang.String) ((java.util.Map) httpResponse.extra).get(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE);
                if (!android.text.TextUtils.isEmpty(str2)) {
                    i = java.lang.Integer.parseInt(str2);
                    com.efs.sdk.base.core.b.c a2 = com.efs.sdk.base.core.b.c.a();
                    android.os.Message obtain = android.os.Message.obtain();
                    obtain.what = 0;
                    obtain.obj = str;
                    obtain.arg1 = i;
                    a2.sendMessage(obtain);
                }
            }
            i = 0;
            com.efs.sdk.base.core.b.c a22 = com.efs.sdk.base.core.b.c.a();
            android.os.Message obtain2 = android.os.Message.obtain();
            obtain2.what = 0;
            obtain2.obj = str;
            obtain2.arg1 = i;
            a22.sendMessage(obtain2);
        }
        b(httpResponse);
        fVar = com.efs.sdk.base.core.d.f.a.a;
        fVar.c.b.incrementAndGet();
        c(httpResponse);
        a(httpResponse);
    }
}
