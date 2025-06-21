package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class y73 implements java.util.concurrent.ThreadFactory {
    public final /* synthetic */ java.lang.String n;

    public /* synthetic */ y73(java.lang.String str) {
        this.n = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final java.lang.Thread newThread(java.lang.Runnable runnable) {
        java.lang.Thread l;
        l = com.google.android.exoplayer2.util.Util.l(this.n, runnable);
        return l;
    }
}
