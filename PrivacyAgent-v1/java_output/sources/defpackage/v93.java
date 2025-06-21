package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class v93 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.video.VideoListActivity n;

    public /* synthetic */ v93(com.moji.mjweather.feed.video.VideoListActivity videoListActivity) {
        this.n = videoListActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.video.VideoListActivity.b(this.n, (com.moji.mjweather.feed.video.viewmodel.VideoListViewModel.VideoListData) obj);
    }
}
