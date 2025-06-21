package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class hg implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.feed.view.banner.BannerAdapter n;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef t;

    public /* synthetic */ hg(com.moji.mjweather.feed.view.banner.BannerAdapter bannerAdapter, kotlin.jvm.internal.Ref.ObjectRef objectRef) {
        this.n = bannerAdapter;
        this.t = objectRef;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.feed.view.banner.BannerAdapter.onBindViewHolder.2.a(this.n, this.t);
    }
}
