package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class r0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.waterfall.AbsChannelWaterfallFragment n;

    public /* synthetic */ r0(com.moji.mjweather.feed.waterfall.AbsChannelWaterfallFragment absChannelWaterfallFragment) {
        this.n = absChannelWaterfallFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.waterfall.AbsChannelWaterfallFragment.i(this.n, (com.moji.mjweather.feed.dress.data.DressRefreshMsg) obj);
    }
}
