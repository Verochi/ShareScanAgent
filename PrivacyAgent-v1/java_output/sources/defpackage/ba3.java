package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ba3 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.detail.view.VideoOperateLayout n;
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.live.LiveVideoDetailFragment t;

    public /* synthetic */ ba3(com.moji.mjweather.feed.newvideo.detail.view.VideoOperateLayout videoOperateLayout, com.moji.mjweather.feed.newvideo.live.LiveVideoDetailFragment liveVideoDetailFragment) {
        this.n = videoOperateLayout;
        this.t = liveVideoDetailFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.feed.newvideo.detail.view.VideoOperateLayout.e(this.n, this.t, view);
    }
}
