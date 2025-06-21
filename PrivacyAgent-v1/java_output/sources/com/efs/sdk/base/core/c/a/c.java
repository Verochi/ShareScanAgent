package com.efs.sdk.base.core.c.a;

/* loaded from: classes22.dex */
public final class c extends com.efs.sdk.base.core.c.a.a {
    private static boolean c(com.efs.sdk.base.core.model.LogDto logDto) {
        return logDto.isCp() || (1 == logDto.getLogProtocol() && !logDto.isSendImediately()) || 1 == logDto.getLogBodyType();
    }

    @Override // com.efs.sdk.base.core.c.a.a
    public final void a(com.efs.sdk.base.core.model.LogDto logDto) {
        if (c(logDto)) {
            b(logDto);
            return;
        }
        byte[] a = com.efs.sdk.base.core.util.b.a(logDto.getData());
        if (a == null) {
            com.efs.sdk.base.core.util.Log.w("efs.base", "gzip error");
            b(logDto);
        } else {
            logDto.setData(a);
            logDto.setCp("gzip");
            b(logDto);
        }
    }
}
