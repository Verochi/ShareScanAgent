package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class tn2 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ com.moji.dialog.MJDialog n;
    public final /* synthetic */ com.moji.snow.SnowRecordActivity t;

    public /* synthetic */ tn2(com.moji.dialog.MJDialog mJDialog, com.moji.snow.SnowRecordActivity snowRecordActivity) {
        this.n = mJDialog;
        this.t = snowRecordActivity;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.snow.SnowRecordActivity.e(this.n, this.t, (java.lang.Boolean) obj);
    }
}
