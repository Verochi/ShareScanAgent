package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class l02 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.toolmatrix.photography.PhotoGraphyActivity n;

    public /* synthetic */ l02(com.moji.toolmatrix.photography.PhotoGraphyActivity photoGraphyActivity) {
        this.n = photoGraphyActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.toolmatrix.photography.PhotoGraphyActivity.d(this.n, (com.moji.http.toolmatrix.entity.PhotoGraphyResult) obj);
    }
}
