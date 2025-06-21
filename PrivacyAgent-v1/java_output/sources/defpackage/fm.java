package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class fm implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.ChannelExpertRecommendFragment n;

    public /* synthetic */ fm(com.moji.mjweather.feed.ChannelExpertRecommendFragment channelExpertRecommendFragment) {
        this.n = channelExpertRecommendFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.ChannelExpertRecommendFragment.b(this.n, (java.lang.Integer) obj);
    }
}
