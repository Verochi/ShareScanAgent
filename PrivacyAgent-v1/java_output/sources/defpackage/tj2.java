package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class tj2 implements java.lang.Runnable {
    public final /* synthetic */ android.widget.RelativeLayout n;
    public final /* synthetic */ com.moji.toolmatrix.opensignature.SignatureDetailActivity t;

    public /* synthetic */ tj2(android.widget.RelativeLayout relativeLayout, com.moji.toolmatrix.opensignature.SignatureDetailActivity signatureDetailActivity) {
        this.n = relativeLayout;
        this.t = signatureDetailActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.toolmatrix.opensignature.SignatureDetailActivity.d(this.n, this.t);
    }
}
