package defpackage;

/* loaded from: classes20.dex */
public final /* synthetic */ class sd2 implements java.lang.Runnable {
    public final /* synthetic */ moji.com.mjweatherservicebase.ScenesLocationMapFragment n;
    public final /* synthetic */ double t;
    public final /* synthetic */ double u;
    public final /* synthetic */ java.lang.String v;
    public final /* synthetic */ float w;

    public /* synthetic */ sd2(moji.com.mjweatherservicebase.ScenesLocationMapFragment scenesLocationMapFragment, double d, double d2, java.lang.String str, float f) {
        this.n = scenesLocationMapFragment;
        this.t = d;
        this.u = d2;
        this.v = str;
        this.w = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        moji.com.mjweatherservicebase.ScenesLocationMapFragment.c(this.n, this.t, this.u, this.v, this.w);
    }
}
