package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class ml2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.ski.SkiDetailsActivity n;

    public /* synthetic */ ml2(com.moji.ski.SkiDetailsActivity skiDetailsActivity) {
        this.n = skiDetailsActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.ski.SkiDetailsActivity.c(this.n, (com.moji.http.ski.SkiingDetailResp) obj);
    }
}
