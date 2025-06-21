package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class m60 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.dress.DressVideoActivity n;
    public final /* synthetic */ long t;

    public /* synthetic */ m60(com.moji.mjweather.feed.dress.DressVideoActivity dressVideoActivity, long j) {
        this.n = dressVideoActivity;
        this.t = j;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.dress.DressVideoActivity.e(this.n, this.t, (com.moji.mjweather.feed.dress.data.DressListData) obj);
    }
}
