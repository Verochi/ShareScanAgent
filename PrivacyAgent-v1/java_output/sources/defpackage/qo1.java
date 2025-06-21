package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class qo1 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.tab.bid.MultipleBlockingAdLoad n;
    public final /* synthetic */ long t;
    public final /* synthetic */ java.util.List u;

    public /* synthetic */ qo1(com.moji.mjad.tab.bid.MultipleBlockingAdLoad multipleBlockingAdLoad, long j, java.util.List list) {
        this.n = multipleBlockingAdLoad;
        this.t = j;
        this.u = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.tab.bid.MultipleBlockingAdLoad.c(this.n, this.t, this.u);
    }
}
