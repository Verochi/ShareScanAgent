package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class nl implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.feed.ChannelBaseFragment n;

    public /* synthetic */ nl(com.moji.mjweather.feed.ChannelBaseFragment channelBaseFragment) {
        this.n = channelBaseFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.recordItemsShow();
    }
}
