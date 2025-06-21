package com.hihonor.push.sdk;

/* loaded from: classes22.dex */
public class k implements android.os.Handler.Callback {
    public final /* synthetic */ com.hihonor.push.sdk.l a;

    public k(com.hihonor.push.sdk.l lVar) {
        this.a = lVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        if (message == null || message.what != 1001) {
            return false;
        }
        com.hihonor.push.sdk.common.logger.Logger.e("AIDLSrvConnection", "bind core service time out");
        this.a.a(com.hihonor.push.sdk.common.data.ErrorCode.BindService.ERROR_SERVICE_TIME_OUT);
        return true;
    }
}
