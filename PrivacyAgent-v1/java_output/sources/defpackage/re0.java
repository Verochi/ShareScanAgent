package defpackage;

/* loaded from: classes2.dex */
public final /* synthetic */ class re0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjfishing.adapter.holder.FishingSpotDetailsHeadViewHolder n;
    public final /* synthetic */ com.moji.http.fishing.entity.FishingPlaceBean t;

    public /* synthetic */ re0(com.moji.mjfishing.adapter.holder.FishingSpotDetailsHeadViewHolder fishingSpotDetailsHeadViewHolder, com.moji.http.fishing.entity.FishingPlaceBean fishingPlaceBean) {
        this.n = fishingSpotDetailsHeadViewHolder;
        this.t = fishingPlaceBean;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjfishing.adapter.holder.FishingSpotDetailsHeadViewHolder.a(this.n, this.t, view);
    }
}
