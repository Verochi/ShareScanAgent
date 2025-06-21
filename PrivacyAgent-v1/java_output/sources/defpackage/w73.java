package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class w73 implements java.util.concurrent.ThreadFactory {
    public final /* synthetic */ java.lang.String n;
    public final /* synthetic */ boolean t;

    public /* synthetic */ w73(java.lang.String str, boolean z) {
        this.n = str;
        this.t = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final java.lang.Thread newThread(java.lang.Runnable runnable) {
        java.lang.Thread f;
        f = okhttp3.internal.Util.f(this.n, this.t, runnable);
        return f;
    }
}
