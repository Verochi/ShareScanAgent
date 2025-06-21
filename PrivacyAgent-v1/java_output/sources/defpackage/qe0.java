package defpackage;

/* loaded from: classes2.dex */
public final /* synthetic */ class qe0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.http.fishing.entity.FishingPlaceBean n;
    public final /* synthetic */ com.moji.mjfishing.adapter.holder.FishingSpotDetailsHeadViewHolder t;

    public /* synthetic */ qe0(com.moji.http.fishing.entity.FishingPlaceBean fishingPlaceBean, com.moji.mjfishing.adapter.holder.FishingSpotDetailsHeadViewHolder fishingSpotDetailsHeadViewHolder) {
        this.n = fishingPlaceBean;
        this.t = fishingSpotDetailsHeadViewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjfishing.adapter.holder.FishingSpotDetailsHeadViewHolder.b(this.n, this.t, view);
    }
}
