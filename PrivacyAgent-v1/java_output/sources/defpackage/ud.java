package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class ud implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.liveview.home.attention.AttentionExpertPersonAdapter n;
    public final /* synthetic */ com.moji.liveview.home.attention.AttentionExpertPersonAdapter.ExpertPersonHolder t;

    public /* synthetic */ ud(com.moji.liveview.home.attention.AttentionExpertPersonAdapter attentionExpertPersonAdapter, com.moji.liveview.home.attention.AttentionExpertPersonAdapter.ExpertPersonHolder expertPersonHolder) {
        this.n = attentionExpertPersonAdapter;
        this.t = expertPersonHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.liveview.home.attention.AttentionExpertPersonAdapter.ExpertPersonHolder.b(this.n, this.t, view);
    }
}
