package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class in0 implements com.moji.mjad.monitor.listener.ValidViewShownListener {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.model.HomeVideoFeed a;

    public /* synthetic */ in0(com.moji.mjweather.feed.newvideo.model.HomeVideoFeed homeVideoFeed) {
        this.a = homeVideoFeed;
    }

    public final void onInventoryShow() {
        com.moji.mjweather.feed.newvideo.adapter.HomeChannelAdapter.c(this.a);
    }
}
