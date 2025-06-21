package defpackage;

/* loaded from: classes5.dex */
public final /* synthetic */ class wq2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjstargaze.StarGazeMainActivity n;

    public /* synthetic */ wq2(com.moji.mjstargaze.StarGazeMainActivity starGazeMainActivity) {
        this.n = starGazeMainActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjstargaze.StarGazeMainActivity.d(this.n, (com.moji.http.stargaze.StarGazeMainBean) obj);
    }
}
