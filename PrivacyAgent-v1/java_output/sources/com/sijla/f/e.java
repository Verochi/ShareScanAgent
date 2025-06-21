package com.sijla.f;

/* loaded from: classes19.dex */
final class e implements java.lang.Runnable {
    private /* synthetic */ android.content.Context a;
    private /* synthetic */ long b;
    private /* synthetic */ com.sijla.callback.QtCallBack c;

    public e(android.content.Context context, long j, com.sijla.callback.QtCallBack qtCallBack) {
        this.a = context;
        this.b = j;
        this.c = qtCallBack;
    }

    @Override // java.lang.Runnable
    public final void run() {
        org.json.JSONObject b;
        try {
            b = com.sijla.f.c.b(this.a, this.b);
            com.sijla.f.c.a(this.a, b, this.c, this.b);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
