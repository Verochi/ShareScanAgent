package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class gl implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.ChannelAttentionFragment n;

    public /* synthetic */ gl(com.moji.mjweather.feed.ChannelAttentionFragment channelAttentionFragment) {
        this.n = channelAttentionFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.ChannelAttentionFragment.c(this.n, (com.moji.mjweather.feed.attention.api.AttentionFeedChannelData) obj);
    }
}
