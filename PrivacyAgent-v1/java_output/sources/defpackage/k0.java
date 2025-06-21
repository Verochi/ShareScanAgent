package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class k0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.feed.adapter.channel.AbsChannelViewHolder n;
    public final /* synthetic */ com.moji.mjweather.feed.data.ZakerFeed t;

    public /* synthetic */ k0(com.moji.mjweather.feed.adapter.channel.AbsChannelViewHolder absChannelViewHolder, com.moji.mjweather.feed.data.ZakerFeed zakerFeed) {
        this.n = absChannelViewHolder;
        this.t = zakerFeed;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.feed.adapter.channel.AbsChannelViewHolder.a(this.n, this.t, view);
    }
}
