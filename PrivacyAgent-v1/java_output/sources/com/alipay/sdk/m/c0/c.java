package com.alipay.sdk.m.c0;

/* loaded from: classes.dex */
public final class c implements java.lang.Runnable {
    public final /* synthetic */ com.alipay.sdk.m.c0.b a;

    public c(com.alipay.sdk.m.c0.b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.b();
        } catch (java.lang.Exception e) {
            com.alipay.sdk.m.c0.d.a(e);
        }
    }
}
