package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class gm implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.ChannelExpertRecommendFragment n;

    public /* synthetic */ gm(com.moji.mjweather.feed.ChannelExpertRecommendFragment channelExpertRecommendFragment) {
        this.n = channelExpertRecommendFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.ChannelExpertRecommendFragment.f(this.n, (com.moji.credit.data.UiStatus) obj);
    }
}
