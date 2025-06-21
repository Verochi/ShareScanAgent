package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class o0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.waterfall.AbsChannelWaterfallFragment n;

    public /* synthetic */ o0(com.moji.mjweather.feed.waterfall.AbsChannelWaterfallFragment absChannelWaterfallFragment) {
        this.n = absChannelWaterfallFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.waterfall.AbsChannelWaterfallFragment.e(this.n, (com.moji.mjweather.feed.dress.data.DressListData) obj);
    }
}
