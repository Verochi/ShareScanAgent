package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class j5 implements java.lang.Runnable {
    public final /* synthetic */ android.view.View n;
    public final /* synthetic */ float t;
    public final /* synthetic */ float u;
    public final /* synthetic */ long v;

    public /* synthetic */ j5(android.view.View view, float f, float f2, long j) {
        this.n = view;
        this.t = f;
        this.u = f2;
        this.v = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.util.AdMJUtils.b(this.n, this.t, this.u, this.v);
    }
}
