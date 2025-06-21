package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class hn0 implements com.moji.mjad.monitor.listener.ValidViewShownListener {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.model.HomeVideoFeed a;

    public /* synthetic */ hn0(com.moji.mjweather.feed.newvideo.model.HomeVideoFeed homeVideoFeed) {
        this.a = homeVideoFeed;
    }

    public final void onInventoryShow() {
        com.moji.mjweather.feed.newvideo.adapter.HomeChannelAdapter.a(this.a);
    }
}
