package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class su2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.tabme.TabMeFragment n;
    public final /* synthetic */ int t;

    public /* synthetic */ su2(com.moji.mjweather.tabme.TabMeFragment tabMeFragment, int i) {
        this.n = tabMeFragment;
        this.t = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.tabme.TabMeFragment.f(this.n, this.t);
    }
}
