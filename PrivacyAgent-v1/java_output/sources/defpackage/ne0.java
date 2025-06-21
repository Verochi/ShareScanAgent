package defpackage;

/* loaded from: classes2.dex */
public final /* synthetic */ class ne0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjfishing.FishingSpotDetailsActivity n;

    public /* synthetic */ ne0(com.moji.mjfishing.FishingSpotDetailsActivity fishingSpotDetailsActivity) {
        this.n = fishingSpotDetailsActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjfishing.FishingSpotDetailsActivity.c(this.n, (com.moji.http.fishing.entity.FishingPlaceDetailResp) obj);
    }
}
