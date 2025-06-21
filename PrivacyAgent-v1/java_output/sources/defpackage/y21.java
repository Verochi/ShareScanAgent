package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class y21 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.influenza.MJInfluenzaMainActivity n;

    public /* synthetic */ y21(com.moji.influenza.MJInfluenzaMainActivity mJInfluenzaMainActivity) {
        this.n = mJInfluenzaMainActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.influenza.MJInfluenzaMainActivity.e(this.n, (com.moji.mjcitypicker.data.SelectedArea) obj);
    }
}
