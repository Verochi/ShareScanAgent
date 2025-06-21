package defpackage;

/* loaded from: classes2.dex */
public final /* synthetic */ class id0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjfishing.fragment.FishingDynamicFragment n;

    public /* synthetic */ id0(com.moji.mjfishing.fragment.FishingDynamicFragment fishingDynamicFragment) {
        this.n = fishingDynamicFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjfishing.fragment.FishingDynamicFragment.d(this.n, (com.moji.http.mqn.entity.TopicPraise) obj);
    }
}
