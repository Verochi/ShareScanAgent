package defpackage;

/* loaded from: classes9.dex */
public final /* synthetic */ class rr0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.page.index.IndexActivityV2 n;

    public /* synthetic */ rr0(com.moji.page.index.IndexActivityV2 indexActivityV2) {
        this.n = indexActivityV2;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.page.index.IndexActivityV2.b(this.n, (com.moji.page.index.IndexResponseV2) obj);
    }
}
