package defpackage;

/* loaded from: classes18.dex */
public final /* synthetic */ class gg implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.viewpager.autobanner.adapter.BannerAdapter n;
    public final /* synthetic */ androidx.recyclerview.widget.RecyclerView.ViewHolder t;

    public /* synthetic */ gg(com.moji.viewpager.autobanner.adapter.BannerAdapter bannerAdapter, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        this.n = bannerAdapter;
        this.t = viewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.viewpager.autobanner.adapter.BannerAdapter.b(this.n, this.t, view);
    }
}
