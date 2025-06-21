package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class hl implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.ChannelAttentionFragment n;

    public /* synthetic */ hl(com.moji.mjweather.feed.ChannelAttentionFragment channelAttentionFragment) {
        this.n = channelAttentionFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.ChannelAttentionFragment.e(this.n, (com.moji.mjweather.feed.newvideo.model.HomeFeedVideoPraiseData) obj);
    }
}
