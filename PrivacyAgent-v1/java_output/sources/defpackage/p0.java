package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class p0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.waterfall.AbsChannelWaterfallFragment n;

    public /* synthetic */ p0(com.moji.mjweather.feed.waterfall.AbsChannelWaterfallFragment absChannelWaterfallFragment) {
        this.n = absChannelWaterfallFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.waterfall.AbsChannelWaterfallFragment.b(this.n, (java.lang.Boolean) obj);
    }
}
