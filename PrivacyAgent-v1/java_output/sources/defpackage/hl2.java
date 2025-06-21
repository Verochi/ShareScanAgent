package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class hl2 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ com.moji.ski.SkiActivity n;

    public /* synthetic */ hl2(com.moji.ski.SkiActivity skiActivity) {
        this.n = skiActivity;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.ski.SkiActivity.e(this.n, (java.lang.Boolean) obj);
    }
}
