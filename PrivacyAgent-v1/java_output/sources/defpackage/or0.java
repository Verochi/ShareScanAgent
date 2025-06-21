package defpackage;

/* loaded from: classes26.dex */
public final /* synthetic */ class or0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.index.dress.DressIndexResp.Data.Best.TaoDataX n;
    public final /* synthetic */ int t;
    public final /* synthetic */ com.moji.index.adapter.ImagePageAdapter u;

    public /* synthetic */ or0(com.moji.index.dress.DressIndexResp.Data.Best.TaoDataX taoDataX, int i, com.moji.index.adapter.ImagePageAdapter imagePageAdapter) {
        this.n = taoDataX;
        this.t = i;
        this.u = imagePageAdapter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.index.adapter.ImagePageAdapter.a(this.n, this.t, this.u, view);
    }
}
