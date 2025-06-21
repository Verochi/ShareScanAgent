package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class js2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.member.adapter.SubNormalSpotAdapter n;
    public final /* synthetic */ com.moji.member.adapter.SubNormalSpotAdapter.SubscribeViewHolder t;
    public final /* synthetic */ java.util.List u;
    public final /* synthetic */ int v;

    public /* synthetic */ js2(com.moji.member.adapter.SubNormalSpotAdapter subNormalSpotAdapter, com.moji.member.adapter.SubNormalSpotAdapter.SubscribeViewHolder subscribeViewHolder, java.util.List list, int i) {
        this.n = subNormalSpotAdapter;
        this.t = subscribeViewHolder;
        this.u = list;
        this.v = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.member.adapter.SubNormalSpotAdapter.SubscribeViewHolder.b(this.n, this.t, this.u, this.v, view);
    }
}
