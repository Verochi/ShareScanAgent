package defpackage;

/* loaded from: classes11.dex */
public final /* synthetic */ class e20 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.rainclould.DisasterActivity n;

    public /* synthetic */ e20(com.moji.rainclould.DisasterActivity disasterActivity) {
        this.n = disasterActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.rainclould.DisasterActivity.k(this.n, (com.moji.rainclould.data.DistrictSearchResult) obj);
    }
}
