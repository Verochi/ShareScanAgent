package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class em implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.ChannelExpertRecommendFragment n;

    public /* synthetic */ em(com.moji.mjweather.feed.ChannelExpertRecommendFragment channelExpertRecommendFragment) {
        this.n = channelExpertRecommendFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.ChannelExpertRecommendFragment.e(this.n, (com.moji.mjweather.feed.expert.api.ExpertAttentionData) obj);
    }
}
