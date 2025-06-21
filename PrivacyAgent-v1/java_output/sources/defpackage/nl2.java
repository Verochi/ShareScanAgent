package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class nl2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.ski.SkiDetailsActivity n;

    public /* synthetic */ nl2(com.moji.ski.SkiDetailsActivity skiDetailsActivity) {
        this.n = skiDetailsActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.ski.SkiDetailsActivity.e(this.n, (com.moji.ski.UiStatus) obj);
    }
}
