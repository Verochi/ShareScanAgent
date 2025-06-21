package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class uj2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.toolmatrix.opensignature.SignatureDetailActivity n;

    public /* synthetic */ uj2(com.moji.toolmatrix.opensignature.SignatureDetailActivity signatureDetailActivity) {
        this.n = signatureDetailActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.toolmatrix.opensignature.SignatureDetailActivity.c(this.n, (com.moji.http.toolmatrix.entity.SignatureResult) obj);
    }
}
