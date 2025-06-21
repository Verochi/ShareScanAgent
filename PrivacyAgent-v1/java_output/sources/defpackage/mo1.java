package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class mo1 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.third.MultipleAdLoad1 n;
    public final /* synthetic */ long t;
    public final /* synthetic */ java.util.List u;

    public /* synthetic */ mo1(com.moji.mjad.third.MultipleAdLoad1 multipleAdLoad1, long j, java.util.List list) {
        this.n = multipleAdLoad1;
        this.t = j;
        this.u = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.third.MultipleAdLoad1.e(this.n, this.t, this.u);
    }
}
