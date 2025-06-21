package com.huawei.hms.opendevice;

/* loaded from: classes22.dex */
public class j implements java.util.concurrent.Callable<com.huawei.hms.aaid.entity.AAIDResult> {
    public android.content.Context a;

    public j(android.content.Context context) {
        this.a = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public com.huawei.hms.aaid.entity.AAIDResult call() throws java.lang.Exception {
        android.content.Context context = this.a;
        if (context == null) {
            throw com.huawei.hms.aaid.constant.ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        java.lang.String c = com.huawei.hms.opendevice.o.c(context);
        com.huawei.hms.aaid.entity.AAIDResult aAIDResult = new com.huawei.hms.aaid.entity.AAIDResult();
        aAIDResult.setId(c);
        return aAIDResult;
    }
}
