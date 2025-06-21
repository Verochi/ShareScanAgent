package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class c1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.AbsHomeChannelFragment n;

    public /* synthetic */ c1(com.moji.mjweather.feed.newvideo.AbsHomeChannelFragment absHomeChannelFragment) {
        this.n = absHomeChannelFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.newvideo.AbsHomeChannelFragment.e(this.n, (com.moji.mjweather.feed.newvideo.model.HomeFeedVideoPraiseData) obj);
    }
}
