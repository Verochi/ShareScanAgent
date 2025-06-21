package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class jn2 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ com.moji.dialog.MJDialog n;
    public final /* synthetic */ com.moji.snow.SnowMoreActivity t;

    public /* synthetic */ jn2(com.moji.dialog.MJDialog mJDialog, com.moji.snow.SnowMoreActivity snowMoreActivity) {
        this.n = mJDialog;
        this.t = snowMoreActivity;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.snow.SnowMoreActivity.b(this.n, this.t, (java.lang.Boolean) obj);
    }
}
