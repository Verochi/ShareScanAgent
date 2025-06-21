package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class cy0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.liveview.home.near.ui.LiveViewCityFragment n;

    public /* synthetic */ cy0(com.moji.liveview.home.near.ui.LiveViewCityFragment liveViewCityFragment) {
        this.n = liveViewCityFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.liveview.home.near.ui.LiveViewCityFragment.d(this.n, (com.moji.liveview.home.near.model.LiveCityData) obj);
    }
}
