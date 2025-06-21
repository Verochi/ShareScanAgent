package com.aliyun.svideosdk.multirecorder.impl.c;

/* loaded from: classes12.dex */
public abstract class f extends com.aliyun.svideosdk.multirecorder.impl.c.a implements com.aliyun.svideosdk.multirecorder.impl.c.c.b {
    private com.aliyun.svideosdk.multirecorder.impl.c.c l = new com.aliyun.svideosdk.multirecorder.impl.c.c(n(), this);

    public final void c(boolean z) {
        this.l.a(k());
        this.l.a(z);
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public void destroy() {
        this.l.a();
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.c.b
    public final void g() {
        o();
        m();
    }

    public abstract void o();

    public final void p() {
        this.l.d();
    }
}
