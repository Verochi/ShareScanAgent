package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class f91 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.MainFragment n;
    public final /* synthetic */ int t;

    public /* synthetic */ f91(com.moji.mjweather.MainFragment mainFragment, int i) {
        this.n = mainFragment;
        this.t = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.MainFragment.k(this.n, this.t, view);
    }
}
