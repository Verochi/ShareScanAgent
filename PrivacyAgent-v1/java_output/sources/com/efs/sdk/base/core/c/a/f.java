package com.efs.sdk.base.core.c.a;

/* loaded from: classes22.dex */
public final class f extends com.efs.sdk.base.core.c.a.a {
    @Override // com.efs.sdk.base.core.c.a.a
    public final void a(com.efs.sdk.base.core.model.LogDto logDto) {
        java.lang.Double d;
        com.efs.sdk.base.core.config.remote.b a = com.efs.sdk.base.core.config.remote.b.a();
        java.lang.String logType = logDto.getLogType();
        com.efs.sdk.base.core.config.remote.RemoteConfig remoteConfig = a.d;
        if (com.efs.sdk.base.core.config.remote.b.a.nextDouble() * 100.0d <= ((!remoteConfig.mUploadSampleRateMap.containsKey(logType) || (d = remoteConfig.mUploadSampleRateMap.get(logType)) == null) ? 100.0d : d.doubleValue())) {
            b(logDto);
        }
    }
}
