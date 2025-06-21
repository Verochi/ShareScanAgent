package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class nm0 implements com.moji.newliveview.base.view.imagelayout.ImageLayoutView.OnItemClickListener {
    public final /* synthetic */ com.moji.newliveview.frienddynamic.HeaderPresenter n;
    public final /* synthetic */ com.moji.newliveview.frienddynamic.HeaderPresenter.HeaderViewHolder t;

    public /* synthetic */ nm0(com.moji.newliveview.frienddynamic.HeaderPresenter headerPresenter, com.moji.newliveview.frienddynamic.HeaderPresenter.HeaderViewHolder headerViewHolder) {
        this.n = headerPresenter;
        this.t = headerViewHolder;
    }

    public final void onItemClick(android.view.View view, java.util.ArrayList arrayList, java.util.ArrayList arrayList2, float[] fArr, int i, boolean z) {
        com.moji.newliveview.frienddynamic.HeaderPresenter.HeaderViewHolder.b(this.n, this.t, view, arrayList, arrayList2, fArr, i, z);
    }
}
