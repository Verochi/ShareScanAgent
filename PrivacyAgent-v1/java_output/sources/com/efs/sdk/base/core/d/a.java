package com.efs.sdk.base.core.d;

/* loaded from: classes22.dex */
public abstract class a extends android.os.Handler {
    public com.efs.sdk.base.core.controller.ControllerCenter a;

    public a() {
        super(com.efs.sdk.base.core.util.concurrent.a.a.getLooper());
        sendEmptyMessageDelayed(0, 60000L);
    }

    public abstract void a();

    @Override // android.os.Handler
    public void handleMessage(@androidx.annotation.NonNull android.os.Message message) {
        super.handleMessage(message);
        a();
        sendEmptyMessageDelayed(0, 60000L);
    }
}
