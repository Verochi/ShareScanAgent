package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ul implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.dress.ChannelDressFragment n;

    public /* synthetic */ ul(com.moji.mjweather.feed.dress.ChannelDressFragment channelDressFragment) {
        this.n = channelDressFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.dress.ChannelDressFragment.g(this.n, (com.moji.opevent.model.OperationEvent) obj);
    }
}
