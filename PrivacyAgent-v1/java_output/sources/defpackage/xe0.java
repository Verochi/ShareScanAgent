package defpackage;

/* loaded from: classes2.dex */
public final /* synthetic */ class xe0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjfishing.FishingSpotListActivity n;

    public /* synthetic */ xe0(com.moji.mjfishing.FishingSpotListActivity fishingSpotListActivity) {
        this.n = fishingSpotListActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjfishing.FishingSpotListActivity.e(this.n, (com.moji.http.fishing.entity.FishlingSpotList) obj);
    }
}
