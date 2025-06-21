package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class b1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.AbsHomeChannelFragment n;

    public /* synthetic */ b1(com.moji.mjweather.feed.newvideo.AbsHomeChannelFragment absHomeChannelFragment) {
        this.n = absHomeChannelFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.newvideo.AbsHomeChannelFragment.d(this.n, (com.moji.mjweather.feed.newvideo.model.HomeFeedChannelData) obj);
    }
}
