package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class zv1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.toolmatrix.opensignature.OpenSignatureActivity n;

    public /* synthetic */ zv1(com.moji.toolmatrix.opensignature.OpenSignatureActivity openSignatureActivity) {
        this.n = openSignatureActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.toolmatrix.opensignature.OpenSignatureActivity.c(this.n, (com.moji.http.toolmatrix.entity.SignatureResult) obj);
    }
}
