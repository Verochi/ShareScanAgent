package com.sijla.b;

/* loaded from: classes19.dex */
final class r implements java.lang.Runnable {
    private /* synthetic */ java.lang.String a;
    private /* synthetic */ android.content.Context b;
    private /* synthetic */ android.content.Intent c;
    private /* synthetic */ com.sijla.b.q d;

    public r(com.sijla.b.q qVar, java.lang.String str, android.content.Context context, android.content.Intent intent) {
        this.d = qVar;
        this.a = str;
        this.b = context;
        this.c = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.equals(com.sijla.h.a.a.c(this.b))) {
            this.d.a.a(this.c.getLongExtra("dur", 0L));
        } else if (this.a.equals(com.sijla.h.a.a.b(this.b))) {
            this.d.a.f();
        }
    }
}
