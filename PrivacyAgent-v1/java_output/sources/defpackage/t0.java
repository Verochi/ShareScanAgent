package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class t0 implements java.lang.Runnable {
    public final /* synthetic */ int n;
    public final /* synthetic */ com.moji.mjweather.feed.waterfall.AbsChannelWaterfallFragment t;

    public /* synthetic */ t0(int i, com.moji.mjweather.feed.waterfall.AbsChannelWaterfallFragment absChannelWaterfallFragment) {
        this.n = i;
        this.t = absChannelWaterfallFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.feed.waterfall.AbsChannelWaterfallFragment.a(this.n, this.t);
    }
}
