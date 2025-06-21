package com.q;

/* loaded from: classes19.dex */
final class a implements java.lang.Runnable {
    public /* synthetic */ android.content.Context n;
    public /* synthetic */ java.lang.String t;

    public a(android.content.Context context, java.lang.String str) {
        this.n = context;
        this.t = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            com.sijla.h.a.a.a(this.n, "ANDROID_I_K", this.t);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
