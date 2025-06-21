package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class kt0 implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.exoplayer2.SimpleExoPlayer n;
    public final /* synthetic */ android.os.HandlerThread t;

    public /* synthetic */ kt0(com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer, android.os.HandlerThread handlerThread) {
        this.n = simpleExoPlayer;
        this.t = handlerThread;
    }

    @Override // java.lang.Runnable
    public final void run() {
        cn.jzvd.JZMediaExo.n(this.n, this.t);
    }
}
