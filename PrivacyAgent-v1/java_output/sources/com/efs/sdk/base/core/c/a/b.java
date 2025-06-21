package com.efs.sdk.base.core.c.a;

/* loaded from: classes22.dex */
public final class b extends com.efs.sdk.base.core.c.a.a {
    @Override // com.efs.sdk.base.core.c.a.a
    public final void a(com.efs.sdk.base.core.model.LogDto logDto) {
        if (logDto.isSendImediately()) {
            b(logDto);
        } else {
            com.efs.sdk.base.core.cache.CacheManager.getInstance().put(logDto);
        }
    }
}
