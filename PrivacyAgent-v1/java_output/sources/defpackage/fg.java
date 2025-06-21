package defpackage;

/* loaded from: classes18.dex */
public final /* synthetic */ class fg implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.viewpager.autobanner.adapter.BannerAdapter n;
    public final /* synthetic */ java.lang.Object t;
    public final /* synthetic */ int u;

    public /* synthetic */ fg(com.moji.viewpager.autobanner.adapter.BannerAdapter bannerAdapter, java.lang.Object obj, int i) {
        this.n = bannerAdapter;
        this.t = obj;
        this.u = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.viewpager.autobanner.adapter.BannerAdapter.a(this.n, this.t, this.u, view);
    }
}
