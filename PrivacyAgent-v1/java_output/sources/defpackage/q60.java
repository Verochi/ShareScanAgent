package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class q60 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.dress.DressVideoFragment n;

    public /* synthetic */ q60(com.moji.mjweather.feed.dress.DressVideoFragment dressVideoFragment) {
        this.n = dressVideoFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.dress.DressVideoFragment.a(this.n, (com.moji.http.fdsapi.entity.ZakerBaseFeed) obj);
    }
}
