package defpackage;

/* loaded from: classes2.dex */
public final /* synthetic */ class me0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjfishing.FishingSpotDetailsActivity n;

    public /* synthetic */ me0(com.moji.mjfishing.FishingSpotDetailsActivity fishingSpotDetailsActivity) {
        this.n = fishingSpotDetailsActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjfishing.FishingSpotDetailsActivity.g(this.n, (com.moji.http.mqn.entity.TopicPraise) obj);
    }
}
