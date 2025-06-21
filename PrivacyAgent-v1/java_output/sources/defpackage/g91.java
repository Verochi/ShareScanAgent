package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class g91 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.MainFragment n;

    public /* synthetic */ g91(com.moji.mjweather.MainFragment mainFragment) {
        this.n = mainFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.MainFragment.j(this.n, (java.lang.Integer) obj);
    }
}
