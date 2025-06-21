package com.ss.android.downloadlib.bt;

/* loaded from: classes19.dex */
public class t<P, R> implements java.lang.Runnable {
    private com.ss.android.downloadlib.bt.t<R, ?> kz;
    private int t;
    private java.lang.ref.SoftReference<com.ss.android.downloadlib.bt.t.vw<P, R>> v;
    private P vw;
    private R wg;
    private com.ss.android.downloadlib.bt.t<?, P> yl;

    public interface vw<PARAM, RESULT> {
        RESULT vw(PARAM param);
    }

    private t(int i, com.ss.android.downloadlib.bt.t.vw<P, R> vwVar, P p) {
        this.t = i;
        this.v = new java.lang.ref.SoftReference<>(vwVar);
        this.vw = p;
    }

    public static <P, R> com.ss.android.downloadlib.bt.t<P, R> vw(com.ss.android.downloadlib.bt.t.vw<P, R> vwVar, P p) {
        return new com.ss.android.downloadlib.bt.t<>(2, vwVar, p);
    }

    private R wg() {
        return this.wg;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ss.android.downloadlib.bt.t<?, P> tVar;
        if (this.t == 0 && !com.ss.android.downloadlib.bt.vl.wg()) {
            com.ss.android.downloadlib.bt.vw().wg().post(this);
            return;
        }
        if (this.t == 1 && com.ss.android.downloadlib.bt.vl.wg()) {
            com.ss.android.downloadlib.v.vw().vw(this);
            return;
        }
        if (this.t == 2 && com.ss.android.downloadlib.bt.vl.wg()) {
            com.ss.android.downloadlib.v.vw().wg(this);
            return;
        }
        if (this.vw == null && (tVar = this.yl) != null) {
            this.vw = tVar.wg();
        }
        com.ss.android.downloadlib.bt.t.vw<P, R> vwVar = this.v.get();
        if (vwVar == null) {
            return;
        }
        this.wg = vwVar.vw(this.vw);
        com.ss.android.downloadlib.bt.t<R, ?> tVar2 = this.kz;
        if (tVar2 != null) {
            tVar2.run();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <NR> com.ss.android.downloadlib.bt.t<R, NR> vw(int i, com.ss.android.downloadlib.bt.t.vw<R, NR> vwVar) {
        com.ss.android.downloadlib.bt.t tVar = (com.ss.android.downloadlib.bt.t<R, ?>) new com.ss.android.downloadlib.bt.t(i, vwVar, null);
        this.kz = tVar;
        tVar.yl = this;
        return tVar;
    }

    public <NR> com.ss.android.downloadlib.bt.t<R, NR> vw(com.ss.android.downloadlib.bt.t.vw<R, NR> vwVar) {
        return vw(0, vwVar);
    }

    public void vw() {
        com.ss.android.downloadlib.bt.t<?, P> tVar = this.yl;
        if (tVar != null) {
            tVar.vw();
        } else {
            run();
        }
    }
}
