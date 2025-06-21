package com.sijla.b;

/* loaded from: classes19.dex */
final class l implements java.lang.Runnable {
    private /* synthetic */ android.content.Context a;
    private /* synthetic */ java.lang.String b;

    public l(android.content.Context context, java.lang.String str) {
        this.a = context;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            java.lang.System.out.println("qmt start");
            com.sijla.mla.c cVar = new com.sijla.mla.c(this.a);
            cVar.a(this.a);
            android.content.Context context = this.a;
            cVar.a(context, com.sijla.h.c.e(context), this.b);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
