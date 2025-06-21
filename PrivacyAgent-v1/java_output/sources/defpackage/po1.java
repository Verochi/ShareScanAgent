package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class po1 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.tab.bid.MultipleBlockingAdLoad n;
    public final /* synthetic */ java.util.List t;

    public /* synthetic */ po1(com.moji.mjad.tab.bid.MultipleBlockingAdLoad multipleBlockingAdLoad, java.util.List list) {
        this.n = multipleBlockingAdLoad;
        this.t = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.tab.bid.MultipleBlockingAdLoad.d(this.n, this.t);
    }
}
