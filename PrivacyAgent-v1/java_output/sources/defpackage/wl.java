package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class wl implements java.lang.Runnable {
    public final /* synthetic */ int n;
    public final /* synthetic */ com.moji.mjweather.feed.dress.ChannelDressFragment t;

    public /* synthetic */ wl(int i, com.moji.mjweather.feed.dress.ChannelDressFragment channelDressFragment) {
        this.n = i;
        this.t = channelDressFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.feed.dress.ChannelDressFragment.j(this.n, this.t);
    }
}
