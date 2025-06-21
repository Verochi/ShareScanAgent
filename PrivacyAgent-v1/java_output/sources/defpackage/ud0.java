package defpackage;

/* loaded from: classes2.dex */
public final /* synthetic */ class ud0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjfishing.FishingMainActivity n;

    public /* synthetic */ ud0(com.moji.mjfishing.FishingMainActivity fishingMainActivity) {
        this.n = fishingMainActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjfishing.FishingMainActivity.f(this.n, (com.moji.mjcitypicker.data.SelectedArea) obj);
    }
}
