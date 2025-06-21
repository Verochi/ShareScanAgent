package com.efs.sdk.base.core.b;

/* loaded from: classes22.dex */
public final class b implements com.efs.sdk.base.core.b.d {
    @Override // com.efs.sdk.base.core.b.d
    @androidx.annotation.NonNull
    public final com.efs.sdk.base.http.HttpResponse a(com.efs.sdk.base.core.model.LogDto logDto, boolean z) {
        com.efs.sdk.base.core.a.c a = com.efs.sdk.base.core.a.c.a();
        a.d = logDto.getCp();
        a.e = logDto.getDe();
        a.g = logDto.getLogProtocol();
        a.h = logDto.getLogType();
        a.o = logDto.getBodySize();
        java.lang.String a2 = com.efs.sdk.base.core.config.remote.b.a().a(false);
        com.efs.sdk.base.core.util.Log.i("efs.LogSendAction.Codelog", "send data url is ".concat(java.lang.String.valueOf(a2)));
        com.efs.sdk.base.http.HttpResponse a3 = logDto.getLogBodyType() == 0 ? com.efs.sdk.base.core.a.a.a().a(a2, a, logDto.getData(), logDto.isLimitByFlow()) : 1 == logDto.getLogBodyType() ? com.efs.sdk.base.core.a.a.a().a(a2, a, logDto.getFile(), logDto.isLimitByFlow()) : new com.efs.sdk.base.http.HttpResponse();
        if (a3.succ && z) {
            com.efs.sdk.base.core.util.FileUtil.delete(logDto.getFile());
        }
        return a3;
    }
}
