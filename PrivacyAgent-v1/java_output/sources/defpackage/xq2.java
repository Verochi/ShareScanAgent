package defpackage;

/* loaded from: classes5.dex */
public final /* synthetic */ class xq2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjstargaze.StarGazeMainActivity n;

    public /* synthetic */ xq2(com.moji.mjstargaze.StarGazeMainActivity starGazeMainActivity) {
        this.n = starGazeMainActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjstargaze.StarGazeMainActivity.b(this.n, (com.moji.mjstargaze.StarGazeTotleBean) obj);
    }
}
