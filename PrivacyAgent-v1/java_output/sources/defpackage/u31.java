package defpackage;

/* loaded from: classes4.dex */
public final /* synthetic */ class u31 implements java.util.concurrent.Callable {
    public final /* synthetic */ com.moji.mjlunarphase.MJLunarPhaseActivity n;
    public final /* synthetic */ android.graphics.Bitmap t;
    public final /* synthetic */ java.lang.String u;
    public final /* synthetic */ java.lang.String v;

    public /* synthetic */ u31(com.moji.mjlunarphase.MJLunarPhaseActivity mJLunarPhaseActivity, android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2) {
        this.n = mJLunarPhaseActivity;
        this.t = bitmap;
        this.u = str;
        this.v = str2;
    }

    @Override // java.util.concurrent.Callable
    public final java.lang.Object call() {
        return com.moji.mjlunarphase.MJLunarPhaseActivity.g(this.n, this.t, this.u, this.v);
    }
}
