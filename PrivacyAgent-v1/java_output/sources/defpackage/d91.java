package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class d91 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.MainFragment n;
    public final /* synthetic */ boolean t;

    public /* synthetic */ d91(com.moji.mjweather.MainFragment mainFragment, boolean z) {
        this.n = mainFragment;
        this.t = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.MainFragment.m(this.n, this.t);
    }
}
