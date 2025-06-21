package defpackage;

/* loaded from: classes11.dex */
public final /* synthetic */ class c30 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.rainclould.DisasterDetailActivity n;

    public /* synthetic */ c30(com.moji.rainclould.DisasterDetailActivity disasterDetailActivity) {
        this.n = disasterDetailActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.rainclould.DisasterDetailActivity.b(this.n, (com.moji.http.rainclould.entity.DisasterDetailResult) obj);
    }
}
