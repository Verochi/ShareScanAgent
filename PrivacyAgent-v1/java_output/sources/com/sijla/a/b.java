package com.sijla.a;

/* loaded from: classes19.dex */
final class b implements java.lang.Runnable {
    private /* synthetic */ long a;
    private /* synthetic */ java.lang.Runnable b;

    public b(long j, java.lang.Runnable runnable) {
        this.a = j;
        this.b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            java.lang.Thread.sleep(this.a);
            this.b.run();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
