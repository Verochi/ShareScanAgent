package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class o62 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.feed.adapter.channel.QAViewHolderForRegimen n;
    public final /* synthetic */ com.moji.mjweather.feed.data.ZakerFeed t;

    public /* synthetic */ o62(com.moji.mjweather.feed.adapter.channel.QAViewHolderForRegimen qAViewHolderForRegimen, com.moji.mjweather.feed.data.ZakerFeed zakerFeed) {
        this.n = qAViewHolderForRegimen;
        this.t = zakerFeed;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.feed.adapter.channel.QAViewHolderForRegimen.g(this.n, this.t, view);
    }
}
