package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ko0 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.detail.view.HomeVideoDescView n;
    public final /* synthetic */ java.lang.CharSequence t;
    public final /* synthetic */ boolean u;
    public final /* synthetic */ java.lang.CharSequence v;
    public final /* synthetic */ com.moji.http.feedvideo.entity.HomeFeed w;

    public /* synthetic */ ko0(com.moji.mjweather.feed.newvideo.detail.view.HomeVideoDescView homeVideoDescView, java.lang.CharSequence charSequence, boolean z, java.lang.CharSequence charSequence2, com.moji.http.feedvideo.entity.HomeFeed homeFeed) {
        this.n = homeVideoDescView;
        this.t = charSequence;
        this.u = z;
        this.v = charSequence2;
        this.w = homeFeed;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.feed.newvideo.detail.view.HomeVideoDescView.a(this.n, this.t, this.u, this.v, this.w);
    }
}
