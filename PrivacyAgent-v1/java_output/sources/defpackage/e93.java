package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class e93 implements com.moji.share.MJThirdShareManager.OnCancelBtnClickListener {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.detail.VideoDetailFragment n;
    public final /* synthetic */ com.moji.base.enums.VideoOpenFrom t;

    public /* synthetic */ e93(com.moji.mjweather.feed.newvideo.detail.VideoDetailFragment videoDetailFragment, com.moji.base.enums.VideoOpenFrom videoOpenFrom) {
        this.n = videoDetailFragment;
        this.t = videoOpenFrom;
    }

    public final void onShareCancelBtnClicked() {
        com.moji.mjweather.feed.newvideo.detail.VideoDetailFragment.p(this.n, this.t);
    }
}
