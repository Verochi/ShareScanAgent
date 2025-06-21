package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class jn0 implements com.moji.mjad.view.ViewShownListener {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.model.HomeVideoFeed a;

    public /* synthetic */ jn0(com.moji.mjweather.feed.newvideo.model.HomeVideoFeed homeVideoFeed) {
        this.a = homeVideoFeed;
    }

    public final void onShow() {
        com.moji.mjweather.feed.newvideo.adapter.HomeChannelAdapter.b(this.a);
    }
}
