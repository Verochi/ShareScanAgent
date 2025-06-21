package com.efs.sdk.base.core.config.remote;

/* loaded from: classes22.dex */
public final class a implements com.efs.sdk.base.IConfigRefreshAction {

    /* renamed from: com.efs.sdk.base.core.config.remote.a$a, reason: collision with other inner class name */
    public static class C0283a {
        private static final com.efs.sdk.base.core.config.remote.a a = new com.efs.sdk.base.core.config.remote.a();
    }

    public static com.efs.sdk.base.core.config.remote.a a() {
        return com.efs.sdk.base.core.config.remote.a.C0283a.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b3, code lost:
    
        com.efs.sdk.base.core.util.Log.i("efs.config", "config request succ, config is:\n ".concat(java.lang.String.valueOf(r2)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c0, code lost:
    
        return r2;
     */
    @Override // com.efs.sdk.base.IConfigRefreshAction
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.String refresh() {
        java.lang.String str = "";
        if (!com.efs.sdk.base.core.util.NetworkUtil.isConnected(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext)) {
            com.efs.sdk.base.core.util.Log.i("efs.config", "Config refresh fail, network is disconnected.");
            return "";
        }
        java.lang.String a = com.efs.sdk.base.core.config.remote.b.a().a(true);
        com.efs.sdk.base.core.a.c a2 = com.efs.sdk.base.core.a.c.a();
        int i = 0;
        while (true) {
            if (i >= 3) {
                break;
            }
            com.efs.sdk.base.core.a.a a3 = com.efs.sdk.base.core.a.a.a();
            java.lang.String b = a2.b();
            if (a3.a) {
                com.efs.sdk.base.core.util.Log.i("efs.px.api", "get config from server, wpkHeader is ".concat(java.lang.String.valueOf(b)));
            }
            java.lang.String str2 = a + "/apm_cc";
            if (a3.a) {
                com.efs.sdk.base.core.util.Log.i("efs.px.api", "get config from server, url is ".concat(java.lang.String.valueOf(str2)));
            }
            java.util.HashMap hashMap = new java.util.HashMap(1);
            hashMap.put("wpk-header", b);
            com.efs.sdk.base.core.util.a.c a4 = new com.efs.sdk.base.core.util.a.d(str2).a(hashMap).a(com.efs.sdk.base.core.a.b.a()).a();
            a4.a.e = com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET;
            com.efs.sdk.base.http.HttpResponse a5 = a4.a();
            if (a5.succ) {
                str = a5.data;
                break;
            }
            if (android.text.TextUtils.isEmpty(a5.getBizCode()) || !com.tencent.connect.common.Constants.DEFAULT_UIN.equals(a5.getBizCode())) {
                break;
            }
            i++;
        }
        return "";
    }
}
