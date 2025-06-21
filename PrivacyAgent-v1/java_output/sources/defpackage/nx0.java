package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class nx0 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.live.LiveVideoFragment n;
    public final /* synthetic */ androidx.fragment.app.Fragment t;

    public /* synthetic */ nx0(com.moji.mjweather.feed.newvideo.live.LiveVideoFragment liveVideoFragment, androidx.fragment.app.Fragment fragment) {
        this.n = liveVideoFragment;
        this.t = fragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.feed.newvideo.live.LiveVideoFragment.b(this.n, this.t);
    }
}
