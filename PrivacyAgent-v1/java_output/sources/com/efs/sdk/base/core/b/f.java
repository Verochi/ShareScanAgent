package com.efs.sdk.base.core.b;

/* loaded from: classes22.dex */
public final class f implements java.lang.Runnable {
    private com.efs.sdk.base.core.model.LogDto a;
    private com.efs.sdk.base.core.b.d b;
    private java.lang.String c;

    public f(com.efs.sdk.base.core.model.LogDto logDto, com.efs.sdk.base.core.b.d dVar, java.lang.String str) {
        this.a = logDto;
        this.b = dVar;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.efs.sdk.base.core.b.d dVar;
        com.efs.sdk.base.core.model.LogDto logDto = this.a;
        com.efs.sdk.base.http.HttpResponse httpResponse = (logDto == null || (dVar = this.b) == null) ? new com.efs.sdk.base.http.HttpResponse() : dVar.a(logDto, true);
        com.efs.sdk.base.core.b.e.a().a(this.c, httpResponse.succ ? 0 : httpResponse.getHttpCode());
        this.c = null;
        this.b = null;
    }
}
