package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class dm implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.ChannelExpertRecommendFragment n;

    public /* synthetic */ dm(com.moji.mjweather.feed.ChannelExpertRecommendFragment channelExpertRecommendFragment) {
        this.n = channelExpertRecommendFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.ChannelExpertRecommendFragment.g(this.n, (com.moji.mjweather.feed.expert.api.ExpertRecommendData) obj);
    }
}
