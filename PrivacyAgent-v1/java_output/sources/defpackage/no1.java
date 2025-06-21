package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class no1 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.third.MultipleAdLoad2 n;
    public final /* synthetic */ int t;
    public final /* synthetic */ long u;

    public /* synthetic */ no1(com.moji.mjad.third.MultipleAdLoad2 multipleAdLoad2, int i, long j) {
        this.n = multipleAdLoad2;
        this.t = i;
        this.u = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.third.MultipleAdLoad2.f(this.n, this.t, this.u);
    }
}
