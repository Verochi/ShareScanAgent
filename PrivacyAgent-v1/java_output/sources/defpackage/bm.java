package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class bm implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.dress.ChannelDressFragment n;

    public /* synthetic */ bm(com.moji.mjweather.feed.dress.ChannelDressFragment channelDressFragment) {
        this.n = channelDressFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.dress.ChannelDressFragment.d(this.n, (com.moji.mjweather.feed.dress.data.DressRefreshMsg) obj);
    }
}
