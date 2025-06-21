package com.huawei.hms.framework.network.grs;

/* loaded from: classes22.dex */
public class GrsClient {
    private static final java.lang.String EMPTY_STRING = "";
    private final com.huawei.hms.framework.network.grs.c grsClientGlobal;

    public GrsClient(android.content.Context context, com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo) {
        if (context == null || grsBaseInfo == null) {
            throw new java.lang.NullPointerException("invalid init params for context is null or GrsBaseInfo instance is null Object.");
        }
        this.grsClientGlobal = com.huawei.hms.framework.network.grs.d.a(grsBaseInfo, context);
    }

    public void ayncGetGrsUrl(java.lang.String str, java.lang.String str2, com.huawei.hms.framework.network.grs.IQueryUrlCallBack iQueryUrlCallBack) {
        com.huawei.hms.framework.network.grs.c cVar = this.grsClientGlobal;
        if (cVar == null) {
            iQueryUrlCallBack.onCallBackFail(-8);
        } else {
            cVar.a(str, str2, iQueryUrlCallBack);
        }
    }

    public void ayncGetGrsUrls(java.lang.String str, com.huawei.hms.framework.network.grs.IQueryUrlsCallBack iQueryUrlsCallBack) {
        com.huawei.hms.framework.network.grs.c cVar = this.grsClientGlobal;
        if (cVar == null) {
            iQueryUrlsCallBack.onCallBackFail(-8);
        } else {
            cVar.a(str, iQueryUrlsCallBack);
        }
    }

    public void clearSp() {
        com.huawei.hms.framework.network.grs.c cVar = this.grsClientGlobal;
        if (cVar == null) {
            return;
        }
        cVar.a();
    }

    public boolean forceExpire() {
        com.huawei.hms.framework.network.grs.c cVar = this.grsClientGlobal;
        if (cVar == null) {
            return false;
        }
        return cVar.b();
    }

    public java.lang.String synGetGrsUrl(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.framework.network.grs.c cVar = this.grsClientGlobal;
        return cVar == null ? "" : cVar.a(str, str2);
    }

    public java.util.Map<java.lang.String, java.lang.String> synGetGrsUrls(java.lang.String str) {
        com.huawei.hms.framework.network.grs.c cVar = this.grsClientGlobal;
        return cVar == null ? new java.util.HashMap() : cVar.a(str);
    }
}
