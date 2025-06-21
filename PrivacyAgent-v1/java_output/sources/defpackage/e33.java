package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class e33 implements java.lang.Runnable {
    public final /* synthetic */ int A;
    public final /* synthetic */ com.moji.mjweather.feed.video.view.TouTiaoVideoView n;
    public final /* synthetic */ int t;
    public final /* synthetic */ int u;
    public final /* synthetic */ int v;
    public final /* synthetic */ int w;
    public final /* synthetic */ int x;
    public final /* synthetic */ int y;
    public final /* synthetic */ int z;

    public /* synthetic */ e33(com.moji.mjweather.feed.video.view.TouTiaoVideoView touTiaoVideoView, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.n = touTiaoVideoView;
        this.t = i;
        this.u = i2;
        this.v = i3;
        this.w = i4;
        this.x = i5;
        this.y = i6;
        this.z = i7;
        this.A = i8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.feed.video.view.TouTiaoVideoView.e(this.n, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A);
    }
}
