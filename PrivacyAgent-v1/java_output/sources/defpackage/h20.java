package defpackage;

/* loaded from: classes11.dex */
public final /* synthetic */ class h20 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.rainclould.DisasterActivity n;

    public /* synthetic */ h20(com.moji.rainclould.DisasterActivity disasterActivity) {
        this.n = disasterActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.rainclould.DisasterActivity.m(this.n, (com.moji.location.entity.MJLocation) obj);
    }
}
