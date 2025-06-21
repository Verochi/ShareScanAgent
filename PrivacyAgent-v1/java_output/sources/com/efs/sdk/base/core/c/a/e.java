package com.efs.sdk.base.core.c.a;

/* loaded from: classes22.dex */
public final class e extends com.efs.sdk.base.core.c.a.a {
    @Override // com.efs.sdk.base.core.c.a.a
    public final void a(com.efs.sdk.base.core.model.LogDto logDto) {
        com.efs.sdk.base.core.d.f fVar;
        com.efs.sdk.base.core.d.f fVar2;
        com.efs.sdk.base.http.HttpResponse a;
        if (!logDto.isSendImediately()) {
            b(logDto);
            return;
        }
        com.efs.sdk.base.core.b.e a2 = com.efs.sdk.base.core.b.e.a();
        if (!logDto.isLimitByFlow() || com.efs.sdk.base.core.b.c.a().a(logDto.getLogType(), logDto.getBodySize())) {
            fVar = com.efs.sdk.base.core.d.f.a.a;
            fVar.c.b();
            fVar2 = com.efs.sdk.base.core.d.f.a.a;
            fVar2.c.c();
            a = a2.c.a(logDto, false);
        } else {
            a = new com.efs.sdk.base.http.HttpResponse();
            a.data = "flow_limit";
        }
        logDto.setResponseDto(a);
        b(logDto);
    }
}
