package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class fx0 implements com.moji.share.MJThirdShareManager.OnCancelBtnClickListener {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.live.LiveVideoDetailFragment n;
    public final /* synthetic */ com.moji.base.enums.VideoOpenFrom t;

    public /* synthetic */ fx0(com.moji.mjweather.feed.newvideo.live.LiveVideoDetailFragment liveVideoDetailFragment, com.moji.base.enums.VideoOpenFrom videoOpenFrom) {
        this.n = liveVideoDetailFragment;
        this.t = videoOpenFrom;
    }

    public final void onShareCancelBtnClicked() {
        com.moji.mjweather.feed.newvideo.live.LiveVideoDetailFragment.a(this.n, this.t);
    }
}
