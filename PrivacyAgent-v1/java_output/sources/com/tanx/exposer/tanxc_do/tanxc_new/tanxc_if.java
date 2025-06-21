package com.tanx.exposer.tanxc_do.tanxc_new;

/* loaded from: classes19.dex */
public class tanxc_if {

    /* renamed from: com.tanx.exposer.tanxc_do.tanxc_new.tanxc_if$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ java.lang.Runnable n;

        public AnonymousClass1(java.lang.Runnable runnable) {
            this.n = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.n.run();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void tanxc_do(java.lang.Runnable runnable, long j) {
        new android.os.Handler(com.tanx.exposer.tanxc_do.tanxc_new.tanxc_do.tanxc_do()).postDelayed(new com.tanx.exposer.tanxc_do.tanxc_new.tanxc_if.AnonymousClass1(runnable), j);
    }
}
