package com.alipay.sdk.app;

/* loaded from: classes29.dex */
public class H5AuthActivity extends com.alipay.sdk.app.H5PayActivity {
    @Override // com.alipay.sdk.app.H5PayActivity
    public void a() {
        java.lang.Object obj = com.alipay.sdk.app.AuthTask.c;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (java.lang.Exception unused) {
            }
        }
    }
}
