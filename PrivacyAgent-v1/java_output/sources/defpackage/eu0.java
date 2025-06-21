package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class eu0 implements java.lang.Runnable {
    public final /* synthetic */ android.media.MediaPlayer n;
    public final /* synthetic */ android.os.HandlerThread t;

    public /* synthetic */ eu0(android.media.MediaPlayer mediaPlayer, android.os.HandlerThread handlerThread) {
        this.n = mediaPlayer;
        this.t = handlerThread;
    }

    @Override // java.lang.Runnable
    public final void run() {
        cn.jzvd.JZMediaSystem.w(this.n, this.t);
    }
}
