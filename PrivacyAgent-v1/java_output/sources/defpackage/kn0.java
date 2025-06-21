package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class kn0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.newliveview.home.adapter.HomeExpertPersonAdapter n;
    public final /* synthetic */ com.moji.newliveview.home.adapter.HomeExpertPersonAdapter.ExpertPersonHolder t;

    public /* synthetic */ kn0(com.moji.newliveview.home.adapter.HomeExpertPersonAdapter homeExpertPersonAdapter, com.moji.newliveview.home.adapter.HomeExpertPersonAdapter.ExpertPersonHolder expertPersonHolder) {
        this.n = homeExpertPersonAdapter;
        this.t = expertPersonHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newliveview.home.adapter.HomeExpertPersonAdapter.ExpertPersonHolder.b(this.n, this.t, view);
    }
}
