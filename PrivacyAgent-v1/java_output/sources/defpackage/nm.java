package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class nm implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.adapter.ChannelZakerFragmentListAdapterV2 n;

    public /* synthetic */ nm(com.moji.mjweather.feed.adapter.ChannelZakerFragmentListAdapterV2 channelZakerFragmentListAdapterV2) {
        this.n = channelZakerFragmentListAdapterV2;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        this.n.updateOperationData((com.moji.opevent.model.OperationEvent) obj);
    }
}
