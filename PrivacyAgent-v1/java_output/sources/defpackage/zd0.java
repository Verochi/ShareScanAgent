package defpackage;

/* loaded from: classes2.dex */
public final /* synthetic */ class zd0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjfishing.FishingMainActivity n;

    public /* synthetic */ zd0(com.moji.mjfishing.FishingMainActivity fishingMainActivity) {
        this.n = fishingMainActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjfishing.FishingMainActivity.b(this.n, (com.moji.http.fishing.entity.FishingHomeResp) obj);
    }
}
