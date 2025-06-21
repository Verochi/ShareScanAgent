package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class k02 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.toolmatrix.photography.PhotoGraphyActivity n;

    public /* synthetic */ k02(com.moji.toolmatrix.photography.PhotoGraphyActivity photoGraphyActivity) {
        this.n = photoGraphyActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.toolmatrix.photography.PhotoGraphyActivity.f(this.n, (java.lang.Boolean) obj);
    }
}
