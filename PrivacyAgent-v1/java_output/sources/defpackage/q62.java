package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class q62 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.feed.adapter.channel.QAViewHolderForRegimen n;
    public final /* synthetic */ com.moji.mjweather.feed.data.ZakerFeed t;
    public final /* synthetic */ com.moji.mjweather.feed.data.ZakerFeed u;

    public /* synthetic */ q62(com.moji.mjweather.feed.adapter.channel.QAViewHolderForRegimen qAViewHolderForRegimen, com.moji.mjweather.feed.data.ZakerFeed zakerFeed, com.moji.mjweather.feed.data.ZakerFeed zakerFeed2) {
        this.n = qAViewHolderForRegimen;
        this.t = zakerFeed;
        this.u = zakerFeed2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.feed.adapter.channel.QAViewHolderForRegimen.d(this.n, this.t, this.u, view);
    }
}
