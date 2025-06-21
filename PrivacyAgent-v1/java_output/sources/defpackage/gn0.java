package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class gn0 implements com.moji.mjad.view.ViewShownListener {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.model.HomeVideoFeed a;

    public /* synthetic */ gn0(com.moji.mjweather.feed.newvideo.model.HomeVideoFeed homeVideoFeed) {
        this.a = homeVideoFeed;
    }

    public final void onShow() {
        com.moji.mjweather.feed.newvideo.adapter.HomeChannelAdapter.d(this.a);
    }
}
