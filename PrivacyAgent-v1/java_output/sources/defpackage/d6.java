package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class d6 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.common.data.AdCommon n;
    public final /* synthetic */ com.moji.mjad.common.view.creater.feed.AdStyleFeedDetailVideoMoJiCreater t;
    public final /* synthetic */ com.moji.mjad.view.AdTouchLayerView u;

    public /* synthetic */ d6(com.moji.mjad.common.data.AdCommon adCommon, com.moji.mjad.common.view.creater.feed.AdStyleFeedDetailVideoMoJiCreater adStyleFeedDetailVideoMoJiCreater, com.moji.mjad.view.AdTouchLayerView adTouchLayerView) {
        this.n = adCommon;
        this.t = adStyleFeedDetailVideoMoJiCreater;
        this.u = adTouchLayerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.common.view.creater.feed.AdStyleFeedDetailVideoMoJiCreater.w(this.n, this.t, this.u);
    }
}
