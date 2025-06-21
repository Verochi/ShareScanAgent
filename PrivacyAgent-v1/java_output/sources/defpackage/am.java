package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class am implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.dress.ChannelDressFragment n;

    public /* synthetic */ am(com.moji.mjweather.feed.dress.ChannelDressFragment channelDressFragment) {
        this.n = channelDressFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.dress.ChannelDressFragment.f(this.n, (com.moji.credit.data.UiStatus) obj);
    }
}
