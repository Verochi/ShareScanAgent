package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class cl implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.user.homepage.CertificateActivity n;

    public /* synthetic */ cl(com.moji.user.homepage.CertificateActivity certificateActivity) {
        this.n = certificateActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.user.homepage.CertificateActivity.b(this.n, (com.moji.http.snsforum.entity.InformationResult) obj);
    }
}
