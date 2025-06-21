package com.ss.android.downloadlib.wg;

/* loaded from: classes19.dex */
public class wg {

    /* renamed from: com.ss.android.downloadlib.wg.wg$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.downloadad.api.vw.wg vw;
        final /* synthetic */ com.ss.android.downloadlib.wg.bt wg;

        /* renamed from: com.ss.android.downloadlib.wg.wg$1$1, reason: invalid class name and collision with other inner class name */
        public class C04791 implements com.ss.android.downloadlib.wg.o {
            public C04791() {
            }

            @Override // com.ss.android.downloadlib.wg.o
            public void vw(boolean z) {
                com.ss.android.downloadlib.wg.wg.AnonymousClass1.this.wg.vw(z);
            }
        }

        public AnonymousClass1(com.ss.android.downloadad.api.vw.wg wgVar, com.ss.android.downloadlib.wg.bt btVar) {
            this.vw = wgVar;
            this.wg = btVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.ss.android.downloadlib.wg.x.vw(this.vw)) {
                this.wg.vw(false);
            } else if (com.ss.android.downloadlib.wg.kz.vw(this.vw)) {
                com.ss.android.downloadlib.wg.kz.vw(this.vw, new com.ss.android.downloadlib.wg.wg.AnonymousClass1.C04791());
            } else {
                this.wg.vw(false);
            }
        }
    }

    public void vw(@androidx.annotation.NonNull com.ss.android.downloadad.api.vw.wg wgVar, @androidx.annotation.NonNull com.ss.android.downloadlib.wg.bt btVar, int i) {
        com.ss.android.downloadlib.v.vw().vw(new com.ss.android.downloadlib.wg.wg.AnonymousClass1(wgVar, btVar), i);
    }
}
